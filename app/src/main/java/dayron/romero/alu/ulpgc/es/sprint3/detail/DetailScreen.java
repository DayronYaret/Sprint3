package dayron.romero.alu.ulpgc.es.sprint3.detail;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import dayron.romero.alu.ulpgc.es.sprint3.app.AppMediator;
import dayron.romero.alu.ulpgc.es.sprint3.app.Repository;
import dayron.romero.alu.ulpgc.es.sprint3.app.RepositoryContract;

public class DetailScreen {

  public static void configure(DetailContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    DetailState state = mediator.getDetailState();
    RepositoryContract repositorio = Repository.getInstance(context.get());

    DetailContract.Router router = new DetailRouter(mediator);
    DetailContract.Presenter presenter = new DetailPresenter(state);
    DetailContract.Model model = new DetailModel(repositorio);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
