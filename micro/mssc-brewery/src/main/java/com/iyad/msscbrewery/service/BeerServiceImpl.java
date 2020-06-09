package com.iyad.msscbrewery.service;

import com.iyad.msscbrewery.model.BeerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return BeerDTO.builder().id(UUID.randomUUID())
                .beerName("Amstel")
                .beetStyle("Non-Alchol")
                .build();
    }

    @Override
    public BeerDTO savedNewBeer(BeerDTO beerDTO) {
        return BeerDTO
                .builder()
                .id(UUID.randomUUID()
                ).build();

    }

    @Override
    public void updateBeer(UUID beerId, BeerDTO beerDTO) {
        // todo update beer DTO
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        // to delete beer
        log.debug("Deleting Beer ....");

    }
}
