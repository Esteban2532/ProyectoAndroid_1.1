package com.esteban.proyectosemana2;

import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity{

    private EditText nombreContacto;
    private EditText telefono;
    private EditText descripcion;
    private EditText email;
    private Button siguiente;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle intentmodificar = getIntent().getExtras();
        nombreContacto = (EditText) findViewById(R.id.tiNombreCompleto);
        telefono = (EditText) findViewById(R.id.titelefono);
        email = (EditText) findViewById(R.id.tiemail);
        descripcion = (EditText) findViewById(R.id.tidescripcion);
        siguiente = (Button) findViewById(R.id.btsiguiente);
        datePicker = (DatePicker)findViewById(R.id.datePicker);


        if (intentmodificar != null) {
            String nombre = intentmodificar.getString(getResources().getString(R.string.nombreUsuario));
            String tel = intentmodificar.getString(getResources().getString(R.string.telefono));
            String em = intentmodificar.getString(getResources().getString(R.string.email));
            String dc = intentmodificar.getString(getResources().getString(R.string.descripcion));

            nombreContacto.setText(nombre);
            telefono.setText(tel);
            descripcion.setText(dc);
            email.setText(em);

        }

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, confirmacionDatos.class);
                intent.putExtra(getResources().getString(R.string.textoNombre), nombreContacto.getText().toString());
                intent.putExtra(getResources().getString(R.string.textotelefono), telefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.textoemail), email.getText().toString());
                intent.putExtra(getResources().getString(R.string.textodescripcion), descripcion.getText().toString());

                intent.putExtra(getResources().getString(R.string.textofechaNacimiento),
                        String.valueOf(datePicker.getDayOfMonth() +"-"+
                        String.valueOf(datePicker.getMonth()+ 1 +"-"+
                        String.valueOf(datePicker.getYear())))

                                        );
                startActivity(intent);
                finish();


            }
        });
    }


}

