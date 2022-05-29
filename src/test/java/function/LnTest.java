package function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Ln(х) Test")
class LnTest {

    private Ln ln;

    @BeforeEach
    void init() {
        ln = new Ln();
    }

    @Test
    void lnNanTest() {
        assertEquals(Math.log(Double.NaN), ln.ln(Double.NaN, 0.00001), 0.1);
    }

    @Test
    void lnPositiveInfTest() {
        assertEquals(Math.log(Double.POSITIVE_INFINITY), ln.ln(Double.POSITIVE_INFINITY, 0.00001), 0.1);
    }

    @Test
    void lnNegativeInfTest() {
        assertEquals(Math.log(Double.NEGATIVE_INFINITY), ln.ln(Double.NEGATIVE_INFINITY, 0.00001), 0.1);
    }

    @ParameterizedTest(name = "Test {index}: ln({0}) with e = {1}")
    @CsvSource({
            "-0.5, 0.0001",
            "0.5, 0.0001",
            "1, 0.0001",
            "10, 0.0001",
    })
    void getLnTest(double x, double e) {
        assertEquals(Math.log(x), ln.ln(x, e), 0.1);
    }

}