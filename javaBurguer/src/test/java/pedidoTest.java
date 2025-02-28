// Importa métodos necessários do JUnit para verificar os resultados do teste
import static org.junit.jupiter.api.Assertions.*;
// Importa a anotação @Test, que marca o método como um teste
import org.junit.Test;
// Importa a biblioteca Mockito, que ajuda a criar "mocks" de objetos
import org.mockito.Mockito;

public class pedidoTest {

    // Teste para verificar o total do pedido com o cupom de desconto
    @Test
    public void testCalcularTotalComDescontoCupom() {
        // Criando "mocks" dos hamburguers. Um "mock" é uma versão falsa do objeto que estamos testando.
        // Aqui, o Mockito cria uma versão "falsa" do hambúrguer chamada hamburguerMock1. Isso significa que não estamos usando um hambúrguer real, mas um hambúrguer "fingido", que vai se comportar de uma maneira específica quando for usado.
        hamburguer hamburguerMock1 = Mockito.mock(hamburguer.class); // Mock do primeiro hambúrguer
        hamburguer hamburguerMock2 = Mockito.mock(hamburguer.class); // Mock do segundo hambúrguer
        hamburguer hamburguerMock3 = Mockito.mock(hamburguer.class); // Mock do terceiro hambúrguer

        // Definindo o que os "mocks" devem fazer quando chamarmos seus métodos.

        //Agora, estamos dizendo ao "mock" do hambúrguer que, quando pedirmos o preço dele (com getPreco()), ele deve sempre responder com o valor de 15.00. Isso é como se fosse um hambúrguer que tem um preço fixo de 15 reais, mas ele não é real, é só uma imitação criada para o teste.
        Mockito.when(hamburguerMock1.getPreco()).thenReturn(15.00); // O primeiro hambúrguer vai retornar o preço 15.00
        Mockito.when(hamburguerMock2.getPreco()).thenReturn(18.00); // O segundo hambúrguer vai retornar 18.00
        Mockito.when(hamburguerMock3.getPreco()).thenReturn(12.00); // O terceiro hambúrguer vai retornar 12.00

        // Criando um pedido (um objeto da classe 'pedido')
        pedido pedido = new pedido();
        // Adicionando os hamburguers falsos (mocks) ao pedido
        //Adicionando os hambúrgueres "falsos" ao pedido
        pedido.adicionarhamburguer(hamburguerMock1);
        pedido.adicionarhamburguer(hamburguerMock2);
        pedido.adicionarhamburguer(hamburguerMock3);

        // Aplicando um cupom de desconto de R$ 5,00 no pedido
        pedido.aplicarDescontoCupom("CUPOM5");

        // Calculando o total do pedido (com o desconto aplicado)

        //Aqui, estamos colocando o hambúrguer "falso" no pedido, assim como colocaríamos um hambúrguer real. O pedido agora "pensa" que tem um hambúrguer de verdade, mas ele está apenas usando a versão "fake" criada pelo Mockito.
        //
        //Testando o total do pedido com os hambúrgueres falsos

        //O pedido calcula o total do preço, mas como estamos usando hambúrgueres falsos, ele vai somar os preços que definimos para os "mocks" (15.00, 18.00, etc.).
        double total = pedido.calcularTotal();

        // Verificando se o total calculado é 35.00, com uma pequena margem de erro (0.01)
        assertEquals(35.00, total, 0.01);
    }

    // Teste para verificar o total do pedido com o desconto de 3 hamburguers (sem cupom)
    @Test
    public void testCalcularTotalComDescontoDe3Lanches() {
        // Criando mocks dos hamburguers (mesmo processo que no outro teste)
        hamburguer hamburguerMock1 = Mockito.mock(hamburguer.class);
        hamburguer hamburguerMock2 = Mockito.mock(hamburguer.class);
        hamburguer hamburguerMock3 = Mockito.mock(hamburguer.class);

        // Definindo os preços dos hamburguers falsos (mocks)
        Mockito.when(hamburguerMock1.getPreco()).thenReturn(15.00);
        Mockito.when(hamburguerMock2.getPreco()).thenReturn(18.00);
        Mockito.when(hamburguerMock3.getPreco()).thenReturn(12.00);

        // Criando o pedido e adicionando os hamburguers
        pedido pedido = new pedido();
        pedido.adicionarhamburguer(hamburguerMock1);
        pedido.adicionarhamburguer(hamburguerMock2);
        pedido.adicionarhamburguer(hamburguerMock3);

        // Calculando o total do pedido (sem cupom, mas com o desconto de 3 hamburguers)
        double total = pedido.calcularTotal();

        // Verificando se o total calculado é 40.00, com uma pequena margem de erro
        assertEquals(40.00, total, 0.01);
    }

    // Teste para verificar o total do pedido sem cupom de desconto
    @Test
    public void testCalcularTotalSemCupom() {
        // Criando mocks dos hamburguers (novamente, objetos falsos)
        hamburguer hamburguerMock1 = Mockito.mock(hamburguer.class);
        hamburguer hamburguerMock2 = Mockito.mock(hamburguer.class);

        // Definindo os preços dos hamburguers falsos
        Mockito.when(hamburguerMock1.getPreco()).thenReturn(15.00);
        Mockito.when(hamburguerMock2.getPreco()).thenReturn(18.00);

        // Criando o pedido e adicionando os hamburguers
        pedido pedido = new pedido();
        pedido.adicionarhamburguer(hamburguerMock1);
        pedido.adicionarhamburguer(hamburguerMock2);

        // Calculando o total do pedido sem aplicar cupom
        double total = pedido.calcularTotal();

        // Verificando se o total calculado é 33.00
        assertEquals(33.00, total, 0.01);
    }
}
