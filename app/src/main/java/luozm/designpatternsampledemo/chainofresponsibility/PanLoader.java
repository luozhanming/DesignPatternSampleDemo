package luozm.designpatternsampledemo.chainofresponsibility;

/**
 * Created by cdc4512 on 2018/2/6.
 */

public abstract class PanLoader {

    protected PanLoader nextPanLoader;
    protected String name;
    protected int responsiblity;

    public static final int COACH = 1;
    public static final int SCORE = 2;
    public static final int DEFENSE = 3;


    public PanLoader(int responsiblity) {
        this.responsiblity = responsiblity;
    }

    public void setNextPanLoader(PanLoader loader) {
        this.nextPanLoader = loader;
    }

    public abstract String getName();

    public String findRealPanLoader(int responsiblity) {
        if (this.responsiblity == responsiblity) {
            return loadPan();
        } else {
            if (nextPanLoader != null) {
                return throwPan()+nextPanLoader.findRealPanLoader(responsiblity);
            }else{
                return throwPan()+"没人肯背锅!!!";
            }
        }
    }

    private String loadPan(){
        return getName()+"背锅!!!\n";
    }

    private String throwPan(){
        return getName()+"甩锅!!\n";
    }

}
