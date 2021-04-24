import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import smpl.sys.expressions.AdditionExpression;
import smpl.sys.expressions.LongExpression;
import smpl.sys.values.IValue;

public class TestAddition {

    private AdditionExpression _addition;
    private Hashtable<String, IValue> _dictionary;

    @BeforeEach
    public void setUp() throws Exception {
        _addition = new AdditionExpression(
            new LongExpression(9l),
            new LongExpression(22l)
        );
    }

    @Test
    @DisplayName("Adding 9 to 22")
    public void testAddition() throws Exception {
        assertEquals(31l, _addition.evaluate(_dictionary).longValue(), "Adding 9 to 22 should be equal to 31");
    }
}