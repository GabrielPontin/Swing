package br.univel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaPrincipal extends JFrame {


	private JTable table;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				TelaPrincipal tp = new TelaPrincipal();
				tp.setSize(800, 600);
				tp.setLocationRelativeTo(null);
				tp.setVisible(true);
			}
		});

	}


	public TelaPrincipal() {
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		JScrollPane jsc = new JScrollPane();
		table = new JTable();
		jsc.setViewportView(table);
		jp.add(jsc, BorderLayout.CENTER);

		JButton button = new JButton("Carregar");
		jp.add(button, BorderLayout.NORTH);

		setContentPane(jp);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				carregar();
			}
		});

	}


	protected void carregar() {

		DaoPessoa dao = new DaoPessoa();

		List<Pessoa> lista = dao.getPessoas();

		MeuModelo meuModelo = new MeuModelo(lista);

		table.setModel(meuModelo);

	}

}
