package fileRead;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;


import java.util.Collections;
import java.util.List;
import java.util.ArrayList;



public class fileHandler {

    private static final String filesFolder = "data";
    //variable that stores file name for data.

    public List<String> getFiles() {
    //method to get files in data folder

        List<String> fileNmaes = new ArrayList<>();
        Path folderPath = Paths.get(filesFolder);

        if (!(Files.exists(folderPath))) {
            throw new RuntimeException("folder not found");
        }//check if file exists

        for(Path path : folderPath ){
            if(Files.isRegularFile(path)){
                fileNmaes.add(path.getFileName().toString());
            }
        }//add files to List.

        return fileNmaes;
    }


}
