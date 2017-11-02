package br.usjt.consultadeusuarios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view){

        EditText etlogin= (EditText) findViewById(R.id.login);
        String login= etlogin.getText().toString();
        EditText etsenha= (EditText) findViewById(R.id.senha);
        String senha= etsenha.getText().toString();

        if(login.equals("1234") && senha.equals("4321")){
            Intent it= new Intent(this, ActivityBusca.class);
            startActivity(it);
        }else{
            Toast.makeText(this, "Login ou senha incorretos", Toast.LENGTH_SHORT).show();
        }
    }

}
