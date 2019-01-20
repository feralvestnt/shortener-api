package com.shortener.demo.service;

import com.shortener.demo.comum.CommunicationException;
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

    public void save(Url url) {
        try {
            validateUrl(url);

            shortenAddress(url);
            urlRepository.save(url);

        } catch (ValidacaoException ex) {
            throw ex;
        } catch (Exception ex) {
            System.out.println("Error saving url.");
            throw ex;
        }
    }

    public void validateUrl(Url url) {
        if(url.getAddress() == null || url.getAddress().equals("")) {
            throw new ValidacaoException("Address is mandatory.");
        }
    }

    public void shortenAddress(Url url) {
        try {
            BitlyClient cliente = new BitlyClient(ACCESS_TOKEN_BITLY_CLIENT);
            Response<ShortenResponse> response = cliente.shorten()
                    .setLongUrl(url.getAddress())
                    .call();

            validateShortenResponse(response);

            url.setShortenedAddress(response.data.url);
        } catch (Exception ex) {
            System.out.println("Error: It was not possible to communicate with Bitly Client.");
            throw ex;
        }
    }

    public void validateShortenResponse(Response<ShortenResponse> response) {
        if (response.status_code != 200) {
            throw new CommunicationException("There is a communication problem, please try later.");
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
