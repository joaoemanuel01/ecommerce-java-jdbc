package br.com.joaoemanuel.ecommerce.dao;

import br.com.joaoemanuel.ecommerce.db.DatabaseConnection;
import br.com.joaoemanuel.ecommerce.entities.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    // 🔹 Inserir uma nova categoria
    public void inserir(Categoria categoria) {
        String sql = "INSERT INTO ecomerce.categoria (nome) VALUES (?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNome());
            stmt.executeUpdate();
            System.out.println("✅ Categoria inserida com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao inserir categoria: " + e.getMessage());
        }
    }

    // 🔹 Listar todas as categorias
    public List<Categoria> listar() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM ecomerce.categoria";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                categorias.add(new Categoria(id, nome));
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao listar categorias: " + e.getMessage());
        }

        return categorias;
    }

    // 🔹 Atualizar categoria
    public void atualizar(Categoria categoria) {
        String sql = "UPDATE ecomerce.categoria SET nome = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNome());
            stmt.setInt(2, categoria.getId());
            stmt.executeUpdate();
            System.out.println("✅ Categoria atualizada com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao atualizar categoria: " + e.getMessage());
        }
    }

    // 🔹 Deletar categoria
    public void deletar(int id) {
        String sql = "DELETE FROM ecomerce.categoria WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Categoria removida com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao deletar categoria: " + e.getMessage());
        }
    }
}