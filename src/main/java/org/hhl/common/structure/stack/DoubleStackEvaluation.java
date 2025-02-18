package org.hhl.common.structure.stack;

import java.util.Stack;

public class DoubleStackEvaluation {
    // 只能从头就用括号括起来的
    public static double evaluate(String expression) {
        Stack<Double> values = new Stack<>();
        // 用于存储运算符的栈
        Stack<String> operators = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (String.valueOf(ch).equals("(")) ;
            else if (String.valueOf(ch).equals("+") || String.valueOf(ch).equals("-") ||
                    String.valueOf(ch).equals("*") || String.valueOf(ch).equals("/")) {
                operators.push(String.valueOf(ch));
            } else if (String.valueOf(ch).equals(")")) {
                String pop = operators.pop();
                Double v = values.pop();
                if (pop.equals("+")) {
                    v = values.pop()+v;
                }
                if (pop.equals("-")) {
                    v =values.pop()-v;
                }
                if (pop.equals("*")) {
                    v = values.pop()*v;
                }
                if (pop.equals("/")) {
                    v =  values.pop()/v;
                }
                values.push(v);
            } else {
                values.push(Double.valueOf(String.valueOf(ch)));
            }
        }
        return values.pop();
    }

    public static void main(String[] args) {
        System.out.println(evaluate("(8*(1+3))"));
    }
}
