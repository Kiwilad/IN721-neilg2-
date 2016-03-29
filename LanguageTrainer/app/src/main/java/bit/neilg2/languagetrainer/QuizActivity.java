package bit.neilg2.languagetrainer;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    //Places here for access through out activity
    String[] articles = {"Der", "Das", "Der", "Die", "Das", "Die", "Die", "Die", "Das", "Die", "Der"};
    String[] nouns = {"Apfel", "Auto", "Baum", "Ente", "Haus", "Hexe", "Kuh", "Milch", "Schaf", "Strasse", "Stuhl"};
    int correctSoFar = 0;
    int currentQuestionNumber = 0;
    private boolean answerTrue;
    int correctAnswers = 0;
    int amountOfAnswers = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        amountOfAnswers = articles.length;
        setUpButton();
        questShuffle();
        displayQuestion();

    }

    public class answerSelectedHandler implements RadioGroup.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            Button buttonSubmit = (Button)findViewById(R.id.btnSubmit);
            buttonSubmit.setEnabled(true);
        }
    }

    private void displayQuestion() {
        //clear checked radio buttons
        RadioGroup chosenButton = (RadioGroup) findViewById(R.id.RadioGroup_languageChoice);
        chosenButton.clearCheck();
        //disable button
        Button buttonSubmit = (Button)findViewById(R.id.btnSubmit);
        buttonSubmit.setEnabled(false);

        ImageView picture = (ImageView) findViewById(R.id.questionPic);
        picture.setImageResource(getImageID());
        //Set question number
        //get refernece to the textview
         TextView questionText=(TextView)findViewById(R.id.tvQuestionNumber);
        //Create the display string
        String output="Question number: "+Integer.toString(currentQuestionNumber+1);
        //Set the text on the text view
        questionText.setText(output);
    }

    private int getImageID() {
        //Get resources
        Resources res = getResources();
        //Get name of the image
        String imageName = articles[currentQuestionNumber] + "_" + nouns[currentQuestionNumber];
        //Convert to lower case
        imageName = imageName.toLowerCase();

        Log.i("ABC", "image name is: " + imageName);
        //Get ID
        int resourceID = res.getIdentifier(imageName, "drawable", getPackageName());

        return resourceID;
    }


    private void setUpButton() {
        //Get reference to button
        Button submitButton = (Button) findViewById(R.id.btnSubmit);
        //Set handler
        submitButton.setOnClickListener(new btnSubmitHandler());
        //find radioGroup referance
        RadioGroup radioGroupanswers = (RadioGroup)findViewById(R.id.RadioGroup_languageChoice);
        //set onCheckedChange
        radioGroupanswers.setOnCheckedChangeListener(new answerSelectedHandler());
    }
    public class btnSubmitHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //Get their answer
            String theirAnswer=getTheirAnswer();
            //if wrong, display wrong message
            if(checkCorrect(theirAnswer)) {
                Toast.makeText(QuizActivity.this, "You answered: " + theirAnswer + " this is the correct answer.", Toast.LENGTH_SHORT).show();
                correctAnswers++;
            } else {
                Toast.makeText(QuizActivity.this, "You answered: " + theirAnswer + " this is the wrong answer.", Toast.LENGTH_SHORT).show();
            }
            //increment currentquestion
            currentQuestionNumber++;
            //check for all questions answered
            if (currentQuestionNumber==amountOfAnswers){
                showResultsActivity();
            } else {
                //else display next question
                displayQuestion();
            }
        }
    }

    private void showResultsActivity(){
        //Create an intent
        Intent nextActivity = new Intent(QuizActivity.this,resultsActivity.class);

        //Bundle required data
        nextActivity.putExtra("CorrectAnswers", correctAnswers);
        nextActivity.putExtra("TotalAnswers", articles.length);
        //start the activity
        startActivity(nextActivity);
    }
    //Gets the users answer
    private String getTheirAnswer() {
        //get radio group
        RadioGroup chosenButton = (RadioGroup) findViewById(R.id.RadioGroup_languageChoice);
        //get item from group
        int radioButtonItem = chosenButton.getCheckedRadioButtonId();
        RadioButton SelectedRadioBtn = (RadioButton) findViewById(radioButtonItem);

        String theirAnswer = SelectedRadioBtn.getText().toString();

        return theirAnswer;
    }

    //checks to see if the user answer is correct
    public boolean checkCorrect(String theirAnswer) {
        String article = articles[currentQuestionNumber];
        //if correct then increment the number of correct answers and give feedback
        return (theirAnswer.equals(article));
    }

    public void questShuffle() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int questOne = random.nextInt(11);
            int questTwo = random.nextInt(11);

            String articlesTemp = articles[questOne];
            String nounsTemp = nouns[questOne];

            articles[questOne] = articles[questTwo];
            nouns[questOne] = nouns[questTwo];

            articles[questTwo] = articlesTemp;
            nouns[questTwo] = nounsTemp;
        }
    }
}