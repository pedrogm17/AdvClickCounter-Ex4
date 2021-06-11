package es.ulpgc.eite.cleancode.advclickcounter.clicks;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.advclickcounter.R;
import es.ulpgc.eite.cleancode.advclickcounter.app.AppMediator;

public class ClickListScreen {

  public static void configure(ClickListContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    String data = context.get().getString(R.string.app_name);

    AppMediator mediator = AppMediator.getInstance();

    ClickListContract.Presenter presenter = new ClickListPresenter(mediator);
    ClickListContract.Model model = new ClickListModel(data);
    presenter.injectModel(model);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
