package luozm.designpatternsampledemo.filter;

import android.support.annotation.IntDef;

/**
 * Created by cdc4512 on 2018/2/2.
 */

public class MagicCard implements Card {
    public static final int TYPE_NORMAL = 1;  //通常魔法卡
    public static final int TYPE_SUSTAINABILITY = 2; //永续魔法卡

    private String name;
    private int mType;
    private String typeName;

    @Override
    public String getName() {
        return name;
    }

    @IntDef({TYPE_NORMAL, TYPE_SUSTAINABILITY})
    public @interface Type {
    }

    public MagicCard(String name, @Type int type) {
        this.name = name;
        this.mType = type;
    }

    public int getType() {
        return mType;
    }

    public void setType(@Type int type) {
        this.mType = type;
        if (type == TYPE_NORMAL) {
            typeName = "通常魔法";
        }else if(type == TYPE_SUSTAINABILITY){
            typeName = "永续魔法";
        }
    }
}
