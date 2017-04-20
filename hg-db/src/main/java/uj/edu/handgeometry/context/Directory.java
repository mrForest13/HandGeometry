package uj.edu.handgeometry.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by mateusz ligeza on 20.04.2017.
 */
@Component
public class Directory {

    @Autowired
    @Value("${test.directory.data}")
    public String dataDirectory;

    @Autowired
    @Value("${test.directory.result}")
    public String resultDirectory;
}
