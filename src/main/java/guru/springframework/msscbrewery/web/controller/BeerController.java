package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.web.model.BeerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
@Deprecated
@RequestMapping("/api/v1/beers")
@RestController
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{id}")
    public ResponseEntity<BeerDTO> getBeer(@PathVariable UUID id){
        return new ResponseEntity<>(beerService.getBeerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createBear(@Valid @RequestBody BeerDTO beerDTO){
        BeerDTO beer = beerService.createBeer(beerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beers/" + beer.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity handleUpdate(@PathVariable UUID id, @Valid @RequestBody BeerDTO beerDTO){
        beerService.updateBeer(id, beerDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBeer(@PathVariable UUID id){
        beerService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
