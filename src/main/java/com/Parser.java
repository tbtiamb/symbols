package com;

import expressions.*;
import expressions.Number;

public class Parser {

    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    public static boolean isSymbol(char ch) {
        return ch == 'a' || ch == 'b' || ch == 'c';
    }

    public static boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static Expression getExpression(Expression right) {
        if (right instanceof Symbol) {
            return new Symbol(right);
        }
        if (right instanceof Number) {
            return new Number(right);
        }
        if (right instanceof FractionalExpression) {
            return new FractionalExpression(right);
        }
        if (right instanceof SummedExpression) {
            return new SummedExpression(right);
        }
        return null;
    }
}
