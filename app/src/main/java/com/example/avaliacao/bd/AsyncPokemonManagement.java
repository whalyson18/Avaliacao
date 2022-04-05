package com.example.avaliacao.bd;

import android.os.AsyncTask;

import com.example.avaliacao.model.PokemonDTO;

import java.util.List;

public interface AsyncPokemonManagement {
    AsyncTask<Void, Void, Void> savePokemonInDb();
}
