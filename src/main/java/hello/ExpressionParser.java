package hello;

import hello.domain.Equation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExpressionParser {

    @Autowired
    EquationSolver equationSolver;

    @Autowired
    Results results;

    @Autowired
    ExpressionValidator expressionValidator;

    String endResults;

    public String parse(Equation equation){

        String[] operators = equation.getEquation().replaceAll("\\(\\-[\\d]\\)|\\d|[.]", "").split("(?=[-+*/()])|(?<=[^-+*/][-+*/])|(?<=[()])");
        String[] operands = equation.getEquation().replaceAll("[()]", "").split("(?<=[\\d])[-+*/]");

        expressionValidator.validate();

        results.setOperands(operands);
        results.setOperators(operators);

        endResults = equationSolver.solve(results);

        return endResults;
    }



}
