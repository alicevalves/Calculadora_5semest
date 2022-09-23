package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_limparTudo, btn_zero, btn_n1, btn_n2, btn_n3, btn_n4, btn_n5,
            btn_n6, btn_n7, btn_n8, btn_n9, btn_ponto,
            btn_igual, btn_soma, btn_subtracao, btn_multiplicacao, btn_divisao;

    private ImageButton ib_apagar;
    private TextView txtCalculo, txtResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();

        btn_zero.setOnClickListener(this);
        btn_n1.setOnClickListener(this);
        btn_n2.setOnClickListener(this);
        btn_n3.setOnClickListener(this);
        btn_n4.setOnClickListener(this);
        btn_n5.setOnClickListener(this);
        btn_n6.setOnClickListener(this);
        btn_n7.setOnClickListener(this);
        btn_n8.setOnClickListener(this);
        btn_n9.setOnClickListener(this);
        btn_ponto.setOnClickListener(this);
        btn_soma.setOnClickListener(this);
        btn_subtracao.setOnClickListener(this);
        btn_divisao.setOnClickListener(this);
        btn_multiplicacao.setOnClickListener(this);

        btn_limparTudo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                txtCalculo.setText("");
                txtResult.setText("");
            }
        });

        ib_apagar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                TextView calculo = findViewById(R.id.txtCalculo);
                String valor = calculo.getText().toString();

                if(!valor.isEmpty()){
                    int tamanho = valor.length();
                    String resultado = valor.substring(0, tamanho-1);
                    calculo.setText(resultado);
                    txtResult.setText("");
                }
            }
        });

        btn_igual.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Expression expressao = new ExpressionBuilder(txtCalculo.getText().toString()).build();
                double result = expressao.evaluate();
                long res = (long) result;

                if(result == (double) res){
                    txtResult.setText((CharSequence) String.valueOf(res));
                }else{
                    txtResult.setText((CharSequence) String.valueOf(result));
                }
            }
        });

    }

    private void inicializar(){
        btn_limparTudo = findViewById(R.id.btn_limparTudo);
        ib_apagar = findViewById(R.id.ib_apagar);
        btn_zero = findViewById(R.id.btn_zero);
        btn_n1 = findViewById(R.id.btn_n1);
        btn_n2 = findViewById(R.id.btn_n2);
        btn_n3 = findViewById(R.id.btn_n3);
        btn_n4 = findViewById(R.id.btn_n4);
        btn_n5 = findViewById(R.id.btn_n5);
        btn_n6 = findViewById(R.id.btn_n6);
        btn_n7 = findViewById(R.id.btn_n7);
        btn_n8 = findViewById(R.id.btn_n8);
        btn_n9 = findViewById(R.id.btn_n9);
        btn_ponto = findViewById(R.id.btn_ponto);
        btn_igual = findViewById(R.id.btn_igual);
        btn_soma = findViewById(R.id.btn_soma);
        btn_subtracao = findViewById(R.id.btn_subtracao);
        btn_divisao = findViewById(R.id.btn_divisao);
        btn_multiplicacao = findViewById(R.id.btn_multiplicacao);
        txtCalculo = findViewById(R.id.txtCalculo);
        txtResult = findViewById(R.id.txtResult);
    }

    public void addExpressao(String item, boolean operacao){
        if(txtResult.getText().equals("")) {
            txtCalculo.setText(" ");
        }
        if(operacao) {
            txtResult.setText(" ");
            txtCalculo.append(item);
        } else {
          txtCalculo.append(txtResult.getText());
          txtCalculo.append(item);
          txtResult.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_zero) {
            addExpressao("0", true);
        } else if (view.getId() == R.id.btn_n1) {
            addExpressao("1", true);
        }else if (view.getId() == R.id.btn_n2) {
            addExpressao("2", true);
        }else if (view.getId() == R.id.btn_n3) {
            addExpressao("3", true);
        }else if (view.getId() == R.id.btn_n4) {
            addExpressao("4", true);
        }else if (view.getId() == R.id.btn_n5) {
            addExpressao("5", true);
        }else if (view.getId() == R.id.btn_n6) {
            addExpressao("6", true);
        }else if (view.getId() == R.id.btn_n7) {
            addExpressao("7", true);
        }else if (view.getId() == R.id.btn_n8) {
            addExpressao("8", true);
        }else if (view.getId() == R.id.btn_n9) {
            addExpressao("9", true);
        }else if (view.getId() == R.id.btn_ponto) {
            addExpressao(",", true);
        }else if (view.getId() == R.id.btn_soma) {
            addExpressao("+", false);
        }else if (view.getId() == R.id.btn_subtracao) {
            addExpressao("-", false);
        }else if (view.getId() == R.id.btn_divisao) {
            addExpressao("/", false);
        }else if (view.getId() == R.id.btn_multiplicacao) {
            addExpressao("*", false);
        }
    }
}