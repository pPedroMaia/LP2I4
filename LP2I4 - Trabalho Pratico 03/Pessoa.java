/*
* Pedro Henrique de Oliveira Maia dos Santos CB3013197
*/

public class Pessoa {

    private static int kp;
    private String nome;
    private char sexo;
    private int idade;

    Pessoa(){}

    public Pessoa(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    public int getKp() {
        return kp;
    }

    public static void setKp(int kp) {
        Pessoa.kp = kp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
       return "Nome: " + nome + "    Sexo: " + sexo + "    Idade: " + idade;
    }
}