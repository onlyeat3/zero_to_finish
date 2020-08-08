package io.github.onlyeat3.zero_to_finish;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class EditAutoActivity extends AppCompatActivity {

    private String[] mHintArray = new String[]{"第一", "第一次", "第一次写代码", "第一次领工资", "第二", "第二个"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_auto);

        AutoCompleteTextView acText = findViewById(R.id.ac_text);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.item_dropdown, mHintArray);
        acText.setAdapter(arrayAdapter);
    }
}