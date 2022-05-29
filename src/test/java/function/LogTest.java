package function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Log(х) Test")
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class LogTest {

    @Mock
    private Ln ln;
    @InjectMocks
    private Log log;

    @BeforeEach
    void init() {
        when(ln.ln(Double.POSITIVE_INFINITY, 0.00001)).thenReturn(Double.POSITIVE_INFINITY);
        when(ln.ln(Double.NEGATIVE_INFINITY, 0.00001)).thenReturn(Double.NaN);
        when(ln.ln(0, 0.00001)).thenReturn(Double.NEGATIVE_INFINITY);
        when(ln.ln(1, 0.00001)).thenReturn(Double.valueOf(0));
        when(ln.ln(2, 0.00001)).thenReturn(0.693);
        when(ln.ln(-10, 0.00001)).thenReturn(Double.NaN);
        when(ln.ln(Double.NaN, 0.00001)).thenReturn(Double.NaN);
    }


    @Test
    void logWithPositiveInfXAndPositiveA() {
        assertEquals(Math.log(Double.POSITIVE_INFINITY) / Math.log(2), log.log(Double.POSITIVE_INFINITY, 2, 0.00001));
    }

    @Test
    void logWithNegativeInfXAndPositiveA() {
        assertEquals(Math.log(Double.NEGATIVE_INFINITY) / Math.log(2), log.log(Double.NEGATIVE_INFINITY, 2, 0.00001), 0.1);
    }

    @Test
    void logWithNegativeXAndPositiveA() {
        assertEquals(Math.log(-10) / Math.log(2), log.log(-10, 2, 0.00001), 0.1);
    }

    @Test
    void logWithZeroXAndPositiveA() {
        assertEquals(Double.NaN, log.log(0, 2, 0.00001), 0.1);
    }

    @Test
    void logWithPositiveXAndNegativeA() {
        assertEquals(Double.NaN, log.log(2, -10, 0.00001), 0.1);
    }

    @Test
    void logWithPositiveXAndAEqualsToOne() {
        assertEquals(Double.NaN, log.log(2, 1, 0.001), 0.1);
    }


    @Test
    void logNanXTest() {
        assertEquals(Math.log(2) / Math.log(Double.NaN),
                log.log(Double.NaN, 2, 0.00001), 0.1);
    }

    @Test
    void logNanATest() {
        assertEquals(Math.log(Double.NaN) / Math.log(2),
                log.log(2, Double.NaN, 0.00001), 0.1);
    }

    @Test
    void logWithOneXAndOneA() {
        assertEquals(0, log.log(1, 3, 0.00001), 0.1);
    }
}