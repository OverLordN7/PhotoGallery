package space.oln7.photogallery;

import android.app.Activity;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class NotificationReceiver extends BroadcastReceiver {
    private static final String TAG = "NotificationReceiver";

    @Override
    public void onReceive(Context c, Intent i) {
        Log.i(TAG, "received result: "+ getResultCode());
        if(getResultCode()!= Activity.RESULT_OK){
            return;
        }

        int requestCode = i.getIntExtra(PollService.REQUEST_CODE,0);
        Notification notification = (Notification) i.getParcelableExtra(PollService.NOTIFICATION);

    }
}
