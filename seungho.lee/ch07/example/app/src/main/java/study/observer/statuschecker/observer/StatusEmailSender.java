package study.observer.statuschecker.observer;

import lombok.extern.slf4j.Slf4j;
import study.observer.statuschecker.status.Status;

@Slf4j
public class StatusEmailSender implements StatusObserver{

  @Override
  public void onAbnormalStatus(Status status) {
    sendEmail(status);
  }

  private void sendEmail(Status status) {
    log.debug("[Send email]");
  }
}
