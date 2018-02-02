package luozm.designpatternsampledemo.filter;

/**
 * Created by cdc4512 on 2018/2/2.
 */

public class MonsterCard implements Card {

    private String name;

    private int attack;
    private int defence;

    public MonsterCard(String name, int attack, int defence) {
        this.name = name;
        this.attack = attack;
        this.defence = defence;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }
}
