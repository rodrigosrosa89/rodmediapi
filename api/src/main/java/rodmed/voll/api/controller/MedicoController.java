package rodmed.voll.api.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import rodmed.voll.api.domain.medico.DadosAtualizacaoMedicoInput;
import rodmed.voll.api.domain.medico.DadosCadastroMedicoInput;
import rodmed.voll.api.domain.medico.DadosDetalhamentoMedico;
import rodmed.voll.api.domain.medico.DadosListagemMedicoOutput;
import rodmed.voll.api.domain.medico.MedicoEntity;
import rodmed.voll.api.domain.medico.MedicoRepository;

import java.util.Optional;

@RestController
@RequestMapping("medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoRepository repository;

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<MedicoEntity> cadastrar(@RequestBody @Valid DadosCadastroMedicoInput dados, UriComponentsBuilder uriComponentsBuilder) {
        MedicoEntity medico = new MedicoEntity(dados);
        repository.save(medico);
        var uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico).toUri();
        return ResponseEntity.created(uri).body(medico);
    }

    @GetMapping("/listagem")
    public ResponseEntity<Page<DadosListagemMedicoOutput>> listar(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable paginacao) {
        Page<DadosListagemMedicoOutput> page =  repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicoOutput::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping()
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedicoInput dados) {
        MedicoEntity medico = repository.getReferenceById(dados.id());
        medico.atualizar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Long id) {
        Optional<MedicoEntity> medico = repository.findById(id);
        if (medico.isPresent()) {
            MedicoEntity entidade = medico.get();
            entidade.exclusaoLogica();
            repository.save(entidade);
            return ResponseEntity.noContent().build();
        } else {
            throw new RuntimeException("Médico não encontrado");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharPorId(@PathVariable Long id) {
        Optional<MedicoEntity> medico = repository.findById(id);
        if (medico.isPresent()) {
            return ResponseEntity.ok(new DadosDetalhamentoMedico(medico.get()));
        } else {
            throw new EntityNotFoundException("Médico não encontrado");
        }
    }

}
