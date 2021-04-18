package study.observer.statuschecker.observer;

import lombok.extern.slf4j.Slf4j;
import study.observer.statuschecker.status.Status;

@Slf4j
public class StatusSmsSender implements StatusObserver {

  @Override
  public void onAbnormalStatus(Status status) {
    sendSms(status);
  }

  private void sendSms(Status status) {
    log.debug("[Send sms]");
  }
}
