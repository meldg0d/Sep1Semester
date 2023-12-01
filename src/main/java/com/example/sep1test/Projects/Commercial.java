package com.example.sep1test.Projects;

import com.example.sep1test.Project;

public class Commercial extends Project
{
  private double sizeOfTheBuilding;
    private int numberOfFloors;
  private String intendedUse;

  public Commercial(String nameOfProject, String budget, int timeline, double size,
      int numberOfFloors, String intendedUse)
  {
    super(nameOfProject, budget, timeline);
    this.sizeOfTheBuilding = sizeOfTheBuilding;
    this.numberOfFloors = numberOfFloors;
    this.intendedUse = intendedUse;
  }

  public double getSize()
  {
    return sizeOfTheBuilding;
  }

  public void setSize(double size)
  {
    this.sizeOfTheBuilding = size;
  }

  public int getNumberOfFloors()
  {
    return numberOfFloors;
  }

  public void setNumberOfFloors(int numberOfFloors)
  {
    this.numberOfFloors = numberOfFloors;
  }

  public String getIntendedUse()
  {
    return intendedUse;
  }

  public void setIntendedUse(String intendedUse)
  {
    this.intendedUse = intendedUse;
  }
}
