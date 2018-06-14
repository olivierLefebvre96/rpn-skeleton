package calculator.token;

public class Tokenizer {
    public String[] extractTokensIntoArray(String tokens){
        String[] tokenArray = getStringToEvaluate(tokens);

        if (tokenArray == null) return null;

        return tokenArray;
    }

    /**
     * Process the string to evaluate by returning it into an array of Strings
     * @param stringToEvaluate The input String to evaluate
     * @return The Input String Array or null if error
     */
    private static String[] getStringToEvaluate(String stringToEvaluate) {
        if(stringToEvaluate.isEmpty()) {
            System.out.println("Insufficient number of characters to interpret.");
            return null;
        }

        if(containsIncorrectToken(stringToEvaluate)) {
            System.out.println("String to parse contains incorrect tokens such as letters which are currently not supported.");
            return null;
        }

        String[] tokenArray = stringToEvaluate.split(" ");

        if(tokenArray.length <= 0) {
            System.out.println("Insufficient number of tokens to interpret.");
            return null;
        }

        return tokenArray;
    }

    /**
     * Checks for incorrect and/or unknown tokens
     * @param stringToParse String to parse for incorrect tokens
     * @return Does it contains incorrect tokens or not?
     */
    private static boolean containsIncorrectToken(String stringToParse){
        return !stringToParse.matches("[\\d\\s-*/+]+");
    }

}
