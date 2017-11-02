package br.usjt.consultadeusuarios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityBusca extends AppCompatActivity {

    private EditText nome;
    public static final String CHAVE = "chave";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca);
        nome = (EditText)findViewById(R.id.usuario);
    }


    public void buscar(View view){
        Intent intent = new Intent(this, ListaUsuarioActivity.class);
        String chave = nome.getText().toString();
        intent.putExtra(CHAVE, chave);
        startActivity(intent);
    }


}
