package softgroup.ch_sergij_home_task_01;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Acr.Aspire on 2017-01-26.
 */

public class MyApplication extends Application {
    private static SharedPreferences sharedPreferences;
    private String nameKey;
    private String passwordKey;
    private String phoneKey;
    private SharedPreferences.Editor editor;

    @Override
    public void onCreate() {
        super.onCreate();
        nameKey = getResources().getString(R.string.nameKey);
        passwordKey = getResources().getString(R.string.passwordKey);
        phoneKey = getResources().getString(R.string.phoneKey);
        sharedPreferences = getSharedPreferences(getResources().getString(R.string.loginData), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public String getUserName() {
        return sharedPreferences.getString(nameKey, "");
    }

    public void setUserName(String newUserName) {
        editor.putString(nameKey, newUserName);
        editor.commit();
    }

    public String getUserPhone() {
        return sharedPreferences.getString(phoneKey, "");
    }

    public void setUserPhone(String newUserPhone) {
        editor.putString(phoneKey, newUserPhone);
        editor.commit();
    }

    public String getUserPassword() {
        return decryptPassword(sharedPreferences.getString(passwordKey, ""));
    }

    public void setUserPassword(String newUserPassword) {
        editor.putString(passwordKey, encryptPassword(newUserPassword));
        editor.commit();
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
}
