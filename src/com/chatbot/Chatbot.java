package com.chatbot;

import java.util.*;

public class Chatbot implements ChatbotInterface {
    private Map<String, String> predefinedResponses = new HashMap<>();
    private Map<String, String> learnedResponses = new HashMap<>();

    @Override
    public void loadPredefinedResponses(String filePath) {
        FileManager.loadResponses(filePath, predefinedResponses);
    }

    @Override
    public String getResponse(String userInput) {
        String input = userInput.toLowerCase();
        if (predefinedResponses.containsKey(input)) {
            return predefinedResponses.get(input);
        } else if (learnedResponses.containsKey(input)) {
            return learnedResponses.get(input);
        } else {
            return "I don't know how to respond to that. Can you teach me?";
        }
    }

    @Override
    public void learnResponse(String question, String response) {
        learnedResponses.put(question.toLowerCase(), response);
    }

    @Override
    public void saveLearnedResponses(String filePath) {
        FileManager.saveResponses(filePath, learnedResponses);
    }
}
