package au.com.rainmore;

import java.util.Random;

public abstract class BaseSpec {

    private Random random = new Random();

    protected Random getRandom() {
        return random;
    }
}
