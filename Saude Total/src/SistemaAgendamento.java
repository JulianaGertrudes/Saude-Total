import javax.swing.*;

//Classe principal responsável por iniciar a aplicação de agendamento.
public class SistemaAgendamento {

    // Método principal para iniciar a aplicação.
    public static void main(String[] args) {
        // Garante que a inicialização da interface gráfica seja feita na thread de interface gráfica.
        SwingUtilities.invokeLater(() -> {
            // Cria uma nova instância da tela de login.
            TelaLogin telaLogin = new TelaLogin();
        });
    }
}
