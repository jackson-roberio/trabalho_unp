package br.jus.jfrn.trabalho1.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import br.jus.jfrn.trabalho1.R;
import br.jus.jfrn.trabalho1.entidade.Usuario;
import br.jus.jfrn.trabalho1.repositorio.dao.UsuarioDAO;
import br.jus.jfrn.trabalho1.util.Mensagem;

public class FormularioActivity extends AppCompatActivity {

    private String login;
    private String senha;
    private UsuarioDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        dao = new UsuarioDAO(this);

        Button botao = (Button) findViewById(R.id.formulario_botao);
        botao.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setValoresVariaveis();
                if(login.isEmpty() || senha.isEmpty()) {
                    Mensagem.enviarLonga(v.getContext(), "Preencha todos os dados");
                } else {
                    if(dao.inserir(new Usuario(login, senha))) {
                        Mensagem.enviarLonga(v.getContext(), "Usuário " + login + " cadastrado com sucesso.");
                        setZerarValoresVariaveis();
                    }
                }
            }
        });

    }


    /**
     * Método responsável por resgatar os valores inseridos na Activity a_formulario.xml
     * e inserir nas variaveis de classe {@link #login} & {@link #senha}
     **/
    private void setValoresVariaveis(){
        EditText loginView = (EditText) findViewById(R.id.formulario_login);
        EditText senhaView = (EditText) findViewById(R.id.formulario_senha);
        login = loginView.getText().toString();
        senha = senhaView.getText().toString();
    }

    private void  setZerarValoresVariaveis(){
        EditText loginView = (EditText) findViewById(R.id.formulario_login);
        EditText senhaView = (EditText) findViewById(R.id.formulario_senha);
        loginView.setText("");
        senhaView.setText("");
        login = null;
        senha = null;
    }
}
