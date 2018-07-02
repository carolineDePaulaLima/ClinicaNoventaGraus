/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import tools.CentroDoMonitorMaior;

public class GUIMenu extends JFrame {

    ImageIcon iconeLogo = new ImageIcon(getClass().getResource("/icones/logo.png"));
    JLabel logo = new JLabel(iconeLogo);

    public GUIMenu() {
        setTitle("Menu");
        Container cp = getContentPane();
        cp = getContentPane();
        cp.add(logo);
        // Cria uma barra de menu para o JFrame
        JMenuBar menuBar = new JMenuBar();

        // Adiciona a barra de menu ao  frame
        setJMenuBar(menuBar);

        // Define e adiciona dois menus drop down na barra de menus
        JMenu fileMenu = new JMenu("Nome1");
        JMenu fileMenu2 = new JMenu("Nome2");
        JMenu fileMenu3 = new JMenu("Nome3");
        menuBar.add(fileMenu);
        menuBar.add(fileMenu2);
        menuBar.add(fileMenu3);

        JMenuItem cliente = new JMenuItem("GUICliente");
        JMenuItem sexo = new JMenuItem("GUISexo");
        JMenuItem contato = new JMenuItem("GUIContato");
        JMenuItem tipoContato = new JMenuItem("GUITipoContato");
        JMenuItem horario = new JMenuItem("GUIHorario");
        JMenuItem especialidades = new JMenuItem("GUIEspecialidades");

        fileMenu.add(cliente);
        fileMenu.addSeparator();
        fileMenu.add(sexo);
        fileMenu.add(contato);
        fileMenu2.add(tipoContato);
        fileMenu3.add(horario);
        fileMenu3.add(especialidades);

        setVisible(true);

        contato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUIContato guiContato = new GUIContato();
            }
        });

        cliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUICliente guiCliente = new GUICliente();
            }
        });

        sexo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUISexo guiSexo = new GUISexo();
            }
        });

        tipoContato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUITipoContato tipoContato = new GUITipoContato();
            }
        });

        horario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUIHorario guiHorario = new GUIHorario();
            }
        });

        especialidades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIEspecialidades guiEspecialidades = new GUIEspecialidades();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        pack();
        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
    }
}
