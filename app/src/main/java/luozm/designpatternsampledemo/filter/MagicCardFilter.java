package luozm.designpatternsampledemo.filter;

import java.util.List;

/**
 * Created by cdc4512 on 2018/2/2.
 */

public class MagicCardFilter implements CardFilter {
    @Override
    public List<Card> filter(List<Card> cards) {
        for (Card card : cards) {
            if(!(card instanceof MagicCard)){
                cards.remove(card);
            }
        }
        return cards;
    }
}
