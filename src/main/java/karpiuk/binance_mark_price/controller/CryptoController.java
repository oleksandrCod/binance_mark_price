package karpiuk.binance_mark_price.controller;

import java.io.IOException;
import karpiuk.binance_mark_price.dto.MarkPriceResponse;
import karpiuk.binance_mark_price.service.CryptoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CryptoController {

    private final CryptoService cryptoService;

    @GetMapping("/price/{pair}")
    public ResponseEntity<MarkPriceResponse> getPrice(@PathVariable String pair) throws IOException, InterruptedException {
        return ResponseEntity.status(HttpStatus.FOUND).body(cryptoService.getPrice(pair));
    }
}
