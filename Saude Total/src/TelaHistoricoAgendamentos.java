import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

// Classe responsável pela tela de histórico de agendamentos.

public class TelaHistoricoAgendamentos {

    private JFrame frame; // O frame principal da tela de histórico
    private JTable tabelaHistorico; // A tabela para exibir o histórico de agendamentos
    private DefaultTableModel model; // O modelo da tabela

    /**
     * Construtor que inicializa a tela de histórico e seus componentes.
     *
     * @param historicoAgendamentos Lista de agendamentos para exibir no histórico.
     */
    public TelaHistoricoAgendamentos(List<String> historicoAgendamentos) {
        frame = new JFrame("Histórico de Agendamentos");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());
        frame.setBackground(new Color(230, 230, 250)); // Fundo roxo claro

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(230, 230, 250)); // Fundo roxo claro

        // Cria o modelo da tabela
        model = new DefaultTableModel();
        model.addColumn("Consulta");

        // Adiciona os agendamentos ao modelo da tabela
        for (String agendamento : historicoAgendamentos) {
            model.addRow(new Object[]{agendamento});
        }

        // Cria a tabela com o modelo
        tabelaHistorico = new JTable(model);
        tabelaHistorico.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(tabelaHistorico);
        panel.add(scrollPane, BorderLayout.CENTER);

        frame.add(panel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null); // Centraliza a janela na tela
        frame.setVisible(true);
    }

    //Exibe a tela de histórico de agendamentos.
     
    public void exibir() {
        frame.pack();
        frame.setVisible(true);
    }
}
