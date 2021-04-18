package study.observer.statuschecker.status;

public class Status {
  private final StatusType statusType;

  public Status(StatusType statusType) {
    this.statusType = statusType;
  }

  public boolean isNormal() {
    return StatusType.NORMAL.equals(statusType);
  }

  public boolean isNotNormal() {
    return !isNormal();
  }
}
