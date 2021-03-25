package smpl.sys;

public class LongExpression implements IExpression {
    
    Long _num;

    public LongExpression(Long num) {
        _num = num;
    }

    @Override
    public Object evaluate() {
        return _num;
    }
}
