package function.system;

import function.Cos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
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

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("TrigonometricFunctionTest")
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class TrigonometricFunctionTest {

    @Mock
    private Cos cos;

    @InjectMocks
    private TrigonometricFunction trigonometricFunction;

    @BeforeEach
    void init() {
        when(cos.cos(-9, 0.00001)).thenReturn(-0.9111302619);
        when(cos.cos(-3.16, 0.00001)).thenReturn(-0.9998305896);
        when(cos.cos(-Math.PI, 0.00001)).thenReturn(-1.0);
        when(cos.cos(-1.6, 0.00001)).thenReturn(-0.0291995223);

        when(cos.cos(-Math.PI/2, 0.00001)).thenReturn(0.0);
        when(cos.cos(-Math.PI/6, 0.00001)).thenReturn(0.8660254038);
        when(cos.cos(0, 0.00001)).thenReturn(1.0);
        when(cos.cos(Math.PI/6, 0.00001)).thenReturn(0.8660254038);
        when(cos.cos(Math.PI/2, 0.00001)).thenReturn(0.0);
        when(cos.cos(1.6, 0.00001)).thenReturn(-0.0291995223);
        when(cos.cos(Math.PI, 0.00001)).thenReturn(-1.0);
        when(cos.cos(9, 0.00001)).thenReturn(-0.9111302619);
    }


    @ParameterizedTest(name = "Test {index}: cos({0}) with e = {1}")
    @CsvSource({
            "-9, 0.00001",
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
    void calculate(double x, double e) {
        assertEquals(Math.cos(x), trigonometricFunction.calculate(x, e), 0.1);
    }
}