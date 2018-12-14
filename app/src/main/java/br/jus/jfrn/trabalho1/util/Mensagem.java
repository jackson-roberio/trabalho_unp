package br.jus.jfrn.trabalho1.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Classe com visualização global, responsável por enviar mensagens de
 * alerta ao usuário, estaticamente, sem necessidade de sua instanciação.
 *
 * @author  Jackson Roberio
 **/
public class Mensagem {

    /**
     * Enviar uma mensagem discreta do tipo Toast onde o seu escopo é
     * Toast.LENGTH_LONG. Essa mensagem é exibida no rodapé do seu dispositivo
     * alinhado no centro da tela.
     *
     * Tem a finalidade de facilitar no envio de mensagem ao usuário.
     *
     * @see #enviarCurta(Context, String)
     **/
    public static void enviarLonga(Context contexto, String texto){
        Toast.makeText(contexto, texto, Toast.LENGTH_LONG).show();
    }


    /**
     * Método responsável por enviar uma mensagem do tipo Toast ao usuário
     * com um escopo breve, uma mensagem discreta que em pouco tempo se
     * ofuscará, caso deseje uma mensagem mais longa use
     * {@link #enviarLonga(Context, String)}. Essa mensagem é exibida no rodapé
     * do seu dispositivo alinhado no centro da tela.
     *
     * @see #enviarLonga(Context, String)
     **/
    public static void enviarCurta(Context contexto, String texto){
        Toast.makeText(contexto, texto, Toast.LENGTH_SHORT).show();
    }

}
