package smpl.sys.commands;

import java.util.Hashtable;
import java.util.Vector;
import smpl.sys.util.Elses;
import smpl.sys.values.IValue;

public class ElsesCommand implements ICommand {
    
    Vector<Elses> _elses;

    public ElsesCommand(Vector<Elses> elses) {
        _elses = elses;
    }

    @Override
    public void execute(Hashtable<String, IValue> dictionary) {
        // TODO Auto-generated method stub
        
    }
}
