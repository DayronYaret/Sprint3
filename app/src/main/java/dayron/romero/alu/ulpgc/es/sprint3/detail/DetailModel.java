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
  public int fetchData() {
    // Log.e(TAG, "fetchData()");
    return repositorio.getClicks();
  }



  @Override
  public ItemCount increase(int id) {

    return repositorio.increase(id);
  }

  @Override
  public ItemCount fetchItem(int id) {
    return repositorio.getItem(id);
  }
}
