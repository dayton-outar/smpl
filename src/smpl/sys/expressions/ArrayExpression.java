package smpl.sys.expressions;

import java.util.Hashtable;
import java.util.Vector;
import java.util.Collections;

import smpl.sys.values.ArrayValue;
import smpl.sys.values.IValue;

/**
 * Wraps a list of expressions to mimick an array
 * 
 * @author Dayton Outar
 * @since 1.0.0
 */
public class ArrayExpression implements IExpression {

    Vector<IExpression> _expressions;

    /**
     * Evaluates each expression and stores the {@code IValue} into the program's heap
     * 
     * @param expressions Collection of expressions
     */
    public ArrayExpression(Vector<IExpression> expressions) {
        _expressions = expressions;
    }

    /**
     * Returns the evaluation of all expressions in an {@code ArrayValue} object
     * 
     * @param dictionary Contains a mapping of strings {@code String} to variables and/or functions
     * @return An object of {@code IValue} template
     * @throws Exception
     */
    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) throws Exception {
        Vector<IValue> vals = new Vector<IValue>();
        
        Collections.reverse(_expressions);

        for (IExpression _exp : _expressions) {
            IValue av = _exp.evaluate(dictionary);
            if (av.isArray() && _exp instanceof ArrayInitializationExpression ) {
                vals.addAll( av.arrayValues() );
            } else {
                vals.add( av );
            }
        }

        return new ArrayValue(vals);
    }
    
}
