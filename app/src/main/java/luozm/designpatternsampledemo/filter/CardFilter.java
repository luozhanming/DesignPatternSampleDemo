package luozm.designpatternsampledemo.filter;

import java.util.List;

/**
 * Created by cdc4512 on 2018/2/2.
 */

public interface CardFilter {

    List<Card> filter(List<Card> card);
}
