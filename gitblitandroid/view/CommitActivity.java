package com.example.dark.gitblitandroid.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.example.dark.gitblitandroid.dao.GitblitWatchDAOSQLite;
import com.example.dark.gitblitandroid.databinding.ActivityCommitBinding;
import com.example.dark.gitblitandroid.model.Depot;
import com.example.dark.gitblitandroid.viewmodel.CommitViewModel;
import com.example.dark.gitblitandroid.viewmodel.CommitViewModel.ViewAction;

public class CommitActivity
  extends AppCompatActivity
  implements CommitViewModel.ViewAction
{
  protected ActivityCommitBinding binding;
  protected CommitViewModel viewModel;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = (Depot)getIntent().getExtras().getSerializable("depot");
    setTitle(paramBundle.getNom());
    this.binding = ((ActivityCommitBinding)DataBindingUtil.setContentView(this, 2130968601));
    this.viewModel = new CommitViewModel(GitblitWatchDAOSQLite.getInstance(this).getAllCommits(paramBundle), this);
    this.binding.commitsList.setLayoutManager(new LinearLayoutManager(this));
    paramBundle = new CommitAdapter(this.viewModel);
    this.binding.commitsList.setAdapter(paramBundle);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131755008, paramMenu);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    Depot localDepot = (Depot)getIntent().getExtras().getSerializable("depot");
    if (paramMenuItem.getItemId() == 2131689579) {
      startActivity(new Intent(this, SettingsActivity.class));
    }
    if (paramMenuItem.getItemId() == 2131689580) {
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://lps3im.univ-reims.fr:4322/gitblit/summary/?r=~" + localSharedPreferences.getString("Identifiant", "bocah002") + "/" + localDepot.getNom())));
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}


/* Location:              C:\Users\Dark\Desktop\apk\classes-dex2jar.jar!\com\example\dark\gitblitandroid\view\CommitActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */