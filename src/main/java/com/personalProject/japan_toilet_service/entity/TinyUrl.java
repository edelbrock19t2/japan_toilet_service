package com.personalProject.japan_toilet_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tinyurl")
public class TinyUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "long_url")
    private String fullUrl;

    @Column(name = "tiny_key")
    private String key;

    @Column(name = "count_clicks")
    private Integer count_clicks;
}
