package br.com.alura.farmacia.dao;

import br.com.alura.farmacia.modelo.Categoria;
import br.com.alura.farmacia.modelo.produtos.Produto;

import javax.persistence.EntityManager;

public class CategoriaDao {
    private EntityManager em;

    public CategoriaDao(){};
    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrarCategoria(Categoria categoria)
    {
        this.em.persist(categoria);

    }
}
