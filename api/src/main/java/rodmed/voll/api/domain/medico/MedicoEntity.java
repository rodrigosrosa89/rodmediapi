package rodmed.voll.api.domain.medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rodmed.voll.api.domain.endereco.EnderecoEntity;
import rodmed.voll.api.enums.EspecialidadeEnum;

@Table(name = "medico")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class MedicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String crm;

    private EspecialidadeEnum especialidade;

    private Boolean ativo;

    @Embedded
    private EnderecoEntity endereco;

    public MedicoEntity(DadosCadastroMedicoInput dadosCadastroMedicoInput) {
        this.nome = dadosCadastroMedicoInput.nome();
        this.email = dadosCadastroMedicoInput.email();
        this.telefone = dadosCadastroMedicoInput.telefone();
        this.crm = dadosCadastroMedicoInput.crm();
        this.especialidade = dadosCadastroMedicoInput.especialidade();
        this.endereco = new EnderecoEntity(dadosCadastroMedicoInput.endereco());
        this.ativo = true;
    }

    public void atualizar(@Valid DadosAtualizacaoMedicoInput dados) {
        this.nome = dados.nome() != null ? dados.nome() : this.nome;
        this.telefone = dados.telefone() != null ? dados.telefone() : this.telefone;
        this.endereco = this.endereco.atualizar(dados.endereco());
    }

    public void exclusaoLogica() {
        this.ativo = false;
    }

}
