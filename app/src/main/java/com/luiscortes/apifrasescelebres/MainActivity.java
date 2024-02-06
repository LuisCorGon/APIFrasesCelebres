package com.luiscortes.apifrasescelebres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.luiscortes.apifrasescelebres.fragments.FragmentFraseDia;
import com.luiscortes.apifrasescelebres.fragments.FragmentListaAutor;
import com.luiscortes.apifrasescelebres.fragments.FragmentListaCategoria;


public class MainActivity extends AppCompatActivity {

    private Button bFraseDia;
    private Button bFraseAutor;
    private Button bFraseCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicarBotones();

        bFraseDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarFragmentFraseDia(FragmentFraseDia.class);
            }
        });

        bFraseAutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarFragmentFraseAutor(FragmentListaAutor.class);

            }
        });

        bFraseCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarFragmentFraseCategoria(FragmentListaCategoria.class);
            }
        });
    }


    private void inicarBotones(){
        bFraseDia = findViewById(R.id.bDia);
        bFraseCategoria = findViewById(R.id.bCategoria);
        bFraseAutor = findViewById(R.id.bAutor);
    }

    private void cargarFragmentFraseDia(Class fragmentClass){
        Intent intent = new Intent(this, FragmentContainer.class);
        intent.putExtra("fragmentClass", fragmentClass);
        startActivity(intent);
    }

    private void cargarFragmentFraseAutor(Class fragmentClass){
        Intent intent = new Intent(this, FragmentContainer.class);
        intent.putExtra("fragmentClass", fragmentClass);
        startActivity(intent);
    }

    private void cargarFragmentFraseCategoria(Class fragmentClass){
        Intent intent = new Intent(this, FragmentContainer.class);
        intent.putExtra("fragmentClass", fragmentClass);
        startActivity(intent);
    }
}