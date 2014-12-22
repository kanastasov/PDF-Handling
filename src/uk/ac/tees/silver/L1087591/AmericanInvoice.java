
package uk.ac.tees.silver.L1087591;

/** 
  <p>   This package contains the solution to the creation of pdf files dynamically for Invoices. </p>
  <p>   AmericanInvoice is responsible for the necessary details about the American invoice.  </p>
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


public class AmericanInvoice implements InvoicingAlgorithm
{

    /** Path to the resulting PDF file. */
    public static final String RESULT
        = "src\\uk\\ac\\tees\\silver\\L1087591/AmericanInvoice.pdf";
    
    /**
     * @param magicAmerican represent the difference between dollar and pound
     */
    final double magicAmerican = 1.57;
    
    /** AmericanInvoice()is a 
     *  default constructor.
     */
    AmericanInvoice()
    {
        
    }
  
    @Override
    public String getInvoice(String name, double amount) 
    {
        amount *= magicAmerican;
        final DecimalFormat df = new DecimalFormat("#.00");
        final String oracleDescription = "Applications\n" +
"Earning Oracle Applications Certifications not only gives you credibility among "
                 + "your peers and hiring managers; you'll also gain the knowledge"
                 + " and skills to save time and resources by implementing and using"
                 + " cutting-edge Oracle Applications. Choose from more than 64 "
                 + "Oracle Applications Certifications in areas ranging from Siebel,"
                 + " to Oracle eBusiness Suite to PeopleSoft and more."
                 + " \n --------------------------------------"
                 + "\n Agile\n" +
"Earning Oracle Agile Certifications proves your expertise in using product lifecycle"
                + " management solutions. Learn how these certifications demonstrate "
                + "your ability to manage information, processes and decisions about "
                + "your company's products."  + " \n --------------------------------------";
         final String total = "--------------------------------------\n TO:   "
              + name + " \n FROM: Easyflap (UK) \n AMOUNT"  + ":$" 
                + df.format(amount) 
              + " \n --------------------------------------" + " \n" + oracleDescription;
         
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
