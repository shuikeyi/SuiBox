package cn.suiseiseki.www.suibox;

import android.graphics.PointF;

/**
 * Created by Administrator on 2016/3/10.
 */
public class Box {

    private PointF mOrigin,mCurrent;
    public Box (PointF pointf)
    {
        mOrigin = pointf;
        mCurrent = pointf;
    }

    public void setCurrent(PointF current)
    {
        mCurrent = current;
    }
    public PointF getCurrent()
    {
        return mCurrent;
    }
    public PointF getOrigin()
    {
        return this.mOrigin;
    }
}
