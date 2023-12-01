package com.example.sep1test;


import com.example.sep1test.DataPersistence.BinaryFilePersister;
import com.example.sep1test.DataPersistence.DataPersistence;
import com.example.sep1test.Projects.ProjectList;
import com.example.sep1test.Projects.Residential;

import java.io.IOException;

public class Main
{


  public static void main(String[] args) throws IOException {

    ProjectList projectList = new ProjectList();

    Residential residential = new Residential();

    projectList.add(residential);

    DataPersistence dataPersistence = new BinaryFilePersister();

    dataPersistence.save(projectList);



  }
}
