package com.shortener.demo.controller;

import com.shortener.demo.model.Url;
import com.shortener.demo.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/url")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping
    public String save(@RequestBody Url url) {
        return urlService.save(url);
    }

    @PutMapping String update(@RequestBody Url url) {
        return urlService.save(url);
    }

    @GetMapping
    public List<Url> getAll() {
        return urlService.getAll();
    }

    @RequestMapping(value = "/{urlId}", method = RequestMethod.GET)
    public Url getById(@PathVariable Integer urlId) {
        return urlService.findById(urlId);
    }

}
