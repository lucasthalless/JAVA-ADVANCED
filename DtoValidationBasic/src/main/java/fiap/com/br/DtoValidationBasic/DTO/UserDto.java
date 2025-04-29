package fiap.com.br.DtoValidationBasic.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDto {

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
    private String name;

    // construtor padrão (obrigatório para frameworks como Spring)
    public UserDto() {
    }

    // construtor com argumento
    public UserDto(String name) { this.name = name; }

    // getter
    public String getNome() { return name; }

    // setter
    public void setNome(String name) { this.name = name; }

    // opcional: para debug
    @Override
    public String toString() {
        return "UserDto{" +
                "nome='" + name + '\'' +
                '}';
    }
}