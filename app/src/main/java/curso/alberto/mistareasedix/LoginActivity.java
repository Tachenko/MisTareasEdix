package curso.alberto.mistareasedix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextView crearCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       /*
        crearCuenta = (TextView)findViewById(R.id.nueva_cuenta);
       crearCuenta.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, NewAccountActivity.class);
                startActivity(i);
            }
        }));

         */

        // ocultar Action Bar
        getSupportActionBar().hide();

        // Fuente texto
        Typeface miFuente = Typeface.createFromAsset(getAssets(), "Vuldo.ttf");

        // Agregar fuentes
        TextView subtitulo = (TextView) findViewById(R.id.subtitulo_login);
        TextView titulo = (TextView) findViewById(R.id.titulo_login);
        TextView cuentaNueva = findViewById(R.id.crear_cuenta);
        TextView botonLogin = (TextView) findViewById(R.id.boton_login);


        // Asignar Fuente a Etiquetas
        subtitulo.setTypeface(miFuente);
        titulo.setTypeface(miFuente);
        cuentaNueva.setTypeface(miFuente);
        botonLogin.setTypeface(miFuente);

    }

    // metodo para boton Login
    public void login (View view) {
        TextInputEditText usuario = (TextInputEditText) findViewById(R.id.cajaUser);
        TextInputEditText password = (TextInputEditText) findViewById(R.id.cajaPass);

        String nombre = usuario.getText().toString();
        String pass = password.getText().toString();

        if (nombre.length() == 0) {
            Toast.makeText(this,"Debes ingresar un nombre", Toast.LENGTH_LONG).show();
        }
        if (pass.length() == 0) {
            Toast.makeText(this,"Debes ingresar un password", Toast.LENGTH_LONG).show();
        }
        if (nombre.length() !=0 && pass.length() != 0 ) {
            Intent i = new Intent(this, TaskActivity.class);
            startActivity(i);
        }
    }

    // metodo Crear Cuenta (necesario pasarle un View)
    public void crearCuenta (View view) {
        Intent i = new Intent(this, NewAccountActivity.class);
        startActivity(i);

    }

}
