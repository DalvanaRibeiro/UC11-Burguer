import java.util.ArrayList;
import java.util.List;

public class pedidos {
    // criando uma lista de hamburgueres do pedido
    private List<hamburguer> hamburguers = new ArrayList<>();
    // armazenando o valor do desconto
    private double descontoCupom;
    // Metodo para adicionar um hamburguer ao pedido
    public void adicionarhamburguer(hamburguer hamburguer){
        // O hamburguer é adicionado à lista de hambúrgueres do pedido
        hamburguers.add(hamburguer);
    }
    // Metodo para aplicar um desconto baseado em cupom
    public void aplicarDescontoCupom(String codigoCupom){
        if (codigoCupom.equals("CUPOM5")){
            descontoCupom = 5; // SE O CÓDIGO DE CUPOM FOR "cupom5" , O DESCONTO SERÁ DE 5 REAIS
        }
        // Agora o de 10
        else if (codigoCupom.equals("CUPOM10")) {
            descontoCupom = 10; // DESCONTO DE 10 REAIS

        }
    }
    // Metodo para calcular o total do pedido
    public double calcularTotal(){
        double total = 0; // variável para armazenar o valor total do pedido inicializada com 0
        // Agora vamos somar os  preços de todos os hambúrgueres no pedido
        for (hamburguer hamburguer : hamburguers){
            total += hamburguer.getPreco(); // Aqui adiciona o preço de cada hambúrguer ao total
        }
        // Então aplicamos o desconto do cupom no total
        total -= descontoCupom; // Subtrai o valor do desconto (se houer) do total.

        // Agora se o usuario estiver numa sexta feira , depois de um dia imenso de // trabalho e pede 3 ou mais hamburguer... ou se tem uma confra do tds do senac. Desconto de 5 reais
        if (hamburguers.size()>= 3){
            total -= 5; // se o número for maior ou igual a 3 , o usuário recebe desconto de 5 reais
        }
        return total; // O metodo retorna o total final do pedido, já com os descontos aplicados


    }
    // Metodo que retorna a lista de hamburgueres do pedido
    public List<hamburguer> getHamburguers(){
        return hamburguers;
    }
    // Metodo que retorna o valor do desconto aplicado pelo cupom
    public double getDescontoCupom(){
        return descontoCupom;
    }
}
