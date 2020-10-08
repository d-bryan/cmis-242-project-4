# Rubric Checklist

## Enumerated type (10 points)

1. The enumerated type should be named Status and should contain three enumeration literals, FOR_SALE, UNDER_CONTRACT and SOLD.

## Interface type (10 points)

The Interface should have the following two methods:

1. The statusChangeable method has a bounded generic type parameter that is an enumerated.
2. The changeStatus abstract method has a generic type parameter.

## Property Class (20 points)

It should implement the StatusChangeable interface. It should contain six instance variables:

1. Parcel ID is integer
2. Property Address is string
3. Number Bedrooms is integer
4. Square Footage is integer
5. Property Price is integer
6. Property Status is an enumerated type with integers of 0, 1, and 2 as equivalence

In addition, it should have the following three methods:

1. A constructor that accepts six parameters for the purpose of initializing the characteristics of the property, specifically

    - Parcel ID
    - Property Address
    - Number Bedrooms
    - Square Footage
    - Property Price
    - Property Status

The Property Status should be set to FOR_SALE (0).

2. A method named changeStatus that allows the status of the property to be changed.
3. An overridden toString method that returns a string containing the Parcel ID, Property Address, Number Bedrooms, Square Footage, Property Price, and Property Status.

## GUI Display (20 points)

1. Window displays graphically information and actions of the program. 

2. Window includes the values of the HashMap: Parcel ID, Property Address, Number Bedrooms, Square Footage, Property Price, and Property Status.

3. When the Process button is clicked, it affects the data in the HashMap:

    - Insert process that adds a new record to the HashMap.
    - Delete process that removed a record from the HashMap.
    - Find process that displays a record in the HashMap.

4. A message displays when process is successfully completed including the type of process and all the property information is appropriate.

5. An error messages displays when:

    - Process button click and nothing in the Parcel ID.
    - A non-integer is the Parcel ID TextField.
    - A non-integer is the Bedrooms TextField.
    - A non-integer is the Square Footage TextField.
    - A non-integer is the Property Price TextField.

6. The Change Status button modifies the HashMap based on the appropriate enumerated type.
7. There is Clear button to remove all text from the TextFields and places cursor in the Parcel ID box.
8. There is an Exit button that ends the program after displaying a message of thanks and identification of the program.

## Program Core (20 points)

1. Contains the main method at end of code.
2. Contains a class variable that defines the database of property records, implemented as a HashMap, with the Parcel ID field as the key and a Property object as the value.
3. Uses PRJ4Property.txt for a basic set of data read into the HashMap of the program.
4. Generates the GUI Display with all elements displayed on image on Page2 of the Project4 document.
5. A Transaction array is declared and defined to hold each process during the program run.
6. When program begins, each record in the HashMap that is read into the program is displayed in the IDE Output Window using toString().
7. During the execution of the program each process transaction is assigned to a Transaction array. At the end of the program, all the transactions assigned to the Transaction array are displayed in the IDE Output Window using toSting().
8. When the program ends, the set of data in the modified HashMap is displayed in IDE Output Window using toString() after the transactions are displayed. This display is after the data from the Transaction array is displayed.
9. Each of the three outputs have a tag describing the type of data displayed.

## Test Cases (10 points)

1. Test cases are supplied in the form of a table with columns indicating the input values, processes, outputs, messages, and supporting screen shots.
2. Enough data examples selected to completely test the program.
3. Test cases were included in the supporting word or PDF documentation.

## Documentation and Style Guide (10 points)

1. Screen captures were provided and labeled for compiling your code and running each of your test cases.
2. Header comments include filename, author, date and brief purpose of the program.
3. In-line comments used to describe major functionality of the code.
4. Meaningful variable names and prompts applied.
5. Class names are written in UpperCamelCase.
6. Variable names are written in LowerCamelCase.
7. Constant names are in written in All Capitals.
8. Braces use K&R style.
9. Declare all instance variables private.
10. Avoids the duplication of code.
