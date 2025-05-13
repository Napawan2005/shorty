package com.bam.ShortyApplication.database;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "url_mappings")
@Data @NoArgsConstructor @AllArgsConstructor
public class UrlMapping {

    @Id
    @Column(name="short_code", nullable=false, length=2048)
    private String shortCode;

    @Column(name="original_url", nullable=false, length=2048)
    private String originalUrl;

    @Column(name="created_at", updatable=false)
    @org.hibernate.annotations.CreationTimestamp
    private java.time.LocalDateTime createdAt;

    public UrlMapping(String shortCode, String originalUrl) {
        this.shortCode = shortCode;
        this.originalUrl = originalUrl;
    }
}
