package dayron.romero.alu.ulpgc.es.sprint3.detail;

import android.util.Log;

import java.lang.ref.WeakReference;

import dayron.romero.alu.ulpgc.es.sprint3.app.ItemCount;

public class DetailPresenter implements DetailContract.Presenter {

  public static String TAG = DetailPresenter.class.getSimpleName();

  private WeakReference<DetailContract.View> view;
  private DetailViewModel viewModel;
  private DetailContract.Model model;
  private DetailContract.Router router;

  public DetailPresenter(DetailState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<DetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(DetailContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(DetailContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    ItemCount item = router.getDataFromPreviousScreen();
    viewModel.item = item;
    view.get().displayData(viewModel);


    // update the view
    view.get().displayData(viewModel);

  }

  @Override
  public void increase() {
    ItemCount increased= model.increase(viewModel.item);
    viewModel.item = increased;
    fetchData();
  }


}
