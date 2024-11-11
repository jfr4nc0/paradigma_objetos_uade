package org.uade.view;

import org.uade.controller.UsuariosController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {
    private JTextField nombreTxt, dniTxt, razonSocialTxt, cuitTxt, iibbTxt, condicionFiscalTxt;
    private JTextField calleTxt, alturaTxt, pisoTxt, dptoTxt, cpTxt, locaTxt, pciaTxt;
    private JTextField nroUsuarioTxt, anioTxt, bimestreTxt;

    private JLabel nombreLbl, dniLbl, razonSocialLbl, cuitLbl, iibbLbl, condicionFiscalLbl;
    private JLabel calleLbl, alturaLbl, pisoLbl, dptoLbl, cpLbl, locaLbl, pciaLbl;
    private JLabel salidaLbl, nroUsuarioLbl, anioLbl, bimestreLbl;

    private JButton crearUsuarioResidencialBtn, crearUsuarioIndustrialBtn, consultarConsumoBtn;
    private JButton guardarUsuarioResidencialBtn, guardarUsuarioIndustrialBtn, buscarConsumoBtn;

    private static final long serialVersionUUID = 1L;
    private JPanel contentPane;

    public MenuPrincipal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        initializeComponents();

        initializeAltaUsuarioResidencialComponent();

        initializeAltaUsuarioIndustrialComponent();

        initializeConsultarConsumoComponent();

        JScrollPane scrollPane = new JScrollPane(contentPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        setContentPane(scrollPane);
    }

    private void initializeComponents() {
        nombreTxt 	= new JTextField();
        dniTxt  	= new JTextField();
        razonSocialTxt = new JTextField();
        cuitTxt     = new JTextField();
        iibbTxt     = new JTextField();
        condicionFiscalTxt = new JTextField();
        calleTxt 	= new JTextField();
        alturaTxt 	= new JTextField();
        pisoTxt 	= new JTextField();
        dptoTxt 	= new JTextField();
        cpTxt 		= new JTextField();
        locaTxt 	= new JTextField();
        pciaTxt 	= new JTextField();
        nroUsuarioTxt = new JTextField();
        anioTxt 	= new JTextField();
        bimestreTxt = new JTextField();

        nombreLbl   = new JLabel("Nombre: ");
        dniLbl      = new JLabel("Dni: ");
        razonSocialLbl = new JLabel("Razon Social: ");
        cuitLbl      = new JLabel("Cuit: ");
        iibbLbl      = new JLabel("Iibb: ");
        condicionFiscalLbl = new JLabel("Condicion Fiscal: ");
        calleLbl    = new JLabel("Calle: ");
        alturaLbl   = new JLabel("Altura: ");
        pisoLbl     = new JLabel("Piso: ");
        dptoLbl		= new JLabel("Dpto: ");
        cpLbl		= new JLabel("CP: ");
        locaLbl		= new JLabel("Localidad: ");
        pciaLbl		= new JLabel("Provincia: ");
        salidaLbl	= new JLabel("Salida: ");
        nroUsuarioLbl = new JLabel("NroUsuario: ");
        anioLbl = new JLabel("Año: ");
        bimestreLbl = new JLabel("Bimestre: ");

        guardarUsuarioResidencialBtn = new JButton("Guardar");
        guardarUsuarioIndustrialBtn = new JButton("Guardar");
        buscarConsumoBtn = new JButton("Consultar");

        crearUsuarioResidencialBtn =   new JButton("Crear Usuario Residencial");
        crearUsuarioIndustrialBtn =    new JButton("Crear Usuario Industrial");
        consultarConsumoBtn =       new JButton("Consultar Tarifa por Consumo");
    }

    private void initializeAltaUsuarioResidencialComponent() {
          crearUsuarioResidencialBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayResidencialUserForm(true);
            }
        });
        contentPane.add(crearUsuarioResidencialBtn);

        guardarUsuarioResidencialBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String nom = nombreTxt.getText();
                    Integer dni = Integer.parseInt(dniTxt.getText());
                    String calle = cuitTxt.getText();
                    Integer altura = Integer.parseInt(alturaTxt.getText());
                    Integer piso = Integer.parseInt(pisoTxt.getText());
                    String depto = dptoTxt.getText();
                    Integer codigoPostal = Integer.parseInt(cpTxt.getText());
                    String localidad = locaTxt.getText();
                    String provincia = pciaTxt.getText();

                    Integer nroUsuarioNuevo = UsuariosController.getInstance().crearUsuarioResidencial(nom, dni, calle, altura, piso, depto, codigoPostal, localidad, provincia);
                    salidaLbl.setText("NroUsuario creado: " + nroUsuarioNuevo.toString());
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void initializeAltaUsuarioIndustrialComponent() {
        crearUsuarioIndustrialBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayIndustrialUserForm(true);
            }
        });
        contentPane.add(crearUsuarioIndustrialBtn);

        guardarUsuarioIndustrialBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String razonSocial = razonSocialTxt.getText();
                    String cuit = cuitTxt.getText();
                    String iibb = iibbTxt.getText();
                    String condicionFiscal = condicionFiscalTxt.getText();
                    String calle = cuitTxt.getText();
                    Integer altura = Integer.parseInt(alturaTxt.getText());
                    Integer piso = Integer.parseInt(pisoTxt.getText());
                    String depto = dptoTxt.getText();
                    Integer codigoPostal = Integer.parseInt(cpTxt.getText());
                    String localidad = locaTxt.getText();
                    String provincia = pciaTxt.getText();

                    Integer nroUsuarioNuevo = UsuariosController.getInstance().crearUsuarioIndustrial(razonSocial, cuit, iibb, condicionFiscal, calle, altura, piso, depto, codigoPostal, localidad, provincia);
                    salidaLbl.setText("NroUsuario creado: " + nroUsuarioNuevo.toString());
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void initializeConsultarConsumoComponent() {
        consultarConsumoBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayConsultarConsumoFields();
            }
        });
        contentPane.add(consultarConsumoBtn);

        buscarConsumoBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer nroUsuario = Integer.parseInt(nroUsuarioTxt.getText());
                    Integer anio = Integer.parseInt(anioTxt.getText());
                    Integer bimestre = Integer.parseInt(bimestreTxt.getText());

                    Double montoTotal = UsuariosController.getInstance().calcularTarifaPorConsumo(nroUsuario, anio, bimestre);
                    salidaLbl.setText("montoTotal: " + montoTotal.toString());
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void displayConsultarConsumoFields() {
        hideAllForms();

        contentPane.add(nroUsuarioLbl);
        contentPane.add(nroUsuarioTxt);
        contentPane.add(anioLbl);
        contentPane.add(anioTxt);
        contentPane.add(bimestreLbl);
        contentPane.add(bimestreTxt);
        contentPane.add(salidaLbl);
        contentPane.add(buscarConsumoBtn);

        contentPane.revalidate();
        contentPane.repaint();
    }

    private void displayResidencialUserForm(boolean show) {
        hideAllForms();

        contentPane.add(nombreLbl);
        contentPane.add(nombreTxt);
        contentPane.add(dniLbl);
        contentPane.add(dniTxt);
        contentPane.add(calleLbl);
        contentPane.add(calleTxt);
        contentPane.add(alturaLbl);
        contentPane.add(alturaTxt);
        contentPane.add(pisoLbl);
        contentPane.add(pisoTxt);
        contentPane.add(dptoLbl);
        contentPane.add(dptoTxt);
        contentPane.add(cpLbl);
        contentPane.add(cpTxt);
        contentPane.add(locaLbl);
        contentPane.add(locaTxt);
        contentPane.add(pciaLbl);
        contentPane.add(pciaTxt);
        contentPane.add(salidaLbl);
        contentPane.add(guardarUsuarioResidencialBtn);

        contentPane.revalidate();
        contentPane.repaint();
    }

    private void displayIndustrialUserForm(boolean show) {
        hideAllForms();

        contentPane.add(razonSocialLbl);
        contentPane.add(razonSocialTxt);
        contentPane.add(cuitLbl);
        contentPane.add(cuitTxt);
        contentPane.add(iibbLbl);
        contentPane.add(iibbTxt);
        contentPane.add(condicionFiscalLbl);
        contentPane.add(condicionFiscalTxt);
        contentPane.add(calleLbl);
        contentPane.add(calleTxt);
        contentPane.add(alturaLbl);
        contentPane.add(alturaTxt);
        contentPane.add(pisoLbl);
        contentPane.add(pisoTxt);
        contentPane.add(dptoLbl);
        contentPane.add(dptoTxt);
        contentPane.add(cpLbl);
        contentPane.add(cpTxt);
        contentPane.add(locaLbl);
        contentPane.add(locaTxt);
        contentPane.add(pciaLbl);
        contentPane.add(pciaTxt);
        contentPane.add(salidaLbl);
        contentPane.add(guardarUsuarioIndustrialBtn);

        contentPane.revalidate();
        contentPane.repaint();
    }

    private void hideAllForms() {
        contentPane.removeAll();
        contentPane.add(crearUsuarioIndustrialBtn);
        contentPane.add(crearUsuarioResidencialBtn);
        contentPane.add(consultarConsumoBtn);
    }
}