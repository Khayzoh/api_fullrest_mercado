package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//necessario para informar que a classe é uma rest
@RestController
//definição a rota da controller
@RequestMapping("/medicos")
public class MedicosController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping("/cadastro")
    @Transactional
    public String medicos(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
        return "Cadastrado";
    }

    @GetMapping("/listar")
    public Page<DadosLisstagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosLisstagemMedico::new);
    }

    @PutMapping("atualizar")
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarMedico dados){

        var medico = repository.getReferenceById(dados.id());

        medico.atualizar(dados);
    }

    @DeleteMapping("deletar/{id}")
    @Transactional
    public void deletar(@PathVariable Long id){

        var medico = repository.getReferenceById(id);

        medico.excluir();

    }

}
