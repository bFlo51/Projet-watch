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
import com.example.dark.gitblitandroid.viewmodel.DepotViewModel;

public class ActivityDepotBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = null;
  private static final SparseIntArray sViewsWithIds = new SparseIntArray();
  public final RecyclerView depotsList;
  private long mDirtyFlags = -1L;
  private final RelativeLayout mboundView0;
  
  static
  {
    sViewsWithIds.put(2131689557, 1);
  }
  
  public ActivityDepotBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 1);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 2, sIncludes, sViewsWithIds);
    this.depotsList = ((RecyclerView)paramDataBindingComponent[1]);
    this.mboundView0 = ((RelativeLayout)paramDataBindingComponent[0]);
    this.mboundView0.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static ActivityDepotBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static ActivityDepotBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/activity_depot_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new ActivityDepotBinding(paramDataBindingComponent, paramView);
  }
  
  public static ActivityDepotBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static ActivityDepotBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968602, null, false), paramDataBindingComponent);
  }
  
  public static ActivityDepotBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static ActivityDepotBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (ActivityDepotBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968602, paramViewGroup, paramBoolean, paramDataBindingComponent);
  }
  
  private boolean onChangeViewModel(DepotViewModel paramDepotViewModel, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    try
    {
      this.mDirtyFlags |= 1L;
      return true;
    }
    finally {}
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
  
  public DepotViewModel getViewModel()
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
    switch (paramInt1)
    {
    default: 
      return false;
    }
    return onChangeViewModel((DepotViewModel)paramObject, paramInt2);
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
  
  public void setViewModel(DepotViewModel paramDepotViewModel) {}
}


/* Location:              C:\Users\Dark\Desktop\apk\classes-dex2jar.jar!\com\example\dark\gitblitandroid\databinding\ActivityDepotBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */