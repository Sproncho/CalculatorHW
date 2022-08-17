package telran.calculator.model;

import com.sun.source.tree.IfTree;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.*;

public class Calculator {
    public Calculator(Class<? extends Operation>... operations){
       Arrays.stream(operations).forEach(op -> addOperation(op));
    }
    Map<String, Class<? extends Operation>> operations =new HashMap<>();
    public double Calculate(String operationName, double arg1, double arg2) throws Exception {
       Class clazz = operations.get(operationName.toLowerCase());
       if (clazz == null)
           throw new Exception("operation not found");
       Method operation = clazz.getDeclaredMethod("invoke", double.class, double.class);
       Constructor<? extends Operation> constructor = clazz.getConstructor();
       double res =  (double)operation.invoke(constructor.newInstance(),arg1,arg2);
       return res;
    }
    public void addOperation(Class<? extends Operation> operation)  {
        try {
            operations.putIfAbsent(operation.getSimpleName().toLowerCase(), operation);
        } catch (Exception e){
            System.out.println("method invoke doesn't exist");
        }
    }
    public void PrintOperations(){
        operations.keySet().forEach(System.out::println);
    }
}
