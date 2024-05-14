package ui_swing;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;

public class Tela_cadastro_filme extends JPanel {

    //objeto para o fluxo de bytes
    public static FileInputStream fis;
    //armazena o tamanho da imagem
    public static int tamanho;

    private static JLabel lblCartaz;
    private static JTextField nomeText, duracaoText, elencoText, diretorText, generoText, distribuidoraText, classificacaoText;
    private static JTextArea sinopseText;
    private static JButton nakabank, home, procuraFoto, cadastrarButton;

    public static FileInputStream getFis() {
        return fis;
    }

    public static int getTamanho() {
        return tamanho;
    }

    public static JLabel getLblCartaz() {
        return lblCartaz;
    }

    public static JButton getProcuraFoto() {
        return procuraFoto;
    }

    public static JTextField getNomeText() {
        return nomeText;
    }

    public static JTextField getDuracaoText() {
        return duracaoText;
    }

    public static JTextField getElencoText() {
        return elencoText;
    }

    public static JTextField getDiretorText() {
        return diretorText;
    }

    public static JTextField getGeneroText() {
        return generoText;
    }

    public static JTextField getDistribuidoraText() {
        return distribuidoraText;
    }

    public static JTextField getClassificacaoText() {
        return classificacaoText;
    }

    public static JTextArea getSinopseText() {
        return sinopseText;
    }

    public static JButton getCadastrarButton() {
        return cadastrarButton;
    }

    public Tela_cadastro_filme(ActionListener listener) {
        setBackground(Color.decode("#0D1E40"));
        setLayout(new BorderLayout()); // Usar BorderLayout para colocar o painel no topo

        JPanel header = new JPanel(new FlowLayout());
        header.setOpaque(true);
        header.setBackground(Color.decode("#F2F0C9"));
        ImageIcon imageIcon = new ImageIcon("src/main/resources/Logo_header.png");
        JLabel imageLabel = new JLabel(imageIcon);
        header.add(imageLabel);
        JLabel fantasma1 = new JLabel();
        fantasma1.setPreferredSize(new Dimension(295, 56));
        header.add(fantasma1);
        JLabel fantasma2 = new JLabel();
        fantasma2.setPreferredSize(new Dimension(295, 56));
        header.add(fantasma2);
        nakabank = Metodos_swing.cria_botao_header("NakaBank");
        nakabank.addActionListener(listener);
        header.add(nakabank);
        JLabel fantasma3 = new JLabel();
        fantasma3.setPreferredSize(new Dimension(148, 56));
        header.add(fantasma3);
        home = Metodos_swing.cria_botao_header("Home");
        home.addActionListener(listener);
        header.add(home);
        JLabel fantasma4 = new JLabel();
        fantasma4.setPreferredSize(new Dimension(148, 56));
        header.add(fantasma4);
        ImageIcon usuario = new ImageIcon("src/main/resources/Usuario.png");
        JLabel imageUsuario = new JLabel(usuario);
        header.add(imageUsuario);

        // Adiciona o painel de cabeçalho ao BorderLayout na parte superior
        add(header, BorderLayout.NORTH);

        JPanel footer = new JPanel(new FlowLayout());
        footer.setOpaque(true);
        footer.setBackground(Color.decode("#F2F0C9"));
        JLabel data = new JLabel();
        Tela_principal.mostrarData(data);
        data.setForeground(Color.decode("#F21B7F"));
        footer.add(data);

        // Adiciona o painel de rodapé ao BorderLayout na parte inferior
        add(footer, BorderLayout.SOUTH);


//        setBackground(Color.decode("#0D1E40"));
//        setLayout(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(10, 10, 10, 10);
//        gbc.gridx = 0;
//        gbc.gridy = 0;

//        // Adicionando a imagem no painel
//        ImageIcon imageIcon = new ImageIcon("src/main/resources/Logo.png");
//        JLabel imageLabel = new JLabel(imageIcon);
//        add(imageLabel, gbc);

//        gbc.gridy = 1;
        // Adicionando o cartaz
        JPanel fotoCartaz = new JPanel(new GridLayout(2, 1));
        fotoCartaz.setOpaque(false);
        lblCartaz = new JLabel();
        lblCartaz.setSize(new Dimension(400, 600));
        lblCartaz.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        fotoCartaz.add(lblCartaz);
        procuraFoto = Metodos_swing.cria_botao("Procurar Imagem");
        procuraFoto.addActionListener(listener);
        fotoCartaz.add(procuraFoto);
        add(fotoCartaz, BorderLayout.WEST);

        // Adicionando os campos de texto
//        gbc.gridy = 1;
        JPanel inputPanel = new JPanel(new GridLayout(8, 2, 0, 30));
        inputPanel.setOpaque(false);
        JLabel nome = new JLabel("Nome do Filme:");
        nome.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(nome);
        nomeText = new JTextField(20);
        inputPanel.add(nomeText);
        JLabel duracao = new JLabel("Duração:");
        duracao.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(duracao);
        duracaoText = new JTextField(20);
        inputPanel.add(duracaoText);
        JLabel elenco = new JLabel("Elenco:");
        elenco.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(elenco);
        elencoText = new JTextField(50);
        inputPanel.add(elencoText);
        JLabel diretor = new JLabel("Diretor:");
        diretor.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(diretor);
        diretorText = new JTextField(20);
        inputPanel.add(diretorText);
        JLabel genero = new JLabel("Gênero:");
        genero.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(genero);
        generoText = new JTextField(20);
        inputPanel.add(generoText);
        JLabel distribuidora = new JLabel("Distribuidora:");
        distribuidora.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(distribuidora);
        distribuidoraText = new JTextField(20);
        inputPanel.add(distribuidoraText);
        JLabel classificacao = new JLabel("Classificação:");
        classificacao.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(classificacao);
        classificacaoText = new JTextField(20);
        inputPanel.add(classificacaoText);
        JLabel sinopse = new JLabel("Sinopse:");
        sinopse.setForeground(Color.decode("#F21B7F"));
        inputPanel.add(sinopse);
        sinopseText = new JTextArea();
        sinopseText.setLineWrap(true);
        sinopseText.setWrapStyleWord(true);
        // Adicionar barra de rolagem vertical
        JScrollPane scrollPane = new JScrollPane(sinopseText);
        // Adicionar JTextArea com barra de rolagem ao painel
        inputPanel.add(scrollPane);
        add(inputPanel, BorderLayout.CENTER);

//        // Adicionando o botão
//        gbc.gridy = 2;
        cadastrarButton = Metodos_swing.cria_botao("Cadastrar");
        cadastrarButton.addActionListener(listener);
        add(cadastrarButton, BorderLayout.EAST);
    }


}