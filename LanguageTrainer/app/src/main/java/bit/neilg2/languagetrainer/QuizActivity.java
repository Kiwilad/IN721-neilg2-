package bit.neilg2.languagetrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

       // RadioGroup RadioGroup_languageChoice = (RadioGroup) findViewById(R.id.RadioGroup_languageChoice);

        setUpButton();


    }
private void setUpButton(){
    //Get reference to button
    Button sumbitButton=(Button)findViewById(R.id.btnSubmit);
    //Set handler
    sumbitButton.setOnClickListener(new btnSubmitHandler());
}

    public class btnSubmitHandler implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            //get radio group
            RadioGroup chosenButton = (RadioGroup) findViewById(R.id.RadioGroup_languageChoice);
            //get item from group
            int radioButtonItem = chosenButton.getCheckedRadioButtonId();
            RadioButton SelectedRadioBtn =(RadioButton)findViewById(radioButtonItem);

            String chosenAnswer = SelectedRadioBtn.getText().toString();

            
            Toast.makeText(QuizActivity.this, "You answered: "+chosenAnswer, Toast.LENGTH_SHORT).show();
        }
    }


}
