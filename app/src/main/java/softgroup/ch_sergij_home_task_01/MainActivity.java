package softgroup.ch_sergij_home_task_01;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;


/**
 * Created by Chupyra Sergij on 2017-01-22.
 */

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private EditText editTextName;
    private EditText editTextPassword;
    private String activeUserName;
    private String activeUserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
    }

    private boolean checkUser(String userName, String userPassword) {
        return userName.equals(activeUserName) && userPassword.equals(activeUserPassword);
    }

    @Override
    public void onClick(View v) {

        String userName = editTextName.getText().toString();
        String userPassword = editTextPassword.getText().toString();
        String message;

        switch (v.getId()) {
            case R.id.buttonLogin:
                if (checkUser(userName, userPassword)) {
                    Intent intent;
                    intent = new Intent(this, LoggedActivity.class);
                    intent.putExtra(getResources().getString(R.string.nameKey), userName);
                    startActivity(intent);
                } else {
                    message = getResources().getString(R.string.loginError);
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.buttonRegistration:
                startActivity(new Intent(this, RegistrationActivity.class));
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyApplication myApp = ((MyApplication) getApplicationContext());
        activeUserName = myApp.getUserName();
        editTextName.setText(activeUserName);
        activeUserPassword = myApp.getUserPassword();
    }

    @Override
    protected void onStop() {
        super.onStop();
        editTextPassword.setText(null);
    }

}