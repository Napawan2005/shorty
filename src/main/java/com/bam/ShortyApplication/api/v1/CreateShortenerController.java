package com.bam.ShortyApplication.api.v1;

import com.bam.ShortyApplication.api.Route;
import com.bam.ShortyApplication.service.ShortenerService;
import com.bam.ShortyApplication.api.v1.dto.ShortenRequest;
import com.bam.ShortyApplication.api.v1.dto.ShortenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shortener")
@RequiredArgsConstructor
public class CreateShortenerController {
    private final ShortenerService service;

    @Value("${server.address}")
    private String serverAddress;

    @Value("${server.port}")
    private int serverPort;

    @PostMapping
    public ResponseEntity<ShortenResponse> create(@Validated @RequestBody ShortenRequest request)
    {
        StopWatch sw = new StopWatch();
        sw.start("requestHandling");

        String shortCode = service.createShortener(request);

        sw.stop();
        long totalTimeMs = sw.getTotalTimeMillis();
        return ResponseEntity.ok(
                new ShortenResponse(
                        "http://" + this.serverAddress + ":" + this.serverPort + "/" + shortCode,
                        String.format("%.3f", totalTimeMs / 1000.0)
                )
        );
    }
}
