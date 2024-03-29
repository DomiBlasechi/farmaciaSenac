package br.com.alura.farmacia.service;
import br.com.alura.farmacia.dao.ConnectionFactory;
import br.com.alura.farmacia.dao.ProdutoDao;
import br.com.alura.farmacia.modelo.DadosCadastroProduto;
import br.com.alura.farmacia.modelo.Produto;

import java.sql.Connection;
import java.util.Set;

public class ProdutoService {
    private ConnectionFactory connection;
    public ProdutoService() {this.connection = new ConnectionFactory();}

    public void cadastrar (Produto produto) {
        Connection conn = connection.recuperarConexao();
        new ProdutoDao(conn).criar(produto);
    }

    public Set<Produto> listar(){
        Connection conn = connection.recuperarConexao();
        return new ProdutoDao(conn).listar();
    }

    public void editar (String nome, double preco) {
        Connection conn = connection.recuperarConexao();
        new ProdutoDao(conn).editar(nome, preco);
    }

    public void excluir (String nome) {
        Connection conn = connection.recuperarConexao();
        new ProdutoDao(conn).deletar(nome);
    }
    //var produto = new Produto(DadosCadastroProduto cadastroProduto)
}
