package luozm.designpatternsampledemo.bridge;

/**
 * Created by cdc4512 on 2018/2/2.
 */

public class BlindBuddhist extends Hero {
    public BlindBuddhist(Skill skill) {
        super(skill);
    }

    @Override
    public String launchSkill() {
        return "盲僧" + mSkill.launch(this);
    }

    @Override
    public int getAttack() {
        return 320;
    }

    @Override
    public int getMagic() {
        return 0;
    }
}
