package curso.alberto.mistareasedix.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

import curso.alberto.mistareasedix.R;

public class ControladorDB extends SQLiteOpenHelper {

    // constructor
    public ControladorDB(Context context) {
        super(context, " curso.alberto.mistareasedix.db", null, 1);
    }

    // metodo para crear tabla bd y sus campos
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE TAREAS (ID integer PRIMARY KEY AUTOINCREMENT,NOMBRE text NOT NULL, TAREA text NOT NULL, PASSWORD varchar NOT NULL)");
    }

    // no se desarrolla ya que no habra nuevas versiones de la app
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

/*
    // registrar usuario
    public void addUser (String nombre, String password) {
        SQLiteDatabase db = this.getWritableDatabase();  //abrir db

        ContentValues registro = new ContentValues();
        registro.put("NOMBRE", nombre);
        registro.put("PASSWORD", password);

        db.insert("TAREAS", null, registro);
        db.close();
    }
*/





    // metodo para insertar tarea
    public void addTarea (String tarea) {

        ContentValues registro = new ContentValues();
        registro.put("TAREA", tarea);   // campo a rellenar y valor


        SQLiteDatabase db = this.getWritableDatabase();  //abrir db
        db.insert("TAREAS", null, registro);   // insertar db
        db.close();    // cerrar db
    }

    // metodo para devolver Array de nombre de las tareas
    public String [] obtenerTareas() {
        SQLiteDatabase db = this.getReadableDatabase();    // solo consulta

        // conjunto de registros, guarda el resultado de una Select
        Cursor cursor;
        cursor = db.rawQuery("SELECT * FROM TAREAS", null); //devuelve todos los elementos de la BD

        // guarda numero de registros
        int regs = cursor.getCount();
        if (regs == 0) {
            db.close();
            return null;
        } else {
            cursor.moveToFirst();
            String[] tareas = new String[regs];
            for (int i=0; i < regs ; i++){
                 tareas[i] = cursor.getString(1);    // cogemos el primer string de campo nombre
                cursor.moveToNext();
            }

            //cerrar BD
            db.close();

            return tareas;
        }
    }

    // devuelve numero de registros que tiene la tabla
    public int numeroRegistros() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor;
        cursor = db.rawQuery("SELECT * FROM TAREAS", null);

        return cursor.getCount();
    }
    
    // Finalizar tarea
    public void finalizarTarea (String tarea) {
        SQLiteDatabase db = this.getWritableDatabase(); //abrir bd
        db.delete("TAREAS", "TAREA=?", new String[] {tarea});    //borra con la condicion de que campo nombre sea igual al la tarea
        db.close();  //cerrar bd
    }


}
