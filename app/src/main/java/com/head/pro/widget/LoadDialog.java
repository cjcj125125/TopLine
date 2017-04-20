package com.head.pro.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.github.ybq.android.spinkit.SpinKitView;
import com.head.pro.R;

/**
 * Created by Jie on 2017/4/9.
 */

public class LoadDialog extends Dialog {
    SpinKitView spinKit;
    TextView loadMsg;

    private View view;
    private Context context;

    public LoadDialog(Context context) {
        this(context, R.style.load_dialog);
    }

    public LoadDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.dialog_layout, null);
        }
        loadMsg = (TextView) view.findViewById(R.id.load_msg);
        spinKit = (SpinKitView) view.findViewById(R.id.spin_kit);
        setContentView(view);
     //   Log.i("TAG","创建dialog");
    }
    /**
     * 在布局中改变style切换不同效果
     *RotatingPlane
     * DoubleBounce
     *Wave
     *WanderingCubes
     *Pulse
     *ChasingDots
     * ThreeBounce
     *Circle
     *CubeGrid
     * FadingCircle
     *FoldingCube
     * RotatingCircle
     *
     * @style/SpinKitView
     @style/SpinKitView.Circle
     @style/SpinKitView.Large
     @style/SpinKitView.Small
     @style/SpinKitView.Small.DoubleBounce
     ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress);
     DoubleBounce doubleBounce = new DoubleBounce();
     progressBar.setIndeterminateDrawable(doubleBounce);
      * */


    /***
     * 设置加载时的提示信息
     */
    public void setLoadMsg(CharSequence msg) {
        if (msg != null) {
            loadMsg.setText(msg);
        }
    }

}
