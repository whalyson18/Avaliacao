package com.example.avaliacao.ui.jogar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.avaliacao.R;
import com.example.avaliacao.databinding.FragmentDescricaoBinding;
import com.example.avaliacao.databinding.FragmentJogarBinding;
import com.example.avaliacao.ui.descricao.HomeViewModel;
import com.squareup.picasso.Picasso;

public class JogarFragment extends Fragment {

    private FragmentJogarBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentJogarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ImageView imageView = root.findViewById(R.id.descriptionImagePokemon);

        Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/9.png").into(imageView);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}