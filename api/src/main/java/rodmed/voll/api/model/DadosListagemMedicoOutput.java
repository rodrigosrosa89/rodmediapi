package rodmed.voll.api.model;

import rodmed.voll.api.model.entity.MedicoEntity;
import rodmed.voll.api.model.enums.EspecialidadeEnum;

public record DadosListagemMedicoOutput(
        String nome,
        String email,
        String crm,
        EspecialidadeEnum especialidade
) {

    public DadosListagemMedicoOutput(MedicoEntity entidade) {
        this(entidade.getNome(), entidade.getEmail(), entidade.getCrm(), entidade.getEspecialidade());
    }
}
