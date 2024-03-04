package br.com.alura.farmacia;

import br.com.alura.farmacia.modelo.Produto;
import br.com.alura.farmacia.service.ProdutoService;

public class Teste {
    public static void main(String[] args) {

        // Semana 6 - Teste para cadastrar um produto:

        Produto produto1 = new Produto (01, "Ibuprofeno", "400mg, caixa com 20. contra febre e dor de cabeça", 19.90 );
        ProdutoService produtoService = new ProdutoService();
        produtoService.cadastrar(produto1);


    }
}
