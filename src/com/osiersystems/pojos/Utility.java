/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osiersystems.pojos;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;

public class Utility {
	

	public static HashMap<String, Integer> getDesktopResolution()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		HashMap<String, Integer> scrSize = new HashMap<String, Integer>();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		scrSize.put("width", width);
		scrSize.put("height", height);
	    
		return(scrSize);
		
	}
	
}

