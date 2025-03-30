package calculadora.pratica012;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    public boolean _memory = false;
    public boolean _error = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickClear(View v) {
        final EditText text = (EditText) findViewById(R.id.Box);

        text.setText("");
        _memory = false;
    }

    public void onClickBackspace(View v) {
        if(_error) {
            onClickClear(v);
            _error = false;
        }

        final EditText text = (EditText) findViewById(R.id.Box);

        String str = text.getText().toString();

        if(!str.isEmpty()) {
            text.setText(str.substring(0, str.length() - 1));
        }
    }

    public void onClickNumber(View v) {
        // Limpa a calculadora se ja tem um resultado
        if(_memory || _error) {
            onClickClear(v);
            _error = false;
        }

        final EditText text = (EditText) findViewById(R.id.Box);

        final Button clickedButton = (Button) v;
        final String number = clickedButton.getText().toString();

        text.append(number);
    }

    public void onClickDot(View v) {
        _memory = false;

        final EditText text = (EditText) findViewById(R.id.Box);

        final String str = text.getText().toString();

        if(!str.isEmpty() && Character.isDigit(str.charAt(str.length() - 1))) {
            text.append(".");
        }
    }

    public void onClickSign(View v) {
        if(_error) {
            onClickClear(v);
            _error = false;
        }

        final EditText text = (EditText) findViewById(R.id.Box);

        _memory = false;

        final Button clickedButton = (Button) v;
        final String sign = clickedButton.getText().toString();

        text.append(sign);
    }

    public void onClickEquals(View v) {
        final EditText text = (EditText) findViewById(R.id.Box);
        String str = text.getText().toString();

        if(str.isEmpty() || _error) {
            return;
        }

        Character[] operators = {'+', 'x', '/', '-'};
        int index = 0;

        for (Character character : operators) {
            index = str.indexOf(character, 1);

            if (index != -1) {
                break;
            }
        }

        String number1 = str.substring(0, index);
        char operator = str.charAt(index);
        String number2 = str.substring(index + 1);

        double n1=0, n2=0;

        try {
            n1 = Double.parseDouble(number1);
            n2 = Double.parseDouble(number2);
        }
        catch (Exception e) {
            text.setText(R.string.error);
            _error = true;
            return;
        }


        switch (operator) {
            case '+':
                doSum(n1, n2);
                break;

            case '-':
                doSubtract(n1, n2);
                break;

            case 'x':
                doMult(n1, n2);
                break;

            case '/':
                doDiv(n1, n2);
                break;
        }
    }

    public void doSum(double n1, double n2) {
        final EditText text = (EditText) findViewById(R.id.Box);

        double result = n1 + n2;
        text.setText(String.valueOf(result));
        _memory = true;
    }
    public void doSubtract(double n1, double n2) {
        final EditText text = (EditText) findViewById(R.id.Box);

        double result = n1 - n2;
        text.setText(String.valueOf(result));
        _memory = true;
    }
    public void doMult(double n1, double n2) {
        final EditText text = (EditText) findViewById(R.id.Box);

        double result = n1 * n2;
        text.setText(String.valueOf(result));
        _memory = true;
    }
    public void doDiv(double n1, double n2) {
        final EditText text = (EditText) findViewById(R.id.Box);

        if(n2 == 0) {
            text.setText(R.string.error);
            _error = true;
            return;
        }

        double result = n1 / n2;
        text.setText(String.valueOf(result));
        _memory = true;
    }

    public boolean countDots(String string) {
        int count = 0;

        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == '.') {
                count++;
            }
        }

        return count <= 1;
    }
}