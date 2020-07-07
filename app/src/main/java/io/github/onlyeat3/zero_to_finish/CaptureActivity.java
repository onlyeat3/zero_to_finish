package io.github.onlyeat3.zero_to_finish;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.PixelCopy;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.onlyeat3.zero_to_finish.util.DateUtil;

public class CaptureActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_capture;
    private String[] mChatStr = {"你吃饭了吗？","今天天气真好呀。","我中奖啦！","我们去看电影吧","晚上干什么好呢？"};
    private ImageView iv_capture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);
        findViewById(R.id.btn_capture).setOnClickListener(this);
        findViewById(R.id.btn_chat).setOnClickListener(this);
        tv_capture = findViewById(R.id.tv_capture);
        iv_capture = findViewById(R.id.iv_capture);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_chat:
                int random = (int) (Math.random() * 10) % 5;
                String newStr = String.format("%s\n%s%s", tv_capture.getText().toString(), DateUtil.getNowTime(), mChatStr[random]);
                tv_capture.setText(newStr);
                break;
            case R.id.btn_capture:
                Bitmap bitmap = tv_capture.getDrawingCache();
                iv_capture.setImageBitmap(bitmap);
                mHandler.postDelayed(mResetCache,200);
                break;
        }
    }

    private Handler mHandler = new Handler();
    private Runnable mResetCache = new Runnable() {
        @Override
        public void run() {
            tv_capture.setDrawingCacheEnabled(false);
            tv_capture.setDrawingCacheEnabled(true);
        }
    };
}