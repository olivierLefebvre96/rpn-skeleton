package calculator;

import calculator.token.Interpretor;

public class Main {
    public static void main(String[] args) {
        String tokenString1 = "7 3 - 2 1 + *";
        String tokenString2 = "22 11 /";
        String tokenString3 = "10 2 / 2 /";
        String tokenString4 = "5 d+";

        Interpretor.interpret(tokenString1);
        Interpretor.interpret(tokenString2);
        Interpretor.interpret(tokenString3);
        Interpretor.interpret(tokenString4);
    }
}
