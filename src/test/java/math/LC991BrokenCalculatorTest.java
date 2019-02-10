package math;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LC991BrokenCalculatorTest {

    @Test
    public void brokenCalculator() {
        Assert.assertEquals(2, LC991BrokenCalculator.brokenCalculator(2, 3));
        Assert.assertEquals(2, LC991BrokenCalculator.brokenCalculator(5, 8));
        Assert.assertEquals(3, LC991BrokenCalculator.brokenCalculator(3, 10));
        Assert.assertEquals(1023, LC991BrokenCalculator.brokenCalculator(1024, 1));
    }
}