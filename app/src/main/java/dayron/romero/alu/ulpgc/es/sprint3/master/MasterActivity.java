package dayron.romero.alu.ulpgc.es.sprint3.master;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import dayron.romero.alu.ulpgc.es.sprint3.R;
import dayron.romero.alu.ulpgc.es.sprint3.app.ItemCount;

public class MasterActivity
    extends AppCompatActivity implements MasterContract.View {

  public static String TAG = MasterActivity.class.getSimpleName();

  private MasterContract.Presenter presenter;
  private MasterAdapter listAdapter;
  private Button addButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_master);

    listAdapter = new MasterAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        ItemCount item = (ItemCount) v.getTag();
        presenter.selectItemListData(item);
      }
    });
    RecyclerView recyclerView = findViewById(R.id.masterList);
    recyclerView.setAdapter(listAdapter);
    addButton=findViewById(R.id.button);
  addButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      presenter.add();
    }
  });
    // do the setup
    MasterScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(MasterContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(MasterViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    listAdapter.setItems(viewModel.items);
  }
}
