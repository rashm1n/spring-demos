package com.rashm1n.spring_ai_demo_1.service;

import com.rashm1n.spring_ai_demo_1.model.*;
import lombok.AllArgsConstructor;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.chat.model.ChatResponse;
import java.util.List;

@Service
@AllArgsConstructor
public class OpenAIService {
    private final static String SYSTEM_INSTRUCTIONS =
            "You are an expert in English Grammar. You will correct the user input appropriately and return.";

    private final OpenAiChatModel chatModel;

    public GrammarResponse correctGrammar(GrammarRequest input) {
        Message userMessage = new UserMessage(input.getMessage());
        SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(SYSTEM_INSTRUCTIONS);
        Message systemMessage = systemPromptTemplate.createMessage();
        Prompt prompt = new Prompt(List.of(userMessage, systemMessage));
        ChatResponse m = chatModel.call(prompt);
        return new GrammarResponse(m.getResult().getOutput().getContent());
    }
}