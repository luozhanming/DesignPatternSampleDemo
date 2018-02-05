package luozm.designpatternsampledemo.filter;

import java.util.ArrayList;
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
        List<Card> result = new ArrayList<>();
        result.addAll(cards);
        int minAttack = attributes[0];
        int maxAttack = attributes[1];
        int minDefense = attributes[2];
        int maxDefense = attributes[3];
        for (int i=0,size=cards.size();i<size;i++) {
            Card card = cards.get(i);
            if (card instanceof MonsterCard) {
                MonsterCard temp = (MonsterCard) card;
                if (temp.getAttack() < minAttack || temp.getAttack() > maxAttack || temp.getDefence() < minDefense || temp.getDefence() > maxDefense) {
                    result.remove(card);
                }
            } else {
                result.remove(card);
            }
        }
        return result;
    }
}
