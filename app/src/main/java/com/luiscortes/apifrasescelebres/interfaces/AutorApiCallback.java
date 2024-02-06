package com.luiscortes.apifrasescelebres.interfaces;

import com.luiscortes.apifrasescelebres.models.Autor;

import java.util.List;

public interface AutorApiCallback {
    void onSuccess(List<Autor> autorList);
    void onFailure(String errorMessage);
}
