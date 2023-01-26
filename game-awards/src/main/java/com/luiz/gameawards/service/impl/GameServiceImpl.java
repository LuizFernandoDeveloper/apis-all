package com.luiz.gameawards.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.gameawards.domain.model.Game;
import com.luiz.gameawards.domain.model.GameRepository;
import com.luiz.gameawards.service.GameService;
import com.luiz.gameawards.service.exception.BusinessException;
import com.luiz.gameawards.service.exception.NotContentException;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private  GameRepository repository;

    @Override
    public List<Game> findAll() {
        return repository.findAll();
    }

    @Override
    public Game findById(Long id) {
        Optional<Game> game = repository.findById(id);
        return game.orElseThrow(() -> new NotContentException());
    }

    @Override
    public void insert(Game game) {
        if(game.getId() != null){
            throw new BusinessException("O ID é diferente de Null na inclusão");
        }
        repository.save(game);
    }

    @Override
    public void update(Long id, Game game) {
        Game gameDb = findById(id);
        if(gameDb.getId().equals(game.getId())){
            repository.save(game);
        }
        else{
            throw new BusinessException("O id é divergente");
        }
    }

    @Override
    public void delete(Long id) {
        Game gameDb = findById(id);
        repository.delete(gameDb);
    }
    
}
