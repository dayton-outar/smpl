package smpl.sys.values;

/**
 * @author Dayton Outar
 * 
 */
public class DoubleValue implements IValue {
    
    Double _val;
    public DoubleValue(Double val) {
        _val = val;
    }

    @Override
    public boolean isNumber() {
        return true;
    }

    @Override
    public boolean isLong() {
        return false;
    }

    @Override
    public boolean isDouble() {
        return true;
    }

    @Override
    public boolean isArray() {
        return false;
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
    public boolean booleanValue() {
        return _val == 0;
    }

    @Override
    public IValue add(IValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() + val.doubleValue() ) );
    }

    @Override
    public IValue sub(IValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() - val.doubleValue() ) );
    }

    @Override
    public IValue mul(IValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() * val.doubleValue() ) );
    }

    @Override
    public IValue div(IValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() / val.doubleValue() ) );
    }

    @Override
    public IValue mod(IValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() % val.doubleValue() ) );
    }

    @Override
    public IValue pow(IValue val) {
        return new DoubleValue( Math.pow( this.doubleValue(), val.doubleValue() ) );
    }

    @Override
    public IValue ban(IValue val) {
        return new LongValue( Long.valueOf( this.longValue() & val.longValue() ) );
    }

    @Override
    public IValue bor(IValue val) {
        return new LongValue( Long.valueOf( this.longValue() | val.longValue() ) );
    }

    @Override
    public IValue bxr(IValue val) {
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
    public IValue eq(IValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() == val.doubleValue() ) );
    }

    @Override
    public IValue gt(IValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() > val.doubleValue() ) );
    }

    @Override
    public IValue lt(IValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() < val.doubleValue() ) );
    }

    @Override
    public IValue noteq(IValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() != val.doubleValue() ) );
    }

    @Override
    public IValue gtoreq(IValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() >= val.doubleValue() ) );
    }

    @Override
    public IValue ltoreq(IValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() <= val.doubleValue() ) );
    }

    @Override
    public String toString() {
        return _val.toString();
    }
}
