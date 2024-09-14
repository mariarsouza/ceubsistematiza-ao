package br.uva.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
//import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
//import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.uva.controller.ContatoController;
import br.uva.model.Contato;
//import br.uva.modelo.Categoria;
//import br.uva.modelo.Produto;
//import br.uva.modelo.Categoria;
//import br.uva.modelo.Categoria;
//import br.uva.modelo.Produto;

public class ContatoFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel lbNome, lbEmail, lbTelefone;
	private JTextField txtNome, txtEmail, txtTelefone, txtLocalizar;
	private JButton btnSalvar, btnAlterar, btnExcluir, btnClear, btnLocalizar, btnExibir;
	private JButton btnPrimeiro, btnProximo, btnAnterior, btnUltimo;
	private JComboBox<Contato> comboContato;

	private List<Contato> contatoList = new ContatoController().listaContatos();
	private int registroAtual = 0;
	private Long key;
	private ExibirFrame telaExibir;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	Object[] botoes = {"Sim", "N�o"};

	public ContatoFrame() {
		super("Contatos");
		Container tela = getContentPane();
		setLayout(null);
		lbNome = new JLabel("Nome");
		lbEmail = new JLabel("Apelido");
		lbTelefone = new JLabel("Data de Nascimento(dd/mm/aaaa)");

		lbNome.setBounds(10, 10, 240, 15);
		lbEmail.setBounds(10, 50, 240, 15);
		lbTelefone.setBounds(10, 90, 240, 15);

		lbNome.setForeground(Color.BLACK);
		lbEmail.setForeground(Color.BLACK);
		lbTelefone.setForeground(Color.BLACK);

		lbNome.setFont(new Font("Courier New", Font.BOLD, 14));
		lbEmail.setFont(new Font("Courier New", Font.BOLD, 14));
		lbTelefone.setFont(new Font("Courier New", Font.BOLD, 14));

		tela.add(lbNome);
		tela.add(lbEmail);
		tela.add(lbTelefone);

		txtNome = new JTextField();
		txtEmail = new JTextField();
		txtTelefone = new JTextField();

		txtNome.setBounds(10, 25, 265, 20);
		txtEmail.setBounds(10, 65, 265, 20);
		txtTelefone.setBounds(10, 105, 265, 20);

		tela.add(txtNome);
		tela.add(txtEmail);
		tela.add(txtTelefone);

		btnSalvar = new JButton("Salvar");
		btnAlterar = new JButton("Alterar");
		btnExcluir = new JButton("Excluir");
		btnExibir = new JButton("Exibir");
		btnClear = new JButton("Limpar");
		btnPrimeiro = new JButton("|<");
		btnAnterior = new JButton("<<");
		btnProximo = new JButton(">>");
		btnUltimo = new JButton(">|");

		btnSalvar.setBounds(280, 25, 80, 20);
		btnAlterar.setBounds(280, 65, 80, 20);
		btnExcluir.setBounds(280, 105, 80, 20);
		btnExibir.setBounds(280, 158, 80, 20);

			// Adicionar os bot�es de a��o ao Container
		
		
		tela.add(btnSalvar);//Adiciona uma a��o ao bot�o Salvar
		tela.add(btnAlterar);//Adiciona uma a��o ao bot�o Alterar
		tela.add(btnExcluir);//Adiciona uma a��o ao bot�o Excluir
		tela.add(btnExibir);//Adiciona uma a��o ao bot�o Exibir
		tela.add(btnClear);//Adiciona uma a��o ao bot�o Limpar
		tela.add(btnPrimeiro);//Adiciona uma a��o ao bot�o voltar ao primeiro
		tela.add(btnAnterior);//Adiciona uma a��o ao bot�o voltar ao anterior
		tela.add(btnProximo);//Adiciona uma a��o ao bot�o para passar ao proximo
		tela.add(btnUltimo);//Adiciona uma a��o ao bot�o para passar para o ultimo
		
			
		
		

		btnPrimeiro.setBounds(10, 135, 50, 20);
		btnAnterior.setBounds(60, 135, 50, 20);
		btnClear.setBounds(110, 135, 75, 20);
		btnProximo.setBounds(185, 135, 50, 20);
		btnUltimo.setBounds(235, 135, 50, 20);

		tela.add(btnPrimeiro);
		tela.add(btnAnterior);
		tela.add(btnClear);
		tela.add(btnProximo);
		tela.add(btnUltimo);

		JLabel lbLocalizar = new JLabel("Localizar por nome");
		lbLocalizar.setBounds(10, 160, 220, 20);

		txtLocalizar = new JTextField();
		txtLocalizar.setBounds(10, 180, 220, 20);

		btnLocalizar = new JButton("Ir");
		btnLocalizar.setBounds(230, 180, 55, 20);

		tela.add(lbLocalizar);
		tela.add(txtLocalizar);
		tela.add(btnLocalizar);

		setSize(400, 250);
		setVisible(true);
		setLocationRelativeTo(null);

		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				onClickSalvar();
		}});
		// Criar um ActionListener que chama o m�todo onClickSalvar() );

		btnAlterar.addActionListener(e ->{
			onClickAlterar();
			
		}
			// Criar um ActionListener que chama o m�todo onClickAlterar()
		);

		btnExcluir.addActionListener(e ->{
			onClickExcluir();
		}
			// Criar um ActionListener que chama o m�todo onClickExcluir()
		);

		btnExibir.addActionListener(e ->{
			onClickExibir();
		}
			// Criar um ActionListener que chama o m�todo onClickExibir()		
		);

		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFields();
				registroAtual = 0;
			}
		});

		btnLocalizar.addActionListener(e ->{
			try {
				onClickLocalizar();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
				
			// Criar um ActionListener que chama o m�todo onClickLocalizar()
		);

		btnPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickPrimeiro();
			}
		});
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickAnterior();
			}
		});

		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickProximo();
			}
		});

		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickUltimo();
			}
		});
	}

	private void onClickUltimo() {
		registroAtual = contatoList.size() - 1;
		getValores(registroAtual);
	}

	private void onClickProximo() {
		if (registroAtual != contatoList.size() - 1) {
			getValores(++registroAtual);
		}
	}

	private void onClickAnterior() {
		if (registroAtual != 0) {
			getValores(--registroAtual);
		}
	}

	private void onClickPrimeiro() {
		registroAtual = 0;
		getValores(registroAtual);
	}

	private void getValores(int index) {
		if (index <= contatoList.size() - 1) {
			Contato contatoAtual = (Contato) contatoList.get(index);
			txtNome.setText(contatoAtual.getNome());
			txtEmail.setText(contatoAtual.getEmail());
			txtTelefone.setText(contatoAtual.getTelefone());		
		}
	}

	private void onClickAlterar() {
		ContatoController cc = new ContatoController();

		long id = 0L;

		if (key == null) {
			id = ((Contato) contatoList.get(registroAtual)).getId();
		} else {
			id = key;
			key = null;
		}

		try {
			cc.alterar(id, txtNome.getText(), txtEmail.getText(), txtTelefone.getText());
			JOptionPane.showMessageDialog(this, "Contato alterado com sucesso!");
			clearFields();
			contatoList = new ContatoController().listaContatos();
			if (telaExibir != null)
				telaExibir.preencherTabela();
				
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Nao foi possivel alterar contato!n" + e.getLocalizedMessage());
		} catch (DateTimeParseException e) {
			JOptionPane.showMessageDialog(this, "Data possui formato inv�lido!n" + e.getLocalizedMessage());
		}
	}

	private void onClickSalvar() {
		ContatoController cc = new ContatoController();
		try {
			cc.salvar(txtNome.getText(), txtEmail.getText(), txtTelefone.getText());
			JOptionPane.showMessageDialog(this, "Contato salvo com sucesso!");
			clearFields();
			contatoList = new ContatoController().listaContatos();
			if (telaExibir != null)
				telaExibir.preencherTabela();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Nao foi possivel salvar contato!n" + e.getLocalizedMessage());
		} catch (DateTimeParseException e) {
			JOptionPane.showMessageDialog(this, "Data possui formato inv�lido!n" + e.getLocalizedMessage());
		}
	}

	private void onClickExcluir() {
		ContatoController cc = new ContatoController();
		long id2= ((Contato) contatoList.get(registroAtual)).getId();
		try {
			cc.excluir(id2);
			JOptionPane.showMessageDialog(this, "Contato excluido com sucesso!");
			clearFields();
			contatoList = new ContatoController().listaContatos();
			if (telaExibir != null)
				telaExibir.preencherTabela();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Nao foi possivel excluir o contato!n" + e.getLocalizedMessage());
		}
	}

	private void onClickExibir() {
		telaExibir = new ExibirFrame();
		telaExibir.setVisible(true);
		WindowListener x = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				telaExibir.dispose(); // Fecha e libera os recursos
				telaExibir = null; // Atribui null para os m�todos saberem que j� foi fechado
			}
		};
		telaExibir.addWindowListener(x);
	}

	private void onClickLocalizar() throws Exception {
		ContatoController cc = new ContatoController();
		try {
			Contato c = cc.buscaContatoPorNome(txtLocalizar.getText());
			txtNome.setText(c.getNome());
			txtEmail.setText(c.getEmail());
			txtTelefone.setText(c.getTelefone());
			key = c.getId();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Ocorreu um erro, tente novamente!n" + e.getLocalizedMessage());
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this, "Contato n�o localizdo ou n�o existe!n" + e.getLocalizedMessage());
		}
	}

	private void clearFields() {
		txtNome.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
		txtLocalizar.setText("");
	}


	public static void main(String[] args) {
		ContatoFrame frame = new ContatoFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}