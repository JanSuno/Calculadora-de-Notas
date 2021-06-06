package com.example.calculadoradenotas;
//Renan Wenzel e Lucas Aguiar
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//Descobrimos que se você apertar Alt+Ins, dá pra gerar getters, setters, etc. Automaticamente

public class MainActivity extends AppCompatActivity {
    private EditText Nome;
    private EditText Email;
    private EditText Nota1;
    private EditText Nota2;

    private TextView Media;

    private Button calcula;
    private Button exibe;
    private Button sai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nome = (EditText) findViewById(R.id.Nome);
        Email = (EditText) findViewById(R.id.Email);
        Nota1 = (EditText) findViewById(R.id.Nota1);
        Nota2 = (EditText) findViewById(R.id.Nota2);
        Media = (TextView) findViewById(R.id.Media);
        calcula = (Button) findViewById(R.id.calcula);
        exibe = (Button) findViewById(R.id.exibe);
        sai = (Button) findViewById(R.id.sai);

        sai.setOnClickListener(new SairListener());
        exibe.setOnClickListener(new ExibeListener());
        calcula.setOnClickListener(new CalculaListener());
    }
    class SairListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            System.exit(0);
        }
    }

    class ExibeListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            String msg = "";
            msg += "Nome: " + Nome.getText() + "\n";
            msg += "Email: " + Email.getText() + "\n";
            msg += "Notas: " + Nota1.getText() + " e " + Nota2.getText();
            try {
                Double check = Double.parseDouble(Media.getText().toString().substring(0, 3));
                msg += "\nMédia: " + check;
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }catch (NumberFormatException ex) {
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        }
    }

    class CalculaListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            double n1, n2, avg;
            n1 = Double.parseDouble(Nota1.getText().toString());
            n2 = Double.parseDouble(Nota2.getText().toString());
            avg = (n1 + n2)/2;
            if(avg < 4) {
                Media.setText(Double.toString(avg) + " (reprovado sem recuperação!)");
            }
            if(avg>=4 & avg < 6){
                Media.setText(Double.toString(avg) + " (reprovado, mas com recuperação!)");
            }
            if(avg >= 6){
                Media.setText(Double.toString(avg) + " (aprovado!! Parabéns!!!!!!!!!)");
            }
        }
    }
}