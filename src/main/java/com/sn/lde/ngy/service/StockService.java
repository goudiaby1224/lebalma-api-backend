package com.sn.lde.ngy.service;

import com.sn.lde.ngy.model.StockProduit;
import com.sn.lde.ngy.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public StockProduit findById(final Long id){
        return  stockRepository.findById(id).orElseThrow();
    }

    public Collection<StockProduit> findAll(){
        return  stockRepository.findAll();
    }

    public StockProduit save(StockProduit  stockProduit){
        return stockRepository.save(stockProduit);
    }

    public StockProduit update(StockProduit  stockProduit){
        StockProduit dbStock = stockRepository.findById(stockProduit.getId()).orElseThrow();
        dbStock.update(stockProduit);
        return stockRepository.save(dbStock);
    }


}
