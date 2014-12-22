package uk.ac.tees.silver.L1087591;

/** 
  <p>   This package contains the solution to the creation of pdf files dynamically for Invoices. </p>
  <p>   EuropeanInvoice is responsible for the necessary details about the European invoice.  </p>
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

public class EuropeanInvoice implements InvoicingAlgorithm
{

    
    /** Path to the resulting PDF file. */
    public static final String RESULT
        = "src\\uk\\ac\\tees\\silver\\L1087591/EuropeanInvoice.pdf";
    
    /**
     * @param magicEuropean represent the difference between pound and euro
     */
    final double magicEuropean = 1.14;
    
    /**
     * EuropeanInvoice() 
     *  a default constructor
     */
    public EuropeanInvoice()
    {
        
    }
     
    @Override
    public String getInvoice(String name, double amount) 
    {
        final char euro = '\u20AC';
        amount *= magicEuropean;
        System.out.println(euro);
        final DecimalFormat df = new DecimalFormat("#.00");
       
        final String siemensDescription = "Siemens honors the twelve \"Inventors"
                + " of the Year\" 2014\n" 
                + "Twelve Siemens researchers and developers were honored by Siemens as Inventors"
                + " of the Year 2014 in Munich on December 3. They come from Germany"
                + ", the U.S., Denmark and China and together they account for more"
                + " than 900 inventions and 842 granted individual patents. In fiscal"
                + " 2014, Siemens filed 4,300 patent applications – a year-over-year "
                + "increase of nine percent. In addition, the company intends to boost"
                + " investments in research and development (R&D) by around €400 million."
                + " In fiscal 2014, R&D expenditures totaled roughly €4 billion.\n"                
                + "Siemens has been presenting the Inventors of the Year award annually since 1995 to honor"
                + " the organization's outstanding researchers and developers whose inventions"
                + " make major contributions to the company's success.";
   
               
        
          final String total = "--------------------------------------\n TO:   "
              + name + " \n FROM: Easyflap (UK) \n AMOUNT"  + ":" + euro 
                + df.format(amount) 
              + " \n --------------------------------------"  + "\n" +siemensDescription;
        System.out.println(total);
        
        
        
        // step 1
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
