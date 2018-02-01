package luozm.designpatternsampledemo.abstractfactory;

/**
 * Created by cdc4512 on 2018/2/1.
 */

public interface AbstractFactory {

     Attack produceAttack();
     Defence produceDefence();
}
