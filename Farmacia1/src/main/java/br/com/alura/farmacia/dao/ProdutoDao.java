package br.com.alura.farmacia.dao;
import br.com.alura.farmacia.modelo.Produto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class ProdutoDao {
    private Connection conn;
    public ProdutoDao(Connection connection) {this.conn = connection;}

    public void criar(Produto produto) {
        String sql = "INSERT INTO produto (id, nome , descricao, preco)" + "VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, produto.getId());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setString(3, produto.getDescricao());
            preparedStatement.setDouble(4, produto.getPreco());
            preparedStatement.execute();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<Produto> listar(){
        PreparedStatement ps;
        ResultSet resultSet;
        Set<Produto> produtos = new HashSet<>();

        String sql = "SELECT * FROM produto";

        try {
            ps = conn.prepareStatement(sql);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(2);
                String nome = resultSet.getString(3);
                String descricao = resultSet.getString(4);
                double preco = resultSet.getDouble(5);

                produtos.add(new Produto(id, nome, descricao, preco));
            }
            resultSet.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return produtos;
    }

    public void editar (String nome, Double preco) {
        PreparedStatement ps;
        String sql = "UPDATE produto SET preco = ? WHERE nome = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setDouble(1, preco);
            ps.setString(2, nome);

            ps.execute();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deletar (String nome) {
        String sql = "DELETE from produto WHERE nome = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            ps.execute();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
