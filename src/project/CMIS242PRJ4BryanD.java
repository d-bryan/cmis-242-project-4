/*******************************************************************************
 * File: CMIS242PRJ4BryanD.java
 * Author: Dylan Bryan
 * Date: 10/8/20, 9:40 AM
 * Purpose: To create and test a real estate database using data structures.
 ******************************************************************************/

package project;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.function.Function;

public class CMIS242PRJ4BryanD {

  /**
   * Enum Status
   */
  public enum Status {
    // enumerated status types
    FOR_SALE(0),
    UNDER_CONTRACT(1),
    SOLD(2);
    // private integer
    private int value;
    // constructor
    Status(int value) {
      this.value = value;
    } // end constructor
    // getter for numeric value
    public int getValue() {
      return value;
    } // end getter

  } // end Status enum

  /**
   * Status Changeable interface
   */
  public interface StatusChangeable {
    // TODO: the statusChangeable method has a bounded generic type parameter
    //  that is an enumerated type
    // TODO: the changeStatus abstract method has a generic type parameter
    // abstract change status method
    Status changeStatus(Status status);
//    // abstract statusChangeable
//    Status statusChangeable(Status status);

  } // end StatusChangeable interface

  /**
   * Property class - Implements Status Changeable interface
   */
  public static class Property implements StatusChangeable {
    private int parcelID;
    private String address;
    private int numberOfBedrooms;
    private int squareFootage;
    private int price;
    private Status status;

    /**
     * Property constructor creates a new property
     * @param parcelID INT ID number for property
     * @param address STRING address for property
     * @param numberOfBedrooms INT total bedrooms for property
     * @param squareFootage INT total square footage for property
     * @param price INT total cost of property
     * @param status STATUS current listing status for property
     */
    public Property(int parcelID,
                    String address,
                    int numberOfBedrooms,
                    int squareFootage,
                    int price,
                    int status) {
      this.parcelID = parcelID;
      this.address = address;
      this.numberOfBedrooms = numberOfBedrooms;
      this.squareFootage = squareFootage;
      this.price = price;
      // set status depending upon input
      switch (status) {
        case 0:
          this.status = Status.FOR_SALE;
          break;
        case 1:
          this.status = Status.UNDER_CONTRACT;
          break;
        case 2:
          this.status = Status.SOLD;
          break;
      } // end switch statement

      // TODO: change the current status to FOR_SALE
    } // end Property constructor


    @Override
    public Status changeStatus(Status status) {
      return this.status = status;
    } // end changeStatus method

    @Override
    public String toString() {
      return String.format("Parcel ID: %s\nProperty address: %s\n" +
              "Number of bedrooms: %s\nSquare footage: %s\n" +
              "Property price: %s\nCurrent status: %s\n",
              parcelID,
              address,
              numberOfBedrooms,
              squareFootage,
              price,
              status);
    } // end toString method

  } // end Property class

  /**
   * User Input Panel class
   */
  public static class UserInputPanel extends JPanel {
    public ControllerLogic logic;
    private GridLayout userInputLayout = new GridLayout(5, 2, 1, 1);
    private int PREF_W = 325;
    private int PREF_H = 200;
    // labels
    JLabel parcelIDLabel = new JLabel("Parcel ID:", JLabel.LEFT);
    JLabel addressLabel = new JLabel("Address:", JLabel.LEFT);
    JLabel bedroomLabel = new JLabel("Bedrooms:", JLabel.LEFT);
    JLabel squareFootageLabel = new JLabel("Square Footage:", JLabel.LEFT);
    JLabel priceLabel = new JLabel("Property Price:", JLabel.LEFT);
    // input fields
    JTextField parcelIDTextField = new JTextField("");
    JTextField addressTextField = new JTextField("");
    JTextField bedroomTextField = new JTextField("");
    JTextField squareFootageTextField = new JTextField("");
    JTextField priceTextField = new JTextField("");
    // array of text fields
    JTextField[] textFieldArray = { parcelIDTextField,
            addressTextField, bedroomTextField, squareFootageTextField, priceTextField };

    public UserInputPanel(ControllerLogic logic) {
      // setup panel for components
      this.logic = logic;
      setLayout(userInputLayout);
      setBackground(Color.LIGHT_GRAY);
      setPreferredSize(new Dimension(PREF_W, PREF_H));
      // add components
      addComponents();
    } // end UserInputPanel constructor

