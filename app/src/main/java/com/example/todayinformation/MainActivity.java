package com.example.todayinformation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


@ViewInject(mainlayoutid = R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @BindView(R.id.main_fab)
    FloatingActionButton mainFab;
    @BindView(R.id.main_rb_shanghai)
    RadioButton mainRbShanghai;
    @BindView(R.id.main_rb_hangzhou)
    RadioButton mainRbHangzhou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.main_fab)
    public void onClick() {
    }
}
