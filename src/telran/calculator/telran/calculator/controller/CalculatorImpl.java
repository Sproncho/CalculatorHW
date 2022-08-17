package telran.calculator.telran.calculator.controller;

import telran.calculator.model.Calculator;
import telran.calculator.model.Operation;
import telran.calculator.operations.Mul;
import telran.calculator.operations.Sub;
import telran.calculator.operations.Sum;

public class CalculatorImpl {
    static Calculator calculator = new Calculator(Mul.class, Sub.class);
    public static void main(String[] args) {
        calculator.addOperation(Sum.class);
        try {
            System.out.println(calculator.Calculate(args[2],Double.parseDouble(args[0]),Double.parseDouble(args[1])));
         }catch (Exception e){
            e.printStackTrace();
        }
    }
}
