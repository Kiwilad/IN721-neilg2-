package bit.neilg2.musicschoolappradiobtns;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button enrollMeBtn = (Button) findViewById(R.id.btnEnrollMe);
        enrollMeBtn.setOnClickListener(new btnEnrollMe());

        RadioGroup instrumentGroup = (RadioGroup) findViewById(R.id.RadioGroup_Instruments);

        //Spinner element
        Spinner monthSpinner = (Spinner) findViewById(R.id.MonthChoiceSpinner);
        //Get spinner layout
        int layoutID = android.R.layout.simple_spinner_item;
        //Spinner dropdown elements
        List<String> months = new ArrayList<String>();
        months.add("January");
        months.add("Febuary");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("Suptember");
        months.add("October");
        months.add("November");
        months.add("December");
        //Spinner adaptor creation
        ArrayAdapter<String> mthAdapter = new ArrayAdapter<String>(this, layoutID, months);

        //attaching adaptor to the spinner
        monthSpinner.setAdapter(mthAdapter);
    }

    public class btnEnrollMe implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            //get radio group
            RadioGroup chosenButton = (RadioGroup) findViewById(R.id.RadioGroup_Instruments);
            //get item from group
            int radioButtonItem = chosenButton.getCheckedRadioButtonId();
            RadioButton SelectedRadioBtn =(RadioButton)findViewById(radioButtonItem);

            String chosenInstrument = SelectedRadioBtn.getText().toString();

            //get spinner
            Spinner monthSpinner =(Spinner)findViewById(R.id.MonthChoiceSpinner);
            //Get item text
            String mthSelected = monthSpinner.getSelectedItem().toString();

            Toast.makeText(MainActivity.this, "You have been enrolled for " + chosenInstrument + " starting in " + mthSelected, Toast.LENGTH_SHORT).show();
        }
    }
}

