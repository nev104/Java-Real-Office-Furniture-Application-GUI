/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiofficefurniture;

import javax.swing.*;

/**
 *
 * @author nevil
 */
public class Table extends FurnitureItem {

    private int diameter;
    private String baseType;
    
    Table()
    {
    	super();
        diameter = 50;
        baseType = "wooden";
        itemPrice();
    }
    
    Table(int id, char tw, int qty, int dia, String bt)
    {
    	super(id, tw, qty);
        diameter = dia;
        baseType = bt;
        itemPrice();
    }

    public int getDiameter()
    {
        return diameter;
    }
    
    public String getBaseType()
    {
        return baseType;
    }
    
    /*
    •	Wooden base price:	£45.00
    •	Chrome base price:	£35.00
    •	Number of units formula:	diameter x diameter
    •	Total table price is:	(number of units x charge) + price of the base

    */
    
    private void setImage()
    {
        if(getBaseType() == "wooden")
            image = new ImageIcon(getClass().getResource("/img/Table2.png"));
        else
            image = new ImageIcon(getClass().getResource("/img/Table1.png"));
    }
    
    private double itemPrice(){
    	
    	if (super.getTypeOfWood() == 'w'){
            itemPrice = (calcUnits() * 0.03);
    	} else if (super.getTypeOfWood()== 'o'){
            itemPrice = (calcUnits() * 0.04);
    	}else{
            itemPrice = 0.00;
        }
        
        if(baseType == "wooden")
            itemPrice = itemPrice + 45;
        else
            itemPrice = itemPrice + 35;
        
    	return itemPrice;
    }
    
    
    
    @Override
    public int calcUnits()
    {
        int units;
        
        // working out cost
        //(((height + width + depth) * 12) + (depth * width) * price per unit) + (number of draws * £8.50)
        //Note: The height of all desks is 80cm.
        
        units = (diameter * diameter);
        
        return units;
    }
    
    //@Override annotation is used when we override a method in sub class.
    //Generally novice developers overlook this feature as it is not mandatory to use
    //this annotation while overriding the method.
    @Override
    public String toString(){
        return super.toString() + "  Diameter "+ diameter +"   BaseType "+ baseType;
    }

}
