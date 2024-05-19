package fiap.tds.repositories;

import fiap.tds.infrastructure.ConexaoDatabase;
import fiap.tds.models.Usuario;
import java.sql.*;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.util.Map.entry;

public class UsuarioRepository {
    public static final Logger LOGGER = LogManager.getLogger(UsuarioRepository.class);
    private ConexaoDatabase conexaoDB = new ConexaoDatabase();

    public static final String TABLE_NAME = "T_PS_USUARIO";

    public static final Map<String, String> TABLE_COLUMNS = Map.ofEntries(
            entry("NOME", "nome"),
            entry("SOBRENOME", "sobrenome"),
            entry("CPF", "cpf_usuario"),
            entry("CARGO", "cargo"),
            entry("EMAIL", "email_usuario"),
            entry("TELEFONE", "telefone"),
            entry("EMPRESA", "empresa"),
            entry("NUMFUNCIONARIOS", "nr_funcionarios"),
            entry("PAIS", "pais"),
            entry("IDIOMA", "idioma"),
            entry("SENHA", "senha")
    );

    // VERIFICAR LOGIN DO USUARIO
    public Optional<Usuario> verificarLogin(String nome, String email, String senha) {
        try (Connection connection = conexaoDB.obterConexao();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM " + TABLE_NAME + " WHERE nome = ? AND email_usuario = ? AND senha = ?")) {
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, senha);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(new Usuario(
                            resultSet.getString(TABLE_COLUMNS.get("NOME")),
                            resultSet.getString(TABLE_COLUMNS.get("SOBRENOME")),
                            resultSet.getString(TABLE_COLUMNS.get("CPF")),
                            resultSet.getString(TABLE_COLUMNS.get("CARGO")),
                            resultSet.getString(TABLE_COLUMNS.get("EMAIL")),
                            resultSet.getString(TABLE_COLUMNS.get("TELEFONE")),
                            resultSet.getString(TABLE_COLUMNS.get("EMPRESA")),
                            resultSet.getInt(TABLE_COLUMNS.get("NUMFUNCIONARIOS")),
                            resultSet.getString(TABLE_COLUMNS.get("PAIS")),
                            resultSet.getString(TABLE_COLUMNS.get("IDIOMA")),
                            resultSet.getString(TABLE_COLUMNS.get("SENHA"))
                    ));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Erro ao realizar o login!",  e.getMessage());
        }
        LOGGER.info("Verificado com sucesso!");
        return Optional.empty();
    }

    // CADASTRAR USUARIO
    public void cadastrar(Usuario usuario){
        try(Connection connection = conexaoDB.obterConexao();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO %s(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s) VALUES (?,?,?,?,?,?,?,?,?,?,?)"
                            .formatted(TABLE_NAME,
                                    TABLE_COLUMNS.get("NOME"),
                                    TABLE_COLUMNS.get("SOBRENOME"),
                                    TABLE_COLUMNS.get("CPF"),
                                    TABLE_COLUMNS.get("CARGO"),
                                    TABLE_COLUMNS.get("EMAIL"),
                                    TABLE_COLUMNS.get("TELEFONE"),
                                    TABLE_COLUMNS.get("EMPRESA"),
                                    TABLE_COLUMNS.get("NUMFUNCIONARIOS"),
                                    TABLE_COLUMNS.get("PAIS"),
                                    TABLE_COLUMNS.get("IDIOMA"),
                                    TABLE_COLUMNS.get("SENHA")))
        ) {
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getSobrenome());
            preparedStatement.setString(3, usuario.getCpf_usuario());
            preparedStatement.setString(4, usuario.getCargo());
            preparedStatement.setString(5, usuario.getEmail_usuario());
            preparedStatement.setString(6, usuario.getTelefone());
            preparedStatement.setString(7, usuario.getEmpresa());
            preparedStatement.setInt(8, usuario.getNr_funcionarios());
            preparedStatement.setString(9, usuario.getPais());
            preparedStatement.setString(10, usuario.getIdioma());
            preparedStatement.setString(11, usuario.getSenha());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            LOGGER.error("Erro ao cadastrar o usuario!", e.getMessage());
        }
        LOGGER.info("Cadastrado com sucesso!");
        return;
    }
}
