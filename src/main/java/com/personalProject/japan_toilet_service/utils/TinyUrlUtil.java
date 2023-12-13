package com.personalProject.japan_toilet_service.utils;

import com.personalProject.japan_toilet_service.config.TinyUrlConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class TinyUrlUtil {

    private final TinyUrlConfig tinyUrlConfig;

    public String generateUniqueKey(){
        String allowedCharacters = tinyUrlConfig.allowedCharacters();
        int keyLength = tinyUrlConfig.keyLength();

        StringBuilder result = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < keyLength; i++){
            int randomIndex = random.nextInt(allowedCharacters.length());
            result.append(allowedCharacters.charAt(randomIndex));
        }

        return result.toString();
    }


}
