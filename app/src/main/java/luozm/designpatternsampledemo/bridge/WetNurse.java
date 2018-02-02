package luozm.designpatternsampledemo.bridge;

/**
 * Created by cdc4512 on 2018/2/2.
 */

public class WetNurse extends Hero {
    public WetNurse(Skill skill) {
        super(skill);
    }

    @Override
    public String launchSkill() {
        return "奶妈" + mSkill.launch(this);
    }

    @Override
    public int getAttack() {
        return 100;
    }

    @Override
    public int getMagic() {
        return 600;
    }
}
