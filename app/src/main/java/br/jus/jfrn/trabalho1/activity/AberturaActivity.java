package br.jus.jfrn.trabalho1.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.jus.jfrn.trabalho1.R;
import br.jus.jfrn.trabalho1.broadcast.DezSegundos;

public class AberturaActivity extends AppCompatActivity {

    private DezSegundos broadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_abertura);

        broadcast = new DezSegundos();
        IntentFilter it = new IntentFilter(Intent.ACTION_TIME_TICK);
        registerReceiver(broadcast, it);
    }


    /**
     * Os métodos abaixo garante que o Broadcast responsável por ouvir
     * toda mudança de horário, seja desabilitado.
     **/
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcast);
    }
}
