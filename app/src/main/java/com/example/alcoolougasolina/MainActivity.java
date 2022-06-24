package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;

public class MainActivity extends AppCompatActivity {
    private EditText valorAlcool,valorGasolina;
    private TextView valorCombustivelResultado;
    private TextView melhorCombustivelResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorAlcool = findViewById(R.id.editTextValorAlcool);
        valorGasolina = findViewById(R.id.editTextValorGasolina);
        valorCombustivelResultado = findViewById(R.id.textViewValores);
        melhorCombustivelResultado = findViewById(R.id.textViewMelhorCombustivel);
    }



    public void precoCombustivel(){
        valorCombustivelResultado.setText("Álcool R$" +valorAlcool.getText().toString()+"\nGasolina R$"+valorGasolina.getText().toString() );
    }

    public void melhorCombustivel(){
        String alcoolString = "",gasolinaString = ""; //iniciando strings
        double alcoolDouble = 0.0, gasolinaDouble = 0.0; //iniciando doubles

        //Convertendo o input para String
        alcoolString = valorAlcool.getText().toString();
        gasolinaString = valorGasolina.getText().toString();

        //Convertendo String para Double
        alcoolDouble = Double.parseDouble(alcoolString);
        gasolinaDouble = Double.parseDouble(gasolinaString);

        //Comparando
        if (alcoolDouble > gasolinaDouble){
            melhorCombustivelResultado.setText("Gasolina");
        }
         else if (gasolinaDouble > alcoolDouble){
            melhorCombustivelResultado.setText("Álcool");
        } else if (gasolinaDouble == alcoolDouble) {
            melhorCombustivelResultado.setText("Ambos tem mesmo valor!");
        }

    }

    public Boolean validarCampos(String pAlcool, String pGasolina){
        Boolean camposValidados = true;

        if ( pAlcool == null || pAlcool.equals("") || pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;
    }


    public void comparar(View view){

        Boolean testeInput = validarCampos(valorAlcool.getText().toString(), valorGasolina.getText().toString());

        if (testeInput == true){
            precoCombustivel();
            melhorCombustivel();
        } else {
            valorCombustivelResultado.setText("Preencha todos os campos!");
            melhorCombustivelResultado.setText("");
        }
    }

}
