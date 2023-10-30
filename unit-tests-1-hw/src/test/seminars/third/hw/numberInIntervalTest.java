package test.seminars.third.hw;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seminars.third.hw.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class numberInIntervalTest {

    static MainHW mainHW;
    @BeforeAll
    static void setUP() {
        mainHW = new MainHW();
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 33, 75, 99})
    void checkNumberInIntervalPositive(int input) {
        assertTrue(mainHW.numberInInterval(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 5, 999, 100})
    void checkNumberInIntervalNegative(int input) {
        assertFalse(mainHW.numberInInterval(input));
    }

}
