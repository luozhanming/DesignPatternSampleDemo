package luozm.designpatternsampledemo.bridge;

/**
 * Created by cdc4512 on 2018/2/2.
 */

public class Cure implements Skill {

    @Override
    public String launch(Hero hero) {
        return "发动治疗，对队友治疗" + (hero.getMagic() * 0.4 + 300) + "HP!!!";
    }
}
