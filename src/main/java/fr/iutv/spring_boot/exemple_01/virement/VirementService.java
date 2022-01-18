package fr.iutv.spring_boot.exemple_01.virement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;

public interface VirementService {

  boolean transfererArgent(DemandeVirement command);

  @Value // https://projectlombok.org/features/Value
  //@Getter
  //@EqualsAndHashCode(callSuper = false)
  class DemandeVirement {

    private final Long sourceAccountId;
    private final Long targetAccountId;
    private final Integer money;

    public DemandeVirement(
            Long sourceAccountId,
            Long targetAccountId,
            Integer money) {
      this.sourceAccountId = sourceAccountId;
      this.targetAccountId = targetAccountId;
      this.money = money;
    }
  }

}
