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
import java.text.DecimalFormat;
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
  } // end Status enum

  /**
   * Status Changeable interface
   */
  public interface StatusChangeable<T> {
    // abstract change status method
    Status changeStatus(Status status);
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
      processBtn.addActionListener(
          e -> {
            // get user input
            String parcelIDInput = logic.userInputPanel.parcelIDTextField.getText().trim();
            String addressInput = logic.userInputPanel.addressTextField.getText().trim();
            String bedroomsInput = logic.userInputPanel.bedroomTextField.getText().trim();
            String squareFootageInput =
                logic.userInputPanel.squareFootageTextField.getText().trim();
            String priceInput = logic.userInputPanel.priceTextField.getText().trim();
            String processType = processComboBox.getSelectedItem().toString();
            String statusType = changeStatusComboBox.getSelectedItem().toString();
            // convert to processable data
            try {
              // if parcel ID is empty throw error
              if (parcelIDInput.equalsIgnoreCase("")) {
                throw new Exception("Parcel ID cannot be empty");
              } // end if statement
              int parcelIDValue =
                  checkForErrors(parcelIDInput, "Parcel ID value is not an integer");
              if (addressInput.equalsIgnoreCase("") &&
                  bedroomsInput.equalsIgnoreCase("") &&
                  squareFootageInput.equalsIgnoreCase("") &&
                  priceInput.equalsIgnoreCase("")) {
                  // find the property by the ID itself
                Property property = logic.database.get(parcelIDValue);
                processData(property, processType);
                // add to transactional array and show pop up
//                logic.transactional.add(property);

              } else {
                if (addressInput.equalsIgnoreCase("")) {
                  throw new Exception("Address cannot be empty");
                } // end if statement
                // process the data
                int bedroomValue = checkForErrors(bedroomsInput, "Bedroom value is not an integer");
                int squareFootageValue =
                        checkForErrors(squareFootageInput, "Square Footage is not an integer");
                int priceValue = checkForErrors(priceInput, "Price is not an integer");
                // create object for comparison and adding to transaction array
                Property currentProcess = new Property(parcelIDValue,
                        addressInput, bedroomValue, squareFootageValue, priceValue, convertStatus(statusType));
                processData(currentProcess, processType); // process the data
              } // end if/else statement
            } catch (Exception err) {
              JOptionPane.showMessageDialog(
                  logic, err.getMessage(), "Error Processing Request", JOptionPane.ERROR_MESSAGE);
            } // end try/catch
          }); // end process button event listener
      changeStatusBtn.addActionListener(e -> {
        // get user input
        String parcelIDInput = logic.userInputPanel.parcelIDTextField.getText().trim();
        String addressInput = logic.userInputPanel.addressTextField.getText().trim();
        String bedroomsInput = logic.userInputPanel.bedroomTextField.getText().trim();
        String squareFootageInput =
                logic.userInputPanel.squareFootageTextField.getText().trim();
        String priceInput = logic.userInputPanel.priceTextField.getText().trim();
        String processType = processComboBox.getSelectedItem().toString();
        String statusType = changeStatusComboBox.getSelectedItem().toString();
        // convert to processable data
        try {
          // if parcel ID is empty throw error
          if (parcelIDInput.equalsIgnoreCase("")) {
            throw new Exception("Parcel ID cannot be empty");
          } // end if statement
          if (addressInput.equalsIgnoreCase("")) {
            throw new Exception("Address cannot be empty");
          } // end if statement
          int parcelIDValue =
                  checkForErrors(parcelIDInput, "Parcel ID value is not an integer");
          int bedroomValue = checkForErrors(bedroomsInput, "Bedroom value is not an integer");
          int squareFootageValue =
                  checkForErrors(squareFootageInput, "Square Footage is not an integer");
          int priceValue = checkForErrors(priceInput, "Price is not an integer");
          // create object for comparison and adding to transaction array
          Property currentProcess = new Property(parcelIDValue,
                  addressInput, bedroomValue, squareFootageValue, priceValue, convertStatus(statusType));
          changeData(currentProcess, statusType);
        } catch (Exception err) {
          JOptionPane.showMessageDialog(
                  logic, err.getMessage(), "Error Processing Request", JOptionPane.ERROR_MESSAGE);
        } // end try/catch
      }); // end change status button event listener
      clearBtn.addActionListener(e -> resetFields()); // end clear button event listener
      exitBtn.addActionListener(e -> exitProgram()); // end exit button event listener
    } // end addComponents method

    /**
     * processes the data from within the
     * text fields and adds it to the HashMap
     */
    private void processData(Property currentProcess, String processType) throws Exception {
      if (currentProcess == null) {
        throw new Exception("Parcel ID cannot be empty");
      } else {
        Function<String, String> checkProcess = k -> {
          if (k.equalsIgnoreCase("find")) {
            return "Record in Database";
          } else {
            return "Success Inserting";
          } // end if/else statement
        }; // end checkProcess function
        Function<Property, String> formatMessage = f -> {
          String startingText = checkProcess.apply(processType);
          DecimalFormat priceFormat = new DecimalFormat("$###,###,###");
          String message = String.format("%s\n%s\n%s\n%s Bedrooms\n%s sq ft\n%s\n%s",
                  startingText,
                  f.parcelID,
                  f.address,
                  f.numberOfBedrooms,
                  f.squareFootage,
                  priceFormat.format(f.price),
                  f.status.toString());
          return message;
        }; // end formatMessage function
        // check for which process type is happening
        if (processType.equalsIgnoreCase("find")) {
          // find process
          Property matchingProperty = logic.database.get(currentProcess.parcelID);
          if (matchingProperty != null) {
            // add to transactional array and show pop up
            logic.transactional.add(matchingProperty);
            JOptionPane.showMessageDialog(logic,
                    formatMessage.apply(matchingProperty),
                    "FOUND: " + matchingProperty.address,
                    JOptionPane.INFORMATION_MESSAGE);
          } else {
            throw new Exception("Could not locate Parcel ID");
          } // end if/else statement
        } else if (processType.equalsIgnoreCase("insert")) {
          // insert process
          Property matchingProperty = logic.database.get(currentProcess.parcelID);
          if (currentProcess != null) {
            if (matchingProperty == null) {
              // add to transactional array and show pop up
              logic.transactional.add(currentProcess);
              logic.database.put(currentProcess.parcelID, currentProcess);
              JOptionPane.showMessageDialog(logic,
                      formatMessage.apply(currentProcess),
                      "INSERTED: " + currentProcess.address,
                      JOptionPane.INFORMATION_MESSAGE);
            } else {
              throw new Exception("Parcel ID exists");
            } // end if/else statement
          } else {
            throw new Exception("Property is not complete");
          } // end if/else statement
        } else {
          // delete process
          Property matchingProperty = logic.database.get(currentProcess.parcelID);
          if (currentProcess != null && matchingProperty != null) {
            logic.transactional.add(currentProcess);
            logic.database.remove(currentProcess.parcelID);
            JOptionPane.showMessageDialog(logic,
                    currentProcess.toString(),
                    "DELETED: " + currentProcess.address,
                    JOptionPane.INFORMATION_MESSAGE);
          } else {
            throw new Exception("Parcel ID does not exist");
          } // end if/else statement
        } // end if/else if/else statement
      } // end if/else statement
    } // end processData method

    /**
     * changes the current listing based in the database
     */
    private void changeData(Property currentProcess, String statusType) throws Exception {
      Property matchingProperty = logic.database.get(currentProcess.parcelID);
      // check for which status change is happening
      if (statusType.equalsIgnoreCase("for_sale")) {
        modifyStatus(currentProcess, matchingProperty, Status.FOR_SALE);
      } else if (statusType.equalsIgnoreCase("under_contract")) {
        // under contract change
        modifyStatus(currentProcess, matchingProperty, Status.UNDER_CONTRACT);
      } else {
        // sold change
        modifyStatus(currentProcess, matchingProperty, Status.SOLD);
      } // end if/else if/else statement
    } // end changeData method

    /**
     * modifies the status of a property by changing the status,
     * throwing an exception if there is an error, and showing a
     * JOptionsPane to the user
     * @param currentProcess PROPERTY current property being processed
     * @param matchingProperty PROPERTY property to be replaced
     * @param status STATUS listing status to be changed
     * @throws Exception
     */
    private void modifyStatus(Property currentProcess, Property matchingProperty, Status status) throws Exception {
      // for sale change
      if (matchingProperty != null) {
        matchingProperty.changeStatus(status); // change the status
        logic.database.replace(currentProcess.parcelID, matchingProperty); // replace the property
        logic.transactional.add(matchingProperty); // add to transactional array
        JOptionPane.showMessageDialog(logic,
                String.format("Updated Property:\n\n%s",
                        matchingProperty.toString()),
                "UPDATED: " + matchingProperty.address,
                JOptionPane.INFORMATION_MESSAGE); // show dialog message
      } else {
        throw new Exception("Could not locate property");
      } // end if/else statement
    } // end modifyStatus method

    /**
     * Check for errors when parsing integers
     * @param userInput STRING users input from the program
     * @param message STRING message to display to user
     * @return INT successfully parsed integer
     */
    private int checkForErrors(String userInput, String message) throws Exception {
      int currentUserInput;
      try {
        currentUserInput = Integer.parseInt(userInput);
      } catch (NumberFormatException e) {
        throw new Exception(message);
      } // end try/catch
      return currentUserInput;
    } // end checkForErrors method

    /**
     * convert the string of status to an integer value to use
     * in the construction of temporary property object
     * @param status STRING string value of status combo box
     * @return INT integer value of status enum
     */
    private int convertStatus(String status) {
      int currentStatus = 0;

      switch (status) {
        case "FOR_SALE":
          currentStatus = 0;
          break;
        case "UNDER_CONTRACT":
          currentStatus = 1;
          break;
        case "SOLD":
          currentStatus = 2;
          break;
      } // end switch statement

      return currentStatus;
    } // end convertStatus method

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
      List<Property> transactional = logic.transactional;
      Map<Integer, Property> database = logic.database;

      // print the transactional array to console
      System.out.println("\nTRANSACTIONAL:");
      for (Property listItem : transactional) {
        System.out.println(listItem.toString());
      } // end for loop

      System.out.println("MODIFIED HASHMAP:");
      // print the modified hashmap to console
      for (Map.Entry<Integer, Property> mapItem : database.entrySet()) {
        Property currentProperty = mapItem.getValue();

        System.out.println(currentProperty.toString());
      } // end for loop

      System.exit(0); // terminate the program
    } // end exitProgram method

  } // end ButtonPanel class

  public static class ControllerLogic extends JPanel {
    UserInputPanel userInputPanel = new UserInputPanel(this);
    ButtonPanel buttonPanel = new ButtonPanel(this);
    FlowLayout logicLayout = new FlowLayout(FlowLayout.CENTER);
    public File textFile;
    public Map<Integer, Property> database;
    public List<Property> transactional;
    private int PREF_W = 400;
    private int PREF_H = 350;

    public ControllerLogic(File textFile) {
      this.textFile = textFile;
      this.database = readFile();
      this.transactional = new ArrayList<>();
      setLayout(logicLayout);
      setBackground(Color.LIGHT_GRAY);
      setPreferredSize(new Dimension(PREF_W, PREF_H));
      add(userInputPanel);
      add(buttonPanel);
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
        System.out.println("ERROR: " + e.getMessage());
      } finally{
        System.out.println("RUN:");
        // print the hashmap data to the console
        for (Map.Entry<Integer, Property> mapItem : hashmap.entrySet()) {
          Property currentProperty = mapItem.getValue();
          // print current item to console
          System.out.println(currentProperty.toString());
          // change status to for sale
          currentProperty.changeStatus(Status.FOR_SALE);
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

  } // end Program Core class

  public static void main(String[] args) {
    // create new application and set display to true
    ProgramCore frame = new ProgramCore();
    frame.setVisible(true);
  } // end main method

} // end CMIS242PRJ4BryanD
