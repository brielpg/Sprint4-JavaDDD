package fiap.tds.infrastructure;

import fiap.tds.repositories.UsuarioRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoDatabase {
    public static final Logger LOGGER = LogManager.getLogger(UsuarioRepository.class);
    public static String URL_ORACLE;
    public static String USER;
    public static String PASSWORD;

    public ConexaoDatabase(){
        carregarDatabase();
    }

    public void carregarDatabase(){
        try(var inputStream = getClass().getClassLoader().getResourceAsStream("database.properties")) {
            var properties = new Properties();
            properties.load(inputStream);
            URL_ORACLE = properties.getProperty("jdbc.url");
            USER = properties.getProperty("jdbc.username");
            PASSWORD = properties.getProperty("jdbc.password");

        } catch (IOException e) {
            LOGGER.error("Erro ao carregar as configurações do banco de dados", e);
            throw new RuntimeException(e);
        }
    }

    public Connection obterConexao() throws SQLException {
        return DriverManager.getConnection(URL_ORACLE, USER, PASSWORD);
    }
}
