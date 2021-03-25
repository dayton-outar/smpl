package smpl.sys;

import java.util.Enumeration;
import java.util.Vector;
import java.util.Stack;

/**
 * Embodies the program stack for a complete body of statements
 */
public class Program {

    Stack<ICommand> programStack;
    
    /**
     * Initialize program stack with list of statements from AST
     * 
     * @param stmts
     */
    public Program(Vector<ICommand> stmts) {
        Enumeration<ICommand> commandElements = stmts.elements();

        while (commandElements.hasMoreElements()) {
            programStack.push(commandElements.nextElement());
        }
    }

    public void execute() {
        while (!programStack.isEmpty()) {
            programStack.pop().execute();
        }
    }
}
