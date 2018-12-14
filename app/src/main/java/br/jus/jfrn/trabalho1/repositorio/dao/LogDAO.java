package br.jus.jfrn.trabalho1.repositorio.dao;

import android.content.ContentValues;
import android.content.Context;
import br.jus.jfrn.trabalho1.entidade.Log;
import br.jus.jfrn.trabalho1.repositorio.sgbd.RepositorioCentral;
import static br.jus.jfrn.trabalho1.util.BancoDadosUtil.BD_LOG;

public class LogDAO {

    private RepositorioCentral repositorio;

    public LogDAO(Context contexto){
        repositorio = new RepositorioCentral(contexto);
    }

    public void inserir(Log log){
        ContentValues valores = new ContentValues();
        valores.put("DATA", log.getData().toString());
        valores.put("LOGIN", log.getLogin());
        valores.put("LOGOU", log.isLogou());
        repositorio.getWritableDatabase().insertOrThrow(BD_LOG, null, valores);
    }
}
