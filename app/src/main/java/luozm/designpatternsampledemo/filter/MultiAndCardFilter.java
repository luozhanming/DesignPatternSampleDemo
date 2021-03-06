package luozm.designpatternsampledemo.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdc4512 on 2018/2/2.
 */

public class MultiAndCardFilter implements CardFilter {

    private List<CardFilter> filters;

    public MultiAndCardFilter(CardFilter...filters){
        this.filters = new ArrayList();
        for (CardFilter filter : filters) {
            this.filters.add(filter);
        }
    }

    @Override
    public List<Card> filter(List<Card> cards) {
        List<Card> temp = new ArrayList<>();
        temp.addAll(cards);
        for (CardFilter filter : filters) {
            temp = filter.filter(temp);

        }
        return temp;
    }
}
