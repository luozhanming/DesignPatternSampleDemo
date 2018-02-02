package luozm.designpatternsampledemo.bridge;

/**
 * Created by cdc4512 on 2018/2/2.
 */

public class DragonTail implements Skill {

    @Override
    public String launch(Hero hero) {
        return "发动神龙摆尾，对敌人造成" + (hero.getAttack() * 0.6 + 600) + "伤害!!!";
    }
}
