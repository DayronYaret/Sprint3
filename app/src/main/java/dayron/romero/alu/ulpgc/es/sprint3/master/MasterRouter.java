package dayron.romero.alu.ulpgc.es.sprint3.master;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import dayron.romero.alu.ulpgc.es.sprint3.app.AppMediator;
import dayron.romero.alu.ulpgc.es.sprint3.app.ItemCount;
import dayron.romero.alu.ulpgc.es.sprint3.detail.DetailActivity;

public class MasterRouter implements MasterContract.Router {

  public static String TAG = MasterRouter.class.getSimpleName();

  private AppMediator mediator;

  public MasterRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, DetailActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(ItemCount item) {
    mediator.setMasterState(item);
  }

  @Override
  public MasterState getDataFromPreviousScreen() {
    MasterState state = mediator.getMasterState();
    return state;
  }
}
