package fr.iutv.spring_boot.exemple_01;

import fr.iutv.spring_boot.exemple_01.virement.VirementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class VirementControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private VirementService sendMoneyUseCase;

  @Test
  void testVirementOK() throws Exception {

    VirementService.DemandeVirement command = new VirementService.DemandeVirement(
            1L,
            2L,
            500);
    when(sendMoneyUseCase.transfererArgent(command)).thenReturn(true);

    mockMvc.perform(post("/virement/{depuisCompteId}/{versCompteId}/{montant}",
            1L, 2L, 500)
            .header("Content-Type", "application/json"))
            .andExpect(status().isOk());
  }

  @Test
  void testVirementKO() throws Exception {
  }

}