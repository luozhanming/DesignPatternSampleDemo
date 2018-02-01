package luozm.designpatternsampledemo.abstractfactory;

/**
 * Created by cdc4512 on 2018/2/1.
 */

public class AttackFighter implements Attack {
    @Override
    public String getName() {
        return "AttackFighter";
    }

    @Override
    public String attack() {
        return getName()+"attack!!!";
    }
}
