package com.example.dark.gitblitandroid.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.ViewDataBinding.IncludedLayouts;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.dark.gitblitandroid.model.Commit;

public class CommitItemBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = null;
  private static final SparseIntArray sViewsWithIds = null;
  public final TextView itemCommitCreator;
  public final TextView itemCommitDescription;
  public final TextView itemDateCommit;
  private Commit mCommit;
  private long mDirtyFlags = -1L;
  private final RelativeLayout mboundView0;
  
  public CommitItemBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 0);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 4, sIncludes, sViewsWithIds);
    this.itemCommitCreator = ((TextView)paramDataBindingComponent[1]);
    this.itemCommitCreator.setTag(null);
    this.itemCommitDescription = ((TextView)paramDataBindingComponent[3]);
    this.itemCommitDescription.setTag(null);
    this.itemDateCommit = ((TextView)paramDataBindingComponent[2]);
    this.itemDateCommit.setTag(null);
    this.mboundView0 = ((RelativeLayout)paramDataBindingComponent[0]);
    this.mboundView0.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static CommitItemBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static CommitItemBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/commit_item_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new CommitItemBinding(paramDataBindingComponent, paramView);
  }
  
  public static CommitItemBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static CommitItemBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968604, null, false), paramDataBindingComponent);
  }
  
  public static CommitItemBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static CommitItemBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (CommitItemBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968604, paramViewGroup, paramBoolean, paramDataBindingComponent);
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.mDirtyFlags;
      this.mDirtyFlags = 0L;
      Object localObject5 = null;
      Object localObject6 = null;
      Object localObject7 = null;
      Commit localCommit = this.mCommit;
      Object localObject4 = localObject6;
      Object localObject3 = localObject5;
      Object localObject1 = localObject7;
      if ((l & 0x3) != 0L)
      {
        localObject4 = localObject6;
        localObject3 = localObject5;
        localObject1 = localObject7;
        if (localCommit != null)
        {
          localObject3 = localCommit.getDescription();
          localObject4 = localCommit.getDateCommit();
          localObject1 = localCommit.getDevelopper();
        }
      }
      if ((l & 0x3) != 0L)
      {
        this.itemCommitCreator.setText((CharSequence)localObject1);
        this.itemCommitDescription.setText((CharSequence)localObject3);
        this.itemDateCommit.setText((CharSequence)localObject4);
      }
      return;
    }
    finally {}
  }
  
  public Commit getCommit()
  {
    return this.mCommit;
  }
  
  public boolean hasPendingBindings()
  {
    try
    {
      return this.mDirtyFlags != 0L;
    }
    finally {}
  }
  
  public void invalidateAll()
  {
    try
    {
      this.mDirtyFlags = 2L;
      requestRebind();
      return;
    }
    finally {}
  }
  
  protected boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    return false;
  }
  
  public void setCommit(Commit paramCommit)
  {
    this.mCommit = paramCommit;
    try
    {
      this.mDirtyFlags |= 1L;
      super.requestRebind();
      return;
    }
    finally {}
  }
  
  public boolean setVariable(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    setCommit((Commit)paramObject);
    return true;
  }
}


/* Location:              C:\Users\Dark\Desktop\apk\classes-dex2jar.jar!\com\example\dark\gitblitandroid\databinding\CommitItemBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */