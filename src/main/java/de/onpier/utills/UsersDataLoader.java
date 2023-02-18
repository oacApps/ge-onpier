package de.onpier.utills;

import com.opencsv.CSVReader;
import de.onpier.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class UsersDataLoader implements ICSVDataLoader {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<User> init(String userDataFile) {
        List<User> userList = new ArrayList<>();
        try {
            CSVReader csvReader = new CSVReader(new FileReader(userDataFile));
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                if(values.length == 5 && values[0].length() != 0) {
                    userList.add(populateData(values));
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            LOGGER.error("IOException: " + e.getMessage());
        }
        return userList;
    }

    public User populateData(String[] data){
        Arrays.asList(data);
        return new User(data[0], data[1], data[2], data[3], data[4]);
    }
}
