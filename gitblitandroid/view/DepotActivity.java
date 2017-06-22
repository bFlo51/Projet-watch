package com.example.dark.gitblitandroid.view;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.example.dark.gitblitandroid.dao.GitblitWatchDAOSQLite;
import com.example.dark.gitblitandroid.databinding.ActivityDepotBinding;
import com.example.dark.gitblitandroid.model.Depot;
import com.example.dark.gitblitandroid.viewmodel.DepotViewModel;
import com.example.dark.gitblitandroid.viewmodel.DepotViewModel.ViewActions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DepotActivity
  extends AppCompatActivity
  implements DepotViewModel.ViewActions
{
  private DepotAdapter adapter;
  protected ActivityDepotBinding binding;
  private BroadcastReceiver doneDepotReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      paramAnonymousContext = GitblitWatchDAOSQLite.getInstance(DepotActivity.this);
      DepotActivity.access$002(DepotActivity.this, paramAnonymousContext.getAllDepots());
      DepotActivity.this.binding.setViewModel(DepotActivity.access$102(DepotActivity.this, new DepotViewModel(DepotActivity.this, DepotActivity.this.liste)));
      DepotActivity.this.binding.depotsList.setLayoutManager(new LinearLayoutManager(DepotActivity.this));
      DepotActivity.access$202(DepotActivity.this, new DepotAdapter(DepotActivity.this.viewModel));
      DepotActivity.this.binding.depotsList.setAdapter(DepotActivity.this.adapter);
      if (DepotActivity.this.progressDialog != null) {
        DepotActivity.this.progressDialog.dismiss();
      }
    }
  };
  private ArrayList<Depot> liste;
  private ProgressDialog progressDialog;
  private DepotViewModel viewModel;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.binding = ((ActivityDepotBinding)DataBindingUtil.setContentView(this, 2130968602));
    this.liste = GitblitWatchDAOSQLite.getInstance(this).getAllDepots();
    paramBundle = this.binding;
    DepotViewModel localDepotViewModel = new DepotViewModel(this, this.liste);
    this.viewModel = localDepotViewModel;
    paramBundle.setViewModel(localDepotViewModel);
    this.binding.depotsList.setLayoutManager(new LinearLayoutManager(this));
    this.adapter = new DepotAdapter(this.viewModel);
    this.binding.depotsList.setAdapter(this.adapter);
    LocalBroadcastManager.getInstance(this).registerReceiver(this.doneDepotReceiver, new IntentFilter("done_depot"));
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131755009, paramMenu);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131689579) {
      startActivity(new Intent(this, SettingsActivity.class));
    }
    if (paramMenuItem.getItemId() == 2131689582)
    {
      this.progressDialog = new ProgressDialog(this);
      this.progressDialog.setMessage("Chargement en cours");
      this.progressDialog.show();
      startService(new Intent(this, DepotService.class));
    }
    if (paramMenuItem.getItemId() == 2131689581)
    {
      Object localObject = GitblitWatchDAOSQLite.getInstance(this).getAllDepots();
      Collections.sort((List)localObject);
      ActivityDepotBinding localActivityDepotBinding = this.binding;
      localObject = new DepotViewModel(this, (ArrayList)localObject);
      this.viewModel = ((DepotViewModel)localObject);
      localActivityDepotBinding.setViewModel((DepotViewModel)localObject);
      this.binding.depotsList.setLayoutManager(new LinearLayoutManager(this));
      this.adapter = new DepotAdapter(this.viewModel);
      this.binding.depotsList.setAdapter(this.adapter);
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}


/* Location:              C:\Users\Dark\Desktop\apk\classes-dex2jar.jar!\com\example\dark\gitblitandroid\view\DepotActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */