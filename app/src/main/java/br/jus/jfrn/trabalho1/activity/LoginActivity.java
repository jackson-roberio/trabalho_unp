package br.jus.jfrn.trabalho1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.jus.jfrn.trabalho1.R;
import br.jus.jfrn.trabalho1.entidade.Log;
import br.jus.jfrn.trabalho1.repositorio.dao.LogDAO;
import br.jus.jfrn.trabalho1.util.Mensagem;

/**
 * Classe da Activity a_login.xml, responsável pela regras de negócios da mesma e
 * pelos eventos de solicitações, como verificação de autenticação e carregamento do design.
 *
 * @author Jackson Roberio
 **/
public class LoginActivity extends AppCompatActivity {

    private String login;
    private String senha;

    private LogDAO logDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_login);

        logDao = new LogDAO(this);

        Button botao = (Button) findViewById(R.id.login_botao);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValoresVariaveis();
                if(isLogar())
                    irMenuActivity();
                else
                    Mensagem.enviarLonga(v.getContext(), "Dados errados");
            }
        });
    }


    /**
     * Método responsável por resgatar os valores inseridos na Activity a_login.xml
     * e inserir nas variaveis de classe {@link #login} & {@link #senha}
     **/
    private void setValoresVariaveis(){
        EditText loginView = (EditText) findViewById(R.id.login_login);
        EditText senhaView = (EditText) findViewById(R.id.login_senha);
        login = loginView.getText().toString();
        senha = senhaView.getText().toString();
    }

    /**
     * Verifica se os dados passados são iguais aos dados necessários para autenticação.
     * Para o campo login, o autenticação não fara restrição de maiúsculas ou minúscula,
     * já para o campo senha, será conferido o tipo do caracter exatamente.
     *
     * A autenticação padrão é:
     * Loggin = Jackson
     * Senha = jackson
     *
     * Todos usuários cadastrados via sistema terão permissão ao login do sistema também.
     **/
    private boolean isLogar(){
        boolean dadosCorretos = false;
        dadosCorretos = login.toLowerCase().equals("jackson") && senha.equals("j");
        if(dadosCorretos) {
            logDao.inserir(new Log(login, true));
        } else {
            logDao.inserir(new Log(login, false));
        }
        return dadosCorretos;
    }


    /**
     * Redireciona o usuário para a Activity  MenuActivity.
     **/
    private void irMenuActivity(){
        Mensagem.enviarLonga(this, "Autenticação correta.");
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }
}
