package smpl.sys.values;

public class LongValue implements INumValue {
    
    Long _val;
    public LongValue(Long val) {
        _val = val;
    }

    @Override
    public boolean isLong() {
        return true;
    }

    @Override
    public boolean isDouble() {
        return false;
    }

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
        if (val.isDouble())
            return val.add(this);
        else
            return new LongValue( Long.valueOf( this.longValue() + val.longValue() ) );
    }

    @Override
    public IValue sub(INumValue val) {
        if (val.isDouble())
            return val.sub(this);
        else
            return new LongValue( Long.valueOf( this.longValue() - val.longValue() ) );
    }

    @Override
    public IValue mul(INumValue val) {
        if (val.isDouble())
            return val.mul(this);
        else
            return new LongValue( Long.valueOf( this.longValue() * val.longValue() ) );
    }

    @Override
    public IValue div(INumValue val) {
        if (val.isDouble())
            return val.div(this);
        else
            return new LongValue( Long.valueOf( this.longValue() / val.longValue() ) );
    }

    @Override
    public IValue mod(INumValue val) {
        if (val.isDouble())
            return val.mod(this);
        else
            return new LongValue( Long.valueOf( this.longValue() % val.longValue() ) );
    }

    @Override
    public IValue pow(INumValue val) {
        return new DoubleValue( Math.pow( this.doubleValue(), val.doubleValue() ) ); // TODO: Return as long instead of double?
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
        long val = this.longValue();
        val++;

        return new LongValue( Long.valueOf( val ) );
    }

    @Override
    public IValue dec() {
        long val = this.longValue();
        val--;

        return new LongValue( Long.valueOf( val ) );
    }

    @Override
    public IValue inv() {
        return new LongValue( Long.valueOf( -this.longValue() ) );
    }

    @Override
    public IValue sqr() {
        return new DoubleValue( Math.sqrt( this.doubleValue() ) ); // TODO: Return as long instead of double?
    }

    @Override
    public IValue eq(INumValue val) {
        return new BooleanValue( Boolean.valueOf( this.longValue() == val.longValue() ) );
    }

    @Override
    public IValue gt(INumValue val) {
        return new BooleanValue( Boolean.valueOf( this.longValue() > val.longValue() ) );
    }

    @Override
    public IValue lt(INumValue val) {
        return new BooleanValue( Boolean.valueOf( this.longValue() < val.longValue() ) );
    }

    @Override
    public IValue noteq(INumValue val) {
        return new BooleanValue( Boolean.valueOf( this.longValue() != val.longValue() ) );
    }

    @Override
    public IValue gtoreq(INumValue val) {
        return new BooleanValue( Boolean.valueOf( this.longValue() >= val.longValue() ) );
    }

    @Override
    public IValue ltoreq(INumValue val) {
        return new BooleanValue( Boolean.valueOf( this.longValue() <= val.longValue() ) );
    }

    @Override
    public String toString() {
        return _val.toString();
    }
}
