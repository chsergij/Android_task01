package softgroup.ch_sergij_home_task_01;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Acr.Aspire on 2017-01-26.
 */

public class LoggedFragment extends Fragment {

   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_in_logged_page,null,false);

        Button btn_fragment = (Button) view.findViewById(R.id.button);
        btn_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Вы нажали кнопку");
            }
        });
        return view;
    }
    private void showToast(String message) {
        Toast toast = Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    public void onStart() {
        super.onStart();
        showToast("Fragment onStart");
    }

    public void onResume() {
        super.onResume();
        showToast("Fragment onResume");
    }

    public void onPause() {
        super.onPause();
        showToast("Fragment onPause");
    }

    public void onStop() {
        super.onStop();
        showToast("Fragment onStop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        showToast("Fragment onDestroyView");
    }

    public void onDestroy() {
        super.onDestroy();
        showToast("Fragment onDestroy");
    }

    public void onDetach() {
        super.onDetach();
        showToast("Fragment onDetach");
    }


}
