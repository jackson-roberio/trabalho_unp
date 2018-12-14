package br.jus.jfrn.trabalho1.repositorio.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;

import br.jus.jfrn.trabalho1.entidade.Usuario;
import br.jus.jfrn.trabalho1.repositorio.sgbd.RepositorioCentral;
import br.jus.jfrn.trabalho1.util.Mensagem;

import static br.jus.jfrn.trabalho1.util.BancoDadosUtil.BD_USARIO;

public class UsuarioDAO {

    private RepositorioCentral repositorio;
    private Context contexto;

    public UsuarioDAO(Context contexto){
        repositorio = new RepositorioCentral(contexto);
        this.contexto = contexto;
    }

    public boolean inserir(Usuario u){
        boolean retorno = true;
        try {
            ContentValues valores = new ContentValues();
            valores.put("LOGIN", u.getLogin());
            valores.put("SENHA", u.getSenha());
            repositorio.getWritableDatabase().insertOrThrow(BD_USARIO, null, valores);
        } catch (SQLiteConstraintException e){
            e.printStackTrace();
            retorno = false;
            Mensagem.enviarCurta(contexto, "Usuário: " + u.getLogin() + " já está cadastrado.");
        }
        return retorno;
    }
}
