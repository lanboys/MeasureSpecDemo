package com.bing.lan.measurespecdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    protected final LogUtil log = LogUtil.getLogUtil(getClass(), LogUtil.LOG_VERBOSE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void changeSize(final View view) {
        Toast.makeText(this, "变大了", Toast.LENGTH_SHORT).show();

        ((WeChatLayout) view).startAnimator();
        //((WeChatLayout) view).changeChildSize();
        //view.requestLayout();
        //ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        //
        //layoutParams.height += 10;
        //layoutParams.width += 10;
        //view.setLayoutParams(layoutParams);


        // 获取的相对于父控件的值
        // getHeight()
        // getBottom()
        // getTop()

        view.post(new Runnable() {
            @Override
            public void run() {
                log.i("run()  getHeight: " + view.getHeight());
                log.i("run()  getBottom: " + view.getBottom());
                log.i("run()  getTop: " + view.getTop());
            }
        });
    }
}
