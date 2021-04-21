package smpl.sys.commands;

import java.util.Hashtable;

import smpl.sys.expressions.IExpression;
import smpl.sys.values.IValue;

public class PrintCommand implements ICommand {
    
    String _message = "";
    IExpression _exp;

    public PrintCommand(String message) {
        _message = message;
    }

    public PrintCommand(IExpression expression) {
        _exp = expression;
    }

    @Override
    public void execute(Hashtable<String, IValue> dictionary) throws Exception {
        if (_message.isEmpty()) {
            System.out.println(_exp.evaluate(dictionary));
        } else {
            System.out.println(_message);
        }        
    }
}
