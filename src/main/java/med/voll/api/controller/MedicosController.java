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

    @RequestMapping("/cadastro")
    @PostMapping
    @Transactional
    public String medicos(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
        return "Cadastrado";
    }

    @RequestMapping("/listar")
    @GetMapping
    public Page<DadosLisstagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosLisstagemMedico::new);
    }

}
