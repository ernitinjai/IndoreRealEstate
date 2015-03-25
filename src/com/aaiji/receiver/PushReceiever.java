package com.aaiji.receiver;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.aaiji.realestate.MainActivity;
import com.parse.ParseAnalytics;
import com.parse.ParsePushBroadcastReceiver;

public class PushReceiever extends ParsePushBroadcastReceiver  {
	
	
	
	protected void onPushOpen(Context context, Intent intent) {
		 
        ParseAnalytics.trackAppOpened(intent);
 
        String uriString = null;
        String alertString = null;
        try { 
            JSONObject pushData = new JSONObject(intent.getStringExtra("com.parse.Data"));
            uriString = pushData.optString("uri");
            alertString = pushData.optString("alert");
        } catch (JSONException e) {
            Log.v("com.parse.ParsePushReceiver", "Unexpected JSONException when receiving push data: ", e);
        } 
        Class<? extends Activity> cls = getActivity(context, intent);
        Intent activityIntent =  new Intent(context, MainActivity.class); //Default
        if (uriString != null && !uriString.isEmpty()) {
            activityIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uriString));
        }
        else { 
            activityIntent = new Intent(context, MainActivity.class);
        } 
        activityIntent.putExtras(intent.getExtras());
        /*if (Build.VERSION.SDK_INT >= 16) {
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            stackBuilder.addParentStack(cls);
            stackBuilder.addNextIntent(activityIntent);
            stackBuilder.startActivities(); 
        } else */
        { 
            activityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(activityIntent);
        } 
    }
	
	

}
