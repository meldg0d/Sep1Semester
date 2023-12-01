package com.example.sep1test.Projects;

import com.example.sep1test.Project;

public class Road extends Project
{
  private double length, width;
  private int numberOfTunnels,numberOfBridges;
  private String complications;

  public Road(String nameOfProject, String budget, int timeline, double length, double width,
      int numberOfTunnels, int numberOfBridges, String complications)
  {
    super(nameOfProject, budget, timeline);
    this.length = length;
    this.width = width;
    this.numberOfTunnels = numberOfTunnels;
    this.numberOfBridges = numberOfBridges;
    this.complications = complications;
  }

  public double getLength()
  {
    return length;
  }

  public void setLength(double length)
  {
    this.length = length;
  }

  public double getWidth()
  {
    return width;
  }

  public void setWidth(double width)
  {
    this.width = width;
  }

  public int getNumberOfTunnels()
  {
    return numberOfTunnels;
  }

  public void setNumberOfTunnels(int numberOfTunnels)
  {
    this.numberOfTunnels = numberOfTunnels;
  }

  public int getNumberOfBridges()
  {
    return numberOfBridges;
  }

  public void setNumberOfBridges(int numberOfBridges)
  {
    this.numberOfBridges = numberOfBridges;
  }

  public String getComplications()
  {
    return complications;
  }

  public void setComplications(String complications)
  {
    this.complications = complications;
  }
}
