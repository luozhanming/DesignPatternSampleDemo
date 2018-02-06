package luozm.designpatternsampledemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import luozm.designpatternsampledemo.abstractfactory.AbstractFactory;
import luozm.designpatternsampledemo.abstractfactory.Attack;
import luozm.designpatternsampledemo.abstractfactory.Defence;
import luozm.designpatternsampledemo.abstractfactory.MonsterFactory;
import luozm.designpatternsampledemo.adapter.AmericanAppliance;
import luozm.designpatternsampledemo.adapter.Appliance;
import luozm.designpatternsampledemo.adapter.ApplianceAdapter;
import luozm.designpatternsampledemo.adapter.ChineseAppliance;
import luozm.designpatternsampledemo.adapter.GeneralAppliance;
import luozm.designpatternsampledemo.bridge.BlindBuddhist;
import luozm.designpatternsampledemo.bridge.Cure;
import luozm.designpatternsampledemo.bridge.DragonTail;
import luozm.designpatternsampledemo.bridge.Hero;
import luozm.designpatternsampledemo.bridge.WetNurse;
import luozm.designpatternsampledemo.chainofresponsibility.James;
import luozm.designpatternsampledemo.chainofresponsibility.PanLoader;
import luozm.designpatternsampledemo.chainofresponsibility.Thomas;
import luozm.designpatternsampledemo.chainofresponsibility.Tyronn;
import luozm.designpatternsampledemo.composite.Branch;
import luozm.designpatternsampledemo.composite.Component;
import luozm.designpatternsampledemo.composite.Leaf;
import luozm.designpatternsampledemo.decoration.ExAttack;
import luozm.designpatternsampledemo.decoration.IHero;
import luozm.designpatternsampledemo.decoration.ThunderAttack;
import luozm.designpatternsampledemo.decoration.ZhaoYun;
import luozm.designpatternsampledemo.factory.Fighter;
import luozm.designpatternsampledemo.factory.FighterFactory;
import luozm.designpatternsampledemo.filter.Card;
import luozm.designpatternsampledemo.filter.CardFilter;
import luozm.designpatternsampledemo.filter.MagicCarTypeFilter;
import luozm.designpatternsampledemo.filter.MagicCard;
import luozm.designpatternsampledemo.filter.MagicCardFilter;
import luozm.designpatternsampledemo.filter.MonsterCard;
import luozm.designpatternsampledemo.filter.MonsterCardAttributesFilter;
import luozm.designpatternsampledemo.filter.MonsterCardFilter;
import luozm.designpatternsampledemo.filter.MultiAndCardFilter;
import luozm.designpatternsampledemo.filter.MultiOrCardFilter;

public class SampleActivity extends AppCompatActivity {

    public static final int FACTORY = 1;
    public static final int ABSTRACT_FACTORY = 2;
    public static final int ADAPTER = 3;
    public static final int BRIDGE = 4;
    public static final int FILTER = 5;
    public static final int COMPOSITE = 6;
    public static final int DECORATION = 7;
    public static final int CHAIN_OF_RESPONSIBILITY = 8;

