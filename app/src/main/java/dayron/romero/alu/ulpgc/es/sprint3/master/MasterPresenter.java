package dayron.romero.alu.ulpgc.es.sprint3.master;

import android.util.Log;

import java.lang.ref.WeakReference;

import dayron.romero.alu.ulpgc.es.sprint3.app.ItemCount;

public class MasterPresenter implements MasterContract.Presenter {

  public static String TAG = MasterPresenter.class.getSimpleName();

  private WeakReference<MasterContract.View> view;
  private MasterViewModel viewModel;
  private MasterContract.Model model;
  private MasterContract.Router router;

  public MasterPresenter(MasterState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<MasterContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(MasterContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(MasterContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    viewModel.items = model.getItems();
    view.get().displayData(viewModel);

  }

  @Override
  public void selectItemListData(ItemCount item) {
    router.passDataToNextScreen(item);
    router.navigateToNextScreen();
  }

  @Override
  public void add() {
    model.add();
  }


}
