package karpiuk.binance_mark_price.service;

import java.io.IOException;
import karpiuk.binance_mark_price.dto.MarkPriceResponse;

public interface CryptoService {
    MarkPriceResponse getPrice(String pair) throws IOException, InterruptedException;
}
