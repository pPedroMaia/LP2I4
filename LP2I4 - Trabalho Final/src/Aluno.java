/*
*Pedro Henrique de Oliveira Maia dos Santos CB3013197
*/
public class Aluno {
    private String nome;
    private int idade;
    private float peso;
    private float altura;
    private String objetivo;

    public Aluno(String nome, int idade, float peso, float altura, String objetivo) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.objetivo = objetivo;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public float getPeso() {
        return peso;
    }

    public float getAltura() {
        return altura;
    }

    public String getObjetivo() {
        return objetivo;
    }
}
