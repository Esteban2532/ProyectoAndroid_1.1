package com.esteban.proyectosemana2;

import android.content.Intent;
import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class confirmacionDatos extends AppCompatActivity {

    private TextView tnombre;
    private TextView ttelefono;
    private TextView temail;
    private TextView tdescripcion;
    private TextView tfechan;
    private Button editarDatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_datos);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.textoNombre));
        final String telefono = parametros.getString(getResources().getString(R.string.textotelefono));
        String email = parametros.getString(getResources().getString(R.string.textoemail));
        String descripcion = parametros.getString(getResources().getString(R.string.textodescripcion));
        String fechanacimiento = parametros.getString(getResources().getString(R.string.textofechaNacimiento));

        tnombre = (TextView)findViewById(R.id.tvnombre);
        ttelefono = (TextView)findViewById(R.id.tvtelefono);
        temail =  (TextView)findViewById(R.id.tvemail);
        tdescripcion = (TextView)findViewById(R.id.tvdescripcion);
        tfechan = (TextView)findViewById(R.id.tvfechanacimiento);
        editarDatos = (Button)findViewById(R.id.editarDatos);



        tnombre.setText(nombre);
        ttelefono.setText(telefono);
        temail.setText(email);
        tdescripcion.setText(descripcion);
        tfechan.setText(fechanacimiento);

        editarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(confirmacionDatos.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.nombreUsuario), tnombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.telefono), ttelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.email), temail.getText().toString());
                intent.putExtra(getResources().getString(R.string.descripcion), tdescripcion.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){

            Intent intent = new Intent(confirmacionDatos.this, MainActivity.class);
            startActivity(intent);
        }

        return super.onKeyDown(keyCode, event);
    }
}
