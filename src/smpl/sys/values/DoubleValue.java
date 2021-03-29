package smpl.sys.values;

/**
 * @author Dayton Outar
 * 
 */
public class DoubleValue implements INumValue {
    
    Double _val;
    public DoubleValue(Double val) {
        _val = val;
    }

    @Override
    public boolean isLong() {
        return false;
    }

    @Override
    public boolean isDouble() {
        return true;
    }

    /**
     * Returns the value of this object as long data type
     */
    @Override
    public long longValue() {
        return _val.longValue();
    }

    @Override
    public double doubleValue() {
        return _val.doubleValue();
    }

    @Override
    public IValue add(INumValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() + val.doubleValue() ) );
    }

    @Override
    public IValue sub(INumValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() - val.doubleValue() ) );
    }

    @Override
    public IValue mul(INumValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() * val.doubleValue() ) );
    }

    @Override
    public IValue div(INumValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() / val.doubleValue() ) );
    }

    @Override
    public IValue mod(INumValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() % val.doubleValue() ) );
    }

    @Override
    public IValue pow(INumValue val) {
        return new DoubleValue( Math.pow( this.doubleValue(), val.doubleValue() ) );
    }

    @Override
    public IValue ban(INumValue val) {
        return new LongValue( Long.valueOf( this.longValue() & val.longValue() ) );
    }

    @Override
    public IValue bor(INumValue val) {
        return new LongValue( Long.valueOf( this.longValue() | val.longValue() ) );
    }

    @Override
    public IValue bxr(INumValue val) {
        return new LongValue( Long.valueOf( this.longValue() ^ val.longValue() ) );
    }

    @Override
    public IValue biv() {
        return new LongValue( Long.valueOf( ~this.longValue() ) );
    }

    @Override
    public IValue inc() {
        double val = this.doubleValue();
        val++;

        return new DoubleValue( Double.valueOf( val ) );
    }

    @Override
    public IValue dec() {
        double val = this.doubleValue();
        val--;

        return new DoubleValue( Double.valueOf( val ) );
    }

    @Override
    public IValue inv() {
        return new DoubleValue( Double.valueOf( -this.doubleValue() ) );
    }

    @Override
    public IValue sqr() {
        return new DoubleValue( Math.sqrt( this.doubleValue() ) );
    }

    @Override
    public IValue eq(INumValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() == val.doubleValue() ) );
    }

    @Override
    public IValue gt(INumValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() > val.doubleValue() ) );
    }

    @Override
    public IValue lt(INumValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() < val.doubleValue() ) );
    }

    @Override
    public IValue noteq(INumValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() != val.doubleValue() ) );
    }

    @Override
    public IValue gtoreq(INumValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() >= val.doubleValue() ) );
    }

    @Override
    public IValue ltoreq(INumValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() <= val.doubleValue() ) );
    }

    @Override
    public String toString() {
        return _val.toString();
    }
}
