package fr.iutv.spring_boot.exemple_01.endpoints;

import fr.iutv.spring_boot.exemple_01.virement.VirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequiredArgsConstructor
public class VirementController {

  @Autowired
  private /*final*/ VirementService virementService;

  @PostMapping(path = "/virement/{depuisCompteId}/{versCompteId}/{montant}")
  ResponseEntity transfererArgent(
          @PathVariable("depuisCompteId") Long depuisCompteId,
          @PathVariable("versCompteId") Long versCompteId,
          @PathVariable("montant") Integer montant) {

    VirementService.DemandeVirement demande = new VirementService.DemandeVirement(
            depuisCompteId,
            versCompteId,
            montant);

    boolean virementIsOk = virementService.transfererArgent(demande);

    if(virementIsOk) {
      return ResponseEntity
              .ok()
              .build();
    } else {
      return ResponseEntity
              .status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("ERROR");
    }
  }

}