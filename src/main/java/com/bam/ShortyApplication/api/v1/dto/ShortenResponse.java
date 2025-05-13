package com.bam.ShortyApplication.api.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShortenResponse {
    private String shortCode;
    private String timeDuration;
}
