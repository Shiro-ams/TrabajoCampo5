package V_principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyecto_cafeteria.Pedido;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class V1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V1 frame = new V1();
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
	public V1() {
		setTitle("CAFETERIA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SELECCIONA TU PRODUCTO");
		lblNewLabel.setBounds(39, 52, 143, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblAgregarExtras = new JLabel("AGREGAR EXTRAS");
		lblAgregarExtras.setBounds(397, 52, 120, 28);
		contentPane.add(lblAgregarExtras);
		
		JLabel lblEscogeElTamao = new JLabel("ESCOGE EL TAMAÑO");
		lblEscogeElTamao.setBounds(224, 52, 120, 28);
		contentPane.add(lblEscogeElTamao);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 220, 499, 208);
		contentPane.add(scrollPane);
		
		JTextArea txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		JComboBox CBproducto = new JComboBox();
		CBproducto.setModel(new DefaultComboBoxModel(new String[] {"", "cafe    $5.00", "té       $ 2.00"}));
		CBproducto.setBounds(49, 90, 132, 21);
		contentPane.add(CBproducto);
		
		JComboBox CBtamaño = new JComboBox();
		CBtamaño.setModel(new DefaultComboBoxModel(new String[] {"", "Grande", "Mediano", "Pequeño"}));
		CBtamaño.setBounds(212, 90, 132, 21);
		contentPane.add(CBtamaño);
		
		JComboBox CBextras = new JComboBox();
		CBextras.setModel(new DefaultComboBoxModel(new String[] {"", "Leche", "Azucar"}));
		CBextras.setBounds(385, 90, 132, 21);
		contentPane.add(CBextras);
		
		JButton btnNewButton = new JButton("PEDIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            String producto = (String) CBproducto.getSelectedItem();
		            String tamaño = (String) CBtamaño.getSelectedItem();
		            String extra = (String) CBextras.getSelectedItem();

		            
		            if (producto == null || producto.isEmpty() || tamaño == null || tamaño.isEmpty()) {
		                JOptionPane.showMessageDialog(null, "Por favor selecciona un producto y un tamaño.");
		                return;
		            }

		            
				Pedido pedido;
                   	 	if (extra != null && !extra.isEmpty()) {
                        		pedido = new Pedido(producto, tamaño, extra);
                    		} else {
                        		pedido = new Pedido(producto, tamaño);
                    		}
		          
		            double precio = pedido.calcularPrecio(true); 
		            String resumen = "Producto: " + producto + "\n" 
		                           + "Tamaño: " + tamaño + "\n";
		            
		            if (extra != null && !extra.isEmpty()) {
		                resumen += "Extra: " + extra + "\n";
		            }

		            resumen += String.format("Total: $%.2f", precio);  

		          
		            txtS.setText(resumen);

		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error al procesar el pedido: " + ex.getMessage());
		        }
		    }
		});
		btnNewButton.setBounds(235, 173, 85, 21);
		contentPane.add(btnNewButton);
	}
}
