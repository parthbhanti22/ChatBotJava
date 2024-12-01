package com.chatbot;

import java.util.Scanner;

public class ChatbotApp {
    public static void main(String[] args) {
        ChatbotInterface chatbot = new Chatbot();
        chatbot.loadPredefinedResponses("./responses.txt");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Chatbot: Hi! Start typing to chat with me.");

        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Chatbot: Goodbye!");
                chatbot.saveLearnedResponses("./learned_responses.txt");
                break;
            }

            String response = chatbot.getResponse(userInput);
            System.out.println("Chatbot: " + response);

            if (response.equals("I don't know how to respond to that. Can you teach me?")) {
                System.out.print("You: ");
                String learnedResponse = scanner.nextLine();
                chatbot.learnResponse(userInput, learnedResponse);
                System.out.println("Chatbot: Got it! I'll remember that.");
            }
        }
        scanner.close();
    }
}
