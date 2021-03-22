package com.timeforwalk.timeforwalk.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
class Root{
 public double lat;
 public double lon;
 public String timezone;
 public int timezone_offset;
 public List<Hourly> hourly;
}

@Getter
@Setter
@ToString
@EqualsAndHashCode
class Hourly{
 public int dt;
 public double temp;
 public double feels_like;
 public int pressure;
 public int humidity;
 public double dew_point;
 public double uvi;
 public int clouds;
 public int visibility;
 public double wind_speed;
 public int wind_deg;
 public double wind_gust;
 public List<Weather> weather;
 public double pop;
 public Rain rain;
}

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Weather{
  public int id;
  public String main;
  public String description;
  public String icon;
}

@Getter
@Setter
@ToString
@EqualsAndHashCode
 class Rain{
  @JsonProperty("1h")
  public double _1h;
}

@Getter
@Setter
@ToString
@EqualsAndHashCode
class Snow{
 @JsonProperty("1h")
 public double _1h;
}





