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
import com.example.dark.gitblitandroid.model.Depot;

public class DepotItemBinding
  extends ViewDataBinding
{
  private static final ViewDataBinding.IncludedLayouts sIncludes = null;
  private static final SparseIntArray sViewsWithIds = null;
  public final TextView itemDepotAccess;
  public final TextView itemDepotCreator;
  public final TextView itemDepotDescription;
  public final TextView itemDepotLast;
  public final TextView itemNomDepot;
  private Depot mDepot;
  private long mDirtyFlags = -1L;
  private final RelativeLayout mboundView0;
  
  public DepotItemBinding(DataBindingComponent paramDataBindingComponent, View paramView)
  {
    super(paramDataBindingComponent, paramView, 0);
    paramDataBindingComponent = mapBindings(paramDataBindingComponent, paramView, 6, sIncludes, sViewsWithIds);
    this.itemDepotAccess = ((TextView)paramDataBindingComponent[5]);
    this.itemDepotAccess.setTag(null);
    this.itemDepotCreator = ((TextView)paramDataBindingComponent[2]);
    this.itemDepotCreator.setTag(null);
    this.itemDepotDescription = ((TextView)paramDataBindingComponent[3]);
    this.itemDepotDescription.setTag(null);
    this.itemDepotLast = ((TextView)paramDataBindingComponent[4]);
    this.itemDepotLast.setTag(null);
    this.itemNomDepot = ((TextView)paramDataBindingComponent[1]);
    this.itemNomDepot.setTag(null);
    this.mboundView0 = ((RelativeLayout)paramDataBindingComponent[0]);
    this.mboundView0.setTag(null);
    setRootTag(paramView);
    invalidateAll();
  }
  
  public static DepotItemBinding bind(View paramView)
  {
    return bind(paramView, DataBindingUtil.getDefaultComponent());
  }
  
  public static DepotItemBinding bind(View paramView, DataBindingComponent paramDataBindingComponent)
  {
    if (!"layout/depot_item_0".equals(paramView.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + paramView.getTag());
    }
    return new DepotItemBinding(paramDataBindingComponent, paramView);
  }
  
  public static DepotItemBinding inflate(LayoutInflater paramLayoutInflater)
  {
    return inflate(paramLayoutInflater, DataBindingUtil.getDefaultComponent());
  }
  
  public static DepotItemBinding inflate(LayoutInflater paramLayoutInflater, DataBindingComponent paramDataBindingComponent)
  {
    return bind(paramLayoutInflater.inflate(2130968605, null, false), paramDataBindingComponent);
  }
  
  public static DepotItemBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflate(paramLayoutInflater, paramViewGroup, paramBoolean, DataBindingUtil.getDefaultComponent());
  }
  
  public static DepotItemBinding inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, boolean paramBoolean, DataBindingComponent paramDataBindingComponent)
  {
    return (DepotItemBinding)DataBindingUtil.inflate(paramLayoutInflater, 2130968605, paramViewGroup, paramBoolean, paramDataBindingComponent);
  }
  
  protected void executeBindings()
  {
    try
    {
      long l = this.mDirtyFlags;
      this.mDirtyFlags = 0L;
      Object localObject7 = null;
      Depot localDepot = this.mDepot;
      Object localObject8 = null;
      Object localObject9 = null;
      Object localObject10 = null;
      Object localObject11 = null;
      Object localObject6 = localObject7;
      Object localObject5 = localObject10;
      Object localObject4 = localObject8;
      Object localObject3 = localObject11;
      Object localObject1 = localObject9;
      if ((l & 0x3) != 0L)
      {
        localObject6 = localObject7;
        localObject5 = localObject10;
        localObject4 = localObject8;
        localObject3 = localObject11;
        localObject1 = localObject9;
        if (localDepot != null)
        {
          localObject6 = localDepot.getAccess();
          localObject4 = localDepot.getDescription();
          localObject1 = localDepot.getNom();
          localObject5 = localDepot.getCreator();
          localObject3 = localDepot.getLastChange();
        }
      }
      if ((l & 0x3) != 0L)
      {
        this.itemDepotAccess.setText((CharSequence)localObject6);
        this.itemDepotCreator.setText((CharSequence)localObject5);
        this.itemDepotDescription.setText((CharSequence)localObject4);
        this.itemDepotLast.setText((CharSequence)localObject3);
        this.itemNomDepot.setText((CharSequence)localObject1);
      }
      return;
    }
    finally {}
  }
  
  public Depot getDepot()
  {
    return this.mDepot;
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
  
  public void setDepot(Depot paramDepot)
  {
    this.mDepot = paramDepot;
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
    setDepot((Depot)paramObject);
    return true;
  }
}


/* Location:              C:\Users\Dark\Desktop\apk\classes-dex2jar.jar!\com\example\dark\gitblitandroid\databinding\DepotItemBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */