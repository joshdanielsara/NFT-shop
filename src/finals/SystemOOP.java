package finals;

//FOR POLISHING & DEBUGGING STAGE

import java.util.Objects;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
public class SystemOOP {
 static ArrayList<String> cart = new ArrayList<>();
 static ArrayList<String> purchased = new ArrayList<>();
 static char ShopSelector, TokenSelector, ProductInfo_Astro, Navigator, ProductInfo_Nature, ProductInfo_Animals;
 static Scanner ShopScan = new Scanner(System.in);
 static Scanner NatureScan = new Scanner(System.in);
 static String register_username, register_password;
 static int ageVerify = 18, total=0, Customer_money=0, userAge;
 static int moon_Price = 18000, milky_Way = 20000, shooting_star = 30000;
 static int mountain_price = 25000, rain_price = 50000, tree_price = 5000;
 static int horse_price = 60000, cat_price = 70000, lion_price = 90000;
 static Scanner TokensScan = new Scanner(System.in);

 static void SystemShop() {

     System.out.println("\t**************************************");
     System.out.println("\tWelcome to the Non-Fungible Token Shop");
     System.out.println("\t**************************************");
     try {
         System.out.println("\t\tPlease Verify Your Age First: ");
         userAge = ShopScan.nextInt();
         if (userAge >= ageVerify) {
             Register.RegisterMember();
         } else {
             System.out.println("\tYou're a minor you are not allowed here.");
             SystemShop();
         }
     } catch (InputMismatchException e) {
             ShopScan.next();
             SystemShop();
     }
 }
}

 class Register extends SystemOOP {
     static void RegisterMember() {
         Scanner LoginScan = new Scanner(System.in);
         System.out.println("\t**************************************");
         System.out.println("\tRegister Account");
         System.out.println("\tPlease register desired username: ");
         register_username = LoginScan.nextLine();
        
         System.out.println("\tPlease register desired password: ");
         register_password = LoginScan.nextLine();
         System.out.println("\t**************************************");
         Login();
         
     }

     static void Login() {
         Scanner LogScan = new Scanner(System.in);
         System.out.println("\tLogin");
         System.out.println("\tPlease Enter Username: ");
         String username = LogScan.nextLine();
         System.out.println("\tPlease Enter Password: ");
         String password = LogScan.nextLine();
         System.out.println("\t**************************************");
         if (Objects.equals(username, register_username) && Objects.equals(password, register_password)) {
             ShopMainMenu.Menu();
         } else {
             System.out.println("\tUsername & Password not clear please try logging in again.");
             Login();
         }
     }
 }

 class ShopMainMenu extends SystemOOP {
     static void Menu() {
         Scanner MenuScan = new Scanner(System.in);
             System.out.println("\tNon-Fungible Token Shop");
             System.out.println("\t[A]Tokens List for Sale");
             System.out.println("\t[B]My Tokens");
             System.out.println("\t[C]Cart");
             System.out.println("\t[D]My Account Info");
             System.out.println("\t[E]Logout");
             System.out.println("\t**************************************");
                 ShopSelector = MenuScan.next().charAt(0);
                 switch (ShopSelector){
                     case 'A':
                     Tokens.TokensInfo();
                     break;

                     case 'B':
                     myTokensBought.myTokens();
                     break;

                     case 'C':
                     Cart.CartList();
                     break;

                     case 'D':
                     Account.myInfo();
                     break;

                     case 'E':
                     SystemOOP.SystemShop();
                     break;

                     default:
                     System.out.println("Input not clear, Please try again.");
                     Menu();
                     break;
                 }
     }
 }

 class Tokens extends SystemOOP {
     static void TokensInfo() {
         System.out.println("\tCategories:");
         System.out.println("\t[A]Astrophotography");
         System.out.println("\t[B]Nature");
         System.out.println("\t[C]Animals");
         System.out.println("\t[E]Back");
         System.out.println("\t**************************************");
         TokenSelector = TokensScan.nextLine().charAt(0);
         switch (TokenSelector) {
             case 'A':
                 Astro.AstroMenu();
                 break;

             case 'B':
                 Nature.NatureMenu();
                 break;

             case 'C':
                 Animals.AnimalsMenu();
                 break;

             case 'E':
                 ShopMainMenu.Menu();
                 break;

                 default:
                 System.out.println("Input not clear, Please try again.");
                 TokensScan.nextLine();
                 TokensInfo();
                 break;
         }
     }
 }

 class myTokensBought extends SystemOOP {
     static void myTokens() {
         System.out.println("\tMy Tokens Owned");
         System.out.println(purchased);
         ShopMainMenu.Menu();
         System.out.println("\t**************************************");

     }
 }
 class Astro extends Tokens {
     static void AstroMenu() {
         System.out.println("\tAstrophotography:");
         System.out.println("\t[A]Moon");
         System.out.println("\t[B]Milky Way");
         System.out.println("\t[C]Shooting Star");
         System.out.println("\t[D]Back");
         System.out.println("\t**************************************");
         AstroInfo();
     }
     static void AstroInfo () {
         System.out.println("\tPlease enter character.");
         ProductInfo_Astro = TokensScan.nextLine().charAt(0);
         switch (ProductInfo_Astro) {
             case 'A':
                 System.out.println("\tMoon: " + moon_Price);
                 System.out.println("\tA moon shot");
                 System.out.println("\t[X] Buy || [Y] Add to Cart || [M] Back");
                 Navigator = TokensScan.nextLine().charAt(0);
                 switch (Navigator) {
                     case 'X':
                         try {
                             System.out.println("\tEnter customer money: ");
                             Customer_money = TokensScan.nextInt();
                             if(Customer_money > moon_Price) {
                                 total = (Customer_money - moon_Price);
                                 System.out.println("\tChange: " + total);
                                 System.out.println("\tItem purchased!");
                                 purchased.add("You owned Moon with value of: " + moon_Price);
                                 TokensScan.nextLine();
                                 ShopMainMenu.Menu();
                                 }
                             if(Customer_money < moon_Price){
                                 System.out.println("Error, Please enter right amount.");
                                 TokensScan.nextLine();
                                 AstroMenu();
                             }
                             else{
                                 AstroMenu();
                                 }
                             } catch (InputMismatchException e) {
                                 TokensScan.nextLine();
                                 System.out.println("\tEntered value is not an number.");
                                 AstroInfo();
                             }
                             break;
                     case 'M':
                         System.out.println("\tGoing back to menu.");
                         Tokens.TokensInfo();
                         break;

                     case 'Y':
                         cart.add("Moon: "+moon_Price);
                         System.out.println("\tAdded to Cart!");
                         Tokens.TokensInfo();

                         default:
                             System.out.println("\tInput not clear, Please try again.");
                             AstroMenu();
                             break;
                     }

                 case 'B':
                     System.out.println("\tMilky Way: " + milky_Way);
                     System.out.println("\tMilky Way photo shot during Milky Way Season");
                     System.out.println("\t[X] Buy || [Y] Add to Cart || [B] Back");
                     Navigator = TokensScan.nextLine().charAt(0);
                     switch (Navigator) {
                         case 'X':
                             try {
                                 System.out.println("\tEnter customer money: ");
                                 Customer_money = TokensScan.nextInt();
                                 if(Customer_money > milky_Way) {
                                     total = (Customer_money - milky_Way);
                                     System.out.println("\tChange: " + total);
                                     System.out.println("\tItem purchased!");
                                     purchased.add("You owned Milky Way with value of: " + milky_Way);
                                     TokensScan.nextLine();
                                     ShopMainMenu.Menu();
                                 }
                                 if(Customer_money < milky_Way){
                                     System.out.println("Error, Please enter right amount.");
                                     TokensScan.nextLine();
                                     AstroMenu();
                                 }
                                 else{
                                     AstroMenu();
                                 }
                             } catch (InputMismatchException e) {
                                 TokensScan.nextLine();
                                 System.out.println("\tEntered value is not an number.");
                                 AstroInfo();
                             }
                             break;
                         case 'M':
                             System.out.println("\tGoing back to menu.");
                             Tokens.TokensInfo();
                             break;

                         case 'Y':
                             cart.add("\tMilky Way: "+milky_Way);
                             System.out.println("\tAdded to Cart!");
                             Tokens.TokensInfo();

                         default:
                             System.out.println("\tInput not clear, Please try again.");
                             AstroMenu();
                     }
                     break;

                 case 'C':
                     System.out.println("\tShooting Star: " + shooting_star);
                     System.out.println("\tA stunning view of the shooting star from a comet.");
                     System.out.println("\t[X] Buy || [Y] Add to Cart || [B] Back");
                     Navigator = TokensScan.nextLine().charAt(0);
                     switch (Navigator) {
                         case 'X':
                             try {
                                 System.out.println("\tEnter customer money: ");
                                 Customer_money = TokensScan.nextInt();
                                 if(Customer_money > shooting_star) {
                                     total = (Customer_money - shooting_star);
                                     System.out.println("\tChange: " + total);
                                     System.out.println("\tItem purchased!");
                                     purchased.add("You owned Shooting Star with value of: " + shooting_star);
                                     TokensScan.nextLine();
                                     ShopMainMenu.Menu();
                                 }
                                 if(Customer_money < shooting_star){
                                     System.out.println("Error, Please enter right amount.");
                                     TokensScan.nextLine();
                                     AstroMenu();
                                 }
                                 else{
                                     AstroMenu();
                                 }
                             } catch (InputMismatchException e) {
                                 TokensScan.nextLine();
                                 System.out.println("\tEntered value is not an number.");
                                 AstroInfo();
                             }
                             break;
                         case 'M':
                             System.out.println("\tGoing back to menu.");
                             Tokens.TokensInfo();
                             break;

                         case 'Y':
                             cart.add("\tShooting Star: "+shooting_star);
                             System.out.println("\tAdded to Cart!");
                             Tokens.TokensInfo();

                         default:
                             System.out.println("\tInput not clear, Please try again.");
                             AstroMenu();

                     }
                     break;

                 case 'D':
                     TokensInfo();
                     break;

                 default:
                     System.out.println("\tInput not clear, Please try again.");
                     AstroMenu();
             }
         }
 }

 class Nature extends Tokens{
 static void NatureMenu() {
     System.out.println("\tNature:");
     System.out.println("\t[A]Mountain");
     System.out.println("\t[B]Tree");
     System.out.println("\t[C]Rain");
     System.out.println("\t[D]Back");
     System.out.println("\t**************************************");
     NatureInfo();
     }
     static void NatureInfo(){
         System.out.println("\tPlease enter character.");
         ProductInfo_Nature = TokensScan.nextLine().charAt(0);
         switch (ProductInfo_Nature) {
             case 'A':
                 System.out.println("\tMountain: " + mountain_price);
                 System.out.println("\tA mountain shot");
                 System.out.println("\t[X] Buy || [Y] Add to Cart || [M] Back");
                 Navigator = TokensScan.nextLine().charAt(0);
                 switch (Navigator) {
                     case 'X':
                         try {
                             System.out.println("\tEnter customer money: ");
                             Customer_money = TokensScan.nextInt();
                             if(Customer_money > mountain_price) {
                                 total = (Customer_money - mountain_price);
                                 System.out.println("\tChange: " + total);
                                 System.out.println("\tItem purchased!");
                                 purchased.add("You owned Mountain with value of: " + mountain_price);
                                 TokensScan.nextLine();
                                 ShopMainMenu.Menu();
                             }
                             if(Customer_money < mountain_price){
                                 System.out.println("Error, Please enter right amount.");
                                 TokensScan.nextLine();
                                 NatureMenu();
                             }
                             else{
                                 NatureInfo();
                             }
                         } catch (InputMismatchException e) {
                             TokensScan.nextLine();
                             System.out.println("\tEntered value is not an number.");
                             NatureMenu();
                         }
                         break;
                     case 'M':
                         System.out.println("\tGoing back to menu.");
                         Tokens.TokensInfo();
                         break;

                     case 'Y':
                         cart.add("Mountain: "+mountain_price);
                         System.out.println("\tAdded to Cart!");
                         Tokens.TokensInfo();

                     default:
                         System.out.println("\tInput not clear, Please try again.");
                         NatureMenu();
                         break;
                 }

             case 'B':
                 System.out.println("\tTree: " + tree_price);
                 System.out.println("\tA stunning Tree photo");
                 System.out.println("\t[X] Buy || [Y] Add to Cart || [B] Back");
                 Navigator = TokensScan.nextLine().charAt(0);
                 switch (Navigator) {
                     case 'X':
                         try {
                             System.out.println("\tEnter customer money: ");
                             Customer_money = TokensScan.nextInt();
                             if(Customer_money > tree_price) {
                                 total = (Customer_money - tree_price);
                                 System.out.println("\tChange: " + total);
                                 System.out.println("\tItem purchased!");
                                 purchased.add("You owned Tree Photo with value of: " + tree_price);
                                 TokensScan.nextLine();
                                 ShopMainMenu.Menu();
                             }
                             if(Customer_money < tree_price){
                                 System.out.println("Error, Please enter right amount.");
                                 TokensScan.nextLine();
                                 NatureMenu();
                             }
                             else{
                                 NatureMenu();
                             }
                         } catch (InputMismatchException e) {
                             TokensScan.nextLine();
                             System.out.println("\tEntered value is not an number.");
                             NatureInfo();
                         }
                         break;
                     case 'M':
                         System.out.println("\tGoing back to menu.");
                         Tokens.TokensInfo();
                         break;

                     case 'Y':
                         cart.add("\tTree: "+tree_price);
                         System.out.println("\tAdded to Cart!");
                         Tokens.TokensInfo();

                     default:
                         System.out.println("\tInput not clear, Please try again.");
                         NatureMenu();
                 }
                 break;

             case 'C':
                 System.out.println("\tRain: " + rain_price);
                 System.out.println("\tA stunning view of the rain photo.");
                 System.out.println("\t[X] Buy || [Y] Add to Cart || [B] Back");
                 Navigator = TokensScan.nextLine().charAt(0);
                 switch (Navigator) {
                     case 'X':
                         try {
                             System.out.println("\tEnter customer money: ");
                             Customer_money = TokensScan.nextInt();
                             if(Customer_money > tree_price) {
                                 total = (Customer_money - tree_price);
                                 System.out.println("\tChange: " + total);
                                 System.out.println("\tItem purchased!");
                                 purchased.add("You owned Tree with value of: " + tree_price);
                                 TokensScan.nextLine();
                                 ShopMainMenu.Menu();
                             }
                             if(Customer_money < tree_price){
                                 System.out.println("Error, Please enter right amount.");
                                 TokensScan.nextLine();
                                 NatureMenu();
                             }
                             else{
                                 NatureMenu();
                             }
                         } catch (InputMismatchException e) {
                             TokensScan.nextLine();
                             System.out.println("\tEntered value is not an number.");
                             NatureInfo();
                         }
                         break;
                     case 'M':
                         System.out.println("\tGoing back to menu.");
                         Tokens.TokensInfo();
                         break;

                     case 'Y':
                         cart.add("\tRain: "+rain_price);
                         System.out.println("\tAdded to Cart!");
                         Tokens.TokensInfo();

                     default:
                         System.out.println("\tInput not clear, Please try again.");
                         NatureMenu();

                 }
                 break;

             case 'D':
                 TokensInfo();
                 break;

             default:
                 System.out.println("\tInput not clear, Please try again.");
                 NatureMenu();
         }
     }
 }

 class Animals extends Tokens{
 static void AnimalsMenu(){
     System.out.println("\tAnimals:");
     System.out.println("\t[A]Horse");
     System.out.println("\t[B]Cat");
     System.out.println("\t[C]Lion");
     System.out.println("\t[D]Back");
     System.out.println("\t**************************************");
     AnimalsInfo();
     }
     static void AnimalsInfo(){
         System.out.println("\tPlease enter character.");
         ProductInfo_Nature = TokensScan.nextLine().charAt(0);
         switch (ProductInfo_Nature) {
             case 'A':
                 System.out.println("\tHorse: " + horse_price);
                 System.out.println("\tA horse shot");
                 System.out.println("\t[X] Buy || [Y] Add to Cart || [M] Back");
                 Navigator = TokensScan.nextLine().charAt(0);
                 switch (Navigator) {
                     case 'X':
                         try {
                             System.out.println("\tEnter customer money: ");
                             Customer_money = TokensScan.nextInt();
                             if(Customer_money > horse_price) {
                                 total = (Customer_money - horse_price);
                                 System.out.println("\tChange: " + total);
                                 System.out.println("\tItem purchased!");
                                 purchased.add("You owned Horse with value of: " + horse_price);
                                 TokensScan.nextLine();
                                 ShopMainMenu.Menu();
                             }
                             if(Customer_money < horse_price){
                                 System.out.println("Error, Please enter right amount.");
                                 TokensScan.nextLine();
                                 AnimalsMenu();
                             }
                             else{
                                 AnimalsInfo();
                             }
                         } catch (InputMismatchException e) {
                             TokensScan.nextLine();
                             System.out.println("\tEntered value is not an number.");
                             AnimalsMenu();
                         }
                         break;
                     case 'M':
                         System.out.println("\tGoing back to menu.");
                         Tokens.TokensInfo();
                         break;

                     case 'Y':
                         cart.add("Horse: "+horse_price);
                         System.out.println("\tAdded to Cart!");
                         Tokens.TokensInfo();

                     default:
                         System.out.println("\tInput not clear, Please try again.");
                         AnimalsMenu();
                         break;
                 }

             case 'B':
                 System.out.println("\tCat: " + cat_price);
                 System.out.println("\tA stunning Cat photo");
                 System.out.println("\t[X] Buy || [Y] Add to Cart || [B] Back");
                 Navigator = TokensScan.nextLine().charAt(0);
                 switch (Navigator) {
                     case 'X':
                         try {
                             System.out.println("\tEnter customer money: ");
                             Customer_money = TokensScan.nextInt();
                             if(Customer_money > cat_price) {
                                 total = (Customer_money - cat_price);
                                 System.out.println("\tChange: " + total);
                                 System.out.println("\tItem purchased!");
                                 purchased.add("You owned Cat Photo with value of: " + cat_price);
                                 TokensScan.nextLine();
                                 ShopMainMenu.Menu();
                             }
                             if(Customer_money < cat_price){
                                 System.out.println("Error, Please enter right amount.");
                                 TokensScan.nextLine();
                                 AnimalsMenu();
                             }
                             else{
                                 AnimalsMenu();
                             }
                         } catch (InputMismatchException e) {
                             TokensScan.nextLine();
                             System.out.println("\tEntered value is not an number.");
                             AnimalsInfo();
                         }
                         break;
                     case 'M':
                         System.out.println("\tGoing back to menu.");
                         Tokens.TokensInfo();
                         break;

                     case 'Y':
                         cart.add("\tTree: "+cat_price);
                         System.out.println("\tAdded to Cart!");
                         Tokens.TokensInfo();

                     default:
                         System.out.println("\tInput not clear, Please try again.");
                         AnimalsMenu();
                 }
                 break;

             case 'C':
                 System.out.println("\tLion: " + lion_price);
                 System.out.println("\tA stunning view of the Lion.");
                 System.out.println("\t[X] Buy || [Y] Add to Cart || [B] Back");
                 Navigator = TokensScan.nextLine().charAt(0);
                 switch (Navigator) {
                     case 'X':
                         try {
                             System.out.println("\tEnter customer money: ");
                             Customer_money = TokensScan.nextInt();
                             if(Customer_money > lion_price) {
                                 total = (Customer_money - lion_price);
                                 System.out.println("\tChange: " + total);
                                 System.out.println("\tItem purchased!");
                                 purchased.add("You owned Lion with value of: " + lion_price);
                                 TokensScan.nextLine();
                                 ShopMainMenu.Menu();
                             }
                             if(Customer_money < lion_price){
                                 System.out.println("Error, Please enter right amount.");
                                 TokensScan.nextLine();
                                 AnimalsMenu();
                             }
                             else{
                                 AnimalsMenu();
                             }
                         } catch (InputMismatchException e) {
                             TokensScan.nextLine();
                             System.out.println("\tEntered value is not an number.");
                             AnimalsInfo();
                         }
                         break;
                     case 'M':
                         System.out.println("\tGoing back to menu.");
                         Tokens.TokensInfo();
                         break;

                     case 'Y':
                         cart.add("\tLion: "+lion_price);
                         System.out.println("\tAdded to Cart!");
                         Tokens.TokensInfo();

                     default:
                         System.out.println("\tInput not clear, Please try again.");
                         AnimalsMenu();

                 }
                 break;

             case 'D':
                 TokensInfo();
                 break;

             default:
                 System.out.println("\tInput not clear, Please try again.");
                 AnimalsMenu();
         }
 }
}

     class Cart extends SystemOOP {
         static void CartList() {
             System.out.println("\tMy Cart");
             System.out.println("\t"+cart);
             ShopMainMenu.Menu();
             System.out.println("\t**************************************");
         }
     }

     class Account extends SystemOOP {
         static void myInfo() {
             System.out.println("\tMy Account Details");
             System.out.println("\tUsername: " + register_username);
             System.out.println("\tPassword: " + register_password);
             System.out.println("\t**************************************");
         }
     }

     class Main {
         public static void main(String[] args) {
             SystemOOP So = new SystemOOP(); //Driver Code
             SystemOOP.SystemShop();
         }
     }
