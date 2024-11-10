package org.uade.fuentes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {
	
	/* alta usuario residencial */
	JTextField nombre_txt;
	JTextField dni_txt;
	JTextField calle_txt;
	JTextField altura_txt;
	JTextField piso_txt;
	JTextField dpto_txt;
	JTextField cp_txt;
	JTextField loca_txt;
	JTextField pcia_txt;
	
	JLabel nombre_lbl;
	JLabel dni_lbl;
	JLabel calle_lbl;
	JLabel altura_lbl;
	JLabel piso_lbl;
	JLabel dpto_lbl;
	JLabel cp_lbl;
	JLabel loca_lbl;
	JLabel pcia_lbl;
	JLabel salidaAltaUsuarioResi;
	JButton guardarUsuario_btn;
	
	/* botones */
	JButton btnCrearUsuarioIndustrial;
	JButton btnConsultarConsumo;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		nombre_txt 	= new JTextField();
		dni_txt 	= new JTextField();
		calle_txt 	= new JTextField();
		altura_txt 	= new JTextField();
		piso_txt 	= new JTextField();
		dpto_txt 	= new JTextField();
		cp_txt 		= new JTextField();
		loca_txt 	= new JTextField();
		pcia_txt 	= new JTextField();
		
		nombre_lbl 					= new JLabel("Nombre: ");
		dni_lbl		 				= new JLabel("Dni: ");
		calle_lbl	 				= new JLabel("Calle: ");
		altura_lbl	 				= new JLabel("Altura: ");
		piso_lbl		 			= new JLabel("Piso: ");
		dpto_lbl		 			= new JLabel("Dpto: ");
		cp_lbl		 				= new JLabel("CP: ");
		loca_lbl		 			= new JLabel("Loca: ");
		pcia_lbl		 			= new JLabel("Pcia: ");
		salidaAltaUsuarioResi	 	= new JLabel("Salida: ");
		guardarUsuario_btn			= new JButton("Guardar");
		
		
		btnCrearUsuarioIndustrial 	= new JButton("Crear Usuario Industrial");
		btnConsultarConsumo 		= new JButton("Consultar Consumo");
		
		JButton btnCrearUsuarioResidencial = new JButton("Crear Usuario Residencial");
		btnCrearUsuarioResidencial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//oculta los otros botones
				btnCrearUsuarioIndustrial.setVisible(false);
				btnConsultarConsumo.setVisible(false);
				
				//muestra formulario de carga
				
				nombre_lbl.setBounds(10, 5, 210, 23);
				contentPane.add(nombre_lbl);
				nombre_txt.setBounds(10, 50, 210, 23);
				contentPane.add(nombre_txt);
				
				dni_lbl.setBounds(20, 5, 210, 23);
				contentPane.add(dni_lbl);
				dni_txt.setBounds(20, 50, 210, 23);
				contentPane.add(dni_txt);
				
				calle_lbl.setBounds(30, 5, 210, 23);
				contentPane.add(calle_lbl);
				calle_txt.setBounds(30, 50, 210, 23);
				contentPane.add(calle_txt);
				
				altura_lbl.setBounds(40, 5, 210, 23);
				contentPane.add(altura_lbl);
				altura_txt.setBounds(40, 50, 210, 23);
				contentPane.add(altura_txt);
				
				piso_lbl.setBounds(50, 5, 210, 23);
				contentPane.add(piso_lbl);
				piso_txt.setBounds(50, 50, 210, 23);
				contentPane.add(piso_txt);
				
				dpto_lbl.setBounds(60, 5, 210, 23);
				contentPane.add(dpto_lbl);
				dpto_txt.setBounds(60, 50, 210, 23);
				contentPane.add(dpto_txt);
				
				cp_lbl.setBounds(70, 5, 210, 23);
				contentPane.add(cp_lbl);
				cp_txt.setBounds(70, 50, 210, 23);
				contentPane.add(cp_txt);
				
				loca_lbl.setBounds(80, 5, 210, 23);
				contentPane.add(loca_lbl);
				loca_txt.setBounds(80, 50, 210, 23);
				contentPane.add(loca_txt);
				
				pcia_lbl.setBounds(90, 5, 210, 23);
				contentPane.add(pcia_lbl);
				pcia_txt.setBounds(90, 50, 210, 23);
				contentPane.add(pcia_txt);
				
				guardarUsuario_btn.setBounds(100, 5, 210, 23);
				contentPane.add(guardarUsuario_btn);
				
				mostrarCamposAltaUsuarioResi();
				
			}
		});
		btnCrearUsuarioResidencial.setBounds(107, 79, 210, 23);
		contentPane.add(btnCrearUsuarioResidencial);
		
		
		btnCrearUsuarioIndustrial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCrearUsuarioIndustrial.setBounds(107, 130, 210, 23);
		contentPane.add(btnCrearUsuarioIndustrial);
		
		
		btnConsultarConsumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnConsultarConsumo.setBounds(107, 182, 210, 23);
		contentPane.add(btnConsultarConsumo);
		
		//guarda alta usuario
		guardarUsuario_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom 		= nombre_txt.getText();
				int dni 		= Integer.valueOf(dni_txt.getText());
				String calle	= calle_txt.getText();
				int altura		= Integer.valueOf(altura_txt.getText());
				int piso		= Integer.valueOf(piso_txt.getText());
				String dpto		= dpto_txt.getText();
				int cp			= Integer.valueOf(cp_txt.getText());
				String loca		= loca_txt.getText();
				String pcia		= pcia_txt.getText();
				
				EmpresaElectrica empresa = new EmpresaElectrica();
				
				int salida = empresa.crearUsuarioResidencial(nom,dni,calle,altura,piso,dpto,cp,loca,pcia);
				salidaAltaUsuarioResi.setText(Integer.toString(salida));
			}
		});
		

	}
	
	public void mostrarCamposAltaUsuarioResi(){
		nombre_txt.setVisible(true);
		dni_txt.setVisible(true);
		calle_txt.setVisible(true);
		altura_txt.setVisible(true);
		piso_txt.setVisible(true);
		dpto_txt.setVisible(true);
		cp_txt.setVisible(true);
		loca_txt.setVisible(true);
		pcia_txt.setVisible(true);
		nombre_lbl.setVisible(true);
		dni_lbl.setVisible(true);
		calle_lbl.setVisible(true);
		altura_lbl.setVisible(true);
		piso_lbl.setVisible(true);
		dpto_lbl.setVisible(true);
		cp_lbl.setVisible(true);
		loca_lbl.setVisible(true);
		pcia_lbl.setVisible(true);
		salidaAltaUsuarioResi.setVisible(true);
	}
	
	public void ocultarCamposAltaUsuarioResi(){
		nombre_txt.setVisible(false);
		dni_txt.setVisible(false);
		calle_txt.setVisible(false);
		altura_txt.setVisible(false);
		piso_txt.setVisible(false);
		dpto_txt.setVisible(false);
		cp_txt.setVisible(false);
		loca_txt.setVisible(false);
		pcia_txt.setVisible(false);
		
		nombre_lbl.setVisible(false);
		dni_lbl.setVisible(false);
		calle_lbl.setVisible(false);
		altura_lbl.setVisible(false);
		piso_lbl.setVisible(false);
		dpto_lbl.setVisible(false);
		cp_lbl.setVisible(false);
		loca_lbl.setVisible(false);
		pcia_lbl.setVisible(false);
		salidaAltaUsuarioResi.setVisible(false);
	}
}
