package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico(
        //valida vazio e nulo
        @NotBlank
        String nome,
        @NotBlank
        //valida o formato e-mail
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        //regex para validar numeros de 4 a 6
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull
        //valida o DTO q está dentro
        @Valid
        DadosEndereco endereco) {




}
