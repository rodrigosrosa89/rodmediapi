package rodmed.voll.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rodmed.voll.api.model.DadosCadastroMedicoInput;
import rodmed.voll.api.model.DadosListagemMedicoOutput;
import rodmed.voll.api.model.entity.MedicoEntity;
import rodmed.voll.api.repository.MedicoRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoRepository repository;

    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody @Valid DadosCadastroMedicoInput dados) {
        repository.save(new MedicoEntity(dados));
        System.out.println("valor do json " + dados);

    }

    @GetMapping("/listagem")
    public List<DadosListagemMedicoOutput> listar() {
        return repository.findAll().stream()
                .map(DadosListagemMedicoOutput::new)
                .toList();
    }
}
