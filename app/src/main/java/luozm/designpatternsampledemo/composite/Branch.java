package luozm.designpatternsampledemo.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdc4512 on 2018/2/5.
 */

public class Branch extends Component {

    private List<Component> subComponent = new ArrayList<>();

    public Branch(String id) {
        super(id);
    }

    public void add(Component component) {
        subComponent.add(component);
    }

    public void remove(Component component) {
        subComponent.remove(component);
    }

    public List<Component> getAllSubComponent() {
        List<Component> result = new ArrayList<>();
        for (Component component : subComponent) {
            result.add(component);
            if(component instanceof Branch){
                Branch branch = (Branch) component;
                result.addAll(branch.getAllSubComponent());
            }

        }
        return result;
    }

    public List<Component> getSubComponent(){
        return this.subComponent;
    }

    @Override
    public String toString() {
        return getId();
    }
}
