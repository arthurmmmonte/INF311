package calculadora.pratica01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button plus = (Button) findViewById(R.id.Button1);
        final Button minus = (Button) findViewById(R.id.Button2);
        final Button mult = (Button) findViewById(R.id.Button3);
        final Button div = (Button) findViewById(R.id.Button4);

        final EditText edt1 = (EditText) findViewById(R.id.EditText1);
        final EditText edt2 = (EditText) findViewById(R.id.EditText2);

        final TextView txt = (TextView) findViewById(R.id.Result);
    }

    public void onClickPlus(View v) {
        final EditText edt1 = (EditText) findViewById(R.id.EditText1);
        final EditText edt2 = (EditText) findViewById(R.id.EditText2);

        final TextView txt = (TextView) findViewById(R.id.Result);

        double value1 = Double.parseDouble(edt1.getText().toString());
        double value2 = Double.parseDouble(edt2.getText().toString());
        double result = value1 + value2;
        txt.setText(String.valueOf(result));
    }
    public void onClickMinus(View v) {
        final EditText edt1 = (EditText) findViewById(R.id.EditText1);
        final EditText edt2 = (EditText) findViewById(R.id.EditText2);

        final TextView txt = (TextView) findViewById(R.id.Result);

        double value1 = Double.parseDouble(edt1.getText().toString());
        double value2 = Double.parseDouble(edt2.getText().toString());
        double result = value1 - value2;
        txt.setText(String.valueOf(result));
    }
    public void onClickMult(View v) {
        final EditText edt1 = (EditText) findViewById(R.id.EditText1);
        final EditText edt2 = (EditText) findViewById(R.id.EditText2);

        final TextView txt = (TextView) findViewById(R.id.Result);

        double value1 = Double.parseDouble(edt1.getText().toString());
        double value2 = Double.parseDouble(edt2.getText().toString());
        double result = value1 * value2;
        txt.setText(String.valueOf(result));
    }
    public void onClickDiv(View v) {
        final EditText edt1 = (EditText) findViewById(R.id.EditText1);
        final EditText edt2 = (EditText) findViewById(R.id.EditText2);

        final TextView txt = (TextView) findViewById(R.id.Result);

        double value1 = Double.parseDouble(edt1.getText().toString());
        double value2 = Double.parseDouble(edt2.getText().toString());
        double result = value1 / value2;
        txt.setText(String.valueOf(result));
    }
}