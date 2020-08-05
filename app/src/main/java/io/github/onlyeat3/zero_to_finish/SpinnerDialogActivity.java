package io.github.onlyeat3.zero_to_finish;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerDialogActivity extends AppCompatActivity {
    private String[] starArray = new String[]{"水星", "金星", "地球", "火星", "木星", "土星"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_dialog);
        initSpinner();
    }

    private void initSpinner(){
        ArrayAdapter<String> starAdapter = new ArrayAdapter<>(this, R.layout.item_select,this.starArray);
        starAdapter.setDropDownViewResource(R.layout.item_dropdown);

        Spinner sp = findViewById(R.id.sp_dialog);
        sp.setPrompt("请选择行星");
        sp.setAdapter(starAdapter);
        sp.setSelection(0);
        sp.setOnItemSelectedListener(new StarSelectedListener());
    }

    class StarSelectedListener implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(SpinnerDialogActivity.this,"您选择的是"+starArray[position],Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}