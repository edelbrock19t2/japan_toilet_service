package com.personalProject.japan_toilet_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public record TinyUrlConfig(@Value("${tinyurl.config.allowed_characters}") String allowedCharacters,
                            @Value("${tinyurl.config.key_length}") int keyLength) {
}
