package dayron.romero.alu.ulpgc.es.sprint3.app;

import java.util.List;

public interface RepositoryContract {
  List<ItemCount> loadItem();
  void insertItem(ItemCount item);

  void add();

  ItemCount increase(ItemCount item);
}
