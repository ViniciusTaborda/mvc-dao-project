
package DAO;

import Model.Address;
import java.sql.PreparedStatement;
import java.sql.*;

public class AddressDAO {
    private final Connect connect;
    private String query;
    private PreparedStatement ps;

    public AddressDAO() {
        this.connect = new Connect();

    }

    public void insere(Address ad) {

        try{
            query = "INSERT INTO address (logradouro, numero, bairro, cidade, uf, complemento) VALUES (?, ?, ?, ?, ?, ?)";
        
            ps = connect.getConexao().prepareStatement(query); //essa query é a conexao que vai juntar um só objeto para depois executa-la.
        
            ps.setString(1, ad.getLogradouro());
            ps.setInt(2, ad.getNumero());
            ps.setString(3, ad.getBairro());
            ps.setString(4, ad.getCidade());
            ps.setString(5, ad.getUf());
            ps.setString(6, ad.getComplemento());
        
            ps.executeUpdate();         
            ps.close();
        }
        catch(SQLException ex) {}

    }
}