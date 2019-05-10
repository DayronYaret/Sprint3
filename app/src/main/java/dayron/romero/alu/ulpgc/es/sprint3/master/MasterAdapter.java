package dayron.romero.alu.ulpgc.es.sprint3.master;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dayron.romero.alu.ulpgc.es.sprint3.R;
import dayron.romero.alu.ulpgc.es.sprint3.app.ItemCount;

public class MasterAdapter extends RecyclerView.Adapter<MasterAdapter.ViewHolder> {

  private List<ItemCount> itemList;
  private final View.OnClickListener clickListener;


  public MasterAdapter(View.OnClickListener listener){

    itemList = new ArrayList();
    clickListener = listener;
  }
  public void addItem(ItemCount item){
    itemList.add(item);
    notifyDataSetChanged();
  }
  public void  addItems(List<ItemCount> items){
    itemList.addAll(items);
    notifyDataSetChanged();
  }
  public void setItems(List<ItemCount> items){
    itemList =items;
    notifyDataSetChanged();
  }
  class ViewHolder extends RecyclerView.ViewHolder{
    final TextView countTextView;

    ViewHolder (View view){
      super(view);
      countTextView = view.findViewById(R.id.counterTextView);


    }
  }
  @Override
  public int getItemCount() {
    if (itemList.size() != 0)
      return itemList.size();
    return 0;
  }
  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.master_list_content, parent, false);
    return new ViewHolder(view);

  }
  @Override
  public void onBindViewHolder(final ViewHolder holder, int position){
    holder.itemView.setTag(itemList.get(position));
    holder.itemView.setOnClickListener(clickListener);

    holder.countTextView.setText(itemList.get(position).getCount());
  }


}
