package softgroup.ch_sergij_home_task_01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Chupyra Sergij on 2017-01-22.
 */

public class LoggedActivity extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_page);

        Bundle extras = getIntent().getExtras();
        String nameKey = getResources().getString(R.string.nameKey);
        String title = getResources().getString(R.string.LoggedPageTitle) + " '";
        setTitle(title + extras.getString(nameKey) + "'");
    }
}
