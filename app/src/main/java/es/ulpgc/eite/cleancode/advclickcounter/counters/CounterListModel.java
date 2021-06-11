package es.ulpgc.eite.cleancode.advclickcounter.counters;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.advclickcounter.data.CounterData;

public class CounterListModel implements CounterListContract.Model {

  public static String TAG = CounterListModel.class.getSimpleName();

  private List<CounterData> data;

  public CounterListModel() {
    data = new ArrayList<>();
  }

  @Override
  public List<CounterData> getStoredData() {
    // Log.e(TAG, "getStoredData()");
    return data;
  }


  @Override
  public void onRestartScreen(List<CounterData> data, Integer counter) {
    // Log.e(TAG, "onRestartScreen()");
    this.data = data;
  }

  @Override
  public void onDataFromNextScreen(CounterData counter, Integer value) {
    // Log.e(TAG, "onDataFromNextScreen()");
    this.data.set(data.indexOf(counter), counter);
    data.get(data.indexOf(data)).value = value;
  }

  public void addCounter(){
    CounterData counterN = new CounterData();
    data.add(counterN);
  }

}
