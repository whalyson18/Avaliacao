package com.example.avaliacao;

import android.content.Context;
import android.os.AsyncTask;

import com.example.avaliacao.model.PokemonDTO;
import com.example.avaliacao.model.Results;

import java.util.List;

public class GetPokemonsByDB extends AsyncTask<Void, Void, List<PokemonDTO>> {
    private Context context;
    public GetPokemonsByDB(Context context) {
        this.context = context;
    }

    @Override
    protected List<PokemonDTO> doInBackground(Void... voids) {
        PokemonService pokemonService = new PokemonService(context);
        return pokemonService.getPokemons();
        //return null;
    }
}
