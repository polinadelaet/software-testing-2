package function.system;

import function.Cos;
import function.Ln;
import function.Log;
import function.Sin;
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
@DisplayName("SystemFunctions Test")
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class SystemFunctionsTest {


    @Mock
    private TrigonometricFunction trigonometricFunction;
    @Mock
    private LogFunction logFunction;
    @InjectMocks
    private SystemFunctions systemFunctions;

    @BeforeEach
    void init() {
        when(trigonometricFunction.calculate(-9.0, 0.00001)).thenReturn(-0.9111302619);
        when(trigonometricFunction.calculate(-Math.PI/2, 0.00001)).thenReturn(0.0);
        when(trigonometricFunction.calculate(0, 0.00001)).thenReturn(1.0);

        when(logFunction.calculate(1.5, 0.00001)).thenReturn(0.0115524);
        when(logFunction.calculate(0.25, 0.00001)).thenReturn(-22.1117535);
    }

    @ParameterizedTest(name = "Test {index}: x = {0}, e = {1}")
    @CsvSource({
            "-9, 0.00001",
            "-" + Math.PI / 2 + ", 0.00001",
            "0, 0.00001",
            "0.25, 0.00001",
            "1.5, 0.00001"
    })
    void calculate(double x, double e) {
        double res;
        if (x <= 0) {
            res = Math.cos(x);
        } else {
            res = (((((Math.log(x) * Math.log(x)) * Math.log(x)/Math.log(2)) + (Math.log(x)/Math.log(5) * Math.log(x)/Math.log(10))) * (((Math.log(x) * Math.log(x)) * Math.log(x)/Math.log(2)) + (Math.log(x)/Math.log(5) * Math.log(x)/Math.log(10)))) * Math.log(x)/Math.log(2));
        }
        assertEquals(systemFunctions.calculate(x, e), res, 0.0001);

    }


}