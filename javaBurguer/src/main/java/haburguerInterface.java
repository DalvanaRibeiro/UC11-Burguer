import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class haburguerInterface extends JFrame {
    // Lista de lanches disponíveis
    private ArrayList<hamburguer> menuLanches;
    private ArrayList<hamburguer> carrinho;
    private JTextArea textoCarrinho;
    private JTextField campoCupom;
    private JLabel labelTotal;

    public haburguerInterface() {
        // Inicializando a lista de lanches e o carrinho
        menuLanches = new ArrayList<>();
        carrinho = new ArrayList<>();

        // Adicionando alguns lanches ao menu
        menuLanches.add(new hamburguer("Hamburguer 1", 15.00));
        menuLanches.add(new hamburguer("Hamburguer 2", 18.00));
        menuLanches.add(new hamburguer("Hamburguer 3", 12.00));

        // Configurações da janela
        setTitle("Pedido de Lanches");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel com lista de lanches
        JPanel painelLanches = new JPanel();
        painelLanches.setLayout(new GridLayout(menuLanches.size(), 1));
        for (hamburguer hamb : menuLanches) {
            JButton botaoHamburguer = new JButton(hamb.getNome() + " - R$ " + hamb.getPreco());
            botaoHamburguer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    carrinho.add(hamb);
                    atualizarCarrinho();
                }
            });
            painelLanches.add(botaoHamburguer);
        }

        // Adicionando o painel de lanches à janela
        add(painelLanches, BorderLayout.CENTER);

        // Painel de controles (carrinho, cupom e cálculo)
        JPanel painelControles = new JPanel();
        painelControles.setLayout(new BoxLayout(painelControles, BoxLayout.Y_AXIS));

        // Campo do carrinho (exibição dos itens no carrinho)
        textoCarrinho = new JTextArea(10, 20);
        textoCarrinho.setEditable(false);
        painelControles.add(new JScrollPane(textoCarrinho));

        // Campo para inserir cupom
        painelControles.add(new JLabel("Cupom de Desconto:"));
        campoCupom = new JTextField(10);
        painelControles.add(campoCupom);

        // Botão para calcular o total
        JButton botaoCalcular = new JButton("Calcular Total");
        botaoCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularTotal();
            }
        });
        painelControles.add(botaoCalcular);

        // Label para mostrar o total
        labelTotal = new JLabel("Total: R$ 0.00");
        painelControles.add(labelTotal);

        // Botão para finalizar o pedido
        JButton botaoFinalizar = new JButton("Finalizar Pedido");
        botaoFinalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalizarPedido();
            }
        });
        painelControles.add(botaoFinalizar);

        // Adicionando o painel de controles à janela
        add(painelControles, BorderLayout.SOUTH);
    }

    // Método para atualizar o carrinho na interface
    private void atualizarCarrinho() {
        textoCarrinho.setText("");
        for (hamburguer hamb : carrinho) {
            textoCarrinho.append(hamb.getNome() + " - R$ " + hamb.getPreco() + "\n");
        }
    }

    // Método para calcular o total do carrinho
    private void calcularTotal() {
        double total = 0;
        for (hamburguer hamb : carrinho) {
            total += hamb.getPreco();
        }

        // Verificando se o cupom é válido e aplicando o desconto
        String cupom = campoCupom.getText().toUpperCase();
        if (cupom.equals("CUPOM5")) {
            total -= 5.00; // Desconto de R$ 5,00
        } else if (!cupom.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Código de cupom inválido", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        labelTotal.setText("Total: R$ " + String.format("%.2f", total));
    }

    // Método para finalizar o pedido
    private void finalizarPedido() {
        JOptionPane.showMessageDialog(this, "Pedido Finalizado!\nTotal: " + labelTotal.getText());
        // Limpa o carrinho após o pedido ser finalizado
        carrinho.clear();
        atualizarCarrinho();
        labelTotal.setText("Total: R$ 0.00");
    }

    // Método principal para iniciar a aplicação
    public static void main(String[] args) {
        // Criando a interface gráfica
        haburguerInterface app = new haburguerInterface();
        app.setVisible(true);
    }
}
