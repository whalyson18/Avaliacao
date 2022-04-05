package com.example.avaliacao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.avaliacao.async.GetPokemonListFromDB;
import com.example.avaliacao.async.GetPokemonListFromURL;
import com.example.avaliacao.bd.BancoDados;
import com.example.avaliacao.connection.Auxilia;
import com.example.avaliacao.connection.Conexao;
import com.example.avaliacao.model.Pokemon;
import com.example.avaliacao.model.PokemonDTO;
import com.example.avaliacao.model.Result;
import com.example.avaliacao.model.Results;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.avaliacao.databinding.ActivityMainBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    //Random gerador = new Random();
    //private final int INDEX = new Random().nextInt(1126);
    //private final int QTD_POKEMON = new Random().nextInt(1126 - INDEX);

    private final String URL = "https://pokeapi.co/api/v2/pokemon?limit=10&offset=300";
    //private final String URL = "https://pokeapi.co/api/v2/pokemon?limit=" + QTD_POKEMON + "&offset=" + INDEX;
    private PokemonService pokemonService;
    public static AsyncTask<Void, Void, List<PokemonDTO>> p;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    public static AsyncTask<Void, Void, List<PokemonDTO>> getP() {
        return p;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_jogar)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        new GetPokemonListFromURL().start(URL);
        try {
            List<PokemonDTO> p = new GetPokemonListFromDB(this).get();
        } catch (ExecutionException e) {
            System.err.println(e.getMessage());
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        //pokemonService = new PokemonService(this);

        //pokemonService.savePokemonsToDb(URL);

        //pokemonService.getPokemons();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}