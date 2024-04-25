
package com.portolink.pdfxeretaitor;

import java.io.File;

public class Edition 
{
    private final String nome, CPF;
    private String doc = null;
    private final String sourceFile;    //  = "INTERCAMBIO CULTURAL_miolo 2015 - pdf completo.pdf";
    private final String picture;       //  = "intercambio_cultural.jpg";        
    private final String targetFile; 
        
    public Edition (String pNomeLivro, String pLingua, String pSource, String pCapa, String pNome, String pCFP, String pAg)
    {
        sourceFile = pSource;
        picture = pCapa;
        nome = pNome;
        CPF = pCFP;
        if (pAg != null)
            doc = ".\\Agencias\\".concat(pAg).concat(".pdf");
      //targetFile  = "./Gerados/".concat(pNome.replace(" ", "")).concat("-").concat(CPF).concat(".pdf");
      
        targetFile = String.format(".\\Gerados\\[%s-%s][%s-%s].pdf", pNomeLivro, pLingua,
                                                               pNome.replace(" ", ""), CPF);    
        System.out.println("sourceFile: " + sourceFile + ".");
        System.out.println("pCapa: " + pCapa + ".");
        System.out.println("Nome: " + nome + ".");
        System.out.println("CPF: " + CPF + ".");
        System.out.println("Agencia: " + doc + ".");
        System.out.println("Arquivo: " + targetFile + ".");
    }
    
    public boolean insereCapa ()
    {
        File fTeste = new File(sourceFile);
        if (!fTeste.exists())
        {
            System.out.println("Livro não encontrado: " + fTeste.getAbsolutePath());
            return false;
        }
        fTeste = new File(picture);
        if (!fTeste.exists())
        {
            System.out.println("Capa não encontrada.");
            return false;
        }
        PDFMixer mixer = new PDFMixer();
        //System.out.println("delete");
        File fDel = new File(targetFile);
        if (fDel.exists())
            fDel.delete();
        //System.out.println("createEmptyPDF");
        if (!mixer.createEmptyPDF(targetFile))
        {
            System.out.println("Erro na abertura do arquivo");
            return false;
        }
        
        //System.out.println("openTarget");
        if (!mixer.openTarget(targetFile))
        {
            System.out.println("Erro na abertura do arquivo de saida");
            return false;
        }
        
        //System.out.println("addPicture");
        if (!mixer.addPicture(picture))
        {
            System.out.println("Erro na adição da capa ao arquivo");
            return false;
        }
        
        if (!mixer.openSource(sourceFile))
        {
            System.out.println("Erro na abertura do arquivo de entrada");
            return false;
        }
        
        //System.out.println("copyPages");
        if (!mixer.copyPages())
        {
            System.out.println("Erro na copia das  páginaS.");
            return false;
        }
        
        //System.out.println("stampPages");
      /*if (!mixer.stampPages(nome, CPF))
        {
            System.out.println("Erro na stampPages das  páginaS.");
            return false;
        }*/
        
        //System.out.println("2. saveTarget");
        if (!mixer.saveTarget(targetFile))
        {
            System.out.println("Erro no fechamento do arquivo");
            return false;
        }
        //System.out.println("closeTarget");
        if (!mixer.closeTarget())
        {
            System.out.println("Erro no fechamento do arquivo de saida");
            return false;
        }
        
        
        //System.out.println("closeSource");
        if (!mixer.closeSource())
        {
          //System.out.println("Erro no fechamento do arquivo de entrada");
            return true;
        }
        return true;
    }
            
    
    public boolean go ()
    {
        File fTeste = new File(sourceFile);
        if (!fTeste.exists())
        {
            System.out.println("Livro não encontrado: " + fTeste.getAbsolutePath());
            return false;
        }
        fTeste = new File(picture);
        if (!fTeste.exists())
        {
            System.out.println("Capa não encontrada.");
            return false;
        }
        PDFMixer mixer = new PDFMixer();
        //System.out.println("delete");
        File fDel = new File(targetFile);
        if (fDel.exists())
            fDel.delete();
        
        //System.out.println("createEmptyPDF");
        if (!mixer.createEmptyPDF(targetFile))
        {
            System.out.println("Erro na abertura do arquivo");
            return false;
        }
        
        //System.out.println("openTarget");
        if (!mixer.openTarget(targetFile))
        {
            System.out.println("Erro na abertura do arquivo de saida");
            return false;
        }
        
        //System.out.println("addPicture");
        if (!mixer.addPicture(picture))
        {
            System.out.println("Erro na adição da capa ao arquivo");
            return false;
        }
        
        //System.out.println("addPage");
        if (doc != null)
        {
            if (!mixer.addPage(doc))
            {
                System.out.println("Erro na adição de página da agencia ao arquivo");
                return false;
            }
        }
        
        //System.out.println("openSource");
        if (!mixer.openSource(sourceFile))
        {
            System.out.println("Erro na abertura do arquivo de entrada");
            return false;
        }
        
        //System.out.println("copyPages");
        if (!mixer.copyPages())
        {
            System.out.println("Erro na copia das  páginaS.");
            return false;
        }
        
        //System.out.println("stampPages");
        if (!mixer.stampPages(nome, CPF))
        {
            System.out.println("Erro na stampPages das  páginaS.");
            return false;
        }
        
        //System.out.println("2. saveTarget");
        if (!mixer.saveTarget(targetFile))
        {
            System.out.println("Erro no fechamento do arquivo");
            return false;
        }
        //System.out.println("closeTarget");
        if (!mixer.closeTarget())
        {
            System.out.println("Erro no fechamento do arquivo de saida");
            return false;
        }
        
        
        //System.out.println("closeSource");
        if (!mixer.closeSource())
        {
            System.out.println("Erro no fechamento do arquivo de entrada");
            return false;
        }
        return true;
    }
    
}
