package luozm.designpatternsampledemo.abstractfactory;

/**
 * Created by cdc4512 on 2018/2/1.
 */

public class MonsterFactory implements AbstractFactory {
    @Override
    public Attack produceAttack() {
        return new AttackMonster();
    }

    @Override
    public Defence produceDefence() {
        return new DefenseMonster();
    }
}
