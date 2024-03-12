package br.com.alura.farmacia.dao;

import br.com.alura.farmacia.modelo.fabricantes.Fabricante;
import br.com.alura.farmacia.modelo.produtos.Produto;

import javax.persistence.EntityManager;

public class FabricanteDao {

    private EntityManager em;

    public FabricanteDao(EntityManager ef){
        this.em = em;
    }
    public void cadastrarFabricante(Fabricante fabricante){
        this.em.persist(fabricante);
    }
}
