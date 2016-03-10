package cn.suiseiseki.www.suibox;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/3/10.
 */
public class DragAndDrawFragment extends Fragment {

    private BoxDrawingView myBoxDrawingView;


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState)
    {
        if(savedInstanceState != null)
        {
            View v = (View)savedInstanceState.getSerializable("saved");
            return v;
        }
        View v = inflater.inflate(R.layout.fragment_drag_and_draw,parent,false);
        myBoxDrawingView = (BoxDrawingView)v;
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putSerializable("saved",myBoxDrawingView);
        super.onSaveInstanceState(bundle);
    }


}
