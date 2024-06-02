import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaAgendamento {

    private JFrame frame; // O frame principal da aplicação
    private JComboBox<String> comboEspecialidade; // Combo box para selecionar a especialidade médica
    private JComboBox<String> comboHora; // Combo box para selecionar a hora do agendamento
    private JComboBox<String> comboDiaSemana; // Combo box para selecionar o dia da semana do agendamento
    private List<String> historicoAgendamentos; // Lista para armazenar o histórico de agendamentos

    // Construtor da classe
    public TelaAgendamento() {
        // Inicialização do JFrame
        frame = new JFrame("Agendamento");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new GridBagLayout()); // Utilizando GridBagLayout para centralizar

        // Define o fundo do frame com o RGB (230, 230, 250)
        frame.getContentPane().setBackground(new Color(230, 230, 250));

        // Criando o painel para organizar os componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10)); // Organizando em grade

        // Criação dos componentes de interface
        JLabel labelEspecialidade = new JLabel("Especialidade:");
        String[] especialidades = {"Ginecologia", "Pediatria", "Cardiologia", "Dermatologia"};
        comboEspecialidade = new JComboBox<>(especialidades);

        JLabel labelDiaSemana = new JLabel("Dia da Semana:");
        String[] diasSemana = {"Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira"};
        comboDiaSemana = new JComboBox<>(diasSemana);

        JLabel labelHora = new JLabel("Hora:");
        String[] horas = {"08:00", "09:00", "10:00", "11:00", "13:00", "14:00", "15:00", "16:00"};
        comboHora = new JComboBox<>(horas);

        JButton botaoAgendar = new JButton("Agendar");
        JButton botaoCancelarConsulta = new JButton("Cancelar Consulta");
        JButton botaoHistorico = new JButton("Histórico de Agendamentos");

        historicoAgendamentos = new ArrayList<>(); // Inicializa a lista de histórico de agendamentos

        // Adicionando os componentes ao painel
        panel.add(labelEspecialidade);
        panel.add(comboEspecialidade);
        panel.add(labelDiaSemana);
        panel.add(comboDiaSemana);
        panel.add(labelHora);
        panel.add(comboHora);
        panel.add(botaoAgendar);
        panel.add(botaoCancelarConsulta);
        panel.add(botaoHistorico);

        // Centralizando o painel no frame
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 20); // Espaçamento uniforme
        frame.add(panel, gbc);

        // Centraliza o frame na tela
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Ação do botão Agendar
        botaoAgendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarAgendamento(); // Chama o método para realizar o agendamento
            }
        });

        // Ação do botão Cancelar Consulta
        botaoCancelarConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarConsulta(); // Chama o método para cancelar a consulta
            }
        });

        // Ação do botão Histórico
        botaoHistorico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarHistorico(); // Chama o método para mostrar o histórico de agendamentos
            }
        });
    }

    // Método para realizar o agendamento
    private void realizarAgendamento() {
        // Obtém os valores selecionados nos combo boxes
        String especialidade = (String) comboEspecialidade.getSelectedItem();
        String diaSemana = (String) comboDiaSemana.getSelectedItem();
        String hora = (String) comboHora.getSelectedItem();

        // Cria uma string com os dados do agendamento
        String agendamento = "Especialidade: " + especialidade +
                " - Dia da Semana: " + diaSemana +
                " - Hora: " + hora;

        // Adiciona o agendamento ao histórico
        historicoAgendamentos.add(agendamento);

        // Exibe uma mensagem de sucesso
        JOptionPane.showMessageDialog(frame, "Agendamento realizado com sucesso!\n" + agendamento);
    }

    // Método para cancelar a consulta
    private void cancelarConsulta() {
        // Verifica se há agendamentos no histórico
        if (historicoAgendamentos.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Não há agendamentos para cancelar.");
            return;
        }

        // Converte o histórico para um array de strings
        String[] opcoes = historicoAgendamentos.toArray(new String[0]);

        // Exibe uma caixa de diálogo para selecionar o agendamento a ser cancelado
        String agendamentoCancelar = (String) JOptionPane.showInputDialog(frame,
                "Selecione o agendamento a ser cancelado:", "Cancelar Consulta",
                JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

        // Se um agendamento foi selecionado, remove-o do histórico e exibe uma mensagem de sucesso
        if (agendamentoCancelar != null) {
            historicoAgendamentos.remove(agendamentoCancelar);
            JOptionPane.showMessageDialog(frame, "Consulta cancelada com sucesso!");
        }
    }

    // Método para mostrar o histórico de agendamentos
    private void mostrarHistorico() {
        // Cria uma instância da tela de histórico de agendamentos e a exibe
        TelaHistoricoAgendamentos telaHistorico = new TelaHistoricoAgendamentos(historicoAgendamentos);
        telaHistorico.exibir();
    }

    // Método main para iniciar a aplicação
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaAgendamento telaAgendamento = new TelaAgendamento(); // Cria uma instância da classe TelaAgendamento
        });
    }
}
