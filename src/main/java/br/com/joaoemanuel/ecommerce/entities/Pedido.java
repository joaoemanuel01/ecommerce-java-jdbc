package br.com.joaoemanuel.ecommerce.entities;

import java.time.LocalDate;

public class Pedido {

    private int id;
    private LocalDate dataPedido;
    private double valorTotal;

    public Pedido(){
    }

    public Pedido(int id, LocalDate data, double valorTotal) {
        this.id = id;
        this.dataPedido = data;
        this.valorTotal = valorTotal;
    }

    // ID
    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    //Data
    public LocalDate getData() {
        return dataPedido;
    }
    public void setData(LocalDate dataPedido){
        this.dataPedido = dataPedido;
    }

    // Valor Total
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }



}
