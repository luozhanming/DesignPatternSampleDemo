package luozm.designpatternsampledemo.decoration;

/**
 * Created by cdc4512 on 2018/2/6.
 */

public class ExAttack extends HeroDecoration {
    public ExAttack(IHero hero) {
        super(hero);
    }

    @Override
    public String getName() {
        return "Ex攻击!!";
    }

    @Override
    public String attack() {
        return hero.attack()+"带Ex强击!!";
    }
}
