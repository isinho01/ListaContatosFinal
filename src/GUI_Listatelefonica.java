import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arraylist.Agenda;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class GUI_Listatelefonica extends JFrame {
	private Agenda agenda = new Agenda ();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTextField textNomeAdicionar;
	private JTextField textTelefoneAdicionar;
	private JTextField Mensagemadd;
	private JTextField Buscar;
	private JTextField fieldRemover;
	private JTextField Buscarinfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Listatelefonica frame = new GUI_Listatelefonica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_Listatelefonica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 664);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Minha Lista de Contatos");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(171, 0, 196, 46);
		contentPane.add(lblNewLabel);
		
		
		JPanel panel_Inserir = new JPanel();
		panel_Inserir.setBackground(new Color(0, 0, 0));
		// deixar nao visivel no jframe 
		panel_Inserir.setVisible(false);
		panel_Inserir.setBounds(10, 159, 253, 119);
		contentPane.add(panel_Inserir);
		panel_Inserir.setLayout(null);
		
		Buscar = new JTextField();
		Buscar.setBounds(10, 33, 160, 19);
		panel_Inserir.add(Buscar);
		Buscar.setColumns(10);
		
		JButton botaopesquisarctt = new JButton("🔎");
		botaopesquisarctt.setBackground(new Color(0, 0, 160));
		botaopesquisarctt.setForeground(new Color(0, 0, 0));
		botaopesquisarctt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (agenda.buscar(Buscar.getText()) == null) {
					Buscar.setText("Esse contato nao existe ! ");
					
				}else {
					agenda.buscar(Buscar.getText());
					// setando o texto para buscar na agenda
					Buscarinfo.setText(agenda.buscar(Buscar.getText()).getTelefone());
					
				}
					
				
				
			}
		});
		botaopesquisarctt.setBounds(10, 88, 85, 21);
		panel_Inserir.add(botaopesquisarctt);
		
		JLabel lblNewLabel_1 = new JLabel("Insira um nome");
		lblNewLabel_1.setForeground(new Color(0, 0, 160));
		lblNewLabel_1.setBounds(10, 10, 143, 13);
		panel_Inserir.add(lblNewLabel_1);
		
		Buscarinfo = new JTextField();
		Buscarinfo.setBounds(20, 62, 150, 19);
		panel_Inserir.add(Buscarinfo);
		Buscarinfo.setColumns(10);
		
		JPanel panel_Adicionar = new JPanel();
		panel_Adicionar.setBackground(new Color(0, 0, 0));
		panel_Adicionar.setVisible(false);
		panel_Adicionar.setBounds(304, 159, 225, 138);
		contentPane.add(panel_Adicionar);
		panel_Adicionar.setLayout(null);
		
		textNomeAdicionar = new JTextField();
		textNomeAdicionar.setBounds(10, 20, 162, 19);
		panel_Adicionar.add(textNomeAdicionar);
		textNomeAdicionar.setColumns(10);
		
		textTelefoneAdicionar = new JTextField();
		textTelefoneAdicionar.setBounds(10, 59, 166, 19);
		panel_Adicionar.add(textTelefoneAdicionar);
		textTelefoneAdicionar.setColumns(10);
		
		Mensagemadd = new JTextField();
		Mensagemadd.setEditable(false);
		Mensagemadd.setBounds(10, 88, 162, 19);
		panel_Adicionar.add(Mensagemadd);
		Mensagemadd.setColumns(10);
		
		JButton botaoadicionarctt = new JButton("+");
		botaoadicionarctt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// adicionando os contatos na lista via interface grafica 
				if (agenda.inserir(textNomeAdicionar.getText(), textTelefoneAdicionar.getText())){
					Mensagemadd.setText("Contato adicionado !");
				}else {
					Mensagemadd.setText("Contato nao Adicionado !");
				}
				
			}
		});
		botaoadicionarctt.setBounds(71, 117, 85, 21);
		panel_Adicionar.add(botaoadicionarctt);
		
		JLabel lblNewLabel_4 = new JLabel("Nome:");
		lblNewLabel_4.setForeground(new Color(0, 0, 160));
		lblNewLabel_4.setBounds(10, 0, 45, 13);
		panel_Adicionar.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Telefone:");
		lblNewLabel_5.setForeground(new Color(0, 0, 160));
		lblNewLabel_5.setBounds(10, 42, 72, 13);
		panel_Adicionar.add(lblNewLabel_5);
		
		JPanel panel_Remover = new JPanel();
		panel_Remover.setBackground(new Color(0, 0, 0));
		panel_Remover.setVisible(false);
		panel_Remover.setBounds(10, 309, 253, 119);
		contentPane.add(panel_Remover);
		panel_Remover.setLayout(null);
		
		fieldRemover = new JTextField();
		fieldRemover.setBounds(10, 33, 185, 19);
		panel_Remover.add(fieldRemover);
		fieldRemover.setColumns(10);
		
		JButton botaoremoverctt = new JButton("Remover");
		botaoremoverctt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (agenda.Remover(fieldRemover.getText())) {
					fieldRemover.setText("Contato removido !");
				}else {
					fieldRemover.setText("Contato nao encontrado. ");
				}
				
			}
		});
		botaoremoverctt.setBounds(70, 88, 109, 21);
		panel_Remover.add(botaoremoverctt);
		
		JLabel lblNewLabel_1_1 = new JLabel("Insira um nome");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 160));
		lblNewLabel_1_1.setBounds(10, 10, 143, 13);
		panel_Remover.add(lblNewLabel_1_1);
		
		JPanel panel_Exibir = new JPanel();
		panel_Exibir.setVisible(false);
		panel_Exibir.setBounds(304, 309, 225, 113);
		contentPane.add(panel_Exibir);
		panel_Exibir.setLayout(null);
		
		JTextArea Exibirctt = new JTextArea();
		Exibirctt.setBounds(0, 0, 225, 113);
		panel_Exibir.add(Exibirctt);
		
		JButton btnNewButton = new JButton("🔎");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Inserir.setVisible(true);
				panel_Adicionar.setVisible(false);
				panel_Remover.setVisible(false);
				panel_Exibir.setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(73, 56, 91, 26);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("+");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Adicionar.setVisible(true);
				panel_Inserir.setVisible(false);
				panel_Remover.setVisible(false);
				panel_Exibir.setVisible(false);
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(0, 128, 255));
		btnNewButton_1.setBounds(427, 56, 91, 26);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Remover");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Remover.setVisible(true);
				panel_Adicionar.setVisible(false);
				panel_Inserir.setVisible(false);
				panel_Exibir.setVisible(false);
			}
		});
		btnNewButton_2.setBackground(new Color(0, 128, 255));
		btnNewButton_2.setBounds(201, 92, 186, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Exibir contatos");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Exibir.setVisible(true);
				panel_Remover.setVisible(false);
				panel_Adicionar.setVisible(false);
				panel_Inserir.setVisible(false);
				agenda.ordemalfabetica();
			String aux = "" ;
			// varredura do ArrayList
			for (int i = 0; i<agenda.getQuantidade_contatos();i++) {
				// pegando contato da posiçao i e exibindo o nome 
				aux = aux + agenda.getContato(i).getNome()+ "-"+ agenda.getContato(i).getTelefone()+"\n";
				
			}
			Exibirctt.setText(aux);
				
			}
		});
		btnNewButton_3.setBounds(201, 123, 186, 19);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("Buscar");
		lblNewLabel_2.setForeground(new Color(0, 0, 160));
		lblNewLabel_2.setBounds(73, 33, 67, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Adicionar");
		lblNewLabel_3.setForeground(new Color(0, 0, 160));
		lblNewLabel_3.setBounds(428, 33, 67, 13);
		contentPane.add(lblNewLabel_3);
		
		JButton Salvar = new JButton("Salvar");
		Salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					agenda.saveagenda();
				} catch (Exception e1) {
					
				}
			}
		});
		Salvar.setBounds(428, 106, 85, 21);
		contentPane.add(Salvar);
		
		JButton Carregar = new JButton("Carregar");
		Carregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					agenda.carregandoagenda();
				} catch (Exception e1) {
				}
			}
		});
		Carregar.setBounds(73, 106, 85, 21);
		contentPane.add(Carregar);
	
	}
}
