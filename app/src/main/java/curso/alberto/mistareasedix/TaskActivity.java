package curso.alberto.mistareasedix;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import curso.alberto.mistareasedix.db.ControladorDB;

public class TaskActivity extends AppCompatActivity {

    // referencia con la BD
    private ControladorDB controladorDB;

    ListView listViewTareas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        controladorDB = new ControladorDB(this);
        listViewTareas = findViewById(R.id.listaTareas);
        actualizarIU();

    }


    // Crear y Añadir elementos a la barra
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Caja Texto menu con opciones (añadir y cancelar)
    // El texto escrito en EditText se añade a la BD
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        final EditText cajaTexto = new EditText(this);
        cajaTexto.setHint("Empieza a escribir");

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Nueva Tarea")
                .setView(cajaTexto)
                .setPositiveButton("Añadir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                             String tarea;
                        tarea = cajaTexto.getText().toString();
                        controladorDB.addTarea(tarea);
                        actualizarIU();
                    }
                })
                .setNegativeButton("Cancelar", null)
                .create();
        dialog.show();

        return super.onOptionsItemSelected(item);
    }

    // metodo para actualizar la IU con los datos de la DB
    private void actualizarIU() {

        if (controladorDB.numeroRegistros() == 0) {
            listViewTareas.setAdapter(null);
        }  else {
            // Adapter para rellenar un ListView
            ArrayAdapter<String> miAdapter = new ArrayAdapter<>(this, R.layout.item_tarea, R.id.task_title, controladorDB.obtenerTareas());
            listViewTareas.setAdapter(miAdapter);
        }
    }


    // Metodo Boton finalizar
    public void finalizarTarea (View view) {
         //obtener padre del boton finalizar
        View parent = (View) view.getParent();
        TextView tareaTextView = parent.findViewById(R.id.task_title);
        //obtener el contenido
        String tarea = tareaTextView.getText().toString();
        controladorDB.finalizarTarea(tarea);
        actualizarIU();
    }


}