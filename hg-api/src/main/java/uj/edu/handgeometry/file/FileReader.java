package uj.edu.handgeometry.file;

import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mateusz ligeza on 05.03.2017.
 */
public class FileReader {

    public static List<String> getAll(String directoryPath) {

        List<String> filesInFolder = null;

        try {
            filesInFolder = Files.walk(Paths.get(directoryPath))
                    .filter(Files::isRegularFile)
                    .map(x -> FilenameUtils.removeExtension(x.getFileName().toString()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filesInFolder;
    }

}

