package luozm.designpatternsampledemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import luozm.designpatternsampledemo.abstractfactory.Attack;
import luozm.designpatternsampledemo.abstractfactory.Defence;
import luozm.designpatternsampledemo.abstractfactory.MonsterFactory;
import luozm.designpatternsampledemo.factory.Fighter;
import luozm.designpatternsampledemo.factory.FighterFactory;

public class SampleActivity extends AppCompatActivity {

    public static final int FACTORY = 1;
    public static final int ABSTRACT_FACTORY = 2;

    @IntDef({FACTORY,ABSTRACT_FACTORY})
    public @interface Pattern {
    }

    TextView logger;

    private int mPattern;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        parseIntent();
        logger = (TextView) findViewById(R.id.logger);
        showPatternPower();
    }

    private void parseIntent() {
        mPattern = getIntent().getIntExtra("pattern", FACTORY);
        ((TextView)findViewById(R.id.title)).setText(getIntent().getStringExtra("name"));
    }

    public static void start(Context ctx, @Pattern int pattern,String name) {
        Intent intent = new Intent(ctx, SampleActivity.class);
        intent.putExtra("pattern", pattern);
        intent.putExtra("name", name);
        ctx.startActivity(intent);
    }

    private void showPatternPower() {
        switch (mPattern) {
            case FACTORY:
                showFactoryPower();
                break;
            case ABSTRACT_FACTORY:
                showAbstractFactoryPower();
                break;
        }
    }

    private void showAbstractFactoryPower() {
        luozm.designpatternsampledemo.abstractfactory.FighterFactory fighterFactory = new luozm.designpatternsampledemo.abstractfactory.FighterFactory();
        Attack attack1 = fighterFactory.produceAttack();
        Defence defence1 = fighterFactory.produceDefence();
        logger.append(attack1.attack()+"\n");
        logger.append(defence1.defend()+"\n");
        MonsterFactory monsterFactory = new MonsterFactory();
        Attack attack2 = monsterFactory.produceAttack();
        Defence defence2 = monsterFactory.produceDefence();
        logger.append(attack2.attack()+"\n");
        logger.append(defence2.defend()+"\n");
    }

    /**
     * 模拟的是工厂生成战士的例子，随机生成不同类型战士，不同战士要不同生产时间，生产完成后战士开始行动。
     *
     * */
    private void showFactoryPower() {
        Observable.create(new ObservableOnSubscribe<Fighter>() {
            @Override
            public void subscribe(ObservableEmitter<Fighter> e) throws Exception {
                FighterFactory factory = new FighterFactory();
                for(int i=0;i<4;i++){
                    e.onNext(factory.getFighter(FighterFactory.TYPE_RANDOM));
                }
            }
        })
                .flatMap(new Function<Fighter, ObservableSource<Fighter>>() {
                    @Override
                    public ObservableSource<Fighter> apply(Fighter fighter) throws Exception {
                        logger.append(fighter.getName()+"开始生产\n");
                        return Observable.just(fighter).delay(fighter.generationTime(), TimeUnit.MILLISECONDS);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Fighter>() {
                    @Override
                    public void accept(Fighter fighter) throws Exception {

                    }
                });
    }

    public void back(View view){
        finish();
    }


}
