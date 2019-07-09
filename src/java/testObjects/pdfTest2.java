/*
Creates a table. might use this to make a single cell.
 */
package testObjects;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
public class pdfTest2 {

    /**
 * @param page
 * @param contentStream
 * @param y the y-coordinate of the first row
 * @param margin the padding on left and right of table
 * @param content a 2d array containing the table data
 * @throws IOException
 */
public static void drawTable(PDPage page, PDPageContentStream contentStream,
                            float y, float margin,
                            String[][] content) throws IOException {
    final int rows = content.length;
    final int cols = content[0].length;
    final float rowHeight = 20f;
    final float tableWidth = page.getMediaBox().getWidth()-(2*margin);
    final float tableHeight = rowHeight * rows;
    final float colWidth = tableWidth/(float)cols;
    final float cellMargin=5f;
 
    //draw the rows
    float nexty = y ;
    for (int i = 0; i <= rows; i++) {
        contentStream.drawLine(margin,nexty,margin+tableWidth,nexty);
        nexty-= rowHeight;
    }
 
    //draw the columns
    float nextx = margin;
    for (int i = 0; i <= cols; i++) {
        contentStream.drawLine(nextx,y,nextx,y-tableHeight);
        nextx += colWidth;
    }
 
    //now add the text
    contentStream.setFont(PDType1Font.HELVETICA_BOLD,12);
 
    float textx = margin+cellMargin;
    float texty = y-15;
    for(int i = 0; i < content.length; i++){
        for(int j = 0 ; j < content[i].length; j++){
            String text = content[i][j];
            contentStream.beginText();
            contentStream.moveTextPositionByAmount(textx,texty);
            contentStream.drawString(text);
            contentStream.endText();
            textx += colWidth;
        }
        texty-=rowHeight;
        textx = margin+cellMargin;
    }
    
}
    public static void main(String[] args) throws IOException {
        PDDocument doc = new PDDocument();
    PDPage page = new PDPage();
    doc.addPage( page );
 
    PDPageContentStream contentStream =
                    new PDPageContentStream(doc, page);
 
    String[][] content = {{"a","b", "1"},
                          {"c","d", "2"},
                          {"e","f", "3"},
                          {"g","h", "4"},
                          {"i","j", "5"}} ;
 
    drawTable(page, contentStream, 700, 100, content);
    contentStream.close();
    doc.save("test.pdf" );
        /*System.out.println("Create Simple PDF file with blank Page");
        
        String fileName = "EmptyPdf.pdf"; // name of our file
        int line = 0;
        
        
        try{
        
        PDDocument doc = new PDDocument(); // creating instance of pdfDoc
        PDPage page = new PDPage();
        PDRectangle rect = page.getMediaBox();
        doc.addPage(page); // adding page in pdf doc file
        PDFont fontPlain = PDType1Font.HELVETICA;
        PDPageContentStream stuff = new PDPageContentStream(doc, page);
        
        stuff.beginText();
        stuff.setFont(fontPlain, 12);
        stuff.newLineAtOffset(100, rect.getHeight() - 50*(++line));
        stuff.showText("Hello World");
        stuff.endText();
                
        stuff.setLineWidth(1);
        stuff.moveTo(200, 250);
        stuff.lineTo(400, 250);
        stuff.closeAndStroke();
        stuff.setLineWidth(5);
        stuff.moveTo(200, 300);
        stuff.lineTo(400, 300);
        stuff.closeAndStroke();
        
        stuff.beginText();
        stuff.newLineAtOffset(25, 500);
        stuff.setFont(PDType1Font.TIMES_ROMAN, 26);
        stuff.showText("Registration Form");
        stuff.endText();
        
        stuff.close();
        doc.save(fileName); // saving as pdf file with name perm 
        
        doc.close(); // cleaning memory 
        
        System.out.println("your file created in : "+ System.getProperty("user.dir"));
        
        
        }
        catch(IOException e){
        System.out.println(e.getMessage());
    //more text
        stuff.beginText();
        stuff.setFont(fontPlain, 12);
        stuff.newLineAtOffset(100, rect.getHeight() - 50*(++line));
        stuff.showText("Hello World");
        stuff.endText();
        //line in difent sizes  
        stuff.setLineWidth(1);
        stuff.moveTo(200, 250);
        stuff.lineTo(400, 250);
        stuff.closeAndStroke();
        stuff.setLineWidth(5);
        stuff.moveTo(200, 300);
        stuff.lineTo(400, 300);
        stuff.closeAndStroke();
        }*/
    }
}
