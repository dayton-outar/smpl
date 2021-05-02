package smpl.sys.commands;

import java.util.Hashtable;
import java.util.Vector;

import smpl.sys.expressions.IExpression;
import smpl.sys.values.IValue;

public class PrintCommand implements ICommand {

    Vector<IExpression> _expressions;

    public PrintCommand(Vector<IExpression> expressions) {
        _expressions = expressions;
    }

    @Override
    public void execute(Hashtable<String, IValue> dictionary) throws Exception {
        StringBuffer sb = new StringBuffer();

        for (IExpression ie : _expressions) {
            sb.append(ie.evaluate(dictionary));
        }
        
        System.out.print(sb.toString());
    }
}
