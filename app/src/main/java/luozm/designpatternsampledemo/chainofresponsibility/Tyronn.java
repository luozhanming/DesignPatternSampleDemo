package luozm.designpatternsampledemo.chainofresponsibility;

/**
 * Created by cdc4512 on 2018/2/6.
 */

public class Tyronn extends PanLoader {
    public Tyronn(int responsiblity) {
        super(responsiblity);
    }

    @Override
    public String getName() {
        return "Tyronn";
    }


}
