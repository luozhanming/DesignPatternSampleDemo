package luozm.designpatternsampledemo.filter;

import java.util.List;

/**
 * Created by cdc4512 on 2018/2/2.
 */

public class MonsterCardAttributesFilter implements CardFilter {

    private int[] attributes;


    public MonsterCardAttributesFilter(int minAttack, int maxAttack, int minDefense, int maxDefense) {
        attributes = new int[]{minAttack, maxAttack, minDefense, maxDefense};
    }

    @Override
    public List<Card> filter(List<Card> cards) {
        int minAttack = attributes[0];
        int maxAttack = attributes[1];
        int minDefense = attributes[2];
        int maxDefense = attributes[3];
        for (Card card : cards) {
            if (card instanceof MonsterCard) {
                MonsterCard temp = (MonsterCard) card;
                if (temp.getAttack() < minAttack || temp.getAttack() > maxAttack || temp.getDefence() < minDefense || temp.getDefence() > maxDefense) {
                    cards.remove(card);
                }
            } else {
                cards.remove(cards);
            }
        }
        return cards;
    }
}
