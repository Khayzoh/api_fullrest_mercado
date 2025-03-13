package med.voll.api.medico;

public record DadosLisstagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public DadosLisstagemMedico(Medico medico) {
        this(medico.getId(),medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
