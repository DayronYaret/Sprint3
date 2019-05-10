package dayron.romero.alu.ulpgc.es.sprint3.master;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import dayron.romero.alu.ulpgc.es.sprint3.app.AppMediator;
import dayron.romero.alu.ulpgc.es.sprint3.app.Repository;
import dayron.romero.alu.ulpgc.es.sprint3.app.RepositoryContract;

public class MasterScreen {

  public static void configure(MasterContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    MasterState state = mediator.getMasterState();
    RepositoryContract repositorio = Repository.getInstance(context.get());

    MasterContract.Router router = new MasterRouter(mediator);
    MasterContract.Presenter presenter = new MasterPresenter(state);
    MasterContract.Model model = new MasterModel(repositorio);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
