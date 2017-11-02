package br.usjt.consultadeusuarios;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetalharUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhar_usuario);
        TextView nome = (TextView)findViewById(R.id.usuario_selecionado);
        Intent intent = getIntent();
        String texto= "Nome: "+intent.getStringExtra(ListaUsuarioActivity.nome)+"\n"+
                      "ID: "+intent.getStringExtra(ListaUsuarioActivity.ID)+"\n"+
                      "Senha: "+intent.getStringExtra(ListaUsuarioActivity.senha)+"\n"+
                      "CPF: "+intent.getStringExtra(ListaUsuarioActivity.cpf)+"\n"+
                      "CNPJ: "+intent.getStringExtra(ListaUsuarioActivity.cnpj);

        nome.setText(texto);
    }
}
