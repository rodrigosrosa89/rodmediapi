package rodmed.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import rodmed.voll.api.domain.endereco.DadosEnderecoInput;
import rodmed.voll.api.enums.EspecialidadeEnum;

public record DadosCadastroMedicoInput(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        EspecialidadeEnum especialidade,

        @NotNull
        @Valid
        DadosEnderecoInput endereco
) {
}
