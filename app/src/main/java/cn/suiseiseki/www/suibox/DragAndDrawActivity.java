package cn.suiseiseki.www.suibox;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class DragAndDrawActivity extends SingleFragmentActivity
{
    @Override
    public Fragment createFragment()
    {
        return new DragAndDrawFragment();
    }
}
