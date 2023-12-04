package com.example.sep1test;


import java.io.Serializable;

public abstract class Project implements Serializable
{
  private String nameOfProject;
  private String budget;
  private int timeline;

  public Project(){
    this.nameOfProject = "Project";
    this.budget = "20";
  }

   public Project(String nameOfProject, String budget, int timeline)
  {
    this.budget = budget;
    this.timeline = timeline;
    this.nameOfProject = nameOfProject;
  }


  public String getNameOfProject() {
    return nameOfProject;
  }

  public void setNameOfProject(String nameOfProject) {
    this.nameOfProject = nameOfProject;
  }

  public String getBudget()
  {
    return budget;
  }


  public void setBudget(String budget) {
    this.budget = budget;
  }

  public int getTimeline()
  {
    return timeline;
  }

  public void setTimeline(int timeline)
  {
    this.timeline = timeline;
  }


  @Override
  public String toString() {
    return "Project{" +
            "nameOfProject='" + nameOfProject + '\'' +
            ", budget=" + budget +
            ", timeline=" + timeline +
            '}';
  }
}
