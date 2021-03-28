package smpl.sys.values;

public interface ILogicValue extends IValue {
    boolean booleanValue();
    IValue and(ILogicValue val);
    IValue or(ILogicValue val);
    IValue not();
}
