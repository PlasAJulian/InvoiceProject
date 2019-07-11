/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testObjects;
import java.awt.Color;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
public class PdfTest {
    public static PDDocument doc;
    public PDDocument getDoc(){
        return doc;
    }
    public static void main(String[] args) throws IOException {
        System.out.println("Create Simple PDF file with blank Page");
        
        String fileName = "EmptyPdf.pdf"; // name of our file
        templateOne t1 = new templateOne();
        data d = new data();
        try{
        doc = new PDDocument(); // creating instance of pdfDoc
        PDPage page = new PDPage();
        doc.addPage(page); // adding page in pdf doc file
        PDPageContentStream stuff = new PDPageContentStream(doc, page); //needed to add content to page
        //////////////////////////////////////////////////////
        //Your info
        t1.userInfoBox(stuff);
        t1.userText(stuff);
        //////////////////////////////////////////////////////
        //Cust and job info
        t1.custJobBox(stuff);
        t1.custJobtext(stuff, d);
        ////////////////////////////////////
        //date
        t1.dateBox(stuff);
        t1.dateText(stuff);
        ////////////////////////////////////////
        //table
        t1.tableRowNameBox(stuff);
        ///////////////////////////////////////////////////
        //items
        t1.itemList(stuff);
        ////////////////////////////
        System.out.println(page.getMediaBox().getHeight());
        System.out.println(page.getMediaBox().getWidth());
        stuff.close();
        doc.save(fileName); // saving as pdf file with name perm 
        
        doc.close(); // cleaning memory 
        
        System.out.println("your file created in : "+ System.getProperty("user.dir"));
        
        
        }
        catch(IOException e){
        System.out.println(e.getMessage());
        }
    }
    
}
