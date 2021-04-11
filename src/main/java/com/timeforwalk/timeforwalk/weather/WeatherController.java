package com.timeforwalk.timeforwalk.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.timeforwalk.timeforwalk.city.City;
import com.timeforwalk.timeforwalk.city.CityService;
import java.io.IOException;
import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping(path = "api/v1/weather")
@ComponentScan("com.spring.restapi.config")
@AllArgsConstructor
public class WeatherController {

  private final CityService cityService;

  @GetMapping("/{city}")
  public ResponseEntity getWeatherForCity(@PathVariable("city") Long city)
      throws JsonProcessingException {

    City bristol = cityService.getBristol();
    UriComponents uriComponents = UriComponentsBuilder
        .newInstance()
        .scheme("http")
        .host("api.openweathermap.org/data/2.5/onecall")
        .path("")
        .query("lat={lat}&lon={lon}&appid={appid}&units=metric&exclude=daily,current,alerts,minutely")
        .buildAndExpand(bristol.getLat(), bristol.getLon(), "9a0b0d28a2525bfc34131287834bd2cb");

    String uri = uriComponents.toUriString();
    System.out.println(uri);
    RestTemplate restTemplate = new RestTemplate();

    ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);

    ObjectMapper om = new ObjectMapper();
    Root root = om.readValue(responseEntity.getBody(), Root.class);

    return null;
  }

  @GetMapping
  public void getWeatherData() throws IOException {

  }

}
