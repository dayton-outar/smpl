package smpl.sys;

import java.util.Enumeration;
import java.util.Vector;
import java.util.Stack;

/**
 * Embodies the program stack for a complete body of statements
 */
public class Program {

    Stack<Command> programStack;
    
    /**
     * Initialize program stack with list of statements from AST
     * 
     * @param stmts
     */
    public Program(Vector<Command> stmts) {
        Enumeration<Command> commandElements = stmts.elements();

        while (commandElements.hasMoreElements()) {
            programStack.push(commandElements.nextElement());
        }
    }

    public void execute() {
        while (!programStack.isEmpty()) {
            //programStack.pop().
        }
    }
}
