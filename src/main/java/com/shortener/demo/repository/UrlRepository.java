package com.shortener.demo.repository;

import com.shortener.demo.model.Url;
import org.springframework.data.repository.CrudRepository;

public interface UrlRepository extends CrudRepository<Url, Integer>{

}
