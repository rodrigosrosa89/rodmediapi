package rodmed.voll.api.domain.medico;

import rodmed.voll.api.enums.EspecialidadeEnum;

public record DadosListagemMedicoOutput(
        Long id,
        String nome,
        String email,
        String crm,
        EspecialidadeEnum especialidade
) {

    public DadosListagemMedicoOutput(MedicoEntity entidade) {
        this(entidade.getId(), entidade.getNome(), entidade.getEmail(), entidade.getCrm(), entidade.getEspecialidade());
    }
}
