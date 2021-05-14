package smpl.sys.expressions;

import java.util.Hashtable;

import smpl.sys.values.IValue;

/**
 * Embodies the sum of two expressions
 * 
 * @author Dayton Outar
 * 
 * @since 1.0.0
 */
public class AdditionExpression implements IExpression {

    IExpression _exp1;
    IExpression _exp2;

    /**
     * Adds the two provided expressions
     * 
     * @param exp1 An expression that will be aggregated into the sum total
     * @param exp2 An expression that will be aggregated into the sum total
     */
    public AdditionExpression(IExpression exp1, IExpression exp2) {
        _exp1 = exp1;
        _exp2 = exp2;
    }

    /**
     * Returns evaluation of this addition expression
     * 
     * @param dictionary Contains a mapping of strings {@code String} to variables and/or functions
     * @return An object of {@code IValue} template
     * @throws Exception
     */
    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) throws Exception {
        return _exp1.evaluate(dictionary).add( _exp2.evaluate(dictionary) );
    }
}
