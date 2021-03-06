package Vistas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controlador.AreaAdministracion;
import ViewModels.VistaClase;

public class Cronograma extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7305690017978747952L;
	private JPanel pnlContenedor;
	private JPanel pnlInferior;
	private JTable tblItems;
	private DefaultTableModel dataModel;
	private JLabel lblTitulo;
	List<VistaClase> items;

	public Cronograma() {
		// Establecer el titulo de la ventana
		this.setTitle("CRONOGRAMA");
		// Establecer la dimension de la ventana (ancho, alto)
		this.setSize(750, 400);
		// Establecer NO dimensionable la ventana
		this.setResizable(false);
		// Ubicar la ventana en el centro de la pantalla
		this.setLocationRelativeTo(null);
		// Agregar el panel al JFrame
		this.getContentPane().add(this.getPanelContenedor());
		// Mostrar la ventana
		this.setVisible(true);
	}

	private JPanel getPanelContenedor() {
		pnlContenedor = new JPanel();
		pnlInferior = new JPanel();
		pnlContenedor.setLayout(new BorderLayout());

		lblTitulo = new JLabel("Cronograma");
		lblTitulo.setFont(new Font("Serif", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(JLabel.CENTER);

		pnlContenedor.add(lblTitulo, BorderLayout.PAGE_START);
		pnlContenedor.add(getJTable(), BorderLayout.CENTER);
		pnlContenedor.add(getPanelInferior(), BorderLayout.PAGE_END);
		return pnlContenedor;
	}

	private JPanel getPanelInferior() {
		pnlInferior.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0; // n�mero columna
		gbc.gridy = 0; // n�mero fila
		gbc.gridwidth = 1; // numero de columnas de ancho
		gbc.gridheight = 1; // numero de filas de ancho
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.VERTICAL; // rellenar la celda en ambos sentidos (horizontal y vertical)
		gbc.insets = new Insets(3, 3, 3, 3); // definir el relleno exterior
		return pnlInferior;
	}

	private JScrollPane getJTable() {
		tblItems = new JTable();
		JScrollPane scrollPane = new JScrollPane(tblItems);
		fillTable();
		return scrollPane;
	}

	public void fillTable() {
		items = getItems();
		Vector<String> aux;
		String[] cabecera = { "Deporte", "Día", "Hora" };

		dataModel = new DefaultTableModel();
		dataModel.setColumnCount(5);
		dataModel.setColumnIdentifiers(cabecera);
		tblItems.setModel(dataModel);
		tblItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// List<Socio> items = AreaAdministracion.getInstancia().obtenerSocios();
		for (VistaClase item : items) {
			aux = new Vector<String>();
			aux.add(item.getDeporte().toString());
			aux.add(item.getDia().toString());
			aux.add(item.getHora().toString());
			dataModel.addRow(aux);
		}

		if (tblItems == null)
			tblItems = new JTable();

	}

	private List<VistaClase> getItems() {
		return AreaAdministracion.getInstancia().obtenerClases();
	}
}