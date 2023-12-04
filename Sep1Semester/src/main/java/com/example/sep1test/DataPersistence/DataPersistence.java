package com.example.sep1test.DataPersistence;

import com.example.sep1test.Projects.ProjectList;

import java.io.IOException;

public interface DataPersistence {

    void save(ProjectList projectList) throws IOException;

    ProjectList load() throws ClassNotFoundException, IOException;


}
