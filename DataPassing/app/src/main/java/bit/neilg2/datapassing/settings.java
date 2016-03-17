package bit.neilg2.datapassing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button btnMainActivity = (Button) findViewById(R.id.btnMainActivity);
        btnMainActivity.setOnClickListener(new returnUsername());
    }

    public class returnUsername implements  View.OnClickListener{
        @Override
        public void onClick(View v) {

            Intent toMainActivity = new Intent(settings.this, MainActivity.class);
            EditText usernameChange = (EditText) findViewById(R.id.usernameChange);
            String usernameInput = usernameChange.getText().toString();
            toMainActivity.putExtra("Username", usernameInput);

            startActivity(toMainActivity);


        }
    }
}
