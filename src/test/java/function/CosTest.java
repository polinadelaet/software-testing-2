package function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DisplayName("Cos(х) Test")
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CosTest {

    @Mock
    private Sin sin;

    @InjectMocks
    private Cos cos;

    @BeforeEach
    void init() {
        when(sin.sin(-3.16, 0.00001)).thenReturn(0.018);
        when(sin.sin(-Math.PI, 0.00001)).thenReturn(0.0);
        when(sin.sin(-1.6, 0.00001)).thenReturn(-0.9995);
        when(sin.sin(- Math.PI / 2, 0.00001)).thenReturn(-1.0);
        when(sin.sin(- Math.PI / 6, 0.00001)).thenReturn(-0.5);
        when(sin.sin(0, 0.00001)).thenReturn(0.0);
        when(sin.sin(Math.PI / 6, 0.00001)).thenReturn(0.5);
        when(sin.sin(Math.PI / 2, 0.00001)).thenReturn(1.0);
        when(sin.sin(1.6, 0.00001)).thenReturn(0.9995);
        when(sin.sin(Math.PI, 0.00001)).thenReturn(0.0);
        when(sin.sin(9, 0.00001)).thenReturn(0.412);
    }


    @Test
    void cosPositiveInfTest() {
        assertEquals(Math.cos(Double.POSITIVE_INFINITY), cos.cos(Double.POSITIVE_INFINITY, 0.1), 0.1);
    }

    @Test
    void cosNegativeInfTest() {
        assertEquals(Math.cos(Double.NEGATIVE_INFINITY), cos.cos(Double.NEGATIVE_INFINITY, 0.1), 0.1);
    }

    @Test
    void cosNanTest() {
        assertEquals(Math.cos(Double.NaN), cos.cos(Double.NaN, 0.1), 0.1);
    }


    @ParameterizedTest(name = "Test {index}: cos({0}) with e = {1}")
    @CsvSource({
            "-3.16, 0.00001",
            "-" + Math.PI + ", 0.00001",
            "-1.6, 0.00001",
            "-" + Math.PI / 2 + ", 0.00001",
            "-" + Math.PI / 6 + ", 0.00001",
            "0, 0.00001",
            Math.PI / 6 + ", 0.00001",
            Math.PI / 2 + ", 0.00001",
            "1.6, 0.00001",
            Math.PI + ", 0.00001",
            "9, 0.00001"
    })
    void getCosTest(double x, double e) {
        assertEquals(Math.cos(x), cos.cos(x, e), 0.1);
    }
}