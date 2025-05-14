package com.bam.ShortyApplication.service;

import com.bam.ShortyApplication.api.v1.dto.ShortenRequest;
import com.bam.ShortyApplication.api.v1.exception.AliasAlreadyExistsException;
import com.bam.ShortyApplication.api.v1.exception.NotFoundException;
import com.bam.ShortyApplication.database.UrlMapping;
import com.bam.ShortyApplication.database.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class ShortenerService {
    private final UrlRepository repo;
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final int CODE_BYTES = 6;

    public String createShortener(ShortenRequest req) {

        if (req.getCustom_alias() != null && repo.existsByShortCode(req.getCustom_alias())) {
            throw new AliasAlreadyExistsException();
        }
        String code = req.getCustom_alias() != null
                ? req.getCustom_alias()
                : generateRandomCode();
        repo.save(new UrlMapping(code, req.getUrl()));
        return code;
    }

    public String getOriginalUrl(String code) {
        return repo.findByShortCode(code)
                .orElseThrow(NotFoundException::new)
                .getOriginalUrl();
    }

    private String generateRandomCode() {
        byte[] bytes = new byte[CODE_BYTES];
        RANDOM.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }
}
