package study.observer.statuschecker.subject;

import lombok.extern.slf4j.Slf4j;
import study.observer.statuschecker.status.Status;
import study.observer.statuschecker.status.StatusType;

@Slf4j
public class StatusChecker extends StatusSubject {

  public void check() {
    Status status = loadStatus();

    if (status.isNotNormal()) {
      super.notifyStatus(status);
    }
  }

  private Status loadStatus() {
    log.debug("Current status is a {}.", StatusType.FAULT);
    return new Status(StatusType.FAULT);
  }
}
