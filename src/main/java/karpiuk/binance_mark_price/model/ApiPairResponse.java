package karpiuk.binance_mark_price.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class ApiPairResponse implements Serializable {
    private String symbol;
    private String markPrice;
    private String indexPrice;
    private String estimatedSettlePrice;
    private String lastFundingRate;
    private String nextFundingTime;
    private String interestRate;
    private String time;
}
