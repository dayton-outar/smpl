package tests.expressions;

import static org.junit.Assert.assertEquals;

import java.util.Hashtable;
import java.util.Vector;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import smpl.sys.expressions.CombinedStringExpression;
import smpl.sys.expressions.DoubleExpression;
import smpl.sys.expressions.ExponentExpression;
import smpl.sys.expressions.IExpression;
import smpl.sys.expressions.LongExpression;
import smpl.sys.expressions.MultiplicationExpression;
import smpl.sys.expressions.StringExpression;
import smpl.sys.values.IValue;

public class StringsTest {
    
    private CombinedStringExpression _string;
    private Hashtable<String, IValue> _dictionary;
    
    @BeforeAll
    public void setUp() throws Exception { //---> Arrange
        System.out.println("Initializing dictionary");

        _dictionary = new Hashtable<>();
    }

    @Test
    @DisplayName("Welcome to SMPL!")
    public void testBasicString() throws Exception {
        // Arrange
        Vector<IExpression> wlcm = new Vector<>();
        wlcm.add(new StringExpression("Welcome to SMPL!"));
        _string = new CombinedStringExpression(wlcm);

        //---> Act ---> Assert
        assertEquals("Welcome to SMPL!", _string.evaluate(_dictionary).toString());
    }

    @Test
    @DisplayName("Injecting πr²")
    public void testInterpolatedString() throws Exception {
        // Arrange
        Vector<IExpression> wlcm = new Vector<>();
        wlcm.add(new StringExpression("Area of circle with radius 3 is "));
        wlcm.add(new MultiplicationExpression(
            new DoubleExpression(3.14159), 
            new ExponentExpression(
                new LongExpression(3l), 
                new LongExpression(2l)
                )
            ));
        wlcm.add(new StringExpression("."));
        _string = new CombinedStringExpression(wlcm);

        //---> Act ---> Assert
        assertEquals("Area of circle with radius 3 is 28.27431.", _string.evaluate(_dictionary).toString());
    }
}
