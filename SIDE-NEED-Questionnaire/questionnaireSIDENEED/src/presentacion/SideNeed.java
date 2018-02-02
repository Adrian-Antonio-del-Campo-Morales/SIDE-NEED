package presentacion;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Desktop;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JCheckBox;
import CLIPSJNI.*;

public class SideNeed {
	private List<String> facts = new ArrayList<String>();
	private String language = "Spanish";
	private int page = 1;
	private String quest1 = "<html>	Does the child experience difficulty concentrating and is distracted by external stimulus?	</html>";
	private String quest2 = "<html>	Does it seem that the child does not listen when speaking directly to him?	</html>";
	private String quest3 = "<html>	Does the child have organisation problems?	</html>";
	private String quest4 = "<html>	Does the child show difficulty performing tasks that involve a sustained mental effort?	</html>";
	private String quest5 = "<html>	Does the child often lose necessary things to perform their tasks?	</html>";
	private String quest6 = "<html>	Does the child have problems remembering things or assignments immediately after being ordered to do them?	</html>";
	private String quest7 = "<html>	Does the child acquire and retain information quicker than their classmates?	</html>";
	private String quest8 = "<html>	Does the child give unusual solutions and provide different alternatives showing great creativity and imagination?	</html>";
	private String quest9 = "<html>	Does the child forget daily activities?	</html>";
	private String quest10 = "<html>	Does the child often get up in situations when they must remain seated?	</html>";
	private String quest11 = "<html>	Does the child run or climb when it is not appropriate?	</html>";
	private String quest12 = "<html>	Does the child talk excessively when they have a conversation?	</html>";
	private String quest13 = "<html>	Does the child use other people´s things without permission?	</html>";
	private String quest14 = "<html>	Does the child use games persistently and obsessively?	</html>";
	private String quest15 = "<html>	Does the child have a lack of awareness of sensations related to hygiene?	</html>";
	private String quest16 = "<html>	Does the child have difficulties to play calmly with other children?	</html>";
	private String quest17 = "<html>	Does the child have a difficulty to follow speech and conversation rules?	</html>";
	private String quest18 = "<html>	Does the child show difficulties in carrying out daily activities related to self-care?	</html>";
	private String quest19 = "<html>	Does he wander for no apparent reason?	</html>";
	private String quest20 = "<html>	Is the imaginative play absent?	</html>";
	private String quest21 = "<html>	Does the child show self-injurious behaviour?	</html>";
	private String quest22 = "<html>	Does the child have few and repetitive elements of distraction?	</html>";
	private String quest23 = "<html>	Does the child show motor stereotypes?	</html>";
	private String quest24 = "<html>	Does the child manifest a difficulty in dealing with changes?	</html>";
	private String quest25 = "<html>	Does the child feel discomfort after standing still for a long time?	</html>";
	private String quest26 = "<html>	Does the child show anomalies in the eye contact or is there no tracking of objects with the eye?	</html>";
	private String quest27 = "<html>	Does the child become disoriented frequently?	</html>";
	private String quest28 = "<html>	Does the child complain about itchy eyes or cry often?	</html>";
	private String quest29 = "<html>	When speaking in front of him, does they turn their head directing their ear towards the interlocutor?	</html>";
	private String quest30 = "<html>	Is the child very close to school materials and other objects to see them?	</html>";
	private String quest31 = "<html>	Is there an excess of flicker?	</html>";
	private String quest32 = "<html>	Does the child show reactions to light sources, appreciating facial changes or absence of winking eyes?	</html>";
	private String quest33 = "<html>	Does the child show intolerance to specific noises, smells or flavours?	</html>";
	private String quest34 = "<html>	Is it perceived an unusual interest for sensorial stimuli of the environment?	</html>";
	private String quest35 = "<html>	Is there a low response to call and sound stimuli? 	</html>";
	private String quest36 = "<html>	Does the child show difficulties in sharing interests or games with other kids?	</html>";
	private String quest37 = "<html>	Does the child have difficulties in establishing social relationships?	</html>";
	private String quest38 = "<html>	Does the child show difficulties in carrying out simple mathematical operations and simple calculations?	</html>";
	private String quest39 = "<html>	Does the child use a reduced range of words in comparison with their classmates?	</html>";
	private String quest40 = "<html>	Is there a language delay perceived in the child?	</html>";
	private String quest41 = "<html>	Does the child show a limited grammatical structure or a disorganised speech?	</html>";
	private String quest42 = "<html>	Are there alterations in the intonation when speaking?	</html>";
	private String quest43 = "<html>	Does the child have problems to understand the implicit language?	</html>";
	private String quest44 = "<html>	Does the child have a vast vocabulary or lot information about complex topics?	</html>";
	private String quest45 = "<html>	Does the child have problems in the acquisition and use of reading and writing?	</html>";
	private String quest46 = "<html>	Does the child have problems in the articulation of phonemes?	</html>";
	private String quest47 = "<html>	Does the child exhibit problems in the speech rhythm with or without stutter?	</html>";
	private String quest48 = "<html>	Does the child repeat words without sense?	</html>";
	private String quest49 = "<html>	Does the child show anomalies in the understanding and use of gestures?	</html>";
	private String quest50 = "<html>	Does the child exhibit problems in carrying out activities that involve oculo-manual coordination?	</html>";
	private String quest51 = "<html>	Can the child manipulate or dismantle mechanical objects of higher difficulty than corresponds to their age?	</html>";
	private String quest52 = "<html>	Is there slowness or vagueness in the performance of motor activities?	</html>";

	private JFrame frame;

