package cn.suiseiseki.www.suibox;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.jar.Attributes;

/**
 * Created by Administrator on 2016/3/10.
 */
public class BoxDrawingView extends View implements Serializable {
    public final static String TAG ="BoxDrawingView";
    private Box mCurrentBox;
    private ArrayList<Box> boxList = new ArrayList<>();
    private Paint mBoxPaint;
    private Paint mBackgroundPaint;

    // Used when creating the View in code
    public BoxDrawingView(Context context)
    {
        this(context,null);
    }
    // Used when inflating the View in xml
    public BoxDrawingView(Context context,AttributeSet attrs)
    {
        super(context, attrs);
        mBoxPaint = new Paint();
        mBoxPaint.setColor(0x22ff0000);
        mBackgroundPaint = new Paint();
        mBackgroundPaint.setColor(0xfff8efe0);
    }

    public boolean onTouchEvent(MotionEvent event)
    {
        PointF curr = new PointF(event.getX(),event.getY());
        Log.i(TAG,"Received event at x=" + curr.x + ", y =" + curr.y + ":");
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG,"ACTION_DOWN");
                mCurrentBox = new Box(curr);
                boxList.add(mCurrentBox);
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG,"ACTION_MOVE");
                if(mCurrentBox!=null)
                {
                    mCurrentBox.setCurrent(curr);
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG,"ACTION_UP");
                mCurrentBox = null;
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.i(TAG,"ACTION_CANCEL");
                mCurrentBox = null;
                break;
        }
        return true;
    }

    protected void onDraw(Canvas canvas)
    {
        canvas.drawPaint(mBackgroundPaint);
        for(Box box:boxList)
        {
            float left = Math.min(box.getOrigin().x,box.getCurrent().x);
            float right = Math.max(box.getOrigin().x, box.getCurrent().x);
            float top = Math.min(box.getOrigin().y, box.getCurrent().y);
            float bottom = Math.max(box.getOrigin().y,box.getCurrent().y);
            canvas.drawRect(left,top,right,bottom,mBoxPaint);
        }

    }

}
