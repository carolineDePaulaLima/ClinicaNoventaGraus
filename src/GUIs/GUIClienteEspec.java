package GUIs;

import DAOs.DAOCliente;
import DAOs.DAOClienteHasEspecialidades;
import DAOs.DAOClienteHasEspecialidadesPK;
import DAOs.DAOEspecialidades;
import Entidades.ClienteHasEspecialidades;
import Entidades.ClienteHasEspecialidadesPK;
import Entidades.Especialidades;
import java.util.List;
import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import tools.*;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import javax.swing.JCheckBox;

public class GUIClienteEspec extends JDialog {

    ImageIcon iconeCreate = new ImageIcon(getClass().getResource("/icones/create.png"));
    ImageIcon iconeRetrieve = new ImageIcon(getClass().getResource("/icones/retrieve.png"));
    ImageIcon iconeUpdate = new ImageIcon(getClass().getResource("/icones/update.png"));
    ImageIcon iconeDelete = new ImageIcon(getClass().getResource("/icones/delete.png"));
    ImageIcon iconeSave = new ImageIcon(getClass().getResource("/icones/save.png"));
    ImageIcon iconeCancel = new ImageIcon(getClass().getResource("/icones/cancel.png"));
    ImageIcon iconeListar = new ImageIcon(getClass().getResource("/icones/list.png"));
    JButton btnCreate = new JButton(iconeCreate);
    JButton btnRetrieve = new JButton(iconeRetrieve);
    JButton btnUpdate = new JButton(iconeUpdate);
    JButton btnDelete = new JButton(iconeDelete);
    JButton btnSave = new JButton(iconeSave);
    JButton btnCancel = new JButton(iconeCancel);
    JButton btnList = new JButton(iconeListar);
    JPanel pnProblemaSaude = new JPanel(new GridLayout(1, 2));
    JPanel pnRestricao = new JPanel(new GridLayout(1, 2));
    JPanel pnProblemaResp = new JPanel(new GridLayout(1, 2));
    JPanel pnQtdSecao = new JPanel(new GridLayout(1, 2));
    JLabel lbCpf = new JLabel("CPF");
    JTextField tfCpf = new JTextField(20);
    JLabel lbIdEspecialidade = new JLabel("ID Especialidade");
    JTextField tfIdEspecialidade = new JTextField(5);
    JLabel lbProblemaSaude = new JLabel("Problema de saúde");
    JCheckBox cbProblemaSaude = new JCheckBox();
    JLabel lbRestricao = new JLabel("Restrição");
    JCheckBox cbRestricao = new JCheckBox();
    JLabel lbProblemaResp = new JLabel("Problema de respiração");
    JCheckBox cbProblemaResp = new JCheckBox();
    JLabel lbQtdSecao = new JLabel("Quantidade de seções");
    JTextField tfQtdSecao = new JTextField(20);
    JPanel pnAvisos = new JPanel();
    JLabel labelAviso = new JLabel("");
    String acao = "";
    DAOClienteHasEspecialidadesPK daoClienteHasEspecialidadesPK = new DAOClienteHasEspecialidadesPK();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");
    ClienteHasEspecialidades clienteHasEspecialidades;
    DAOClienteHasEspecialidades daoClienteHasEspecialidades = new DAOClienteHasEspecialidades();
    Especialidades especialidades = new Especialidades();

    private void atvBotoes(boolean c, boolean r, boolean u, boolean d) {
        btnCreate.setEnabled(c);
        btnRetrieve.setEnabled(r);
        btnUpdate.setEnabled(u);
        btnDelete.setEnabled(d);
        btnList.setEnabled(r);
    }

    public void mostrarBotoes(boolean visivel) {
        btnCreate.setVisible(visivel);
        btnRetrieve.setVisible(visivel);
        btnUpdate.setVisible(visivel);
        btnDelete.setVisible(visivel);
        btnList.setVisible(visivel);
        btnSave.setVisible(!visivel);
        btnCancel.setVisible(!visivel);
    }

    private void habilitarAtributos(boolean cliente, boolean especialidades, boolean problemasaude, boolean restricao, boolean problemaresp, boolean qtdsecao) {
        if (especialidades) {
            tfCpf.requestFocus();
            tfCpf.selectAll();
        }
        tfCpf.setEditable(cliente);
        tfIdEspecialidade.setEditable(especialidades);
        cbProblemaSaude.setEnabled(problemasaude);
        cbProblemaResp.setEnabled(problemaresp);
        cbRestricao.setEnabled(restricao);
        tfQtdSecao.setEditable(qtdsecao);
    }

    public void zerarAtributos() {
        tfCpf.setText("");
        tfIdEspecialidade.setText("");
        cbProblemaSaude.setSelected(false);
        cbRestricao.setSelected(false);
        cbProblemaResp.setSelected(false);
        tfQtdSecao.setText("");
    }
    Color corPadrao = lbIdEspecialidade.getBackground();

