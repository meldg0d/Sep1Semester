package com.example.sep1test.Projects;

import com.example.sep1test.Project;

public class Residential extends Project
{
  private double size;
  private int numberOfKitchens;
  private int numberOfBathrooms;

  private int numberOfPlumbingRooms;
  private boolean isNewBuild;

  public Residential(){
    this.size = 0;
    this.numberOfKitchens = 0;
    this.numberOfBathrooms = 0;
    this.numberOfPlumbingRooms = 0;
    this.isNewBuild = true;
  }


  public Residential(String nameOfProject,String budget, int timeline, double size,
      int numberOfKitchens, int numberOfBathrooms, int numberOPlumbingRooms, boolean isNewBuild)
  {
    super(nameOfProject,budget,timeline);
    this.size = size;
    this.numberOfKitchens = numberOfKitchens;
    this.numberOfBathrooms = numberOfBathrooms;
    this.numberOfPlumbingRooms = numberOPlumbingRooms;
    this.isNewBuild = true;
  }
  public double getSize()
  {
    return size;
  }

  public void setSize(double size)
  {
    this.size = size;
  }

  public int getNumberOfKitchens()
  {
    return numberOfKitchens;
  }

  public void setNumberOfKitchens(int numberOfKitchens)
  {
    this.numberOfKitchens = numberOfKitchens;
  }

  public int getNumberOfBathrooms()
  {
    return numberOfBathrooms;
  }

  public void setNumberOfBathrooms(int numberOfBathrooms)
  {
    this.numberOfBathrooms = numberOfBathrooms;
  }

  public int getNumberOfPlumbingRooms()
  {
    return numberOfPlumbingRooms;
  }

  public void setNumberOfPlumbingRooms(int numberOfPlumbingRooms)
  {
    this.numberOfPlumbingRooms = numberOfPlumbingRooms;
  }

  public void setNewBuild(boolean newBuild)
  {
    isNewBuild = newBuild;
  }

  @Override
  public String toString() {
    return "Residential{" +
            "size=" + size +
            ", numberOfKitchens=" + numberOfKitchens +
            ", numberOfBathrooms=" + numberOfBathrooms +
            ", numberOfPlumbingRooms=" + numberOfPlumbingRooms +
            ", isNewBuild=" + isNewBuild +
            '}'+ "Project{" +
            "nameOfProject='" + getNameOfProject() + '\'' +
            ", budget=" + getBudget() +
            ", timeline=" + getTimeline() +
            '}';
  }
}
