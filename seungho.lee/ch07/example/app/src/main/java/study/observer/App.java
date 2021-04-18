package study.observer;

import lombok.extern.slf4j.Slf4j;
import study.observer.statuschecker.observer.StatusEmailSender;
import study.observer.statuschecker.observer.StatusMessageSender;
import study.observer.statuschecker.observer.StatusObserver;
import study.observer.statuschecker.observer.StatusSmsSender;
import study.observer.statuschecker.subject.StatusChecker;

@Slf4j
public class App {

  public static void main(String[] args) {
    log.info("Hello observer pattern!!\n");

    StatusObserver emailSender = new StatusEmailSender();
    StatusObserver smsSender = new StatusSmsSender();
    StatusObserver messageSender = new StatusMessageSender();

    StatusChecker statusChecker = new StatusChecker();
    statusChecker.add(emailSender);
    statusChecker.add(smsSender);
    statusChecker.check();

    statusChecker.add(messageSender);
    statusChecker.check();

    statusChecker.remove(emailSender);
    statusChecker.remove(smsSender);
    statusChecker.check();
  }
}