    /**
     * add components to the panel
     */
    private void addComponents() {
      add(parcelIDLabel, 0);
      add(parcelIDTextField, 1);
      add(addressLabel, 2);
      add(addressTextField, 3);
      add(bedroomLabel, 4);
      add(bedroomTextField, 5);
      add(squareFootageLabel, 6);
      add(squareFootageTextField, 7);
      add(priceLabel, 8);
      add(priceTextField, 9);
    } // end addComponents method

  } // end UserInputPanel class

  /**
   * Button Panel class
   */
  public static class ButtonPanel extends JPanel {
    public ControllerLogic logic;
    private GridLayout buttonLayout = new GridLayout(3, 2, 1, 1);
    private int PREF_W = 350;
    private int PREF_H = 100;
    // buttons
    Button processBtn = new Button("Process");
    Button changeStatusBtn = new Button("Change Status");
    Button clearBtn = new Button("Clear");
    Button exitBtn = new Button("Exit");
    // combo boxes
    String[] processOptions = { "Find", "Insert", "Delete" };
    String[] changeStatusOptions = { Status.FOR_SALE.toString(),
            Status.UNDER_CONTRACT.toString(), Status.SOLD.toString() };
    JComboBox processComboBox = new JComboBox(processOptions);
    JComboBox changeStatusComboBox = new JComboBox(changeStatusOptions);

    public ButtonPanel(ControllerLogic logic) {
      // setup panel for components
      this.logic = logic;
      setLayout(buttonLayout);
      setBackground(Color.LIGHT_GRAY);
      setPreferredSize(new Dimension(PREF_W, PREF_H));
      // add components
      addComponents();
    } // end ButtonPanel constructor

    /**
     * add components to the panel
     */
    private void addComponents() {
      // components
      add(processBtn, 0);
      add(processComboBox,1);
      add(changeStatusBtn, 2);
      add(changeStatusComboBox, 3);
      add(clearBtn, 4);
      add(exitBtn, 5);
      // event listeners
      processBtn.addActionListener(e -> {

      }); // end process button event listener
      changeStatusBtn.addActionListener(e -> {

      }); // end change status button event listener
      clearBtn.addActionListener(e -> resetFields()); // end clear button event listener
      exitBtn.addActionListener(e -> exitProgram()); // end exit button event listener
    } // end addComponents method

    /**
     * processes the data from within the
     * text fields and adds it to the HashMap
     */
    private void processData() {
      // TODO: Find process that displays a record in the HashMap
      // TODO: Insert process that adds a new record to the HashMap
      // TODO: Delete process that removed a record from the HashMap

    } // end processData method

    /**
     * changes the current listing based in the database
     */
    private void changeData() {
      // TODO: modifies the HashMap based on the appropriate enumerated type
    } // end changeData method

    /**
     * checks for input errors from user
     */
    private void checkForErrors() {
      // TODO: process button clicked and nothing in id text field
      // TODO: non integer in parcel id field
      // TODO: non integer in bedrooms field
      // TODO: non integer in square footage field
      // TODO: non integer price field
    } // end checkForErrors method

    /**
     * Reset the text fields and combo boxes
     * to their default settings
     */
    private void resetFields() {
      processComboBox.setSelectedIndex(0);
      changeStatusComboBox.setSelectedIndex(0);
      logic.userInputPanel.parcelIDTextField.setText("");
      logic.userInputPanel.addressTextField.setText("");
      logic.userInputPanel.bedroomTextField.setText("");
      logic.userInputPanel.squareFootageTextField.setText("");
      logic.userInputPanel.priceTextField.setText("");
      logic.userInputPanel.parcelIDTextField.requestFocus();
    } // end resetFields method

    /**
     * Prints transactional array and modified
     * hashmap data to the console before exiting
     * the program
     */
    private void exitProgram() {
      // TODO: print the Transaction Array to the console
      // TODO: print the modified HashMap to the console
      System.exit(0); // terminate the program
    } // end exitProgram method

  } // end ButtonPanel class

