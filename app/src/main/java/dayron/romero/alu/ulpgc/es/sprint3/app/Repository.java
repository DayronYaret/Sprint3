package dayron.romero.alu.ulpgc.es.sprint3.app;

import android.content.Context;

public class Repository implements RepositoryContract {

  public static Repository INSTANCE;
  private Context context;

  public static Repository getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = new Repository(context);
    }
    return INSTANCE;
  }

  private Repository(Context context) {
    this.context = context;
  }
}
