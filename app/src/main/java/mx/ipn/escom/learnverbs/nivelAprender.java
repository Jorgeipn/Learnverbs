package mx.ipn.escom.learnverbs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class nivelAprender extends AppCompatActivity {

    LinearLayout ly_contenedor;
    private String palabra= "ANDROID";
    private EditText controles[];

    ImageButton btn_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel_aprender);

        btn_ok= (ImageButton)findViewById(R.id.btn_ok);

        ly_contenedor= (LinearLayout) findViewById(R.id.ly_contenedor);
        controles= new EditText[palabra.length()];

        InputFilter[] FilterArray = new InputFilter[1];
        FilterArray[0] = new InputFilter.LengthFilter(1);
        for(int fila=0; fila< controles.length; fila++){
            controles[fila]= new EditText(getApplicationContext());
            controles[fila].setHint("-");
            controles[fila].setFilters(FilterArray);
            ly_contenedor.addView(controles[fila]);
        }

    btn_ok.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(checkBlanks()){
                if(comprobarPalabra().equals(palabra)){
                    Toast.makeText(getApplicationContext(), "Correcto!", Toast.LENGTH_SHORT).show();
                }
            }else{
                btn_ok.setImageResource(R.drawable.ic_error);
            }


        }
    });


    }


    private String comprobarPalabra(){
        String respuesta= "";
        for (int i=0; i<controles.length; i++){
            respuesta= respuesta + controles[i].getText().toString();
        }
        return respuesta;
    }

    private boolean checkBlanks(){
        boolean valor= true;
        for (int i=0; i<controles.length; i++){
            if(controles[i].getText().toString().isEmpty()){
                valor=false;
                break;
            }
        }
        return valor;
    }



}
