package br.com.alura.farmacia.dao;
import br.com.alura.farmacia.modelo.produtos.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProdutoDao {

    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrarProduto(Produto produto) {
        this.em.persist(produto);
    }

    public Produto buscarPorId(int id) {
        return em.find(Produto.class, id);
    }

    // SEMANA 7 - Entrega 8: método para listar produtos: ==============================================================
    public List<Produto> buscarTodos() {
        String jpql = "SELECT p FROM Produto p";
        return em.createQuery(jpql, Produto.class).getResultList();
    }

    // SEMANA 7 - Entrega 10: método para deletar um produto: ==========================================================
    public void excluirProduto (int id){
        Produto produto = em.find(Produto.class, id);
        em.remove(produto);
    }
}


