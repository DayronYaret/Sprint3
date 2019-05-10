package dayron.romero.alu.ulpgc.es.sprint3.app;

import java.util.List;

public interface RepositoryContract {
  List<ItemCount> loadItem();
  void insertItem(ItemCount item);
  int getClicks();
  void add();

  ItemCount increase(int id);

  ItemCount getItem(int id);
}
