package com.bam.ShortyApplication.database;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UrlRepository extends JpaRepository<UrlMapping, String> {
    boolean existsByShortCode(String code);
    Optional<UrlMapping> findByShortCode(String code);
}
