package med.voll.api.controller;

import med.voll.api.dto.medico.DadosCadastroMedico;
import med.voll.api.jpa.medico.Medico;
import med.voll.api.jpa.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicosController {

    @Autowired
    private MedicoRepository repository;

    @RequestMapping("/cadastro")
    @PostMapping
    public String medicos(@RequestBody DadosCadastroMedico dados){
        repository.save(new Medico(dados));

        return "Cadastrado";
    }

}
