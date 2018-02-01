package luozm.designpatternsampledemo.adapter;

/**
 * Created by cdc4512 on 2018/2/1.
 */

public class ApplianceAdapter implements GeneralAppliance {

    private Appliance appliance;
    private int type;

    /**
     * 美国电器的适配器还是中国电器的适配器
     */
    public ApplianceAdapter(Appliance appliance, int type) {
        this.appliance = appliance;
        this.type = type;
    }

    @Override
    public String use() {
        if (appliance instanceof AmericanAppliance) {
            return appliance.use110V() + ",但经过" + type + "V适配器可以接入"+type+"V电";
        } else if (appliance instanceof ChineseAppliance) {
            return appliance.use220V() + ",但经过" + type + "V适配器可以接入"+type+"V电";
        } else
            return null;
    }
}
