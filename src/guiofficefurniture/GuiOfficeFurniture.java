package guiofficefurniture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class GuiOfficeFurniture extends JFrame implements ActionListener, MouseListener, MouseMotionListener{
    
    //
    private final JLabel Chair1, Chair2;//, Desk1, Desk2, Desk3, Desk4, Table1, Table2;
    //private JLabel emptySmall1, emptySmall2, emptySmall3, emptySmall4, emptySmall5, emptySmall6;
    //private JLabel emptyLarge1, emptyLarge2, emptyLarge3;
    private final ImageIcon c1, c2;//, d1, d2, d3, d4, t1, t2;// eS1, eS2, eS3, eS4, eS5, eS6, eL1, eL2, eL3;
    
    // counters
    int smallGridpos = 0;
    int bigGridpos = 0;
    double totalPrice = 0;
    
    // Array Collections for Class's
    ArrayList<FurnitureItem> aCollectionAll = new ArrayList<>();
    ArrayList<FurnitureItem> aCollectionSmall = new ArrayList<>();
    ArrayList<FurnitureItem> aCollectionLarge = new ArrayList<>();
    
    JTextField chairID = new JTextField(8);
    JTextField typeOfWood = new JTextField(8);
    JTextField quantity = new JTextField(5);
  
    ImageIcon emptySmall = new ImageIcon(getClass().getResource("/img/empty_w100xh100.png"));
    JLabel[] emptySmallLabel = new JLabel[6];
    
    ImageIcon emptyLarge = new ImageIcon(getClass().getResource("/img/empty_w150xh100.png"));   
    JLabel[] emptyLargeLabel = new JLabel[3];
    
    private final JButton addChairBTN = new JButton();
    private final JButton addTableBTN = new JButton();
    private final JButton addDeskBTN = new JButton();
    private final JButton clearAllBTN = new JButton();
    private final JButton totalPriceBTN = new JButton();
    private final JButton saveBTN = new JButton();
    private final JButton loadBTN = new JButton();
    private final JButton summaryBTN = new JButton();
    private final JButton tempBTN = new JButton();
    
    JTextArea txtArea = new JTextArea(8,38);
    int x,y;
    
    final JPanel warning = new JPanel();
    
    public GuiOfficeFurniture(){
        super("Real Office Furniture");  
        
        //setLayout(new FlowLayout()); 
        setLayout(new BorderLayout());
        Container contentPane = getContentPane();
        
        JPanel pnlNorth = new JPanel();        
        pnlNorth.setBackground(Color.yellow);
        pnlNorth.setOpaque(true);
        
        JPanel pnlSouth = new JPanel();        
        pnlSouth.setBackground(Color.yellow);
        pnlSouth.setOpaque(true);
                
        JPanel btnPanel = new JPanel(new GridLayout(9,1));
        
        JPanel ctPanel = new JPanel(new GridLayout(3,2)); 
        
        JPanel deskPanel = new JPanel(new GridLayout(3,1)); 
             
        addChairBTN.setPreferredSize(new Dimension(120, 50));
        addChairBTN.setText("Add Chair");
        btnPanel.add(addChairBTN);
        
        addTableBTN.setPreferredSize(new Dimension(120, 50));
        addTableBTN.setText("Add Table");
        btnPanel.add(addTableBTN);
        
        addDeskBTN.setPreferredSize(new Dimension(120, 50));
        addDeskBTN.setText("Add Desk");
        btnPanel.add(addDeskBTN);
        
        clearAllBTN.setPreferredSize(new Dimension(120, 50));
        clearAllBTN.setText("Clear All");
        btnPanel.add(clearAllBTN);
        
        totalPriceBTN.setPreferredSize(new Dimension(120, 50));
        totalPriceBTN.setText("Total Price");
        btnPanel.add(totalPriceBTN);
        
        saveBTN.setPreferredSize(new Dimension(120, 50));
        saveBTN.setText("Save");
        btnPanel.add(saveBTN);
        
        loadBTN.setPreferredSize(new Dimension(120, 50));
        loadBTN.setText("Load");
        btnPanel.add(loadBTN);
        
        summaryBTN.setPreferredSize(new Dimension(120, 50));
        summaryBTN.setText("Summary");
        btnPanel.add(summaryBTN);
        
        // temp button
        tempBTN.setPreferredSize(new Dimension(120, 50));
        tempBTN.setText("Temp Placment");
        btnPanel.add(tempBTN);
        
        
        // set the images in an array
        c1 = new ImageIcon(getClass().getResource("/img/Chair1.png"));
        Chair1 = new JLabel(c1);
        Chair1.setOpaque(true);
        
        c2 = new ImageIcon(getClass().getResource("/img/Chair2.png"));
        Chair2 = new JLabel(c2);
        Chair2.setOpaque(true);
        /*
        d1 = new ImageIcon(getClass().getResource("/img/Desk1.png"));
        Desk1 = new JLabel(d1);
        Desk1.setOpaque(true);
        
        d2 = new ImageIcon(getClass().getResource("/img/Desk2.png"));
        Desk2 = new JLabel(d2);
        Desk2.setOpaque(true);
        
        d3 = new ImageIcon(getClass().getResource("/img/Desk3.png"));
        Desk3 = new JLabel(d3);
        Desk3.setOpaque(true);
        
        d4 = new ImageIcon(getClass().getResource("/img/Desk4.png"));
        Desk4 = new JLabel(d4);
        Desk4.setOpaque(true);
        
        t1 = new ImageIcon(getClass().getResource("/img/Table1.png"));
        Table1 = new JLabel(t1);
        Table1.setOpaque(true);
        
        t2 = new ImageIcon(getClass().getResource("/img/Table2.png"));
        Table2 = new JLabel(t2);
        Table2.setOpaque(true);
        */
        
        for (int i = 0; i < 6; i++){     
            emptySmallLabel[i] = new JLabel();
            emptySmallLabel[i].setIcon(emptySmall);          
        }
        
        for (int i = 0; i < 3; i++){     
            emptyLargeLabel[i] = new JLabel();
            emptyLargeLabel[i].setIcon(emptyLarge);          
        }

        
        ctPanel.add(emptySmallLabel[0]);
        ctPanel.add(emptySmallLabel[1]);
        ctPanel.add(emptySmallLabel[2]);
        ctPanel.add(emptySmallLabel[3]);
        ctPanel.add(emptySmallLabel[4]);
        ctPanel.add(emptySmallLabel[5]);

        deskPanel.add(emptyLargeLabel[0]);
        deskPanel.add(emptyLargeLabel[1]);
        deskPanel.add(emptyLargeLabel[2]);
               
        pnlNorth.add(new JLabel("Real Office Funiture"));
        pnlSouth.add(txtArea);
        
        contentPane.add("North", pnlNorth);
        contentPane.add("West", btnPanel); 
        contentPane.add("Center", ctPanel);
        contentPane.add("East", deskPanel);
        contentPane.add("South", pnlSouth);
        
        
        addChairBTN.addActionListener(this);

        addTableBTN.addActionListener(this);

        addDeskBTN.addActionListener(this); 
        
        clearAllBTN.addActionListener(this);
        
        totalPriceBTN.addActionListener(this);
        
        saveBTN.addActionListener(this);
        
        loadBTN.addActionListener(this);
        
        summaryBTN.addActionListener(this);
        
        tempBTN.addActionListener(this);

        for (int i = 0; i < 6; i++){
        
            emptySmallLabel[i].addMouseListener(this);
        }
        
        //emptyLargeLabel[0].addMouseListener(this);
        //emptyLargeLabel[1].addMouseListener(this);
        //emptyLargeLabel[2].addMouseListener(this);
        
        for (int i = 0; i < 3; i++){
        
            emptyLargeLabel[i].addMouseListener(this);
            
        }
        
        Chair1.addMouseListener(this);
        
        Chair2.addMouseListener(this);
        /*
        Desk1.addMouseListener(this);
        Desk2.addMouseListener(this);
        Desk3.addMouseListener(this);
        Desk4.addMouseListener(this);
        Table1.addMouseListener(this);
        Table2.addMouseListener(this);*/
        
        txtArea.addMouseListener(this);

        txtArea.addMouseMotionListener(this);
        
    } //end of contructor
    
    // show summary for furniture
    void smallFurnitureSummary(Chair sumChair){    
        System.out.println("Small Furniture Summary Here: ");     
        txtArea.append("\nYou have clicked on a Small Furniture Item");
        JOptionPane.showMessageDialog(null, sumChair.toString(), "Item Details", JOptionPane.INFORMATION_MESSAGE);   
    }
    
    
    
    // display summary of order in asending order of price
    void displaySummary()
    {
        // clear the Complate collection
        aCollectionAll.clear();
        
        // add all small items to the complete collection
        aCollectionSmall.forEach((singleItem) -> {
            aCollectionAll.add(singleItem);
        });
        
        // add all Large items to the complete collection
        aCollectionLarge.forEach((singleItem) -> {
            aCollectionAll.add(singleItem);
        });
        
        
        // Sort by Total Price:
        Collections.sort(aCollectionAll, new ItemPriceComparator());
        
        
        // list though all chair classes
        aCollectionAll.forEach((singleChair) -> {
            System.out.println("\n "+singleChair.toString());
        });
    }
    
    
    // clear function
    void clearFunction()
    {
        System.out.println("Clear All Button Pressed");
        
        // reset all counters
        smallGridpos = 0; //reset position
        bigGridpos = 0;
        totalPrice = 0;
        
        // reset all array collections
        aCollectionAll.clear();
        aCollectionSmall.clear();
        aCollectionLarge.clear();
        
        // reset small labels
        for (int i = 0; i < 6; i++){     
            //emptySmallLabel[i] = new JLabel();
            emptySmallLabel[i].setIcon(emptySmall);          
        }
        
        // reset large labels
        for (int i = 0; i < 3; i++){     
            //emptySmallLabel[i] = new JLabel();
            emptyLargeLabel[i].setIcon(emptyLarge);          
        }
    }
    
    
    
    // Save
    void saveToFile()
    {
        // clear the Complate collection
        aCollectionAll.clear();
        
        // add all small items to the complete collection
        aCollectionSmall.forEach((singleItem) -> {
            aCollectionAll.add(singleItem);
        });
        
        // add all Large items to the complete collection
        aCollectionLarge.forEach((singleItem) -> {
            aCollectionAll.add(singleItem);
        });
        
        // try to save the file, error with IO expresion if it fails.
        try {
            FileOutputStream fos = new FileOutputStream("file1.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(aCollectionAll);
            oos.close();
            System.out.println("\n File Saved!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    
    
    
    // Load
    void loadFromFile() throws ClassNotFoundException
    {
        // run the clear function to clear all variables
        clearFunction();
        
        try {
            FileInputStream fis = new FileInputStream("file1.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            aCollectionAll = (ArrayList<FurnitureItem>) ois.readObject();
            ois.close();
            System.out.println("\n File loaded!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        
        // loop thought all collection and them to the approtirate collection
        aCollectionAll.forEach((FurnitureItem singleItem) -> {
            if("Chair".equals(singleItem.getClass().getSimpleName()))
                aCollectionSmall.add(singleItem);
            
            if("Table".equals(singleItem.getClass().getSimpleName()))
                aCollectionSmall.add(singleItem);
            
            if("Desk".equals(singleItem.getClass().getSimpleName()))
                aCollectionLarge.add(singleItem);
            
            //System.out.println("\n "+singleItem.getClass().getSimpleName());
        });
        
        placeItemsOnGrid();
    }
    
    
    
    // tempory realod array to test placement
    void placeItemsOnGrid()
    {
        // reset posistion counters
        smallGridpos = 0; //reset position
        bigGridpos = 0;
        
        // reset small labels
        for (int i = 0; i < 6; i++){     
            //emptySmallLabel[i] = new JLabel();
            emptySmallLabel[i].setIcon(emptySmall);          
        }
        
        // reset large labels
        for (int i = 0; i < 3; i++){     
            //emptySmallLabel[i] = new JLabel();
            emptyLargeLabel[i].setIcon(emptyLarge);          
        }
        
        
        
        // list though all chair classes
        aCollectionSmall.forEach((FurnitureItem singleItem) -> {
            
            emptySmallLabel[smallGridpos].setIcon(singleItem.getImage());
            smallGridpos++;
            /*
            if(singleItem.getArmRests() == true)
            {
                emptySmallLabel[smallGridpos].setIcon(c1);
                //emptySmallLabel[smallGridpos].a
                smallGridpos++;
            }
            else
            {
                
                
            }
            totalPrice = totalPrice + (singleChair.getTotalPrice());*/
        });
        
        
    }
    
    
    
    
    //static void newChair(){
    
    public void addChair(){
        
        ButtonGroup tow = new ButtonGroup();        
        JRadioButton oak = new JRadioButton("Oak", true);
        JRadioButton walnut = new JRadioButton("Walnut");
        tow.add(oak);
        tow.add(walnut);
        
        ButtonGroup chrType = new ButtonGroup(); 
        JRadioButton chair1 = new JRadioButton("Without Armrests", true);
        JRadioButton chair2 = new JRadioButton("With Armrests");
        chrType.add(chair1);
        chrType.add(chair2);
       
        JPanel myChair = new JPanel();
        myChair.add(new JLabel("Chair ID Number: "));
        myChair.add(chairID);
        myChair.add(oak);
        myChair.add(walnut);
        myChair.add(new JLabel("Quantity: "));
        myChair.add(quantity);
        myChair.add(chair1);
        myChair.add(chair2);
        
        char tempChar = 'w';
        boolean tempBool = false;
        
        if (smallGridpos == 6){           
            JOptionPane.showMessageDialog(warning, "Small Furniture Display Limit Reached", "Error", JOptionPane.ERROR_MESSAGE);
        } //end of small grid limit if statement
        
        else { int chairBtnResult = JOptionPane.showConfirmDialog(null, myChair, "Chair Selected", JOptionPane.OK_CANCEL_OPTION);
        
        if (chairBtnResult == JOptionPane.OK_OPTION) {
            
           System.out.println("chairID: " + chairID.getText());
        
           if (oak.isSelected()){ 
                tempChar ='o';
                System.out.println("Type of Wood Selected: " + oak.getText());               
           } 
           else if (walnut.isSelected()){
                tempChar ='w';
                System.out.println("Type of Wood Selected: " + walnut.getText());
           }         
           
           System.out.println("Quantity: " + quantity.getText());

           if (chair1.isSelected()){               
                tempBool = false;
           } 
           else if (chair2.isSelected()){
                tempBool = true;
           } 
           placeItemsOnGrid();
        }    
        if (chairBtnResult == JOptionPane.OK_OPTION){
            System.out.println("OK Pressed");
            
        } else if (chairBtnResult == JOptionPane.CANCEL_OPTION) {          
            System.out.println("Cancel Pressed");      
        }
        
        }//end else for grid position check
        
        int id = Integer.parseInt(chairID.getText());	
        int qty = Integer.parseInt(quantity.getText());
        
     //Chair newChair = new Chair(chairID.getText());
     
        FurnitureItem newChair = new Chair();
        newChair = new Chair(id, tempChar, qty, tempBool);
        
        // Add to Small Array Collaction
        aCollectionSmall.add(newChair);
    }
 

    @Override
    public void mouseEntered(MouseEvent event){

        txtArea.setText("Mouse Entered");

    }

    @Override
    public void mousePressed(MouseEvent event){

        //txtArea.append("\nMouse Pressed at X: " + x + " Y" + y);
        
        if (SwingUtilities.isLeftMouseButton(event)){
            txtArea.append("\nLeft Mouse Button Clicked");
        }
        if (SwingUtilities.isMiddleMouseButton(event)){
            txtArea.append("\nMiddle Mouse Button Clicked");
        }
        if (SwingUtilities.isRightMouseButton(event)){
            txtArea.append("\nRight Mouse Button Clicked");
        }
        

    }

    @Override
    public void mouseReleased(MouseEvent event){

        txtArea.append("\nMouse released");

    }
    
    /**
     *
     * @param event
     */
    @Override
    public void mouseClicked(MouseEvent event){
        JLabel clickedLabel = (JLabel) event.getSource();
         
        int smallLabelPos = -1; //no match
        
        for (int i = 0; i < 6; i++) {
            if (clickedLabel == emptySmallLabel[i])    // match
            {
                smallLabelPos = i;
                txtArea.append("\nYou have clicked on a small empty space");
                break;
            }
        }
        System.out.println("Position: " + smallLabelPos);
       
        int largeLabelPos = -1; //no match
        
        for (int i = 0; i < 3; i++) {
            if (clickedLabel == emptyLargeLabel[i])    // match
            {
                largeLabelPos = i;
                txtArea.append("\nYou have clicked on a large empty space");
                break;
            }
        }
        System.out.println("Position: " + largeLabelPos);

        if(event.getButton() == MouseEvent.BUTTON1) {             
            if (clickedLabel.getIcon() == c1 || clickedLabel.getIcon() == c2){           
            System.out.println("Small Furniture Found");
            //smallFurnitureSummary();       
            }
            /**
            if (clickedLabel.getIcon() == c1 || clickedLabel.getIcon() == c2 ){
            txtArea.append("\nYou have clicked on a Chair 1");
            String to_print = "ID: " + chairID.getText() + "\nType Of Wood: " + selectedWood + "\nQuantity: " + quantity.getText() + "\nArmRests: " + selectedArmType;
            JOptionPane.showMessageDialog(null, to_print, "Item Details", JOptionPane.INFORMATION_MESSAGE);
            txtArea.append("\nLeft Click!");
          }
          **/
        }// end button 1 
          if(event.getButton() == MouseEvent.BUTTON2) {
            if (clickedLabel.getIcon() == c1){
            JOptionPane.showMessageDialog(null, "","Change/Update Item", JOptionPane.INFORMATION_MESSAGE);
            txtArea.append("\nMiddle Click!");
          } 
            
        } // end button 2
          if(event.getButton() == MouseEvent.BUTTON3) {
            if (clickedLabel.getIcon() == c1){
            JOptionPane.showMessageDialog(null, "", "Remove the Item", JOptionPane.INFORMATION_MESSAGE);
            txtArea.append("\nRight Click!");
            }
          } //end button 3

    }
    
    @Override
    public void mouseExited(MouseEvent event){}
    
    @Override
    public void mouseMoved(MouseEvent event){

        x = event.getX(); y = event.getY();

    }

    @Override
    public void mouseDragged(MouseEvent event){}

    
    @Override
    public void actionPerformed(ActionEvent event){  

        if(event.getSource() == addChairBTN){

            addChair();
            System.out.println("Chair Button Pressed");
        }

        if(event.getSource() == addTableBTN){

            System.out.println("Table Button Pressed");

        }

        if(event.getSource() == addDeskBTN){

            System.out.println("Desk Button Pressed");

        }
        
        if(event.getSource() == clearAllBTN){

            clearFunction();

        }
        
        if(event.getSource() == totalPriceBTN){

            System.out.println("Total Price Button Pressed");

        }
        
        if(event.getSource() == saveBTN){

            System.out.println("save Button Pressed");
            
            saveToFile();
        }
        
        if(event.getSource() == loadBTN){

            System.out.println("load Button Pressed");
            
            try {
                loadFromFile();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GuiOfficeFurniture.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(event.getSource() == summaryBTN){

            System.out.println("Summary Button Pressed");
            
            displaySummary();
        }
        
        
        
        if(event.getSource() == tempBTN)
        {
            System.out.println("Temp Button Pressed");
            
            tempPlacement();
        }
    }
    
    
    

    public static void main(String[] args) {
        GuiOfficeFurniture RealOfficeFuniture = new GuiOfficeFurniture(); 
        //RealOfficeFuniture.setSize(500,200);
        RealOfficeFuniture.pack();    
        RealOfficeFuniture.setDefaultCloseOperation(EXIT_ON_CLOSE);
          
        RealOfficeFuniture.setVisible(true);              
        
    }

}


class ItemPriceComparator implements Comparator<FurnitureItem> {
    public int compare(FurnitureItem item1, FurnitureItem item2) {
        return (int)item1.getTotalPrice()- (int)item2.getTotalPrice();
    }
}