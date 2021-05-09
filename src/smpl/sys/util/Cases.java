package smpl.sys.util;

import java.util.Vector;

import smpl.sys.commands.ICommand;
import smpl.sys.expressions.IExpression;

public class Cases {
    
    Vector<IExpression> _expressions;
    ICommand _statement;

    public Cases(Vector<IExpression> expressions, ICommand statement) {
        _expressions = expressions;
        _statement = statement;
    }

    /**
     * Get case value
     * 
     * @return Vector<String>
     */
    public Vector<IExpression> getCaseValues() {
        return _expressions;
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
