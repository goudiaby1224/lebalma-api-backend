package com.sn.lde.ngy.rest;

import com.sn.lde.ngy.model.StockProduit;
import com.sn.lde.ngy.service.StockService;
import com.sn.lde.ngy.utils.ConstantsPath;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(ConstantsPath.MAIN_LEBALMA_PATH+"stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockProduit> findbyId(@PathVariable("id") final Long id){
        return ResponseEntity.ok(stockService.findById(id));
    }

    @PostMapping
    public ResponseEntity<StockProduit> save(@RequestBody StockProduit stockProduit){
        return  ResponseEntity.ok(stockService.save(stockProduit));
    }

    @PutMapping
    public ResponseEntity<StockProduit> update(@RequestBody StockProduit stockProduit){
        return  ResponseEntity.ok(stockService.update(stockProduit));
    }

    @GetMapping
    public ResponseEntity<Collection<StockProduit>> findAll(){
        return ResponseEntity.ok(stockService.findAll());
    }



}
