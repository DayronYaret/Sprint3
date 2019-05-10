package dayron.romero.alu.ulpgc.es.sprint3.master;

import java.lang.ref.WeakReference;
import java.util.List;

import dayron.romero.alu.ulpgc.es.sprint3.app.ItemCount;

interface MasterContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(MasterViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void selectItemListData(ItemCount item);

    void add();
  }

  interface Model {
    String fetchData();

    void add();

    List<ItemCount> getItems();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(ItemCount item);

    MasterState getDataFromPreviousScreen();
  }
}
