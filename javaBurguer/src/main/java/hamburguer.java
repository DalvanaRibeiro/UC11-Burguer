public class hamburguer { // Aqui estamos criando a classe "hamburguer", que será usada para representar um hambúrguer no sistema.

    private String nome; // "nome" é uma variável que vai guardar o nome do hambúrguer, como "Cheeseburger", "X-Burger", etc.
    private double preco; // "preco" é uma variável que vai guardar o preço do hambúrguer.

    // Este é o construtor da classe. Ele é chamado quando criamos um novo objeto da classe "hamburguer".
    // O construtor recebe dois parâmetros: o nome e o preço do hambúrguer.
    public hamburguer(String nome, double preco) {
        this.nome = nome;  // O nome do hambúrguer que foi passado como parâmetro é armazenado na variável "nome".
        this.preco = preco; // O preço do hambúrguer que foi passado como parâmetro é armazenado na variável "preco".
    }

    // Este é o método "getNome", que retorna o nome do hambúrguer.
    // Ou seja, se chamarmos "hamburguer.getNome()", ele nos dirá o nome do hambúrguer.
    public String getNome() {
        return nome;  // Retorna o nome que foi armazenado na variável "nome".
    }

    // Este é o método "getPreco", que retorna o preço do hambúrguer.
    // Ou seja, se chamarmos "hamburguer.getPreco()", ele nos dirá o preço do hambúrguer.
    public double getPreco() {
        return preco;  // Retorna o preço que foi armazenado na variável "preco".
    }

    // Este é o método "setPreco", que permite que o preço do hambúrguer seja alterado.
    // Ou seja, se quisermos mudar o preço de um hambúrguer depois de ele ter sido criado, podemos usar esse método.
    public void setPreco(double preco) {
        this.preco = preco;  // Altera o preço do hambúrguer, substituindo o valor atual pelo novo preço que foi passado como parâmetro.
    }
}
