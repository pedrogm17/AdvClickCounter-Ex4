package es.ulpgc.eite.cleancode.advclickcounter.counters;

import java.lang.ref.WeakReference;

public interface CounterListContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onDataUpdated(CounterListViewModel viewModel);
    void navigateToNextScreen();

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
    void onCounterButtonPressed();
  }

  interface Model {
    String getStoredData();

    void onDataFromNextScreen(String data);
    void onRestartScreen(String data);
    void onDataFromPreviousScreen(String data);
  }

}
