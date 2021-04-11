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
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Test {
//
//  public static void main(String[] args) throws IOException {
//
//    ObjectMapper om = new ObjectMapper();
//    Root root = om.readValue(new File(
//            "C:\\\\codebase\\\\training\\\\timeforwalk\\\\timeforwalk\\\\src\\\\main\\\\resources\\\\templates\\\\onecall-dup.json"),
//        Root.class);
//
//    System.out.println(root.lat + " -- " + root.lon);
//      getDryWeather(root.getHourly(), 7, 11,0D);
//
//    }
//  public static void getWetWeather(List<Hourly> hourlies) {
//    System.out.println("Hourly..");
//    for(Hourly h : hourlies){
//      if(h.pop != 0D) {
//        System.out.println("chances of rain at " + Instant.ofEpochSecond(h.dt));
//      }
//    }
//  }
//  public static void getDryWeather(List<Hourly> hourlies, double startHour, double endHour, double pop) {
//    List dryHours = new ArrayList<Integer>();
//    for(Hourly h : hourlies){
//      if(h.pop <= pop &&
//          LocalDateTime.ofInstant(Instant.ofEpochSecond(h.dt), ZoneOffset.UTC).getHour() >= startHour &&
//          LocalDateTime.ofInstant(Instant.ofEpochSecond(h.dt), ZoneOffset.UTC).getHour() <= endHour){
//          dryHours.add(LocalDateTime.ofInstant(Instant.ofEpochSecond(h.dt), ZoneOffset.UTC).getHour());
//      }
//    }
//    if(dryHours.size()!=0)  {
//      Collections.sort(dryHours);
//      System.out.println("dry weather from:" + dryHours.get(0) + " to " + dryHours.get(dryHours.size()-1));
//    }
//    else
//    {
//      System.out.println("No suitable dry weather found");
//    }
//  }
//
//
//  public static void getDryestWeather(List<Hourly> hourlies, double startHour, double endHour, double pop) {
//      for (Hourly h : hourlies) {
//        if (h.pop == pop &&
//            LocalDateTime.ofInstant(Instant.ofEpochSecond(h.dt), ZoneOffset.UTC).getHour() >= startHour &&
//            LocalDateTime.ofInstant(Instant.ofEpochSecond(h.dt), ZoneOffset.UTC).getHour() <= endHour) {
//          System.out.println("No chances of rain from " + Instant.ofEpochSecond(h.dt));
//        }else if(h.pop != pop &&
//            LocalDateTime.ofInstant(Instant.ofEpochSecond(h.dt), ZoneOffset.UTC).getHour() >= startHour &&
//            LocalDateTime.ofInstant(Instant.ofEpochSecond(h.dt), ZoneOffset.UTC).getHour() <= endHour){
//          System.out.println("chances of rain at : " + Instant.ofEpochSecond(h.dt));
//        }
//      }
//  }
//
//
//  public static void printDates(List<Hourly> hourlies) {
//    for(Hourly h : hourlies) {
//      System.out.println(Instant.ofEpochSecond(h.dt));
//      if (h.pop > 0) {
//        System.out.println("rain");
//      }
//    }
//  }



}
