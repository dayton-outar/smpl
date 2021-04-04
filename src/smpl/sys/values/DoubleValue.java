package smpl.sys.values;

import java.util.Vector;

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
    public IValue add(DoubleValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() + val.doubleValue() ) );
    }

    @Override
    public IValue sub(DoubleValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() - val.doubleValue() ) );
    }

    @Override
    public IValue mul(DoubleValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() * val.doubleValue() ) );
    }

    @Override
    public IValue div(DoubleValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() / val.doubleValue() ) );
    }

    @Override
    public IValue mod(DoubleValue val) {
        return new DoubleValue( Double.valueOf( this.doubleValue() % val.doubleValue() ) );
    }

    @Override
    public IValue pow(DoubleValue val) {
        return new DoubleValue( Math.pow( this.doubleValue(), val.doubleValue() ) );
    }

    @Override
    public IValue ban(LongValue val) {
        return new LongValue( Long.valueOf( this.longValue() & val.longValue() ) );
    }

    @Override
    public IValue bor(LongValue val) {
        return new LongValue( Long.valueOf( this.longValue() | val.longValue() ) );
    }

    @Override
    public IValue bxr(LongValue val) {
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
    public IValue eq(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() == val.doubleValue() ) );
    }

    @Override
    public IValue gt(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() > val.doubleValue() ) );
    }

    @Override
    public IValue lt(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() < val.doubleValue() ) );
    }

    @Override
    public IValue noteq(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() != val.doubleValue() ) );
    }

    @Override
    public IValue gtoreq(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() >= val.doubleValue() ) );
    }

    @Override
    public IValue ltoreq(LongValue val) {
        return new BooleanValue( Boolean.valueOf( this.doubleValue() <= val.doubleValue() ) );
    }

    @Override
    public String toString() {
        return _val.toString();
    }

    @Override
    public Vector<IValue> arrayValues() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue add(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue add(LongValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue add(ArrayValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue sub(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue sub(LongValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue sub(ArrayValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue mul(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue mul(LongValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue mul(ArrayValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue div(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue div(LongValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue div(ArrayValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue mod(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue mod(LongValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue mod(ArrayValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue pow(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue pow(LongValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue pow(ArrayValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue ban(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue ban(ArrayValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue bor(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue bor(ArrayValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue bxr(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue bxr(ArrayValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue eq(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue eq(DoubleValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue eq(ArrayValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue gt(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue gt(DoubleValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue gt(ArrayValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue lt(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue lt(DoubleValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue lt(ArrayValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue noteq(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue noteq(DoubleValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue noteq(ArrayValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue gtoreq(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue gtoreq(DoubleValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue gtoreq(ArrayValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue ltoreq(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue ltoreq(DoubleValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue ltoreq(ArrayValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue and(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue and(BooleanValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue or(IValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue or(BooleanValue val) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue not() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
}
