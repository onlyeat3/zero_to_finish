package io.github.onlyeat3.zero_to_finish;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckboxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        CheckBox cb = findViewById(R.id.cb_a);
        cb.setOnCheckedChangeListener(new CheckListener());
    }

    private class CheckListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String msg = String.format("您勾选了控件%d,状态为%b", buttonView.getId(), isChecked);
            Toast.makeText(CheckboxActivity.this,msg, Toast.LENGTH_LONG).show();
        }
    }
}