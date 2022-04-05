package com.example.avaliacao;

import android.os.AsyncTask;

import com.example.avaliacao.connection.Auxilia;
import com.example.avaliacao.connection.Conexao;
import com.example.avaliacao.model.Result;
import com.example.avaliacao.model.Results;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class GetListPokemonByURL extends AsyncTask<Void, Void, Results> {

    private String URL;

    public GetListPokemonByURL(){}

    private GetListPokemonByURL(String URL) {
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
    
    public List<Result> getResults(String URL){
        AsyncTask<Void, Void, Results> r = new GetListPokemonByURL(URL).execute();

        try {
            return r.get().results;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
