package com.santanderdevweek.bootcamp.mapper;

import com.santanderdevweek.bootcamp.model.Stock;
import com.santanderdevweek.bootcamp.model.dto.StockDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockMapper {

    public Stock toEntity(StockDTO dto){
        Stock stock = new Stock();
        stock.setId(dto.getId());
        stock.setNameStock(dto.getNameStock());
        stock.setPrice(dto.getPrice());
        stock.setVariation(dto.getVariation());
        stock.setDateStock(dto.getDateStock());

        return stock;
    }

    public StockDTO toDto(Stock stock) {
        StockDTO dto = new StockDTO();
        dto.setId(stock.getId());
        dto.setNameStock(stock.getNameStock());
        dto.setPrice(stock.getPrice());
        dto.setVariation(stock.getVariation());
        dto.setDateStock(stock.getDateStock());

        return dto;
    }
   public List<StockDTO> listDto(List<Stock> listStock){
        return listStock.stream().map(this::toDto).collect(Collectors.toList());
   }
}
