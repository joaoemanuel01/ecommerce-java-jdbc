package br.com.joaoemanuel.ecommerce.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Configurações do banco de dados
    private static final String URL = "jdbc:postgresql://localhost:5432/MeuBanco"; // nome do seu banco
    private static final String USER = "postgres"; // seu usuário do banco
    private static final String PASSWORD = "2612006"; // sua senha do banco

    // Método que retorna a conexão
    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conectado ao banco com sucesso!");
            return conn;
        } catch (SQLException e) {
            System.out.println("❌ Erro ao conectar: " + e.getMessage());
            return null;
        }
    }


    public static void main(String[] args) {
        getConnection();
    }
}

