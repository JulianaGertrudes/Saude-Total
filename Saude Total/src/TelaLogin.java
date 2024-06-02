import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class TelaLogin {

    private JFrame frame;
    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    private Map<String, Usuario> usuarios;

    public TelaLogin() {
        this.usuarios = new HashMap<>(); // Inicializa o mapa de usuários

        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Define o fundo da tela como roxo claro
        frame.getContentPane().setBackground(new Color(230, 230, 250)); // Fundo roxo claro

        // Criando o layout com GridBagLayout para organizar os componentes
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 9, 20); // Espaçamento entre os componentes

        // Adicionando o texto "Bem-vindo ao Saúde Total!" centralizado e estilizado
        JLabel labelBemVindo = new JLabel("Bem vindo ao Saúde Total");
        labelBemVindo.setFont(new Font("Arial", Font.BOLD, 18));
        labelBemVindo.setForeground(new Color(102, 0, 102)); // Cor roxo escuro
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Define a largura para ocupar duas colunas
        gbc.anchor = GridBagConstraints.NORTH; // Alinhamento superior
        frame.add(labelBemVindo, gbc);

        // Criando os componentes de login
        gbc.gridy++;
        gbc.gridwidth = 1; // Restaura a largura para uma coluna
        JLabel labelUsuario = new JLabel("Usuário:");
        campoUsuario = new JTextField(40);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        frame.add(labelUsuario, gbc);
        gbc.gridy++;
        frame.add(campoUsuario, gbc);

        gbc.gridy++;
        JLabel labelSenha = new JLabel("Senha:");
        campoSenha = new JPasswordField(20);
        frame.add(labelSenha, gbc);
        gbc.gridy++;
        frame.add(campoSenha, gbc);

        gbc.gridy++;
        JButton botaoLogin = new JButton("Login");
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarLogin();
            }
        });
        frame.add(botaoLogin, gbc);

        gbc.gridy++;
        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastro();
            }
        });
        frame.add(botaoCadastrar, gbc);

        // Centraliza o frame na tela
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void add(JTextField t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    private void realizarLogin() {
        String usuario = campoUsuario.getText();
        char[] senha = campoSenha.getPassword();
        String senhaStr = new String(senha);

        // Verifica se o usuário e a senha existem no mapa
        if (usuarios.containsKey(usuario) && usuarios.get(usuario).getSenha().equals(senhaStr)) {
            JOptionPane.showMessageDialog(frame, "Login realizado com sucesso!");
            TelaAgendamento telaAgendamento = new TelaAgendamento();
            frame.dispose(); // Fecha a tela de login após o login bem-sucedido
        } else {
            JOptionPane.showMessageDialog(frame, "Usuário ou senha inválidos. Tente novamente.");
            campoUsuario.setText("");
            campoSenha.setText("");
        }
    }

    private void abrirTelaCadastro() {
        TelaCadastro telaCadastro = new TelaCadastro(usuarios, this);
        frame.dispose(); // Fecha a tela de login ao abrir a tela de cadastro
    }

    public void adicionarUsuario(String usuario, Usuario dados) {
        usuarios.put(usuario, dados);
    }

    public void exibir() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaLogin telaLogin = new TelaLogin();
        });
    }
}

class Usuario {
    private String senha;
    private String cpf;
    private String telefone;

    public Usuario(String senha, String cpf, String telefone) {
        this.senha = senha;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }
}
