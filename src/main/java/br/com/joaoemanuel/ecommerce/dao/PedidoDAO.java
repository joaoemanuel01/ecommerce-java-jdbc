package br.com.joaoemanuel.ecommerce.dao;

import br.com.joaoemanuel.ecommerce.db.DatabaseConnection;
import br.com.joaoemanuel.ecommerce.entities.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    // Inserir pedido
    public void inserir(Pedido pedido) {
        String sql = "INSERT INTO ecomerce.pedido (data_pedido, valor_total) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setTimestamp(1, Timestamp.valueOf(pedido.getData().atStartOfDay()));
            stmt.setDouble(2, pedido.getValorTotal());
            stmt.executeUpdate();
            System.out.println("✅ Pedido inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao inserir pedido: " + e.getMessage());
        }
    }

    // Listar pedidos
    public List<Pedido> listar() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM ecomerce.pedido";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pedido p = new Pedido();
                p.setId(rs.getInt("id"));
                p.setData(rs.getTimestamp("data_pedido").toLocalDateTime().toLocalDate());
                p.setValorTotal(rs.getDouble("valor_total"));
                pedidos.add(p);
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao listar pedidos: " + e.getMessage());
        }

        return pedidos;
    }

    // Atualizar pedido
    public void atualizar(Pedido pedido) {
        String sql = "UPDATE ecomerce.pedido SET data_pedido = ?, valor_total = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setTimestamp(1, Timestamp.valueOf(pedido.getData().atStartOfDay()));
            stmt.setDouble(2, pedido.getValorTotal());
            stmt.setInt(3, pedido.getId());
            stmt.executeUpdate();
            System.out.println("✅ Pedido atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao atualizar pedido: " + e.getMessage());
        }
    }

    // Deletar pedido
    public void deletar(int id) {
        String sql = "DELETE FROM ecomerce.pedido WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Pedido deletado com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao deletar pedido: " + e.getMessage());
        }
    }
}