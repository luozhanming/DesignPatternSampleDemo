package luozm.designpatternsampledemo.composite;

/**
 * Created by cdc4512 on 2018/2/5.
 */

public class Leaf extends Component {


    public Leaf(String id) {
        super(id);
    }

    @Override
    public String toString() {
        return getId();
    }
}
