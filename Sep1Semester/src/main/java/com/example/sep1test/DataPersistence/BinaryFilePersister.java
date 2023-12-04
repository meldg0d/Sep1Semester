package com.example.sep1test.DataPersistence;
import com.example.sep1test.Projects.ProjectList;

import java.io.*;


public class BinaryFilePersister implements DataPersistence{

    private final File file;


    public BinaryFilePersister() {
        file = new File("data.bin");
    }

    @Override
    public void save(ProjectList projectList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(projectList);
        outputStream.flush();
        outputStream.close();
    }

    @Override
    public ProjectList load() throws ClassNotFoundException, IOException {
        ProjectList projectList;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            projectList = new ProjectList();
            return projectList;
        }
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        projectList = (ProjectList) objectInputStream.readObject();
        objectInputStream.close();
        return projectList;
    }
}

