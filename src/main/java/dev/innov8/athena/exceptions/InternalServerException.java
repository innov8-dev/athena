package dev.innov8.athena.exceptions;

/**
 * @author Wezley Singleton (GitHub: wsingleton)
 */
public class InternalServerException extends RuntimeException {

    public InternalServerException() {
        super("An unexpected exception has occurred.");
    }

    public InternalServerException(String s) {
        super(s);
    }

    public InternalServerException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
