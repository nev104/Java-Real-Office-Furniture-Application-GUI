package guiofficefurniture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GuiOfficeFurniture extends JFrame implements ActionListener, MouseListener, MouseMotionListener{
        
    private JLabel Chair1, Chair2, Desk1, Desk2, Desk3, Desk4, Table1, Table2;
    //private JLabel emptySmall1, emptySmall2, emptySmall3, emptySmall4, emptySmall5, emptySmall6;
    //private JLabel emptyLarge1, emptyLarge2, emptyLarge3;
    private ImageIcon c1, c2, d1, d2, d3, d4, t1, t2;// eS1, eS2, eS3, eS4, eS5, eS6, eL1, eL2, eL3;
    
    // counters
    int smallGridpos = 0;
    int pos;
    
    // Collections
    static FurnitureItem[] smallF = new FurnitureItem[6];
    static FurnitureItem[] largeV = new FurnitureItem[3];
    
    static ArrayList<Chair> aChair = new ArrayList<>();
    static ArrayList<Table> aTable = new ArrayList<>();
    static ArrayList<Desk> aDesk = new ArrayList<>();
    
    static double totalPrice = 0;
    
    JTextField chairID = new JTextField(8);
    JTextField typeOfWood = new JTextField(8);
    JTextField quantity = new JTextField(5);
  
    ImageIcon emptySmall = new ImageIcon(getClass().getResource("/img/empty_w100xh100.png"));
    JLabel[] emptySmallLabel = new JLabel[6];
    
    ImageIcon emptyLarge = new ImageIcon(getClass().getResource("/img/empty_w150xh100.png"));   
    JLabel[] emptyLargeLabel = new JLabel[3];
    
    private JButton addChairBTN = new JButton();
    private JButton addTableBTN = new JButton();
    private JButton addDeskBTN = new JButton();
    private JButton clearAllBTN = new JButton();
    private JButton totalPriceBTN = new JButton();
    private JButton saveBTN = new JButton();
    private JButton loadBTN = new JButton();
    private JButton summaryBTN = new JButton();
    private JButton tempBTN = new JButton();
    
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
                
        JPanel btnPanel = new JPanel(new GridLayout(8,1));
        
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
        Desk1.addMouseListener(this);
        Desk2.addMouseListener(this);
        Desk3.addMouseListener(this);
        Desk4.addMouseListener(this);
        Table1.addMouseListener(this);
        Table2.addMouseListener(this);
        
        txtArea.addMouseListener(this);

        txtArea.addMouseMotionListener(this);
        
    } //end of contructor
    
    // show summary for furniture
    void smallFurnitureSummary(Chair sumChair){    
        System.out.println("Small Furniture Summary Here: ");     
        txtArea.append("\nYou have clicked on a Small Furniture Item");
        JOptionPane.showMessageDialog(null, sumChair.toString(), "Item Details", JOptionPane.INFORMATION_MESSAGE);   
    }
    
    // tempory realod array to test placement
    void tempPlacement()
    {
        clearFunction();
        
        // list though all chair classes
        for(Chair singleChair : aChair)
        {
            if(singleChair.getArmRests() == true)
            {
                emptySmallLabel[smallGridpos].setIcon(c1);
                //emptySmallLabel[smallGridpos].a
                smallGridpos++;
            }
            else
            {
                
                
            }
            totalPrice = totalPrice + (singleChair.getTotalPrice());
        }
        
        
    }
    
    
    
    
    //static void newChair(){
    
    public Chair addChair(){
        
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
                System.out.println("Chair1: " + chair1.getText());
                //emptySmall3.setIcon(c1);
                tempBool = false;
                emptySmallLabel[smallGridpos].setIcon(c1);
                smallGridpos++;
           } 
           else if (chair2.isSelected()){
                System.out.println("Chair2: " + chair2.getText());
                //emptySmall6.setIcon(c2);
                tempBool = true;
                emptySmallLabel[smallGridpos].setIcon(c2);
                smallGridpos++;
           } 
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
        Chair newChair = new Chair(id, tempChar, qty, tempBool);
        
        aChair.add(newChair);
        
        return newChair;
    }
 

    public void mouseEntered(MouseEvent event){

        txtArea.setText("Mouse Entered");

    }

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

    public void mouseReleased(MouseEvent event){

        txtArea.append("\nMouse released");

    }

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

    public void mouseExited(MouseEvent event){}

    public void mouseMoved(MouseEvent event){

        x = event.getX(); y = event.getY();

    }

    public void mouseDragged(MouseEvent event){}

    

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
        
        if(event.getSource() == tempBTN)
        {
            System.out.println("Temp Button Pressed");
            
            tempPlacement();
        }

    }
    
    // clear function
    void clearFunction()
    {
        System.out.println("Clear All Button Pressed");
        smallGridpos = 0; //reset position

        for (int i = 0; i < 6; i++){     
            //emptySmallLabel[i] = new JLabel();
            emptySmallLabel[i].setIcon(emptySmall);          
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
