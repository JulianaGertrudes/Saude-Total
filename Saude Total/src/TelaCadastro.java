import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * Classe responsável pela tela de cadastro de novos usuários.
 */
public class TelaCadastro {

    private JFrame frame; // O frame principal da tela de cadastro
    private JTextField campoNovoUsuario; // Campo para inserir o novo usuário
    private JPasswordField campoNovaSenha; // Campo para inserir a nova senha
    private JTextField campoCpf; // Campo para inserir o CPF
    private JTextField campoTelefone; // Campo para inserir o telefone
    private JButton botaoCadastrar; // Botão para realizar o cadastro
    private Map<String, Usuario> usuarios; // Mapa de usuários cadastrados
    private TelaLogin telaLogin; // Referência à tela de login

    /**
     * Construtor que inicializa a tela de cadastro e seus componentes.
     *
     * @param usuarios Mapa de usuários cadastrados.
     * @param telaLogin Referência à tela de login.
     */
    public TelaCadastro(Map<String, Usuario> usuarios, TelaLogin telaLogin) {
        this.usuarios = usuarios;
        this.telaLogin = telaLogin;

        frame = new JFrame("Cadastro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new GridBagLayout());

        // Define o fundo com o RGB (230, 230, 250)
        frame.getContentPane().setBackground(new Color(230, 230, 250));

        // Criando o painel para organizar os componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBackground(new Color(230, 230, 250)); // Fundo roxo claro
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Criação dos componentes de interface
        JLabel labelNovoUsuario = new JLabel("Novo Usuário:");
        campoNovoUsuario = new JTextField(20); // Aumentando o tamanho do campo
        JLabel labelNovaSenha = new JLabel("Nova Senha:");
        campoNovaSenha = new JPasswordField(20); // Aumentando o tamanho do campo
        JLabel labelCpf = new JLabel("CPF:");
        campoCpf = new JTextField(20); // Aumentando o tamanho do campo
        JLabel labelTelefone = new JLabel("Telefone:");
        campoTelefone = new JTextField(20); // Aumentando o tamanho do campo
        botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setAlignmentX(Component.CENTER_ALIGNMENT); // Centralizando o botão

        // Ação do botão Cadastrar
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarNovoUsuario(); // Chama o método para cadastrar um novo usuário
            }
        });

        // Adiciona os componentes ao painel
        panel.add(labelNovoUsuario);
        panel.add(campoNovoUsuario);
        panel.add(labelNovaSenha);
        panel.add(campoNovaSenha);
        panel.add(labelCpf);
        panel.add(campoCpf);
        panel.add(labelTelefone);
        panel.add(campoTelefone);

        // Adiciona o botão cadastrar em um novo painel para centralizar
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(230, 230, 250)); // Fundo roxo claro
        buttonPanel.add(botaoCadastrar);

        // Adiciona os painéis ao frame usando o GridBagLayout para centralizar
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1; // Adiciona espaço vertical
        frame.add(panel, gbc);
        
        // Adiciona o painel do botão ajustando a posição vertical
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 20, 0); // Espaçamento inferior
        frame.add(buttonPanel, gbc);

        // Centraliza o frame na tela
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Cadastra um novo usuário no sistema.
     */
    private void cadastrarNovoUsuario() {
        String novoUsuario = campoNovoUsuario.getText();
        String novaSenha = new String(campoNovaSenha.getPassword());
        String cpf = campoCpf.getText();
        String telefone = campoTelefone.getText();

        // Cria um novo objeto Usuario e adiciona ao mapa de usuários
        Usuario novoUsuarioObj = new Usuario(novaSenha, cpf, telefone);
        usuarios.put(novoUsuario, novoUsuarioObj);

        JOptionPane.showMessageDialog(frame, "Novo usuário cadastrado com sucesso!");
        abrirTelaLogin(); // Chama o método para abrir a tela de login novamente
    }

    /**
     * Abre a tela de login novamente.
     */
    private void abrirTelaLogin() {
        telaLogin.exibir(); // Chama o método para exibir a tela de login
        frame.dispose(); // Fecha apenas a tela de cadastro
    }
}
