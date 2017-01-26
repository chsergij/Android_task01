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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setTitle("Registration");
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone1);
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
            String userPassword = editTextPassword.getText().toString();
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
                MyApplication myApp = ((MyApplication) getApplicationContext());
                myApp.setUserName(userName);
                myApp.setUserPassword(userPassword);
                myApp.setUserPhone(userPhone);
                message = getResources().getString(R.string.loginDataSaved);
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            }
        }
        finish();
    }
}
