import java.util.Hashtable;

import smpl.sys.*;
import smpl.sys.expressions.DoubleExpression;
import smpl.sys.expressions.IExpression;
import smpl.sys.expressions.LongExpression;
import smpl.sys.expressions.MultiplicationExpression;
import smpl.sys.values.IValue;

public class Test {
    public static void main(String[] args) throws Exception {
        Object s = new String("JavaTpoint");
        Object num1 = 8l;
        Object num2 = 9.5;
        Object num3 = 2.2;
        Object num4 = 3l;

        Class a = num1.getClass();

        System.out.println( "Class of Object obj is : " + a.getName() );

        System.out.println( "num1: " + num1.toString() + " " + ((num1 instanceof Integer) ? "is" : "is not") + " Integer" );
        System.out.println( "num1: " + num1.toString() + " " + ((num1 instanceof Long) ? "is" : "is not") + " Long" );
        System.out.println( "num1: " + num1.toString() + " " + ((num1 instanceof Double) ? "is" : "is not") + " Double" );
        System.out.println( "num1: " + num1.toString() + " " + ((num1 instanceof String) ? "is" : "is not") + " String" );

        IExpression exp1 = new LongExpression(Long.valueOf(8l));
        IExpression exp2 = new DoubleExpression(Double.valueOf(9.5));

        IExpression expMul = new MultiplicationExpression(exp1, exp2);
        Object result = expMul.evaluate(new Hashtable<String, IValue>());
        System.out.println("result = " + result.toString());
        
        Double result2 = Math.pow( Double.valueOf(num1.toString()), Double.valueOf(num3.toString()) );
        double remainder = result2 % 1.0;
        
        Object r;

        if (remainder == 0.0) {
            r = result2.longValue();
        } else {
            r = result;
        }

        System.out.println("remainder = " + remainder + " ... " + r);

        Long p = Long.valueOf(num2.toString()) | Long.valueOf(num3.toString());
    }
}
