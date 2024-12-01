package com.chatbot;

import java.io.*;
import java.util.Map;

public class FileManager {
    public static void loadResponses(String filePath, Map<String, String> responses) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    responses.put(parts[0].toLowerCase(), parts[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading responses: " + e.getMessage());
        }
    }

    public static void saveResponses(String filePath, Map<String, String> responses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            for (Map.Entry<String, String> entry : responses.entrySet()) {
                writer.write(entry.getKey() + "|" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving responses: " + e.getMessage());
        }
    }
}
