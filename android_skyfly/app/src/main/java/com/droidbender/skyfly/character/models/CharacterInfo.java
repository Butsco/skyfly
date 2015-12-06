package com.droidbender.skyfly.character.models;

import java.util.ArrayList;

public class CharacterInfo {

  public String name;

  public String image;

  public String background;

  public ArrayList<Family> family;

  public House house;

  public String religion;

  public String culture;

  public String quote;

  public String actor;

  public String introduction;

  public String biography;

  public class Family {

    public String name;

    public String relation;

    public String image;
  }

  public class House {

    public String name;

    public String image;
  }
}
