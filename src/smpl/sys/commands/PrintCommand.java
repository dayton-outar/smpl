package smpl.sys.commands;

import java.util.Hashtable;

import smpl.sys.expressions.IExpression;
import smpl.sys.values.IValue;

public class PrintCommand implements ICommand {
    
    String _message = "";
    IExpression _exp;

    // TODO: Will need to change to accommodate array of strings and expressions
    public PrintCommand(String message) {
        _message = message;
    }

    public PrintCommand(IExpression expression) {
        _exp = expression;
    }

    @Override
    public void execute(Hashtable<String, IValue> dictionary) {
        if (_message.isEmpty()) {
            System.out.println(_exp.evaluate(dictionary));
        } else {
            System.out.println(_message);
        }        
    }
}
