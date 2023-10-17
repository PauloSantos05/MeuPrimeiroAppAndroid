package com.example.proj1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    private TextView campoDeslocamento, campoConsumidoResult, campoAuto;
    private EditText campoKmInicial, campoKmFinal, campoCapacidade, campoConsumido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        campoDeslocamento = findViewById(R.id.campoDeslocamento);
        campoKmInicial = findViewById(R.id.campoKmInicial);
        campoKmFinal = findViewById(R.id.campoKmFinal);
        campoCapacidade = findViewById(R.id.campoCapacidade);
        campoConsumido = findViewById(R.id.campoConsumido);
        campoConsumidoResult = findViewById(R.id.campoConsumidoResult);
        campoAuto = findViewById(R.id.campoAuto);



    }

    public void Calcular(View visualizar)
    {

        // Obtenha os valores dos campos de texto
        String kmInicialTexto = campoKmInicial.getText().toString();
        String kmFinalTexto = campoKmFinal.getText().toString();
        String capacidadeTexto = campoCapacidade.getText().toString();
        String consumidoTexto = campoConsumido.getText().toString();

        double Deslocamento;
        double ConsumidoResult;
        double Auto;

        if(kmInicialTexto.isEmpty() || kmFinalTexto.isEmpty() || capacidadeTexto.isEmpty() || consumidoTexto.isEmpty())
        {
            Deslocamento = 0;
            ConsumidoResult = 0;
            Auto = 0;
            return;
        }

        double KmInicial = Double.parseDouble(kmInicialTexto);
        double KmFinal = Double.parseDouble(kmFinalTexto);
        double Capacidade = Double.parseDouble(capacidadeTexto);
        double Consumido = Double.parseDouble(consumidoTexto);

        char DeslocamentoText;

        Deslocamento = KmFinal - KmInicial;
        ConsumidoResult = Deslocamento / Consumido;
        Auto = ConsumidoResult * (Capacidade - Consumido);



// Formate os valores para exibição
        DecimalFormat formato = new DecimalFormat("#.##");
        String deslocamentoFormatado = formato.format(Deslocamento);
        String consumidoResultFormatado = formato.format(ConsumidoResult);
        String autoFormatado = formato.format(Auto);

        // Defina os valores formatados nos campos de texto
        campoDeslocamento.setText(getString(R.string.desloc) + " " + deslocamentoFormatado + "Km");
        campoConsumidoResult.setText(getString(R.string.consumidoR) + " " + consumidoResultFormatado + "Km/L");
        campoAuto.setText(getString(R.string.auto) + " " + autoFormatado + "L");
    }
}