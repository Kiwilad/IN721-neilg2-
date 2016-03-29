package bit.neilg2.languagetrainer;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    //Places here for access through out activity
    String[] articles = {"Der", "Das", "Der", "Die", "Das", "Die", "Die", "Die", "Das", "Die", "Der"};
    String[] nouns = {"Apfel", "Auto", "Baum", "Ente", "Haus", "Hexe", "Kuh", "Milch", "Schaf", "Strasse", "Stuhl"};
    int correctSoFar = 0;
    int currentQuestionNumber = 0;
    private String article;
    private String theirAnswer;
    private boolean answerTrue;
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // RadioGroup RadioGroup_languageChoice = (RadioGroup) findViewById(R.id.RadioGroup_languageChoice);

        setUpButton();
        questShuffle();
        displayQuestion();


    }

    private void displayQuestion() {
        ImageView picture = (ImageView) findViewById(R.id.questionPic);
        picture.setImageResource(getImageID());
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
        Button sumbitButton = (Button) findViewById(R.id.btnSubmit);
        //Set handler
        sumbitButton.setOnClickListener(new btnSubmitHandler());
    }

    public class btnSubmitHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //if correct, display correct messaage and increrment correctSoFar
            //if wrong, display wrong message
            checkCorrect();
            //increment currentquestion
            currentQuestionNumber++;
            //else display next question
            displayQuestion();
        }
    }

    public boolean checkCorrect() {
        //get radio group
        RadioGroup chosenButton = (RadioGroup) findViewById(R.id.RadioGroup_languageChoice);
        //get item from group
        int radioButtonItem = chosenButton.getCheckedRadioButtonId();
        RadioButton SelectedRadioBtn = (RadioButton) findViewById(radioButtonItem);

        String theirAnswer = SelectedRadioBtn.getText().toString();
        String article = articles[currentQuestionNumber];

        if (theirAnswer.equals(article)) {
            Toast.makeText(QuizActivity.this, "You answered: " + theirAnswer + " this is the correct answer.", Toast.LENGTH_SHORT).show();
            answerTrue = true;
            correctAnswers++;
        } else {
            Toast.makeText(QuizActivity.this, "You answered: " + theirAnswer + " this is the wrong answer.", Toast.LENGTH_SHORT).show();
            answerTrue = false;
        }
        return answerTrue;
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