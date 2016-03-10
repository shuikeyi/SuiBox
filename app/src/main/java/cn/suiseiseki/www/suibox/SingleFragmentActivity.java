package cn.suiseiseki.www.suibox;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/3/10.
 */
public abstract class SingleFragmentActivity extends Activity {

    public abstract Fragment createFragment();
    public int getLayoutResID()
    {
        return R.layout.fragment_activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_framelayout);
        if(fragment == null)
        {  fragment = createFragment();
        fm.beginTransaction().add(R.id.fragment_framelayout,fragment).commit();}
    }


}
