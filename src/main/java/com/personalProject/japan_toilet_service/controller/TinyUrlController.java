package com.personalProject.japan_toilet_service.controller;

import com.personalProject.japan_toilet_service.dto.TinyUrlRequest;
import com.personalProject.japan_toilet_service.dto.TinyUrlResponse;
import com.personalProject.japan_toilet_service.service.TinyUrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api/v1/tinyUrl")
@RequiredArgsConstructor
@Slf4j
public class TinyUrlController {

    private final TinyUrlService tinyUrlService;

    @PostMapping("/full")
    public TinyUrlResponse getUniqueKey(@RequestParam("fullUrl") String fullUrl){
        log.atInfo().log("Creating an unique key");
        TinyUrlRequest request = TinyUrlRequest.builder().fullUrl(fullUrl).build();
        return tinyUrlService.createShortUrl(request);
    }

    @GetMapping("/{theKey}")
    public RedirectView getToFullUrl(@PathVariable("theKey") String theKey){
        log.atInfo().log("Redirecting to full url via key: " + theKey);
        return tinyUrlService.getFullUrl(theKey);
    }
}
