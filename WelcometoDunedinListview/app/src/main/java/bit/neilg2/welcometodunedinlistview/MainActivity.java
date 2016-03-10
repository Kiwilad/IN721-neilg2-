package bit.neilg2.welcometodunedinlistview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //turnes the title bar off if you change the extends to Activity
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        setupNodeActivities();

        ListView lvnodeActivitiesGroup = (ListView) findViewById(R.id.lvOutAbout);

        lvnodeActivitiesGroup.setOnItemClickListener(new lvnodeActivitiesHandler());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    // This method is invoked when the exit_clicked menue item is clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.exit:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setupNodeActivities()
    {
        String[] groups = {"Activities", "Shopping", "Dining", "Services"};
        ArrayAdapter<String> nodeActivitiesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, groups);
        ListView  lvnodeActivitiesGroup = (ListView) findViewById(R.id.lvOutAbout);
        lvnodeActivitiesGroup.setAdapter(nodeActivitiesAdapter);
    }

    public class lvnodeActivitiesHandler implements AdapterView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            String clickedItemString = (String) parent.getItemAtPosition(position).toString();
            Intent goToIntent;

            switch(clickedItemString)
            {
                case "Activities":
                    goToIntent = new Intent(MainActivity.this, Activities.class);
                    break;
                case "Shopping":
                    goToIntent = new Intent(MainActivity.this, Shopping.class);
                    break;
                case "Dining":
                    goToIntent = new Intent(MainActivity.this, Dining.class);
                    break;
                case "Services":
                    goToIntent = new Intent(MainActivity.this, Services.class);
                    break;
                default:
                    goToIntent = null;
            }

            if (goToIntent != null)
            {
                startActivity(goToIntent);
            }
        }
    }


}
