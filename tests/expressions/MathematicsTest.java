package expressions;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Hashtable;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import smpl.sys.expressions.AdditionExpression;
import smpl.sys.expressions.BooleanExpression;
import smpl.sys.expressions.LongExpression;
import smpl.sys.expressions.MultiplicationExpression;
import smpl.sys.expressions.SubtractionExpression;
import smpl.sys.expressions.DoubleExpression;
import smpl.sys.values.IValue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathematicsTest {

    private AdditionExpression _addition;
    private SubtractionExpression _subtraction;
    private MultiplicationExpression _multiplication;
    private Hashtable<String, IValue> _dictionary;
    
    @BeforeAll
    public void setUp() throws Exception { //---> Arrange
        System.out.println("Initializing dictionary");

        _dictionary = new Hashtable<>();
    }

    @Test
    @DisplayName("Adding 9 to 22")
    public void testAdditionWholeNumbers() throws Exception { 
        // Arrange
        // Add whole numbers (ie. two long data types)
        _addition = new AdditionExpression(
            new LongExpression(9l),
            new LongExpression(22l)
        );

        //---> Act ---> Assert
        assertEquals(31l, _addition.evaluate(_dictionary).longValue(), "Adding 9 to 22 should be equal to 31");
    }

    @Test
    @DisplayName("Adding 8 to 9.5")
    public void testAdditionWholeAndDecimalNumbers() throws Exception {
        // Arrange
        // Add a whole number (i.e. a long data type) and a decimal number (i.e. a double data type)
        _addition = new AdditionExpression(
            new LongExpression(Long.valueOf(8l)),
            new DoubleExpression(Double.valueOf(9.5)));

        assertEquals(17.5, _addition.evaluate(_dictionary).doubleValue(), "Adding 8 to 9.5 should be equal to 17.5");
    }

    @DisplayName("Repeatedly adding decimal numbers")
    @RepeatedTest(
        value = 3,
        name = "Repeating addition of decimal numbers {currentRepetition} of {totalRepetitions}"
    )
    public void testRepeatedlyAddingDecimalNumbers() throws Exception {
        // Arrange
        _addition = new AdditionExpression(
            new DoubleExpression(Double.valueOf(8.5)),
            new DoubleExpression(Double.valueOf(9.5)));
        
        assertEquals(18.0, _addition.evaluate(_dictionary).doubleValue(), "Adding 8.5 to 9.5 should be equal to 18");
    }

    @DisplayName("Subtract 7 from a number")
    @ParameterizedTest
    @MethodSource("wholeNumbers")
    public void testSubtraction(Long number) throws Exception {
        // Arrange
        _subtraction = new SubtractionExpression(
            new LongExpression(Long.valueOf(number)),
            new LongExpression(Long.valueOf(7l)));
        
        long expected = number - 7l;

        assertEquals(expected, _subtraction.evaluate(_dictionary).longValue(), String.format("Subtracting 7 from %1$s should equal %2$s", number, expected ) );
    }

    private static Stream<Long> wholeNumbers() {
        return Stream.of(40l, 13l, 28l);
    }

    @DisplayName("Multiply a number times 5")
    @ParameterizedTest
    @ValueSource(doubles = { 3.1, 11.2, 13.5 })
    public void testMultiplication(double number) throws Exception {
        _multiplication = new MultiplicationExpression(
            new DoubleExpression(number),
            new DoubleExpression(Double.valueOf(5)));

        double expected = 5 * number;
        assertEquals(expected, _multiplication.evaluate(_dictionary).doubleValue());
    }

    @Test
    @DisplayName("Adding number to boolean is not implemented")
    public void testAdditionWholeAndBooleanNotAllowed() throws Exception {
        _addition = new AdditionExpression(
            new LongExpression(Long.valueOf(10l)), 
            new BooleanExpression(false));
        
        assertThrows(Exception.class, () -> _addition.evaluate(_dictionary));
    }

    @AfterAll
    public void tearDown() {
        System.out.println("Completed all mathematics test cases");
    }
}