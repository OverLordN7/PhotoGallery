package space.oln7.photogallery;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public  abstract class VisibleFragment  extends Fragment {
    private static final String TAG = "visibleFragment";

    @Override
    public void onStart(){
        super.onStart();

        IntentFilter filter = new IntentFilter(PollService.ACTION_SHOW_NOTIFICATION);
        getActivity().registerReceiver(mOnShowNotification, filter,PollService.PERM_PRIVATE,null);
    }

    @Override
    public void onStop(){
        super.onStop();
        getActivity().unregisterReceiver(mOnShowNotification);
    }

    private BroadcastReceiver mOnShowNotification = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i(TAG,"Canceling notification");
            setResultCode(Activity.RESULT_CANCELED);
        }
    };
}
