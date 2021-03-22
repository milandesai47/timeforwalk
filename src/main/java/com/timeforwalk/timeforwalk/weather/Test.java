package com.timeforwalk.timeforwalk.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class Test {

  public static void main(String[] args) throws IOException {

    ObjectMapper om = new ObjectMapper();
    Root root = om.readValue(new File(
            "C:\\\\codebase\\\\training\\\\timeforwalk\\\\timeforwalk\\\\src\\\\main\\\\resources\\\\templates\\\\onecall.json"),
        Root.class);

    System.out.println(root.lat + " -- " + root.lon);
    getWetWeather(root.getHourly());
    getDryWeather(root.getHourly());

    }
  public static void getWetWeather(List<Hourly> hourlies) {
    System.out.println("Hourly..");
    for(Hourly h : hourlies){
      if(h.rain != null) {
        System.out.println("chances of rain at " + Instant.ofEpochSecond(h.dt));
        System.out.println(h.rain.get_1h());
      }
    }
  }
  public static void getDryWeather(List<Hourly> hourlies) {
    System.out.println("Hourly..");
    for(Hourly h : hourlies){
      if(h.rain == null) {
        System.out.println("No chances of rain at " + Instant.ofEpochSecond(h.dt));
      }
    }
  }



}
