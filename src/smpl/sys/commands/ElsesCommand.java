package smpl.sys.commands;

import java.util.Vector;
import smpl.sys.values.Elses;

public class ElsesCommand implements ICommand {
    
    Vector<Elses> _elses;

    public ElsesCommand(Vector<Elses> elses) {
        _elses = elses;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        
    }
}