    @IntDef({FACTORY, ABSTRACT_FACTORY, ADAPTER, BRIDGE, FILTER, COMPOSITE, DECORATION,CHAIN_OF_RESPONSIBILITY})
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
        ((TextView) findViewById(R.id.title)).setText(getIntent().getStringExtra("name"));
    }

    public static void start(Context ctx, @Pattern int pattern, String name) {
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
            case ADAPTER:
                showAdapterPower();
                break;
            case BRIDGE:
                showBridgePower();
                break;
            case FILTER:
                showFilterPower();
                break;
            case COMPOSITE:
                showCompositePower();
                break;
            case DECORATION:
                showDecorationPower();
                break;
            case CHAIN_OF_RESPONSIBILITY:
                showChainOfResponsiblityPower();
                break;
        }
    }

    private void showChainOfResponsiblityPower() {
        PanLoader tyronn = new Tyronn(PanLoader.COACH);
        PanLoader james = new James(PanLoader.SCORE);
        PanLoader thomas = new Thomas(PanLoader.DEFENSE);

        tyronn.setNextPanLoader(james);
        james.setNextPanLoader(thomas);

        logger.append("执教不力\n");
        logger.append(tyronn.findRealPanLoader(PanLoader.COACH)+"\n");
        logger.append("得分划水\n");
        logger.append(tyronn.findRealPanLoader(PanLoader.SCORE)+"\n");
        logger.append("防守黑洞\n");
        logger.append(tyronn.findRealPanLoader(PanLoader.DEFENSE)+"\n");
        logger.append("对手太强\n");
        logger.append(tyronn.findRealPanLoader(-1)+"\n");



    }

    /**
     * 装饰器模式
     * 场景：模拟三国无双赵云普通攻击，Ex普通攻击,雷属性Ex普通攻击
     */
    private void showDecorationPower() {
        IHero zhaoyun = new ZhaoYun();
        logger.append(zhaoyun.attack()+"\n");
        zhaoyun = new ExAttack(zhaoyun);
        logger.append(zhaoyun.attack()+"\n");
        zhaoyun = new ThunderAttack(zhaoyun);
        logger.append(zhaoyun.attack()+"\n");
    }

    /**
     * 合成模式
     * 场景：阿里巴巴集团的公司结构
     */
    private void showCompositePower() {
        Branch compony = new Branch("阿里巴巴");
        Branch compony1 = new Branch("蚂蚁金服");
        Branch compony2 = new Branch("淘宝");
        Branch compony3 = new Branch("天猫");
        compony.add(compony1);
        compony.add(compony2);
        compony2.add(compony3);
        Leaf leaf = new Leaf("支付宝");
        Leaf leaf1 = new Leaf("蚂蚁借呗");
        Leaf leaf3 = new Leaf("大疆无人机旗舰店");
        compony1.add(leaf);
        compony1.add(leaf1);
        compony3.add(leaf3);
        List<Component> all = compony.getAllSubComponent();
        logger.append("阿里巴巴的下线公司有:\n");
        logger.append(all.toString() + "\n");
        logger.append("蚂蚁金服的下线公司有:\n");
        logger.append(compony1.getAllSubComponent().toString() + "\n");
        logger.append("淘宝的下线公司有:\n");
        logger.append(compony2.getAllSubComponent().toString() + "\n");
        logger.append("天猫的下线公司有:\n");
        logger.append(compony3.getAllSubComponent().toString() + "\n");

    }

    /**
     * 过滤器模式
     * 场景：通过不同过滤器类可以筛选不同条件的卡片
     */
    private void showFilterPower() {
        List<Card> cards = new ArrayList<>();
        cards.add(new MonsterCard("青眼白龙", 3000, 2500));
        cards.add(new MonsterCard("黑魔导士", 2500, 2000));
        cards.add(new MonsterCard("妖精剑士", 1400, 1000));
        cards.add(new MonsterCard("时间魔术师", 500, 300));
        cards.add(new MagicCard("神奇羽毛扫", MagicCard.TYPE_NORMAL));
        cards.add(new MagicCard("神圣加隆炮", MagicCard.TYPE_SUSTAINABILITY));
        StringBuffer sb = new StringBuffer();
        logger.append("原卡片集合:\n");
        for (Card card : cards) {
            logger.append(card.getName() + "-");
        }
        logger.append("\n经过怪兽卡过滤器后:\n");
        CardFilter filter1 = new MonsterCardFilter();
        List<Card> result1 = filter1.filter(cards);
        for (Card card : result1) {
            logger.append(card.getName() + "-");
        }
        logger.append("\n经过魔法卡过滤器后:\n");
        CardFilter filter2 = new MagicCardFilter();
        List<Card> result2 = filter2.filter(cards);
        for (Card card : result2) {
            logger.append(card.getName() + "-");
        }
        logger.append("\n经过普通魔法卡过滤器过滤后:\n");
        CardFilter filter3 = new MultiAndCardFilter(filter2, new MagicCarTypeFilter(MagicCard.TYPE_NORMAL));
        List<Card> result3 = filter3.filter(cards);
        for (Card card : result3) {
            logger.append(card.getName() + "-");
        }
        logger.append("\n经过怪兽卡属性或过滤器过滤后:\n");
        CardFilter filter4 = new MultiOrCardFilter(new MonsterCardAttributesFilter(3000, 4000, 0, 2500)
                , new MonsterCardAttributesFilter(0, 600, 0, 600));
        List<Card> result4 = filter4.filter(cards);
        for (Card card : result4) {
            logger.append(card.getName() + "-");
        }
    }

    /**
     * 桥接模式<br>
     * 场景：抽象类是英雄，实现类是技能，英雄可以随意装备技能。技能可以扩展。不同英雄对技能的使用有不同效果
     */
    private void showBridgePower() {
        Hero blindDragonBuddhist = new BlindBuddhist(new DragonTail());
        logger.append(blindDragonBuddhist.launchSkill() + "\n");
        Hero wetDragonNurse = new WetNurse(new DragonTail());
        logger.append(wetDragonNurse.launchSkill() + "\n");
        Hero blindCureBuddhist = new BlindBuddhist(new Cure());
        logger.append(blindCureBuddhist.launchSkill() + "\n");
        Hero wetCureNurse = new WetNurse(new Cure());
        logger.append(wetCureNurse.launchSkill() + "\n");
    }


    /**
     * 适配器模式<br>
     * 场景:美国电器用110V电，中国电器用220V电，做一个适配器，使得美国电器可以用220V电，中国电器用110V电
     */
    private void showAdapterPower() {
        //美国电器用220V电
        Appliance aappliance = new AmericanAppliance();
        String s3 = aappliance.use110V();
        logger.append(s3 + "\n");
        GeneralAppliance _220V = new ApplianceAdapter(aappliance, 220);
        String s1 = _220V.use();
        logger.append(s1 + "\n");
        //中国电器用110V电
        Appliance aappliance1 = new ChineseAppliance();
        String s4 = aappliance1.use220V();
        logger.append(s4 + "\n");
        GeneralAppliance _110 = new ApplianceAdapter(aappliance1, 110);
        String s2 = _110.use();
        logger.append(s2 + "\n");
    }

    /**
     * 场景:模拟抽象工厂模式。有两个工厂：怪兽工厂和战士工厂，两个工厂均可生产攻击和防御型。
     */
    private void showAbstractFactoryPower() {
        AbstractFactory fighterFactory = new luozm.designpatternsampledemo.abstractfactory.FighterFactory();
        Attack attack1 = fighterFactory.produceAttack();
        Defence defence1 = fighterFactory.produceDefence();
        logger.append(attack1.attack() + "\n");
        logger.append(defence1.defend() + "\n");
        MonsterFactory monsterFactory = new MonsterFactory();
        Attack attack2 = monsterFactory.produceAttack();
        Defence defence2 = monsterFactory.produceDefence();
        logger.append(attack2.attack() + "\n");
        logger.append(defence2.defend() + "\n");
    }

    /**
     * 模拟的是工厂生成战士的例子，随机生成不同类型战士，不同战士要不同生产时间，生产完成后战士开始行动。
     */
    private void showFactoryPower() {
        Observable.create(new ObservableOnSubscribe<Fighter>() {
            @Override
            public void subscribe(ObservableEmitter<Fighter> e) throws Exception {
                FighterFactory factory = new FighterFactory();
                for (int i = 0; i < 4; i++) {
                    e.onNext(factory.getFighter(FighterFactory.TYPE_RANDOM));
                }
            }
        })
                .flatMap(new Function<Fighter, ObservableSource<Fighter>>() {
                    @Override
                    public ObservableSource<Fighter> apply(Fighter fighter) throws Exception {
                        logger.append(fighter.getName() + "开始生产\n");
                        return Observable.just(fighter).delay(fighter.generationTime(), TimeUnit.MILLISECONDS);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Fighter>() {
                    @Override
                    public void accept(Fighter fighter) throws Exception {
                        logger.append(fighter.fight() + "\n");
                        logger.append(fighter.sleep() + "\n");
                    }
                });
    }

    public void back(View view) {
        finish();
    }


}
