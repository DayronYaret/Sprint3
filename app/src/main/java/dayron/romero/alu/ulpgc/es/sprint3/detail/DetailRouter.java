package dayron.romero.alu.ulpgc.es.sprint3.detail;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import dayron.romero.alu.ulpgc.es.sprint3.app.AppMediator;
import dayron.romero.alu.ulpgc.es.sprint3.app.ItemCount;

public class DetailRouter implements DetailContract.Router {

  public static String TAG = DetailRouter.class.getSimpleName();

  private AppMediator mediator;

  public DetailRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public ItemCount getDataFromPreviousScreen() {
    ItemCount item = mediator.getItem();
    mediator.setItem(null);
    return item;
  }
}
