package com.example.avaliacao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.avaliacao.async.GetPokemonFromURL;
import com.example.avaliacao.async.GetPokemonListFromURL;
import com.example.avaliacao.bd.BancoDados;
import com.example.avaliacao.bd.PokemonDAO;
import com.example.avaliacao.model.Pokemon;
import com.example.avaliacao.model.PokemonDTO;
import com.example.avaliacao.model.Result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokemonService implements PokemonDAO {
    private BancoDados bancoDados;
    private SQLiteDatabase sqLiteDatabase;

    public PokemonService(Context context) {
        bancoDados = new BancoDados(context);
    }

    @Override
    public void insertPokemon(PokemonDTO pokemon) {
        sqLiteDatabase = bancoDados.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(BancoDados.COLUMN_NAME_ID, pokemon.getId());
        contentValues.put(BancoDados.COLUMN_NAME_NAME, pokemon.getName());
        contentValues.put(BancoDados.COLUMN_NAME_EXP, pokemon.getExp());
        contentValues.put(BancoDados.COLUMN_NAME_HEIGHT, pokemon.getHeight());
        contentValues.put(BancoDados.COLUMN_NAME_WEIGHT, pokemon.getWeight());
        contentValues.put(BancoDados.COLUMN_NAME_SPRITE, pokemon.getSprite());
        contentValues.put(BancoDados.COLUMN_NAME_TYPES, pokemon.getTypes().toString());
        contentValues.put(BancoDados.COLUMN_NAME_SKILLS, pokemon.getSkills().toString());

        sqLiteDatabase.insert(BancoDados.TABLE_NAME, null, contentValues);
    }

    @Override
    public List<PokemonDTO> getPokemons() {
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
        System.out.println(pokemons);
        return pokemons;
    }

    @Override
    public void savePokemonsToDb(String url) {
        List<Result> pokemons = new ArrayList<Result>();
        List<String> habilidades = new ArrayList<>();
        List<String> tipos = new ArrayList<>();
        pokemons = new GetPokemonListFromURL().start(url);
        //pokemons = new GetListPokemonByURL().getResults(url);

        pokemons.forEach(p -> {
            Pokemon pokemon = new GetPokemonFromURL().start(p.url);
            //Pokemon pokemon = new GetPokemonByURL().getPokemon(p.url);

            pokemon.getAbilities().forEach(h -> {
                habilidades.add(h.ability.getName());
            });

            pokemon.getTypes().forEach(t -> {
                tipos.add(t.type.getName());
            });

            PokemonDTO pokemonDTO = new PokemonDTO(
                    pokemon.getId(),
                    pokemon.getName(),
                    pokemon.getHeight(),
                    pokemon.getWeight(),
                    pokemon.getBaseExperience(),
                    habilidades,
                    tipos,
                    pokemon.getSprites().getFrontDefault()
            );
            this.insertPokemon(pokemonDTO);
            tipos.clear();
            habilidades.clear();
        });
    }
}
