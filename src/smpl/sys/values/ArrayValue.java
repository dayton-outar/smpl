package smpl.sys.values;

import java.util.Vector;

public class ArrayValue implements IValue {

    Vector<IValue> _val;
    public ArrayValue(Vector<IValue> val) {
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
        return true;
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
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append( String.join(", ", _val.toArray(new String[_val.size()]) ) );
        sb.append("]");
        return sb.toString();
    }
    @Override
    public boolean booleanValue() {
        // TODO Auto-generated method stub
        return false;
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
    public IValue add(DoubleValue val) {
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
    public IValue sub(DoubleValue val) {
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
    public IValue mul(DoubleValue val) {
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
    public IValue div(DoubleValue val) {
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
    public IValue mod(DoubleValue val) {
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
    public IValue pow(DoubleValue val) {
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
    public IValue ban(LongValue val) {
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
    public IValue bor(LongValue val) {
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
    public IValue bxr(LongValue val) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public IValue bxr(ArrayValue val) throws Exception {
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
    public IValue eq(LongValue val) {
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
    public IValue gt(LongValue val) {
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
    public IValue lt(LongValue val) {
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
    public IValue noteq(LongValue val) {
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
    public IValue gtoreq(LongValue val) {
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
    public IValue ltoreq(LongValue val) {
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