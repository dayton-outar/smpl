package smpl.sys.values;

import java.util.Vector;

public class LongValue implements IValue {
    
    Long _val;
    public LongValue(Long val) {
        _val = val;
    }

    @Override
    public boolean isNumber() {
        return true;
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
    public boolean isArray() {
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
    public boolean booleanValue() {
        return _val == 0;
    }

    @Override
    public Vector<IValue> arrayValues() {
        return null;
    }

    @Override
    public IValue add(IValue val) throws Exception {
        throw new Exception("Implementation for this type does not exist");
    }

    @Override
    public IValue add(DoubleValue val) {
        return val.add(this);
    }

    @Override
    public IValue add(LongValue val) {
        return new LongValue( Long.valueOf( this.longValue() + val.longValue() ) );
    }

    @Override
    public IValue add(ArrayValue val) {
        return val.add(this);
    }

    @Override
    public IValue sub(IValue val) throws Exception {
        throw new Exception("Implementation for this type does not exist");
    }

    @Override
    public IValue sub(DoubleValue val) {
        return val.sub(this);
    }

    @Override
    public IValue sub(LongValue val) {
        return new LongValue( Long.valueOf( this.longValue() - val.longValue() ) );
    }

    @Override
    public IValue sub(ArrayValue val) {
        return val.sub(this);
    }

    @Override
    public IValue mul(IValue val) throws Exception {
        throw new Exception("Implementation for this type does not exist");
    }

    @Override
    public IValue mul(DoubleValue val) {
        return val.mul(this);
    }

    @Override
    public IValue mul(LongValue val) {
        return new LongValue( Long.valueOf( this.longValue() * val.longValue() ) );
    }

    @Override
    public IValue mul(ArrayValue val) {
        return val.mul(this);
    }
    
    @Override
    public IValue div(IValue val) throws Exception {
        throw new Exception("Implementation for this type does not exist");
    }

    @Override
    public IValue div(DoubleValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() / val.doubleValue() ) );
    }

    @Override
    public IValue div(LongValue val) {
        return new LongValue( Long.valueOf( this.longValue() / val.longValue() ) );
    }

    @Override
    public IValue div(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform 6 / [1, 3, 2] => [6, 2, 3]
        for (IValue ival : val.arrayValues()) {
            lvs.add( this.div(ival) );
        }
        
        return new ArrayValue( lvs );
    }
    
    @Override
    public IValue mod(IValue val) throws Exception {
        throw new Exception("Implementation for this type does not exist");
    }

    @Override
    public IValue mod(DoubleValue val) {
        return new DoubleValue( Double.valueOf( this.longValue() % val.doubleValue() ) );
    }

    @Override
    public IValue mod(LongValue val) {
        return new LongValue( Long.valueOf( this.longValue() % val.longValue() ) );
    }

    @Override
    public IValue mod(ArrayValue val) {
        return val.mod(this);
    }

    @Override
    public IValue pow(IValue val) throws Exception {
        if ( val.isArray() ) {
            return this.pow( (ArrayValue) val);
        } else {
            return val.isLong() ? this.pow( (LongValue) val) : this.pow( (DoubleValue) val);
        }
    }

    @Override
    public IValue pow(DoubleValue val) {
        return new DoubleValue( Math.pow( this.doubleValue(), val.doubleValue() ) );
    }

    @Override
    public IValue pow(LongValue val) {
        return new LongValue( (long)Math.pow( this.doubleValue(), val.doubleValue() ) );
    }

    @Override
    public IValue pow(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform 2**[1, 3, 2] => [2, 8, 4]
        for (IValue ival : val.arrayValues()) {
            lvs.add( this.pow(ival) );
        }
        
        return new ArrayValue( lvs );
    }

    //..
    @Override
    public IValue ban(IValue val) throws Exception {
        throw new Exception("Implementation for this type does not exist");
    }

    @Override
    public IValue ban(LongValue val) {
        return new LongValue( Long.valueOf( this.longValue() & val.longValue() ) );
    }

