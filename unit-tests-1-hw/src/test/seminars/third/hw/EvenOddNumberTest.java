package test.seminars.third.hw;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seminars.third.hw.*;
import static org.junit.jupiter.api.Assertions.*;
public class EvenOddNumberTest {
    static MainHW mainHW;
    @BeforeAll
    static void setUP() {
        mainHW = new MainHW();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 6, 22, 100})
    void checkEvenOddNumberPositive(int input) {
        assertTrue(mainHW.evenOddNumber(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 21, 101})
    void checkEvenOddNumberNegative(int input) {
        assertFalse(mainHW.evenOddNumber(input));
    }
}
