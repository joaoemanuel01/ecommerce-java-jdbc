package br.com.joaoemanuel.ecommerce.entities;

public class ProdutoPedido {

    private int PedidoId;
    private int ProdutoId;
    private int quantidade;

    public ProdutoPedido(){}

    public ProdutoPedido(int PedidoId, int ProdutoId, int quantidade){
        this.PedidoId = PedidoId;
        this.ProdutoId = ProdutoId;
        this.quantidade = quantidade;
    }

    // FK_ID_Pedido
    public int getPedidoId() {
        return PedidoId;
    }
    public void setPedidoId(int PedidoId) {
        this.PedidoId = PedidoId;
    }

    // FK_ID_Produto
    public int getProdutoId() {
        return ProdutoId;
    }
    public void setProdutoId(int ProdutoId) {
        this.ProdutoId = ProdutoId;
    }

    // Fk_ID_Quantidade
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
