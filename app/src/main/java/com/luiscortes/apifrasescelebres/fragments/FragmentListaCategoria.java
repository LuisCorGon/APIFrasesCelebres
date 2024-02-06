package com.luiscortes.apifrasescelebres.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.luiscortes.apifrasescelebres.R;
import com.luiscortes.apifrasescelebres.adapters.AdapterListaAutor;
import com.luiscortes.apifrasescelebres.adapters.AdapterListaCategoria;
import com.luiscortes.apifrasescelebres.api.IApiService;
import com.luiscortes.apifrasescelebres.api.RestClient;
import com.luiscortes.apifrasescelebres.interfaces.AutorApiCallback;
import com.luiscortes.apifrasescelebres.interfaces.CategoriaApiCallback;
import com.luiscortes.apifrasescelebres.interfaces.OnCardClick;
import com.luiscortes.apifrasescelebres.models.Autor;
import com.luiscortes.apifrasescelebres.models.Categoria;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentListaCategoria extends Fragment implements OnCardClick {

    private RecyclerView recyclerView;
    private AdapterListaCategoria adapterListaCategoria;
    private IApiService api;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_categoria, container, false);
        api = RestClient.getInstance();
        recyclerView = view.findViewById(R.id.rvCategoria);
        obtenerTodasLasCategorias(new CategoriaApiCallback() {
            @Override
            public void onSuccess(List<Categoria> categoriaList) {
                adapterListaCategoria = new AdapterListaCategoria(FragmentListaCategoria.this, categoriaList);
                recyclerView.setAdapter(adapterListaCategoria);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            }

            @Override
            public void onFailure(String errorMessage) {
                Log.e("Error", errorMessage);
            }
        });



        return view;
    }

    private void obtenerTodasLasCategorias(CategoriaApiCallback callback) {

        api.getAllCategorias().enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                if (response.isSuccessful()) {
                    List<Categoria> categorias = response.body();
                    callback.onSuccess(categorias);
                }
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }

    @Override
    public void onCardClick(int id) {
        FragmentFraseCategoria fragmentFraseCategoria = new FragmentFraseCategoria();

        Bundle bundle = new Bundle();
        bundle.putInt("idCategoria", id);

        fragmentFraseCategoria.setArguments(bundle);
        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flFragmentContainer, fragmentFraseCategoria);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
