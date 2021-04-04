package smpl.sys.values;

public class BooleanValue implements IValue {
    
    Boolean _val;
    public BooleanValue(Boolean val) {
        _val = val;
    }

    @Override
    public boolean isNumber() {
        return false;
    }

    @Override
    public boolean isDouble() {
        return false;
    }

    @Override
    public boolean isLong() {
        return false;
    }

    @Override
    public boolean isArray() {
        return false;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }

    @Override
    public boolean booleanValue() {
        return _val.booleanValue();
    }

    @Override
    public IValue add(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue sub(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue mul(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue div(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue mod(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue pow(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue ban(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue bor(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue bxr(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue biv() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue inc() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue dec() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue inv() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue sqr() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue eq(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue gt(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue lt(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue noteq(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue gtoreq(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue ltoreq(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue and(BooleanValue val) {
        return new BooleanValue( Boolean.valueOf( this.booleanValue() && val.booleanValue() ) );
    }

    @Override
    public IValue or(BooleanValue val) {
        return new BooleanValue( Boolean.valueOf( this.booleanValue() || val.booleanValue() ) );
    }

    @Override
    public IValue not() {
        return new BooleanValue( Boolean.valueOf( !this.booleanValue() ) );
    }

    @Override
    public String toString() {
        return _val.toString();
    }
}
