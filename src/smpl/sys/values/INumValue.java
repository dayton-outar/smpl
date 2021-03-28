package smpl.sys.values;

public interface INumValue extends IValue {
    boolean isDouble();
    boolean isLong();
    long longValue();
    double doubleValue();
    IValue add(INumValue val);
    IValue sub(INumValue val);
    IValue mul(INumValue val);
    IValue div(INumValue val);
    IValue mod(INumValue val);
    IValue pow(INumValue val);
    IValue ban(INumValue val);
    IValue bor(INumValue val);
    IValue bxr(INumValue val);
    IValue biv();
    IValue inc();
    IValue dec();
    IValue inv();
    IValue sqr();
    // Logical Expressions
    IValue eq(INumValue val);
    IValue gt(INumValue val);
    IValue lt(INumValue val);
    IValue noteq(INumValue val);
    IValue gtoreq(INumValue val);
    IValue ltoreq(INumValue val);
}
