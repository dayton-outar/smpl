package smpl.sys.values;

public class BooleanValue implements ILogicValue {
    
    Boolean _val;
    public BooleanValue(Boolean val) {
        _val = val;
    }

    @Override
    public boolean booleanValue() {
        return _val.booleanValue();
    }

    @Override
    public IValue and(ILogicValue val) {
        return new BooleanValue( Boolean.valueOf( this.booleanValue() && val.booleanValue() ) );
    }

    @Override
    public IValue or(ILogicValue val) {
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
