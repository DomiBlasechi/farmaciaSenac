package br.com.alura.farmacia.modelo.produtos;

import br.com.alura.farmacia.modelo.Categoria;
import br.com.alura.farmacia.modelo.fabricantes.Fabricante;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "Produtos")
public class Produto {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String descricao;
    private double preco;

    // SEMANA 7 - Entrega 11: Adicionando atributo na classe Produto. ==================================================
    private LocalDate dataCadastro = LocalDate.now();
    @ManyToOne
    private Categoria categoria;
    @ManyToOne(fetch = FetchType.LAZY)
    private Fabricante fabricante;


    // Construtores, getters e setters. ================================================================================
    public Produto(){};
    public Produto(String nome, String descricao, double preco, Categoria categoria, Fabricante fabricante) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public int getId() { return id; }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return "Produto\n" + id + " || " +
                "Nome do produto = '" + nome + '\'' +
                "... Descrição = '" + descricao + '\'' +
                "... Preço unitário = " + preco + '\'' +
                "... Categoria = " + categoria;
    }
}
