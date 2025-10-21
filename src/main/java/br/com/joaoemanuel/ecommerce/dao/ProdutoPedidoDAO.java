package br.com.joaoemanuel.ecommerce.dao;

import br.com.joaoemanuel.ecommerce.db.DatabaseConnection;
import br.com.joaoemanuel.ecommerce.entities.ProdutoPedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoPedidoDAO {

    // Inserir relação produto-pedido
    public void inserir(ProdutoPedido pp) {
        String sql = "INSERT INTO ecomerce.produto_pedido (fk_id_pedido, fk_id_produto, quantidade) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pp.getPedidoId());
            stmt.setInt(2, pp.getProdutoId());
            stmt.setInt(3, pp.getQuantidade());
            stmt.executeUpdate();
            System.out.println("✅ Relação produto-pedido inserida com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao inserir produto_pedido: " + e.getMessage());
        }
    }

    // Listar
    public List<ProdutoPedido> listar() {
        List<ProdutoPedido> lista = new ArrayList<>();
        String sql = "SELECT * FROM ecomerce.produto_pedido";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ProdutoPedido pp = new ProdutoPedido();
                pp.setPedidoId(rs.getInt("pedido_id"));
                pp.setProdutoId(rs.getInt("produto_id"));
                pp.setQuantidade(rs.getInt("quantidade"));
                lista.add(pp);
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao listar produto_pedido: " + e.getMessage());
        }

        return lista;
    }

    // Atualizar
    public void atualizar(ProdutoPedido pp) {
        String sql = "UPDATE ecomerce.produto_pedido SET quantidade = ? WHERE fk_id_pedido = ? AND fk_id_produto = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pp.getQuantidade());
            stmt.setInt(2, pp.getPedidoId());
            stmt.setInt(3, pp.getProdutoId());
            stmt.executeUpdate();
            System.out.println("✅ ProdutoPedido atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao atualizar produto_pedido: " + e.getMessage());
        }
    }

    // Deletar
    public void deletar(int pedidoId, int produtoId) {
        String sql = "DELETE FROM ecomerce.produto_pedido WHERE fk_id_pedido = ? AND fk_id_produto = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pedidoId);
            stmt.setInt(2, produtoId);
            stmt.executeUpdate();
            System.out.println("✅ ProdutoPedido removido com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao deletar produto_pedido: " + e.getMessage());
        }
    }
}
