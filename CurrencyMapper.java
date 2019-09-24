package com.hpdlendscape.assetfinance.engine.services.mappers;

import com.hpdlendscape.assetfinance.engine.infrastructure.database.meta.Currency;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import shared.dto.meta.CurrencyDTO;

/**
 * com.hpdlendscape.assetfinance.engine.services.mappers.CurrencyMapper, created on 24/09/2019 10:38 <p>
 * @author AlessandroA
 */
@Mapper
public interface CurrencyMapper {

  CurrencyMapper INSTANCE = Mappers.getMapper(CurrencyMapper.class);

  CurrencyDTO convertToDTO(Currency currency);

  Currency convertToEntity(CurrencyDTO currencyDTO);
}
