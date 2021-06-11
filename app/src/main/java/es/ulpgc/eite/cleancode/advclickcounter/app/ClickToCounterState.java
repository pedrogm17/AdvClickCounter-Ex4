package es.ulpgc.eite.cleancode.advclickcounter.app;

import es.ulpgc.eite.cleancode.advclickcounter.data.CounterData;

public class ClickToCounterState {

  public CounterData data;
  public Integer value;

  public ClickToCounterState(CounterData data, Integer value){
    this.data = data;
    this.value = value;
  }
}
