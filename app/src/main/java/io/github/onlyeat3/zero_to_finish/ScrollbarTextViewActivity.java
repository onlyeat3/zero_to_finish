package io.github.onlyeat3.zero_to_finish;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import io.github.onlyeat3.zero_to_finish.util.DateUtil;

public class ScrollbarTextViewActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {
    private TextView m_tv_bbs;
    private TextView m_tv_control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollbar_text_view);
        this.m_tv_control = findViewById(R.id.tv_control);
        this.m_tv_control.setOnClickListener(this);
        this.m_tv_control.setOnLongClickListener(this);
        this.m_tv_bbs = findViewById(R.id.tv_bbs);
        this.m_tv_bbs.setMovementMethod(new ScrollingMovementMethod());
        this.m_tv_bbs.setGravity(Gravity.LEFT|Gravity.BOTTOM);
    }

    private String[] mChatStr = {"你吃饭了吗？","今天天气真好呀。","我中奖啦！","我们去看电影吧","晚上干什么好呢？"};


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_control||v.getId() == R.id.tv_bbs) {
            int random = (int) ((Math.random() * 10) % 5);
            String newStr = String.format("%s\n%s %s", m_tv_bbs.getText(), DateUtil.getNowTime(), mChatStr[random]);
            m_tv_bbs.setText(newStr);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (v.getId() == R.id.tv_control || v.getId() == R.id.tv_bbs) {
            m_tv_bbs.setText("");
        }
        return true;
    }
}