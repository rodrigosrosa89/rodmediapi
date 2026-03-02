package rodmed.voll.api.domain.medico;

import rodmed.voll.api.domain.endereco.EnderecoEntity;
import rodmed.voll.api.enums.EspecialidadeEnum;

public record DadosDetalhamentoMedico(
        Long id,
        String nome,
        String email,
        String crm,
        EspecialidadeEnum especialidade,
        EnderecoEntity endereco
) {

    public DadosDetalhamentoMedico(MedicoEntity medico) {
        this(
                medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getEspecialidade(),
                medico.getEndereco()
        );
    }
}
