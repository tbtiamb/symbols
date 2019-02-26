package com;

import expressions.Expression;
import expressions.Expression;

import java.util.ArrayList;
import java.util.List;

public class Scanner {

    public List<Expression> splitInputString(String input) {
        List<String> elements = new ArrayList<>();

        for(String value : input.split("(?=[+|\\-|*|/|^|(|)])|(?<=[+|\\-|*|/|^|(|)])")){
            if(value.equals("")){
                continue;
            } else{
                elements.add(value);
            }
        }
        return elements;
    }
}
