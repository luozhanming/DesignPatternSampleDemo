package luozm.designpatternsampledemo.bridge;

/**
 * Created by cdc4512 on 2018/2/2.
 */

public abstract class Hero {
    protected Skill mSkill;


    public Hero(Skill skill) {
        this.mSkill = skill;
    }

    public abstract String launchSkill();

    public abstract int getAttack();

    public abstract int getMagic();
}
