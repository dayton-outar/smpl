package smpl.sys.values;

public interface IListValue extends IValue {
    IValue add(INumValue val);
    IValue add(IListValue val);
    IValue sub(INumValue val);
    IValue sub(IListValue val);
    IValue mul(INumValue val);
    IValue mul(IListValue val);
    IValue div(INumValue val);
    IValue div(IListValue val);
    IValue mod(INumValue val);
    IValue mod(IListValue val);
    IValue pow(INumValue val);
    IValue pow(IListValue val);
    IValue ban(INumValue val);
    IValue ban(IListValue val);
    IValue bor(INumValue val);
    IValue bor(IListValue val);
    IValue bxr(INumValue val);
    IValue bxr(IListValue val);
    IValue biv();
    IValue inc();
    IValue dec();
    IValue inv();
    IValue sqr();
    // Logical Expressions
    IValue eq(IListValue val);
    IValue gt(IListValue val);
    IValue lt(IListValue val);
    IValue noteq(IListValue val);
    IValue gtoreq(IListValue val);
    IValue ltoreq(IListValue val);   
}