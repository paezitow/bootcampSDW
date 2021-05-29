package com.santanderdevweek.bootcamp.repository;


import com.santanderdevweek.bootcamp.model.Stock;
import com.santanderdevweek.bootcamp.model.dto.StockDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepo extends JpaRepository<Stock, Long> {

    Optional<Stock> findByNameStockAndDateStock(String nameStock, LocalDate dateStock);

    @Query("SELECT stock " +
            "FROM Stock stock " +
            "WHERE stock.nameStock = :name AND stock.dateStock = :date AND stock.id != :id")
    Optional<Stock> findByStockUpdate(String name, LocalDate date, Long id);

    @Query("SELECT stock " +
            "FROM Stock stock " +
            "WHERE  stock.dateStock = :date")
    Optional <List<Stock>> findByToday(LocalDate date);
}
