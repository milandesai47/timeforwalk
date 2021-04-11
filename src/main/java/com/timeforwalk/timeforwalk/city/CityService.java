package com.timeforwalk.timeforwalk.city;

import org.springframework.stereotype.Service;

@Service
public class CityService {

  public City getBristol(){
    return new City(1L,"Bristol",  "-2.587910", "51.454514");
  }

}
