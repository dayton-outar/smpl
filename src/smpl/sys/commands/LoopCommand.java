package smpl.sys.commands;

import java.util.Hashtable;
import java.util.Vector;

import smpl.sys.expressions.IExpression;
import smpl.sys.values.IValue;

public class LoopCommand implements ICommand {

    Vector<ICommand> _initializeList;
    IExpression _condition;
    IExpression _incrementExpression;
    Vector<ICommand> _statements;

    public LoopCommand(Vector<ICommand> initializeList, IExpression condition, IExpression incrementExpression, Vector<ICommand> statements) {
        _initializeList = initializeList;
        _condition = condition;
        _incrementExpression = incrementExpression;
        _statements = statements;
    }

    @Override
    public void execute(Hashtable<String, IValue> dictionary) throws Exception {
        for (ICommand cmd : _initializeList) {
            cmd.execute(dictionary);
        }

        while( _condition.evaluate(dictionary).booleanValue() ) {
            for (ICommand stmt : _statements) {
                stmt.execute(dictionary);
            }
            _incrementExpression.evaluate(dictionary);
        }
    }
    
}
