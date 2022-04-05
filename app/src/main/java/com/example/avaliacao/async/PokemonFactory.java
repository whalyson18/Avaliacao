package com.example.avaliacao.async;

import android.os.AsyncTask;

import com.example.avaliacao.connection.Auxilia;
import com.example.avaliacao.connection.Conexao;
import com.example.avaliacao.model.Pokemon;
import com.example.avaliacao.model.Result;
import com.example.avaliacao.model.Results;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PokemonFactory {
    private final String URL = "https://pokeapi.co/api/v2/pokemon?limit=10&offset=300";


    private List<Result> exportJsonToListPokemon() throws ExecutionException, InterruptedException {
        return new GetPokemonListFromURL(URL).execute().get().results;
    }

    public Pokemon exportPokemonFromList(List<Result> pokemons){
        pokemons.forEach(p -> {
            
        });
        return new PokemonFactory().GetPokemonFromURL
    }

    public class GetPokemonListFromURL extends AsyncTask<Void, Void, Results>{
        private String URL;

        private GetPokemonListFromURL(String URL) {
            this.URL = URL;
        }

        @Override
        protected Results doInBackground(Void... voids) {
            Conexao conexao = new Conexao();
            InputStream inputStream = conexao.obterRespostaHTTP(URL);
            Auxilia auxilia = new Auxilia();
            String textJSON = auxilia.converter(inputStream);

            Gson gson = new Gson();

            if(textJSON!=null){
                Type type = new TypeToken<Results>(){}.getType();
                return gson.fromJson(textJSON, type);
            }
            return null;
        }
    }

    public class GetPokemonFromURL extends AsyncTask<Void, Void, Pokemon>{
        private String URL;

        public GetPokemonFromURL(String URL) {
            this.URL = URL;
        }
        @Override
        protected Pokemon doInBackground(Void... voids) {
            Conexao conexao = new Conexao();
            InputStream inputStream = conexao.obterRespostaHTTP(URL);
            Auxilia auxilia = new Auxilia();
            String textJSON = auxilia.converter(inputStream);
            Gson gson = new Gson();

            if(textJSON!=null){
                Type type = new TypeToken<Pokemon>(){}.getType();
                return gson.fromJson(textJSON, type);
            }
            return null;
        }
    }
}
