package com.company;
import java.util.Scanner; //import της class Scanner του πακέτου java.util για ανάγνωση input χρήστη
import java.util.ArrayList; //import της class ArrayList του πακέτου java.util για κατασκευή λίστας με τις επαφές

public class Main
{

    private static void showMenu() //static method της class Main για εμφάνιση αρχικού μενού, ορατή μόνο από class Main
    {
        System.out.println("1. Προβολή όλων των διαθέσιμων επαφών"); //επιλογές αρχικού μενού
        System.out.println("2. Προσθήκη νέας επαφής");
        System.out.println("3. Αναζήτηση επαφής βάσει ονόματος");
        System.out.println("4. Αναζήτηση επαφής βάσει τηλεφώνου");
        System.out.println("5. Επεξεργασία επαφής βάσει ονόματος");
        System.out.println("6. Διαγραφή επαφής βάσει ονόματος");
        System.out.println("7. Έξοδος από την εφαρμογή\n");
    }

    private static void showModifyMenu() //static method της class Main για εμφάνιση μενού επεξεργασίας, ορατή μόνο από class Main
    {
        System.out.println("1. Επεξεργασία ονόματος"); //επιλογές μενού
        System.out.println("2. Επεξεργασία τηλεφώνου");
        System.out.println("3. Επεξεργασία email");
        System.out.println("4. Επεξεργασία διεύθυνσης");
        System.out.println("5. Επεξεργασία τίτλου επαγγέλματος");
    }



