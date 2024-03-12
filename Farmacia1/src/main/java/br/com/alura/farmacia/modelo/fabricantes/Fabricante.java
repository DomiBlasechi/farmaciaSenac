package br.com.alura.farmacia.modelo.fabricantes;

import javax.persistence.*;

@Entity
@Table(name = "Fabricantes")
public class Fabricante {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    public Fabricante(){}

    public Fabricante(String nome) { this.nome = nome; }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}


