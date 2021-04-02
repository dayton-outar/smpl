package smpl.sys.util;

import smpl.sys.expressions.IExpression;

public class Cases {
    
    String _value;
    IExpression _expression;

    public Cases(String value, IExpression expression) {
        this._value = value;
        this._expression = expression;
    }

    /**
     * Get condition
     * 
     * @return IExpression
     */
    public String getCaseValue() {
        return _value;
    }

    /**
     * Get expression
     * 
     * @return IExpression
     */
    public IExpression getExpression() {
        return _expression;
    }
}
