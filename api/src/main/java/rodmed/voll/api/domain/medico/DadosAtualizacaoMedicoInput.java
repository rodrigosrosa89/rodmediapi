package rodmed.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import rodmed.voll.api.domain.endereco.DadosEnderecoInput;

public record DadosAtualizacaoMedicoInput(
        @NotNull Long id,
        String nome,
        String telefone,
        DadosEnderecoInput endereco
) {
}
