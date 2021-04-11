package com.timeforwalk.timeforwalk.city;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/city")
public class CityController {

  @GetMapping
  public List<City> getAllCities(){
    List<City> cities = Arrays.asList(
        new City(1L,"Bristol",  "-2.587910", "51.454514"),
        new City(2L,"London",  "-0.118092", "51.509865")
    );
    return cities;
  }

  @GetMapping("/find/bristol")
  public City getCityByName(){
    return new City(1L,"Bristol",  "-2.587910", "51.454514");
  }
}
