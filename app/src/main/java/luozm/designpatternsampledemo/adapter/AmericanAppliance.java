package luozm.designpatternsampledemo.adapter;

/**
 * Created by cdc4512 on 2018/2/1.
 */

public class AmericanAppliance implements Appliance {

    @Override
    public String use110V() {
        return "美国电器用110V电";
    }

    @Override
    public String use220V() {
        return null;
    }
}
