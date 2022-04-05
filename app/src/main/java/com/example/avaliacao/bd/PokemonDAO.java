package com.example.avaliacao.bd;

import androidx.room.Insert;

import com.example.avaliacao.model.PokemonDTO;

import java.util.List;

public interface PokemonDAO {
    void insertPokemon(PokemonDTO pokemon);
    List<PokemonDTO> getPokemons();
    void savePokemonsToDb(String url);
}
