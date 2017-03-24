package mx.ipn.escom.learnverbs;

import android.Manifest;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
    public static final int segundos= 10;
    public static final int milisegundos= segundos * 1000;
    public static final int delay= 2;

    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(maximoProgreso());
        empezarAnimacion();
    }

    private void empezarAnimacion() {

        new CountDownTimer(milisegundos, 1000){

            @Override
            public void onTick(long l) {
                progressBar.setProgress(establecerProreso(l));
            }

            @Override
            public void onFinish() {
                Intent i= new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }.start();

    }

    public int establecerProreso(long miliseg){
        return (int) ((milisegundos - miliseg)/1000);
    }

    public static int maximoProgreso() {
        return segundos-delay;
    }
}
