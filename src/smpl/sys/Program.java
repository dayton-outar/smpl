package smpl.sys;

import java.util.Enumeration;
import java.util.Vector;

import smpl.sys.commands.ICommand;
import smpl.sys.util.ProgramState;

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
        programStack = new Stack<ICommand>();

        while (commandElements.hasMoreElements()) {
            programStack.push(commandElements.nextElement());
        }
    }

    public void execute(ProgramState state) {
        state.setStack( programStack );

        while (!programStack.isEmpty()) {
            programStack.pop().execute(state);
        }
    }
}
