package dev.innov8.athena.exceptions;

/**
 * @author Wezley Singleton (GitHub: wsingleton)
 */
public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(String s) {
        super(s);
    }

    public InvalidRequestException(String s, Throwable throwable) {
        super(s, throwable);
    }

}
