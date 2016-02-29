package bit.neilg2.eventhandlers;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEventTest = (Button)findViewById(R.id.btnEventTest);

        // Event handlers
        //short click
        btnEventTest.setOnClickListener(new btnEventTest());
        //long click
        btnEventTest.setOnLongClickListener(new btnEventTest());
    }

    public class btnEventTest implements View.OnClickListener, View.OnLongClickListener
    {
        //Short click
        @Override
        public void onClick(View v)
        {
            Toast.makeText(MainActivity.this, "Normal Click", Toast.LENGTH_SHORT).show();
        }

        // Long click
        @Override
        public boolean onLongClick(View v)
        {
            Toast.makeText(MainActivity.this, "Long Click", Toast.LENGTH_LONG).show();
            return true;
        }

    }
}
