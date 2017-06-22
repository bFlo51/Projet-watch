package com.example.dark.gitblitandroid.viewmodel;

import com.example.dark.gitblitandroid.model.Commit;
import java.util.ArrayList;

public class CommitViewModel
{
  public ViewAction actions;
  private ArrayList<Commit> commits;
  
  public CommitViewModel(ArrayList<Commit> paramArrayList, ViewAction paramViewAction)
  {
    this.commits = paramArrayList;
    this.actions = paramViewAction;
  }
  
  public Commit getCommit(int paramInt)
  {
    return (Commit)this.commits.get(paramInt);
  }
  
  public int getCount()
  {
    return this.commits.size();
  }
  
  public static abstract interface ViewAction {}
}


/* Location:              C:\Users\Dark\Desktop\apk\classes-dex2jar.jar!\com\example\dark\gitblitandroid\viewmodel\CommitViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */