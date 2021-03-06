package cliente;

import game.ConfiguracionSprites;
import gameobject.Direcciones;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SkinWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2508608251640220052L;
	private JPanel contentPane;
	private ConfigWindow paren;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {/*
				try {
					SkinWindow frame = new SkinWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
*/			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SkinWindow(ConfigWindow cw) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				paren.refrescarSkinsSeleccionadas();
				dispose();
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 550, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		paren = cw;
		ImageIcon iconNormal = new ImageIcon(ConfiguracionSprites.PACMAN_DEFAULT.getValor(Direcciones.DERECHA));
		ImageIcon iconLoco = new ImageIcon(ConfiguracionSprites.PACMAN_LOCO.getValor(Direcciones.DERECHA));
		ImageIcon iconMalvado = new ImageIcon(ConfiguracionSprites.PACMAN_MALVADO.getValor(Direcciones.DERECHA));
		ImageIcon iconBowWow = new ImageIcon(ConfiguracionSprites.PACMAN_BOWWOW.getValor(Direcciones.DERECHA));
		ImageIcon iconMelon = new ImageIcon(ConfiguracionSprites.PACMAN_MELON.getValor(Direcciones.DERECHA));
		ImageIcon iconYin = new ImageIcon(ConfiguracionSprites.PACMAN_YIN.getValor(Direcciones.DERECHA));
		ImageIcon iconBrasil = new ImageIcon(ConfiguracionSprites.PACMAN_BRASIL.getValor(Direcciones.DERECHA));
				
		JLabel lblPacMan = new JLabel("ELIJA UN MODELO");
		lblPacMan.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		GridBagConstraints gbc_lblPacMan = new GridBagConstraints();
		gbc_lblPacMan.gridwidth = 5;
		gbc_lblPacMan.insets = new Insets(0, 0, 5, 5);
		gbc_lblPacMan.gridx = 1;
		gbc_lblPacMan.gridy = 1;
		contentPane.add(lblPacMan, gbc_lblPacMan);
				
		// Label normal
		JLabel normal = new JLabel(" ");
		normal.setIcon(iconNormal);
		GridBagConstraints gbc_normal = new GridBagConstraints();
		gbc_normal.insets = new Insets(0, 0, 5, 5);
		gbc_normal.gridx = 0;
		gbc_normal.gridy = 2;
		contentPane.add(normal, gbc_normal);

		/// Label loco
		JLabel loco = new JLabel(" ");
		loco.setIcon(iconLoco);
		GridBagConstraints gbc_loco = new GridBagConstraints();
		gbc_loco.insets = new Insets(0, 0, 5, 5);
		gbc_loco.gridx = 2;
		gbc_loco.gridy = 2;
		contentPane.add(loco, gbc_loco);
		
		/// Label Malvado
		JLabel malvado = new JLabel(" ");
		malvado.setIcon(iconMalvado);
		GridBagConstraints gbc_malvado = new GridBagConstraints();
		gbc_malvado.insets = new Insets(0, 0, 5, 5);
		gbc_malvado.gridx = 4;
		gbc_malvado.gridy = 2;
		contentPane.add(malvado, gbc_malvado);

		/// Label Bow Wow
		JLabel bowwow = new JLabel(" ");
		bowwow.setIcon(iconBowWow);
		GridBagConstraints gbc_bowwow = new GridBagConstraints();
		gbc_bowwow.insets = new Insets(0, 0, 5, 5);
		gbc_bowwow.gridx = 6;
		gbc_bowwow.gridy = 2;
		contentPane.add(bowwow, gbc_bowwow);
				
		/// Boton normal
		JButton btnNormal = new JButton("Normal");
		btnNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paren.setSkinPacman(ConfiguracionSprites.PACMAN_DEFAULT);
				paren.setSkinFantasma(ConfiguracionSprites.FANTASMA_DEFAULT);
			}
		});
		GridBagConstraints gbc_btnNormal = new GridBagConstraints();
		gbc_btnNormal.insets = new Insets(0, 0, 5, 5);
		gbc_btnNormal.gridx = 0;
		gbc_btnNormal.gridy = 3;
		contentPane.add(btnNormal, gbc_btnNormal);
		
		/// Boton loco
		JButton btnLoco = new JButton("Loco");
		btnLoco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paren.setSkinPacman(ConfiguracionSprites.PACMAN_LOCO);
				paren.setSkinFantasma(ConfiguracionSprites.FANTASMA_LOCO);
			}
		});
		GridBagConstraints gbc_btnLoco = new GridBagConstraints();
		gbc_btnLoco.insets = new Insets(0, 0, 5, 5);
		gbc_btnLoco.gridx = 2;
		gbc_btnLoco.gridy = 3;
		contentPane.add(btnLoco, gbc_btnLoco);
					
		/// Boton Malvado
		JButton btnMalvado = new JButton("Malvado");
		btnMalvado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paren.setSkinPacman(ConfiguracionSprites.PACMAN_MALVADO);
				paren.setSkinFantasma(ConfiguracionSprites.FANTASMA_MALVADO);
			}
		});
		GridBagConstraints gbc_btnMalvado = new GridBagConstraints();
		gbc_btnMalvado.insets = new Insets(0, 0, 5, 5);
		gbc_btnMalvado.gridx = 4;
		gbc_btnMalvado.gridy = 3;
		contentPane.add(btnMalvado, gbc_btnMalvado);
			
		/// Boton Bow wow
		JButton btnBowWow = new JButton("Bow wow");
		btnBowWow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paren.setSkinPacman(ConfiguracionSprites.PACMAN_BOWWOW);
				paren.setSkinFantasma(ConfiguracionSprites.FANTASMA_BOWWOW);
			}
		});
		GridBagConstraints gbc_btnBowWow = new GridBagConstraints();
		gbc_btnBowWow.insets = new Insets(0, 0, 5, 5);
		gbc_btnBowWow.gridx = 6;
		gbc_btnBowWow.gridy = 3;
		contentPane.add(btnBowWow, gbc_btnBowWow);

		/// label Melon
		JLabel melon = new JLabel(" ");
		GridBagConstraints gbc_melon = new GridBagConstraints();
		melon.setIcon(iconMelon);
		gbc_melon.insets = new Insets(0, 0, 5, 5);
		gbc_melon.gridx = 0;
		gbc_melon.gridy = 8;
		contentPane.add(melon, gbc_melon);

		/// Label Yin
		JLabel yin = new JLabel(" ");
		yin.setIcon(iconYin);
		GridBagConstraints gbc_yin = new GridBagConstraints();
		gbc_yin.insets = new Insets(0, 0, 5, 5);
		gbc_yin.gridx = 2;
		gbc_yin.gridy = 8;
		contentPane.add(yin, gbc_yin);

		/// Label Brasil
		JLabel brasil = new JLabel(" ");
		brasil.setIcon(iconBrasil);
		GridBagConstraints gbc_brasil = new GridBagConstraints();
		gbc_brasil.insets = new Insets(0, 0, 5, 5);
		gbc_brasil.gridx = 4;
		gbc_brasil.gridy = 8;
		contentPane.add(brasil, gbc_brasil);

		/// Boton Sandia
		JButton btnMelon  = new JButton("Sandia");
		btnMelon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paren.setSkinPacman(ConfiguracionSprites.PACMAN_MELON);
				paren.setSkinFantasma(ConfiguracionSprites.FANTASMA_MELON);
			}
		});
		GridBagConstraints gbc_btnMelon = new GridBagConstraints();
		gbc_btnMelon.insets = new Insets(0, 0, 5, 5);
		gbc_btnMelon.gridx = 0;
		gbc_btnMelon.gridy = 9;
		contentPane.add(btnMelon, gbc_btnMelon);

		/// Boton Yin
		JButton btnYin = new JButton("Yin Yang");
		btnYin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paren.setSkinPacman(ConfiguracionSprites.PACMAN_YIN);
				paren.setSkinFantasma(ConfiguracionSprites.FANTASMA_YIN);
			}
		});
		GridBagConstraints gbc_btnYin = new GridBagConstraints();
		gbc_btnYin.insets = new Insets(0, 0, 5, 5);
		gbc_btnYin.gridx = 2;
		gbc_btnYin.gridy = 9;
		contentPane.add(btnYin, gbc_btnYin);
		
		/// Boton Brasil
		JButton btnBrasil = new JButton("Brasil");
		btnBrasil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paren.setSkinPacman(ConfiguracionSprites.PACMAN_BRASIL);
				paren.setSkinFantasma(ConfiguracionSprites.FANTASMA_BRASIL);
			}
		});
		GridBagConstraints gbc_btnBrasil = new GridBagConstraints();
		gbc_btnBrasil.insets = new Insets(0, 0, 5, 5);
		gbc_btnBrasil.gridx = 4;
		gbc_btnBrasil.gridy = 9;
		contentPane.add(btnBrasil, gbc_btnBrasil);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paren.refrescarSkinsSeleccionadas();
				dispose();
			}
		});
		GridBagConstraints gbc_btnRegresar = new GridBagConstraints();
		gbc_btnRegresar.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegresar.gridx = 6;
		gbc_btnRegresar.gridy = 10;
		contentPane.add(btnRegresar, gbc_btnRegresar);
	}

}
