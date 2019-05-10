package dayron.romero.alu.ulpgc.es.sprint3.detail;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

import dayron.romero.alu.ulpgc.es.sprint3.app.ItemCount;
import dayron.romero.alu.ulpgc.es.sprint3.app.RepositoryContract;

public class DetailModel implements DetailContract.Model {

  public static String TAG = DetailModel.class.getSimpleName();
  private RepositoryContract repositorio;
  public DetailModel(RepositoryContract repositorio) {
  this.repositorio=repositorio;
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }

  @Override
  public ItemCount increase(ItemCount item) {
    ItemCount newItem = repositorio.increase(item);
    return newItem;
  }
}
