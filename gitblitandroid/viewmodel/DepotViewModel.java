package com.example.dark.gitblitandroid.viewmodel;

import android.databinding.BaseObservable;
import com.example.dark.gitblitandroid.model.Depot;
import java.util.ArrayList;

public class DepotViewModel
  extends BaseObservable
{
  public ViewActions actions;
  private ArrayList<Depot> depots;
  
  public DepotViewModel(ViewActions paramViewActions, ArrayList<Depot> paramArrayList)
  {
    this.actions = paramViewActions;
    this.depots = paramArrayList;
  }
  
  public int getCount()
  {
    return this.depots.size();
  }
  
  public Depot getDepot(int paramInt)
  {
    return (Depot)this.depots.get(paramInt);
  }
  
  public ArrayList<Depot> getDepots()
  {
    return this.depots;
  }
  
  public static abstract interface ViewActions {}
}


/* Location:              C:\Users\Dark\Desktop\apk\classes-dex2jar.jar!\com\example\dark\gitblitandroid\viewmodel\DepotViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */