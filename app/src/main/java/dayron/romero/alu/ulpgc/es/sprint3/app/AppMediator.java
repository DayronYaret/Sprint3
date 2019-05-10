package dayron.romero.alu.ulpgc.es.sprint3.app;

import android.app.Application;

import dayron.romero.alu.ulpgc.es.sprint3.detail.DetailState;
import dayron.romero.alu.ulpgc.es.sprint3.master.MasterState;

public class AppMediator extends Application {
  private MasterState masterstate;
  private DetailState detailState;
  private ItemCount item;

  public AppMediator() {
    masterstate = new MasterState();
    detailState = new DetailState();
  }

  public MasterState getMasterState() {
    return masterstate;
  }

  public void setMasterState(ItemCount item) {
    this.item = item;
  }

  public DetailState getDetailState() {
    return detailState;
  }

  public void setDetailState(DetailState state) {
    this.detailState = state;
  }

  public ItemCount getItem() {
    return item;
  }
}
