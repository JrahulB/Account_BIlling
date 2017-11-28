/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account_billing;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author ACER
 */
public class PrintInvoice extends JFrame {
    JPanel controlPanel;
    JLabel label ;
    public PrintInvoice(String cus1,String billno,String ntot,String date) throws ClassNotFoundException, SQLException{
          // create JFrame and JTable
        JFrame frame = new JFrame();
        controlPanel = new JPanel();
		frame.add(controlPanel);
		controlPanel.setVisible(true);
		controlPanel.setBounds(50, 50, 500, 600);
                frame.setVisible(false);
                JScrollPane jsp = new JScrollPane(controlPanel);
                frame.add(jsp);
                 StringBuilder table = new StringBuilder();
                try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			Statement stm = c.createStatement();
               
		table.append("<HTML><head>");
               table.append(" <style>");
                table.append("table, th, td {"); 
                table.append("border: 1px solid black;");
                table.append("border-collapse: collapse;");
                table.append("}");
                table.append( "th, td {");
                table.append("    padding: 1px;");
                table.append("    text-align: left;");
                table.append("}");
                table.append("</style></head><body>");
                
                table.append("<table style=\"width:100%\">");//width=\"100%\" border=\"1\" cellspacing=\"1\"  cellpadding=\"1\" >");
               PreparedStatement ps1 = c.prepareStatement("select * from shop_details");
                            ResultSet rs = ps1.executeQuery();
                            while(rs.next())
                            {
                                table.append("<tr>");
                                    table.append("<th colspan=\"13\" align=\"center\">"+rs.getString("name")+" <br> "+rs.getString("address")+" </th>");
                                table.append("</tr>");
                            }
                table.append("<tr>");
                    table.append("<th colspan=\"13\" align=\"center\">TAX INVOICE </th>");
                table.append("</tr>");
                
                table.append("</tr>");
                       //table.append(" <td>");
                        table.append("<td colspan=\"6\"> ");
                        table.append("<strong>Invoice No:"+billno+"</strong>");
                        //table.append("  ");
                        table.append("</td>");
                        
                        table.append("<td colspan=\"7\"> ");
                        table.append("<strong>Transport Mode:</strong>");
                        table.append("  ");
                        table.append("</td>");
                table.append("</tr>");
                table.append("</tr>");
                       table.append(" <tr>");
                        table.append("<td colspan=\"6\"> ");
                        table.append("<strong>Invoice date:"+date+"</strong>");
                        table.append("  ");
                        table.append("</td>");
                        
                        table.append("<td colspan=\"7\"> ");
                        table.append("<strong>Vehicle No:</strong>");
                        table.append("  ");
                        table.append("</td>");
                table.append("</tr>");
                table.append("</tr>");
                       table.append(" <tr>");
                        table.append("<td colspan=\"6\"> ");
                        table.append("<strong>Reverse Charges(Y/N):</strong>");
                        table.append("  ");
                        table.append("</td>");
                        
                        table.append("<td colspan=\"7\"> ");
                        table.append("<strong>Date Of supply:</strong>");
                        table.append("  ");
                        table.append("</td>");
                table.append("</tr>");
                table.append("</tr>");
                       table.append(" <tr>");
                        table.append("<td colspan=\"6\"> ");
                        table.append("<strong>State: </strong>");
                        table.append("</td>");
                        table.append("<td colspan=\"7\"> ");
                        table.append("<strong>Place Of Supply:</strong>");
                        table.append("  ");
                        table.append("</td>");
                table.append("</tr>");
                
                table.append("<tr>");
                        table.append("<th colspan=\"6\" align=\"center\">Bill To Party</th>");
                        table.append("<th colspan=\"7\" align=\"center\">Ship To Party</th>");
                       table.append("</tr>");
                       table.append(" <tr>");
                        table.append("<td colspan=\"6\"> ");
                        table.append("<strong>Name:"+cus1+"</strong>");
                        table.append("  ");
                        table.append("</td>");
                        
                        table.append("<td colspan=\"7\"> ");
                        table.append("<strong>Name:</strong>");
                        table.append("  ");
                        table.append("</td>");
                        
                        table.append(" </tr>");
                       table.append(" <tr>");
                        PreparedStatement ps4 = c.prepareStatement("select address from customer where name='"+cus1+"'");
                        ResultSet rs4 = ps4.executeQuery();
                         while(rs4.next())
                          {
                            table.append("<td colspan=\"6\"> ");
                            table.append("<strong>Address:"+rs4.getString("address")+"</strong>");
                            table.append("</td>");
                           }
                        table.append("<td colspan=\"7\"> ");
                        table.append("<strong>Address:</strong>");
                        table.append("</td>");
                        
                       table.append(" </tr>");
                       table.append(" <tr>");
                        PreparedStatement ps5 = c.prepareStatement("select gst from customer where name='"+cus1+"'");
                        ResultSet rs5 = ps5.executeQuery();
                         while(rs5.next())
                          {
                            table.append("<td colspan=\"6\"> ");
                            table.append("<strong>GSTIN:"+rs5.getString("gst")+"</strong>");
                            table.append("</td>");
                          }
                         table.append("<td colspan=\"7\"> ");
                        table.append("<strong>GSTIN:</strong>");
                        table.append("  ");
                        table.append("</td>");
                        
                       table.append(" </tr>");
                       table.append(" <tr>");
                        PreparedStatement ps6 = c.prepareStatement("select state from account where name='"+cus1+"'");
                        ResultSet rs6 = ps6.executeQuery();
                        while(rs6.next())
                         {
                            table.append("<td colspan=\"6\"> ");
                            table.append("<strong>State:"+rs6.getString("state")+"</strong>");
                            table.append("</td>");
                         }
                        table.append("<td colspan=\"7\"> ");
                        table.append("<strong>State:</strong>");
                        table.append("  ");
                        table.append("</td>");
                        
                       table.append(" </tr>");
                    table.append("<tr>");
                        table.append("<th colspan=\"13\"></th>");
                    table.append("</tr>");
                table.append("<tr>");
                    table.append("<th>Sr.No</th>");
                    table.append("<th >Product Description</th>");
                    table.append("<th >HSN Code</th>");
                    table.append("<th>QTY</th>");
                    table.append("<th>Rate</th>");
                    table.append("<th>Discount</th>");
                    table.append("<th>Taxable Value</th>");
                    table.append("<th colspan=\"2\" align=\"center\">GST</th>");
                    table.append("<th colspan=\"2\" align=\"center\">CGST</th>");
                    table.append("<th>Total</th>");
                table.append("</tr>");
                   table.append("<td>");
                    table.append("<th colspan=\"6\"></th>");
                    table.append("<th>Price</th>");
                    table.append("<th>Amount</th>");
                    table.append("<th>Price</th>");
                    table.append("<th>Amount</th>");
                    table.append("<th></th>");
                  table.append("</td>");
               
                    PreparedStatement ps11 = c.prepareStatement("select * from invoice where srno='"+billno+"'and name='"+cus1+"'");
				ResultSet rs11 = ps11.executeQuery();
				while(rs11.next()){
                     table.append("<tr>");                
                    table.append("<td>1</td>");
                    table.append("<td>"+rs11.getString("items")+"</td>");
                    table.append("<td>"+rs11.getString("hsn_code")+"</td>");
                    table.append("<td>"+rs11.getString("quantity")+"</td>");
                    table.append("<td>"+rs11.getString("rate")+"</td>");
                     table.append("<td> </td>");
                    table.append("<td>"+rs11.getString("total")+"</td>");
                    table.append("<td>"+rs11.getString("cgst_rate")+"</td>");
                    table.append("<td>"+rs11.getString("cgst")+"</td>");
                    table.append("<td>"+rs11.getString("sgst_rate")+"</td>");
                    table.append("<td>"+rs11.getString("sgst")+"</td>");
                    table.append("<td>5</td>");
                     table.append("</tr>");
                                }      
                        PreparedStatement ps12 = c.prepareStatement("select * from total where srno='"+billno+"'and name='"+cus1+"'");
                        ResultSet rs12 = ps12.executeQuery();
                        while(rs12.next()){
                         table.append("<tr>");
                        table.append("<th colspan=\"3\" align=\"center\">Total</th>");
                            table.append("<td>"+rs12.getString("total_qty")+" </td>");
                            table.append("<td> "+rs12.getString("total_rate")+"</td>");
                            table.append("<td> </td>");
                            table.append("<td>"+rs12.getString("net_total")+" </td>");
                            table.append("<td>"+rs12.getString("c_rate")+" </td>");
                            table.append("<td>"+rs12.getString("total_amount")+" </td>");
                            table.append("<td> "+rs12.getString("s_rate")+"</td>");
                            table.append("<td> "+rs12.getString("s_amount")+" </td>");
                            table.append("<td>"+rs12.getString("net_total")+" </td>");
                         table.append("</tr>");
                      }
                    table.append("<tr>");
                        table.append("<th colspan=\"7\" align=\"center\">Total Invoice amount in Words</th>");
                        PreparedStatement ps15 = c.prepareStatement("select * from total where srno='"+billno+"'and name='"+cus1+"'");
                        ResultSet rs15 = ps15.executeQuery();
                        while(rs15.next()){
                         table.append("<th colspan=\"4\" align=\"center\">Total amount before Tax</th>");
                        table.append("<td>"+rs15.getString("net_total")+"</td>");
                        }
                    table.append("</tr>");
                    table.append("<tr>");
                        table.append("<td ROWSPAN=\"4\" colspan=\"7\" align=\"center\"></td>");
                        PreparedStatement ps13 = c.prepareStatement("select * from total where srno='"+billno+"'and name='"+cus1+"'");
                        ResultSet rs13 = ps13.executeQuery();
                        while(rs13.next()){
                         table.append("<th colspan=\"4\" align=\"center\">Add:CGST </th>");
                        table.append("<td>"+rs13.getString("total_amount")+" </td>");
                        }
                    table.append("</tr>");
                    PreparedStatement ps14 = c.prepareStatement("select * from total where srno='"+billno+"'and name='"+cus1+"'");
                    ResultSet rs14 = ps14.executeQuery();
                    while(rs14.next()){
                    table.append("<tr>");
                        table.append("<th colspan=\"4\" align=\"center\">Add:SGST</th>");
                        table.append("<td>"+rs14.getString("s_amount")+"</td>");
                    table.append("</tr>");
                    }
                    table.append("<tr>");
                        table.append("<th colspan=\"4\" align=\"center\">Total Tax Amount</th>");
                        table.append("<td> </td>");
                    table.append("</tr>");
                    
                    table.append("<tr>");
                        table.append("<th colspan=\"4\" align=\"center\">Total Amount after Tax</th>");
                        table.append("<td> </td>");
                    table.append("</tr>");
                     table.append("<tr>");
                        table.append("<th colspan=\"7\">Bank Name:</th>");
                        table.append("<th colspan=\"4\" align=\"center\">GST on Reverse Charge </th>");
                        table.append("<td> </td>");
                    table.append("</tr>");
                     table.append("<tr>");
                        table.append("<th colspan=\"7\">Account No:</th>");
                        table.append("<td ROWSPAN=\"3\" colspan=\"5\" align=\"center\"></td>");
                    table.append("</tr>");
                    table.append("<tr>");
                        table.append("<th colspan=\"7\">Ifsc Code:</th>");
                    table.append("</tr>");
                    table.append("<tr>");
                        table.append("<th colspan=\"7\">Terms & Conditions:</th>");
                    table.append("</tr>");
                    
//                    table.append("<tr>");
//                        table.append("<th ROWSPAN=\"2\" colspan=\"13\" align=\"center\">Address of shop</th>");
//                    table.append("</tr>");
                   
                    //common HSN code table
                     table.append("<tr>");
                         table.append("<th ROWSPAN=\"2\" colspan=\"2\" align=\"center\">HSN/SAC</th>");
                         table.append("<th ROWSPAN=\"2\" colspan=\"2\" align=\"center\">Taxable Value</th>");
                         table.append("<th  colspan=\"3\" align=\"center\">Central Tax</th>");
                         table.append("<th  colspan=\"3\" align=\"center\">State Tax</th>");
                         table.append("<th ROWSPAN=\"2\" colspan=\"2\" align=\"center\">Total</th>");
                    table.append("</tr>");
                table.append("<tr>");
                    table.append("<th colspan=\"2\" align=\"center\">Rate</th>");
                    table.append("<th align=\"center\">Amount</th>");
                    table.append("<th colspan=\"2\" align=\"center\">Rate</th>");
                    table.append("<th align=\"center\">Amount</th>");
                table.append("</tr>");
                //insert data in hsn table
                PreparedStatement ps16 = c.prepareStatement(" SELECT hsn_code, SUM(sgst) , SUM(cgst) ,SUM(total) FROM invoice where srno='"+billno+"'and name='"+cus1+"' GROUP BY hsn_code");//where srno='"+billno+"'and name='"+cus1+"'");
                ResultSet rs16 = ps16.executeQuery();
                while(rs16.next()){
                    table.append("<tr>");
                        table.append("<th  colspan=\"2\" align=\"left\">"+rs16.getString("hsn_code")+" </th>");
                        table.append("<th  colspan=\"2\" align=\"center\">"+rs16.getString("SUM(total)")+"  </th>");
                        table.append("<th  colspan=\"2\" align=\"center\"> </th>");
                        table.append("<th  align=\"center\"> "+rs16.getString("SUM(sgst)")+" </th>");
                        table.append("<th  colspan=\"2\" align=\"center\">  </th>");
                        table.append("<th   align=\"center\">"+rs16.getString("SUM(sgst)")+" </th>");
                        table.append("<th  colspan=\"2\" align=\"center\"> </th>");
                    table.append("</tr>");
                }
                table.append("<tr>");
                    table.append("<th  colspan=\"2\" align=\"left\">Total</th>");
                    table.append("<th  colspan=\"2\" align=\"center\"> </th>");
                    table.append("<th  colspan=\"2\" align=\"center\"> </th>");
                    table.append("<th  align=\"center\"> </th>");
                    table.append("<th  colspan=\"2\" align=\"center\"> </th>");
                    table.append("<th   align=\"center\"> </th>");
                    table.append("<th  colspan=\"2\" align=\"center\"> </th>");
                table.append("</tr>");
                   
                table.append("<tr>");
                    table.append("<th colspan=\"13\" align=\"center\">Shop Address  </th>");
                table.append("</tr>");
                } catch(ClassNotFoundException cnf)
			{
                            cnf.printStackTrace();
                            System.out.println("Cnf Exception");
			}
			catch(SQLException sql)
			{
                            sql.printStackTrace();
                            System.out.println("SQL Exception");
			}
               // table.append("<tfoot>");
                table.append("</table>");
                table.append("</body></HTML>");
                label = new JLabel(table.toString());
				//("OSIER SYSTEMS"); 
				label.setForeground(Color.black);
				label.setFont(new Font("Calibri", Font.BOLD, 20));
				label.setBounds(560,50,220,100);
				controlPanel.add(label);
       // frame.setBounds(0,0,Utility.getDesktopResolution().get("width"),Utility.getDesktopResolution().get("height"));
        frame.setBackground(new Color(255,179,179));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
                //  PrintInvoice pi = new PrintInvoice();
			
	}
    
}
