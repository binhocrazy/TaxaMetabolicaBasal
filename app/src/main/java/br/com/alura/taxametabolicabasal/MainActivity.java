package br.com.alura.taxametabolicabasal;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ////////////////////////// VARIAVEIS //////////////////////////
    EditText edAltura, edPeso, edIdade;
    RadioButton rbMasculino, rbFeminino, rbLeve, rbModerado, rbIntenso;
    CheckBox cbResultSem, cbResultMes;
    ImageButton ibCalc;

    ///////////// EDITADO ULTIMA VEZ PELO BRENDER ////////////////

    ////////////////////////// VARIAVEIS //////////////////////////
    double P, A, I, AF, Resultado, Resultado_semana, Resultado_mes;
    ///////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ///////////////// PADRÃO ////////////////////
        getSupportActionBar().hide();
        /////////////////////////////////////////////
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /////////////////////////////////////////////

        ////////////////////////// DECLARAÇÕES //////////////////////////
        final EditText edAltura = (EditText) findViewById(R.id.edAltura);
        final EditText edPeso = (EditText) findViewById(R.id.edPeso);
        final EditText edIdade = (EditText) findViewById(R.id.edIdade);

        final RadioButton rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);
        final RadioButton rbFeminino = (RadioButton) findViewById(R.id.rbFeminino);
        final RadioButton rbLeve = (RadioButton) findViewById(R.id.rbLeve);
        final RadioButton rbModerado = (RadioButton) findViewById(R.id.rbModerado);
        final RadioButton rbIntenso = (RadioButton) findViewById(R.id.rbIntenso);

        final CheckBox cbResultSem = (CheckBox) findViewById(R.id.cbResultSem);
        final CheckBox cbResultMes = (CheckBox) findViewById(R.id.cbResultMes);

        final ImageButton ibCalc = (ImageButton) findViewById(R.id.ibCalc);
        ///////////////////////////////////////////////////////////////////

        ///////////////// FUNÇÃO DO CLIQUE NO BOTÃO ///////////////////////
         ibCalc.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
        ////////////////////////// CONDIÇÕES PARA DADOS EM BRANCO //////////////////////////
                 if (
                         edAltura.getText().length() == 0 ||
                         edPeso.getText().length() == 0 ||
                         edIdade.getText().length() == 0 ||
                                 (rbMasculino.isChecked() == false && rbFeminino.isChecked() == false) ||
                                 (rbLeve.isChecked() == false && rbModerado.isChecked() == false && rbIntenso.isChecked() == false))
                 {
                 Toast.makeText(MainActivity.this, "Atenção, os dados altura, peso, idade, sexo e nível de atividade física devem ser preenchidos!", Toast.LENGTH_SHORT).show();
                 return;
                 }
            ///////////////////////////// CALCULO /////////////////////////////////////////
                 else  {
                         A = Double.parseDouble(edAltura.getText().toString());
                         P = Double.parseDouble(edPeso.getText().toString());
                         I = Double.parseDouble(edIdade.getText().toString());

             //////////////////////// INICIO SELEÇÃO SE MASCULINO ////////////////////////////////
                     if (rbMasculino.isChecked()) {
                         if (rbLeve.isChecked()) {
                             AF = 1.55;
                         }
                         if (rbModerado.isChecked()) {
                             AF = 178;
                         }
                         if (rbIntenso.isChecked()) {
                             AF = 2.10;
                         }
                         if (cbResultSem.isChecked() || cbResultMes.isChecked()) {
                             if (cbResultSem.isChecked() && cbResultMes.isChecked()) {
                                 Resultado = 66.5 + (14 * P) + (5 * A) - (6.7 * I);
                                 Resultado = Resultado * AF;
                                 Resultado_semana = Resultado * 7;
                                 Resultado_mes = Resultado * 30;
                                 Toast.makeText(MainActivity.this, "Sua TMB é de " + Resultado + " kcal diárias \n Sua TMB é de " + Resultado_semana + " kcal semanal \nSua TMB é de " + Resultado_mes + " kcal mensal", Toast.LENGTH_SHORT).show();
                                 return;
                             }

                             if (cbResultSem.isChecked()) {
                                 Resultado = 66.5 + (14 * P) + (5 * A) - (6.7 * I);
                                 Resultado = Resultado * AF;
                                 Resultado_semana = Resultado * 7;
                                 Toast.makeText(MainActivity.this, "Sua TMB é de " + Resultado + " kcal diárias \n Sua TMB é de " + Resultado_semana + " kcal semanal", Toast.LENGTH_SHORT).show();
                                 return;
                             }
                             if (cbResultMes.isChecked()) {
                                 Resultado = 66.5 + (14 * P) + (5 * A) - (6.7 * I);
                                 Resultado = Resultado * AF;
                                 Resultado_mes = Resultado * 30;
                                 Toast.makeText(MainActivity.this, "Sua TMB é de " + Resultado + " kcal diárias \n Sua TMB é de " + Resultado_mes + " kcal mensal", Toast.LENGTH_SHORT).show();
                                 return;
                             }
                         }
                             else
                         {
                                 Resultado = 66.5 + (14 * P) + (5 * A) - (6.7 * I);
                                 Resultado = Resultado * AF;
                                 Toast.makeText(MainActivity.this, "Sua TMB é de " + Resultado + " kcal diárias", Toast.LENGTH_SHORT).show();
                                 return;
                         }
                     }
                 /////////////////////////////////// FIM SELEÇÃO SE MASCULINO ///////////////////////////////////////////

                 /////////////////////////////////// INICIO SELEÇÃO SE FEMININO /////////////////////////////////////////

                             else
                     {
                                   if(rbLeve.isChecked())
                                   {
                                       AF = 1.56;
                                   }
                                   if(rbModerado.isChecked())
                                   {
                                       AF = 1.64;
                                   }
                                   if(rbIntenso.isChecked())
                                   {
                                       AF = 1.82;
                                   }
                                   if(cbResultSem.isChecked() || cbResultMes.isChecked())
                                   {
                                       if(cbResultSem.isChecked() && cbResultMes.isChecked())
                                       {
                                           Resultado = 65.5 + (9.6 * P) + (1.8 * A) - (4.7 * I);
                                           Resultado = Resultado * AF;
                                           Resultado_semana = Resultado * 7;
                                           Resultado_mes = Resultado * 30;
                                           Toast.makeText(MainActivity.this, "Sua TMB é de " + Resultado + " kcal diárias \n Sua TMB é de " + Resultado_semana + " kcal semanal \nSua TMB é de " + Resultado_mes + " kcal mensal", Toast.LENGTH_SHORT).show();
                                           return;
                                       }
                                       if(cbResultSem.isChecked())
                                       {
                                           Resultado = 65.5 + (9.6 * P) + (1.8 * A) - (4.7 * I);
                                           Resultado = Resultado * AF;
                                           Resultado_semana = Resultado * 7;
                                           Toast.makeText(MainActivity.this, "Sua TMB é de " + Resultado + " kcal diárias \n Sua TMB é de " + Resultado_semana + " kcal semanal", Toast.LENGTH_SHORT).show();
                                           return;
                                       }
                                       if(cbResultMes.isChecked())
                                       {
                                           Resultado = 65.5 + (9.6 * P) + (1.8 * A) - (4.7 * I);
                                           Resultado = Resultado * AF;
                                           Resultado_mes = Resultado * 30;
                                           Toast.makeText(MainActivity.this, "Sua TMB é de " + Resultado + " kcal diárias \n Sua TMB é de " + Resultado_mes + " kcal mensal", Toast.LENGTH_SHORT).show();
                                           return;
                                       }

                                       else
                                       {
                                           Resultado = 65.5 + (9.6 * P) + (1.8 * A) - (4.7 * I);
                                           Resultado = Resultado * AF;
                                           Toast.makeText(MainActivity.this, "Sua TMB é de " + Resultado + " kcal diárias", Toast.LENGTH_SHORT).show();
                                           return;
                                       }
                                   }
                     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                     }
                /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                 }
             }
        });
    }
}