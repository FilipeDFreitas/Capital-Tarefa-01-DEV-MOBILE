package com.example.capitaltarefa01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String [] UF =
            {
                    "Paraná",
                    "Santa Catarina",
                    "Rio Grande do Sul",
                    "São Paulo",
                    "Espirito Santo",
                    "Minas Gerais",
                    "Goiás",
                    "Amazonas",
                    "Acre",
                    "Pernambuco",
                    "Amapá",
                    "Mato Grosso do Sul",
                    "Rio de Janeiro",
                    "Rondônia",
                    "Roraima",
                    "Ceará"

            };
    String [] Capital =
            {
                    "Curitiba",
                    "Florianópolis",
                    "Porto Alegre",
                    "São Paulo",
                    "Vitória",
                    "Belo Horizonte",
                    "Goiânia",
                    "Manaus",
                    "Rio Branco",
                    "Recife",
                    "Macapá",
                    "Campo Grande",
                    "Rio de Janeiro",
                    "Porto Velho",
                    "Boa Vista",
                    "Fortaleza"

            };
    TextView TentativasTxt;
    TextView Input;
    TextView UFView;
    TextView Result;
    Button Try;
    Button Next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TentativasTxt = findViewById(R.id.Tentativas);
        Input = findViewById(R.id.CapitalInput);
        UFView = findViewById(R.id.UF);
        Result = findViewById(R.id.Resultado);
        Try = (Button) findViewById(R.id.Go);
        Next = (Button) findViewById(R.id.Prox);
        Next.setOnClickListener(view -> quiz());
        quiz();
    }
    public void quiz(){


        Try.setEnabled(true);
        Result.setText("");
        Input.setText("");
        int Tentativas = Integer.valueOf(TentativasTxt.getText().toString());
        Tentativas++;
        TentativasTxt.setText(String.valueOf(Tentativas));
        if(Tentativas==5){

            Next.setEnabled(false);
            Try.setEnabled(false);
        }
        else {
            int i = 0;
            Next.setEnabled(true);
            Random r = new Random();
            int selecionado = r.nextInt(10);
            UFView.setText(UF[selecionado] + "?");
        }
    }
    public void Check(View view){
        TextView Input = findViewById(R.id.CapitalInput);
        TextView UFView = findViewById(R.id.UF);
        TextView pontosTxt = findViewById(R.id.Pontos);
        TextView Result = findViewById(R.id.Resultado);

        int Pontos = Integer.valueOf(pontosTxt.getText().toString());
        int i=0;
        while (i<10){
            String test = UF[i] + "?";
            if(UFView.getText().toString().equals(test)){
                if(Input.getText().toString().equals(Capital[i])) {
                    Pontos= Pontos +10;
                    pontosTxt.setText(String.valueOf(Pontos));
                    Result.setText("Acertou!");
                }
                else
                    Result.setText("Errou!");
                Button Try = (Button) findViewById(R.id.Go);
                Try.setEnabled(false);
            }
            i++;
        }
    }
}