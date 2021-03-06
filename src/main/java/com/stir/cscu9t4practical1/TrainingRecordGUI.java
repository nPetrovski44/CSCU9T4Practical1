// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {
	
    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField terrain = new JTextField(10);
    private JTextField tempo = new JTextField(4);
    private JTextField rep = new JTextField(4);
    private JTextField rec = new JTextField(4);
    private JTextField place = new JTextField(10);
    
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance:");
    private JLabel labdrop = new JLabel(" Select entry:");
    private JLabel labterrain = new JLabel(" Terrain:");
    private JLabel labtempo = new JLabel(" Tempo:");
    private JLabel labrep = new JLabel(" Repetition:");
    private JLabel labrec = new JLabel(" Recovery:");
    private JLabel labplace = new JLabel(" Place:");
    
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up Last");
    private JButton FindAllByDate = new JButton("Look Up All (Date)");
    private JButton	FindAllByName = new JButton("Look Up All (Name)");
    private JButton removeEntry = new JButton("Remove");
    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);
    private String[] entryOptions = {"NormalRun", "Sprint", "Swim", "Cycle"};
    private JComboBox<String> dropDown = new JComboBox<String>(entryOptions);
    
    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labdrop);
        add(dropDown);
        dropDown.addActionListener(this);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        
        add(labterrain);
        add(terrain);
        labterrain.setVisible(false);
        terrain.setVisible(false);
        terrain.setEditable(true);
        
        add(labtempo);
        add(tempo);
        labtempo.setVisible(false);
        tempo.setVisible(false);
        tempo.setEditable(true);
        
        add(labrep);
        add(rep);
        labrep.setVisible(false);
        rep.setVisible(false);
        rep.setEditable(true);
        
        add(labrec);
        add(rec);
        labrec.setVisible(false);
        rec.setVisible(false);
        rec.setEditable(true);

        add(labplace);
        add(place);
        labplace.setVisible(false);
        place.setVisible(false);
    	place.setEditable(true);
        
        add(addR);
        addR.addActionListener(this);
        add(removeEntry);
        removeEntry.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(FindAllByDate);
        FindAllByDate.addActionListener(this);
        add(FindAllByName);
        FindAllByName.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        removeEntry.setEnabled(false);
        lookUpByDate.setEnabled(false);
        FindAllByDate.setEnabled(false);
        FindAllByName.setEnabled(false);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
            if(myAthletes.getNumberOfEntries() != 0)
            {
            	removeEntry.setEnabled(true);
            	lookUpByDate.setEnabled(true);
            	FindAllByDate.setEnabled(true);
            	FindAllByName.setEnabled(true);
            }
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == FindAllByDate)
        {
        	message = lookupAll();
        }
        if (event.getSource() == FindAllByName)
        {
        	message = lookUpName();
        }
        if(event.getSource() == removeEntry)
        {
        	message = removeEntry();
        	if(myAthletes.getNumberOfEntries() == 0)
            {
                removeEntry.setEnabled(false);
                lookUpByDate.setEnabled(false);
                FindAllByDate.setEnabled(false);
                FindAllByName.setEnabled(false);
            }
        }

        if(event.getSource() == dropDown)
        {
            if(dropDown.getSelectedItem().toString().equals("Sprint"))
            {
            	 labrep.setVisible(true);
                 rep.setVisible(true);
                 
                 labrec.setVisible(true);
                 rec.setVisible(true);
                 
                 labplace.setVisible(false);
                 place.setVisible(false);
                 
                 labterrain.setVisible(false);
                 terrain.setVisible(false);
                 
                 labtempo.setVisible(false);
                 tempo.setVisible(false);
                 
                 
                 SwingUtilities.updateComponentTreeUI(rep);
                 SwingUtilities.updateComponentTreeUI(rec);
                 SwingUtilities.updateComponentTreeUI(place);
                 SwingUtilities.updateComponentTreeUI(terrain);
                 SwingUtilities.updateComponentTreeUI(tempo);
            }
            if(dropDown.getSelectedItem().toString().equals("Swim"))
            {
	           	 labrep.setVisible(false);
	             rep.setVisible(false);
	             
	             labrec.setVisible(false);
	             rec.setVisible(false);
	             
	             labplace.setVisible(true);
	             place.setVisible(true);
	             
	             labterrain.setVisible(false);
	             terrain.setVisible(false);
	             
	             labtempo.setVisible(false);
	             tempo.setVisible(false);
	             
                SwingUtilities.updateComponentTreeUI(rep);
                SwingUtilities.updateComponentTreeUI(rec);
                SwingUtilities.updateComponentTreeUI(place);
                SwingUtilities.updateComponentTreeUI(terrain);
                SwingUtilities.updateComponentTreeUI(tempo);
            }
            if(dropDown.getSelectedItem().toString().equals("Cycle"))
            {	
	           	 labrep.setVisible(false);
	             rep.setVisible(false);
	             
	             labrec.setVisible(false);
	             rec.setVisible(false);
	             
	             labplace.setVisible(false);
	             place.setVisible(false);
	             
	             labterrain.setVisible(true);
	             terrain.setVisible(true);
	             
	             labtempo.setVisible(true);
	             tempo.setVisible(true);
	             	
                SwingUtilities.updateComponentTreeUI(rep);
                SwingUtilities.updateComponentTreeUI(rec);
                SwingUtilities.updateComponentTreeUI(place);
                SwingUtilities.updateComponentTreeUI(terrain);
                SwingUtilities.updateComponentTreeUI(tempo);
            }

        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        if(n.equals(""))return "Enter a valid name";
        try
        {
	        int m = Integer.parseInt(month.getText());
	        if(m < 1 || m > 12) return "Enter a valid month";
	        int d = Integer.parseInt(day.getText());
	        int y = Integer.parseInt(year.getText());
	        if(d > 0)
	        {
	        	if((m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) && d > 31) return "Enter a valid day";
	        	if((m == 4 || m == 6 || m == 9 || m == 11) && d > 30 ) return "Enter a valid day";
	        	if(m == 2 && y % 4 != 0 && d > 28) return "Enter a valid day";
	        	if(m == 2 && y % 4 == 0 && d > 29) return "Enter a valid day";
	        }else return "Enter a valid day";
	        float km = java.lang.Float.parseFloat(dist.getText());
	        if(km < 0)return "Enter valid distance";
	        int h = Integer.parseInt(hours.getText());
	        if(h < 0) return "Enter a valid hour";
	        int mm = Integer.parseInt(mins.getText());
	        if(mm < 0 || mm > 60) return "Enter valid minutes";
	        int s = Integer.parseInt(secs.getText());
	        if(s < 0 || s > 60) return "Enter valid seconds";
	        if(myAthletes.lookupExact(n, d, mm, y) == null)
	        {	
	        	if(dropDown.getSelectedItem().toString().equals("NormalRun"))
	        	{
	        		Entry e = new Entry(n, d, m, y, h, mm, s, km);
	        		myAthletes.addEntry(e);
	        	}
	        	
	        	if(dropDown.getSelectedItem().toString().equals("Sprint"))
	        	{	
	        		int repetition = Integer.parseInt(rep.getText());
	        		if(repetition < 0) return "Enter a valid repetition";
	        		int recovery = Integer.parseInt(rec.getText());
	        		if(recovery < 0) return "Enter a valid recovery";
	        		SprintEntry e = new SprintEntry(n, d, m, y, h, mm, s, km, repetition, recovery);
	        		myAthletes.addEntry(e);
	        	}
	        	
	        	if(dropDown.getSelectedItem().toString().equals("Swim"))
	        	{
	        		String swimmingPlace = place.getText();
	        		if(swimmingPlace.equals("")) return "Enter a valid swimming place";
	        		SwimEntry e = new SwimEntry(n, d, m, y, h, mm, s, km, swimmingPlace);
	        		myAthletes.addEntry(e);
	        	}
	        	
	        	if(dropDown.getSelectedItem().toString().equals("Cycle"))
	        	{	
	        		String ter = terrain.getText();
	        		if(ter.equals("")) return "Enter a valid terrain";
	        		String tem = tempo.getText();
	        		if(tem.equals("")) return "Enter a valid tempo";
	        		CycleEntry e = new CycleEntry(n, d, m, y, h, mm, s, km, ter, tem);
	        		myAthletes.addEntry(e);
	        	}

	        }else return "This session has already been entered";
	        return message;
        }catch(Exception e)
        {
        	return "Invalid input";
        }
    }
    
    public String lookupEntry() {
    	try
    	{
	    	int m = Integer.parseInt(month.getText());
	        int d = Integer.parseInt(day.getText());
	        int y = Integer.parseInt(year.getText());
	        outputArea.setText("looking up record ...");
	     	String message = myAthletes.lookupEntry(d, m, y);
	        return message;
    	}catch(Exception e)
    	{
    		return "Enter a valid input";
    	}
    }
    
    public String lookupAll()
    {
    	try
    	{
	        int m = Integer.parseInt(month.getText());
	        int d = Integer.parseInt(day.getText());
	        int y = Integer.parseInt(year.getText());
	        outputArea.setText("looking up record ...");
	     	String message = myAthletes.lookupAll(d, m, y);
	        return message;
    	}catch(Exception e)
    	{
    		return "Enter a valid input";
    	}
    }
    
    public String lookUpName()
    {
    	try
    	{
    		String n = name.getText();
	        outputArea.setText("looking up records ...");
	     	String message = myAthletes.lookUpName(n);
	        return message;
    	}catch(Exception e)
    	{
    		return "Enter a valid input";
    	}
    }

    public String removeEntry()
    {
    	try
    	{
	    	String n = name.getText();
	        int m = Integer.parseInt(month.getText());
	        int d = Integer.parseInt(day.getText());
	        int y = Integer.parseInt(year.getText());
	        outputArea.setText("looking up record ...");
	     	String message = myAthletes.removeEntry(n, d, m, y);
	        return message;
    	}catch(Exception e)
    	{
    		return "Enter a valid input";
    	}
    }
    
    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        rep.setText("");
        rec.setText("");
        terrain.setText("");
        tempo.setText("");
        place.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI

