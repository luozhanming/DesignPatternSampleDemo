package luozm.designpatternsampledemo.abstractfactory;

/**
 * Created by cdc4512 on 2018/2/1.
 */

public class AttackMonster implements Attack {
    @Override
    public String getName() {
        return "AttackMonster";
    }

    @Override
    public String attack() {
        return getName()+"attack!!!";
    }
}
