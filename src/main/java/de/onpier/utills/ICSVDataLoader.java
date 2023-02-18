package de.onpier.utills;

import java.util.List;

public interface ICSVDataLoader {
    List<?> init(String dataFile);
    Object populateData(String[] data);
}
