package io.github.onlyeat3.zero_to_finish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ViewUtils;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import io.github.onlyeat3.zero_to_finish.util.ViewUtil;

public class EditHideActivity extends AppCompatActivity {

    private EditText mEtOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_hide);

        LinearLayout ll_hide = findViewById(R.id.ll_hide);
        EditText et_mobile = findViewById(R.id.et_mobile);
        EditText et_password = findViewById(R.id.et_password);
        mEtOther = findViewById(R.id.et_other);
        ll_hide.setOnClickListener(new LlHideClickListener());
        et_mobile.addTextChangedListener(new HideTextWatcher(et_mobile));
        et_password.addTextChangedListener(new HideTextWatcher(et_password));
    }

    class LlHideClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.ll_hide) {
                ViewUtil.hideAllInputMethod(EditHideActivity.this);
            }
        }
    }

    class HideTextWatcher implements TextWatcher{

        private EditText mEditText;
        private final int maxLength;
        private CharSequence mStr;

        public HideTextWatcher(EditText mEditText) {
            this.mEditText = mEditText;
            maxLength = ViewUtil.getMaxLength(mEditText);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mStr = s;
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (mStr == null || mStr.length() == 0) {
                return;
            }
            if (mStr.length() >= maxLength) {
                ViewUtil.hideOneInputMethod(EditHideActivity.this,mEditText);
            }
        }
    }
}