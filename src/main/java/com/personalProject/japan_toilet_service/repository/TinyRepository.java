package com.personalProject.japan_toilet_service.repository;

import com.personalProject.japan_toilet_service.entity.TinyUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TinyRepository extends JpaRepository<TinyUrl, Long> {

    TinyUrl findByFullUrl(String theFullUrl);
    TinyUrl findByKey(String theKey);
}