	private final JButton btnSuggest = new JButton("Suggest Diagnosis");
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnFile = new JMenu("File");
	private final JMenu mnDM = new JMenu("Trees");
	private final JMenu mnHelp = new JMenu("Help");
	private final JMenuItem mntmSave = new JMenuItem("Save");
	private final JMenuItem mntmExit = new JMenuItem("Exit");
	private final JMenuItem mntmshallowADHDADP = new JMenuItem("ADHD Attention Deficit Predominance");
	private final JMenuItem mntmshallowADHDHP = new JMenuItem("ADHD with Hyperactivity Predominance ");
	private final JMenuItem mntmshallowCombinedADHD = new JMenuItem("ADHD Combined");
	private final JMenuItem mntmshallowLSD = new JMenuItem("Learning Specific Disorder");
	private final JMenuItem mntmshallowSCD = new JMenuItem("Social Communication Disorder");
	private final JMenuItem mntmSpanish = new JMenuItem("Spanish");
	private final JMenuItem mntmEnglish = new JMenuItem("English");
	private final JMenuItem mntmAbout = new JMenuItem("About ...");
	private final JButton btnNext = new JButton("  Next  ");
	private final JLabel lblPage = new JLabel("Page " + page + "/4");
	private final JLabel lblYesNo = new JLabel("YES / NO");
	private final JMenuItem mntmLoad = new JMenuItem("Load");
	private final JButton btnPrevious = new JButton("Previous");
	private final JPanel pnlQuestionnaire = new JPanel();
	private final JLabel lbl1 = new JLabel(quest1);
	private final JLabel lbl2 = new JLabel(quest2);
	private final JLabel lbl3 = new JLabel(quest3);
	private final JLabel lbl4 = new JLabel(quest4);
	private final JLabel lbl5 = new JLabel(quest5);
	private final JLabel lbl6 = new JLabel(quest6);
	private final JLabel lbl7 = new JLabel(quest7);
	private final JLabel lbl8 = new JLabel(quest8);
	private final JLabel lbl9 = new JLabel(quest9);
	private final JLabel lbl10 = new JLabel(quest10);
	private final JLabel lbl11 = new JLabel(quest11);
	private final JLabel lbl12 = new JLabel(quest12);
	private final JLabel lbl13 = new JLabel(quest13);
	private final JCheckBox chckbx1 = new JCheckBox();
	private final JCheckBox chckbx2 = new JCheckBox();
	private final JCheckBox chckbx3 = new JCheckBox();
	private final JCheckBox chckbx4 = new JCheckBox();
	private final JCheckBox chckbx5 = new JCheckBox();
	private final JCheckBox chckbx6 = new JCheckBox();
	private final JCheckBox chckbx7 = new JCheckBox();
	private final JCheckBox chckbx8 = new JCheckBox();
	private final JCheckBox chckbx9 = new JCheckBox();
	private final JCheckBox chckbx10 = new JCheckBox();
	private final JCheckBox chckbx11 = new JCheckBox();
	private final JCheckBox chckbx12 = new JCheckBox();
	private final JCheckBox chckbx13 = new JCheckBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SideNeed window = new SideNeed();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SideNeed() {
		initialize();
		selectLanguage(language);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new FrameWindowListener());
		frame.setBounds(100, 100, 628, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
			pnlQuestionnaire.setBorder(
					new TitledBorder(null, "Questionnaire", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			frame.getContentPane().add(pnlQuestionnaire, BorderLayout.CENTER);
		}
		GridBagLayout gbl_pnlQuestionnaire = new GridBagLayout();
		gbl_pnlQuestionnaire.columnWidths = new int[] { 85, 100, 3, 10, 0, 0 };
		gbl_pnlQuestionnaire.rowHeights = new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0 };
		gbl_pnlQuestionnaire.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_pnlQuestionnaire.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
				1.0, 1.0, 0.0, Double.MIN_VALUE };
		pnlQuestionnaire.setLayout(gbl_pnlQuestionnaire);
		{
			GridBagConstraints gbc_btnSuggest = new GridBagConstraints();
			gbc_btnSuggest.insets = new Insets(0, 0, 0, 5);
			gbc_btnSuggest.anchor = GridBagConstraints.SOUTH;
			gbc_btnSuggest.gridx = 3;
			gbc_btnSuggest.gridy = 14;
			btnSuggest.setEnabled(false);
			btnSuggest.addActionListener(new BtnSuggestActionListener());
			{
				GridBagConstraints gbc_lblYesNo = new GridBagConstraints();
				gbc_lblYesNo.insets = new Insets(0, 0, 5, 5);
				gbc_lblYesNo.gridx = 3;
				gbc_lblYesNo.gridy = 0;
				pnlQuestionnaire.add(lblYesNo, gbc_lblYesNo);
			}
			{
				GridBagConstraints gbc_lbl1 = new GridBagConstraints();
				gbc_lbl1.gridwidth = 2;
				gbc_lbl1.fill = GridBagConstraints.HORIZONTAL;
				gbc_lbl1.insets = new Insets(0, 0, 5, 5);
				gbc_lbl1.gridx = 1;
				gbc_lbl1.gridy = 1;
				pnlQuestionnaire.add(lbl1, gbc_lbl1);
			}
			{
				GridBagConstraints gbc_chckbx1 = new GridBagConstraints();
				gbc_chckbx1.insets = new Insets(0, 0, 5, 5);
				gbc_chckbx1.gridx = 3;
				gbc_chckbx1.gridy = 1;
				pnlQuestionnaire.add(chckbx1, gbc_chckbx1);
			}
			{
				GridBagConstraints gbc_lbl2 = new GridBagConstraints();
				gbc_lbl2.gridwidth = 2;
				gbc_lbl2.fill = GridBagConstraints.HORIZONTAL;
				gbc_lbl2.insets = new Insets(0, 0, 5, 5);
				gbc_lbl2.gridx = 1;
				gbc_lbl2.gridy = 2;
				pnlQuestionnaire.add(lbl2, gbc_lbl2);
			}
			{
				GridBagConstraints gbc_chckbx2 = new GridBagConstraints();
				gbc_chckbx2.insets = new Insets(0, 0, 5, 5);
				gbc_chckbx2.gridx = 3;
				gbc_chckbx2.gridy = 2;
				pnlQuestionnaire.add(chckbx2, gbc_chckbx2);
			}
			{
				GridBagConstraints gbc_lbl3 = new GridBagConstraints();
				gbc_lbl3.gridwidth = 2;
				gbc_lbl3.fill = GridBagConstraints.HORIZONTAL;
				gbc_lbl3.insets = new Insets(0, 0, 5, 5);
				gbc_lbl3.gridx = 1;
				gbc_lbl3.gridy = 3;
				pnlQuestionnaire.add(lbl3, gbc_lbl3);
			}
			{
				GridBagConstraints gbc_chckbx3 = new GridBagConstraints();
				gbc_chckbx3.insets = new Insets(0, 0, 5, 5);
				gbc_chckbx3.gridx = 3;
				gbc_chckbx3.gridy = 3;
				pnlQuestionnaire.add(chckbx3, gbc_chckbx3);
			}
			{
				GridBagConstraints gbc_lbl4 = new GridBagConstraints();
				gbc_lbl4.gridwidth = 2;
				gbc_lbl4.fill = GridBagConstraints.HORIZONTAL;
				gbc_lbl4.insets = new Insets(0, 0, 5, 5);
				gbc_lbl4.gridx = 1;
				gbc_lbl4.gridy = 4;
				pnlQuestionnaire.add(lbl4, gbc_lbl4);
			}
			{
				GridBagConstraints gbc_chckbx4 = new GridBagConstraints();
				gbc_chckbx4.insets = new Insets(0, 0, 5, 5);
				gbc_chckbx4.gridx = 3;
				gbc_chckbx4.gridy = 4;
				pnlQuestionnaire.add(chckbx4, gbc_chckbx4);
			}
			{
				GridBagConstraints gbc_lbl5 = new GridBagConstraints();
				gbc_lbl5.gridwidth = 2;
				gbc_lbl5.fill = GridBagConstraints.HORIZONTAL;
				gbc_lbl5.insets = new Insets(0, 0, 5, 5);
				gbc_lbl5.gridx = 1;
				gbc_lbl5.gridy = 5;
				pnlQuestionnaire.add(lbl5, gbc_lbl5);
			}
			{
				GridBagConstraints gbc_chckbx5 = new GridBagConstraints();
				gbc_chckbx5.insets = new Insets(0, 0, 5, 5);
				gbc_chckbx5.gridx = 3;
				gbc_chckbx5.gridy = 5;
				pnlQuestionnaire.add(chckbx5, gbc_chckbx5);
			}
			{
				GridBagConstraints gbc_lbl6 = new GridBagConstraints();
				gbc_lbl6.gridwidth = 2;
				gbc_lbl6.fill = GridBagConstraints.HORIZONTAL;
				gbc_lbl6.insets = new Insets(0, 0, 5, 5);
				gbc_lbl6.gridx = 1;
				gbc_lbl6.gridy = 6;
				pnlQuestionnaire.add(lbl6, gbc_lbl6);
			}
			{
				GridBagConstraints gbc_chckbx6 = new GridBagConstraints();
				gbc_chckbx6.insets = new Insets(0, 0, 5, 5);
				gbc_chckbx6.gridx = 3;
				gbc_chckbx6.gridy = 6;
				pnlQuestionnaire.add(chckbx6, gbc_chckbx6);
			}
			{
				GridBagConstraints gbc_lbl7 = new GridBagConstraints();
				gbc_lbl7.gridwidth = 2;
				gbc_lbl7.fill = GridBagConstraints.HORIZONTAL;
				gbc_lbl7.insets = new Insets(0, 0, 5, 5);
				gbc_lbl7.gridx = 1;
				gbc_lbl7.gridy = 7;
				pnlQuestionnaire.add(lbl7, gbc_lbl7);
			}
			{
				GridBagConstraints gbc_chckbx7 = new GridBagConstraints();
				gbc_chckbx7.insets = new Insets(0, 0, 5, 5);
				gbc_chckbx7.gridx = 3;
				gbc_chckbx7.gridy = 7;
				pnlQuestionnaire.add(chckbx7, gbc_chckbx7);
			}
			{
				GridBagConstraints gbc_lbl8 = new GridBagConstraints();
				gbc_lbl8.gridwidth = 2;
				gbc_lbl8.fill = GridBagConstraints.HORIZONTAL;
				gbc_lbl8.insets = new Insets(0, 0, 5, 5);
				gbc_lbl8.gridx = 1;
				gbc_lbl8.gridy = 8;
				pnlQuestionnaire.add(lbl8, gbc_lbl8);
			}
			{
				GridBagConstraints gbc_chckbx8 = new GridBagConstraints();
				gbc_chckbx8.insets = new Insets(0, 0, 5, 5);
				gbc_chckbx8.gridx = 3;
				gbc_chckbx8.gridy = 8;
				pnlQuestionnaire.add(chckbx8, gbc_chckbx8);
			}
			{
				GridBagConstraints gbc_lbl9 = new GridBagConstraints();
				gbc_lbl9.gridwidth = 2;
				gbc_lbl9.fill = GridBagConstraints.HORIZONTAL;
				gbc_lbl9.insets = new Insets(0, 0, 5, 5);
				gbc_lbl9.gridx = 1;
				gbc_lbl9.gridy = 9;
				pnlQuestionnaire.add(lbl9, gbc_lbl9);
			}
			{
				GridBagConstraints gbc_chckbx9 = new GridBagConstraints();
				gbc_chckbx9.insets = new Insets(0, 0, 5, 5);
				gbc_chckbx9.gridx = 3;
				gbc_chckbx9.gridy = 9;
				pnlQuestionnaire.add(chckbx9, gbc_chckbx9);
			}
			{
				GridBagConstraints gbc_lbl10 = new GridBagConstraints();
				gbc_lbl10.gridwidth = 2;
				gbc_lbl10.fill = GridBagConstraints.HORIZONTAL;
				gbc_lbl10.insets = new Insets(0, 0, 5, 5);
				gbc_lbl10.gridx = 1;
				gbc_lbl10.gridy = 10;
				pnlQuestionnaire.add(lbl10, gbc_lbl10);
			}
			{
				GridBagConstraints gbc_chckbx10 = new GridBagConstraints();
				gbc_chckbx10.insets = new Insets(0, 0, 5, 5);
				gbc_chckbx10.gridx = 3;
				gbc_chckbx10.gridy = 10;
				pnlQuestionnaire.add(chckbx10, gbc_chckbx10);
			}
			{
				GridBagConstraints gbc_lbl11 = new GridBagConstraints();
				gbc_lbl11.gridwidth = 2;
				gbc_lbl11.fill = GridBagConstraints.HORIZONTAL;
				gbc_lbl11.insets = new Insets(0, 0, 5, 5);
				gbc_lbl11.gridx = 1;
				gbc_lbl11.gridy = 11;
				pnlQuestionnaire.add(lbl11, gbc_lbl11);
			}
			{
				GridBagConstraints gbc_chckbx11 = new GridBagConstraints();
				gbc_chckbx11.insets = new Insets(0, 0, 5, 5);
				gbc_chckbx11.gridx = 3;
				gbc_chckbx11.gridy = 11;
				pnlQuestionnaire.add(chckbx11, gbc_chckbx11);
			}
			{
				GridBagConstraints gbc_lbl12 = new GridBagConstraints();
				gbc_lbl12.gridwidth = 2;
				gbc_lbl12.fill = GridBagConstraints.HORIZONTAL;
				gbc_lbl12.insets = new Insets(0, 0, 5, 5);
				gbc_lbl12.gridx = 1;
				gbc_lbl12.gridy = 12;
				pnlQuestionnaire.add(lbl12, gbc_lbl12);
			}
			{
				GridBagConstraints gbc_chckbx12 = new GridBagConstraints();
				gbc_chckbx12.insets = new Insets(0, 0, 5, 5);
				gbc_chckbx12.gridx = 3;
				gbc_chckbx12.gridy = 12;
				pnlQuestionnaire.add(chckbx12, gbc_chckbx12);
			}
			{
				GridBagConstraints gbc_lbl13 = new GridBagConstraints();
				gbc_lbl13.gridwidth = 2;
				gbc_lbl13.fill = GridBagConstraints.HORIZONTAL;
				gbc_lbl13.insets = new Insets(0, 0, 5, 5);
				gbc_lbl13.gridx = 1;
				gbc_lbl13.gridy = 13;
				pnlQuestionnaire.add(lbl13, gbc_lbl13);
			}
			{
				GridBagConstraints gbc_chckbx13 = new GridBagConstraints();
				gbc_chckbx13.insets = new Insets(0, 0, 5, 5);
				gbc_chckbx13.gridx = 3;
				gbc_chckbx13.gridy = 13;
				pnlQuestionnaire.add(chckbx13, gbc_chckbx13);
			}
			{
				GridBagConstraints gbc_btnNext = new GridBagConstraints();
				gbc_btnNext.anchor = GridBagConstraints.WEST;
				gbc_btnNext.insets = new Insets(0, 0, 0, 5);
				gbc_btnNext.gridx = 1;
				gbc_btnNext.gridy = 14;
				btnNext.addActionListener(new BtnNextActionListener());
				{
					GridBagConstraints gbc_btnPrevious = new GridBagConstraints();
					gbc_btnPrevious.insets = new Insets(0, 0, 0, 5);
					gbc_btnPrevious.gridx = 0;
					gbc_btnPrevious.gridy = 14;
					btnPrevious.addActionListener(new BtnPreviousActionListener());
					pnlQuestionnaire.add(btnPrevious, gbc_btnPrevious);
				}

				pnlQuestionnaire.add(btnNext, gbc_btnNext);
			}
			{
				GridBagConstraints gbc_lblPagina = new GridBagConstraints();
				gbc_lblPagina.insets = new Insets(0, 0, 0, 5);
				gbc_lblPagina.gridx = 2;
				gbc_lblPagina.gridy = 14;
				pnlQuestionnaire.add(lblPage, gbc_lblPagina);
			}
			btnSuggest.setIcon(new ImageIcon(SideNeed.class.getResource("/presentacion/cargarComentarios.png")));
			pnlQuestionnaire.add(btnSuggest, gbc_btnSuggest);
		}
		{
			frame.setJMenuBar(menuBar);
		}
		{
			mnFile.setMnemonic('A');
			menuBar.add(mnFile);
		}
		{
			mntmSave.addActionListener(new BtnSaveActionListener());
			mntmSave.setIcon(new ImageIcon(SideNeed.class.getResource("/presentacion/guardar.png")));
			mnFile.add(mntmSave);
		}
		{
			mntmLoad.addActionListener(new BtnLoadActionListener());
			mntmLoad.setIcon(new ImageIcon(SideNeed.class.getResource("/presentacion/abrir.png")));
			mnFile.add(mntmLoad);
		}
		{
			mntmExit.addActionListener(new ExitActionListener());
			{
				mntmLoad.setIcon(new ImageIcon(SideNeed.class.getResource("/presentacion/abrir.png")));
				mnFile.add(mntmLoad);
			}
			mntmExit.setIcon(new ImageIcon(SideNeed.class.getResource("/presentacion/cross.png")));
			mnFile.add(mntmExit);
		}
		{
			mnDM.setMnemonic('E');
			menuBar.add(mnDM);
		}
		{
			mntmshallowADHDADP.addActionListener(new BtnshallowADHDADPActionListener());
			mnDM.add(mntmshallowADHDADP);
		}
		{
			mntmshallowADHDHP.addActionListener(new BtnshallowADHDHPActionListener());
			mnDM.add(mntmshallowADHDHP);
		}
		{
			mntmshallowCombinedADHD.addActionListener(new BtnshallowCombinedADHDActionListener());
			mnDM.add(mntmshallowCombinedADHD);
		}
		{
			mntmshallowLSD.addActionListener(new BtnshallowLSDActionListener());
			mnDM.add(mntmshallowLSD);
		}
		{
			mntmshallowSCD.addActionListener(new BtnshallowSCDActionListener());
			mnDM.add(mntmshallowSCD);
		}
		{
			mnHelp.setMnemonic('y');
			menuBar.add(mnHelp);
		}
		{
			mntmSpanish.addActionListener(new BtnSetSpanishLanguageActionListener());
			mnHelp.add(mntmSpanish);
		}
		{
			mntmEnglish.addActionListener(new BtnSetEnglishLanguageActionListener());
			mnHelp.add(mntmEnglish);
		}
		{
			mntmAbout.addActionListener(new AboutActionListener());
			mnHelp.add(mntmAbout);
		}

