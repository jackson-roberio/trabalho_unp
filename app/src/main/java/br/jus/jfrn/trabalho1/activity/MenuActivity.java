package br.jus.jfrn.trabalho1.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import br.jus.jfrn.trabalho1.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_menu);

        ImageView img = (ImageView) findViewById(R.id.menu_add);
        img.setOnClickListener(listenerGenerico(FormularioActivity.class));

        ImageView img2 = (ImageView) findViewById(R.id.menu_list);
        img2.setOnClickListener(listenerGenerico(ListaActivity.class));
    }

    private void ir(Class pagina){
        Intent i = new Intent(this, pagina);
        startActivity(i);
    }

    private View.OnClickListener listenerGenerico(final Class pagina){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ir(pagina);
            }
        };
    }
}
