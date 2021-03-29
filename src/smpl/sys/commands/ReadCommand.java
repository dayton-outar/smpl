package smpl.sys.commands;

public class ReadCommand implements ICommand {
    
    String _var;
    public ReadCommand(String var) {
        _var = var;
    }

    @Override
    public void execute() {
        System.out.println("READ INTO " + _var);       
    }
}
