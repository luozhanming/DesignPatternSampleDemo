package luozm.designpatternsampledemo.abstractfactory;

/**
 * Created by cdc4512 on 2018/2/1.
 */

public class FighterFactory implements AbstractFactory {
    @Override
    public Attack produceAttack() {
        return new AttackFighter();
    }

    @Override
    public Defence produceDefence() {
        return new DefenseFighter();
    }
}
