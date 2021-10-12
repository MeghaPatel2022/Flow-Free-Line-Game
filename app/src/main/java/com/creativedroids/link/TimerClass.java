package com.creativedroids.link;

import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;

import java.util.Timer;
import java.util.TimerTask;

public class TimerClass extends TimerTask {

    private final Activity activity;
    private final int fromX;
    private final int fromY;
    private final View view;
    private final int toX;
    private final int toY;
    private int steps;

    public TimerClass(Timer timer, Activity act, View view, int fromX,
                      int fromY, int toX, int toY) {
        activity = act;
        this.view = view;
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
        steps = 0;
    }

    public void run() {
        if (steps < 10) {
            ++steps;
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    LayoutParams params = (LayoutParams) view.getLayoutParams();
                    params.leftMargin = (toX - fromX) * steps / 10 + fromX;
                    params.topMargin = (toY - fromY) * steps / 10 + fromY;
                    view.setLayoutParams(params);
                    view.invalidate();
                }
            });
        } else {
            cancel();
        }
    }
}
