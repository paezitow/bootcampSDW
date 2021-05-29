package com.santanderdevweek.bootcamp.service;


import com.santanderdevweek.bootcamp.exceptions.BusinessException;
import com.santanderdevweek.bootcamp.exceptions.NotFoundException;
import com.santanderdevweek.bootcamp.mapper.StockMapper;
import com.santanderdevweek.bootcamp.model.Stock;
import com.santanderdevweek.bootcamp.model.dto.StockDTO;
import com.santanderdevweek.bootcamp.repository.StockRepo;
import com.santanderdevweek.bootcamp.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.NotActiveException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class StockService {

    @Autowired
    private StockRepo repository;

    @Autowired
    private StockMapper mapper;

    @Transactional
    public StockDTO save(StockDTO dto) {
        Optional<Stock> optionalStock = repository.findByNameStockAndDateStock(dto.getNameStock(), dto.getDateStock());
        if(optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }

        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);

    }

    @Transactional
    public StockDTO update(StockDTO dto) {
        Optional<Stock> optionalStock = repository.findByStockUpdate(dto.getNameStock(), dto.getDateStock(), dto.getId());
        if(optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }

        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);
    }

    @Transactional(readOnly = true)
    public List<StockDTO> findAll() {

        return mapper.listDto(repository.findAll());
    }
    @Transactional(readOnly = true)
    public StockDTO findByID(Long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public StockDTO delete(Long id) {
        StockDTO dto = this.findByID(id);
        repository.deleteById(dto.getId());
        return dto;
    }

    @Transactional(readOnly = true)
    public List<StockDTO> findByToday() {
        return repository.findByToday(LocalDate.now()).map(mapper::listDto).orElseThrow(NotFoundException::new);
    }
}
