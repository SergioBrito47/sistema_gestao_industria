package dao;

import config.ConexaoMySQL;
import model.Funcionario;
import model.Setor;

import java.sql.*;
import java.util.ArrayList;

public class FuncionarioDAO {

    private static Connection conn = ConexaoMySQL.getConnection();

    public ArrayList<Funcionario> listar() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        try {
            String sql = "SELECT f.*, s.id_setor, s.nome_setor, s.responsavel " +
                    "FROM funcionario f " +
                    "INNER JOIN setor s ON f.id_setor = s.id_setor;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // Dados do setor
                Setor setor = new Setor(
                        rs.getInt("id_setor"),
                        rs.getString("nome_setor"),
                        rs.getString("responsavel")
                );

                // Dados do funcionário
                Funcionario f = new Funcionario(
                        rs.getInt("id_funcionario"),
                        rs.getString("nome"),
                        rs.getString("sobrenome"),
                        setor
                );

                funcionarios.add(f);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar funcionários: " + e.getMessage());
        }
        return funcionarios;
    }

    public Funcionario buscarPorId(Integer id) {
        try {
            String sql = "SELECT f.*, s.id_setor, s.nome_setor, s.responsavel " +
                    "FROM funcionario f " +
                    "INNER JOIN setor s ON f.id_setor = s.id_setor " +
                    "WHERE f.id_funcionario = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Setor setor = new Setor(
                        rs.getInt("id_setor"),
                        rs.getString("nome_setor"),
                        rs.getString("responsavel")
                );

                return new Funcionario(
                        rs.getInt("id_funcionario"),
                        rs.getString("nome"),
                        rs.getString("sobrenome"),
                        setor
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar funcionário por ID: " + e.getMessage());
        }
        return null;
    }

    public Boolean cadastrar(Funcionario funcionario) {
        try {
            String sql = "INSERT INTO funcionario (nome, sobrenome, id_setor) VALUES (?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getSobrenome());
            ps.setInt(3, funcionario.getSetor().getIdSetor()); // usamos o ID do setor

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
        }
        return false;
    }

    public Boolean atualizar(Funcionario funcionario) {
        try {
            String sql = "UPDATE funcionario SET nome = ?, sobrenome = ?, id_setor = ? WHERE id_funcionario = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getSobrenome());
            ps.setInt(3, funcionario.getSetor().getIdSetor());
            ps.setInt(4, funcionario.getIdFuncionario());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar funcionário: " + e.getMessage());
        }
        return false;
    }

    public Boolean remover(Integer id) {
        try {
            Funcionario funcionario = buscarPorId(id);
            if (funcionario == null) return false;

            String sql = "DELETE FROM funcionario WHERE id_funcionario = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao remover funcionário: " + e.getMessage());
        }
        return false;
    }
}