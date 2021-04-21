package smpl.sys.commands;

import java.util.Hashtable;
import java.util.Vector;
import java.util.Collections;

import smpl.sys.expressions.IExpression;
import smpl.sys.values.IValue;

public class LoopCommand implements ICommand {

    ICommand _initialize;
    IExpression _condition;
    ICommand _stepper;
    Vector<ICommand> _statements;

    public LoopCommand(ICommand initialize, IExpression condition, ICommand stepper, Vector<ICommand> statements) {
        _initialize = initialize;
        _condition = condition;
        _stepper = stepper;
        _statements = statements;
    }

    @Override
    public void execute(Hashtable<String, IValue> dictionary) throws Exception {
        if (_initialize != null) {
            _initialize.execute(dictionary);
        }

        Collections.reverse(_statements);

        while( _condition.evaluate(dictionary).booleanValue() ) {
            for (ICommand stmt : _statements) {
                stmt.execute(dictionary);
            }
            
            if ( _stepper != null) {
                _stepper.execute(dictionary);
            }
        }
    }
    
}
