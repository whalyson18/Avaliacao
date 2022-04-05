package com.example.avaliacao.async;

import android.os.AsyncTask;

import com.example.avaliacao.GetPokemonByURL;
import com.example.avaliacao.connection.Auxilia;
import com.example.avaliacao.connection.Conexao;
import com.example.avaliacao.model.Pokemon;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.concurrent.ExecutionException;

public class GetPokemonFromURL extends AsyncTask<Void, Void, Pokemon> {
    private String URL;

    public GetPokemonFromURL() {
    }

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

    public Pokemon start(String URL){
        AsyncTask<Void, Void, Pokemon> r = new GetPokemonByURL(URL).execute();

        try {
            return r.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
