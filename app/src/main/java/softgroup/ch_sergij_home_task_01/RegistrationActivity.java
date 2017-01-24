package softgroup.ch_sergij_home_task_01;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by Chupyra Sergij on 2017-01-22.
 */

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextName;
    private EditText editTextPassword;
    private EditText editTextPhone;
    private SharedPreferences sharedPreferences;
    private String nameKey;
    private String passwordKey;
    private String phoneKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setTitle("Registration");
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone1);
        String loginData = getApplicationContext().getResources().getString(R.string.loginData);
        sharedPreferences = getSharedPreferences(loginData, Context.MODE_PRIVATE);
        nameKey = getResources().getString(R.string.nameKey);
        passwordKey = getResources().getString(R.string.passwordKey);
        phoneKey = getResources().getString(R.string.phoneKey);
    }

    private String encryptPassword(String password) {
        int shift_key = R.string.shift_key;
        char character;
        char ch[] = new char[password.length()];
        for (int i = 0; i < password.length(); i++) {
            character = password.charAt(i);
            character = (char) (character + shift_key);
            ch[i] = character;
        }
        return String.valueOf(ch);
    }

    private String getMessagePart(String message, String logDataField, int resourceStr) {
        String newMessage = message;
        if (logDataField.isEmpty()) {
            newMessage += newMessage.isEmpty() ? "" : ", ";
            newMessage += getResources().getString(resourceStr);
        }
        return newMessage;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.buttonOK){
            String userName = editTextName.getText().toString();
            String userPassword = encryptPassword(editTextPassword.getText().toString());
            String userPhone = editTextPhone.getText().toString();
            String message = "";
            message = getMessagePart(message, userName, R.string.name);
            message = getMessagePart(message, userPassword, R.string.password);
            message = getMessagePart(message, userPhone, R.string.phone);
            if (!message.isEmpty()) {
                message = getResources().getString(R.string.specify) + " " + message;
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                return;
            } else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(nameKey, userName);
                editor.putString(passwordKey, userPassword);
                editor.putString(phoneKey, userPhone);
                editor.commit();
                message = getResources().getString(R.string.loginDataSaved);
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            }
        }
        finish();
    }
}
