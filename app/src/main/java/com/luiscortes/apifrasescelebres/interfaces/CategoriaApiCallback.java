package com.luiscortes.apifrasescelebres.interfaces;

import com.luiscortes.apifrasescelebres.models.Autor;
import com.luiscortes.apifrasescelebres.models.Categoria;

import java.util.List;

public interface CategoriaApiCallback {

    void onSuccess(List<Categoria> categoriaList);
    void onFailure(String errorMessage);
}
