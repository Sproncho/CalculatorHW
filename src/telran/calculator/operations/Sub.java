package telran.calculator.operations;

import telran.calculator.model.Operation;

public class Sub implements Operation {

    @Override
    public double invoke(double arg1, double arg2) {
        return arg1 - arg2;
    }
}
