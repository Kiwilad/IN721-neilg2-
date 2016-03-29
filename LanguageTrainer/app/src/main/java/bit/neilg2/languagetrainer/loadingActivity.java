package bit.neilg2.languagetrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        //Set button handlers
        buttonSetup();
    }

    private void buttonSetup(){
        //Get reference to button
         Button startButton=(Button)findViewById(R.id.btnStart);
        //Set handler
        startButton.setOnClickListener(new buttonStartHandler());
    }

    public class buttonStartHandler implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //Create an intent
            Intent nextActivity = new Intent(loadingActivity.this,QuizActivity.class);
            startActivity(nextActivity);
        }
    }
}
