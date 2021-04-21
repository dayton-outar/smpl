package smpl.sys.commands;

import java.util.Hashtable;
import java.util.Vector;
import java.util.Collections;

import smpl.sys.util.Elses;
import smpl.sys.values.IValue;

public class ElsesCommand implements ICommand {
    
    Vector<Elses> _elses;

    public ElsesCommand(Vector<Elses> elses) {
        _elses = elses;
    }

    @Override
    public void execute(Hashtable<String, IValue> dictionary) throws Exception {
        Collections.reverse(_elses);

        for (Elses elses : _elses) {
            if ( elses.getCondition().evaluate(dictionary).booleanValue() ) {
                elses.getStatement().execute(dictionary);
                break;
            }
        }
    }
}
