package es.ulpgc.eite.cleancode.advclickcounter.clicks;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.advclickcounter.data.ClickData;
import es.ulpgc.eite.cleancode.advclickcounter.data.CounterData;

public class ClickListModel implements ClickListContract.Model {

  public static String TAG = ClickListModel.class.getSimpleName();

  private List<ClickData> data;
  private CounterData counter;
  private Integer value;

  public ClickListModel() {
    data = new ArrayList<>();
    value = 0;
  }

  @Override
  public List<ClickData> getStoredData() {
    // Log.e(TAG, "getStoredData()");
    return data;
  }

  @Override
  public Integer getStoredValue() {
    // Log.e(TAG, "getStoredData()");
    return value;
  }

  @Override
  public CounterData getStoredCounter() {
    // Log.e(TAG, "getStoredData()");
    return counter;
  }

  @Override
  public void onRestartScreen(List<ClickData> data) {
    // Log.e(TAG, "onRestartScreen()");
    this.data = data;
  }


  @Override
  public void onDataFromPreviousScreen(CounterData counter) {
    // Log.e(TAG, "onDataFromPreviousScreen()");
    this.counter = counter;
  }

  @Override
  public void addClick(){
    ClickData clickN = new ClickData();
    data.add(clickN);
  }

  @Override
  public void incrementClick(ClickData data){
    data.value++;
    this.value++;
  }
}
