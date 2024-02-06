package com.luiscortes.apifrasescelebres.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.luiscortes.apifrasescelebres.R;
import com.luiscortes.apifrasescelebres.adapters.AdapterFraseAutor;
import com.luiscortes.apifrasescelebres.api.IApiService;
import com.luiscortes.apifrasescelebres.api.RestClient;
import com.luiscortes.apifrasescelebres.interfaces.FraseApiCallback;
import com.luiscortes.apifrasescelebres.models.Frase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentFraseDia extends Fragment {

    private TextView tvId;
    private TextView tvFrase;
    private IApiService api;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_frase, container, false);
        tvId = view.findViewById(R.id.tvIdFrase);
        tvFrase = view.findViewById(R.id.tvFrase);
        api = RestClient.getInstance();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada = LocalDate.now().format(formato).toString();
        obtenerFrase(fechaFormateada);
        return view;
    }

    private void obtenerFrase(String fechaProgramada){
        api.getFraseDia(fechaProgramada).enqueue(new Callback<Frase>() {
            @Override
            public void onResponse(Call<Frase> call, Response<Frase> response) {
                if (response.isSuccessful()){
                    Frase frase = response.body();
                    tvFrase.setText(frase.getTexto());
                    tvId.setText(String.valueOf(frase.getId()));
                }
            }

            @Override
            public void onFailure(Call<Frase> call, Throwable t) {
                Log.e("Error",t.getMessage());
            }
        });
    }


}
