package com.luiscortes.apifrasescelebres.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.luiscortes.apifrasescelebres.R;
import com.luiscortes.apifrasescelebres.adapters.AdapterFraseCategoria;
import com.luiscortes.apifrasescelebres.api.IApiService;
import com.luiscortes.apifrasescelebres.api.RestClient;
import com.luiscortes.apifrasescelebres.interfaces.FraseApiCallback;
import com.luiscortes.apifrasescelebres.models.Frase;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentFraseCategoria extends Fragment {

    private RecyclerView recyclerView;
    private AdapterFraseCategoria adapterFraseCategoria;

    private IApiService api;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_frase_categoria, container, false);

        api = RestClient.getInstance();
        recyclerView = view.findViewById(R.id.rvFraseCategoria);
        Bundle bundle = getArguments();
        if (bundle != null){
            int idCategoria = bundle.getInt("idCategoria");
            obtenerFrases(idCategoria, new FraseApiCallback() {
                @Override
                public void onSuccess(List<Frase> fraseList) {
                    adapterFraseCategoria = new AdapterFraseCategoria(fraseList);
                    recyclerView.setAdapter(adapterFraseCategoria);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                }

                @Override
                public void onFailure(String errorMessage) {
                    Log.e("Error", errorMessage);
                }
            });

        }
        return view;
    }

    private void obtenerFrases(int idCategoria, FraseApiCallback fraseApiCallback){
        api.getFraseCategoriaById(idCategoria).enqueue(new Callback<List<Frase>>() {
            @Override
            public void onResponse(Call<List<Frase>> call, Response<List<Frase>> response) {
                if (response.isSuccessful()){
                    List<Frase> frases = response.body();
                    fraseApiCallback.onSuccess(frases);
                }
            }

            @Override
            public void onFailure(Call<List<Frase>> call, Throwable t) {
                fraseApiCallback.onFailure(t.getMessage());
            }
        });
    }
}
