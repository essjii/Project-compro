package catalog.view;

import catalog.controller.CatalogController;
import catalog.model.Catalog;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class TestCatalog {

    public static void main(String[] args) {
        try {
            Scanner usr = new Scanner(System.in);

            System.out.print("Enter User Name : ");
            String usrName = usr.next();

            System.out.print("Enter Password : ");
            String password = usr.next();

            CatalogController catalogCtrl = new CatalogController(usrName, password);

            System.out.println("------Menu------");
            System.out.print("(1)Create Table\n" + "(2)Add product\n" + "(3)Find a product\n" + "(4)Adjust table\n" + "(5)Delete all product\n" + "----------------\n");
//            System.out.print("Choose the menu (0-5) : ");
//            int menu = usr.nextInt();
            int menu;            
            String otherMenu;
            
            do {
                System.out.print("Choose the menu (1-5) : ");
                menu = usr.nextInt();
                switch (menu) {
                    case 1:
                        catalogCtrl.createCatalogTable();
                        System.out.print("Enter file name : ");
                        String filename = usr.next();
                        catalogCtrl.insertFromFile(filename);
                        break;
                        
                    case 2:
//                    System.out.print("Do you want to add more product? (y/n): ");
//                    String addMore = usr.next();
                        String addMore;

                        do {

                            System.out.print("Enter product's ID : ");
                            String addProductId = usr.next();

                            System.out.print("Enter product's name : ");
                            String addProductName = usr.next();

                            System.out.print("Enter product's cost : ");
                            String addProductCost = usr.next();

                            Catalog product = new Catalog(addProductId, addProductName, addProductCost);
                            catalogCtrl.insertCatalog(product);

                            System.out.print("Do you want to add more product? (y/n): ");
                            addMore = usr.next();

                        } while (addMore.equalsIgnoreCase("y"));
//                    
                        break;
                        
//                case 3 :
//                    
//                    break;
                        
//                case 4 :
//                    
//                    break;
                        
                    case 5:
                        catalogCtrl.dropCatalogTable();
                        break;
                        
//                    case 0:
//                        catalogCtrl.closeCatalogConnection();
//                        break;
                }
                System.out.print("Do you want to do anything else? (y/n): ");
                otherMenu = usr.next();
//                System.out.print("Choose the menu (0-5) : ");
//                menu = usr.nextInt();
                
            } while (otherMenu.equalsIgnoreCase("y"));
            
            catalogCtrl.closeCatalogConnection();

        } catch (SQLException sql) {
            System.out.println(sql);
        } catch (ClassNotFoundException cnf) {
            System.out.println(cnf);
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf);
        }
    }

}
