package smpl.sys.commands;

import java.util.Hashtable;
import java.util.Vector;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import smpl.sys.expressions.IExpression;
import smpl.sys.util.Cases;
import smpl.sys.values.BooleanValue;
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

    private IValue compareToPredicate(IExpression predicate, Hashtable<String, IValue> dictionary, IValue val) {
        IValue result = new BooleanValue(false);

        try {
            result = predicate.evaluate(dictionary).eq(val);
        } catch (Exception ex) {}

        return result;
    }

    @Override
    public void execute(Hashtable<String, IValue> dictionary) throws Exception {
        Collections.reverse(_cases);
        
        IValue val = _exp.evaluate(dictionary);

        for (Cases cases : _cases) {

            List<IExpression> predicates = Collections.list( cases.getCaseValues().elements() );
            boolean outcome = predicates.stream()
                                        .anyMatch(p -> compareToPredicate(p, dictionary, val).booleanValue());

            if ( outcome ) {
                cases.getStatement().execute(dictionary);
                break;
            }
        }
    }
}
