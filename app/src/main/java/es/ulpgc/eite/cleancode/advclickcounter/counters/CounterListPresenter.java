package es.ulpgc.eite.cleancode.advclickcounter.counters;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.advclickcounter.app.AppMediator;
import es.ulpgc.eite.cleancode.advclickcounter.app.ClickToCounterState;
import es.ulpgc.eite.cleancode.advclickcounter.app.CounterToClickState;

public class CounterListPresenter implements CounterListContract.Presenter {

  public static String TAG = CounterListPresenter.class.getSimpleName();

  private WeakReference<CounterListContract.View> view;
  private CounterListState state;
  private CounterListContract.Model model;
  private AppMediator mediator;

  public CounterListPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getCounterListState();
  }


  @Override
  public void onStart() {
    // Log.e(TAG, "onStart()");

    // initialize the state if is necessary
    if (state == null) {
      state = new CounterListState();
    }

    /*
    // use passed state if is necessary
    CounterListState savedState = router.getStateFromPreviousScreen();
    if (savedState != null) {

      // update the model if is necessary
      model.onDataFromPreviousScreen(savedState.data);
    }
    */
  }

  @Override
  public void onRestart() {
    // Log.e(TAG, "onRestart()");

    // update the model if is necessary
    model.onRestartScreen(state.data);
  }

  @Override
  public void onResume() {
    // Log.e(TAG, "onResume()");

    // use passed state if is necessary
    ClickToCounterState savedState = getStateFromNextScreen();
    if (savedState != null) {

      // update the model if is necessary
      model.onDataFromNextScreen(savedState.data);
    }

    // call the model and update the state
    state.data = model.getStoredData();

    // update the view
    view.get().onDataUpdated(state);

  }

  @Override
  public void onBackPressed() {
    // Log.e(TAG, "onBackPressed()");
  }

  @Override
  public void onPause() {
    // Log.e(TAG, "onPause()");
  }

  @Override
  public void onDestroy() {
    // Log.e(TAG, "onDestroy()");
  }

  @Override
  public void onCounterButtonPressed() {

  }

  private void passStateToNextScreen(CounterToClickState state) {
    mediator.setNextCounterScreenState(state);
  }

  private ClickToCounterState getStateFromNextScreen() {
    return mediator.getNextCounterScreenState();
  }

  /*
  private void passStateToPreviousScreen(CounterListState state) {
    mediator.setPreviousCounterScreenState(state);
  }

  private CounterListState getStateFromPreviousScreen() {
    return mediator.getPreviousCounterScreenState();
  }
  */

  @Override
  public void injectView(WeakReference<CounterListContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(CounterListContract.Model model) {
    this.model = model;
  }

}
