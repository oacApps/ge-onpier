package de.onpier.utills;

import com.opencsv.CSVReader;
import de.onpier.dto.Book;
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
public class BooksDataLoader implements ICSVDataLoader {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<Book> init(String booksDataFile) {
        List<Book> bookList = new ArrayList<>();
        try {
            CSVReader csvReader = new CSVReader(new FileReader(booksDataFile));
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                if(values.length == 4 && values[0].length() != 0) {
                    bookList.add(populateData(values));
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            LOGGER.error("IOException: " + e.getMessage());
        }
        return bookList;
    }

     public Book populateData(String[] data){
        Arrays.asList(data);
        return new Book(data[0], data[1], data[2], data[3]);
    }
}
