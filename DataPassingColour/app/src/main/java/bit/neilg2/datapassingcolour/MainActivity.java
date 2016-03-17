package bit.neilg2.datapassingcolour;

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

        Button ChangeTxtColour = (Button) findViewById(R.id.btnChangeTxtColour);
        ChangeTxtColour.setOnClickListener(new ChangeTxtColourHandler());

    }

    public class ChangeTxtColourHandler implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            Intent changeActivityIntent = new Intent(MainActivity.this, settings.class);
            startActivityForResult(changeActivityIntent, 0);
        }
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data)
    {
        if (requestCode == 0)
        {
            TextView TheColourMustChange = (TextView) findViewById(R.id.txtTheColourMustChange);
            int SetColour = data.getIntExtra("SetColour", 0);
            TheColourMustChange.setTextColor(SetColour);
        }
    }
}
