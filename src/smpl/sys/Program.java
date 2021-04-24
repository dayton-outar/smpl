package smpl.sys;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import smpl.sys.commands.ICommand;
import smpl.sys.values.IValue;

import java.util.Stack;

/** Embodies the program stack for a complete body of statements
 * 
 * @author Dayton Outar
 * 
 * @version 1.0.0
 * @since 1.0.0
 */
public class Program {

    Stack<ICommand> programStack;
    
    /**
     * Initialize program stack with list of statements from AST
     * 
     * @param stmts A collection of statements to be executed
     */
    public Program(Vector<ICommand> stmts) {
        Enumeration<ICommand> commandElements = stmts.elements();
        programStack = new Stack<ICommand>();

        while (commandElements.hasMoreElements()) {
            programStack.push(commandElements.nextElement());
        }
    }

    /**
     * Executes the collection of statements provided with a hashtable that stores variables and functions
     * 
     * @param dictionary Contains a mapping of strings {@code String} to variables and/or functions
     * @throws Exception
     */
    public void execute(Hashtable<String, IValue> dictionary) throws Exception {
        while (!programStack.isEmpty()) {
            programStack.pop().execute(dictionary);
        }
    }
}
