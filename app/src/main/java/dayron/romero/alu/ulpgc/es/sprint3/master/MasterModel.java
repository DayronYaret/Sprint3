package dayron.romero.alu.ulpgc.es.sprint3.master;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

import dayron.romero.alu.ulpgc.es.sprint3.app.ItemCount;
import dayron.romero.alu.ulpgc.es.sprint3.app.RepositoryContract;

public class MasterModel implements MasterContract.Model {

  public static String TAG = MasterModel.class.getSimpleName();

  private RepositoryContract repositorio;
  public MasterModel(RepositoryContract repositorio) {
  this.repositorio=repositorio;
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }

  @Override
  public void add() {
    repositorio.add();
  }

  public List<ItemCount> getItems(){return repositorio.loadItem();}
}
