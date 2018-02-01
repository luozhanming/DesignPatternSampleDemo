package luozm.designpatternsampledemo.abstractfactory;

/**
 * Created by cdc4512 on 2018/2/1.
 */

public class DefenseMonster implements Defence {
    @Override
    public String getName() {
        return "DefenseMonster";
    }

    @Override
    public String defend() {
        return getName()+"defend!!!";
    }
}
