package luozm.designpatternsampledemo.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdc4512 on 2018/2/2.
 */

public class MagicCarTypeFilter implements CardFilter {

    private int type;

    public MagicCarTypeFilter(@MagicCard.Type int type){
        this.type = type;
    }


    @Override
    public List<Card> filter(List<Card> cards) {
        List<Card> result = new ArrayList<>();
        result.addAll(cards);
        for (int i=0,size=cards.size();i<size;i++) {
            Card card = cards.get(i);
            if(card instanceof MagicCard){
                MagicCard temp = (MagicCard) card;
                if(temp.getType()!=type){
                    result.remove(card);
                }
            }else{
                result.remove(card);
            }
        }
        return result;
    }
}
