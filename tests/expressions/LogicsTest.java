package expressions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Hashtable;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import smpl.sys.commands.AssignmentExpressionCommand;
import smpl.sys.expressions.EqualsExpression;
import smpl.sys.expressions.LongExpression;
import smpl.sys.expressions.VariableExpression;
import smpl.sys.values.IValue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LogicsTest {
    
    private EqualsExpression _equalsLogic;
    private Hashtable<String, IValue> _dictionary;
    
    @BeforeAll
    public void setUp() throws Exception { //---> Arrange
        System.out.println("Initializing dictionary");

        _dictionary = new Hashtable<>();

        AssignmentExpressionCommand aec = new AssignmentExpressionCommand("x", new LongExpression(5l));
        aec.execute(_dictionary);
    }

    @Test
    @DisplayName("Variable containing 5 equal 5?")
    public void testEquals() throws Exception {
        // Arrange
        _equalsLogic = new EqualsExpression(
            new VariableExpression("x"), 
            new LongExpression(5l));

        //---> Act ---> Assert
        assertEquals(true, _equalsLogic.evaluate(_dictionary).booleanValue());
    }
}
