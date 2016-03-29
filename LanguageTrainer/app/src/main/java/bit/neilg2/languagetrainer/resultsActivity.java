package bit.neilg2.languagetrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class resultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        //Grab data passed to us
        int correctAnswers=getIntent().getExtras().getInt("CorrectAnswers");
        int totalAnswers=getIntent().getExtras().getInt("TotalAnswers");
        //Create output sting used said data
        String myOutput="Your total score was: "+ correctAnswers;
        //Set the string on the textview
        //find ref
        TextView outputTV=(TextView)findViewById(R.id.txtResults);
        outputTV.setText(myOutput);
        //Set button handlers
        buttonSetup();
    }

    private void buttonSetup(){
        //Get reference to buttons
        Button exitButton=(Button)findViewById(R.id.btnExit);
        Button againButton=(Button)findViewById(R.id.btnAgain);

        //Set handlers
        exitButton.setOnClickListener(new buttonExitHandler());
        againButton.setOnClickListener(new buttonAgainHandler());
    }

    public class buttonExitHandler implements View.OnClickListener{

        @Override
        public void onClick(View v) {
           //Kill application
        finish();
        }
    }

    public class buttonAgainHandler implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            //Create an intent
            Intent nextActivity = new Intent(resultsActivity.this,loadingActivity.class);
            startActivity(nextActivity);
        }
    }
}