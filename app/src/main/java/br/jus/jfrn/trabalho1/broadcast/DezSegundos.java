package br.jus.jfrn.trabalho1.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import br.jus.jfrn.trabalho1.activity.LoginActivity;

/**
 * Broadcast responsável por redirecionar a página de abertura para página de login.
 * Apesar de se chamar DezSegundos, o broadcast trabalha em cima de um minuto.
 *
 * @author  Jackson Roberio
 *
 **/
public class DezSegundos extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

//        Toast.makeText(context,"Deu certo", Toast.LENGTH_SHORT).show();

        Intent i = new Intent(context, LoginActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);


    }
}
