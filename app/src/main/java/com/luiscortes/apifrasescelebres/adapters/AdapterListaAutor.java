package com.luiscortes.apifrasescelebres.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.luiscortes.apifrasescelebres.R;
import com.luiscortes.apifrasescelebres.interfaces.OnCardClick;
import com.luiscortes.apifrasescelebres.models.Autor;

import java.util.List;

public class AdapterListaAutor extends RecyclerView.Adapter<AdapterListaAutor.AutorViewHolder>{

    private OnCardClick click;
    private List<Autor> autorList;

    public AdapterListaAutor(List<Autor> autorList, OnCardClick click) {
        this.autorList = autorList;
        this.click = click;
    }

    @NonNull
    @Override
    public AutorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_autor, parent, false);
        return new AutorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AutorViewHolder holder, int position) {
        Autor autor = autorList.get(position);
        holder.bindAutor(autor);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.onCardClick(autor.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return autorList.size();
    }

    public class AutorViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvNacimiento, tvFallecimiento, tvProfesion;

        public AutorViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvNacimiento = itemView.findViewById(R.id.tvNacimiento);
            tvFallecimiento = itemView.findViewById(R.id.tvFallecimiento);
            tvProfesion = itemView.findViewById(R.id.tvProfesion);
        }

        public void bindAutor(Autor autor){
            tvNombre.setText(autor.getNombre());
            tvNacimiento.setText(autor.getNacimiento());
            tvFallecimiento.setText(autor.getMuerte());
            tvProfesion.setText(autor.getProfesion());
        }
    }
}
