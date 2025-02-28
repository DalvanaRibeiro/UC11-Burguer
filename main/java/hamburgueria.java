public class hamburgueria {  // Aqui estamos criando uma classe chamada "hamburgueria", que será o programa principal onde vamos criar lanches e pedidos.

    public static void main(String[] args) {  // Este é o ponto de entrada do programa, o método "main". Quando você executa o programa, tudo começa aqui.

        // Criar alguns lanches (hambúrgueres)
        hamburguer hamburguer1 = new hamburguer("Cheddar", 15.00);  // Criamos um novo hambúrguer chamado "Cheddar" com preço 15.00.
        hamburguer hamburguer2 = new hamburguer("Bacon", 18.00);     // Criamos outro hambúrguer chamado "Bacon" com preço 18.00.
        hamburguer hamburguer3 = new hamburguer("Frango", 12.00);    // Criamos um hambúrguer chamado "Frango" com preço 12.00.
        hamburguer hamburguer4 = new hamburguer("Vegano", 14.00);    // Criamos um hambúrguer chamado "Vegano" com preço 14.00.

        // Criar um pedido
        pedido pedido = new pedido();  // Criamos um novo pedido. O pedido começa vazio, sem nenhum hambúrguer.

        // Adicionar hambúrgueres ao pedido
        pedido.adicionarhamburguer(hamburguer1);  // Adicionamos o hambúrguer "Cheddar" ao pedido.
        pedido.adicionarhamburguer(hamburguer2);  // Adicionamos o hambúrguer "Bacon" ao pedido.
        pedido.adicionarhamburguer(hamburguer3);  // Adicionamos o hambúrguer "Frango" ao pedido.

        // Aplicar cupom de desconto
        pedido.aplicarDescontoCupom("CUPOM5");  // Aplicamos o cupom de desconto "CUPOM5" ao pedido. Esse cupom dá R$ 5 de desconto.

        // Calcular e exibir o total do pedido
        System.out.println("Total do pedido: R$ " + pedido.calcularTotal());  // Calcula o total do pedido (somando os preços dos hambúrgueres e aplicando o desconto). Exibe o resultado no console.
    }
}
