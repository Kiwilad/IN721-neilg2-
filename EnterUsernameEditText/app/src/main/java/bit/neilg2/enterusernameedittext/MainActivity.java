package bit.neilg2.enterusernameedittext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int USERLENGTH = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText usernameTextField = (EditText)findViewById(R.id.usernameTextField);
        usernameTextFieldHandler listening = new usernameTextFieldHandler();
        usernameTextField.setOnKeyListener(listening);
    }

    public class usernameTextFieldHandler implements OnKeyListener
    {

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event)
        {

            boolean bool = false;

            if (event.getAction() == KeyEvent.ACTION_DOWN)
            {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {

                    EditText usernameTextField = (EditText) findViewById(v.getId());
                    String username = usernameTextField.getText().toString();
                    check(username);
                    bool = true;
                }
            }
            return  bool;
        }

        private void check(String username)
        {
            if (username.length() == USERLENGTH) {
                Toast.makeText(MainActivity.this, "Thank you " + username, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Usernames must be exactly " + USERLENGTH + " characters long", Toast.LENGTH_LONG).show();
            }
        }

    }
}
