package curso.alberto.mistareasedix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener{

    // metodo principal
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ocultar Action Bar
        getSupportActionBar().hide();

        // Fuente texto
        Typeface miFuente = Typeface.createFromAsset(getAssets(),"KindnessLoveDemoScript.ttf");

        // Agregar al titulo
        TextView titulo = (TextView) findViewById(R.id.titulo);

        // Decimos ala etiqueta que utilice la fuente
        titulo.setTypeface(miFuente);

        // animacion titulo
        Animation anim = AnimationUtils.loadAnimation(this,R.anim.animacion_titulo);
        titulo.startAnimation(anim);
        anim.setAnimationListener(this);  // ponemos animacion a la escucha
    }

    // Metodos Listener Animacion
    @Override
    public void onAnimationStart(Animation animation) {

    }

    // Cuando termine la animacion de MainActivity pasa a LoginActivity
    @Override
    public void onAnimationEnd(Animation animation) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();    // ya no se podra volver a MainActivity
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}