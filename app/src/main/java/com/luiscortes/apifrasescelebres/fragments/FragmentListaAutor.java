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
import com.luiscortes.apifrasescelebres.api.IApiService;
import com.luiscortes.apifrasescelebres.api.RestClient;
import com.luiscortes.apifrasescelebres.interfaces.AutorApiCallback;
import com.luiscortes.apifrasescelebres.interfaces.OnCardClick;
import com.luiscortes.apifrasescelebres.models.Autor;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentListaAutor extends Fragment implements OnCardClick {


    private RecyclerView recyclerView;
    private AdapterListaAutor adapterListaAutor;
    private IApiService api;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_autor, container, false);
        api = RestClient.getInstance();
        recyclerView = view.findViewById(R.id.rvAutor);
        obtenerTodosLosAutores(new AutorApiCallback() {
            @Override
            public void onSuccess(List<Autor> autorList) {
                adapterListaAutor = new AdapterListaAutor(autorList, FragmentListaAutor.this);
                recyclerView.setAdapter(adapterListaAutor);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                Log.d("AUTOR 1: ", autorList.get(1).toString());
            }

            @Override
            public void onFailure(String errorMessage) {
                Log.e("Error", errorMessage);
            }
        });



        return view;
    }

    private void obtenerTodosLosAutores(AutorApiCallback callback) {

        api.getAllAutores().enqueue(new Callback<List<Autor>>() {
            @Override
            public void onResponse(Call<List<Autor>> call, Response<List<Autor>> response) {
                if (response.isSuccessful()) {
                    List<Autor> autores = response.body();
                    callback.onSuccess(autores);
                }
            }

            @Override
            public void onFailure(Call<List<Autor>> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }

    @Override
    public void onCardClick(int id) {
        FragmentFraseAutor fragmentFraseAutor = new FragmentFraseAutor();

        Bundle bundle = new Bundle();
        bundle.putInt("idAutor", id);

        fragmentFraseAutor.setArguments(bundle);
        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flFragmentContainer, fragmentFraseAutor);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
