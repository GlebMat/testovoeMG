package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class Main {

    public static void main(String[] args) {
        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("tickets.json")) {
            if (inputStream == null) {
                throw new FileNotFoundException("File tickets.json not found in the classpath");
            }

            ObjectMapper objectMapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
            Root root = objectMapper.readValue(inputStream, new TypeReference<Root>() {
            });
            root.getMinTime();
            System.out.println("Разница между средней ценой и медианной = " + root.differenceAveragePriceAndMedian(root.getTickets()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
