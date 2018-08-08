package com.serviceImplementation;

import java.sql.*;
import java.util.Scanner;

public class DBService{

    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    public static void workWithDBForAddressBook() throws SQLException, ClassNotFoundException {

        System.out.println("Working with DB ! We would initialize the default Database!");

            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println(" Establishing Connection");

            connect = DriverManager.getConnection("jdbc:mysql://localhost/addressbook?" + "user=sqluser&password=sqluserpw");

            System.out.println("Bye!");

            statement = connect.createStatement();

            Scanner sc = new Scanner( System.in );

//            resultSet = statement.executeQuery("select * from addressbook.book1");

            System.out.println("Now that everything is initialized , time to find out what you want to do !");


            String choice = "";

            do {

                System.out.println("Enter 1 to search for person , 2 to add person to addressBook , 3 to delete person , 4 to edit details of a person");

                System.out.println("5 to Total population of AddressBook , 6 show AddressBook details , 0 to Exit");

                choice = sc.nextLine();

                if(choice.equals("1")){

                    System.out.println("Enter the first name and then last name of person you want to search!");

                    String firstName = sc.nextLine();

                    String lastName = sc.nextLine();

//                    preparedStatement = connect.prepareStatement(
//                      "select * from addressbook.book1 where FirstName = ? and LastName = ? ;"
//                    );
//
//                    preparedStatement.setString(1,firstName);
//
//                    preparedStatement.setString(2,lastName);
//
//                    resultSet = preparedStatement.executeQuery();

                    statement = connect.createStatement();

                    String query = "select * from addressbook.book1 where FirstName = '" + firstName +"' and LastName = '" + lastName + "';";

                    resultSet = statement.executeQuery(query);
                    /*
                    if(!resultSet.next()){

                        System.out.println("Cannot be found any such person!");

                    }

                    else{
                    */
//                        System.out.println("Hey Printing now!");

                        showResultSet(resultSet);

                        System.out.println("Done printing? ");

//                    }


                }

                if(choice.equals("2")){

                    System.out.println("Adding new Person to AddressBook!");

                    System.out.println("Enter First Name , Last Name , Phone Number , Flat Number , Building , Landmark , City , State , Pincode");

                    String firstName = sc.nextLine();

                    String lastName = sc.nextLine();

                    String phoneNumber = sc.nextLine();

                    String flatNumber = sc.nextLine();

                    String buildingName = sc.nextLine();

                    String landmark = sc.nextLine();

                    String city = sc.nextLine();

                    String state = sc.nextLine();

                    String pinCode = sc.nextLine();

                    preparedStatement = connect.prepareStatement(
                            "insert into addressbook.book1 values ( ? , ? , ? , ? , ? , ? ,? , ? , ? );"
                    );

                    preparedStatement.setString(1,firstName);
                    preparedStatement.setString(2,lastName);
                    preparedStatement.setString(3,phoneNumber);
                    preparedStatement.setString(4,flatNumber);
                    preparedStatement.setString(5,buildingName);
                    preparedStatement.setString(6,landmark);
                    preparedStatement.setString(7,city);
                    preparedStatement.setString(8,state);
                    preparedStatement.setString(9,pinCode);

                    preparedStatement.addBatch();

                    preparedStatement.executeBatch();

                    System.out.println("New Person Added!");

                }

                if(choice.equals("3")){

                    System.out.println("Deleting Person !");

                    System.out.println("Enter your first name then last name");

                    String firstName = sc.nextLine();

                    String lastName = sc.nextLine();

                    preparedStatement = connect.prepareStatement(
                            "delete * from addressbook.book1 where FirstName = ? and LastName = ?;"
                    );

                    preparedStatement.setString(1,firstName);

                    preparedStatement.setString(2,lastName);

                    preparedStatement.executeUpdate();
/*
                    if(!resultSet.next()){

                        System.out.println("No such person found!");

                    }
*/
                    System.out.println("Successfully Deleted!");

                }

                if(choice.equals("4")){

                    System.out.println("Enter your first name and last name");

                    String firstName = sc.nextLine();

                    String lastName = sc.nextLine();

                    preparedStatement = connect.prepareStatement(
                            "select * from addressbook.book1 where FirstName = ? and LastName = ?;"
                    );

                    preparedStatement.setString(1,firstName);

                    preparedStatement.setString(2,lastName);

                    resultSet = preparedStatement.executeQuery();

                    /*
                    if(!resultSet.next()){

                        System.out.println("No such person found.");

                    }

                    else{
*/
                        String option = "";

                        while(resultSet.next()) {

                            System.out.println("Welcome!");

                            System.out.print(resultSet.getString("FirstName") + " " + resultSet.getString("LastName"));

                            String stop = "";

//                            do {

                                System.out.println("1 to edit phone number , 2 to edit address");

                                option = sc.nextLine();

                                if (option.equals("1")) {

                                    System.out.println("Enter your new phone Number");

                                    String phoneNumber = sc.nextLine();

                                    preparedStatement = connect.prepareStatement(
                                            "update addressbook.book1 set PhoneNumber = ? where FirstName = ? and LastName = ?;"
                                    );


                                    preparedStatement.setString(1, phoneNumber);
                                    preparedStatement.setString(2, firstName);
                                    preparedStatement.setString(3, lastName);

                                    preparedStatement.addBatch();
                                    preparedStatement.executeBatch();

                                }

                                if(option.equals("2")){

                                    System.out.println("Enter new Address");

                                    System.out.println("Enter Flat Number , Building , Landmark , City , State , Pincode");

                                    String flatNumber = sc.nextLine();

                                    String buildingName = sc.nextLine();

                                    String landmark = sc.nextLine();

                                    String city = sc.nextLine();

                                    String state = sc.nextLine();

                                    String pinCode = sc.nextLine();

                                    preparedStatement = connect.prepareStatement(
                                      "update addressbook.book1 set FlatNumber = ? , BuildingName = ? , Landmark = ? , City = ? , State = ? , Pindcode = ? where FirstName = ? and LastName = ?;"
                                    );

                                    preparedStatement.setString(1,flatNumber);
                                    preparedStatement.setString(2,buildingName);
                                    preparedStatement.setString(3,landmark);
                                    preparedStatement.setString(4,city);
                                    preparedStatement.setString(5,state);
                                    preparedStatement.setString(6,pinCode);
                                    preparedStatement.setString(7,firstName);
                                    preparedStatement.setString(8,lastName);

                                    preparedStatement.addBatch();
                                    preparedStatement.executeBatch();

                                    System.out.println("Changes made to DataBase!");


                                }

                                else{

                                    System.out.println("Passing on!");

                                }

//                            }while(!stop.equals("yes"));

//                        }
                    }

                }

            }while(!choice.equals("0"));


    }

    public static void showResultSet(ResultSet resultSet)throws SQLException{

        while(resultSet.next()){

//            System.out.println("Begin to display! ");

            System.out.println(" Hey " + resultSet.getString("FirstName"));

            System.out.println(" Registered Full Name " + resultSet.getString("FirstName") + " " + resultSet.getString("LastName"));

            System.out.println("Phone Number :" + resultSet.getString("PhoneNumber"));

            System.out.println("Address Details are : ");

            System.out.println(resultSet.getString("FlatNumber") + " ,\n" + resultSet.getString("BuildingName" ) + " ," );

            System.out.println(resultSet.getString("Landmark") + " , \n" + resultSet.getString("City") + " , \n" + resultSet.getString("State") + " , \n");

            System.out.println(resultSet.getString("Pindcode"));

        }

    }


}