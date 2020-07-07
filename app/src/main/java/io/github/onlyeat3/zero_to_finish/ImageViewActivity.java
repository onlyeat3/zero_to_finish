package io.github.onlyeat3.zero_to_finish;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageViewActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView iv_scale;
    private Button btn_center;
    private Button btn_fitCenter;
    private Button btn_centerCrop;
    private Button btn_centerInside;
    private Button btn_fitXY;
    private Button btn_fitStart;
    private Button btn_fitEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        this.iv_scale = findViewById(R.id.iv_scale);
        btn_center = findViewById(R.id.btn_center);
        btn_fitCenter = findViewById(R.id.btn_fitCenter);
        btn_centerCrop = findViewById(R.id.btn_centerCrop);
        btn_centerInside = findViewById(R.id.btn_centerInside);
        btn_fitXY = findViewById(R.id.btn_fitXY);
        btn_fitStart = findViewById(R.id.btn_fitStart);
        btn_fitEnd = findViewById(R.id.btn_fitEnd);

        btn_center.setOnClickListener(this);
        btn_fitCenter.setOnClickListener(this);
        btn_centerCrop.setOnClickListener(this);
        btn_centerInside.setOnClickListener(this);
        btn_fitXY.setOnClickListener(this);
        btn_fitStart.setOnClickListener(this);
        btn_fitEnd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_center:
                iv_scale.setScaleType(ImageView.ScaleType.CENTER);
                break;
            case R.id.btn_fitCenter:
                iv_scale.setScaleType(ImageView.ScaleType.FIT_CENTER);
                break;
            case R.id.btn_centerCrop:
                iv_scale.setScaleType(ImageView.ScaleType.CENTER_CROP);
                break;
            case R.id.btn_centerInside:
                iv_scale.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                break;
            case R.id.btn_fitXY:
                iv_scale.setScaleType(ImageView.ScaleType.FIT_XY);
                break;
            case R.id.btn_fitStart:
                iv_scale.setScaleType(ImageView.ScaleType.FIT_START);
                break;
            case R.id.btn_fitEnd:
                iv_scale.setScaleType(ImageView.ScaleType.FIT_END);
                break;
        }
    }
}