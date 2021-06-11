package es.ulpgc.eite.cleancode.advclickcounter.counters;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.advclickcounter.data.CounterData;

public class CounterListModel implements CounterListContract.Model {

  public static String TAG = CounterListModel.class.getSimpleName();

  private Integer counter;
  private List<CounterData> data;

  public CounterListModel() {
    data = new ArrayList<>();
    counter = 0;
  }

  @Override
  public List<CounterData> getStoredData() {
    // Log.e(TAG, "getStoredData()");
    return data;
  }

  @Override
  public Integer getStoredCounter() {
    // Log.e(TAG, "getStoredData()");
    return counter;
  }

  @Override
  public void onRestartScreen(List<CounterData> data, Integer counter) {
    // Log.e(TAG, "onRestartScreen()");
    this.counter = counter;
    this.data = data;
  }

  @Override
  public void onDataFromNextScreen(CounterData counter, Integer value) {
    // Log.e(TAG, "onDataFromNextScreen()");
    this.data.set(value, counter);

  }

  public void addCounter(){
    CounterData counterN = new CounterData();
    data.add(counterN);
  }

}
