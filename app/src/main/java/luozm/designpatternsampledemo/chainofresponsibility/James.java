package luozm.designpatternsampledemo.chainofresponsibility;

/**
 * Created by cdc4512 on 2018/2/6.
 */

public class James extends PanLoader {
    public James(int responsiblity) {
        super(responsiblity);
    }

    @Override
    public String getName() {
        return "James";
    }
}
