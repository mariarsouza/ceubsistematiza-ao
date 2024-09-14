package br.uva.view;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;

//import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.uva.controller.ContatoController;
import br.uva.model.Contato;

public class ExibirFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private List<Contato> contatoList; 
	private JTable tabela;
	private DefaultTableModel modelo;
	private JScrollPane scroller;

	public ExibirFrame() {
		setTitle("Tabela de Contatos");
		setResizable(false);
		setLocation(50, 50);
		setSize(600, 300);
		try {
			preencherTabela();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void preencherTabela() throws SQLException {
		contatoList = new ContatoController().listaContatos();
		tabela = new JTable();
		modelo = (DefaultTableModel) tabela.getModel();
		scroller = new JScrollPane();
		scroller.setViewportView(tabela);
		getContentPane().add(scroller, BorderLayout.CENTER);
		validate();

		modelo.addColumn("Identificador do Contato");
		modelo.addColumn("Nome do Contato");
		modelo.addColumn("Email");
		modelo.addColumn("Telefone");
		for (Contato c : contatoList) {
			modelo.addRow(new Object[] { c.getId(), c.getNome(), c.getEmail(),
					c.getTelefone()});
//					new SimpleDateFormat("dd/MM/yyyy").format(c.getDtNascimento()) });
		}
		setVisible(true);
	}
}
