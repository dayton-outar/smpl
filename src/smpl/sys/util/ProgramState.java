package smpl.sys.util;

import java.util.Hashtable;
import java.util.Stack;

import smpl.sys.commands.ICommand;
import smpl.sys.values.IValue;

public class ProgramState {
    
    Stack<ICommand> _programStack;
    Hashtable<String, IValue> _dictionary;

    public ProgramState() {
        _programStack = new Stack<ICommand>();
        _dictionary = new Hashtable<String, IValue>();
    }

    public ProgramState(Stack<ICommand> programStack, Hashtable<String, IValue> dictionary) {
        _programStack = programStack;
        _dictionary = dictionary;
    }

    public Stack<ICommand> getStack() {
        return _programStack;
    }

    public Hashtable<String, IValue> getDictionary() {
        return _dictionary;
    }

    public void setStack(Stack<ICommand> stack) {
        _programStack = stack;
    }

    public void setDictionary(Hashtable<String, IValue> dictionary) {
        _dictionary = dictionary;
    }
}
