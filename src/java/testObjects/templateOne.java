/*
 *Julian A Plasencia
 *invoice project 
 *
 *one template used to create and add text to pdf file. some var will be replaced with var from actual site.
 */
package testObjects;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import static testObjects.PdfTest.doc;


public class templateOne {
    public void dateBox(PDPageContentStream content) throws IOException{ //box of date
        int l = 512;
        int r = 587;
        int t = 775;
        int b = 750;
        content.beginText();
        content.newLineAtOffset(485, 759);
        content.setFont(PDType1Font.TIMES_ROMAN, 12);
        content.showText("Date");
        content.endText();
        //left
        content.setLineWidth(1);
        content.addLine(l, t, l, b);
        content.closeAndStroke();
        //right
        content.setLineWidth(1);
        content.addLine(r, t, r, b);
        content.closeAndStroke();
        //top
        content.setLineWidth(1);
        content.addLine(l, t, r, t);
        content.closeAndStroke();
        //bottom
        content.setLineWidth(1);
        content.addLine(l, b, r, b);
        content.closeAndStroke();
        System.out.println("DateBox has been added");
    }
    public void dateText(PDPageContentStream content) throws IOException{ //current date added to pdf
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	LocalDate localDate = LocalDate.now();
	System.out.println(dtf.format(localDate));
        String d = (dtf.format(localDate));
        
        content.beginText();
        content.newLineAtOffset(517, 758);
        content.setFont(PDType1Font.TIMES_ROMAN, 12);
        content.showText(d);
        content.endText();
        
    }
    public void userInfoBox(PDPageContentStream content) throws IOException{ //box created to hold user's info
        int l = 181;
        int r = 431;
        int t = 750;
        int b = 650;
        //left side
        content.setLineWidth(1);
        content.addLine(l, t, l, b);
        content.closeAndStroke();

        //right side
        content.setLineWidth(1);
        content.addLine(r, t, r, b);
        content.closeAndStroke();
        
        //top 
        content.setLineWidth(1);
        content.addLine(l, t, r, t);
        content.closeAndStroke();
        //bottom
        content.setLineWidth(1);
        content.addLine(l, b, r, b);
        content.closeAndStroke();
        System.out.println("userInfoBox has been added");
    }
    public void userText(PDPageContentStream content, data d)throws IOException{ //add test to user's box
        content.beginText();
        content.newLineAtOffset(186, 733);
        content.setFont(PDType1Font.TIMES_ROMAN, 12);
        content.showText(d.userName);
        content.endText();
        
        content.beginText();
        content.newLineAtOffset(186, 708);
        content.setFont(PDType1Font.TIMES_ROMAN, 12);
        content.showText(d.userStreet);
        content.endText();
        
        content.beginText();
        content.newLineAtOffset(186, 695);
        content.setFont(PDType1Font.TIMES_ROMAN, 12);
        content.showText(d.userCity+" "+d.userState+" "+d.userZip);
        content.endText();
        
        content.beginText();
        content.newLineAtOffset(186, 673);
        content.setFont(PDType1Font.TIMES_ROMAN, 12);
        content.showText(d.userPhone);
        content.endText();
        
        content.beginText();
        content.newLineAtOffset(186, 660);
        content.setFont(PDType1Font.TIMES_ROMAN, 12);
        content.showText(d.userEmail);
        content.endText();
        
    }
    public void custJobBox(PDPageContentStream content) throws IOException{ //created boxs for customer's info and customer's or job address.
        int l = 25;
        int r = 587;
        int t = 625;
        int b = 475;
        int c = 306;
        content.beginText();
        content.newLineAtOffset(30, 603);
        content.setFont(PDType1Font.TIMES_ROMAN, 18);
        content.showText("Customer Infomation");
        content.endText();
        //left
        content.setLineWidth(1);
        content.addLine(l, t, l, b);
        content.closeAndStroke();
        //right
        content.setLineWidth(1);
        content.addLine(r, t, r, b);
        content.closeAndStroke();
        //top
        content.setLineWidth(1);
        content.addLine(l, t, r, t);
        content.closeAndStroke();
        //bottom
        content.setLineWidth(1);
        content.addLine(l, b, r, b);
        content.closeAndStroke();
        //center line
        content.setLineWidth(1);
        content.addLine(c, t, c, b);
        content.closeAndStroke();
        
        content.beginText();
        content.newLineAtOffset(311, 603);
        content.setFont(PDType1Font.TIMES_ROMAN, 18);
        content.showText("Job Address");
        content.endText();
        System.out.println("custJobBox has been added");
    }
    public void custJobtext(PDPageContentStream content, data d) throws IOException{ //add test to ustomer's info and customer's or job address
        content.beginText();
        content.newLineAtOffset(30, 565);
        content.setFont(PDType1Font.TIMES_ROMAN, 15);
        content.showText(d.custName);
        content.endText();
        
        content.beginText();
        content.newLineAtOffset(30, 545);
        content.setFont(PDType1Font.TIMES_ROMAN, 15);
        content.showText(d.custPhone);
        content.endText();
        
        content.beginText();
        content.newLineAtOffset(30, 530);
        content.setFont(PDType1Font.TIMES_ROMAN, 15);
        content.showText(d.custEmail);
        content.endText();
        
        content.beginText();
        content.newLineAtOffset(311, 565);
        content.setFont(PDType1Font.TIMES_ROMAN, 15);
        content.showText(d.jobStreet);
        content.endText();
        
        content.beginText();
        content.newLineAtOffset(311, 550);
        content.setFont(PDType1Font.TIMES_ROMAN, 15);
        content.showText(d.jobCity+" "+d.jobState+" "+d.jobZip);
        content.endText();
    }
    public void tableRowNameBox(PDPageContentStream content) throws IOException{ // creates row with all the columns' name
        int l = 25;
        int r0 = 437;
        int r1 = 512;
        int r2 = 587;
        int t = 425;
        int b = 400;
        
        //table
        //desc
        content.beginText();
        content.newLineAtOffset(30, 409);
        content.setFont(PDType1Font.TIMES_ROMAN, 12);
        content.showText("Description");
        content.endText();
        //left
        content.setLineWidth(1);
        content.addLine(l, t, l, b);
        content.closeAndStroke();
        //right
        content.setLineWidth(1);
        content.addLine(r0, t, r0, b);
        content.closeAndStroke();
        //top
        content.setLineWidth(1);
        content.addLine(l, t, r0, t);
        content.closeAndStroke();
        //bottom
        content.setLineWidth(1);
        content.addLine(l, b, r0, b);
        content.closeAndStroke();
        //table
        //amount
        content.beginText();
        content.newLineAtOffset(442, 409);
        content.setFont(PDType1Font.TIMES_ROMAN, 12);
        content.showText("Quantity");
        content.endText();
        //right
        content.setLineWidth(1);
        content.addLine(r1, t, r1, b);
        content.closeAndStroke();
        //top
        content.setLineWidth(1);
        content.addLine(r0, t, r1, t);
        content.closeAndStroke();
        //bottom
        content.setLineWidth(1);
        content.addLine(r0, b, r1, b);
        content.closeAndStroke();
        //table
        //price
        content.beginText();
        content.newLineAtOffset(517, 409);
        content.setFont(PDType1Font.TIMES_ROMAN, 12);
        content.showText("Price");
        content.endText();

        //right
        content.setLineWidth(1);
        content.addLine(r2, t, r2, b);
        content.closeAndStroke();
        //top
        content.setLineWidth(1);
        content.addLine(r1, t, r2, t);
        content.closeAndStroke();
        //bottm
        content.setLineWidth(1);
        content.addLine(r1, b, r2, b);
        content.closeAndStroke();
        System.out.println("tableRowNameBox has been added");
    }
    public void itemList(PDPageContentStream content) throws IOException{ //add text from an array to the table in the pdf. limit is 25 itmes. breaks when a 3rd page is added.
        int text = 375;
        int l = 25;
        int r0 = 437;
        int r1 = 512;
        int r2 = 587;
        int t = 400;
        int b = 360;
        int total = 0;
        int Quantity = 0;
        ArrayList<String[]> outerArr = new ArrayList<String[]>();  /////////////////might be replaced
        ///////////////////////////////
        //all of this was just used to test this method. all will be removed
        String[] myString1= {"This is what i did for the job.","1","100"};  
        String[] myString2= {"This is what i did for the job.","2","200"};  
        String[] myString3= {"This is what i did for the job.","3","300"};
        String[] myString4= {"This is what i did for the job.","4","400"};
        String[] myString5= {"This is what i did for the job.","5","500"};
        String[] myString6= {"This is what i did for the job.","6","600"};
        String[] myString7= {"This is what i did for the job.","7","700"};
        String[] myString8= {"This is what i did for the job.","8","800"};
        String[] myString9= {"This is what i did for the job.","9","900"};
        String[] myString10= {"This is what i did for the job.","10","1000"};
        String[] myString11= {"This is what i did for the job.","11","1100"};
        String[] myString12= {"This is what i did for the job.","12","1200"};
        String[] myString13= {"This is what i did for the job.","13","1300"};
        String[] myString14= {"This is what i did for the job.","14","1400"};
        String[] myString15= {"This is what i did for the job.","15","1500"};
        String[] myString16= {"This is what i did for the job.","16","1600"};
        String[] myString17= {"This is what i did for the job.","17","1700"};
        String[] myString18= {"This is what i did for the job.","18","1800"};
        String[] myString19= {"This is what i did for the job.","19","1900"};
        
        
        outerArr.add(myString1);
        outerArr.add(myString2);
        outerArr.add(myString3);
        outerArr.add(myString4);
        outerArr.add(myString5);
        outerArr.add(myString6);
        outerArr.add(myString7);
        outerArr.add(myString8);
        outerArr.add(myString9);
        outerArr.add(myString10);
        outerArr.add(myString11);
        outerArr.add(myString12);
        outerArr.add(myString13);
        outerArr.add(myString14);
        outerArr.add(myString15);
        outerArr.add(myString16);
        outerArr.add(myString17);
        outerArr.add(myString18);
        outerArr.add(myString19);
        outerArr.add(myString2);
        outerArr.add(myString2);
        outerArr.add(myString2);
        ///////////////////////////////////////////////
        for(int i=0;i<outerArr.size();i++){//creates all the cell that will be needed
                //items
                //left
                content.setLineWidth(1);
                content.addLine(l, t, l, b);
                content.closeAndStroke();
                //right
                //content.setLineWidth(1);
                //content.addLine(r0, t, r0, b);
                //content.closeAndStroke();
                //bottom
                content.setLineWidth(1);
                content.addLine(l, b, r0, b);
                content.closeAndStroke();
                //item
                //amount
                //left
                content.setLineWidth(1);
                content.addLine(r0, t, r0, b);
                content.closeAndStroke();
                //right
                content.setLineWidth(1);
                content.addLine(r1, t, r1, b);
                content.closeAndStroke();
                //bottom
                content.setLineWidth(1);
                content.addLine(r0, b, r1, b);
                content.closeAndStroke();
                //table
                //price
                //left
                content.setLineWidth(1);
                content.addLine(r1, t, r1, b);
                content.closeAndStroke();
                //right
                content.setLineWidth(1);
                content.addLine(r2, t, r2, b);
                content.closeAndStroke();
                //bottm
                content.setLineWidth(1);
                content.addLine(r1, b, r2, b);
                content.closeAndStroke();
                
                
                String[] myString= new String[3]; /////////////////creates another array to add text into each cell in the table.
                myString=outerArr.get(i);
                
                content.beginText();
                content.newLineAtOffset(30, text);
                content.setFont(PDType1Font.TIMES_ROMAN, 12);
                content.showText(myString[0]);
                content.endText();

                content.beginText();
                content.newLineAtOffset(447, text);
                content.setFont(PDType1Font.TIMES_ROMAN, 12);
                content.showText(myString[1]);
                content.endText();

                content.beginText();
                content.newLineAtOffset(521, text);
                content.setFont(PDType1Font.TIMES_ROMAN, 12);
                content.showText(myString[2]);
                content.endText();
                
                int num;/////////////cals the total of all the items in the table.
                Quantity = Integer.parseInt(myString[1]);
                num = Quantity * Integer.parseInt(myString[2]);
                total = total + num;
                System.out.println("--------------------"+total);
                b = b - 40;
                text = text - 40; 
                System.out.println(b + " Last number");
                //////////////////////
                //addes another page to pdf when bottom of the first page is reached.
                // breaks if pdf need more the 2 pages.
                //needs to be fixed
                if (b < 40 ){
                    text = 757;
                    t = 782;
                    b = 742;
                
                    PDPage p2 = new PDPage();
                    PdfTest.doc.addPage(p2);
                    PDPageContentStream page2 = new PDPageContentStream(doc, p2);
                    content = page2;
                    System.out.println("This is only one page. It think"); 
                }
        }
        System.out.println("-----final-------"+total);
        //note
        note(content, total);
        content.close();
    }
    public void note(PDPageContentStream content, int t) throws IOException{//this will later take a string
        content.beginText();
        content.newLineAtOffset(25, 50);
        content.setFont(PDType1Font.TIMES_ROMAN, 12);
        //content.setNonStrokingColor(Color.RED);
        content.showText("Note:");
        content.endText();
        //tolal text
        System.out.println("Note has been added");
        content.beginText();
        content.newLineAtOffset(450, 40);
        content.setFont(PDType1Font.TIMES_ROMAN, 18);
        content.showText("Total:");
        content.endText();
        
        content.beginText();
        content.newLineAtOffset(500, 40);
        content.setFont(PDType1Font.TIMES_ROMAN, 20);
        content.showText("$"+t);
        content.endText();
    }
    //testing word wrapping. this will later be its own class.
    public void wordWrap(int x, int y, String text){
        /*
        ??????????Two Lines?????????????????????????
        content.beginText();
        content.newLineAtOffset(30, 385);
        content.setFont(PDType1Font.TIMES_ROMAN, 12);
        content.showText("This is what i did for the job.");
        content.endText();
        content.beginText();
        content.newLineAtOffset(30, 365);
        content.setFont(PDType1Font.TIMES_ROMAN, 12);
        content.showText("This is what i did for the job.");
        content.endText();
        */
    }
}
