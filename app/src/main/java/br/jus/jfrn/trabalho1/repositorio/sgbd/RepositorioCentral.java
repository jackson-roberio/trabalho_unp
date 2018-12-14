package br.jus.jfrn.trabalho1.repositorio.sgbd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static br.jus.jfrn.trabalho1.util.BancoDadosUtil.BD_USARIO;
import static br.jus.jfrn.trabalho1.util.BancoDadosUtil.BD_LOG;
import static br.jus.jfrn.trabalho1.util.BancoDadosUtil.BANCO_NOME;
import static br.jus.jfrn.trabalho1.util.BancoDadosUtil.VERSAO;


public class RepositorioCentral extends SQLiteOpenHelper {

    public RepositorioCentral(Context context) {
        super(context,BANCO_NOME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + BD_USARIO + " (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "LOGIN TEXT UNIQUE, " +
                "SENHA TEXT)");

        db.execSQL(" CREATE TABLE " + BD_LOG + " ( " +
                " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " DATA TEXT, " +
                " LOGIN TEXT," +
                " LOGOU NUMERIC );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +  BD_USARIO + ";");
        db.execSQL("DROP TABLE IF EXISTS " + BD_LOG + ";");
        onCreate(db);
    }
}
