package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/agenda?useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
    private String user = "eduardo";
    private String password = "Root123456@"; 

    private Connection conectar() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // 1. CREATE
    public void inserirEntulho(Entulho entulho) {
        String create = "INSERT INTO contatos (logradouro, material, volume) VALUES (?, ?, ?)";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(create);
            pst.setString(1, entulho.getLogradouro());
            pst.setString(2, entulho.getMaterial());
            pst.setString(3, entulho.getVolume());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 2. READ
    public ArrayList<Entulho> listarEntulhos() {
        ArrayList<Entulho> lista = new ArrayList<>();
        String read = "SELECT * FROM contatos ORDER BY id DESC";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Entulho entulho = new Entulho();
                entulho.setId(rs.getInt("id"));
                entulho.setLogradouro(rs.getString("logradouro"));
                entulho.setMaterial(rs.getString("material"));
                entulho.setVolume(rs.getString("volume"));
                lista.add(entulho);
            }
            con.close();
            return lista;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // 3. UPDATE - ETAPA 1 (Buscar por ID)
    public Entulho selecionarEntulho(int id) {
        String select = "SELECT * FROM contatos WHERE id = ?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(select);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            Entulho entulho = new Entulho();
            
            if (rs.next()) {
                entulho.setId(rs.getInt("id"));
                entulho.setLogradouro(rs.getString("logradouro"));
                entulho.setMaterial(rs.getString("material"));
                entulho.setVolume(rs.getString("volume"));
            }
            con.close();
            return entulho;
        } catch (Exception e) {
            System.out.println("Erro ao selecionar por ID: " + e);
            return null;
        }
    }

    // 3. UPDATE - ETAPA 2 (Salvar Alteração)
    public void alterarEntulho(Entulho entulho) {
        String update = "UPDATE contatos SET logradouro = ?, material = ?, volume = ? WHERE id = ?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(update);
            
            pst.setString(1, entulho.getLogradouro());
            pst.setString(2, entulho.getMaterial());
            pst.setString(3, entulho.getVolume());
            pst.setInt(4, entulho.getId());
            
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println("Erro ao alterar no banco: " + e);
        }
    }

    // 4. DELETE
    public void deletarEntulho(Entulho entulho) {
        String delete = "DELETE FROM contatos WHERE id = ?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(delete);
            pst.setInt(1, entulho.getId());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println("Erro ao deletar: " + e);
        }
    }
}