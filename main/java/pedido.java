import java.util.ArrayList;
import java.util.List;

public class pedido {  // Esta é a classe "pedido", que representa um pedido de hambúrgueres.
    private List<hamburguer> hamburguers = new ArrayList<>(); // Aqui estamos criando uma lista de hambúrgueres no pedido.
    private double descontoCupom; // Essa variável vai armazenar o valor do desconto aplicado através de um cupom.

    // Método para adicionar um hambúrguer ao pedido.
    public void adicionarhamburguer(hamburguer hamburguer) {
        hamburguers.add(hamburguer); // O hambúrguer é adicionado à lista de hambúrgueres do pedido.
    }

    // Método para aplicar um desconto baseado em um cupom.
    public void aplicarDescontoCupom(String codigoCupom) {
        // Verifica se o cupom é "CUPOM5" e aplica um desconto de 5 reais.
        if (codigoCupom.equals("CUPOM5")) {
            descontoCupom = 5;  // Se o código do cupom for "CUPOM5", o desconto será de 5 reais.
        }
        // Se o cupom for "CUPOM10", aplica um desconto de 10 reais.
        else if (codigoCupom.equals("CUPOM10")) {
            descontoCupom = 10;  // Se o código do cupom for "CUPOM10", o desconto será de 10 reais.
        }
    }

    // Método para calcular o total do pedido.
    public double calcularTotal() {
        double total = 0;  // Variável para armazenar o valor total do pedido, começando com 0.

        // Agora vamos somar os preços de todos os hambúrgueres no pedido.
        for (hamburguer hamburguer : hamburguers) {
            total += hamburguer.getPreco(); // Adiciona o preço de cada hambúrguer ao total.
        }

        // Agora aplicamos o desconto do cupom no total.
        total -= descontoCupom;  // Subtrai o valor do desconto (se houver) do total.

        // Se o pedido tiver 3 ou mais hambúrgueres, é aplicado um desconto extra de 5 reais.
        if (hamburguers.size() >= 3) {
            total -= 5;  // Se o número de hambúrgueres for maior ou igual a 3, o total recebe um desconto extra de 5 reais.
        }

        return total;  // O método retorna o total final do pedido, já com os descontos aplicados.
    }

    // Método que retorna a lista de hambúrgueres do pedido.
    public List<hamburguer> gethamburguers() {
        return hamburguers;  // Retorna a lista de hambúrgueres no pedido.
    }

    // Método que retorna o valor do desconto aplicado pelo cupom.
    public double getDescontoCupom() {
        return descontoCupom;  // Retorna o valor do desconto do cupom.
    }
}
