package luozm.designpatternsampledemo.composite;

/**
 * Created by cdc4512 on 2018/2/5.
 */

public abstract class Component {

    private String mId;

    public Component(String id) {
        this.mId = id;
    }

    public String getId(){
        return mId;
    }
}
