package de.onpier.utills;

import com.opencsv.CSVReader;
import de.onpier.dto.BorrowedBook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class BorrowedDataLoader implements ICSVDataLoader {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<BorrowedBook> init(String borrowedDataFile) {
        List<BorrowedBook> borrowedBookList = new ArrayList<>();
        try {
            CSVReader csvReader = new CSVReader(new FileReader(borrowedDataFile));
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                if(values.length == 4 && values[0].length() != 0) {
                    borrowedBookList.add(populateData(values));
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            LOGGER.error("IOException: " + e.getMessage());
        }
        return borrowedBookList;
    }

    public BorrowedBook populateData(String[] data){
        Arrays.asList(data);
        return new BorrowedBook(data[0], data[1], data[2], data[3]);
    }
}
