package karpiuk.binance_mark_price.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import karpiuk.binance_mark_price.dto.MarkPriceResponse;
import karpiuk.binance_mark_price.exceptions.InvalidCurrencyNameException;
import karpiuk.binance_mark_price.exceptions.JsonParsingException;
import karpiuk.binance_mark_price.exceptions.RequestException;
import karpiuk.binance_mark_price.mapper.MarkPriceMapper;
import karpiuk.binance_mark_price.model.ApiPairResponse;
import karpiuk.binance_mark_price.service.CryptoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CryptoServiceImpl implements CryptoService {
    @Value("${binance.url}")
    private String baseUrl;
    private final ObjectMapper objectMapper;
    private final HttpClient client;
    private final MarkPriceMapper priceMapper;

    @Override
    public MarkPriceResponse getPrice(String pair) {
        return priceMapper.toDto(fetchCurrencyPrice(pair));
    }

    private ApiPairResponse fetchCurrencyPrice(String pair) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + pair))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RequestException("Can't fetch currency price", e);
        }
        if (response.statusCode() == 200) {
            try {
                return objectMapper.readValue(response.body(), ApiPairResponse.class);
            } catch (JsonProcessingException e) {
                throw new JsonParsingException("Can't map json value to object", e);
            }

        }
        throw new InvalidCurrencyNameException("Provided currency name is not valid.");
    }
}
