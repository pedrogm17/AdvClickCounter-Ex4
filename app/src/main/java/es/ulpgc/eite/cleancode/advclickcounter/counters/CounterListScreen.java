package es.ulpgc.eite.cleancode.advclickcounter.counters;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.advclickcounter.R;
import es.ulpgc.eite.cleancode.advclickcounter.app.AppMediator;

public class CounterListScreen {

  public static void configure(CounterListContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    String data = context.get().getString(R.string.app_name);

    AppMediator mediator = AppMediator.getInstance();

    CounterListContract.Presenter presenter = new CounterListPresenter(mediator);
    CounterListContract.Model model = new CounterListModel(data);
    presenter.injectModel(model);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
