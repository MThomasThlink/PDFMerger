
package com.portolink.pdfxeretaitor;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FrameMain extends javax.swing.JFrame {
    
    public FrameMain() {
        initComponents();
    }
    
    private void refrescaTabela ()
    {
        try {
            String strTable = new String(Files.readAllBytes(Paths.get("./tabela.txt")));
            taTabela.setText(strTable);
        } catch (IOException ex) {
            Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void go ()
    {
        File fGerados = new File("./Gerados");
        if (!fGerados.exists())
            fGerados.mkdirs();
        carregaCboLivros();
        cboAgencia.setModel(new javax.swing.DefaultComboBoxModel(listFiles("./Agencias", "pdf")));
        refrescaTabela();
        setVisible(true);
    }
    
    private void carregaCboLivros ()
    {
        cboLivros.removeAllItems();
        cboLinguas.removeAllItems();
        String[] livros = listDirs("./Livros");
        System.out.println(" " + livros.length);
        cboLivros.setModel(new javax.swing.DefaultComboBoxModel(livros));
        cboLivros.setSelectedIndex(0);
    }
    
    private void carregaCboLinguas ()
    {
        if (cboLivros.getSelectedItem() == null) 
            return;
        String strLivro = (String)cboLivros.getSelectedItem();
        String[] linguas = listDirs("./Livros/" + strLivro);
        System.out.println(" " + linguas.length);
        cboLinguas.setModel(new javax.swing.DefaultComboBoxModel(linguas));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panSelecao = new javax.swing.JPanel();
        lblLivro = new javax.swing.JLabel();
        cboLivros = new javax.swing.JComboBox<>();
        cboLinguas = new javax.swing.JComboBox<>();
        panGeral = new javax.swing.JPanel();
        scrollPane1 = new java.awt.ScrollPane();
        taTabela = new javax.swing.JTextArea();
        btGeraPDFs = new javax.swing.JButton();
        btRefresca = new javax.swing.JButton();
        btFim = new javax.swing.JButton();
        panIndividual = new javax.swing.JPanel();
        Nome = new javax.swing.JLabel();
        tNome = new javax.swing.JTextField();
        Nome1 = new javax.swing.JLabel();
        tCPF = new javax.swing.JTextField();
        Nome2 = new javax.swing.JLabel();
        cboAgencia = new javax.swing.JComboBox<>();
        btPDF1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PDFMerger");
        setMaximumSize(new java.awt.Dimension(660, 600));
        setMinimumSize(new java.awt.Dimension(660, 600));
        setPreferredSize(new java.awt.Dimension(660, 600));
        setResizable(false);

        panSelecao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panSelecao.setMaximumSize(new java.awt.Dimension(630, 70));
        panSelecao.setMinimumSize(new java.awt.Dimension(630, 70));

        lblLivro.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLivro.setForeground(new java.awt.Color(102, 0, 0));
        lblLivro.setText("Livro:");

        cboLivros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboLivros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboLivros.setMaximumSize(new java.awt.Dimension(68, 23));
        cboLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLivrosActionPerformed(evt);
            }
        });

        cboLinguas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboLinguas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboLinguas.setMaximumSize(new java.awt.Dimension(68, 23));

        javax.swing.GroupLayout panSelecaoLayout = new javax.swing.GroupLayout(panSelecao);
        panSelecao.setLayout(panSelecaoLayout);
        panSelecaoLayout.setHorizontalGroup(
            panSelecaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panSelecaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboLinguas, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panSelecaoLayout.setVerticalGroup(
            panSelecaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSelecaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panSelecaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboLivros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLinguas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        panGeral.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panGeral.setMaximumSize(new java.awt.Dimension(630, 313));
        panGeral.setMinimumSize(new java.awt.Dimension(630, 313));
        panGeral.setPreferredSize(new java.awt.Dimension(630, 313));

        taTabela.setColumns(20);
        taTabela.setRows(5);
        taTabela.setText("Manuel Orleans;123.456.789;AG1\nMT;987.654.321-00;AG2");
        taTabela.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        scrollPane1.add(taTabela);

        btGeraPDFs.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btGeraPDFs.setForeground(new java.awt.Color(102, 0, 0));
        btGeraPDFs.setText("Gera PDFs");
        btGeraPDFs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGeraPDFsActionPerformed(evt);
            }
        });

        btRefresca.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btRefresca.setForeground(new java.awt.Color(102, 0, 0));
        btRefresca.setText("Refresca");
        btRefresca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRefrescaActionPerformed(evt);
            }
        });

        btFim.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btFim.setForeground(new java.awt.Color(102, 0, 0));
        btFim.setText("Fim");
        btFim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panGeralLayout = new javax.swing.GroupLayout(panGeral);
        panGeral.setLayout(panGeralLayout);
        panGeralLayout.setHorizontalGroup(
            panGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(panGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btRefresca, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btGeraPDFs, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFim, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panGeralLayout.setVerticalGroup(
            panGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panGeralLayout.createSequentialGroup()
                        .addComponent(btGeraPDFs, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btRefresca, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btFim, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 37, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );

        panIndividual.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panIndividual.setMaximumSize(new java.awt.Dimension(630, 159));
        panIndividual.setMinimumSize(new java.awt.Dimension(630, 159));
        panIndividual.setPreferredSize(new java.awt.Dimension(630, 159));

        Nome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Nome.setForeground(new java.awt.Color(102, 0, 0));
        Nome.setText("Nome:");

        tNome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tNome.setForeground(new java.awt.Color(0, 0, 102));

        Nome1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Nome1.setForeground(new java.awt.Color(102, 0, 0));
        Nome1.setText("CPF:");

        tCPF.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tCPF.setForeground(new java.awt.Color(0, 0, 102));

        Nome2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Nome2.setForeground(new java.awt.Color(102, 0, 0));
        Nome2.setText("Agência:");

        cboAgencia.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        cboAgencia.setForeground(new java.awt.Color(102, 0, 0));
        cboAgencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btPDF1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btPDF1.setForeground(new java.awt.Color(102, 0, 0));
        btPDF1.setText("Gera PDF 1");
        btPDF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPDF1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panIndividualLayout = new javax.swing.GroupLayout(panIndividual);
        panIndividual.setLayout(panIndividualLayout);
        panIndividualLayout.setHorizontalGroup(
            panIndividualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panIndividualLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panIndividualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panIndividualLayout.createSequentialGroup()
                        .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(tNome, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panIndividualLayout.createSequentialGroup()
                        .addGroup(panIndividualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nome2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panIndividualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboAgencia, 0, 284, Short.MAX_VALUE)
                            .addComponent(tCPF))))
                .addGap(35, 35, 35)
                .addComponent(btPDF1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panIndividualLayout.setVerticalGroup(
            panIndividualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panIndividualLayout.createSequentialGroup()
                .addGroup(panIndividualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panIndividualLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btPDF1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panIndividualLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panIndividualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panIndividualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panIndividualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nome2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panGeral, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panSelecao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panIndividual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(panSelecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(panGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(panIndividual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPDF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPDF1ActionPerformed
        if (tNome.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Preencha o nome!");
            return;
        }
        if (tCPF.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Preencha o CPF!");
            return;
        }
        doPDF1();
    }//GEN-LAST:event_btPDF1ActionPerformed

    private void btRefrescaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRefrescaActionPerformed
        refrescaTabela();
    }//GEN-LAST:event_btRefrescaActionPerformed

    private void btGeraPDFsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGeraPDFsActionPerformed
        doPDFs();
    }//GEN-LAST:event_btGeraPDFsActionPerformed

    private void btFimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFimActionPerformed
        //fazAsCapas();
        System.exit(0);
    }//GEN-LAST:event_btFimActionPerformed

    private void cboLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLivrosActionPerformed
        carregaCboLinguas();
    }//GEN-LAST:event_cboLivrosActionPerformed

    private void doPDFs ()
    {
        int ctdOK = 0, ctdErro = 0;
        
        if (cboLivros.getSelectedItem() == null || cboLinguas.getSelectedItem() == null)
        {
            JOptionPane.showMessageDialog(this, "Livro e língua não escolhido!");
            return;
        }
        String absolutePath = System.getProperty("user.dir");
        String pathLivro = absolutePath.concat("\\Livros\\").
                                        concat((String)cboLivros.getSelectedItem()).
                                        concat("\\").
                                        concat((String)cboLinguas.getSelectedItem());
            
        String[] livros = listFiles(pathLivro, ".pdf");
        if (livros.length != 1)
        {
            JOptionPane.showMessageDialog(this, "Deve haver somente 1 PDF em " + pathLivro);
            return;
        }
        String livro = String.format("%s\\Livros\\%s\\%s\\%s", absolutePath, cboLivros.getSelectedItem(), 
                                                           cboLinguas.getSelectedItem(), livros[0]);
        String[] capas = listFiles(pathLivro, ".jpg");
        if (capas.length != 1)
        {
            JOptionPane.showMessageDialog(this, "Deve haver somente 1 JPG em " + pathLivro);
            return;
        }
        String capa = String.format("%s\\Livros\\%s\\%s\\%s", absolutePath, cboLivros.getSelectedItem(), 
                                                           cboLinguas.getSelectedItem(), capas[0]);
        
        for (String line : taTabela.getText().split("\n")) 
        {
          //System.out.println("1. line.length() = " + line.length());
            line = line.replaceAll("\\r|\\n", "");
          //System.out.println("2. line.length() = " + line.length());
            
            String[] parts = line.split(";");
            if (parts.length == 3)
            {
                Edition ed = new Edition((String)cboLivros.getSelectedItem(), (String)cboLinguas.getSelectedItem(), 
                                         livro, capa, parts[0], parts[1], parts[2]);
                if (ed.go())
                {
                    ctdOK++;
                    System.out.println("Arquivo gerado com sucesso.\n");
                }
                else
                {
                    ctdErro++;
                    System.out.println("Erro na geracao do arquivo.\n");
                }
            }
            else
                System.out.println("Ignorando linha mal formada. \n " + line);
        }
        JOptionPane.showMessageDialog(this, String.format("Gerados: %d. Erro: %d", ctdOK, ctdErro));
    }
    
    private void doPDF1 ()
    {
        if (cboLivros.getSelectedItem() == null || cboLinguas.getSelectedItem() == null)
        {
            JOptionPane.showMessageDialog(this, "Livro e língua não escolhido!");
            return;
        }
        String absolutePath = System.getProperty("user.dir");
        String pathLivro = absolutePath.concat("\\Livros\\").
                                        concat((String)cboLivros.getSelectedItem()).
                                        concat("\\").
                                        concat((String)cboLinguas.getSelectedItem());
            
        String[] livros = listFiles(pathLivro, ".pdf");
        if (livros.length != 1)
        {
            JOptionPane.showMessageDialog(this, "Deve haver somente 1 PDF em " + pathLivro);
            return;
        }
        String livro = String.format("%s\\Livros\\%s\\%s\\%s", absolutePath, cboLivros.getSelectedItem(), 
                                                           cboLinguas.getSelectedItem(), livros[0]);
        String[] capas = listFiles(pathLivro, ".jpg");
        if (capas.length != 1)
        {
            JOptionPane.showMessageDialog(this, "Deve haver somente 1 JPG em " + pathLivro);
            return;
        }
        String capa = String.format("%s\\Livros\\%s\\%s\\%s", absolutePath, cboLivros.getSelectedItem(), 
                                                           cboLinguas.getSelectedItem(), capas[0]);
        String agencia = null;
        if (cboAgencia.getSelectedItem() != null)
            agencia = cboAgencia.getSelectedItem().toString().replace(".pdf", "");
        Edition ed = new Edition((String)cboLivros.getSelectedItem(), (String)cboLinguas.getSelectedItem(), 
                                 livro, capa, tNome.getText(), tCPF.getText(), agencia);
        if (ed.go())
            JOptionPane.showMessageDialog(this, "Funcionou!");
        else
            JOptionPane.showMessageDialog(this, "Não teve sorte!");
    }

    private void fazAsCapas ()
    {
        Edition ed;
                
        String pNomeLivro, pLingua, pSource, pCapa, pDir;
        
        //Expatriado
      /*pDir = "C:\\projetosII\\Dropbox\\CampoGrande1\\Current\\Teste\\PDFMerger\\Livros\\Expatriado\\Espanhol";
        pNomeLivro = "ExpatriadosEspComCapa";
        pSource = pDir.concat("\\ExpatriadosEsp.pdf");
        pCapa = pDir.concat("\\expatriados_capa_final.jpg");
        pLingua = "Espanhol";
        ed = new Edition(pNomeLivro, pLingua, pSource, pCapa, "", "", "");
        if (ed.insereCapa())
            JOptionPane.showMessageDialog(this, "Expatriado ESP com capa OK!");
        else
            JOptionPane.showMessageDialog(this, "Expatriado ESP com capa erro!");
        
        pDir = "C:\\projetosII\\Dropbox\\CampoGrande1\\Current\\Teste\\PDFMerger\\Livros\\Expatriado\\Portugues";
        pNomeLivro = "ExpatriadosPortComCapa";
        pSource = pDir.concat("\\miolo expatriados_último.pdf");
        pCapa = pDir.concat("\\expatriados_capa_final.jpg");
        pLingua = "Portugues";
        ed = new Edition(pNomeLivro, pLingua, pSource, pCapa, "", "", "");
        if (ed.insereCapa())
            JOptionPane.showMessageDialog(this, "Expatriado PORT com capa OK!");
        else
            JOptionPane.showMessageDialog(this, "Expatriado PORT com capa erro!");
        
        //Intercambio
        pDir = "C:\\projetosII\\Dropbox\\CampoGrande1\\Current\\Teste\\PDFMerger\\Livros\\Intercambio\\Espanhol";
        pNomeLivro = "IntercambioEspComCapa";
        pSource = pDir.concat("\\Intercambio espanhol.pdf");
        pCapa = pDir.concat("\\capa_intercambio espanhol.jpg");
        pLingua = "Espanhol";
        ed = new Edition(pNomeLivro, pLingua, pSource, pCapa, "", "", "");
        if (ed.insereCapa())
            JOptionPane.showMessageDialog(this, "Intercambio Esp com capa OK!");
        else
            JOptionPane.showMessageDialog(this, "Intercambio Esp com capa erro!");
       
        pDir = "C:\\projetosII\\Dropbox\\CampoGrande1\\Current\\Teste\\PDFMerger\\Livros\\Intercambio\\Portugues";
        pNomeLivro = "IntercambioPortComCapa";
        pSource = pDir.concat("\\INTERCAMBIO CULTURAL_miolo 2015 - pdf completo.pdf");
        pCapa = pDir.concat("\\intercambio_cultural.jpg");
        pLingua = "Portugues";
        ed = new Edition(pNomeLivro, pLingua, pSource, pCapa, "", "", "");
        if (ed.insereCapa())
            JOptionPane.showMessageDialog(this, "Intercambio PORT com capa OK!");
        else
            JOptionPane.showMessageDialog(this, "Intercambio PORT com capa erro!");*/
        
        pDir = "C:\\projetosII\\Dropbox\\CampoGrande1\\Current\\Teste\\PDFMerger\\Livros\\Intercambio\\Ingles";
        pNomeLivro = "Intercâmbio inglês";
        pSource = pDir.concat("\\Intercâmbio inglês.pdf");
        pCapa = pDir.concat("\\capaIngles.jpg");
        pLingua = "Ingles";
        ed = new Edition(pNomeLivro, pLingua, pSource, pCapa, "", "", "");
        if (ed.insereCapa())
            JOptionPane.showMessageDialog(this, "Intercambio ENG com capa OK!");
        else
            JOptionPane.showMessageDialog(this, "Intercambio ENG com capa erro!");
        
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nome;
    private javax.swing.JLabel Nome1;
    private javax.swing.JLabel Nome2;
    private javax.swing.JButton btFim;
    private javax.swing.JButton btGeraPDFs;
    private javax.swing.JButton btPDF1;
    private javax.swing.JButton btRefresca;
    private javax.swing.JComboBox<String> cboAgencia;
    private javax.swing.JComboBox<String> cboLinguas;
    private javax.swing.JComboBox<String> cboLivros;
    private javax.swing.JLabel lblLivro;
    private javax.swing.JPanel panGeral;
    private javax.swing.JPanel panIndividual;
    private javax.swing.JPanel panSelecao;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JTextField tCPF;
    private javax.swing.JTextField tNome;
    private javax.swing.JTextArea taTabela;
    // End of variables declaration//GEN-END:variables


    public String[] listFiles (String pPath, final String pExt)
    {
        File diretorio = new File(pPath);
        File[] fList = diretorio.listFiles(new FilenameFilter() 
        {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(pExt);
            }
        });
        if (fList == null)
                return null;
        String[] listNames = new String[fList.length];
        int i = 0;
        for (File fList1 : fList)
        {
            listNames[i] = fList1.getName();
            i++;
        }
        
        return listNames;
    }
    
    public String[] listDirs (String pPath)
    {
        File diretorio = new File(pPath);
        File[] fList = diretorio.listFiles(new FilenameFilter() 
        {
            @Override
            public boolean accept(File dir, String name) {
                return dir.isDirectory();
            }
        });
        if (fList == null)
                return null;
        String[] listNames = new String[fList.length];
        int i = 0;
        for (File fList1 : fList)
        {
            listNames[i] = fList1.getName();
            i++;
        }
        
        return listNames;
    }
    
}