		btnPrevious.setEnabled(false);

	}

	private class FrameWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent arg0) {

			if (language.equals("English")) {
				JOptionPane.showMessageDialog(frame, "Thanks for using our system", "Close application",
						JOptionPane.PLAIN_MESSAGE);
			}

			if (language.equals("Spanish")) {
				JOptionPane.showMessageDialog(frame, "Gracias por utilizar nuestro sistema", "Cerrar aplicacion",
						JOptionPane.PLAIN_MESSAGE);
			}

		}
	}

	private class BtnSuggestActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setFacts();
			clips();

		}
	}

	private class BtnLoadActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			JFileChooser selecFile = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("CLP", "clp");
			selecFile.setFileFilter(filter);
			int returnValue = selecFile.showOpenDialog(frame);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				try {
					File file = selecFile.getSelectedFile();
					BufferedReader br = new BufferedReader(new FileReader(file));
					facts.clear();

					String line;
					while ((line = br.readLine()) != null) {
						if (!line.equals("(deffacts facts") && !line.equals(")")) {
							System.out.println(line);
							facts.add(line);
						}
					}
					br.close();
					btnSuggest.setEnabled(true);

					JOptionPane.showMessageDialog(frame, "File Loaded", "File Loaded", JOptionPane.PLAIN_MESSAGE);
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(frame, "Error while loading file", "Error while loading file",
							JOptionPane.ERROR_MESSAGE);
					exc.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(frame, "The user canceled the action", "Canceled",
						JOptionPane.PLAIN_MESSAGE);
			}

			setChecked();
		}

	}

	private class BtnSaveActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setFacts();

			Set<String> hs = new HashSet<>();
			hs.addAll(facts);
			facts.clear();
			facts.addAll(hs);

			JFileChooser selecFile = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("CLP", "clp");
			selecFile.setFileFilter(filter);
			int returnValue = selecFile.showSaveDialog(frame);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File file = selecFile.getSelectedFile();
				try {
					FileWriter fileWriter = new FileWriter(file + ".clp");
					PrintWriter pw = new PrintWriter(fileWriter);
					pw.println("(deffacts hechos");

					for (String fact : facts) {
						pw.println(fact);
					}

					pw.println(")");
					fileWriter.close();
					JOptionPane.showMessageDialog(frame, "File Saved", "File Saved", JOptionPane.PLAIN_MESSAGE);
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(frame, "Error while saving file", "Error while saving file",
							JOptionPane.ERROR_MESSAGE);
					exc.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(frame, "The user canceled the action", "Canceled",
						JOptionPane.PLAIN_MESSAGE);
			}
		}
	}

	private class BtnshallowADHDADPActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			File file = getResourceAsFile("resources/shallowADHDADP.pdf", ".pdf");
			try {
				Desktop.getDesktop().browse(file.toURI());
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
	}

	private class BtnshallowADHDHPActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			File file = getResourceAsFile("resources/shallowADHDHP.pdf", ".pdf");
			try {
				Desktop.getDesktop().browse(file.toURI());
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
	}

	private class BtnshallowCombinedADHDActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			File file = getResourceAsFile("resources/shallowCombinedADHD.pdf", ".pdf");
			try {
				Desktop.getDesktop().browse(file.toURI());
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
	}

	private class BtnshallowLSDActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			File file = getResourceAsFile("resources/shallowLSD.pdf", ".pdf");
			try {
				Desktop.getDesktop().browse(file.toURI());
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
	}

	private class BtnshallowSCDActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			File file = getResourceAsFile("resources/shallowSCD.pdf", ".pdf");
			try {
				Desktop.getDesktop().browse(file.toURI());
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
	}

	private class BtnNextActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (page < 4) {
				setFacts();

				if (page == 3) {
					btnSuggest.setEnabled(true);
					btnNext.setEnabled(false);
				}

				page = page + 1;
				setQuestions();
				setChecked();

				if (language.equals("English")) {
					lblPage.setText("Page " + page + "/4");

				}
				if (language.equals("Spanish")) {
					lblPage.setText("Pagina " + page + "/4");
				}
				btnPrevious.setEnabled(true);

			}
			Set<String> hs = new HashSet<>();
			hs.addAll(facts);
			facts.clear();
			facts.addAll(hs);
		}
	}

	private class BtnPreviousActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (page > 1) {
				setFacts();

				page = page - 1;
				setQuestions();
				setChecked();

				if (language.equals("English")) {
					lblPage.setText("Page " + page + "/4");

				}
				if (language.equals("Spanish")) {
					lblPage.setText("Pagina " + page + "/4");
				}
				btnNext.setEnabled(true);
				if (page == 1) {
					btnPrevious.setEnabled(false);
				}

			}
			Set<String> hs = new HashSet<>();
			hs.addAll(facts);
			facts.clear();
			facts.addAll(hs);
		}
	}

	private class AboutActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(frame,
					"This prototype was developed as a part of the SIDE NEED project.\nAuthor: Adrian del Campo Morales.\nContact: Adrian.Campo@alu.uclm.es",
					"About", JOptionPane.PLAIN_MESSAGE);
		}
	}

	private class BtnSetSpanishLanguageActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			selectLanguage("Spanish");
		}
	}

	private class BtnSetEnglishLanguageActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			selectLanguage("English");
		}
	}

	private class ExitActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	private void selectLanguage(String selectedLang) {
		if (selectedLang.equals("English")) {

			// ELEMENTS
			pnlQuestionnaire.setBorder(
					new TitledBorder(null, "Questionnaire", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			frame.getContentPane().add(pnlQuestionnaire, BorderLayout.CENTER);
			btnSuggest.setText("Suggest Diagnosis");
			mnFile.setText("File");
			mnDM.setText("Trees");
			mnHelp.setText("Help");
			mntmSave.setText("Save");
			mntmExit.setText("Exit");
			mntmshallowADHDADP.setText("ADHD Attention Deficit Predominance");
			mntmshallowADHDHP.setText("ADHD with Hyperactivity Predominance ");
			mntmshallowCombinedADHD.setText("ADHD Combined");
			mntmshallowLSD.setText("Learning Specific Disorder");
			mntmshallowSCD.setText("Social Communication Disorder");
			mntmSpanish.setText("Spanish");
			mntmEnglish.setText("English");
			mntmAbout.setText("About...");
			btnNext.setText("  Next  ");
			lblPage.setText("Page " + page + "/4");
			lblYesNo.setText("YES / NO");
			mntmLoad.setText("Load");
			btnPrevious.setText("Previous");

			// QUESTIONS
			quest1 = "<html>	Does the child experience difficulty concentrating and is distracted by external stimulus?	</html>";
			quest2 = "<html>	Does it seem that the child does not listen when speaking directly to him?	</html>";
			quest3 = "<html>	Does the child have organisation problems?	</html>";
			quest4 = "<html>	Does the child show difficulty performing tasks that involve a sustained mental effort?	</html>";
			quest5 = "<html>	Does the child often lose necessary things to perform their tasks?	</html>";
			quest6 = "<html>	Does the child have problems remembering things or assignments immediately after being ordered to do them?	</html>";
			quest7 = "<html>	Does the child acquire and retain information quicker than their classmates?	</html>";
			quest8 = "<html>	Does the child give unusual solutions and provide different alternatives showing great creativity and imagination?	</html>";
			quest9 = "<html>	Does the child forget daily activities?	</html>";
			quest10 = "<html>	Does the child often get up in situations when they must remain seated?	</html>";
			quest11 = "<html>	Does the child run or climb when it is not appropriate?	</html>";
			quest12 = "<html>	Does the child talk excessively when they have a conversation?	</html>";
			quest13 = "<html>	Does the child use other people´s things without permission?	</html>";
			quest14 = "<html>	Does the child use games persistently and obsessively?	</html>";
			quest15 = "<html>	Does the child have a lack of awareness of sensations related to hygiene?	</html>";
			quest16 = "<html>	Does the child have difficulties to play calmly with other children?	</html>";
			quest17 = "<html>	Does the child have a difficulty to follow speech and conversation rules?	</html>";
			quest18 = "<html>	Does the child show difficulties in carrying out daily activities related to self-care?	</html>";
			quest19 = "<html>	Does he wander for no apparent reason?	</html>";
			quest20 = "<html>	Is the imaginative play absent?	</html>";
			quest21 = "<html>	Does the child show self-injurious behaviour?	</html>";
			quest22 = "<html>	Does the child have few and repetitive elements of distraction?	</html>";
			quest23 = "<html>	Does the child show motor stereotypes?	</html>";
			quest24 = "<html>	Does the child manifest a difficulty in dealing with changes?	</html>";
			quest25 = "<html>	Does the child feel discomfort after standing still for a long time?	</html>";
			quest26 = "<html>	Does the child show anomalies in the eye contact or is there no tracking of objects with the eye?	</html>";
			quest27 = "<html>	Does the child become disoriented frequently?	</html>";
			quest28 = "<html>	Does the child complain about itchy eyes or cry often?	</html>";
			quest29 = "<html>	When speaking in front of him, does they turn their head directing their ear towards the interlocutor?	</html>";
			quest30 = "<html>	Is the child very close to school materials and other objects to see them?	</html>";
			quest31 = "<html>	Is there an excess of flicker?	</html>";
			quest32 = "<html>	Does the child show reactions to light sources, appreciating facial changes or absence of winking eyes?	</html>";
			quest33 = "<html>	Does the child show intolerance to specific noises, smells or flavours?	</html>";
			quest34 = "<html>	Is it perceived an unusual interest for sensorial stimuli of the environment?	</html>";
			quest35 = "<html>	Is there a low response to call and sound stimuli? 	</html>";
			quest36 = "<html>	Does the child show difficulties in sharing interests or games with other kids?	</html>";
			quest37 = "<html>	Does the child have difficulties in establishing social relationships?	</html>";
			quest38 = "<html>	Does the child show difficulties in carrying out simple mathematical operations and simple calculations?	</html>";
			quest39 = "<html>	Does the child use a reduced range of words in comparison with their classmates?	</html>";
			quest40 = "<html>	Is there a language delay perceived in the child?	</html>";
			quest41 = "<html>	Does the child show a limited grammatical structure or a disorganised speech?	</html>";
			quest42 = "<html>	Are the alterations in the intonation when speaking?	</html>";
			quest43 = "<html>	Does the child have problems to understand the implicit language?	</html>";
			quest44 = "<html>	Does the child have a vast vocabulary or lot information about complex topics?	</html>";
			quest45 = "<html>	Does the child have problems in the acquisition and use of reading and writing?	</html>";
			quest46 = "<html>	Does the child have problems in the articulation of phonemes?	</html>";
			quest47 = "<html>	Does the child exhibit problems in the speech rhythm with or without stutter?	</html>";
			quest48 = "<html>	Does the child repeat words without sense?	</html>";
			quest49 = "<html>	Does the child show anomalies in the understanding and use of gestures?	</html>";
			quest50 = "<html>	Does the child exhibit problems in carrying out activities that involve oculo-manual coordination?	</html>";
			quest51 = "<html>	Can the child manipulate or dismantle mechanical objects of higher difficulty than corresponds to their age?	</html>";
			quest52 = "<html>	Is there a slowness and vagueness n in the performance of motor activities?	</html>";
			setQuestions();
			language = "English";
		}
		if (selectedLang.equals("Spanish")) {
			pnlQuestionnaire.setBorder(
					new TitledBorder(null, "Cuestionario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			frame.getContentPane().add(pnlQuestionnaire, BorderLayout.CENTER);
			btnSuggest.setText("Sugerir Diagnostico");
			mnFile.setText("Archivo");
			mnDM.setText("Arboles");
			mnHelp.setText("Ayuda");
			mntmSave.setText("Grabar");
			mntmExit.setText("Salir");
			mntmshallowADHDADP.setText("ADHD Predominio Defit de Atencion");
			mntmshallowADHDHP.setText("ADHD Predominio Hiperactivo-Impulsivo");
			mntmshallowCombinedADHD.setText("TDAH Combinado");
			mntmshallowLSD.setText("Trastorno Especifico del Aprendizaje");
			mntmshallowSCD.setText("Trastorno de la Comunicacion Social");
			mntmSpanish.setText("Español");
			mntmEnglish.setText("Ingles");
			mntmAbout.setText("Acerca de ...");
			btnNext.setText("Siguiente");
			lblPage.setText("Pagina " + page + "/4");
			lblYesNo.setText("SI / NO");
			mntmLoad.setText("Cargar");
			btnPrevious.setText("Anterior");

			// QUESTIONS
			quest1 = "<html>	¿Muestra dificultades para concentrarse en las tareas y se muestra distraido por estímulos externos?	</html>";
			quest2 = "<html>	¿Parece que no escucha cuando se le habla directamente?	</html>";
			quest3 = "<html>	¿Le cuesta organizarse?	</html>";
			quest4 = "<html>	¿Se resiste o muestra dificultades al realizar tareas que implican un esfuerzo mental sostenido?	</html>";
			quest5 = "<html>	¿Pierde frecuentemente cosas necesarias para  realizar sus tareas?	";
			quest6 = "<html>	¿Tiene dificultades para recordar cosas o tareas inmediatamente después de que se le digan?	</html>";
			quest7 = "<html>	¿Adquiere y retiene información rápidamente habiendo una gran diferencia con sus compañeros?	</html>";
			quest8 = "<html>	¿Da soluciones inusuales o aporta distintas alternativas  mostrando una gran creatividad e imaginación?	</html>";
			quest9 = "<html>	¿Se olvida de actividades cotidianas?	</html>";
			quest10 = "<html>	¿Se levanta frecuentemente en situaciones en las que debe permanecer sentado?	</html>";
			quest11 = "<html>	¿Corretea o trepa en situaciones en las que no es adecuado?	</html>";
			quest12 = "<html>	¿Habla excesivamente cuando mantiene una conversación?	</html>";
			quest13 = "<html>	¿Utiliza las cosas de otros sin permiso?	</html>";
			quest14 = "<html>	¿Realiza juegos o actividades de forma persistente y obsesiva?	</html>";
			quest15 = "<html>	¿Manifiesta una conciencia escasa de sensaciones relacionadas con la higiene y el aseo personal?	</html>";
			quest16 = "<html>	¿tiene dificultades para jugar con otros niños tranquilamente?	</html>";
			quest17 = "<html>	¿Tiene dificultades para seguir las normas de conversación y narración?	</html>";
			quest18 = "<html>	¿Muestra dificultades en la realización de actividades cotidianadas  relacionadas con su autocuidado?	</html>";
			quest19 = "<html>	¿Deambula sin sentido aparente?	</html>";
			quest20 = "<html>	¿Rechaza o no está presente el juego imaginativo o de ficción?	</html>";
			quest21 = "<html>	¿presenta conductas autolesivas?	</html>";
			quest22 = "<html>	¿Tiene pocos y repetitivos elementos de distraccion?	</html>";
			quest23 = "<html>	¿Muestra estereotipias motoras ?	</html>";
			quest24 = "<html>	¿Muestra dificultades para soportar cambios?	</html>";
			quest25 = "<html>	¿Se aprecia incomodidad cuando permanece quieto durante mucho tiempo?	</html>";
			quest26 = "<html>	¿Se aprecian anomalías en el contacto visual o no hay seguimiento de objetos con la vista?	</html>";
			quest27 = "<html>	¿Parece estar desorientado,  frecuentemente?	</html>";
			quest28 = "<html>	¿Se queja de picor de ojos o le lloran con frecuencia?	</html>";
			quest29 = "<html>	¿Al hablar frente a él, gira su cabeza dirigiendo su oido hacía el interlocutor?	</html>";
			quest30 = "<html>	¿Se acerca mucho al material escolar y a otros objetos para verlos?	</html>";
			quest31 = "<html>	¿Hay un exceso de parpadeo?	</html>";
			quest32 = "<html>	¿Muestra reacciones ante focos de luz,  apreciándose cambios faciales o una inexistencia  del guiño de ojos?	</html>";
			quest33 = "<html>	¿Muestra intolerancia a determinados ruidos, olores o sabores?	</html>";
			quest34 = "<html>	¿Se percibe un interés inhabitual por aspectos sensoriales del entorno?	</html>";
			quest35 = "<html>	¿Se aprecia una baja respuesta a las llamadas y a los estímulos sonoros?	</html>";
			quest36 = "<html>	¿Muestra dificultades para compartir intereses o juegos con otros niños?	</html>";
			quest37 = "<html>	¿Tiene dificultades para establecer relaciones sociales?	</html>";
			quest38 = "<html>	¿Muestra dificultades en la realización de operaciones matemáticas sencillas y cálculos elementales?	</html>";
			quest39 = "<html>	¿Su vocabulario es reducido en comparación con el de sus compañeros/as?	</html>";
			quest40 = "<html>	¿Se aprecia un retraso en el lenguaje en comparación con otros niños de su edad?	</html>";
			quest41 = "<html>	¿Muestra una estructura gramatical limitada cuando habla o un discurso desorganizado?	</html>";
			quest42 = "<html>	¿Se dan alteraciones en la entonación cuando habla?	</html>";
			quest43 = "<html>	¿Tiene problemas comprendiendo lo que no se dice explícitamente?	</html>";
			quest44 = "<html>	¿Presenta un vocabulario muy amplio  y/o tiene gran información de temas complejos para su edad?	</html>";
			quest45 = "<html>	¿Tiene problemas en la adquisición y uso de la lecto-escritura?	</html>";
			quest46 = "<html>	¿Presenta problemas en la articulación de fonemas?	</html>";
			quest47 = "<html>	¿Presenta problemas en el ritmo del habla acompañados o no de tartamudeo?	</html>";
			quest48 = "<html>	¿Repite palabras sin sentido aparente o ecolalia?	</html>";
			quest49 = "<html>	¿Se aprecian anomalías en la comprensión y uso de gestos?	</html>";
			quest50 = "<html>	¿Presenta problemas en la realización de actividades que implican la coordinacion oculo-manual?	</html>";
			quest51 = "<html>	¿Puede manipular o desmontar objetos mecánicos de dificultad superior a la que corresponde a su edad?	</html>";
			quest52 = "<html>	¿Se observa lentitud e impresición en la realización de actividades motrices?	</html>";
			setQuestions();
			language = "Spanish";

		}
	}

	private void setFacts() {
		if (page == 1) {
			if (chckbx1.isSelected()) {
				facts.add("(ExecFunc_1)");
			}
			if (chckbx2.isSelected()) {
				facts.add("(ExecFunc_2)");
			}
			if (chckbx3.isSelected()) {
				facts.add("(ExecFunc_3)");
			}
			if (chckbx4.isSelected()) {
				facts.add("(ExecFunc_4)");
			}
			if (chckbx5.isSelected()) {
				facts.add("(ExecFunc_5)");
			}
			if (chckbx6.isSelected()) {
				facts.add("(ExecFunc_6)");
			}
			if (chckbx7.isSelected()) {
				facts.add("(ExecFunc_7)");
			}
			if (chckbx8.isSelected()) {
				facts.add("(ExecFunc_8)");
			}
			if (chckbx9.isSelected()) {
				facts.add("(ExecFunc_9)");
			}
			if (chckbx10.isSelected()) {
				facts.add("(AdapBeha_1)");
			}
			if (chckbx11.isSelected()) {
				facts.add("(AdapBeha_2)");
			}
			if (chckbx12.isSelected()) {
				facts.add("(AdapBeha_3)");
			}
			if (chckbx13.isSelected()) {
				facts.add("(AdapBeha_4)");
			}
		}
		if (page == 2) {
			if (chckbx1.isSelected()) {
				facts.add("(AdapBeha_5)");
			}
			if (chckbx2.isSelected()) {
				facts.add("(AdapBeha_6)");
			}
			if (chckbx3.isSelected()) {
				facts.add("(AdapBeha_7)");
			}
			if (chckbx4.isSelected()) {
				facts.add("(AdapBeha_8)");
			}
			if (chckbx5.isSelected()) {
				facts.add("(AdapBeha_9)");
			}
			if (chckbx6.isSelected()) {
				facts.add("(AdapBeha_10)");
			}
			if (chckbx7.isSelected()) {
				facts.add("(AdapBeha_11)");
			}
			if (chckbx8.isSelected()) {
				facts.add("(AdapBeha_12)");
			}
			if (chckbx9.isSelected()) {
				facts.add("(AdapBeha_13)");
			}
			if (chckbx10.isSelected()) {
				facts.add("(AdapBeha_14)");
			}
			if (chckbx11.isSelected()) {
				facts.add("(AdapBeha_15)");
			}
			if (chckbx12.isSelected()) {
				facts.add("(AdapBeha_16)");
			}
			if (chckbx13.isSelected()) {
				facts.add("(SensPerc_1)");
			}
		}
		if (page == 3) {
			if (chckbx1.isSelected()) {
				facts.add("(SensPerc_2)");
			}
			if (chckbx2.isSelected()) {
				facts.add("(SensPerc_3)");
			}
			if (chckbx3.isSelected()) {
				facts.add("(SensPerc_4)");
			}
			if (chckbx4.isSelected()) {
				facts.add("(SensPerc_5)");
			}
			if (chckbx5.isSelected()) {
				facts.add("(SensPerc_6)");
			}
			if (chckbx6.isSelected()) {
				facts.add("(SensPerc_7)");
			}
			if (chckbx7.isSelected()) {
				facts.add("(SensPerc_8)");
			}
			if (chckbx8.isSelected()) {
				facts.add("(SensPerc_9)");
			}
			if (chckbx9.isSelected()) {
				facts.add("(SensPerc_10)");
			}
			if (chckbx10.isSelected()) {
				facts.add("(Social_1)");
			}
			if (chckbx11.isSelected()) {
				facts.add("(Social_2)");
			}
			if (chckbx12.isSelected()) {
				facts.add("(LogMat_1)");
			}
			if (chckbx13.isSelected()) {
				facts.add("(LingCommu_1)");
			}
		}
		if (page == 4) {
			if (chckbx1.isSelected()) {
				facts.add("(LingCommu_2)");
			}
			if (chckbx2.isSelected()) {
				facts.add("(LingCommu_3)");
			}
			if (chckbx3.isSelected()) {
				facts.add("(LingCommu_4)");
			}
			if (chckbx4.isSelected()) {
				facts.add("(LingCommu_5)");
			}
			if (chckbx5.isSelected()) {
				facts.add("(LingCommu_6)");
			}
			if (chckbx6.isSelected()) {
				facts.add("(LingCommu_7)");
			}
			if (chckbx7.isSelected()) {
				facts.add("(LingCommu_8)");
			}
			if (chckbx8.isSelected()) {
				facts.add("(LingCommu_9)");
			}
			if (chckbx9.isSelected()) {
				facts.add("(LingCommu_10)");
			}
			if (chckbx10.isSelected()) {
				facts.add("(LingCommu_11)");
			}
			if (chckbx11.isSelected()) {
				facts.add("(MotSkills_1)");
			}
			if (chckbx12.isSelected()) {
				facts.add("(MotSkills_2)");
			}
			if (chckbx13.isSelected()) {
				facts.add("(MotSkills_3)");
			}
		}

		Set<String> hs = new HashSet<>();
		hs.addAll(facts);
		facts.clear();
		facts.addAll(hs);

	}

	private void setQuestions() {
		if (page == 1) {
			lbl1.setText(quest1);
			lbl2.setText(quest2);
			lbl3.setText(quest3);
			lbl4.setText(quest4);
			lbl5.setText(quest5);
			lbl6.setText(quest6);
			lbl7.setText(quest7);
			lbl8.setText(quest8);
			lbl9.setText(quest9);
			lbl10.setText(quest10);
			lbl11.setText(quest11);
			lbl12.setText(quest12);
			lbl13.setText(quest13);
		}
		if (page == 2) {
			lbl1.setText(quest14);
			lbl2.setText(quest15);
			lbl3.setText(quest16);
			lbl4.setText(quest17);
			lbl5.setText(quest18);
			lbl6.setText(quest19);
			lbl7.setText(quest20);
			lbl8.setText(quest21);
			lbl9.setText(quest22);
			lbl10.setText(quest23);
			lbl11.setText(quest24);
			lbl12.setText(quest25);
			lbl13.setText(quest26);
		}
		if (page == 3) {
			lbl1.setText(quest27);
			lbl2.setText(quest28);
			lbl3.setText(quest29);
			lbl4.setText(quest30);
			lbl5.setText(quest31);
			lbl6.setText(quest32);
			lbl7.setText(quest33);
			lbl8.setText(quest34);
			lbl9.setText(quest35);
			lbl10.setText(quest36);
			lbl11.setText(quest37);
			lbl12.setText(quest38);
			lbl13.setText(quest39);
		}
		if (page == 4) {
			lbl1.setText(quest40);
			lbl2.setText(quest41);
			lbl3.setText(quest42);
			lbl4.setText(quest43);
			lbl5.setText(quest44);
			lbl6.setText(quest45);
			lbl7.setText(quest46);
			lbl8.setText(quest47);
			lbl9.setText(quest48);
			lbl10.setText(quest49);
			lbl11.setText(quest50);
			lbl12.setText(quest51);
			lbl13.setText(quest52);
		}
	}

	private void clips() {

		Environment clips = new Environment();
		clips.load("Rules.clp");
		clips.reset();

		for (String fact : facts) {
			System.out.println("aserting" + fact);
			clips.eval("(assert " + fact + ")");
		}

		clips.run();

		String evaluate = "(find-all-facts ((?v diagnosis)) TRUE)";
		PrimitiveValue value = clips.eval(evaluate);
		String results = "";

		try {

			for (int i = 0; i < value.size(); i++) {
				results = results + value.get(i).getFactSlot("need").toString() + "\n";
				results = results + "     Conficence Level :  " + value.get(i).getFactSlot("confidence").toString()
						+ "\n\n";
			}
			System.out.println("Results:  " + results);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (results.length() > 5) {

			if (language.equals("English")) {
				results = results.replace("ADHD_HP", "ADHD with Hyperactivity Predominance");
				results = results.replace("ADHD_ADP", "ADHD with Attention-deficit Predominance");
				results = results.replace("ADHD_COMBINED", "Combined ADHD");
				results = results.replace("ASD", "Autism Spectrum Disorders");
				results = results.replace("IDD", "Intellectual Development Disorder");
				results = results.replace("SCD", "Social Communication Disorder");
				results = results.replace("VD", "Visual Disability");
				results = results.replace("LD", "Language Disorder");
				results = results.replace("HI", "Hearing Impairment");
				results = results.replace("CDD", "Coordination Development Disorder");
				results = results.replace("SMD", "Stereotyped Movements Disorder");
				results = results.replace("LSD", "Learning Specific disorder");
				results = results.replace("HC", "High Capacities");
				JOptionPane.showMessageDialog(frame, results, "Evaluation Result", JOptionPane.PLAIN_MESSAGE);

			}
			if (language.equals("Spanish")) {
				results = results.replace("ADHD_HP", "TDAH con Predominio Hiperactivo-impulsivo");
				results = results.replace("ADHD_ADP", "TDAH con Predominio Déficit de Atención");
				results = results.replace("ADHD_COMBINED", "TDAH Combinado");
				results = results.replace("ASD", "Trastorno del Espectro Autista");
				results = results.replace("IDD", "Trastorno del Desarrollo Intelectual");
				results = results.replace("SCD", "Trastorno de Comunicación Social");
				results = results.replace("VD", "Discapacidad Visual");
				results = results.replace("LD", "Trastorno del Lenguaje");
				results = results.replace("HI", "Discapacidad Auditiva");
				results = results.replace("CDD", "Trastorno del Desarrollo de la Coordinación");
				results = results.replace("SMD", "Trastorno de Movimientos Estereotipados");
				results = results.replace("LSD", "Trastorno Especifico del Aprendizaje");
				results = results.replace("HC", "Altas Capacidades");
				results = results.replace("Conficence Level", "Nivel de Confianza");
				results = results.replace("conficence", "confianza");
				results = results.replace("High", "Alto");
				results = results.replace("Medium", "Medio");
				results = results.replace("Low", "Bajo");
				JOptionPane.showMessageDialog(frame, results, "Resultados de la Evaluacion", JOptionPane.PLAIN_MESSAGE);

			}

		} else {

			if (language.equals("English")) {
				JOptionPane.showMessageDialog(frame, "Not enough evidence to suggest a diagnosis", "Evaluation Result",
						JOptionPane.PLAIN_MESSAGE);
			}
			if (language.equals("Spanish")) {
				JOptionPane.showMessageDialog(frame, "No hay suficientes evidencias como para sugerir un diagnostico.",
						"Resultados de la Evaluacion", JOptionPane.PLAIN_MESSAGE);
			}

		}
		results = "";
		clips.reset();

	}

	private void resetChecked() {
		chckbx1.setSelected(false);
		chckbx2.setSelected(false);
		chckbx3.setSelected(false);
		chckbx4.setSelected(false);
		chckbx5.setSelected(false);
		chckbx6.setSelected(false);
		chckbx7.setSelected(false);
		chckbx8.setSelected(false);
		chckbx9.setSelected(false);
		chckbx10.setSelected(false);
		chckbx11.setSelected(false);
		chckbx12.setSelected(false);
		chckbx13.setSelected(false);

	}

	private void setChecked() {
		resetChecked();
		if (page == 1) {
			if (facts.contains("(ExecFunc_1)")) {
				chckbx1.setSelected(true);
			}
			if (facts.contains("(ExecFunc_2)")) {
				chckbx2.setSelected(true);
			}
			if (facts.contains("(ExecFunc_3)")) {
				chckbx3.setSelected(true);
			}
			if (facts.contains("(ExecFunc_4)")) {
				chckbx4.setSelected(true);
			}
			if (facts.contains("(ExecFunc_5)")) {
				chckbx5.setSelected(true);
			}
			if (facts.contains("(ExecFunc_6)")) {
				chckbx6.setSelected(true);
			}
			if (facts.contains("(ExecFunc_7)")) {
				chckbx7.setSelected(true);
			}
			if (facts.contains("(ExecFunc_8)")) {
				chckbx8.setSelected(true);
			}
			if (facts.contains("(ExecFunc_9)")) {
				chckbx9.setSelected(true);
			}
			if (facts.contains("(AdapBeha_1)")) {
				chckbx10.setSelected(true);
			}
			if (facts.contains("(AdapBeha_2)")) {
				chckbx11.setSelected(true);
			}
			if (facts.contains("(AdapBeha_3)")) {
				chckbx12.setSelected(true);
			}
			if (facts.contains("(AdapBeha_4)")) {
				chckbx13.setSelected(true);
			}
		}
		if (page == 2) {

			if (facts.contains("(AdapBeha_5)")) {
				chckbx1.setSelected(true);
			}
			if (facts.contains("(AdapBeha_6)")) {
				chckbx2.setSelected(true);
			}
			if (facts.contains("(AdapBeha_7)")) {
				chckbx3.setSelected(true);
			}
			if (facts.contains("(AdapBeha_8)")) {
				chckbx4.setSelected(true);
			}
			if (facts.contains("(AdapBeha_9)")) {
				chckbx5.setSelected(true);
			}
			if (facts.contains("(AdapBeha_10)")) {
				chckbx6.setSelected(true);
			}
			if (facts.contains("(AdapBeha_11)")) {
				chckbx7.setSelected(true);
			}
			if (facts.contains("(AdapBeha_12)")) {
				chckbx8.setSelected(true);
			}
			if (facts.contains("(AdapBeha_13)")) {
				chckbx9.setSelected(true);
			}
			if (facts.contains("(AdapBeha_14)")) {
				chckbx10.setSelected(true);
			}
			if (facts.contains("(AdapBeha_15)")) {
				chckbx11.setSelected(true);
			}
			if (facts.contains("(AdapBeha_16)")) {
				chckbx12.setSelected(true);
			}
			if (facts.contains("(SensPerc_1)")) {
				chckbx13.setSelected(true);
			}
		}
		if (page == 3) {

			if (facts.contains("(SensPerc_2)")) {
				chckbx1.setSelected(true);
			}
			if (facts.contains("(SensPerc_3)")) {
				chckbx2.setSelected(true);
			}
			if (facts.contains("(SensPerc_4)")) {
				chckbx3.setSelected(true);
			}
			if (facts.contains("(SensPerc_5)")) {
				chckbx4.setSelected(true);
			}
			if (facts.contains("(SensPerc_6)")) {
				chckbx5.setSelected(true);
			}
			if (facts.contains("(SensPerc_7)")) {
				chckbx6.setSelected(true);
			}
			if (facts.contains("(SensPerc_8)")) {
				chckbx7.setSelected(true);
			}
			if (facts.contains("(SensPerc_9)")) {
				chckbx8.setSelected(true);
			}
			if (facts.contains("(SensPerc_10)")) {
				chckbx9.setSelected(true);
			}
			if (facts.contains("(SocInter_1)")) {
				chckbx10.setSelected(true);
			}
			if (facts.contains("(SocInter_1)")) {
				chckbx11.setSelected(true);
			}
			if (facts.contains("(LogMat_1)")) {
				chckbx12.setSelected(true);
			}
			if (facts.contains("(LingCommu_1)")) {
				chckbx13.setSelected(true);
			}
		}
		if (page == 4) {

			if (facts.contains("(LingCommu_2)")) {
				chckbx1.setSelected(true);
			}
			if (facts.contains("(LingCommu_3)")) {
				chckbx2.setSelected(true);
			}
			if (facts.contains("(LingCommu_4)")) {
				chckbx3.setSelected(true);
			}
			if (facts.contains("(LingCommu_5)")) {
				chckbx4.setSelected(true);
			}
			if (facts.contains("(LingCommu_6)")) {
				chckbx5.setSelected(true);
			}
			if (facts.contains("(LingCommu_7)")) {
				chckbx6.setSelected(true);
			}
			if (facts.contains("(LingCommu_8)")) {
				chckbx7.setSelected(true);
			}
			if (facts.contains("(LingCommu_9)")) {
				chckbx8.setSelected(true);
			}
			if (facts.contains("(LingCommu_10)")) {
				chckbx9.setSelected(true);
			}
			if (facts.contains("(LingCommu_11)")) {
				chckbx10.setSelected(true);
			}
			if (facts.contains("(MotSkills_1)")) {
				chckbx11.setSelected(true);
			}
			if (facts.contains("(MotSkills_2)")) {
				chckbx12.setSelected(true);
			}
			if (facts.contains("(MotSkills_3)")) {
				chckbx13.setSelected(true);
			}
		}

	}

	public static File getResourceAsFile(String resourcePath, String format) {
		try {
			InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(resourcePath);
			if (in == null) {
				return null;
			}

			File tempFile = File.createTempFile(String.valueOf(in.hashCode()), format);
			tempFile.deleteOnExit();

			try (FileOutputStream out = new FileOutputStream(tempFile)) {
				// copy stream
				byte[] buffer = new byte[1024];
				int bytesRead;
				while ((bytesRead = in.read(buffer)) != -1) {
					out.write(buffer, 0, bytesRead);
				}
			}
			return tempFile;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
