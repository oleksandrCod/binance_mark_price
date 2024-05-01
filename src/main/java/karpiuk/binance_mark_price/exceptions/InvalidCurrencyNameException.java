package karpiuk.binance_mark_price.exceptions;

public class InvalidCurrencyNameException extends RuntimeException {
    public InvalidCurrencyNameException(String message) {
        super(message);
    }
}
