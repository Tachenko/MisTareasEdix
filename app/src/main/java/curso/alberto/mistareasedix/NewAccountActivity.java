package curso.alberto.mistareasedix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


public class NewAccountActivity extends AppCompatActivity {

    private TextInputEditText usuario, pass;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);


        usuario = (TextInputEditText) findViewById(R.id.caja_nuevo_usuario);
        pass = (TextInputEditText) findViewById(R.id.caja_nuevo_password);

    }


    // Metodo para el boton Crear , validaciones
    public void btnCrear (View view) {

        String nombre = usuario.getText().toString();
        String password = pass.getText().toString();

        if (nombre.length() == 0) {
            Toast.makeText(this,"Debes ingresar un nombre", Toast.LENGTH_LONG).show();
        }
        if (password.length() == 0) {
            Toast.makeText(this,"Debes ingresar un password", Toast.LENGTH_LONG).show();
        }

        if (nombre.length() !=0 && password.length() != 0 ) {
            Toast.makeText(this, "Registro en proceso...", Toast.LENGTH_LONG).show();
        }

    }

    // Metodo para el boton Volver
    public void btnVolver (View view) {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }


}