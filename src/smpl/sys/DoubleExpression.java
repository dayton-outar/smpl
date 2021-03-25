package smpl.sys;

public class DoubleExpression implements IExpression {
    
    Double _num;

    public DoubleExpression(Double num) {
        _num = num;
    }

    @Override
    public Object evaluate() {
        return _num;
    }
}
