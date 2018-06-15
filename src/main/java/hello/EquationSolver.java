package hello;


import hello.domain.Equation;
import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class EquationSolver {

    public String result;

    float n1;
    float n2;
    String op;

    String solve(Results results) {

        Stack<String> cifri = new Stack<String>();
        Stack<String> temp1 = new Stack<String>();
        Stack<String> oper = new Stack<String>();
        Stack<String> cifri2 = new Stack<String>();
        Stack<String> cifriTemp = new Stack<String>();
        Stack<String> oper2 = new Stack<String>();
        Stack<String> operTemp = new Stack<String>();
        Stack<String> postfix = new Stack<String>();
        Stack<String> tempOper = new Stack<String>();


                System.out.println("start");

                for (int i = 0; i < results.operands.length; i++) {
                    cifri.push(results.operands[i]);

                }
                while (!cifri.isEmpty()) {
                    cifri2.push(cifri.pop());

                }
                for (int z = 0; z < results.operators.length; z++) {
                    oper.push(results.operators[z]);
                    System.out.println("drjuk" + oper.peek());

                }
                while (!oper.isEmpty()) {
                    oper2.push(oper.pop());
                    System.out.println("drjuk2" + oper2.peek());
                }


                System.out.println("start2");

                while (!oper2.isEmpty()) {
                    //postfix.push(cifri2.pop());
                    System.out.println("cikl");


                    op = oper2.pop();
                    n1 = Float.valueOf(cifri2.pop());

                    if (op.equals("-") | op.equals("+")) {
                        operTemp.push(op);
                        cifriTemp.push(String.valueOf(n1));
                        if (oper2.isEmpty()) {
                            System.out.println("pusto");
                            cifriTemp.push(cifri2.pop());
                        }


                    } else if (op.equals("/") | op.equals("*")) {

                        switch (op) {
                            case "/":
                                System.out.println("//");
                                n2 = Float.valueOf(cifri2.pop());

                                cifri2.push(String.valueOf(n1 / n2));

                                break;
                            case "*":
                                System.out.println("**");
                                n2 = Float.valueOf(cifri2.pop());
                                cifri2.push(String.valueOf(n2 * n1));

                                break;
                        }


                        System.out.println(cifri2.peek());


                    }
                }

                while (!cifriTemp.isEmpty()) {
                    cifri2.push(cifriTemp.pop());
                }

                while (!operTemp.isEmpty()) {
                    oper2.push(operTemp.pop());
                }

                while (!oper2.isEmpty()) {
                    op = oper2.pop();
                    n1 = Float.valueOf(cifri2.pop());
                    if (op.equals("-") | op.equals("+")) {
                        switch (op) {
                            case "-":
                                System.out.println("-");
                                n2 = Float.valueOf(cifri2.pop());
                                cifri2.push(String.valueOf(n1 - n2));
                                break;
                            case "+":
                                System.out.println("+");
                                n2 = Float.valueOf(cifri2.pop());
                                cifri2.push(String.valueOf(n1 + n2));
                                break;
                        }
                    }
                }
                System.out.println(cifri2.peek());
                System.out.println("start3");


result = cifri2.peek();





        return result;
    }
}