    public GUIClienteEspec() {
        setTitle("CRUD - ClienteHasEspecialidadesPK");
        setSize(600, 200);
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        Container cp = getContentPane();
        atvBotoes(false, true, false, false);
        habilitarAtributos(false, false, false, false, false, false);
        btnCreate.setToolTipText("Inserir novo registro");
        btnRetrieve.setToolTipText("Pesquisar por chave");
        btnUpdate.setToolTipText("Alterar");
        btnDelete.setToolTipText("Excluir");
        btnList.setToolTipText("Listar todos");
        btnSave.setToolTipText("Salvar");
        btnCancel.setToolTipText("Cancelar");
        JToolBar Toolbar1 = new JToolBar();
        Toolbar1.add(lbCpf);
        Toolbar1.add(tfCpf);
        Toolbar1.add(lbIdEspecialidade);
        Toolbar1.add(tfIdEspecialidade);
        Toolbar1.add(btnRetrieve);
        Toolbar1.add(btnCreate);
        Toolbar1.add(btnUpdate);
        Toolbar1.add(btnDelete);
        Toolbar1.add(btnSave);
        Toolbar1.add(btnCancel);
        Toolbar1.add(btnList);
        btnSave.setVisible(false);
        btnCancel.setVisible(false);
        JPanel centro = new JPanel(new GridLayout(4, 1));
        pnAvisos.add(labelAviso);
        pnAvisos.setBackground(Color.yellow);
        cp.add(Toolbar1, BorderLayout.NORTH);
        cp.add(centro, BorderLayout.CENTER);
        cp.add(pnAvisos, BorderLayout.SOUTH);
        pnProblemaSaude.add(lbProblemaSaude);
        pnProblemaSaude.add(cbProblemaSaude);
        pnRestricao.add(lbRestricao);
        pnRestricao.add(cbRestricao);
        pnProblemaResp.add(lbProblemaResp);
        pnProblemaResp.add(cbProblemaResp);
        pnQtdSecao.add(lbQtdSecao);
        pnQtdSecao.add(tfQtdSecao);
        centro.add(pnProblemaSaude);
        centro.add(pnRestricao);
        centro.add(pnProblemaResp);
        centro.add(pnQtdSecao);
        tfIdEspecialidade.requestFocus();
        tfIdEspecialidade.selectAll();
        labelAviso.setText("Aperte ENTER nos campos ID para selecionar os ID's e click [Pesquisar].");
        btnRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                clienteHasEspecialidades = new ClienteHasEspecialidades();
                try {
                    ClienteHasEspecialidadesPK clienteHasEspecialidadesPK = new ClienteHasEspecialidadesPK();
                    clienteHasEspecialidadesPK.setClienteCpf(tfCpf.getText());
                    clienteHasEspecialidadesPK.setIdEspecialidades(Integer.valueOf(tfIdEspecialidade.getText()));
                    DAOClienteHasEspecialidades daoClienteHasEspecialidades = new DAOClienteHasEspecialidades();
                    clienteHasEspecialidades = daoClienteHasEspecialidades.obter(clienteHasEspecialidadesPK);
                    if (clienteHasEspecialidades != null) {
                        cbProblemaSaude.setSelected(clienteHasEspecialidades.getProblemaSaude());
                        cbRestricao.setSelected(clienteHasEspecialidades.getRestricao());
                        cbProblemaResp.setSelected(clienteHasEspecialidades.getProblemaRespiracao());
                        tfQtdSecao.setText(String.valueOf(clienteHasEspecialidades.getQntdSecao()));
                        atvBotoes(false, true, true, true);
                        habilitarAtributos(false, false, false, false, false, false);
                        labelAviso.setText("Encontrou - click [Alterar] ou [Excluir].");
                        acao = "encontrou";
                    } else {
                        atvBotoes(true, true, false, false);
                        labelAviso.setText("Não cadastrado - click [Inserir] ou aperte ENTER nos campos ID para selecionar outro ID [Pesquisar].");
                    }
                    tfIdEspecialidade.setBackground(Color.green);
                    tfCpf.setBackground(Color.green);
                } catch (Exception x) {
                    if (tfCpf.getText().equals("")) {
                        labelAviso.setText("Erro no campo CPF.");
                        tfCpf.setBackground(Color.red);
                    } else {
                        labelAviso.setText("Erro no campo ID Especialidades.");
                        tfIdEspecialidade.setBackground(Color.red);
                    }
                }
            }
        });
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                habilitarAtributos(false, false, true, true, true, true);
                tfQtdSecao.requestFocus();
                mostrarBotoes(false);
                labelAviso.setText("Preencha os campos e clic [Salvar] ou click [Cancelar].");
                acao = "insert";
                tfIdEspecialidade.setBackground(corPadrao);
                tfCpf.setBackground(corPadrao);
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean deuRuim = false;
                if (acao.equals("insert")) {
                    clienteHasEspecialidades = new ClienteHasEspecialidades();
                }
                try {
                    String cpf = tfCpf.getText();
                    int idProd = Integer.valueOf(tfIdEspecialidade.getText());
                    clienteHasEspecialidades.setClienteHasEspecialidadesPK(new ClienteHasEspecialidadesPK(cpf, idProd));
                } catch (Exception erro2) {
                    deuRuim = true;
                    tfIdEspecialidade.setBackground(Color.red);
                    tfCpf.setBackground(Color.red);
                }
                try {
                    clienteHasEspecialidades.setProblemaSaude(cbProblemaSaude.isSelected());
                    clienteHasEspecialidades.setRestricao(cbRestricao.isSelected());
                    clienteHasEspecialidades.setProblemaRespiracao(cbProblemaResp.isSelected());
                    clienteHasEspecialidades.setQntdSecao(Integer.valueOf(tfQtdSecao.getText()));
                    zerarAtributos();
                } catch (Exception erro3) {
                    deuRuim = true;
                }
                if (!deuRuim) {
                    if (acao.equals("insert")) {
                        daoClienteHasEspecialidades.inserir(clienteHasEspecialidades);
                        labelAviso.setText("Registro inserido.");
                    } else {
                        daoClienteHasEspecialidades.atualizar(clienteHasEspecialidades);
                        labelAviso.setText("Registro alterado.");
                    }
                    tfQtdSecao.setBackground(corPadrao);
                    habilitarAtributos(false, false, false, false, false, false);
                    mostrarBotoes(true);
                    atvBotoes(false, true, false, false);
                } else {
                    tfQtdSecao.setBackground(Color.RED);
                    labelAviso.setText("Erro em algum dos campos.");
                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                zerarAtributos();
                atvBotoes(false, true, false, false);
                habilitarAtributos(false, false, false, false, false, false);
                mostrarBotoes(true);
                tfIdEspecialidade.setBackground(corPadrao);
                tfCpf.setBackground(corPadrao);
                tfQtdSecao.setBackground(corPadrao);
                labelAviso.setText("Aperte ENTER nos campos ID e click [Pesquisar].");
            }
        });
        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                acao = "list";
                GUIClienteEspecListagem guiClienteHasEspecialidadesListagem = new GUIClienteEspecListagem(daoClienteHasEspecialidades.list());
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                acao = "update";
                mostrarBotoes(false);
                habilitarAtributos(false, false, true, true, true, true);
                labelAviso.setText("Editando - click [Salvar] ou [Cancelar].");
                tfCpf.setBackground(corPadrao);
                tfIdEspecialidade.setBackground(corPadrao);
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
                        "Confirma a exclusão?\n"
                        + "ID Cliente: " + clienteHasEspecialidades.getClienteHasEspecialidadesPK().getClienteCpf() + "\n"
                        + "ID Especialidade: " + clienteHasEspecialidades.getClienteHasEspecialidadesPK().getIdEspecialidades() + "\n",
                        "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    labelAviso.setText("Registro excluído...");
                    daoClienteHasEspecialidades.remover(clienteHasEspecialidades);
                    zerarAtributos();
                    habilitarAtributos(false, false, false, false, false, false);
                    mostrarBotoes(true);
                    atvBotoes(false, true, false, false);
                    tfCpf.setBackground(corPadrao);
                    tfIdEspecialidade.setBackground(corPadrao);
                    tfCpf.requestFocus();
                    tfCpf.selectAll();
                }
            }
        });
        DAOCliente daoCliente = new DAOCliente();
        tfCpf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = daoCliente.listInOrderNomeStrings("id");
                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split("-");
                        tfCpf.setText(aux[0]);
                        tfCpf.setBackground(Color.GREEN);
                        labelAviso.setText("Aperte ENTER nos campos ID e click [Pesquisar].");
                        btnRetrieve.setEnabled(true);
                    } else {
                        labelAviso.setText("Aperte ENTER nos campos ID e click [Pesquisar].");
                    }
                } else {
                    System.out.println("Nenhum dado adicionado.");
                }
            }
        });
        DAOEspecialidades daoEspecialidades = new DAOEspecialidades();
        tfIdEspecialidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = daoEspecialidades.listInOrderNomeStrings("id");
                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split("-");
                        tfIdEspecialidade.setText(aux[0]);
                        tfIdEspecialidade.setBackground(Color.GREEN);
                        labelAviso.setText("Aperte ENTER nos campos ID e click [Pesquisar].");
                        if (tfCpf.getText().equals("")) {
                            labelAviso.setText("Erro no campo CPF.");
                            tfCpf.setBackground(Color.red);
                            btnRetrieve.setEnabled(false);
                        } else {
                            btnRetrieve.setEnabled(true);
                        }
                    } else {
                        labelAviso.setText("Aperte ENTER nos campos ID e click [Pesquisar].");
                    }
                } else {
                    System.out.println("Nenhum dado adicionado.");
                }
            }
        });
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
        setModal(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GUIClienteEspec();
    }
}