    public static void main(String[] args)
    {
        ArrayList <Contact> contacts = new ArrayList <Contact>(); //κλήση constructor της class ArrayList
        //επαφές hardwired στον κώδικα, είσοδος με αλφαβητική σειρά
        Contact firstCon = new Contact("Γιώργος Γαβριηλίδης","2102519950","gav1990@outlook.com","Λάμπρου Πορφύρα 28", "Java Developer"); //δημιουργία νέου object της class Contact
        contacts.add(firstCon); //πρόσθεση νέας επαφής σε λίστα επαφών
        Contact secondCon = new Contact("Πέτρος Παπαπέτρου","2102525934","papa@yahoo.com","Λεωφόρος Αλεξάνδρας 103", "Personal Trainer"); //δημιουργία νέου object της class Contact
        contacts.add(secondCon); //πρόσθεση νέας επαφής σε λίστα επαφών
        Contact thirdCon = new Contact("Σταύρος Ιωαννίδης","2102617890","stav@gmail.com","Στρατάρχου Νικολάου 5", "Διευθυντής Πωλήσεων"); //δημιουργία νέου object της class Contact
        contacts.add(thirdCon); //πρόσθεση νέας επαφής σε λίστα επαφών
        Contact fourthCon = new Contact("Χαρά Παπαδοπούλου","2102518164","harap@outlook.com","Λάμπρου Πορφύρα 26", "Ψυχολόγος"); //δημιουργία νέου object της class Contact
        contacts.add(fourthCon); //πρόσθεση νέας επαφής σε λίστα επαφών



        System.out.println("Εφαρμογή AddressBook"); //καλωσόρισμα στην εφαρμογή.Εμφάνιση μόνο την 1η φορά απεικόνισης μενού
        System.out.println("Επιλέξτε από το παρακάτω μενού επιλογών πληκτρολογώντας το αντίστοιχο νούμερο"); //επιλογές αρχικού μενού
        System.out.println("---------------------------------------------------------------------------------------");

        boolean isInt = true; /*μεταβλητή isInt τίθεται true, θα την χρησιμοποιήσουμε για να ελέγξουμε αν το input
        χρήστη είναι ακέραιος αριθμός*/
        Scanner scanner = new Scanner(System.in);
        int input = -1; /*μεταβλητή τύπου int με τυχαία τιμή, θα αλλάξει μετά(απλώς γιατί πρέπει να έχει
        τιμή πριν το try-catch, αλλιώς "χτυπάει" μετά, στα ifs)*/
        while(true) //loop, θα "τρέχει" μέχρι να πατηθεί το πλήκτρο 7 από τον χρήστη
        {
            do
            {
                try
                {
                    showMenu(); //κλήση της static method showMenu για εμφάνιση αρχικού μενού
                    isInt = true; //μεταβλητή isInt τίθεται (ξανά) true, για κάθε νέο iteration
                    input = scanner.nextInt();
                }
                catch (Exception InputMismatchException) //αν το input δεν είναι ακέραιος αριθμός
                {
                    isInt = false;
                    System.out.println("Πρέπει να πληκτρολογήσετε έναν αριθμό (από 1 έως 7)!\n");
                    scanner.nextLine(); //για κατανάλωση του \n που έχει μείνει από το scanner.nextInt()
                }
                if  ((isInt == true) && (input < 1 || input > 7)) /*isInt == true, ώστε να εμφανιστεί μόνο αν δεν έχει
                 γίνει InputMismatchException αλλά ο αριθμός είναι εκτός ορίων επιλογής*/
                {
                    System.out.println("Ο αριθμός πρέπει να είναι από 1 έως 7!\n");
                    isInt = false;
                }
            }   while(isInt == false ); //loop θα τρέχει μέχρι το input να είναι ακέραιος από 1 έως 7

            scanner.nextLine(); //για κατανάλωση του \n που έχει μείνει από το scanner.nextInt()

            //Ενέργειες ανά επιλογή χρήστη
            if (input == 1) //προβολή διαθέσιμων επαφών
            {
                try
                {
                    System.out.println("Οι επαφές του address book:\n");
                    char fChar; //θα κρατά τον 1ο χαρακτήρα κάθε επαφής, για αλφαβητική ταξινόμηση
                    char prevFChar = Character.toUpperCase(contacts.get(0).getName().charAt(0)); /*θα κρατά τον 1ο χαρακτήρα της προηγούμενης επαφής,
                 για τοποθέτηση (ή όχι) αρχικού γράμματος ή συμβόλου πάνω από κάθε νέο γράμμα/ σύμβολο*/
                    boolean numAlready = false; //εάν η προηγούμενη επαφή ήταν αριθμός, θέλουμε 1 επικεφαλίδα για όλους
                    if(prevFChar >= 48 && prevFChar <= 57) //αν ο πρώτος χαρακτήρας είναι αριθμός
                    {
                        System.out.println("#");
                        System.out.println("--------");
                        numAlready = true;
                    }
                    else if((prevFChar >= 65 && prevFChar <= 90) || prevFChar == 902 || (prevFChar >= 904 && prevFChar <= 974))
                    {
                        System.out.println(Character.toUpperCase(prevFChar));
                        System.out.println("--------");
                    }


                    for (Contact ct : contacts)
                    {
                        fChar = Character.toUpperCase(ct.getName().charAt(0)); //1ος χαρακτήρας ονόματος κάθε επαφής
                        if(fChar >= 48 && fChar <= 57) //αν είναι αριθμός
                        {
                            if(numAlready == false)
                            {
                                System.out.println("#");
                                System.out.println("--------");
                                numAlready = true;
                            }

                        }
                        else if((fChar >= 65 && fChar <= 90) || fChar == 902 || (fChar >= 904 && fChar <= 974))
                            //ελληνικοί ή λατινικοί χαρακτήρες
                        {
                            if(fChar > prevFChar) //αν 1ος χαρακτήρας ονόματος επαφής > 1ο χαρακτήρα ονόματος νέας επαφής
                            {
                                System.out.println((fChar));
                                System.out.println("--------");
                            }
                        }
                        ct.showContact(); //κλήση μεθόδου showContact από κάθε στοιχείο πίνακα contacts
                        System.out.println("\n");
                        prevFChar = fChar; /*προετοιμασία για την επόμενη σύγκριση, prevChar γίνεται 1ος χαρακτήρας
                        παρούσας επαφής*/
                    }
                }
                catch (Exception IndexOutOfBoundsException) /*εάν ζητηθεί χαρακτήρας 1ου στοιχείου ArrayList(γραμμή 86)
                                ενώ η ArrayList έχει αδειάσει λόγω συνεχόμενων διαγραφών*/
                {
                    System.out.println("Δεν υπάρχει καμία αποθηκευμένη επαφή. Ο κατάλογος επαφών είναι κενός\n\n");
                }
            }


            else if (input == 2) //προσθήκη νέας επαφής
            {
                String newName;
                boolean spaceorEmpty;
                int spaceCount; //μεταβλητή με την οποία θα μετρήσουμε πόσα spaces υπάρχουν σε input χρήστη (αν υπάρχουν)
                do
                {
                    spaceCount = 0; //αρχική τιμή 0, και κάθε φορά που θα ξανατρέχει το loop
                    spaceorEmpty = false; //μεταβλητή για έλεγχο εγκυρότητας input χρήστη για τυχόν κενό όνομα
                    System.out.print("Πληκτρολογήστε το ονοματεπώνυμο της νέας επαφής: ");
                    newName = scanner.nextLine(); //nextLine καθώς περιμένουμε String με κενό ανάμεσα σε όνομα και επίθετο
                    if(newName.length() == 0) //1ος έλεγχος, εξετάζουμε αν το String είναι κενό
                    {
                        System.out.println("Το πεδίο ονόματος δεν μπορεί να είναι κενό!\n");
                        spaceorEmpty = true; //boolean μεταβλητή τίθεται ως true, το loop θα επαναληφθεί
                    }
                    else //2ος έλεγχος, αν το String δεν είναι κενό, εξετάζουμε αν έχει μόνο space
                    {
                        for(int i = 0; i < newName.length(); i++)
                        {
                            if(newName.charAt(i) == 32) //εάν ο χαρακτήρας είναι το space
                            {
                                spaceCount++;
                            }
                        }
                        if(spaceCount == newName.length()) //δηλαδή αν το String περιέχει μόνο spaces
                        {
                            System.out.println("Το πεδίο ονόματος δεν μπορεί να είναι κενό!\n");
                            spaceorEmpty = true; //boolean μεταβλητή τίθεται ως true, το loop θα επαναληφθεί
                        }
                    }

                }while (spaceorEmpty == true); /*loop θα τρέχει μέχρι να έχουμε input που δεν αποτελείται μόνο
                         από space και που δεν είναι κενό*/

                String newTel;
                boolean telOnlyNum;
                do
                    {
                        telOnlyNum = true; //μεταβλητή για έλεγχο εγκυρότητας input χρήστη για το πεδίο τηλεφώνου
                        System.out.print("Πληκτρολογήστε το τηλέφωνο της νέας επαφής: ");
                        newTel= scanner.nextLine();
                        for(int i = 0; i < newTel.length(); i++)
                        {
                            if(newTel.charAt(i) < 48 || newTel.charAt(i) > 57) //εάν δεν είναι νούμερο έστω και ένας χαρακτήρας
                            {
                                System.out.println("Το τηλέφωνο θα πρέπει να περιλαμβάνει μόνο νούμερα!\n");
                                telOnlyNum = false;
                                break; //λάθος input, σπάει το loop
                            }
                        }
                    }while (telOnlyNum == false); //loop θα τρέχει μέχρι να έχουμε input μόνο με αριθμούς

                System.out.print("Πληκτρολογήστε το email της νέας επαφής: ");
                String newMail = scanner.nextLine();
                System.out.print("Πληκτρολογήστε τη διεύθυνση της νέας επαφής: ");
                String newAddr = scanner.nextLine(); //nextLine καθώς περιμένουμε String με πολλά κενά μεταξύ των όρων της διεύθυνσης
                System.out.print("Πληκτρολογήστε το επάγγελμα της νέας επαφής: ");
                String newProf = scanner.nextLine(); /*nextLine καθώς ενδέχεται ο τίτλος επαγγέλματος ενδέχεται να αποτελείται από 2
             ή και παραπάνω λέξεις*/
                Contact newCon = new Contact(newName, newTel, newMail, newAddr, newProf); /*δημιουργία νέου object της class Contact με
             τα input χρήστη ως τιμές στις ιδιότητές του*/
                System.out.println("\n"); //1 γραμμή περιθώριο
                boolean isSymbol = true; //μεταβλητές boolean για μετέπειτα ελέγχους
                boolean conAdded = false;
                Contact position = new Contact(); //object της class Contact, θα λειτουργήσει ως δείκτης
                char newConFirst = Character.toUpperCase(newCon.getName().charAt(0));/*1ος χαρακτήρας ονόματος
                νέας επαφής*/
                if((newConFirst >= 48 && newConFirst <= 57) || (newConFirst >= 65 && newConFirst <= 90) || newConFirst == 902 || (newConFirst >= 904 && newConFirst <= 974))
                {
                    isSymbol = false; //1ος χαρακτήρας επαφής δεν είναι σύμβολο
                }
                if(isSymbol == false) //εάν η νέα επαφή δεν ξεκινά από σύμβολο
                {
                    boolean breakOuter = false; //boolean μεταβλητή, όταν πληρούνται κάποιες προϋποθέσεις, θα γίνει true

                    for (Contact ct : contacts)
                    {
                        if(breakOuter == true)
                        {
                            break; //αν true, θα "σπάσει" το loop
                        }
                        char fChar = Character.toUpperCase(ct.getName().charAt(0)); /* toUppeCase ώστε αν έχουμε π.χ.
                        b να μην θεωρηθεί μεγαλύτερο από ένα C, όπως θα γίνει λόγω κωδικού τους σε πίνακα ASCII*/
                        {
                            if(!((fChar >= 48 && fChar <= 57) || (fChar >= 65 && fChar <= 90) || fChar == 902 || (fChar >= 904 && fChar <= 974)))
                            {
                                continue; //εάν ο πρώτος χαρακτήρας ονόματος επαφής με την οποία θα συγκρίνουμε τη νέα είναι σύμβολο, προχωράμε
                            }

                        }
                        if(Character.toUpperCase(ct.getName().charAt(0)) > Character.toUpperCase(newCon.getName().charAt(0)))
                        //αν 1ος χαρακτήρας επαφής καταλόγου μεγαλύτερος από 1ον χαρακτήρα νέας επαφής
                        {
                            position = ct; /*object position δείχνει σε διεύθυνση επαφής που έπεται αλφαβητικά της νέας,
                            ώστε η νέα να πάρει την δική της θέση σε λίστα και αυτή την επόμενη*/
                            conAdded = true; //η θέση στην οποία θα προστεθέι η επαφή βρέθηκε
                            break; //σπάει το loop, βρήκαμε τη θέση στην οποία θα μπει η νέα επαφή
                        }
                        else if (Character.toUpperCase(ct.getName().charAt(0)) == Character.toUpperCase(newCon.getName().charAt(0)))
                        {
                            if(ct.getName().length() <= newCon.getName().length()) //σύγκριση μήκους ονομάτων
                            {
                                boolean continueOuter = false;
                                for (int i = 1; i < ct.getName().length(); i++) /*i = 1, ο πρώτος χαρακτήρας (0) των
                                 αλφαριθμητικών ξέρουμε ότι είναι ίδιος*/
                                {
                                    if(continueOuter == true) //όταν γίνει true..
                                    {
                                        break;//..θα σπάσει το loop
                                    }
                                    if(Character.toUpperCase(ct.getName().charAt(i)) > Character.toUpperCase(newCon.getName().charAt(i)))
                                    {
                                        position = ct;
                                        conAdded = true;
                                        breakOuter = true; //για να σπάσει και το εξωτερικό loop
                                        break; //σπάει το loop, βρήκαμε τη θέση στην οποία θα μπει η νέα επαφή
                                    }
                                    else if(Character.toUpperCase(ct.getName().charAt(i)) < Character.toUpperCase(newCon.getName().charAt(i)))
                                    {
                                        continueOuter = true; /*γίνεται true για να σπάσει το loop, η νέα επαφή
                                        θα συγκριθεί με την επόμενη στον κατάλογο*/
                                    }
                                }
                            }
                            else if(ct.getName().length() > newCon.getName().length()) //άλλο σενάριο σύγκρισης μήκους ονομάτων
                            {
                                boolean continueOuter = false;
                                for (int i = 1; i < newCon.getName().length(); i++) /*i = 1, ο πρώτος χαρακτήρας (0)
                                    των αλφαριθμητικών ξέρουμε ότι είναι ίδιος*/
                                {
                                    if(continueOuter == true)
                                    {
                                        break;
                                    }

                                    if(Character.toUpperCase(ct.getName().charAt(i)) > Character.toUpperCase(newCon.getName().charAt(i)))
                                    {
                                        position = ct;
                                        conAdded = true;
                                        breakOuter = true; //για να σπάσει και το εξωτερικό loop
                                        break; //σπάει το loop, βρήκαμε τη θέση στην οποία θα μπει η νέα επαφή
                                    }
                                    else if(Character.toUpperCase(ct.getName().charAt(i)) < Character.toUpperCase(newCon.getName().charAt(i)))
                                    {
                                        continueOuter = true;
                                    }
                                }
                            }
                        }
                    }
                    if (conAdded == false) //αν δηλαδή η νέα επαφή είναι τελευταία αλφαβητικά
                    {
                        contacts.add(newCon); //θα μπει στο τέλος της λίστας
                        System.out.println(contacts.indexOf(newCon));
                    }
                    else
                    {
                        contacts.add(contacts.indexOf(position), newCon);/*εισαγωγή στη λίστα, στη θέση της επαφής
                        το όνομα της οποίας είναι μεγαλύτερο αλφαβητικά, η θέση βρίσκεται μέσω του object position*/
                    }
                }
                else //άν 1ο γράμμα νέας επαφής είναι σύμβολο και όχι γράμμα ή αριθμός
                {
                    contacts.add(0, newCon); //επαφές με σύμβολο μπαίνουν στην αρχή του καταλόγου
                }

                System.out.println("Ο/Η " + newName + " προστέθηκε στις επαφές σας.\n");
            }


            else if (input == 3) //αναζήτηση επαφής βάσει ονόματος
            {
                System.out.print("Πληκτρολογήστε το όνομα της επαφής που θέλετε να βρείτε: ");
                String inputName = scanner.nextLine();
                boolean foundName = false; //μεταβλητή boolean, αρχικά false
                for (Contact ct : contacts)
                {
                    if(ct.getName().equals(inputName))
                    {
                        foundName = true; //βρέθηκε επαφή με το ζητούμενο όνομα, μεταβλητή τίθεται ως true
                        System.out.print("\nΤα υπόλοιπα στοιχεία του/της " + ct.getName() + " είναι: \n\n");
                        ct.showFoundByName(); //κλήση μεθόδου του object
                        System.out.print("\n\n");
                    }
                }
                if(foundName == false)
                {
                    System.out.println("\nΔεν υπάρχει αποθηκευμένη επαφή με το συγκεκριμένο όνομα.\n");
                }
            }


            else if (input == 4) //αναζήτηση επαφής βάσει τηλεφώνου
            {
                String inputTel;
                boolean telOnlyNum;
                do
                {
                    telOnlyNum = true; //μεταβλητή για έλεγχο εγκυρότητας input χρήστη για το πεδίο τηλεφώνου
                    System.out.print("Πληκτρολογήστε το τηλέφωνο της επαφής που θέλετε να βρείτε: ");
                    inputTel = scanner.nextLine();
                    for(int i = 0; i < inputTel.length(); i++)
                    {
                        if(inputTel.charAt(i) < 48 || inputTel.charAt(i) > 57) //εάν δεν είναι νούμερο έστω και ένας χαρακτήρας
                        {
                            System.out.println("Το τηλέφωνο θα πρέπει να περιλαμβάνει μόνο νούμερα!\n");
                            telOnlyNum = false;
                            break; //λάθος input, σπάει το loop
                        }
                    }
                }while (telOnlyNum == false);


                boolean foundTel = false; //μεταβλητή boolean, αρχικά false
                for (Contact ct : contacts)
                {
                    if(ct.getTelephone().equals(inputTel))
                    {
                        foundTel = true; //βρέθηκε επαφή με το ζητούμενο τηλέφωνο, μεταβλητή τίθεται ως true
                        System.out.print("\nΤα υπόλοιπα στοιχεία της επαφής με τηλέφωνο " + ct.getTelephone() + " είναι: \n\n");
                        ct.showFoundByTel(); //κλήση μεθόδου object
                        System.out.print("\n\n");
                    }
                }
                if(foundTel == false)
                {
                    System.out.println("\nΔεν υπάρχει αποθηκευμένη επαφή με το συγκεκριμένο τηλέφωνο.\n");
                }
            }


            else if(input == 5) //επεξεργασία επαφής βάσει ονόματος
            {
                System.out.print("Πληκτρολογήστε το όνομα της επαφής που θέλετε να επεξεργαστείτε: ");
                String modName = scanner.nextLine();
                boolean found = false; //μεταβλητή boolean, αρχικά false
                for (Contact ct : contacts) //αρχικό iteration για να δούμε αν υπάρχει επαφή με αυτό το όνομα
                {
                    if(ct.getName().equals(modName))
                    {
                        found = true;
                        break; //stop στη πρώτη, ακόμη κι αν υπάρχουν πολλές.Μας ενδιαφέρει απλά αν υπάρχει έστω μία
                    }
                }

                if (found == false)
                {
                    System.out.println("\nΔεν υπάρχει αποθηκευμένη επαφή με το συγκεκριμένο όνομα.\n");
                }
                else
                {
                    System.out.println("\nΕπιλέξτε την επιθυμητή ενέργεια πληκτρολογώντας το αντίστοιχο νούμερο");

                    while(true) //loop, θα σπάσει με κάποιο break, αναλόγως την επιλογή του χρήστη
                    {
                        boolean modIsInt = true; //μεταβλητή isInt για μετέπειτα έλεγχο, τίθεται αρχικά true
                        int modInput = -1; /*μεταβλητή τύπου int με τυχαία τιμή(απλώς γιατί πρέπει να έχει τιμή πριν το try-catch, αλλιώς
                                "χτυπάει" μετά, στα ifs)"*/
                        do
                        {
                            try
                            {
                                showModifyMenu(); /*εμφάνιση μενού επιλογών επεξεργασίας, κλήση της άλλης static
                                μεθόδου της class Main*/
                                modIsInt = true; //μεταβλητή modIsInt τίθεται (ξανά) true, για κάθε νέο iteration
                                modInput = scanner.nextInt();
                            }
                            catch (Exception InputMismatchException) //αν το input δεν είναι ακέραιος αριθμός
                            {
                                modIsInt = false;
                                System.out.println("Πρέπει να πληκτρολογήσετε έναν αριθμό (από 1 έως 5)!\n");
                                scanner.nextLine();
                            }
                            if  ((modIsInt == true) && (modInput < 1 || modInput > 5)) /*modIsInt == true, ώστε να
                             εμφανιστεί μόνο αν δεν έχει γίνει InputMismatchException, αν το input είναι εκτός ορίων
                             επιλογής*/
                            {
                                System.out.println("Ο αριθμός πρέπει να είναι από 1 έως 5!\n");
                                modIsInt = false;
                            }
                        }   while(modIsInt == false ); //το loop θα τρέχει όσο το input δεν είναι ακέραιος από 1 έως 5

                        scanner.nextLine(); //για κατανάλωση του \n που έχει μείνει από το scanner.nextInt()
                        String newInfo; //μεταβλητή String, θα της εκχωρηθεί το input χρήστη(όνομα/τηλέφωνο κλπ)

                        if(modInput == 1) //επεξεργασία ονόματος
                        {
                            boolean spaceorEmpty;
                            int spaceCount; //μεταβλητή με την οποία θα μετρήσουμε πόσα spaces υπάρχουν σε input χρήστη (αν υπάρχουν)
                            do
                            {
                                spaceCount = 0; //αρχική τιμή 0, και κάθε φορά που θα ξανατρέχει το loop
                                spaceorEmpty = false; //μεταβλητή για έλεγχο εγκυρότητας input χρήστη για τυχόν κενό όνομα
                                System.out.print("Δώστε το νέο όνομα για την επαφή: ");
                                newInfo = scanner.nextLine();
                                if(newInfo.length() == 0) //1ος έλεγχος, εξετάζουμε αν το String είναι κενό
                                {
                                    System.out.println("Το πεδίο ονόματος δεν μπορεί να είναι κενό!\n");
                                    spaceorEmpty = true; //boolean μεταβλητή τίθεται ως true, το loop θα επαναληφθεί
                                }
                                else //2ος έλεγχος, αν το String δεν είναι κενό, εξετάζουμε αν έχει μόνο space
                                {
                                    for(int i = 0; i < newInfo.length(); i++)
                                    {
                                        if(newInfo.charAt(i) == 32) //εάν ο χαρακτήρας είναι το space
                                        {
                                            spaceCount++;
                                        }
                                    }
                                    if(spaceCount == newInfo.length()) //δηλαδή αν το String περιέχει μόνο spaces
                                    {
                                        System.out.println("Το πεδίο ονόματος δεν μπορεί να είναι κενό!\n");
                                        spaceorEmpty = true; //boolean μεταβλητή τίθεται ως true, το loop θα επαναληφθεί
                                    }
                                }

                            }while (spaceorEmpty == true); /*loop θα τρέχει μέχρι να έχουμε input που δεν αποτελείται μόνο
                         από space και που δεν είναι κενό*/


                            for (Contact ct : contacts)
                            {
                                if(ct.getName().equals(modName))
                                {
                                    ct.setName(newInfo); //κλήση μεθόδου object για αλλαγή ονόματος
                                    System.out.print("\nΕπιτυχής αλλαγή ονόματος επαφής\n\n");
                                    //εμφάνιση όσες φορές αλλάξει όνομα επαφής του καταλόγου
                                }
                            }
                            break; //"σπάει" το εξωτερικό loop, η επεξεργασία έγινε
                        }
                        else if(modInput == 2) //επεξεργασία τηλεφώνου
                        {

                            boolean telOnlyNum;
                            do
                            {
                                telOnlyNum = true; //μεταβλητή για έλεγχο εγκυρότητας input χρήστη για το πεδίο τηλεφώνου
                                System.out.print("Δώστε το νέο τηλέφωνο για την επαφή: ");
                                newInfo = scanner.nextLine();
                                for(int i = 0; i < newInfo.length(); i++)
                                {
                                    if(newInfo.charAt(i) < 48 || newInfo.charAt(i) > 57) //εάν δεν είναι νούμερο έστω και ένας χαρακτήρας
                                    {
                                        System.out.println("Το τηλέφωνο θα πρέπει να περιλαμβάνει μόνο νούμερα!\n");
                                        telOnlyNum = false;
                                        break; //λάθος input, σπάει το loop
                                    }
                                }
                            }while (telOnlyNum == false);

                            for (Contact ct : contacts)
                            {
                                if(ct.getName().equals(modName))
                                {
                                    ct.setTelephone(newInfo);
                                    System.out.print("\nΕπιτυχής αλλαγή τηλεφώνου επαφής\n\n");
                                }
                            }
                            break;
                        }
                        else if(modInput == 3) //επεξεργασία email
                        {
                            System.out.print("Δώστε το νέο email για την επαφή: ");
                            newInfo = scanner.nextLine();
                            for (Contact ct : contacts)
                            {
                                if(ct.getName().equals(modName))
                                {
                                    ct.setMail(newInfo);
                                    System.out.print("\nΕπιτυχής αλλαγή email επαφής\n\n");
                                }
                            }
                            break;
                        }
                        else if(modInput == 4) //επεξεργασία διεύθυνσης
                        {
                            System.out.print("Δώστε τη νέα διεύθυνση για την επαφή: ");
                            newInfo = scanner.nextLine();
                            for (Contact ct : contacts)
                            {
                                if(ct.getName().equals(modName))
                                {
                                    ct.setAddress(newInfo);
                                    System.out.print("\nΕπιτυχής αλλαγή διεύθυνσης επαφής\n\n");
                                }
                            }
                            break;
                        }
                        else if(modInput == 5) //επεξεργασία τίτλου επαγγέλματος
                        {
                            System.out.print("Δώστε τον νέο τίτλο επαγγέλματος για την επαφή: ");
                            newInfo = scanner.nextLine();
                            for (Contact ct : contacts)
                            {
                                if(ct.getName().equals(modName))
                                {
                                    ct.setProf(newInfo);
                                    System.out.print("\nΕπιτυχής αλλαγή τίτλου επαγγέλματος επαφής\n\n");
                                }
                            }
                            break;
                        }
                    }
                }
            }


            else if (input == 6) //διαγραφή επαφής βάσει ονόματος
            {
                ArrayList <Contact> newContacts = new ArrayList<>(); /*νέα ArrayList, θα χρησιμοποιηθεί στην
                περίπτωση που θα χρειαστούν πολλαπλές διαγραφές*/
                System.out.print("Πληκτρολογήστε το όνομα της επαφής που θέλετε να διαγράψετε: ");
                String delName = scanner.nextLine();
                int count = 0; //ακέραιος, αρχική τιμή 0, θα κρατήσει αριθμό επαφών που έχουν το προς διαγραφή όνομα
                for (Contact ct : contacts)
                {
                    if(ct.getName().equals(delName))
                    {
                        count++; //εύρεση του αριθμού επαφών που θα χρειαστεί να διαγράψουμε
                    }
                }
                if(count == 1) //μία μόνο επαφή προς διαγραφή
                {
                    int position = -1; /*ακέραιος για εντοπισμό θέσης του προς διαγραφή στοιχείου. Αρχική τιμή -1,
                    θα αλλάξει στη συνέχεια*/
                    for(Contact ct : contacts)
                    {
                        if(ct.getName().equals(delName)) //εάν το όνομα επαφής είναι αυτό που δόθηκε για διαγραφή
                        {
                            position = contacts.indexOf(ct);
                        }
                    }
                    contacts.remove(contacts.get(position)); //διαγραφή μίας και μοναδικής επαφής
                    System.out.println("Ο/Η " + delName + " διαγράφηκε από τις επαφές σας.\n");
                }
                else if(count > 1) //περισσότερες από μία επαφές προς διαγραφή
                {
                    for(Contact ct : contacts)
                    {
                        if(!(ct.getName().equals(delName)))//εάν το όνομα επαφής δεν είναι αυτό που δόθηκε για διαγραφή
                        {
                            newContacts.add(ct); //προσθήκη επαφής σε νέα λίστα
                        }
                    }
                    contacts = newContacts; /*newContacts είναι η λίστα επαφών χωρίς τα ονόματα που έπρεπε να
                    διαγραφούν, οπότε η contacts αποκτά νέο περιεχόμενο, αυτό της newContacts*/
                    System.out.println("Βρέθηκαν παραπάνω από μία επαφές με το όνομα " + delName + ".");
                    System.out.println("Οι επαφές διαγράφηκαν από τον κατάλογο.\n");
                }

                else
                {
                    System.out.println("\nΔεν υπάρχει αποθηκευμένη επαφή με το συγκεκριμένο όνομα.\n");
                }

            }
            else if (input == 7) //έξοδος από την εφαρμογή
            {
                System.out.println("Έξοδος από την εφαρμογή.."); //ενημέρωση και..
                return; //η συνάρτηση main τερματίζεται
            }

        }
    }


}
