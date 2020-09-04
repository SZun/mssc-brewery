package guru.springframework.msscbrewery.web.controller.v2;

import guru.springframework.msscbrewery.services.v2.BeerServiceV2;
import guru.springframework.msscbrewery.web.model.v2.BeerDTOV2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beers")
@RestController
@RequiredArgsConstructor
public class BeerControllerV2 {

    private final BeerServiceV2 beerServiceV2;

    @GetMapping({"/{id}"})
    public ResponseEntity<BeerDTOV2> getBeer(@PathVariable UUID id){
        return new ResponseEntity<>(beerServiceV2.getBeerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createBear(@RequestBody BeerDTOV2 beerDTO){
        BeerDTOV2 beer = beerServiceV2.createBeer(beerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beers/" + beer.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity handleUpdate(@PathVariable UUID id, @RequestBody BeerDTOV2 beerDTO){
        beerServiceV2.updateBeer(id, beerDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBeer(@PathVariable UUID id){
        beerServiceV2.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
