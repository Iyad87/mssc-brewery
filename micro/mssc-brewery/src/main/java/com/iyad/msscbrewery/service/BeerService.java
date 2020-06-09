package com.iyad.msscbrewery.service;

import com.iyad.msscbrewery.model.BeerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public interface BeerService {
    BeerDTO getBeerById(UUID beerId);

    BeerDTO savedNewBeer(BeerDTO beerDTO);

    void updateBeer(UUID beerId, BeerDTO beerDTO);

    void deleteBeerById(UUID beerId);
}
