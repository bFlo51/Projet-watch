package com.example.dark.gitblitandroid.view;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

public class SettingsActivity
  extends AppCompatActivity
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  boolean verification = false;
  
  private void repeatDepotService(int paramInt)
  {
    PendingIntent localPendingIntent = PendingIntent.getService(this, 0, new Intent(this, DepotService.class), 0);
    AlarmManager localAlarmManager = (AlarmManager)getSystemService("alarm");
    if (!this.verification)
    {
      localAlarmManager.cancel(localPendingIntent);
      return;
    }
    localAlarmManager.setInexactRepeating(2, SystemClock.elapsedRealtime(), paramInt, localPendingIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968603);
    setTitle("Paramètres");
    PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    this.verification = paramSharedPreferences.getBoolean("Notifications", false);
    repeatDepotService(Integer.parseInt(paramSharedPreferences.getString("Frequence_verif", "20")) * 60000);
  }
}


/* Location:              C:\Users\Dark\Desktop\apk\classes-dex2jar.jar!\com\example\dark\gitblitandroid\view\SettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */