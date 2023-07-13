package com.lambdatest.lambdaselenideproject.configuration;

import org.openqa.selenium.InvalidElementStateException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {

    public static Properties getPropertiesFromFile(String filename) {
        InputStream inputStream = null;
        Properties properties = new Properties();

        try {
            inputStream = ConfigFileReader.class
                    .getClassLoader()
                    .getResourceAsStream(filename);
            if (inputStream != null) {
                properties.load(inputStream);

            } else {
                throw new FileNotFoundException("File was not found: " + filename);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new InvalidElementStateException("Can't read file: " + filename);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }
}
