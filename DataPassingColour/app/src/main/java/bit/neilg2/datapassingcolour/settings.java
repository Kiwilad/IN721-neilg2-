package bit.neilg2.datapassingcolour;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextView settingsRedText = (TextView) findViewById(R.id.txtSettingsRedText);
        int SetColour = settingsRedText.getCurrentTextColor();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("SetColour", SetColour);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
