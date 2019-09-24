package com.hpdlendscape.assetfinance.engine.mappers;

import com.hpdlendscape.assetfinance.engine.services.mappers.CurrencyMapper;
import com.hpdlendscape.assetfinance.engine.infrastructure.database.meta.Currency;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import shared.dto.meta.CurrencyDTO;

import java.util.stream.IntStream;

/**
 * com.hpdlendscape.assetfinance.engine.mappers.MapperPerformanceTest, created on 24/09/2019 13:30 <p>
 * @author AlessandroA
 */
public class MapperPerformanceTest {

  @Test
  public void testModelMapperPerformances() {
    ModelMapper modelMapper = new ModelMapper();
    Currency currency = new Currency("AAA", "Test currency 1");
    long startTime = System.currentTimeMillis();
    IntStream.range(0, 10000).forEach(e -> {
      CurrencyDTO currencyDTO = modelMapper.map(currency, CurrencyDTO.class);
    });
    long endTime = System.currentTimeMillis();
    long modelMapperResult = endTime - startTime;

    startTime = System.currentTimeMillis();
    IntStream.range(0, 10000).forEach(e -> {
      CurrencyDTO currencyDTO = CurrencyMapper.INSTANCE.convertToDTO(currency);
    });
    endTime = System.currentTimeMillis();
    long mapStructResult = endTime - startTime;

    System.out.println("ModelMapper: " + modelMapperResult);
    System.out.println("MapStruct: " + mapStructResult);
  }
}
