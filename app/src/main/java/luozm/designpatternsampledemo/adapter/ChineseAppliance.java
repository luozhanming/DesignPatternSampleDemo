package luozm.designpatternsampledemo.adapter;

/**
 * Created by cdc4512 on 2018/2/1.
 */

public class ChineseAppliance implements Appliance {

    @Override
    public String use110V() {
        return null;
    }

    @Override
    public String use220V() {
        return "中国电器用220V电";
    }
}
