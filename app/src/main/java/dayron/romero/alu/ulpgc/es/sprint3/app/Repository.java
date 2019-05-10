package dayron.romero.alu.ulpgc.es.sprint3.app;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Repository implements RepositoryContract {

  public static Repository INSTANCE;
  private Context context;
  private List<ItemCount> items = new ArrayList<>();
  private int clicks = 0;

  public static Repository getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = new Repository(context);
    }
    return INSTANCE;
  }

  private Repository(Context context) {
    this.context = context;
    items.add(new ItemCount(0, 1));
  }

  @Override
  public List<ItemCount> loadItem() {
    return items;
  }
  public void insertItem(ItemCount item){items.add(item);}

  @Override
  public void add() {
    items.add(new ItemCount(0, items.size()+1));
  }

  @Override
  public ItemCount increase(int id) {
    clicks++;
    for(int i =0; i<items.size(); i++) {
      if (id == items.get(i).getId()) {
        items.get(i).setCount(items.get(i).getCount() + 1);
        return items.get(i);
      }
    }
    return null;
  }

  @Override
  public ItemCount getItem(int id) {
    for(int i =0; i<items.size(); i++) {
      if (id == items.get(i).getId()) {
        return items.get(i);
      }
    }
    return null;
  }

  public int getClicks() {
    return clicks;
  }
}
