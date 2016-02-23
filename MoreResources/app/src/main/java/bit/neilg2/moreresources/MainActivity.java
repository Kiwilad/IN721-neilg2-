package bit.neilg2.moreresources;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Get a referance pointer to the target TextView
        TextView txtDisplay = (TextView)findViewById(R.id.displayedTextDays);
        //Get text to set in the textView
        String textToDisplay = displayThisText();
        //Set the text
        txtDisplay.setText(textToDisplay);
    }

    private String displayThisText(){
        String aString="February Fridays are on: ";
        int[] day;
        //Create a Resources object
        Resources resourceResolver = getResources();
        //Get array from resources
        day=resourceResolver.getIntArray(R.array.FebFridays);
        //Loop through the array and add each day to the string
        for (int i=0;i<day.length;i++){
            aString += day[i];
            aString += " ";
        }
        return aString;
    }
}


