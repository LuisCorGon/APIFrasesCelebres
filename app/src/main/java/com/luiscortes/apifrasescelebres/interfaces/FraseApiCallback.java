package com.luiscortes.apifrasescelebres.interfaces;

import com.luiscortes.apifrasescelebres.models.Autor;
import com.luiscortes.apifrasescelebres.models.Frase;

import java.util.List;

public interface FraseApiCallback {

    void onSuccess(List<Frase> fraseList);
    void onFailure(String errorMessage);
}
