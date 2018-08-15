package com.lzhb.latte.util.timer;

import java.util.TimerTask;

/**
 * author: Lzhb
 * created on: 2018/8/15 16:50
 * description:
 */

public class BaseTimerTask extends TimerTask{

    private ITimerListener mListener = null;

    public BaseTimerTask(ITimerListener listener) {
        this.mListener = listener;
    }

    @Override
    public void run() {
        if (mListener!=null){
            mListener.onTimer();
        }
    }
}
