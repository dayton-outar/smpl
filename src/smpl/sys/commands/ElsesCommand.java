package smpl.sys.commands;

import java.util.Vector;
import smpl.sys.util.Elses;
import smpl.sys.util.ProgramState;

public class ElsesCommand implements ICommand {
    
    Vector<Elses> _elses;

    public ElsesCommand(Vector<Elses> elses) {
        _elses = elses;
    }

    @Override
    public void execute(ProgramState state) {
        // TODO Auto-generated method stub
        
    }
}
