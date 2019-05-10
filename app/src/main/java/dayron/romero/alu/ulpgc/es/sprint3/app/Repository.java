package dayron.romero.alu.ulpgc.es.sprint3.app;

import android.content.Context;

import java.util.List;

public class Repository implements RepositoryContract {

  public static Repository INSTANCE;
  private Context context;
  private List<ItemCount> items;
  private int clicks;

  public static Repository getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = new Repository(context);
    }
    return INSTANCE;
  }

  private Repository(Context context) {
    this.context = context;
    items.add(new ItemCount(0));
  }

  @Override
  public List<ItemCount> loadItem() {
    return items;
  }
  public void insertItem(ItemCount item){items.add(item);}

  @Override
  public void add() {
    items.add(new ItemCount(0));
  }

  @Override
  public ItemCount increase(ItemCount item) {
    clicks++;
    int count = item.getCount();
    int increased = count ++;
    item.setCount(increased);
    return item;
  }

  public int getClicks() {
    return clicks;
  }
}
