package com.iyad.msscbrewery.controller;

import com.iyad.msscbrewery.model.BeerDTO;
import com.iyad.msscbrewery.service.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    ResponseEntity<BeerDTO> getBeer(@PathVariable("beerId") UUID beerId){
         return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity handelPost( @RequestBody BeerDTO beerDTO){
        BeerDTO savedDto= beerService.savedNewBeer(beerDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        // todo add hostname to URL
        httpHeaders.add("Location","/api/v1/beer" + savedDto.getId().toString());
        return new ResponseEntity(httpHeaders,HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity handelPut(@PathVariable("beerId") UUID beerId,@RequestBody BeerDTO beerDTO){

        beerService.updateBeer(beerId,beerDTO);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerService.deleteBeerById(beerId);

    }
}
