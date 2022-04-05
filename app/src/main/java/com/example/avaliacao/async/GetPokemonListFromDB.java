package com.example.avaliacao.async;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import com.example.avaliacao.PokemonService;
import com.example.avaliacao.bd.BancoDados;
import com.example.avaliacao.model.PokemonDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetPokemonListFromDB extends AsyncTask<Void, Void, List<PokemonDTO>> {
    private BancoDados bancoDados;
    private SQLiteDatabase sqLiteDatabase;

    public GetPokemonListFromDB(Context context) {
        bancoDados = new BancoDados(context);
    }

    @Override
    protected List<PokemonDTO> doInBackground(Void... voids) {
        List<PokemonDTO> pokemons = new ArrayList<>();
        sqLiteDatabase = bancoDados.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(BancoDados.TABLE_NAME, null, null,null, null, null, null);

        while (cursor.moveToNext()){
            PokemonDTO pokemon = new PokemonDTO();
            pokemon.setId(cursor.getInt(cursor.getColumnIndexOrThrow(BancoDados.COLUMN_NAME_ID)));
            pokemon.setName(cursor.getString(cursor.getColumnIndexOrThrow(BancoDados.COLUMN_NAME_NAME)));
            pokemon.setHeight(cursor.getInt(cursor.getColumnIndexOrThrow(BancoDados.COLUMN_NAME_HEIGHT)));
            pokemon.setWeight(cursor.getInt(cursor.getColumnIndexOrThrow(BancoDados.COLUMN_NAME_WEIGHT)));
            pokemon.setExp(cursor.getInt(cursor.getColumnIndexOrThrow(BancoDados.COLUMN_NAME_EXP)));
            String skills = cursor.getString(cursor.getColumnIndexOrThrow(BancoDados.COLUMN_NAME_SKILLS)).replaceAll("^\\[|]$", "");
            pokemon.setSkills(new ArrayList<String>(Arrays.asList(skills.split(", "))));
            String types = cursor.getString(cursor.getColumnIndexOrThrow(BancoDados.COLUMN_NAME_TYPES)).replaceAll("^\\[|]$", "");
            pokemon.setTypes(new ArrayList<String>(Arrays.asList(types.split(", "))));
            pokemon.setSprite(cursor.getString(cursor.getColumnIndexOrThrow(BancoDados.COLUMN_NAME_SPRITE)));
            pokemons.add(pokemon);
        }
        cursor.close();
        //System.out.println(pokemons);
        return pokemons;
        //return null;
    }
}
