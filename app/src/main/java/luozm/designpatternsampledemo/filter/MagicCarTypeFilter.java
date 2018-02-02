package luozm.designpatternsampledemo.filter;

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
        for (Card card : cards) {
            if(card instanceof MagicCard){
                MagicCard temp = (MagicCard) card;
                if(temp.getType()!=type){
                    cards.remove(card);
                }
            }else{
                cards.remove(card);
            }
        }
        return cards;
    }
}
