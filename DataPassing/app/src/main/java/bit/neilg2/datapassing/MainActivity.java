package bit.neilg2.datapassing;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPassData = (Button) findViewById(R.id.btnPassData);
        btnPassData.setOnClickListener(new goToSettingsButtonHandler());
        Intent launchIntent = getIntent();
        String userName = launchIntent.getStringExtra("Username");
        TextView txtUserName = (TextView) findViewById(R.id.txtUsername);
        txtUserName.setText(userName);
    }

    public class goToSettingsButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent changeActivityIntent = new Intent(MainActivity.this, settings.class);
            startActivity(changeActivityIntent);
        }
    }
}
