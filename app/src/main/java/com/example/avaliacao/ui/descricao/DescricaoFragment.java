package com.example.avaliacao.ui.descricao;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.avaliacao.GetPokemonsByDB;
import com.example.avaliacao.MainActivity;
import com.example.avaliacao.PokemonService;
import com.example.avaliacao.databinding.FragmentDescricaoBinding;
import com.example.avaliacao.model.PokemonDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class DescricaoFragment extends Fragment {

    private FragmentDescricaoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDescricaoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        System.out.println(MainActivity.p);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}