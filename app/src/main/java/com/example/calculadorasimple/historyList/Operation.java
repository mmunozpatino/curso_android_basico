package com.example.calculadorasimple.historyList;

public class Operation {

    private String result, operator1, operator2;

    public Operation() {
    }

    public Operation(String result, String operator1, String operator2) {
        this.result = result;
        this.operator1 = operator1;
        this.operator2 = operator2;
    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getOperator1() {
        return operator1;
    }

    public void setOperator1(String operator1) {
        this.operator1 = operator1;
    }

    public String getOperator2() {
        return operator2;
    }

    public void setOperator2(String operator2) {
        this.operator2 = operator2;
    }
}
