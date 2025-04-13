package pratica02.inf311.pratica021;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickRelatorio(View v) {
        final EditText nameBox = (EditText) findViewById(R.id.name_box);
        final EditText ageBox = (EditText) findViewById(R.id.age_box);
        final EditText weightBox = (EditText) findViewById(R.id.weight_box);
        final EditText heightBox = (EditText) findViewById(R.id.height_box);

        Intent it = new Intent(getBaseContext(), Tela2.class);
        Bundle params = new Bundle();

        params.putString("name", nameBox.getText().toString());
        params.putString("age", ageBox.getText().toString());
        params.putString("weight", weightBox.getText().toString());
        params.putString("height", heightBox.getText().toString());

        it.putExtras(params);
        startActivity(it);
    }
}