package com.shortener.demo.service;

import com.shortener.demo.comum.ValidacaoException;
import com.shortener.demo.model.Url;
import com.shortener.demo.repository.UrlRepository;
import net.swisstech.bitly.BitlyClient;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.ShortenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    private static String ACCESS_TOKEN_BITLY_CLIENT = "79c3d14dadeeaa35656d13cae1e9f9191d1a5f6e";

    public String save(Url url) {
        validateUrl(url);

        shortenAddress(url);
        urlRepository.save(url);
        return url.getShortenedAddress();
    }

    public void shortenAddress(Url url) {
        BitlyClient cliente = new BitlyClient(ACCESS_TOKEN_BITLY_CLIENT);
        Response<ShortenResponse> resp = cliente.shorten()
                                .setLongUrl(url.getAddress())
                                .call();
        url.setShortenedAddress(resp.data.url);
    }

    public void validateUrl(Url url) {
        if(url.getAddress() == null) {
            throw new ValidacaoException("Address is mandatory.");
        }
    }

    public List<Url> getAll() {
        return (List) urlRepository.findAll();
    }

    public Url findById(Integer urlId) {
        Optional<Url> urlOptional = urlRepository.findById(urlId);
        if (urlOptional.isPresent()) {
            return urlOptional.get();
        } else {
            throw new ValidacaoException("Url not found.");
        }
    }
}
