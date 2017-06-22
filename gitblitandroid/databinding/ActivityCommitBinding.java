package com.example.dark.gitblitandroid.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.ViewDataBinding.IncludedLayouts;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.example.dark.gitblitandroid.viewmodel.CommitViewModel;

public class ActivityCommitBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = null;
  private static final SparseIntArray sViewsWithIds = new SparseIntArray();
  public final RecyclerView commitsList;
  private long mDirtyFlags = -1L;
  private final RelativeLayout mboundView0;
  
  static
  {
    sViewsWithIds.put(2131689556, 1);
  }
  
  public ActivityCommitBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 0);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 2, sIncludes, sViewsWithIds);
    this.commitsList = ((RecyclerView)paramDataBindingComponent[1]);
    this.mboundView0 = ((RelativeLayout)paramDataBindingComponent[0]);
    this.mboundView0.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static ActivityCommitBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static ActivityCommitBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/activity_commit_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new ActivityCommitBinding(paramDataBindingComponent, paramView);
  }
  
  public static ActivityCommitBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static ActivityCommitBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968601, null, false), paramDataBindingComponent);
  }
  
  public static ActivityCommitBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static ActivityCommitBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (ActivityCommitBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968601, paramViewGroup, paramBoolean, paramDataBindingComponent);
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.mDirtyFlags;
      this.mDirtyFlags = 0L;
      return;
    }
    finally {}
  }
  
  public CommitViewModel getViewModel()
  {
    return null;
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
  
  public boolean setVariable(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public void setViewModel(CommitViewModel paramCommitViewModel) {}
}


/* Location:              C:\Users\Dark\Desktop\apk\classes-dex2jar.jar!\com\example\dark\gitblitandroid\databinding\ActivityCommitBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */