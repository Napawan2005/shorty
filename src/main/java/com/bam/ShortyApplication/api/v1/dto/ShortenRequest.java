package com.bam.ShortyApplication.api.v1.dto;
import lombok.Data;

@Data
public class ShortenRequest
{
    private String url;

    private String custom_alias;
}
