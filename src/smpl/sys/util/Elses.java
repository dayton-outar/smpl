package smpl.sys.util;

import smpl.sys.commands.ICommand;
import smpl.sys.expressions.IExpression;

public class Elses {

    IExpression _condition;
    ICommand _statement;

    public Elses(IExpression condition, ICommand statement) {
        this._condition = condition;
        this._statement = statement;
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
     * @return ICommand
     */
    public ICommand getStatement() {
        return _statement;
    }
}