package com.personalProject.japan_toilet_service.service.implementation;

import com.personalProject.japan_toilet_service.dto.TinyUrlRequest;
import com.personalProject.japan_toilet_service.dto.TinyUrlResponse;
import com.personalProject.japan_toilet_service.entity.TinyUrl;
import com.personalProject.japan_toilet_service.repository.TinyRepository;
import com.personalProject.japan_toilet_service.service.TinyUrlService;
import com.personalProject.japan_toilet_service.utils.TinyUrlUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

@Service
@RequiredArgsConstructor
public class TinyUrlImpl implements TinyUrlService {

    private final TinyRepository tinyRepository;
    private final TinyUrlUtil tinyUrlUtil;

    @Override
    public TinyUrlResponse createShortUrl(TinyUrlRequest request) {
        String fullUrl = request.getFullUrl();
        TinyUrl existingShortUrl = tinyRepository.findByFullUrl(fullUrl);

        if(existingShortUrl != null) {
            return TinyUrlResponse.builder().key(existingShortUrl.getKey()).build();
        }else{
            String newKey = tinyUrlUtil.generateUniqueKey();
            TinyUrl newTinyUrl = TinyUrl.builder()
                    .fullUrl(fullUrl)
                    .key(newKey)
                    .count_clicks(0)
                    .build();
            tinyRepository.save(newTinyUrl);
            return TinyUrlResponse.builder().key(newKey).build();
        }
    }

    @Override
    public RedirectView getFullUrl(String theKey) {
        TinyUrl tinyUrlDb = tinyRepository.findByKey(theKey);

        tinyUrlDb.setCount_clicks(tinyUrlDb.getCount_clicks() + 1);
        tinyRepository.save(tinyUrlDb);

        return new RedirectView(tinyUrlDb.getFullUrl());
    }
}
