package hello;

import hello.domain.Equation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ExpressionParser {

    @Autowired
    EquationSolver equationSolver;

    @Autowired
    Results results;


    String endResults;

    public String parse(Equation equation) {

        String[] operators = equation.getEquation().replaceAll("\\(\\-[\\d]\\)|\\d|[.]", "").split("(?=[-+*/()])|(?<=[^-+*/][-+*/])|(?<=[()])");
        String[] operands = equation.getEquation().replaceAll("[()]", "").split("(?<=[\\d])[-+*/]");


        this.validate(operands, operators, equation);

        results.setOperands(operands);
        results.setOperators(operators);

        endResults = equationSolver.solve(results);

        return endResults;
    }

    public String validate(String[] operands, String[] operators, Equation equation) {

        if (operands.length == 1) {
            System.out.println("1 cifra");



            String pattern = "[+]{2,10}";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(equation.getEquation());

            if (equation.getEquation().trim().isEmpty() || m.find()) {
                System.out.println("digits");


            }

        }
        return null;
    }
}