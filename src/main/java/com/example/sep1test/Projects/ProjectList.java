package com.example.sep1test.Projects;


import com.example.sep1test.Project;

import java.io.Serializable;
import java.util.ArrayList;

public class ProjectList implements Serializable {

    private final ArrayList<Project> projectList;

    public ProjectList() {
        projectList = new ArrayList<>();
    }

    public void add(Project project) {
        projectList.add(project);
    }

    public void remove(Project project) {
        projectList.remove(project);
    }

    public ArrayList<Project> getData() {
        return projectList;
    }

    @Override
    public String toString() {
        return "ProjectList{" +
                "projectList=" + projectList +
                '}';
    }
}
