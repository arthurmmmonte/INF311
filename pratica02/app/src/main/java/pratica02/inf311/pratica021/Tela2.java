package pratica02.inf311.pratica021;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Tela2 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_tela2);

        TextView name_var = (TextView) findViewById(R.id.name_var);
        TextView age_var = (TextView) findViewById(R.id.age_var);
        TextView weight_var = (TextView) findViewById(R.id.weight_var);
        TextView height_var = (TextView) findViewById(R.id.height_var);
        TextView imc_var = (TextView) findViewById(R.id.imc_var);
        TextView classification_var = (TextView) findViewById(R.id.classification_var);

        Intent it = getIntent();

        name_var.setText(it.getStringExtra("name"));
        age_var.setText(it.getStringExtra("age"));
        weight_var.setText(it.getStringExtra("weight"));
        height_var.setText(it.getStringExtra("height"));

        double weight = Double.parseDouble(weight_var.getText().toString());
        double height = Double.parseDouble(height_var.getText().toString());

        double imc = weight / (height*height);

        imc_var.setText(String.valueOf(imc));
        String temp = "ERROR";

        if(imc < 18.5) {
            temp = "Abaixo do Peso";
        }
        else if(imc < 24.9) {
            temp = "Saudável";
        }
        else if(imc < 29.9) {
            temp = "Sobrepeso";
        }
        else if(imc < 34.9) {
            temp = "Obesidade Grau I";
        }
        else if(imc < 39.9) {
            temp = "Obesidade Grau II (severa)";
        }
        else if(imc >= 40) {
            temp = "Obesidade Grau III (mórbida)";
        }

        classification_var.setText(temp);
    }

    public void voltar(View v) {
        finish();
    }
}