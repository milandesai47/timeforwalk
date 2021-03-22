package com.timeforwalk.timeforwalk.weather;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/weather")
public class WeatherController {
//
//  @GetMapping("/{city}")
//  public ResponseEntity getWeatherForCity(@PathVariable("city") String city){
//
//    UriComponents uriComponents = UriComponentsBuilder
//        .newInstance()
//        .scheme("http")
//        .host("api.openweathermap.org/data/2.5/onecall")
//        .path("")
//        .query("?lat={lat}&lon={lon}&appid={appid}&units=metric")
//        .buildAndExpand("london", "9a0b0d28a2525bfc34131287834bd2cb");
//
//    String uri = uriComponents.toUriString();
//    System.out.println(uri);
//    return null;
//  }

  @GetMapping
  public void getWeatherData() throws IOException {

  }

}
