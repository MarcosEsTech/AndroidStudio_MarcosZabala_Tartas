package com.example.alumno_fp.entregatartas_marcoszabala;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextNombre;
    EditText editTextApellido;
    EditText editTextEdad;
    EditText editTextConcurso;
    boolean checkGender = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = (EditText) findViewById(R.id.editTextNombre);
        editTextApellido = (EditText) findViewById(R.id.editTextApellido);
        editTextEdad = (EditText) findViewById(R.id.editTextEdad);
        editTextConcurso = (EditText) findViewById(R.id.editTextConcurso);
        editTextConcurso.setVisibility(View.GONE);

        Button buttonValidar = (Button) findViewById(R.id.buttonValidar);
        buttonValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
        });
    }

    private void validar() {
        editTextNombre.setError(null);
        editTextApellido.setError(null);
        editTextEdad.setError(null);

        String nombre = editTextNombre.getText().toString();
        String apellido = editTextApellido.getText().toString();
        String edad = editTextEdad.getText().toString();

        if(TextUtils.isEmpty(nombre)){
            editTextNombre.setError(getString(R.string.error_campo_obligatorio));
            editTextNombre.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(apellido)){
            editTextApellido.setError(getString(R.string.error_campo_obligatorio));
            editTextApellido.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(edad)){
            editTextEdad.setError(getString(R.string.error_campo_obligatorio));
            editTextEdad.requestFocus();
            return;
        }

        if(TextUtils.isDigitsOnly(nombre)){
            editTextNombre.setError(getString(R.string.error_campo_string));
            editTextNombre.requestFocus();
            return;
        }

        if(TextUtils.isDigitsOnly(apellido)){
            editTextApellido.setError(getString(R.string.error_campo_string));
            editTextApellido.requestFocus();
            return;
        }

        if(TextUtils.isDigitsOnly(edad)){
        }else{
            editTextEdad.setError(getString(R.string.error_campo_numerico));
            editTextEdad.requestFocus();
            return;
        }

        int edadInt = Integer.parseInt(edad);

        if(edadInt<18){
            editTextEdad.setError(getString(R.string.error_menor_18));
            editTextEdad.requestFocus();
            return;
        }

        if (checkGender){
            Toast.makeText(getApplicationContext(), "Se ha validado correctamente.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"Introduzca su género.",Toast.LENGTH_SHORT).show();
        }

    }

    public void onCheckboxClicked(View view) {

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            editTextConcurso.setVisibility(View.VISIBLE);
        }else {
            editTextConcurso.setVisibility(View.GONE);
        }
    }

    public void check(View view){
        checkGender = true;
    }

}
