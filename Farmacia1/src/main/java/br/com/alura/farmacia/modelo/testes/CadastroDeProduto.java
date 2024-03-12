package br.com.alura.farmacia.modelo.testes;

import br.com.alura.farmacia.dao.CategoriaDao;
import br.com.alura.farmacia.dao.ProdutoDao;
import br.com.alura.farmacia.modelo.Categoria;
import br.com.alura.farmacia.dao.FabricanteDao;
import br.com.alura.farmacia.modelo.produtos.Produto;
import br.com.alura.farmacia.service.ProdutoService;
import br.com.alura.farmacia.util.JPAUtil;

import javax.persistence.EntityManager;

import java.util.List;


public class CadastroDeProduto {
    public static void main(String[] args) {

        // Consulta de produto por id:
        cadastrarProduto();

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto p = produtoDao.buscarPorId(1);
        System.out.println("O nome do produto é: " + p.getNome());

        // SEMANA 7 - Entrega 8: Listar produtos:

        List<Produto> todos = produtoDao.buscarTodos();
        todos.forEach(p2 -> System.out.println("""
                ==================================
                Produto cadastrado: 
                ==================================
                """ + p2.getNome()));
    }
    // ======================  Entrega da SEMANA 7 - Atividade 7: cadastro de produto e fabricante   ===================
    public static void cadastrarProduto() {
        //Primeiro teste - adicionar produto e fabricante: =============================================================
        //Produto ibuprofeno = new Produto("Ibuprofeno", "Febre e dor de cabeça",12.90);
        //Fabricante pfizer = new Fabricante("Pfizer");

        // SEMANA 7 - Entrega 11: adicionar atributos a classe Produto. ================================================
        //Categoria antibioticos = new Categoria("ANTIBIOTICOS");
        //Produto amoxicilina = new Produto("Amoxicilina", "Antibiótico", 39.90, antibioticos);
        //Produto azitromicina = new Produto("Azitromicina", "Antibiótico", 35.90, antibioticos);
        //Produto produto = new Produto();

        //EntityManager em = JPAUtil.getEntityManager();

        // ***** Instanciando as entidades *****
        //ProdutoDao produtoDao = new ProdutoDao(em);
        //CategoriaDao categoriaDao1 = new CategoriaDao(em);
        //FabricanteDao dao2 = new FabricanteDao(em);

        //em.getTransaction().begin();

        // SEMANA 7 - Entrega 9: editar a descrição de um produto: =====================================================
        //azitromicina.setDescricao("Contra infecções virais e bacterianas.");

        // ***** Primeiros testes - adicionar produto e fabricante: *****
        //dao.cadastrarProduto(ibuprofeno);
        // dao2.cadastrarFabricante(pfizer);

        // ***** Entrega 11 - Adicionar atributos a classe Produto: *****
        //categoriaDao1.cadastrarCategoria(antibioticos);
        //produtoDao.cadastrarProduto(azitromicina);

        //em.getTransaction().commit();
        //em.close();
    }
}