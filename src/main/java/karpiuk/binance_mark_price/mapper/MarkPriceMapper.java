package karpiuk.binance_mark_price.mapper;

import karpiuk.binance_mark_price.config.MapperConfiguration;
import karpiuk.binance_mark_price.dto.MarkPriceResponse;
import karpiuk.binance_mark_price.model.ApiPairResponse;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface MarkPriceMapper {
    MarkPriceResponse toDto(ApiPairResponse apiResponse);
}
