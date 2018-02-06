package luozm.designpatternsampledemo.decoration;

/**
 * Created by cdc4512 on 2018/2/6.
 */

public class ThunderAttack extends HeroDecoration {
    public ThunderAttack(IHero hero) {
        super(hero);
    }

    @Override
    public String getName() {
        return "雷属性攻击";
    }

    @Override
    public String attack() {
        return hero.attack()+"带雷属性!!!";
    }
}
