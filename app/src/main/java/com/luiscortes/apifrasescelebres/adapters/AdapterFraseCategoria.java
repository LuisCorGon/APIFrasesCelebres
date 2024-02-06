package com.luiscortes.apifrasescelebres.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.luiscortes.apifrasescelebres.R;
import com.luiscortes.apifrasescelebres.models.Frase;

import java.util.List;

public class AdapterFraseCategoria extends RecyclerView.Adapter<AdapterFraseCategoria.FraseViewHolder> {

    private List<Frase> fraseList;

    public AdapterFraseCategoria(List<Frase> fraseList) {
        this.fraseList = fraseList;
    }

    @NonNull
    @Override
    public FraseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_frase, parent, false);
        return new FraseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FraseViewHolder holder, int position) {
        Frase frase = fraseList.get(position);
        holder.bindFrase(frase);
    }

    @Override
    public int getItemCount() {
        return fraseList.size();
    }


    public class FraseViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvTexto;


        public FraseViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvIdFrase);
            tvTexto = itemView.findViewById(R.id.tvFrase);
        }

        public void bindFrase(Frase frase){
            tvId.setText(String.valueOf(frase.getId()));
            tvTexto.setText(frase.getTexto());
        }
    }
}
