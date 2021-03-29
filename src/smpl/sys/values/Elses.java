package smpl.sys.values;

import smpl.sys.expressions.IExpression;

public class Elses {

    IExpression _condition;
    IExpression _expression;

    public Elses(IExpression condition, IExpression expression) {
        this._condition = condition;
        this._expression = expression;
    }

    /**
     * Get condition
     * 
     * @return IExpression
     */
    public IExpression getCondition() {
        return _condition;
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