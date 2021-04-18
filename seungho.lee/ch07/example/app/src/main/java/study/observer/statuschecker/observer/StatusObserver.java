package study.observer.statuschecker.observer;

import study.observer.statuschecker.status.Status;

public interface StatusObserver {

  void onAbnormalStatus(Status status);
}
