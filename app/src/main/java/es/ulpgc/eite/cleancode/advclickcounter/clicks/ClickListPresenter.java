package es.ulpgc.eite.cleancode.advclickcounter.clicks;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.advclickcounter.app.AppMediator;
import es.ulpgc.eite.cleancode.advclickcounter.app.ClickToCounterState;
import es.ulpgc.eite.cleancode.advclickcounter.app.CounterToClickState;
import es.ulpgc.eite.cleancode.advclickcounter.data.ClickData;
import es.ulpgc.eite.cleancode.advclickcounter.data.CounterData;

public class ClickListPresenter implements ClickListContract.Presenter {

  public static String TAG = ClickListPresenter.class.getSimpleName();

  private WeakReference<ClickListContract.View> view;
  private ClickListState state;
  private ClickListContract.Model model;
  private AppMediator mediator;

  public ClickListPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getClickListState();
  }

  @Override
  public void onStart() {
    // Log.e(TAG, "onStart()");

    // initialize the state if is necessary
    if (state == null) {
      state = new ClickListState();
    }

    // use passed state if is necessary
    CounterToClickState savedState = getStateFromPreviousScreen();
    if (savedState != null) {

      // update the model if is necessary
      model.onDataFromPreviousScreen(savedState.data);
    }
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

    /*
    // use passed state if is necessary
    ClickListState savedState = router.getStateFromNextScreen();
    if (savedState != null) {

      // update the model if is necessary
      model.onDataFromNextScreen(savedState.data);
    }
    */

    // call the model and update the state
    state.data = model.getStoredData();
    state.counter = model.getStoredCounter();
    state.value = model.getStoredValue();

    // update the view
    view.get().onDataUpdated(state);

  }

  @Override
  public void onBackPressed() {
    // Log.e(TAG, "onBackPressed()");
    passStateToPreviousScreen(
            new ClickToCounterState(state.counter, state.value)
    );
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
  public void onClickButtonPressed() {
    model.addClick();
    onResume();
  }

  @Override
  public void onClickListCell(ClickData data) {
    Log.e(TAG, "onClickLetterListCell()");

//    passStateToPreviousScreen(
//            new ClickToCounterState(data,state.value)
//    );

    model.incrementClick(data);
    onResume();
  }

  private void passStateToPreviousScreen(ClickToCounterState state) {
    mediator.setPreviousClickScreenState(state);
  }

  private CounterToClickState getStateFromPreviousScreen() {
    return mediator.getPreviousClickScreenState();
  }

  @Override
  public void injectView(WeakReference<ClickListContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ClickListContract.Model model) {
    this.model = model;
  }

}
