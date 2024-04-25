
package com.portolink.pdfxeretaitor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;

public class PDFMixer {
    private PDDocument sourcePDF, targetPDF, agency;
    private int W = 453, H = 651;
    
    public boolean createEmptyPDF (String pFile)
    {
        PDDocument doc;
        try
        {
            doc = new PDDocument(); // creating instance of pdfDoc
            //doc.addPage(new PDPage()); // adding page in pdf doc file
            doc.save(pFile); // saving as pdf file with name perm 
            doc.close(); // cleaning memory 
            return true;
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        } catch (COSVisitorException ex) {
            Logger.getLogger(PDFMixer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean openSource (String pFile)
    {
        try
        {
            File file = new File(pFile);
            sourcePDF = PDDocument.load(file);
            return true;
        } catch (Exception e)
        {
            System.out.println("openSource ERROR: " + e.toString());
            return false;
        }
    }
    
    public boolean openTarget (String pFile)
    {
        try
        {
            File file = new File(pFile);
            targetPDF = PDDocument.load(file);
            return true;
        } catch (Exception e)
        {
            System.out.println("openTarget ERROR: " + e.toString());
            return false;
        }
    }
    
    public boolean addPicture (String pPicture)
    {
        try
        {
            InputStream in = new FileInputStream(pPicture);
            BufferedImage bimg = ImageIO.read(in);
            float width = bimg.getWidth();
            float height = bimg.getHeight();
            PDPage page = new PDPage(new PDRectangle(width, height));
            targetPDF.addPage(page); 
            
            PDXObjectImage img = new PDJpeg(targetPDF, new FileInputStream(pPicture));
            PDPageContentStream contentStream = new PDPageContentStream(targetPDF, page);
            contentStream.drawImage(img, 0, 0);
            contentStream.close();
            in.close();

            //doc.save("test.pdf");
            //'doc.close();
          //System.out.println("addPicture DONE");
            return true;
        } catch (Exception io){
            System.out.println("addPicture ERROR: " + io.toString());
            return false;
        }
    }
    
    public boolean addText (String pText)
    {
        try
        {
            PDPage page = new PDPage(new PDRectangle(W, H));
            targetPDF.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(targetPDF, page, true, true);

            contentStream.beginText(); 
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 10);
            contentStream.moveTextPositionByAmount(W*5/100, H*95/100);
            contentStream.drawString(pText);
            contentStream.endText();

            contentStream.close();
            
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }
            
    public boolean addPage (String pDoc)
    {
        try
        {
            File file = new File(pDoc);
            if (!file.exists())
            {
                System.out.println("Arquivo não existe");
                return false;
            }
            agency = PDDocument.load(file);
            List<PDPage> list = agency.getDocumentCatalog().getAllPages();
            for(int i = 0; i < list.size(); i++) 
            {
                PDPage page = (PDPage)agency.getDocumentCatalog().getAllPages().get(i);
                targetPDF.addPage(page);
                break;
            }
            
          //System.out.println("addPage DONE");
            //agency.close();
            return true;
        } catch (Exception io){
            System.out.println("addPage ERROR: " + io.toString());
            return false;
        }
    }

    public boolean copyPages ()
    {
        List<PDPage> list = sourcePDF.getDocumentCatalog().getAllPages();
        for(int i = 0; i < list.size(); i++) 
        {
            System.out.printf("@"); System.out.flush();
            PDPage page = (PDPage)sourcePDF.getDocumentCatalog().getAllPages().get(i);
            targetPDF.addPage(page);
        }
        
        System.out.println("." );
        //targetPDF.save( outfile );
        return true;
    }
    
    public boolean stampPages (String pNome, String pCPF)
    {
        String myString2 = "CPF: ".concat(pCPF);
        try
        {
            List<PDPage> list = targetPDF.getDocumentCatalog().getAllPages();
            for(int i = 1; i < list.size(); i++) 
            {
                System.out.printf("#"); System.out.flush();
                PDPage page = (PDPage)targetPDF.getDocumentCatalog().getAllPages().get(i);
              //PDPage page = (PDPage) sourcePDF.getDocumentCatalog().getAllPages().get(i); 
                PDPageContentStream contentStream = new PDPageContentStream(targetPDF, page, true, true);

                contentStream.beginText(); 
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 10);
                contentStream.moveTextPositionByAmount(130, 30);
                contentStream.drawString(pNome);
                contentStream.moveTextPositionByAmount(0, -10);
                contentStream.drawString(myString2);
                contentStream.endText();
                
                contentStream.close();
            }
            System.out.println(".");
        } catch (Exception e)
        {
            System.out.println("stampPages error: " + e.toString());
        }
        return true;
    }
    
    public boolean closeSource ()
    {
        try
        {
            sourcePDF.close();
            if (agency != null)
                agency.close();
            return true;
        } catch (Exception e)
        {
            System.out.println("closeSource ERROR: " + e.toString());
            return false;
        }
    }
    public boolean closeTarget ()
    {
        try
        {
            targetPDF.close();
            return true;
        } catch (Exception e)
        {
            System.out.println("closeTarget ERROR: " + e.toString());
            return false;
        }
    }
    
    public boolean saveSource (String newName)
    {
        System.out.println("saveSource: " + newName);
        try
        {
            sourcePDF.save(newName);

            return true;
        } catch (Exception e)
        {
            System.out.println("saveSource ERROR: " + e.toString());
            return false;
        }
    }
    public boolean saveTarget (String newName)
    {
        System.out.println("saveTarget: " + newName);
        try
        {
            targetPDF.save(newName);

            return true;
        } catch (Exception e)
        {
            System.out.println("saveTarget ERROR: " + e.toString());
            return false;
        }
    } 
    
            
    /*public boolean addPage (String pPicture)
    {
        System.out.println("addPage ");
        PDPage page = new PDPage();
        try
        {
            BufferedImage awtImage = ImageIO.read( new File( pPicture ) );
            PDImageXObject  pdImageXObject = LosslessFactory.createFromImage(inputPDF, awtImage);
            PDPageContentStream contentStream = new PDPageContentStream(inputPDF, new PDPage(), true, false);
            contentStream.drawImage(pdImageXObject, 200, 300, awtImage.getWidth() / 2, awtImage.getHeight() / 2);
            contentStream.close();
            inputPDF.addPage(page);
            System.out.println("addPage DONE");
            return true;
        } catch (Exception io){
            System.out.println("addPage ERROR: " + io.toString());
            return false;
        }
    }
    
    public boolean addPage2 (String pPicture)
    {
        System.out.println("addPage2 ");
        PDPage page = new PDPage();
        inputPDF.addPage(page);

        try
        {
            BufferedImage awtImage = ImageIO.read( new File(pPicture) );
            PDImageXObject  pdImageXObject = LosslessFactory.createFromImage(inputPDF, awtImage);
            PDPageContentStream contentStream = new PDPageContentStream(inputPDF, new PDPage(), true, false);
            contentStream.drawImage(pdImageXObject, 500, 500, awtImage.getWidth() / 2, awtImage.getHeight() / 2);
            contentStream.close();
            
            System.out.println("addPage2 DONE");
            return true;
        } catch (Exception io){
            System.out.println("addPage2 ERROR: " + io.toString());
            return false;
        }
    }
    */
}
