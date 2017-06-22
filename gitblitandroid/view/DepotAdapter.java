package com.example.dark.gitblitandroid.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.example.dark.gitblitandroid.databinding.DepotItemBinding;
import com.example.dark.gitblitandroid.model.Depot;
import com.example.dark.gitblitandroid.viewmodel.DepotViewModel;
import java.io.Serializable;
import java.util.ArrayList;

public class DepotAdapter
  extends RecyclerView.Adapter<BindingHolder>
{
  private DepotViewModel viewModel;
  
  public DepotAdapter(DepotViewModel paramDepotViewModel)
  {
    this.viewModel = paramDepotViewModel;
  }
  
  public int getItemCount()
  {
    return this.viewModel.getCount();
  }
  
  public void onBindViewHolder(BindingHolder paramBindingHolder, int paramInt)
  {
    Depot localDepot = this.viewModel.getDepot(paramInt);
    paramBindingHolder.binding.setDepot(localDepot);
  }
  
  public BindingHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new BindingHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130968605, paramViewGroup, false));
  }
  
  public class BindingHolder
    extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    private DepotItemBinding binding;
    
    public BindingHolder(View paramView)
    {
      super();
      this.binding = ((DepotItemBinding)DataBindingUtil.bind(paramView));
      paramView.setOnClickListener(this);
    }
    
    public void onClick(View paramView)
    {
      Intent localIntent = new Intent(paramView.getContext(), CommitActivity.class);
      localIntent.putExtra("depot", (Serializable)DepotAdapter.this.viewModel.getDepots().get(getAdapterPosition()));
      paramView.getContext().startActivity(localIntent);
    }
  }
}


/* Location:              C:\Users\Dark\Desktop\apk\classes-dex2jar.jar!\com\example\dark\gitblitandroid\view\DepotAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */