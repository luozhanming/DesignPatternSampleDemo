package luozm.designpatternsampledemo.decoration;

/**
 * Created by cdc4512 on 2018/2/6.
 */

public abstract class HeroDecoration implements IHero {

    protected IHero hero;

    public HeroDecoration(IHero hero){
        this.hero = hero;
    }

}
