package es.ulpgc.eite.cleancode.advclickcounter.clicks;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.advclickcounter.data.ClickData;
import es.ulpgc.eite.cleancode.advclickcounter.data.CounterData;

public interface ClickListContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onDataUpdated(ClickListViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);

    void onResume();
    void onStart();
    void onRestart();
    void onBackPressed();
    void onPause();
    void onDestroy();

    void onClickButtonPressed();

    void onClickListCell(ClickData data);
  }

  interface Model {
    List<ClickData> getStoredData();
    Integer getStoredValue();
    CounterData getStoredCounter();
    void onRestartScreen(List<ClickData> data);
    void onDataFromPreviousScreen(CounterData data);
    void addClick();
    void incrementClick(ClickData data);

  }

}
