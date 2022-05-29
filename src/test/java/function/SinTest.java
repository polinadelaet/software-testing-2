package function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Sin(х) Test")
class SinTest {
    private Sin sin;

    @BeforeEach
    void init() {
        sin = new Sin();
    }

    @Test
    void sinPositiveInfTest() {
        assertEquals(Math.sin(Double.POSITIVE_INFINITY), sin.sin(Double.POSITIVE_INFINITY, 0.1), 0.1);
    }

    @Test
    void sinNegativeInfTest() {
        assertEquals(Math.sin(Double.NEGATIVE_INFINITY), sin.sin(Double.NEGATIVE_INFINITY, 0.1), 0.1);
    }

    @Test
    void sinNanTest() {
        assertEquals(Math.sin(Double.NaN), sin.sin(Double.NaN, 0.1), 0.1);
    }


    @ParameterizedTest(name = "Test {index}: sin({0}) with e = {1}")
    @CsvSource({
            "-3.16, 0.1",
            "-" + Math.PI + ", 0.1",
            "-1.6, 0.1",
            "-" + Math.PI / 2 + ", 0.1",
            "-" + Math.PI / 6 + ", 0.1",
            "0, 0.01",
            Math.PI / 6 + ", 0.1",
            Math.PI / 2 + ", 0.1",
            "1.6, 0.1",
            Math.PI + ", 0.1",
            "9, 0.1"
    })
    void getSinTest(double x, double e) {
        assertEquals(Math.sin(x), sin.sin(x, e), 0.1);
    }

}