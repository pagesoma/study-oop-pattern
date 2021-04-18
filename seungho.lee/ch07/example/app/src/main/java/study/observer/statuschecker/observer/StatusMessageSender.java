package study.observer.statuschecker.observer;

import lombok.extern.slf4j.Slf4j;
import study.observer.statuschecker.status.Status;

@Slf4j
public class StatusMessageSender implements StatusObserver {

  @Override
  public void onAbnormalStatus(Status status) {
    sendMessage(status);
  }

  private void sendMessage(Status status) {
    log.debug("[Send message]");
  }
}
