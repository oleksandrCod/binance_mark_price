package karpiuk.binance_mark_price.exceptions;

public class JsonParsingException extends RuntimeException {
    public JsonParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}
