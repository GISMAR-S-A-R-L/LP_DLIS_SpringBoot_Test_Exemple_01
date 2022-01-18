package fr.iutv.spring_boot.exemple_01.virement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class VirementServiceImpl implements VirementService {

  public VirementServiceImpl() {
    log.info(">>> création du VirementService! <<<");
  }

  @Override
  public boolean transfererArgent(DemandeVirement command) {
    boolean virementIsOk = (Math.floorMod(System.currentTimeMillis(),2L) == 0);
    log.info("virement d'argent ("+virementIsOk+") ");
    return virementIsOk;
  }

}