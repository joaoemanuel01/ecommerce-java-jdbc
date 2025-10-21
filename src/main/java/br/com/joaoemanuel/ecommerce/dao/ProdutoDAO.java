package br.com.joaoemanuel.ecommerce.dao;

import br.com.joaoemanuel.ecommerce.db.DatabaseConnection;
import br.com.joaoemanuel.ecommerce.entities.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    // Inserir produto
    public void inserir(Produto produto) {
        String sql = "INSERT INTO ecomerce.produtos (nome, preco, fk_id_categoria) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getCategoriaId());
            stmt.executeUpdate();
            System.out.println("✅ Produto inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao inserir produto: " + e.getMessage());
        }
    }

    // Listar produtos
    public List<Produto> listar() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM ecomerce.produtos";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setCategoriaId(rs.getInt("categoria_id"));
                produtos.add(p);
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao listar produtos: " + e.getMessage());
        }

        return produtos;
    }

    // Atualizar produto
    public void atualizar(Produto produto) {
        String sql = "UPDATE ecomerce.produtos SET nome = ?, preco = ?, fk_id_categoria = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getCategoriaId());
            stmt.setInt(4, produto.getId());
            stmt.executeUpdate();
            System.out.println("✅ Produto atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao atualizar produto: " + e.getMessage());
        }
    }

    // Deletar produto
    public void deletar(int id) {
        String sql = "DELETE FROM ecomerce.produtos WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Produto deletado com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao deletar produto: " + e.getMessage());
        }
    }
}
