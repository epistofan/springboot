package hello;


import hello.domain.Equation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CalculatorController {

@Autowired
ExpressionParser expressionParser;


    @PostMapping("/calculator")
    public String eq(@RequestParam String expression, Map<String, Object> model){

        Equation equation = new Equation();
        equation.setEquation(expression);
        String results = expressionParser.parse(equation);
        System.out.println("post "+ results);

        model.put("ravno", results);

        return  "calculator";
    }
}
