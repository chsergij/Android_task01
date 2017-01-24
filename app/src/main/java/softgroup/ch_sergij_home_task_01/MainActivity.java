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
    private SharedPreferences sharedPreferences;
    private String activeUserName;
    private String activeUserPassword;
    private String nameKey;
    private String passwordKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        String loginData = getResources().getString(R.string.loginData);
        nameKey = getResources().getString(R.string.nameKey);
        passwordKey = getResources().getString(R.string.passwordKey);
        sharedPreferences = getSharedPreferences(loginData, Context.MODE_PRIVATE);
        getActiveUserData();
    }

    private void getActiveUserData() {
        activeUserName = sharedPreferences.getString(nameKey, "");
        editTextName.setText(activeUserName);
        activeUserPassword = decryptPassword(sharedPreferences.getString(passwordKey, ""));
    }

    private boolean checkUser(String userName, String userPassword) {
        return userName.equals(activeUserName) && userPassword.equals(activeUserPassword);
    }

    private String decryptPassword(String encryptedPassword) {
        int shift_key = R.string.shift_key;
        char character;
        char ch[] = new char[encryptedPassword.length()];
        for(int i=0;i<encryptedPassword.length();i++)
        {
            character=encryptedPassword.charAt(i);
            character = (char) (character - shift_key);
            ch[i]=character;
        }
        return String.valueOf(ch);
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
                    intent.putExtra(nameKey, userName);
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
    protected void onStop() {
        super.onStop();
        editTextPassword.setText(null);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getActiveUserData();
    }
}