package com.luiscortes.apifrasescelebres.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.luiscortes.apifrasescelebres.R;
import com.luiscortes.apifrasescelebres.interfaces.OnCardClick;
import com.luiscortes.apifrasescelebres.models.Categoria;

import java.util.List;

public class AdapterListaCategoria extends RecyclerView.Adapter<AdapterListaCategoria.CategoriaViewHolder> {

    private OnCardClick click;
    private List<Categoria> categoriaList;

    public AdapterListaCategoria(OnCardClick click, List<Categoria> categoriaList) {
        this.click = click;
        this.categoriaList = categoriaList;
    }


    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categoria, parent, false);
        return new CategoriaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder holder, int position) {
        Categoria categoria = categoriaList.get(position);
        holder.bindCategoria(categoria);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.onCardClick(categoria.getId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoriaList.size();
    }

    public class CategoriaViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre;

        public CategoriaViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvNombre = itemView.findViewById(R.id.tvNombreCategoria);
        }

        public void bindCategoria(Categoria categoria){
            tvNombre.setText(categoria.getNombre());
        }
    }
}
