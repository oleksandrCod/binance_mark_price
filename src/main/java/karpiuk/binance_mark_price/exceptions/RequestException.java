package karpiuk.binance_mark_price.exceptions;

public class RequestException extends RuntimeException {
    public RequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
