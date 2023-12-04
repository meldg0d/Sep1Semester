package com.example.sep1test.Projects;

import com.example.sep1test.Project;

public class Industrial extends Project
{
  private int size;
  private String type;

  public Industrial(String nameOfProject, String budget, int timeline, int size, String type)
  {
    super(nameOfProject,budget, timeline);
    this.size = size;
    this.type = type;
  }

  public int getSize()
  {
    return size;
  }

  public void setSize(int size)
  {
    this.size = size;
  }

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }
}
