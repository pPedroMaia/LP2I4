/* 
* Pedro Henrique de Oliveira Maia dos Santos CB3013197
*/

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Funcionario {

    private int id;
    private String nome;
    private double salario;
    private String cargo;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<Funcionario> listarFuncionarios(String nome) {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        try {
            Connection con = new Conexao().getConexao();

            String queryString = "select f.cod_func, f.nome_func, f.sal_func, c.ds_cargos from tbFunc f inner join tbCargos c on f.cod_cargos = c.cd_cargos where f.nome_func like '"
                    + nome + "%'";

            PreparedStatement smt = con.prepareStatement(queryString);

            ResultSet rs = smt.executeQuery();

            while (rs.next()) {

                Funcionario f = new Funcionario();

                f.setId(rs.getInt("cod_func"));
                f.setNome(rs.getString("nome_func"));
                f.setSalario(rs.getDouble("sal_func"));
                f.setCargo(rs.getString("ds_cargos"));

                funcionarios.add(f);

            }

            rs.close();
            smt.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return funcionarios;
    }
}