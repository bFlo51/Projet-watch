package com.example.dark.gitblitandroid.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.example.dark.gitblitandroid.databinding.CommitItemBinding;
import com.example.dark.gitblitandroid.model.Commit;
import com.example.dark.gitblitandroid.viewmodel.CommitViewModel;

public class CommitAdapter
  extends RecyclerView.Adapter<BindingHolder>
{
  private CommitViewModel viewModel;
  
  public CommitAdapter(CommitViewModel paramCommitViewModel)
  {
    this.viewModel = paramCommitViewModel;
  }
  
  public int getItemCount()
  {
    return this.viewModel.getCount();
  }
  
  public void onBindViewHolder(BindingHolder paramBindingHolder, int paramInt)
  {
    Commit localCommit = this.viewModel.getCommit(paramInt);
    paramBindingHolder.binding.setCommit(localCommit);
  }
  
  public BindingHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new BindingHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130968604, paramViewGroup, false));
  }
  
  public class BindingHolder
    extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    private CommitItemBinding binding;
    
    public BindingHolder(View paramView)
    {
      super();
      this.binding = ((CommitItemBinding)DataBindingUtil.bind(paramView));
      paramView.setOnClickListener(this);
    }
    
    public void onClick(View paramView)
    {
      paramView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(CommitAdapter.this.viewModel.getCommit(getAdapterPosition()).getLink())));
    }
  }
}


/* Location:              C:\Users\Dark\Desktop\apk\classes-dex2jar.jar!\com\example\dark\gitblitandroid\view\CommitAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */