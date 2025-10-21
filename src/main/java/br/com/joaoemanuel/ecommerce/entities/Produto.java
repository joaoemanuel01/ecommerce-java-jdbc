package br.com.joaoemanuel.ecommerce.entities;

public class Produto {

    private int id;
    private String nome;
    private double preco;
    private int CategoriaId;


    public Produto(){
    }

    public Produto(int id, String nome, double preco, int CategoriaId) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.CategoriaId = CategoriaId;
    }

    //ID
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // Nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    //Preço
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Fk_CategoriaId
    public int getCategoriaId() {
        return CategoriaId;
    }
    public void setCategoriaId(int CategoriaId) {
        this.CategoriaId = CategoriaId;
    }



}
