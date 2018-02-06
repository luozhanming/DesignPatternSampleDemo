package luozm.designpatternsampledemo.decoration;

/**
 * Created by cdc4512 on 2018/2/6.
 */

public class ZhaoYun implements IHero {
    @Override
    public String getName() {
        return "赵云";
    }

    @Override
    public String attack() {
        return getName()+"发动普通攻击!!!";
    }
}
