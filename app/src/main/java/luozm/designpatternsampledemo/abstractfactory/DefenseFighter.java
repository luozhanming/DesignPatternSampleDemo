package luozm.designpatternsampledemo.abstractfactory;

/**
 * Created by cdc4512 on 2018/2/1.
 */

public class DefenseFighter implements Defence {
    @Override
    public String getName() {
        return "DefenseFighter";
    }

    @Override
    public String defend() {
        return getName()+"defend!!!";
    }
}
