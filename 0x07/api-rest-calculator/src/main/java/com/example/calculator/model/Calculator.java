package com.example.calculator.model;

import java.time.LocalDate;

public class Calculator {

    public Double sum(Double number1, Double number2) {
        double resultado = number1 + number2;
        if(number1.isNaN() && number2.isNaN()){
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }else {
            return resultado;
        }
    }

    public Double sub(Double number1, Double number2) {
        Double resultado = number1 - number2;
        if(number1.isNaN() && number2.isNaN()){
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }else {
            return resultado;
        }
    }

    public Double divide (Double number1, Double number2)  {
        Double resultado = number1 / number2;
        if(number1.isNaN() && number2.isNaN()){
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }else if(number1 == 0 || number2 == 0){
            throw new ArithmeticException("Divisão por zero não é permitido.");
        }else {
            return resultado;
        }
    }

    public Integer factorial(Integer factorial) {
        Integer result = 1;
        if (factorial != null && factorial != 0) {
            for (int i=1; i <= factorial; i++){
                result = result * i;
            }
        } else {
            throw new NullPointerException("Número é obrigatório.");
        }
        return result;
    }

    public Integer integerToBinary(Integer integer) {
        String resultadoString = Integer.toBinaryString(integer);
        Integer result = Integer.parseInt(resultadoString);
        return result;
    }

    public String integerToHexadecimal(Integer integer) {
        String resultado = Integer.toHexString(integer);
        return resultado;
    }

    public int calculeDayBetweenDate(LocalDate date1, LocalDate date2) {
        int dias = date1.compareTo(date2);
        return dias;
    }
}
