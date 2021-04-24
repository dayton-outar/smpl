package expressions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import smpl.sys.expressions.AdditionExpression;
import smpl.sys.expressions.LongExpression;
import smpl.sys.expressions.DoubleExpression;
import smpl.sys.values.IValue;

public class TestAddition {

    private AdditionExpression _addition1;
    private AdditionExpression _addition2;
    private Hashtable<String, IValue> _dictionary;
    
    @BeforeEach
    public void setUp() throws Exception { //---> Arrange
        // Add whole numbers (ie. two long data types)
        _addition1 = new AdditionExpression(
            new LongExpression(9l),
            new LongExpression(22l)
        );

        // Add a whole number (i.e. a long data type) and a decimal number (i.e. a double data type)
        _addition2 = new AdditionExpression(
            new LongExpression(Long.valueOf(8l)),
            new DoubleExpression(Double.valueOf(9.5)));
    }

    @Test
    @DisplayName("Adding 9 to 22")
    public void testAdditionWholeNumbers() throws Exception { //---> Act ---> Assert
        assertEquals(31l, _addition1.evaluate(_dictionary).longValue(), "Adding 9 to 22 should be equal to 31");
    }

    @Test
    @DisplayName("Adding 8 to 9.5")
    public void testAdditionWholeAndDecimalNumbers() throws Exception {
        assertEquals(17.5, _addition2.evaluate(_dictionary).doubleValue(), "Adding 8 to 9.5 should be equal to 17.5");
    }
}