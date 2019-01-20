package com.shortener.demo.controller;

import com.shortener.demo.model.Url;
import com.shortener.demo.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/url")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping
    public String save(Url url) {
        return urlService.save(url);
    }

    @GetMapping
    public List<Url> getAll() {
        return urlService.getAll();
    }

}
