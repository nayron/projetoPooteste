/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoDiscPOO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *estacionamentojg
 * @author Nayron
 */
public class ContatoDao {

    private final Connection conexao;

    public ContatoDao() throws ClassNotFoundException, SQLException {
        this.conexao = CriarConexao.getConexao();
    }

    public void Adicionar(Contato c1) throws SQLException {
        String sql = "INSERT INTO poo.contatos (nome, endereco, telefone, veiculo, placa) VALUES (?,?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, c1.getNome());
        stmt.setString(2, c1.getEndereco());
        stmt.setString(3, c1.getTelefone());
        stmt.setString(4, c1.getVeiculo());
        stmt.setString(5, c1.getPlaca());

        stmt.execute();
        stmt.close();

    }

    /**
     *
     * @param nome
     * @return @throws SQLException
     */
    public ArrayList<Contato> getLista(String nome) throws SQLException {
        String sql = "select * from contatos where nome like?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();

        ArrayList<Contato> MinhaLista = new ArrayList<Contato>();

        while (rs.next()) {
            Contato c1 = new Contato();
            c1.setId(rs.getInt("id"));
            c1.setNome(rs.getString("nome"));
            c1.setEndereco(rs.getString("endereco"));
            c1.setTelefone(rs.getString("telefone"));
            c1.setVeiculo(rs.getString("veiculo"));
            c1.setPlaca(rs.getString("placa"));
            MinhaLista.add(c1);

        }
        rs.close();
        stmt.close();
        return MinhaLista;

    }

    public void Altera(Contato c1) throws SQLException {
        String sql = "UPDATE poo.contatos SET nome=?, endereco=?, telefone=?, veiculo=?, placa=?"
                + "where id=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, c1.getNome());
        stmt.setString(2, c1.getEndereco());
        stmt.setString(3, c1.getTelefone());
        stmt.setString(4, c1.getVeiculo());
        stmt.setString(5, c1.getPlaca());
        stmt.setInt(6, c1.getId());

        stmt.execute();
        stmt.close();
        

    }

    public void remove(Contato c1) throws SQLException {
        String slq = "DELETE FROM poo.contatos WHERE id=?";
        PreparedStatement stmt = conexao.prepareStatement(slq);
        stmt.setInt(1,c1.getId());
        
        stmt.execute();
        stmt.close();

       
    }
     public ArrayList<Contato> getListas() throws SQLException {
        String sql = "select * from contatos";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();

        ArrayList<Contato> MinhaLista = new ArrayList<Contato>();

        while (rs.next()) {
            Contato c1 = new Contato();
            c1.setId(rs.getInt("id"));
            c1.setNome(rs.getString("nome"));
            c1.setEndereco(rs.getString("endereco"));
            c1.setTelefone(rs.getString("telefone"));
            c1.setVeiculo(rs.getString("veiculo"));
            c1.setPlaca(rs.getString("placa"));
            MinhaLista.add(c1);

        }
        rs.close();
        stmt.close();
        return MinhaLista;

    }
     public ArrayList<Contato> getListass(String placa) throws SQLException {
        String sql = "select * from contatos where placa like?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, placa);
        ResultSet rs = stmt.executeQuery();

        ArrayList<Contato> MinhaLista = new ArrayList<Contato>();

        while (rs.next()) {
            Contato c1 = new Contato();
            c1.setId(rs.getInt("id"));
            c1.setNome(rs.getString("nome"));
            c1.setEndereco(rs.getString("endereco"));
            c1.setTelefone(rs.getString("telefone"));
            c1.setVeiculo(rs.getString("veiculo"));
            c1.setPlaca(rs.getString("placa"));
            MinhaLista.add(c1);

        }
        rs.close();
        stmt.close();
        return MinhaLista;

    }
     
     
}
