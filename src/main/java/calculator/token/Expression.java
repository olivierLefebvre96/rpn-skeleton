package calculator.token;

public abstract class Expression implements Token {
    protected final Token leftToken;
    protected final Token rightToken;

    protected Expression(Token leftToken, Token rightToken){
        this.leftToken = leftToken;
        this.rightToken = rightToken;
    }
}
