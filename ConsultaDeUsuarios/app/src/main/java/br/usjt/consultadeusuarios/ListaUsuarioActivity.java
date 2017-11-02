package br.usjt.consultadeusuarios;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.usjt.consultadeusuarios.model.Usuario;

public class ListaUsuarioActivity extends AppCompatActivity {

    public static final String nome = "nome";
    public static final String ID = "id";
    public static final String senha = "senha";
    public static final String cpf = "cpf";
    public static final String cnpj = "cnpj";
    ArrayList<Usuario> lista;
    Activity atividade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuario);
        atividade = this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(ActivityBusca.CHAVE);
        lista = buscaUsuario(chave);
        ArrayAdapter<Usuario> adapter = new ArrayAdapter<Usuario>(this, android.R.layout.simple_list_item_1, lista);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, DetalharUsuarioActivity.class);

                Usuario usuario= new Usuario();
                usuario= lista.get(position);

                intent.putExtra(nome, usuario.getNome());
                intent.putExtra(ID, usuario.getId());
                intent.putExtra(senha, usuario.getSenha());
                intent.putExtra(cpf, usuario.getCpf());
                intent.putExtra(cnpj, usuario.getCnpj());
                startActivity(intent);
            }
        });
    }


    public ArrayList<Usuario> buscaUsuario(String chave){
        ArrayList<Usuario> lista = geraListaClientes();
        if (chave == null || chave.length() == 0){
            return lista;
        } else {
            ArrayList<Usuario> subLista = new ArrayList<>();
            for(Usuario usuario:lista){
                if(usuario.getNome().toUpperCase().contains(chave.toUpperCase())){
                    subLista.add(usuario);
                }
            }
            return subLista;

        }
    }


    public ArrayList<Usuario> geraListaClientes(){

        Usuario usuario1 = new Usuario("1111", "Chapolin", "1111", "999.999.999-99", "08:00:00", "18:00:00", true, 2, "11.111.111/1111-11");
        Usuario usuario2 = new Usuario("2222", "Chaves", "2222", "888.888.888-88", "07:00:00", "17:00:00", false, 0, "11.111.111/1111-11");
        Usuario usuario3 = new Usuario("3333", "Clotilde", "3333", "777.777.777-77", "09:00:00", "19:00:00", false, 1, "11.111.111/1111-11");
        Usuario usuario4 = new Usuario("4444", "Florinda", "4444", "666.666.666-66", "09:00:00", "18:00:00", true, 2, "11.111.111/1111-11");
        Usuario usuario6 = new Usuario("5555", "Madruga", "5555", "555.555.555-55", "08:00:00", "18:00:00", true, 1, "11.111.111/1111-11");
        Usuario usuario7 = new Usuario("6666", "Girafales", "6666", "444.444.444-44", "08:00:00", "18:00:00", false, 0, "11.111.111/1111-11");
        Usuario usuario8 = new Usuario("7777", "Barriga", "7777", "333.333.333-33", "07:00:00", "17:00:00", false, 0, "11.111.111/1111-11");
        Usuario usuario9 = new Usuario("8888", "Chapatins", "8888", "222.222.222-22", "09:00:00", "19:00:00", true, 1, "11.111.111/1111-11");
        Usuario usuario10 = new Usuario("9999", "Popis", "9999", "111.111.111-11", "08:00:00", "18:00:00", true, 2, "11.111.111/1111-11");
        Usuario usuario5 = new Usuario("1010", "Godines", "1010", "123.456.687-22", "08:00:00", "18:00:00", false, 1, "11.111.111/1111-11");


        ArrayList<Usuario> lista = new ArrayList<>();
        lista.add(usuario1);
        lista.add(usuario2);
        lista.add(usuario3);
        lista.add(usuario4);
        lista.add(usuario5);
        lista.add(usuario6);
        lista.add(usuario7);
        lista.add(usuario8);
        lista.add(usuario9);
        lista.add(usuario10);
        return lista;
    }
}
