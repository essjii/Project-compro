package catalog.view;

import catalog.controller.CatalogController;
import catalog.model.Catalog;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestCatalog {

    public static void main(String[] args) {
        try {
            String productId;
            String productName;
            String productCost;
            int select;
            int menu;
            String otherMenu;

            Scanner usr = new Scanner(System.in);

            System.out.print("Enter User Name : ");
            String usrName = usr.next();

            System.out.print("Enter Password : ");
            String password = usr.next();

            CatalogController catalogCtrl = new CatalogController(usrName, password);

            do {
                System.out.println("------Menu------");
                System.out.print("(1)Create Table\n" + "(2)Add products\n" + "(3)Edit product\n" + "(4)Find products\n"
                        + "(5)Show all products\n" + "(6)Delete product\n" + "(7)Drop table\n" +"----------------\n");
                System.out.print("Choose the menu (1-5) : ");
                menu = usr.nextInt();
                switch (menu) {
                    case 1:
                        catalogCtrl.createCatalogTable();
                        break;
                    case 2:
                        String addMore;
                        do {
                            System.out.print("Do you want to add products from file or not? (y/n): ");
                            String addProduct = usr.next();
                            if (addProduct.equalsIgnoreCase("y")) {
                                System.out.print("Enter file name : ");
                                String filename = usr.next();
                                catalogCtrl.insertFromFile(filename);
                            }
                            if (addProduct.equalsIgnoreCase("n")) {
                                do {
                                    System.out.print("Enter product's ID : ");
                                    productId = usr.next();
                                    System.out.print("Enter product's name : ");
                                    productName = usr.next();
                                    System.out.print("Enter product's cost : ");
                                    productCost = usr.next();
                                    Catalog product = new Catalog(productId, productName, productCost);
                                    catalogCtrl.insertCatalog(product);
                                    System.out.print("Do you want to add more product? (y/n): ");
                                    addMore = usr.next();
                                } while (addMore.equalsIgnoreCase("y"));
                            }
                            if (!addProduct.equalsIgnoreCase("y") && !addProduct.equalsIgnoreCase("n")) {
                                System.out.println("Error!!! you can put only 'y' or 'n'");
                            }
                            System.out.print("Do you want to add more product? (y/n): ");
                            addMore = usr.next();
                        } while (addMore.equalsIgnoreCase("y"));
                        break;
                    case 3:
                        String choose;
                        do {
                            System.out.print("What do you want to edit? (1)Product's cost | (2)Product's name : ");
                            select = usr.nextInt();
                            if (select == 1) {
                                System.out.print("Enter product's ID : ");
                                productId = usr.next();
                                System.out.print("Enter new product's cost : ");
                                productCost = usr.next();
                                catalogCtrl.editProductCost(productId, productCost);
                            }
                            if (select == 2) {
                                System.out.print("Enter product's ID : ");
                                productId = usr.next();
                                System.out.print("Enter new product's name : ");
                                productName = usr.next();
                                catalogCtrl.editProductCost(productId, productName);
                            }
                            System.out.print("Do you want to edit more products? (y/n): ");
                            choose = usr.next();
                        } while (choose.equalsIgnoreCase("y"));
                        break;
                    case 4:
                        ArrayList<Catalog> productList = catalogCtrl.selectProduct();
                        String findMore;
                        do {
                            System.out.print("Enter (1) to find product by ID | Enter (2) to find product by name | Enter (3) to find by cost : ");
                            select = usr.nextInt();
                            if (select == 1) {
                                System.out.print("Enter product's ID : ");
                                String pId = usr.next();
                                for (int i = 0; i < productList.size(); i++) {
                                    if (productList.get(i).getProductId().equalsIgnoreCase(pId)) {
                                        System.out.println(productList.get(i));
                                    }
                                }
                            }
                            if (select == 2) {
                                System.out.print("Enter product's name : ");
                                String pName = usr.next();
                                for (int i = 0; i < productList.size(); i++) {
                                    if (productList.get(i).getProductName().equalsIgnoreCase(pName)) {
                                        System.out.println(productList.get(i));
                                    }
                                }
                            }
                            if (select == 3) {
                                System.out.print("Enter product's cost : ");
                                String pCost = usr.next();
                                for (int i = 0; i < productList.size(); i++) {
                                    if (productList.get(i).getProductCost().equalsIgnoreCase(pCost)) {
                                        System.out.println(productList.get(i));
                                    }
                                }
                            }
                            System.out.print("Do you want to find anything else? (y/n) : ");
                            findMore = usr.next();
                        } while (findMore.equalsIgnoreCase("y"));
                        break;
                    case 5:
                        productList = catalogCtrl.selectProduct();
                        for (int i = 0; i < productList.size(); i++) {
                            System.out.println(productList.get(i));
                        }
                        break;
                    case 6:
                        System.out.print("Enter (1) to delete some products | Enter (2) to delete all product : ");
                        select = usr.nextInt();
                        if (select == 1) {
                            do {
                                System.out.print("Enter product's ID : ");
                                productId = usr.next();
                                catalogCtrl.deleteProduct(productId);
                                System.out.print("Do you want to delete more products? (y/n) : ");
                                choose = usr.next();
                            } while (choose.equalsIgnoreCase("y"));
                        }
                        if (select == 2) {
                            catalogCtrl.deleteProduct();
                        }
                        break;                        
                    case 7:
                        catalogCtrl.dropCatalogTable();
                        break;
                }
                System.out.print("Do you want to do anything else? (y/n): ");
                otherMenu = usr.next();
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