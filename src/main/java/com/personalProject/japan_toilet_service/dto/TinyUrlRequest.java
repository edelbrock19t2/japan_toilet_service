package com.personalProject.japan_toilet_service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TinyUrlRequest {

    private String fullUrl;
}