  public static class ControllerLogic extends JPanel {
    UserInputPanel userInputPanel = new UserInputPanel(this);
    ButtonPanel buttonPanel = new ButtonPanel(this);
    FlowLayout logicLayout = new FlowLayout(FlowLayout.CENTER);
    public File textFile;
    public Map<Integer, Property> database;
    private int PREF_W = 400;
    private int PREF_H = 350;

    public ControllerLogic(File textFile) {
      this.textFile = textFile;
      setLayout(logicLayout);
      setBackground(Color.LIGHT_GRAY);
      setPreferredSize(new Dimension(PREF_W, PREF_H));
      add(userInputPanel);
      add(buttonPanel);
      this.database = readFile();
    } // end ControllerLogic constructor

    /**
     * read the text file, set the contents to the
     * HashMap and print the contents to the console
     */
    private Map<Integer, Property> readFile() {
      Map<Integer, Property> hashmap = new HashMap<>();
      Scanner sc;

      try {
        BufferedReader inputStream = new BufferedReader(new FileReader(textFile));
        sc = new Scanner(inputStream);
        while (sc.hasNext()) {
          String[] items;
          String currentLine = sc.nextLine();
          String modifiedString;
          // add items to array
          int currentID = Integer.parseInt(currentLine.substring(0, 4).trim());
          modifiedString = currentLine.substring(5, currentLine.length());
          items = modifiedString.split(",");
          // parse data from array
          String address = items[0];
          int numberOfRooms = Integer.parseInt(items[1].trim());
          int squareFootage = Integer.parseInt(items[2].trim());
          int price = Integer.parseInt(items[3].trim());
          int status = Integer.parseInt(items[4].trim());
          // add to hashmap
          Property currentListing = new Property(currentID,
                  address, numberOfRooms, squareFootage, price, status);
          hashmap.put(currentID, currentListing);
        } // end while loop
      } catch (FileNotFoundException | InputMismatchException | NumberFormatException e) {
        System.out.println("File Not Found: " + e.getMessage());
      } finally{
        System.out.println("run:");
        // print the hashmap data to the console
        for (Map.Entry<Integer, Property> mapItem : hashmap.entrySet()) {
          Property currentProperty = mapItem.getValue();

          System.out.println(currentProperty.toString());
        } // end for loop
      } // end try/catch/finally

      return hashmap;
    } // end readFile method

  } // end ControllerLogic class

  /**
   * Program Core class
   */
  public static class ProgramCore extends JFrame {
    public File textFile = new File("PRJ4Property.txt");
    private int PREF_W = 400;
    private int PREF_H = 350;
    ControllerLogic logic = new ControllerLogic(textFile);

    // creates the GUI for the program and starts the application
    public ProgramCore() {
      super("Real Estate Database");
      setFrame(PREF_W, PREF_H);
      addComponents();
    } // end ProgramCore constructor

    /**
     * Sets the current frame width and height while allowing to close
     * the window upon exiting the program
     * @param width INT width of the frame
     * @param height INT height of the frame
     */
    private void setFrame(int width, int height) {
      setSize(width, height);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end setFrame method

    /**
     * Add components to the frame
     */
    private void addComponents() {
      setBackground(Color.LIGHT_GRAY);
      add(logic);
    } // end addComponents method

    // TODO: create static variable that defines database property records implemented as a HashMap
    //  with Parcel ID field as the key and Property object as the value
    // TODO: Use PRJ4Property.txt file for a basic set of data read into the HashMap of program
    // TODO: Generate the GUI display with all elements displayed
    // TODO: Transactional Array is declared and defined to hold each process during program run
    // TODO: Upon program start, each record read into HashMap is displayed into IDE
    //  output window using toString() method -- READ DATA
    // TODO: During execution of of the program, each process transaction is assigned to transaction
    //  array. At the end of the program, all transactions assigned are displayed in the IDE output
    //  window using toString() method -- TRANSACTION DATA
    // TODO: When the program ends, the data in the modified HashMap is displayed in IDE output
    //  window using toString() method after the transactions are displayed -- MODIFIED DATA
    // TODO: each of the three outputs have a tag describing the data displayed
  } // end Program Core class

  public static void main(String[] args) {
    // create new application and set display to true
    ProgramCore frame = new ProgramCore();
    frame.setVisible(true);
  } // end main method

} // end CMIS242PRJ4BryanD
