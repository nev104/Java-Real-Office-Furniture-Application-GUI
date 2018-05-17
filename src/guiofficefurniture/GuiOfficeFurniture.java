package guiofficefurniture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiOfficeFurniture extends JFrame implements ActionListener, MouseListener, MouseMotionListener{
        
    private JLabel Chair1, Chair2, Desk1, Desk2, Desk3, Desk4, Table1, Table2;
    private JLabel emptySmall1, emptySmall2, emptySmall3, emptySmall4, emptySmall5, emptySmall6;
    private JLabel emptyLarge1, emptyLarge2, emptyLarge3;
    private ImageIcon c1, c2, d1, d2, d3, d4, t1, t2, eS1, eS2, eS3, eS4, eS5, eS6, eL1, eL2, eL3;
    
    //IMAGEICONS
    ImageIcon emptyL = new ImageIcon("/img/empty_w100xh100.png");
    //ImageIcon emptyS = new ImageIcon("emptyS.jpg");
    
    Image emptyImage = emptyL.getImage();
    
    
    //ARRAYS    
    //static FurnitureItem[] largeV = new Vehicle[4];
    static FurnitureItem[] smallItem = new FurnitureItem[6];
    static FurnitureItem[] largeItem = new FurnitureItem[3];
    
    
    //CONSTRUCTORS
    //static Chair newChair = new Chair();
    
    private JButton addChairBTN = new JButton();
    private JButton addTableBTN = new JButton();
    private JButton addDeskBTN = new JButton();
    private JButton clearAllBTN = new JButton();
    private JButton totalPriceBTN = new JButton();
    private JButton saveBTN = new JButton();
    private JButton loadBTN = new JButton();
    private JButton summaryBTN = new JButton();
    
    JTextArea txtArea = new JTextArea(8,38);
    int x,y;
    
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
        summaryBTN.setText("Total for day");
        btnPanel.add(summaryBTN);
        
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
        
        
        //need to set es1 etc.. in an array
        
        //ImageIcon eS = new ImageIcon(getClass().getResource("/img/empty_w100xh100.png"));
        //ImageIcon eL = new ImageIcon(getClass().getResource("/img/empty_w150xh100.png"));
        
        //ARRAYS
        
        eS1 = new ImageIcon(getClass().getResource("/img/empty_w100xh100.png"));
        emptySmall1 = new JLabel(eS1);
        emptySmall1.setOpaque(true);
        
        eS2 = new ImageIcon(getClass().getResource("/img/empty_w100xh100.png"));
        emptySmall2 = new JLabel(eS2);
        emptySmall2.setOpaque(true);
        
        eS3 = new ImageIcon(getClass().getResource("/img/empty_w100xh100.png"));
        emptySmall3 = new JLabel(eS3);
        emptySmall3.setOpaque(true);
        
        eS4 = new ImageIcon(getClass().getResource("/img/empty_w100xh100.png"));
        emptySmall4 = new JLabel(eS4);
        emptySmall4.setOpaque(true);
        
        eS5 = new ImageIcon(getClass().getResource("/img/empty_w100xh100.png"));
        emptySmall5 = new JLabel(eS5);
        emptySmall5.setOpaque(true);
        
        eS6 = new ImageIcon(getClass().getResource("/img/empty_w100xh100.png"));
        emptySmall6 = new JLabel(eS6);
        emptySmall6.setOpaque(true);
        
        eL1 = new ImageIcon(getClass().getResource("/img/empty_w150xh100.png"));
        emptyLarge1 = new JLabel(eL1);
        emptyLarge1.setOpaque(true);
        
        eL2 = new ImageIcon(getClass().getResource("/img/empty_w150xh100.png"));
        emptyLarge2 = new JLabel(eL2);
        emptyLarge2.setOpaque(true);
        
        
        eL3 = new ImageIcon(getClass().getResource("/img/empty_w150xh100.png"));
        emptyLarge3 = new JLabel(eL3);
        emptyLarge3.setOpaque(true);
        
        ctPanel.add(emptySmall1);
        ctPanel.add(emptySmall2);
        ctPanel.add(emptySmall3);
        ctPanel.add(emptySmall4);
        ctPanel.add(emptySmall5);
        ctPanel.add(emptySmall6);
              
        deskPanel.add(emptyLarge1);
        deskPanel.add(emptyLarge2);
        deskPanel.add(emptyLarge3);
               
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
        
        emptySmall1.addMouseListener(this);
        
        emptySmall2.addMouseListener(this);
        
        emptySmall3.addMouseListener(this);
        
        emptySmall4.addMouseListener(this);
        
        emptySmall5.addMouseListener(this);
        
        emptySmall6.addMouseListener(this);

        txtArea.addMouseListener(this);

        txtArea.addMouseMotionListener(this);     
        
    } //end of contructor
    
    //static void newChair(){
    
    public Chair createChair(){
       
        
        JTextField chairID = new JTextField(8);
        JTextField typeOfWood = new JTextField(8);
        JTextField quantity = new JTextField(5);
        
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
        
        int chairBtnResult = JOptionPane.showConfirmDialog(null, myChair, 
               "Chair Selected", JOptionPane.OK_CANCEL_OPTION);
        if (chairBtnResult == JOptionPane.OK_OPTION) {
           System.out.println("chairID: " + chairID.getText());
        if (oak.isSelected()){               
                System.out.println("Type of Wood Selected: " + oak.getText());
                
           } 
           else if (chair2.isSelected()){
                System.out.println("Type of Wood Selected: " + walnut.getText());
           }         
           System.out.println("Quantity: " + quantity.getText());

           if (chair1.isSelected()){               
                System.out.println("Chair1: " + chair1.getText());
                
                emptySmall3.setIcon(c1);
                //emptySmall1.setIcon(smallItem[0].getImage());
                
                //for (int i = 0; i < 6; i++){
                    
                    //System.out.println(smallSpaces[i]);
                                  
               // }
                
                //emptySmall1.setIcon(c1);
           } 
           else if (chair2.isSelected()){
                System.out.println("Chair2: " + chair2.getText());
                emptySmall6.setIcon(c2);
           } 
        }    
        if (chairBtnResult == JOptionPane.OK_OPTION){
            System.out.println("OK Pressed");
            
        } else if (chairBtnResult == JOptionPane.CANCEL_OPTION) {          
            System.out.println("Cancel Pressed");      
        }
        
     Chair newChair = new Chair(chairID.getText());
     
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

    public void mouseClicked(MouseEvent event){}

    public void mouseExited(MouseEvent event){}

    public void mouseMoved(MouseEvent event){

        x = event.getX(); y = event.getY();

    }

    public void mouseDragged(MouseEvent event){}

    

    public void actionPerformed(ActionEvent event){  

        if(event.getSource() == addChairBTN){

            createChair();
            System.out.println("Chair Button Pressed");
        }

        if(event.getSource() == addTableBTN){

            System.out.println("Table Button Pressed");

        }

        if(event.getSource() == addDeskBTN){

            System.out.println("Desk Button Pressed");

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
