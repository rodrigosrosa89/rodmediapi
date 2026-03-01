package rodmed.voll.api.model.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rodmed.voll.api.model.DadosCadastroMedicoInput;
import rodmed.voll.api.model.enums.EspecialidadeEnum;

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

    @Embedded
    private EnderecoEntity endereco;

    public MedicoEntity(DadosCadastroMedicoInput dadosCadastroMedicoInput) {
        this.nome = dadosCadastroMedicoInput.nome();
        this.email = dadosCadastroMedicoInput.email();
        this.telefone = dadosCadastroMedicoInput.telefone();
        this.crm = dadosCadastroMedicoInput.crm();
        this.especialidade = dadosCadastroMedicoInput.especialidade();
        this.endereco = new EnderecoEntity(dadosCadastroMedicoInput.endereco());
    }
}
