package com.hwp.study.algorithems;

import java.util.Stack;

public class EvaluationDeluxe extends Evaluation{
    private final String LEFT_PARENTHESES = "(";
    private final String RIGHT_PARENTHESES = ")";
    private final String OPERAND_PLUS = "+";
    private final String OPERAND_MINUS = "-";
    private final String OPERAND_MULTI = "*";
    private final String OPERAND_DIVISION = "/";
    private final String OPERAND_SQRT = "sqrt";

    public double evaluation(String exp){
        String[] opers = exp.split(" ");

        Stack<String> lowerOperator = new Stack<String>();
        Stack<String> higherOperator = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        for (int i = 0; i < opers.length; i++){
            if (opers[i].equals(LEFT_PARENTHESES)){
               i++;
               while(! opers[i].equals(RIGHT_PARENTHESES)){
                   parse(opers[i], lowerOperator, higherOperator, vals);
                   i++;
               }
               continue;
            }

            parse(opers[i], lowerOperator, higherOperator, vals);
        }

        while(! lowerOperator.isEmpty()){
            String operator = lowerOperator.pop();
            calculate(operator, vals);
        }

        return vals.pop();
    }

    private void parse(String oper, Stack<String> lowerOperator, Stack<String> higherOperator, Stack<Double> vals){
        if (! higherOperator.isEmpty()){
            vals.push(Double.parseDouble(oper));
            String operator = higherOperator.pop();
            calculate(operator, vals);
            return;
        }

        if(oper.equals(OPERAND_MULTI) ||
                oper.equals(OPERAND_DIVISION) ||
                oper.equals(OPERAND_SQRT)){
            higherOperator.push(oper);
            return;
        }

        if(oper.equals(OPERAND_PLUS) ||
                oper.equals(OPERAND_MINUS)){
            lowerOperator.push(oper);
            return;
        }

        vals.push(Double.parseDouble(oper));
    }

    public static void main(String[] args){
        EvaluationDeluxe evaluation = new EvaluationDeluxe();
        String exp = "1 + 2 * 3 + 4 * 5";
        System.out.println(evaluation.evaluation(exp));

        exp = "2 * ( 3 + 4 ) * 5 * 6";
        System.out.println(evaluation.evaluation(exp));
    }
}
