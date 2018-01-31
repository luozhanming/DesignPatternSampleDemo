package luozm.designpatternsampledemo.factory;

/**
 * Created by cdc4512 on 2018/1/31.
 */

public class BlueFighter implements Fighter {
    @Override
    public String getName() {
        return "蓝战士";
    }

    @Override
    public String fight() {
        return "蓝战士打架......";
    }

    @Override
    public String sleep() {
        return "蓝战士睡觉......";
    }

    @Override
    public long generationTime() {
        return 3000;
    }
}
