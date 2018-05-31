/*
  The expression be evaluated with this algorithem must be fully parenthese,
  and operand or operators need to be separated by space
  for example, ( 1 + ( ( 2 + 3 ) * ( 4 + 5 ) ) ) is valid,
  while (1 + (2*3) ) is not valid
 */
package com.hwp.study.algorithems;

import java.util.Stack;

public class Evaluation {
    private final String LEFT_PARENTHESES = "(";
    private final String RIGHT_PARENTHESES = ")";
    private final String OPERAND_PLUS = "+";
    private final String OPERAND_MINUS = "-";
    private final String OPERAND_MULTI = "*";
    private final String OPERAND_DIVISION = "/";
    private final String OPERAND_SQRT = "sqrt";

    public double evaluation(String exp){
        String[] opers = exp.split(" ");
        for(int i = 0; i < opers.length; i++){
            System.out.print(opers[i] + " ");
        }
        System.out.print ("= ");

        Stack<Double> vals = new Stack<Double>();
        Stack<String> operatorStack = new Stack<String>();
        for(int i = 0; i < opers.length; i++){
            if (opers[i].equals(LEFT_PARENTHESES)){
                continue;
            }

            if(opers[i].equals(OPERAND_PLUS) ||
                    opers[i].equals(OPERAND_MINUS) ||
                    opers[i].equals(OPERAND_MULTI) ||
                    opers[i].equals(OPERAND_DIVISION) ||
                    opers[i].equals(OPERAND_SQRT)){
                operatorStack.push(opers[i]);
                continue;
            }

            if (opers[i].equals(RIGHT_PARENTHESES)){
                 String operator = operatorStack.pop();
                 calculate(operator, vals);
                 continue;
            }

            vals.push(Double.parseDouble(opers[i]));
        }

        return vals.pop();
    }

    protected void calculate(String operator, Stack<Double> vals){
        Double val =  vals.pop();

        if (operator.equals(OPERAND_PLUS)){
            val = vals.pop() + val;
        } else if (operator.equals(OPERAND_MINUS)){
            val = vals.pop() - val;
        } else if (operator.equals(OPERAND_MULTI)){
            val = vals.pop() * val;
        } else if (operator.equals(OPERAND_DIVISION)){
            val = vals.pop() / val;
        } else if (operator.equals(OPERAND_SQRT)){
            val = Math.sqrt(val);
        }

        vals.push(val);
    }

    public static void main(String[] args){
        Evaluation evaluation = new Evaluation();
        String exp = "( 1 + ( ( 2 + 3 ) * ( 4 + 5 ) ) )";
        System.out.println(evaluation.evaluation(exp));

        exp = "( ( 2 * 3 ) + ( ( 4 * 5 ) * 6 ) )";
        System.out.println(evaluation.evaluation(exp));
    }
}
