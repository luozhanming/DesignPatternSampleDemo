package luozm.designpatternsampledemo.factory;

/**
 * Created by cdc4512 on 2018/1/31.
 */

public class RedFighter implements Fighter {
    @Override
    public String getName() {
        return "红战士";
    }

    @Override
    public String fight() {
        return getName()+"打架......";
    }

    @Override
    public String sleep() {
        return getName()+"睡觉......";
    }

    @Override
    public long generationTime() {
        return 2000;
    }
}
