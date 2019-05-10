package dayron.romero.alu.ulpgc.es.sprint3.detail;

import java.lang.ref.WeakReference;

import dayron.romero.alu.ulpgc.es.sprint3.app.ItemCount;

interface DetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(DetailViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void increase();
  }

  interface Model {
    String fetchData();

    ItemCount increase(ItemCount item);
  }

  interface Router {

    ItemCount getDataFromPreviousScreen();
  }
}
