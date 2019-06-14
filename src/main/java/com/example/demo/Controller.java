package com.example.demo;
import com.example.demo.com.example.com.example.repository.TweetsRepository;
import com.example.demo.com.example.demo.model.Busca;
import com.example.demo.com.example.demo.model.TweetResult;
import com.example.demo.com.example.services.TweetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twitter4j.TwitterException;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private TweetsRepository repo;
    @Autowired
    private TweetsService service;

    @PostMapping(value = "/search/keyword")
    public TweetResult buscar(@RequestBody Busca recebe) throws TwitterException {
        TweetResult resultado = service.searchKeyWord(recebe.getKeyWords());
        repo.save(resultado);

        return resultado;
    }

    @GetMapping(value="/search/saved")
    public List<TweetResult> exibir(){
        return repo.findAll();
    }
}
