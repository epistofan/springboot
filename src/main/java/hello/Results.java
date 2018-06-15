package hello;

import org.springframework.stereotype.Component;

@Component
public class Results {

    String [] operators;
    String [] operands;


    public String[] getOperators() {
        return operators;
    }

    public void setOperators(String[] operators) {
        this.operators = operators;
    }

    public String[] getOperands() {
        return operands;
    }

    public void setOperands(String[] operands) {
        this.operands = operands;
    }
}
