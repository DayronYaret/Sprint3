package dayron.romero.alu.ulpgc.es.sprint3.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import dayron.romero.alu.ulpgc.es.sprint3.R;

public class DetailActivity
    extends AppCompatActivity implements DetailContract.View {

  public static String TAG = DetailActivity.class.getSimpleName();

  private DetailContract.Presenter presenter;
  private Button increaseButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);

    // do the setup
    increaseButton = findViewById(R.id.increaseButton);
    increaseButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.increase();
      }
    });
    DetailScreen.configure(this);
    presenter.fetchData();
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(DetailContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(DetailViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    ((TextView) findViewById(R.id.counterTextView)).setText(Integer.toString(viewModel.item.getCount()));
    ((TextView) findViewById(R.id.clickTextView)).setText(Integer.toString(viewModel.click));
  }

}
