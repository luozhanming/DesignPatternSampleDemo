package luozm.designpatternsampledemo.factory;

import android.util.SparseIntArray;

import java.util.Random;

/**
 * Created by cdc4512 on 2018/1/31.
 */

public class FighterFactory {

    public static final int TYPE_RANDOM = 0;
    public static final int TYPE_BLUE = 1;
    public static final int TYPE_RED = 2;

    SparseIntArray factoryLogger = new SparseIntArray();


    public Fighter getFighter(int type) {
        switch (type) {
            case TYPE_BLUE:
                factoryLogger.put(TYPE_BLUE, factoryLogger.get(TYPE_BLUE) + 1);
                return new BlueFighter();
            case TYPE_RED:
                factoryLogger.put(TYPE_RED, factoryLogger.get(TYPE_BLUE) + 1);
                return new RedFighter();
            default:
                Random random = new Random();
                int i = random.nextInt(3);
                return getFighter(i);
        }
    }

 /*   public int getFighterCount(int type) {
        switch (type) {
            case TYPE_BLUE:
                return factoryLogger.get(TYPE_BLUE);
            case TYPE_RED:
                return factoryLogger.get(TYPE_RED);
            default:
                return 0;
        }
    }*/
}
