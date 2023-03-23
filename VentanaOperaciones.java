import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaOperaciones extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField dato;
	private JButton btnCalcular;
	JComboBox Opciones;
	JComboBox Conversion;
	int seleccionado, tipo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaOperaciones frame = new VentanaOperaciones();
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
	public VentanaOperaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 372, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("CHALLENGE 2 ");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblTitulo.setBounds(0, 11, 356, 14);
		contentPane.add(lblTitulo);
		
		Opciones = new JComboBox();
		Opciones.setBounds(44, 51, 122, 22);
		contentPane.add(Opciones);
		Opciones.addItem("Monedas");
		Opciones.addItem("Temperatura");
		Opciones.addItem("Longitud");
		
		JLabel lblNewLabel = new JLabel("Opciones\r\n");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(44, 36, 122, 14);
		contentPane.add(lblNewLabel);
		
		
		
		 Conversion = new JComboBox();
		Conversion.setBounds(196, 51, 122, 22);
		Opciones.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(Opciones.getSelectedIndex()==0) {
					Conversion.removeAllItems();
					Conversion.addItem("Peso - Dolar");
					Conversion.addItem("Dolar - Peso");
					Conversion.addItem("Peso - Euro");
					Conversion.addItem("Euro - Peso");
				}
				
				if(Opciones.getSelectedIndex()==1) {
					Conversion.removeAllItems();
					Conversion.addItem("Celsius - Fahrenheit");
					Conversion.addItem("Celsius - Kelvin");
					Conversion.addItem("Fahrenheit - Celsius");
					Conversion.addItem("Fahrenheit - Kelvin");
					Conversion.addItem("Kelvin - Fahrenheit");
					Conversion.addItem("Kelvin - Celsius");
				}
				
				if(Opciones.getSelectedIndex()==2) {
					Conversion.removeAllItems();
					Conversion.addItem("Kilometros - Millas");
					Conversion.addItem("Kilometros - Metros");
					Conversion.addItem("Millas - Kilometros");
					Conversion.addItem("Metros - Kilometros");
				}
				
			}
		});
		contentPane.add(Conversion);
		
		JLabel lblNewLabel_1 = new JLabel("Conversión");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(196, 36, 122, 14);
		contentPane.add(lblNewLabel_1);
		
		dato = new JTextField();
		dato.setBounds(119, 100, 122, 20);
		contentPane.add(dato);
		dato.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Valor");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(119, 84, 122, 14);
		contentPane.add(lblNewLabel_2);
		
		btnCalcular = new JButton("Calcular\r\n");
		btnCalcular.addActionListener(this);
		btnCalcular.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnCalcular.setBounds(119, 144, 122, 23);
		contentPane.add(btnCalcular);
	};
	
	public void actionPerformed(ActionEvent e) {

		tipo=Opciones.getSelectedIndex();
		seleccionado=Conversion.getSelectedIndex();
		
		if(e.getSource() == btnCalcular) {
			
			
			String input = dato.getText();
			double cantidad = Double.parseDouble(input);
			double resultado=0;
			
			
			if(tipo==0) {
				 if (seleccionado == 0) {
		                resultado = cantidad / 18.59;
		            } else if (seleccionado == 1) {
		                resultado = cantidad * 18.59;
		            }
		            else if (seleccionado == 2) {
		                resultado = cantidad / 20.14;
		            }
		            else if (seleccionado == 3) {
		                resultado = cantidad * 20.14;
		            }
			}else if(tipo==1) {
				if (seleccionado == 0) {
					resultado = (cantidad * 9/5) + 32;

	            } else if (seleccionado == 1) {
	            	resultado = cantidad + 273.15;
	        
	            }
	            else if (seleccionado == 2) {
	            	resultado = (cantidad - 32) * 5/9;
	              
	            }
	            else if (seleccionado == 3) {
	            	resultado = (cantidad - 32) * 5/9 + 273.15;
	            
	            }
	            else if (seleccionado == 4) {
	            	resultado = (cantidad - 273.15) * 9/5 + 32;
	            
	            }
	            else if (seleccionado == 5) {
	            	resultado = cantidad - 273.15;
	             
	            }
				
			}else if(tipo==2) {
				if (seleccionado == 0) {
					resultado = cantidad * 0.62137;

	            } else if (seleccionado == 1) {
	            	resultado = cantidad * 1000;

	            }
	            else if (seleccionado == 2) {
	            	resultado = cantidad / 0.62137;
	    
	            }
	            else if (seleccionado == 3) {
	            	resultado = cantidad / 1000;
	      
	            }
			}
			String result="El resultado de tu conversion es "+resultado;
			JOptionPane.showMessageDialog(this, result,".", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
