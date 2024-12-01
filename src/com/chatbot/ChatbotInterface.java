package com.chatbot;

public interface ChatbotInterface {
    void loadPredefinedResponses(String filePath);
    String getResponse(String userInput);
    void learnResponse(String question, String response);
    void saveLearnedResponses(String filePath);
}