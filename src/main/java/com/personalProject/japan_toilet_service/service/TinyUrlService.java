package com.personalProject.japan_toilet_service.service;

import com.personalProject.japan_toilet_service.dto.TinyUrlRequest;
import com.personalProject.japan_toilet_service.dto.TinyUrlResponse;
import org.springframework.web.servlet.view.RedirectView;

public interface TinyUrlService {

    TinyUrlResponse createShortUrl(TinyUrlRequest request);
    RedirectView getFullUrl(String theKey);
}
