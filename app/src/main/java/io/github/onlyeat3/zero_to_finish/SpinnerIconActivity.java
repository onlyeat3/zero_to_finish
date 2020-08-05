package io.github.onlyeat3.zero_to_finish;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpinnerIconActivity extends AppCompatActivity {
    private int[] starIconArray = new int[]{R.drawable.shuixing, R.drawable.jinxing, R.drawable.diqiu,
            R.drawable.huoxing, R.drawable.muxing, R.drawable.tuxing};
    private String[] starNameArray = new String[]{"水星", "金星", "地球", "火星", "木星", "土星"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_icon);

        initSpinnerForSimpleAdapter();
    }

    private void initSpinnerForSimpleAdapter() {
        List<Map<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < starIconArray.length; i++) {
            int iconId = starIconArray[i];
            String starName = this.starNameArray[i];
            Map<String, Object> item = new HashMap<>();
            item.put("icon",iconId);
            item.put("name",starName);
            data.add(item);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, R.layout.item_simple, new String[]{"icon", "name"}, new int[]{R.id.iv_icon, R.id.tv_name});
        simpleAdapter.setDropDownViewResource(R.layout.item_simple);
        Spinner sp = findViewById(R.id.sp_icon_star);
        sp.setPrompt("请选择行星");
        sp.setAdapter(simpleAdapter);

        sp.setSelection(0);
        sp.setOnItemSelectedListener(new MySelectedListener());
    }

    // 定义一个选择监听器，它实现了接口OnItemSelectedListener
    class MySelectedListener implements AdapterView.OnItemSelectedListener {
        // 选择事件的处理方法，其中arg2代表选择项的序号
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            Toast.makeText(SpinnerIconActivity.this, "您选择的是" + starNameArray[arg2], Toast.LENGTH_LONG).show();
        }

        // 未选择时的处理方法，通常无需关注
        public void onNothingSelected(AdapterView<?> arg0) {}
    }
}