package function.system;

import function.Ln;
import function.Log;
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
@DisplayName("LogFunctionTest")
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class LogFunctionTest {

    @Mock
    private Ln ln;
    @Mock
    private Log log;

    @InjectMocks
    private LogFunction logFunction;


    @BeforeEach
    void init() {
        when(ln.ln(10, 0.000001)).thenReturn(2.302585092994);
        when(log.log(10, 2, 0.000001)).thenReturn(3.3219280);
        when(log.log(10, 5, 0.000001)).thenReturn(1.4306765);
        when(log.log(10, 10, 0.000001)).thenReturn(1.0);

        when(ln.ln(4.81, 0.000001)).thenReturn(1.5706970841177);
        when(log.log(4.81, 2, 0.000001)).thenReturn(2.26603689);
        when(log.log(4.81, 5, 0.000001)).thenReturn(0.9759289);
        when(log.log(4.81, 10, 0.000001)).thenReturn(0.682145076);

        when(ln.ln(0, 0.00001)).thenReturn(-Double.NEGATIVE_INFINITY);
        when(log.log(0, 2, 0.000001)).thenReturn(Double.NaN);
        when(log.log(0, 5, 0.000001)).thenReturn(Double.NaN);
        when(log.log(0, 10, 0.000001)).thenReturn(Double.NaN);

        when(ln.ln(1.5, 0.00001)).thenReturn(0.40546510810816);
        when(log.log(1.5, 2, 0.000001)).thenReturn(0.58496250);
        when(log.log(1.5, 5, 0.000001)).thenReturn(0.251929636);
        when(log.log(1.5, 10, 0.000001)).thenReturn(0.1760912590);
    }

    @ParameterizedTest(name = "Test {index}: x = {0} with e = {1}")
    @CsvSource({
            "10, 0.000001",
            "4.81, 0.000001",
            "0, 0.000001",
            "1.5, 0.000001",
    })
    void calculateTest(double x, double e) {
        double res = (((((Math.log(x) * Math.log(x)) * Math.log(x) / Math.log(2))
                + (Math.log(x) / Math.log(5) * Math.log(x) / Math.log(10)))
                * (((Math.log(x) * Math.log(x)) * Math.log(x) / Math.log(2))
                + (Math.log(x) / Math.log(5) * Math.log(x) / Math.log(10))))
                * Math.log(x) / Math.log(2));
        assertEquals(res, logFunction.calculate(x, e), 0.1);
    }
}