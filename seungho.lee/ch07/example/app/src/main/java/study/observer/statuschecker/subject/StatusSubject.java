package study.observer.statuschecker.subject;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import study.observer.statuschecker.status.Status;
import study.observer.statuschecker.observer.StatusObserver;

@Slf4j
public abstract class StatusSubject {
  private final List<StatusObserver> observers = new ArrayList<>();

  public void add(StatusObserver observer) {
    log.debug("Add {} to observers.", observer.getClass().getSimpleName());
    observers.add(observer);
  }

  public void remove(StatusObserver observer) {
    log.debug("Remove {} from observers.", observer.getClass().getSimpleName());
    observers.remove(observer);
  }

  public void notifyStatus(Status status) {
    for (StatusObserver observer : observers) {
      observer.onAbnormalStatus(status);
    }
    log.debug("Status notification is complete.\n");
  }

}
