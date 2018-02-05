package luozm.designpatternsampledemo.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdc4512 on 2018/2/2.
 */

public class MagicCardFilter implements CardFilter {
    @Override
    public List<Card> filter(List<Card> cards) {
        List<Card> result = new ArrayList<>();
        result.addAll(cards);

        for (int i=0,size = cards.size();i<size;i++) {
            Card card = cards.get(i);
            if(!(card instanceof MagicCard)){
                result.remove(card);
            }
        }
        return result;
    }
}
