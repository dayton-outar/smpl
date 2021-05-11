package smpl.sys.commands;

import java.util.Hashtable;

import smpl.sys.expressions.IExpression;
import smpl.sys.values.IValue;

public class PrintCommand implements ICommand {

    IExpression _expression;

    public PrintCommand(IExpression expression) {
        _expression = expression;
    }

    @Override
    public void execute(Hashtable<String, IValue> dictionary) throws Exception {
        System.out.print(_expression.evaluate(dictionary));
    }
}