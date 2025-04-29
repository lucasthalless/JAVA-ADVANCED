package fiap.com.br.DtoValidationBasic.Test;

import fiap.com.br.DtoValidationBasic.DTO.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserConsoleApp implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.execute("""
            CREATE TABLE IF NOT EXISTS user (
                ID INTEGER PRIMARY KEY,
                name VARCHAR(50) NOT NULL,
            )
        """);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n === USER CONSOLE ===");
            System.out.println("1. Add new user");
            System.out.println("2. List users");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Type the user name: ");
                    String nome = scanner.nextLine();
                    UserDto userDto = new UserDto(nome);
                    jdbcTemplate.update("INSERT INTO users (nome) VALUES (?)", userDto.getNome());
                    System.out.println("Usuário salvo com sucesso!");
            }
        }
    }
}
