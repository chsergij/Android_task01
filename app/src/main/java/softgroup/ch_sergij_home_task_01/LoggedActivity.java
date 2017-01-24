package softgroup.ch_sergij_home_task_01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

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

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop LoggedActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart LoggedActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume LoggedActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart LoggedActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause LoggedActivity", Toast.LENGTH_SHORT).show();
    }


}