    @Override
    public IValue ban(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform 5 & [1, 4, 2] => [1, 4, 0]
        for (IValue ival : val.arrayValues()) {
            lvs.add( this.ban( ival ) );
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue bor(IValue val) throws Exception {
        throw new Exception("Implementation for this type does not exist");
    }

    @Override
    public IValue bor(LongValue val) {
        return new LongValue( Long.valueOf( this.longValue() | val.longValue() ) );
    }

    @Override
    public IValue bor(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform 5 | [1, 4, 2] => [5, 5, 7]
        for (IValue ival : val.arrayValues()) {
            lvs.add( this.bor( ival ) );
        }
        
        return new ArrayValue( lvs );
    }

    @Override
    public IValue bxr(IValue val) throws Exception {
        throw new Exception("Implementation for this type does not exist");
    }

    @Override
    public IValue bxr(LongValue val) {
        return new LongValue( Long.valueOf( this.longValue() ^ val.longValue() ) );
    }

    @Override
    public IValue bxr(ArrayValue val) throws Exception {
        Vector<IValue> lvs = new Vector<IValue>();

        // The intention is to perform 5 | [1, 4, 2] => [5, 5, 7]
        for (IValue ival : val.arrayValues()) {
            lvs.add( this.bxr( ival ) );
        }
        
        return new ArrayValue( lvs );
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
    public IValue eq(IValue val) throws Exception {
        throw new Exception("Implementation for this type does not exist");
    }

    @Override
    public IValue eq(DoubleValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() == val.doubleValue() ) );
    }

    @Override
    public IValue eq(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.longValue() == val.longValue() ) );
    }

    @Override
    public IValue eq(ArrayValue val) throws Exception {
        return new BooleanValue(false);
    }

    @Override
    public IValue gt(IValue val) throws Exception {
        throw new Exception("Implementation for this type does not exist");
    }

    @Override
    public IValue gt(DoubleValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() > val.doubleValue() ) );
    }

    @Override
    public IValue gt(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.longValue() > val.longValue() ) );
    }

    @Override
    public IValue gt(ArrayValue val) throws Exception {
        return new BooleanValue(false);
    }

    @Override
    public IValue lt(IValue val) throws Exception {
        throw new Exception("Implementation for this type does not exist");
    }

    @Override
    public IValue lt(DoubleValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() < val.doubleValue() ) );
    }

    @Override
    public IValue lt(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.longValue() < val.longValue() ) );
    }

    @Override
    public IValue lt(ArrayValue val) throws Exception {
        return new BooleanValue(false);
    }

    @Override
    public IValue noteq(IValue val) throws Exception {
        throw new Exception("Implementation for this type does not exist");
    }

    @Override
    public IValue noteq(DoubleValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() != val.doubleValue() ) );
    }

    @Override
    public IValue noteq(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.longValue() != val.longValue() ) );
    }

    @Override
    public IValue noteq(ArrayValue val) throws Exception {
        return new BooleanValue(false);
    }

    @Override
    public IValue gtoreq(IValue val) throws Exception {
        throw new Exception("Implementation for this type does not exist");
    }

    @Override
    public IValue gtoreq(DoubleValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() >= val.doubleValue() ) );
    }

    @Override
    public IValue gtoreq(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.longValue() >= val.longValue() ) );
    }

    @Override
    public IValue gtoreq(ArrayValue val) throws Exception {
        return new BooleanValue(false);
    }

    @Override
    public IValue ltoreq(IValue val) throws Exception {
        throw new Exception("Implementation for this type does not exist");
    }

    @Override
    public IValue ltoreq(DoubleValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() <= val.doubleValue() ) );
    }

    @Override
    public IValue ltoreq(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.longValue() <= val.longValue() ) );
    }

    @Override
    public IValue ltoreq(ArrayValue val) throws Exception {
        return new BooleanValue(false);
    }

    @Override
    public IValue and(IValue val) throws Exception {
        throw new Exception("Implementation for this type does not exist");
    }

    @Override
    public IValue and(BooleanValue val) throws Exception {
        throw new Exception("Implementation for this type does not exist");
    }

    @Override
    public IValue or(IValue val) throws Exception {
        throw new Exception("Implementation for this type does not exist");
    }

    @Override
    public IValue or(BooleanValue val) throws Exception {
        throw new Exception("Implementation for this type does not exist");
    }

    @Override
    public IValue not() throws Exception {
        throw new Exception("Implementation for this type does not exist");
    }

    @Override
    public String toString() {
        return _val.toString();
    }
}
