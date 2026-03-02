package rodmed.voll.api.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEntity {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public EnderecoEntity(DadosEnderecoInput dadosEnderecoInput) {
        this.logradouro = dadosEnderecoInput.logradouro();
        this.bairro = dadosEnderecoInput.bairro();
        this.cep = dadosEnderecoInput.cep();
        this.numero = dadosEnderecoInput.numero();
        this.complemento = dadosEnderecoInput.complemento();
        this.cidade = dadosEnderecoInput.cidade();
        this.uf = dadosEnderecoInput.uf();
    }

    public EnderecoEntity atualizar(DadosEnderecoInput dadosEnderecoAtualizar) {
        if (dadosEnderecoAtualizar.logradouro() != null) {
            this.logradouro = dadosEnderecoAtualizar.logradouro();
        }
        if (dadosEnderecoAtualizar.bairro() != null) {
            this.logradouro = dadosEnderecoAtualizar.bairro();
        }
        if (dadosEnderecoAtualizar.cep() != null) {
            this.logradouro = dadosEnderecoAtualizar.cep();
        }
        if (dadosEnderecoAtualizar.uf() != null) {
            this.logradouro = dadosEnderecoAtualizar.uf();
        }
        if (dadosEnderecoAtualizar.cidade() != null) {
            this.logradouro = dadosEnderecoAtualizar.cidade();
        }
        if (dadosEnderecoAtualizar.numero() != null) {
            this.logradouro = dadosEnderecoAtualizar.numero();
        }
        if (dadosEnderecoAtualizar.complemento() != null) {
            this.logradouro = dadosEnderecoAtualizar.complemento();
        }
        return this;
    }
}
