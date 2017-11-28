/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account_billing;

/**
 *
 * @author ACER
 */
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class BGenerate extends JFrame implements Printable{
	
	JLabel rate1,cgstt, dt,sr1,add;
	JButton paid,home;
	JButton print;
	int y;
	StringBuilder name ;
	JPanel controlPanel;
	public BGenerate(String cus1,String billno,String ntot) {

        // create JFrame and JTable
        JFrame frame = new JFrame();
       frame.setBackground(Color.red);
       
       paid = new JButton("Paid");
		paid.setBounds(1000, 100, 200, 30);
		frame.add(paid);
		
		home = new JButton("Home");
		home.setBounds(1000, 200, 200, 30);
		frame.add(home);
		
		print = new JButton("Print");
		print.setBounds(1000, 150, 200, 30);
		frame.add(print);
		ImageIcon comp = new ImageIcon("G:/oslog.png");
		JLabel colLogo = new JLabel(comp);
		colLogo.setBounds(950,-165,450,450);
		colLogo.setFont(new Font("Calibri", Font.BOLD, 20));
		frame.add(colLogo);

		controlPanel = new JPanel();
		frame.add(controlPanel);
		controlPanel.setVisible(true);
		controlPanel.setBounds(330, 50, 350, 800);
		
paid.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String[] choices = { "CASH PAYMENT", "CARD PAYMENT", "NET BANKING" ,"NOT PAID"};
			          String input1 = (String) JOptionPane.showInputDialog(frame, "Paying Modes",
						        "Ready To Pay", JOptionPane.YES_NO_OPTION, null,choices, choices[1]);
			        	  try {
			        		  String sr = ""+billno;
								Class.forName("oracle.jdbc.driver.OracleDriver");
								Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
								Statement stm = c.createStatement();
								PreparedStatement ps  = c.prepareStatement("insert into pbill values(?,?,?)");
								
									ps.setString(1,sr);		
									
									//ps.setString(1,"");
									if(choices[3] == "NOT PAID" && "NOT PAID".equals(choices)){
									ps.setString(2, "NO");
									}
									else {
										//if(choices[1] == "CASH PAYMENT" && "CASH PAYMENT".equals(choices)){
										ps.setString(2, "YES");
									//}
									}
									ps.setString(3, input1+"");
																	
									ps.executeQuery();
									c.close();
									stm.close();
						}
						catch(ClassNotFoundException cnf)
						{
							System.out.println("Cnf Exception");
						}
						catch(SQLException sql)
						{
							sql.printStackTrace();
							System.out.println("SQL Exception");
						}
				 	 
			}
			
		});

	
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
					Statement stm = c.createStatement();
					PreparedStatement ps2 = c.prepareStatement("select * from shop_details ");
					ResultSet rs2 = ps2.executeQuery();
				    name = new StringBuilder();
					name.append("<HTML><head><title></title></head><body>");
					while(rs2.next()){
					name.append(" &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <font face=\"WildWest\" size=\"4\">"+rs2.getString("name")+"</font><br>");
					name.append("<font face=\"WildWest\" size=\"4\">"+rs2.getString("address")+"</font><br>");
					name.append(" &nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp <font face=\"WildWest\" size=\"4\">"+rs2.getString("phno")+"</font>");
				}
					name.append("</body></HTML>");
					stm.close();
				    c.close();
				} catch (Exception e) {
				e.printStackTrace();
				}
				dt = new JLabel(name.toString());
				//("OSIER SYSTEMS"); 
				dt.setForeground(Color.black);
				dt.setFont(new Font("Calibri", Font.BOLD, 20));
				dt.setBounds(560,50,220,20);
				controlPanel.add(dt);
		
		 JLabel st =new JLabel("----------------------Tax Invoice----------------------");
	     st.setForeground(Color.black);
	     st.setFont(new Font("Calibri", Font.BOLD, 20));
	     st.setBounds(290, 140, 700, 20);
	     controlPanel.add(st);
	     
	     StringBuilder sb = new StringBuilder();
	     Date date12 = new Date(System.currentTimeMillis());
	     sb.append("<HTML><head><title></title></head><body>");
	     sb.append(" <font face=\"Times New Roman\" size=\"4\">Date:</font>");
		 sb.append( " <font face=\"WildWest\" size=\"4\">"+date12.toString()+"</font>");
		 sb.append(" &nbsp <font face=\"Times New Roman\" size=\"4\">Bill No:</font>");
		 sb.append(" &nbsp <font face=\"Times New Roman\" size=\"4\">"+billno+"</font><br>");
		 sb.append(" &nbsp &nbsp &nbsp &nbsp <font face=\"Times New Roman\" size=\"4\">GST No:</font>");
		 try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				Statement stm = c.createStatement();
				PreparedStatement ps2 = c.prepareStatement("select * from shop_details ");
				ResultSet rs2 = ps2.executeQuery();
				while(rs2.next()){
				sb.append(" &nbsp <font face=\"Times New Roman\" size=\"4\">"+rs2.getString("gstno")+"</font>");
				}
				stm.close();
		    c.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		 sb.append("</body></HTML>");
		 JLabel date = new JLabel(sb.toString());
	     date.setForeground(Color.black);
	     date.setBounds(430,170,220,20);
	     controlPanel.add(date);

		JLabel ll = new JLabel("-----------------------------------------------------------"); 
		ll.setForeground(Color.black);
		ll.setFont(new Font("Calibri", Font.BOLD, 20));
		ll.setBounds(290,190,700,20);
		controlPanel.add(ll);
		
		
		//back Button 
		JButton	back = new JButton("Back"); 
        back.setToolTipText("Go to GenBill");
        back.setBounds(50, 30, 100, 35);
        frame.add(back);
		back.addActionListener(new ActionListener() {
					
					@Override
					
					public void actionPerformed(ActionEvent e) {
						String str1=(String)e.getActionCommand();
						Object source = e.getSource();
					try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");

						if(source==back)
						{
//							GenBill ge =new GenBill();
//							ge.showBill();
//							frame.dispose();
					}
						
						}
					catch(ClassNotFoundException cnf)
					{
						System.out.println("Cnf Exception");
					}
					catch(SQLException sql)
					{
						System.out.println("SQL Exception");
					}
					
					}
						
						
					});
		////home button action part
		home.addActionListener(new ActionListener() {
			
			@Override
			
			public void actionPerformed(ActionEvent e) {
				String str1=(String)e.getActionCommand();
				Object source = e.getSource();
		
				if(source==back)
				{
//					Home ge =new Home();
//					ge.show();
//					frame.dispose();
				}
					
			}
					
			});
		
		JLabel no1 = new JLabel(""); 
		no1.setForeground(Color.black);
		no1.setBounds(680,170,550,20);
		frame.add(no1);

		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			Statement stm = c.createStatement();
			PreparedStatement ps1 = c.prepareStatement("select * from daily where srno='"+billno+"'and cusname='"+cus1+"' ");
			ResultSet rs = ps1.executeQuery();
			StringBuilder Bill = new StringBuilder();
			   Bill.append("<HTML><head><title></title></head><body>");
			   
			   Bill.append("<table style=\"border:none\" cellpadding=\"12\" >");
			  
					   
			   Bill.append("<tr>");
			   Bill.append("<th>Particulars</th>");
			   Bill.append("<th>Quantity</th>");
			   Bill.append("<th>Price</th>");
			   Bill.append("<th>Total</th>");
			   Bill.append("</tr>");			
			   while(rs.next()){

				Bill.append("<tr>");
				Bill.append("<td> <font face=\"WildWest\" size=\"4\">"+rs.getString("Items")+"</font></td>");
				Bill.append("<td><font face=\"WildWest\" size=\"4\">"+rs.getString("quantity")+"</font></td>");
				Bill.append("<td><font face=\"WildWest\" size=\"4\">"+rs.getString("price")+"</font></td>");
				Bill.append("<td><font face=\"WildWest\" size=\"4\">"+rs.getString("total")+"</font></td>");
				Bill.append("</tr>");
			   }
				
					//name.append("</HTML>");
			   Bill.append("</table>");
			   Bill.append("</body></HTML>");
			  
           
             Bill.append("</HTML>");
             JLabel BillLable = new JLabel(Bill.toString()); 
             BillLable.setForeground(Color.black);
             BillLable.setBounds(290,this.y+10,700,20);
             BillLable.setFont(new Font("Calibri", Font.PLAIN, 20));
     		controlPanel.add(BillLable);
     		
     		
		JLabel bd = new JLabel(); 
		bd.setForeground(Color.black);
		bd.setBounds(290,this.y+10,700,20);
		bd.setFont(new Font("Calibri", Font.BOLD, 20));
		controlPanel.add(bd);
		String printLbl5 ="--------------------------------------------------------";
		bd.setText(printLbl5.toString());
		
		////Gst Calculation
		String strng = "";
		PreparedStatement ps22 = c.prepareStatement("select gst from  shop_details");
		ResultSet rs1 = ps22.executeQuery();
		while(rs1.next()){
			strng = ""+rs1.getShort("gst");
		}
		
		float totcal = (Float.parseFloat(ntot))*((Float.parseFloat(strng))/100);
		//float totcal = (Float.parseFloat(ntot))*((a)/100);
		float tmp = Math.round(totcal);
		float tot = (Float.parseFloat(ntot))+(totcal);
		//////**********///////////////////////
		  StringBuilder table = new StringBuilder();
		  table.append("<HTML><head><title></title></head><body>");
		  table.append(" &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <font face=\"WildWest\" size=\"4\">Net Total :</font>");
		  table.append( "&nbsp &nbsp  <font face=\"WildWest\" size=\"4\">"+ntot+"</font><br>");
		  table.append(" &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<font face=\"WildWest\" size=\"4\">GST </font>");
		  try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c1 =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				Statement stm1 = c1.createStatement();
				PreparedStatement ps11 = c1.prepareStatement("select gst from  shop_details");
				ResultSet rs11 = ps11.executeQuery();
				while(rs11.next()){
					table.append(" &nbsp &nbsp <font face=\"WildWest\" size=\"4\">"+rs11.getString("gst")+"% :</font>");
				}
				}
			catch(ClassNotFoundException cnf)
			{
				System.out.println("Cnf Exception");
			}
			catch(SQLException sql)
			{
				System.out.println("SQL Exception");
			}
		  table.append(" &nbsp &nbsp <font face=\"WildWest\" size=\"4\">"+tmp+"</font><br>");
		  table.append(" &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <font face=\"WildWest\" size=\"4\">TOTAl :</font>");
		  table.append(" &nbsp &nbsp &nbsp  &nbsp &nbsp <font face=\"WildWest\" size=\"4\">"+tot+"</font> ");
		  table.append("</body></HTML>");
		  table.append("</HTML>");
		
			JLabel subtot = new JLabel(table.toString()); 
			subtot.setForeground(Color.black);
			subtot.setBounds(700,this.y+20,350,20);
			controlPanel.add(subtot);
			
			
			 stm.close();
	            c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		BGenerate bg = this;
		print.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
						
				PrinterJob printJob = PrinterJob.getPrinterJob();
				PageFormat pf = printJob.pageDialog(printJob.defaultPage());
			    printJob.setPrintable(bg);
			    if (printJob.printDialog())
			      try { 
			        printJob.print();
			      } catch(PrinterException pe) {
			        System.out.println("Error printing: " + pe);
			      }
			    
			   
			} 
			      });
	
		frame.setVisible(false);
       // frame.setBounds(0,0,Utility.getDesktopResolution().get("width"),Utility.getDesktopResolution().get("height"));
        frame.setBackground(new Color(255,179,179));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
		public static void main(String[] args){
                    BGenerate bill = new BGenerate("ss", "44", "5555");
			
	}
		@Override
		 public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
	        if (pageIndex > 0) {
	          return(NO_SUCH_PAGE);
	        } else {
	          Graphics2D g2d = (Graphics2D)g;
	          g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
	          // Turn off double buffering
	          controlPanel.paint(g2d);
	          // Turn double buffering back on
	          return(PAGE_EXISTS);
	        }
	    
		

		}
		}
