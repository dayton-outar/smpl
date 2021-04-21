package smpl.sys.commands;

import java.util.Hashtable;
import java.util.Vector;
import java.util.Collections;

import smpl.sys.expressions.IExpression;
import smpl.sys.util.Cases;
import smpl.sys.values.IValue;

public class CasesCommand implements ICommand {
    
    IExpression _exp;
    Vector<Cases> _cases;

    public CasesCommand(
        IExpression exp, 
        Vector<Cases> cases) {
        _exp = exp;
        _cases = cases;
    }

    @Override
    public void execute(Hashtable<String, IValue> dictionary) throws Exception {
        Collections.reverse(_cases);

        String val = _exp.evaluate(dictionary).toString();

        for (Cases cases : _cases) {
            if ( cases.getCaseValues().contains( val ) ) {
                cases.getStatement().execute(dictionary);
                break;
            }
        }
    }
}
