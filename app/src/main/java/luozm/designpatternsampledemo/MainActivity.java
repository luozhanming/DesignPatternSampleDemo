package luozm.designpatternsampledemo;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void factory(View view) {
        SampleActivity.start(this, SampleActivity.FACTORY,((Button)view).getText().toString());
    }

    public void abstractFactory(View view) {
        SampleActivity.start(this, SampleActivity.ABSTRACT_FACTORY,((Button)view).getText().toString());
    }

    public void adapter(View view){
        SampleActivity.start(this, SampleActivity.ADAPTER,((Button)view).getText().toString());
    }

    public void bridge(View view){
        SampleActivity.start(this, SampleActivity.BRIDGE,((Button)view).getText().toString());
    }

    public void filter(View view){
        SampleActivity.start(this, SampleActivity.FILTER,((Button)view).getText().toString());
    }

    public void composite(View view){
        SampleActivity.start(this, SampleActivity.COMPOSITE,((Button)view).getText().toString());
    }

    public void decoration(View view){
        SampleActivity.start(this, SampleActivity.DECORATION,((Button)view).getText().toString());
    }

    public void responsiblity(View view){
        SampleActivity.start(this, SampleActivity.CHAIN_OF_RESPONSIBILITY,((Button)view).getText().toString());
    }
}
