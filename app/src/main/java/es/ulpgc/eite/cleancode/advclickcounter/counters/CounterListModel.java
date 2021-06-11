package es.ulpgc.eite.cleancode.advclickcounter.counters;

import java.util.List;

import es.ulpgc.eite.cleancode.advclickcounter.data.CounterData;

public class CounterListModel implements CounterListContract.Model {

  public static String TAG = CounterListModel.class.getSimpleName();

  private Integer counter;
  private List<CounterData> data;

  public CounterListModel(List<CounterData> data, Integer counter) {
    this.data = data;
    this.counter = counter;
  }

  @Override
  public List<CounterData> getStoredData() {
    // Log.e(TAG, "getStoredData()");
    return data;
  }

  @Override
  public void onRestartScreen(List<CounterData> data, Integer counter) {
    // Log.e(TAG, "onRestartScreen()");
    this.counter = counter;
    this.data = data;
  }

  @Override
  public void onDataFromNextScreen(String data) {
    // Log.e(TAG, "onDataFromNextScreen()");

  }

}
