package com.bam.ShortyApplication.api;

import com.bam.ShortyApplication.service.ShortenerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/{code}")
public class RedirectController {
    private final ShortenerService service;

    @GetMapping
    public RedirectView redirect(@PathVariable String code)
    {
        System.out.println(code);
        String target = service.getOriginalUrl(code);
        RedirectView rv = new RedirectView(target);
        rv.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
        return rv;
    }
}
