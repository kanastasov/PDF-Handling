package uk.ac.tees.silver.L1087591;
/** 
  <p>   This package contains the solution to the creation of pdf files dynamically for Invoices. </p>
  <p>   JapaneseInvoice is responsible for the necessary details about the Japanese invoice.  </p>
  <p>   This program is in development. Some of the main things to be added are files reading & multithreading.</p>
  
 <p>Invoices-SOLUTION is free software: you can redistribute it and/or
 modify it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or (at your
 option) any later version.</p>
 	
 <p>This program is distributed in the hope that it will be useful, but
 WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 details.</p>
 
 <p>You should have received a copy of the GNU General Public License along
 with this program. If not, see http://www.gnu.org/licenses/.</p>
 
 <p>Copyright Kiril Anastasov L1087591@live.tees.ac.uk   November-2014 </p>
 */
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JapaneseInvoice implements InvoicingAlgorithm
{

    
    /** Path to the resulting PDF file. */
    public static final String RESULT
        = "src\\uk\\ac\\tees\\silver\\L1087591/JapaneseInvoice.pdf";
    
    /**
     * @param magicSamurai represents the difference between the pound and the yenni
     */
     final double magicSamurai = 121;
     
    /**JapaneseInvoice() is a default constructor.
     */
    public JapaneseInvoice()
    {
        
    }
    //Uk: japan 1 : 121
    @Override
    public String getInvoice(String name, double amount) 
    {
        
         final char iena = '\u00A5';
        amount *= magicSamurai;
        System.out.println(iena);
        final DecimalFormat df = new DecimalFormat("#.00");
      
        final String hondaDescription = "Honda engines are developed, tested and"
                + " certified with petroleum based motor oils as a lubricant. "
                + "Synthetic oils may be used; however, any motor oil used in our"
                + " engines must meet all oil requirements as stated in the owner"
                + "’s manual. In addition, recommended oil change intervals must be followed."
                + " Honda engines are designed and certified to run on regular unleaded gasoline containing no more than 10% ethanol (E10)."
                + "Gasoline is allowed, by regulation, to contain a variety of additives. The same regulation limits how much of some additives, such as alcohol, can be included in the fuel and still allow it to be sold as gasoline. If you look in a Honda product owner’s manual, you will see that a maximum of 10% ethanol is allowed (other oxygenates are also listed). Honda engines are designed for good performance and efficient operation using gasoline containing from 0 to 10% ethanol."
                + "E85, a mixture of 85% ethanol and 15% gasoline, has been in the news recently. E85 is an alternative fuel; it is not gasoline. Honda engines are not certified or designed to run on E85 or any other alternative fuel."
                + "Always refer to the owner’s manual for your Honda to get a list of recommended fuel and the current approved additives.";

        final String total = "--------------------------------------\n TO:   "
              + name + " \n FROM: Easyflap (UK) \n AMOUNT"  + ":" + iena
                + df.format(amount) 
              + " \n --------------------------------------" + "\n " + hondaDescription + 
                " \n --------------------------------------\n";
        System.out.println(total);
         
         
         
         //step1
         final Document document = new Document();
        try {
            try {
                // step 2
                PdfWriter.getInstance(document, new FileOutputStream(RESULT));
            } catch (DocumentException ex) {
                Logger.getLogger(AmericanInvoice.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AmericanInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }
        // step 3
        document.open();
        try {
            // step 4
            document.add(new Paragraph(total));
        } catch (DocumentException ex) {
            Logger.getLogger(AmericanInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }
        // step 5
        document.close();
        
        
         return total;
    }
}
    
    

