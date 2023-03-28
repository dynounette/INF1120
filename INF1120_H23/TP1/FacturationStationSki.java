/**
 * Ce programme permet d'effectuer la facturation pour
 * la vente de billets dans une station de ski alpin.
 * auteure: Dyna Mehenni MEHD84580003
 */
public class FacturationStationSki {

    public static void main(String[] args) {

        //----------------------
        // VARIABLES
        //----------------------
        //choix de l'utilisateur au menu
        char choixMenu;
        //choix de l'utilisateur au menu periode
        char choixPeriodes;
        //choix de l'utilisateur au menu tranches d'ages
        char choixAges;
        //nombre de billet choisi par l'utilisateur
        int nombreBillets = 0;
        //numero de la facture de l'utilisateur
        int numeroFacture = 0;
        //montant total des prix des billets achetés de l'utilisateur
        double facture = 0.00;
        //montant des recettes
        double recette = 0.00;
        //montant total de la facture de l'utilisateur
        double totalFacture = 0.00;
        String billet = "";
        String factureFormat = "";
        final String MSG_ERR_MENU = "\nErreur ! Vous devez entrer "
                + "1, 2, 3 ou 4... Recommencez !\n";
        final String MSG_ERR_PERIODES = "\nErreur ! Vous devez entrer "
                + "A, B, C ou D... Recommencez !\n";
        final String MSG_ERR_AGES = "\nErreur ! Vous devez entrer "
                + "A, B, C, D, E ou F... Recommencez !\n";
        final String MSG_ERR_NBR_BILLETS = "\nErreur ! Vous devez entrer "
                + "un nombre entre 0 et 9 inclusivement. Recommencez...\n";
        final String MSG_FIN = "\n\nAurevoir !";
        final String PRESENTATION = "\n\nCe programme permet d'effectuer la facturation pour\n" +
                "la vente de billets dans une station de ski alpin.\n";
        final String MENU_PRINCIPAL = "\n====\nMENU\n====\n"
                + "1. Vente de billets\n"
                + "2. Consultation des recettes\n"
                + "3. Reinitialisation\n"
                + "4. Quitter"
                + "\n\nEntrez votre choix : ";
        final String MENU_PERIODES = "\n----------------\n"
                + "VENTE DE BILLETS\n"
                + "----------------\n"
                + "Periodes :\n"
                + "A. Jour\n"
                + "B. Jour et soir\n"
                + "C. Soirée\n"
                + "D. Terminer"
                + "\n\nEntrez votre choix : ";
        final String TRANCHES_AGES = "\nTranches d'âges : \n"
                + "A. 0 - 6\n"
                + "B. 7 - 12\n"
                + "C. 13 - 24\n"
                + "D. 25 - 69\n"
                + "E. 70 et +\n"
                + "F. Terminer"
                + "\n\nEntrez votre choix : ";
        final String REINITIALISATION = "----------------\n"
                + "RÉINITIALISATION\n"
                + "----------------\n"
                + "\n"
                + "---> RÉINITIALISATION EFFECTUÉE <---";

        final String MSG_ENTREE = "\nAppuyez sur <ENTREE> pour revenir au menu...";
        final String MSG_NBR_BILLETS = "\nEntrez le nombre de billets : ";
        final double BILLETS_MIN = 0;
        final double BILLETS_MAX = 9;
        final double ENFANT = 11.52// 0 à 6 ans
                ,JEUNE_J = 33.92, JEUNE_JS = 38.92, JEUNE_S = 22.18 // 7 à 12 ans
                ,ADO_J = 42.62 ,ADO_JS = 47.84 ,ADO_S = 26.31 // 13 à 24 ans
                ,ADULTE_J = 56.53, ADULTE_JS = 61.75, ADULTE_S = 32.62// 25 à 69 ans
                ,VIEUX_J = 37.40, VIEUX_JS = 37.40, VIEUX_S = 26.31;//70 ans et plus
        // J POUR JOUR ; JS POUR JOUR ET SOIR ; S POUR SOIRÉE


        //presentation du programme
        System.out.println(PRESENTATION);

        //AFFICHER MENU PRINCIPAL
        do
        {
            System.out.print(MENU_PRINCIPAL);
            choixMenu = Clavier.lireCharLn();

            switch(choixMenu)
            {
                //TRAITEMENT VENTE DE BILLET
                case '1':
                    do
                    {
                        //AFFICHER MENU PERIODES
                        System.out.print(MENU_PERIODES);
                        choixPeriodes = Clavier.lireCharLn();
                        choixPeriodes = Character.toUpperCase(choixPeriodes);

                        switch(choixPeriodes)
                        {
                            //CHOIX PERIODE JOUR
                            case 'A':
                                //CHOIX TRANCHES D'AGES
                                do
                                {
                                    System.out.print(TRANCHES_AGES);
                                    choixAges = Clavier.lireCharLn();
                                    choixAges = Character.toUpperCase(choixAges);

                                    //CHOIX AGE 0 - 6 ANS
                                    if(choixAges == 'A')
                                    {
                                        System.out.print(MSG_NBR_BILLETS);
                                        nombreBillets = Clavier.lireIntLn();
                                        while(nombreBillets > BILLETS_MAX || nombreBillets < BILLETS_MIN )
                                        {
                                            System.out.print(MSG_ERR_NBR_BILLETS);
                                            System.out.print(MSG_NBR_BILLETS);
                                            nombreBillets = Clavier.lireIntLn();
                                        }
                                        if(nombreBillets != 0){
                                            System.out.println("\nAJOUT DE " + nombreBillets + " BILLET(S) 0 - 6 ans | JOUR");
                                            facture = (ENFANT * nombreBillets);
                                            factureFormat = String.format("%.2f", facture);
                                            billet += nombreBillets + " BILLET(S) | JOUR      | 0 - 6 ans      :   " + factureFormat + " $\n";
                                            totalFacture += facture;
                                        }
                                    }
                                    //CHOIX AGE 7 - 12 ANS
                                    else if (choixAges == 'B')
                                    {
                                        System.out.print(MSG_NBR_BILLETS);
                                        nombreBillets = Clavier.lireIntLn();
                                        while(nombreBillets > BILLETS_MAX || nombreBillets < BILLETS_MIN )
                                        {
                                            System.out.print(MSG_ERR_NBR_BILLETS);
                                            System.out.print(MSG_NBR_BILLETS);
                                            nombreBillets = Clavier.lireIntLn();
                                        }
                                        if(nombreBillets != 0) {
                                            System.out.println("\nAJOUT DE " + nombreBillets + " BILLET(S) 7 - 12 ans | JOUR");
                                            facture = (JEUNE_J * nombreBillets);
                                            factureFormat = String.format("%.2f", facture);
                                            billet += nombreBillets + " BILLET(S) | JOUR      | 7 - 12 ans     :   " + factureFormat + " $\n";
                                            totalFacture += facture;
                                        }
                                    }
                                    //CHOIX AGE 13 - 24 ANS
                                    else if (choixAges == 'C')
                                    {
                                        System.out.print(MSG_NBR_BILLETS);
                                        nombreBillets = Clavier.lireIntLn();
                                        while(nombreBillets > BILLETS_MAX || nombreBillets < BILLETS_MIN )
                                        {
                                            System.out.print(MSG_ERR_NBR_BILLETS);
                                            System.out.print(MSG_NBR_BILLETS);
                                            nombreBillets = Clavier.lireIntLn();
                                        }
                                        if(nombreBillets != 0){
                                            System.out.println("\nAJOUT DE " + nombreBillets + " BILLET(S) 13 - 24 ans | JOUR");
                                            facture = (ADO_J * nombreBillets);
                                            factureFormat = String.format("%.2f", facture);
                                            billet += nombreBillets + " BILLET(S) | JOUR      | 13 - 24 ans    :   " + factureFormat + " $\n";
                                            totalFacture += facture;
                                        }
                                    }
                                    //CHOIX AGE 25 - 69 ANS
                                    else if (choixAges == 'D')
                                    {
                                        System.out.print(MSG_NBR_BILLETS);
                                        nombreBillets = Clavier.lireIntLn();
                                        while(nombreBillets > BILLETS_MAX || nombreBillets < BILLETS_MIN )
                                        {
                                            System.out.print(MSG_ERR_NBR_BILLETS);
                                            System.out.print(MSG_NBR_BILLETS);
                                            nombreBillets = Clavier.lireIntLn();
                                        }
                                        if(nombreBillets != 0){
                                            System.out.println("\nAJOUT DE " + nombreBillets + " BILLET(S) 25 - 69 ans | JOUR");
                                            facture = (ADULTE_J * nombreBillets);
                                            factureFormat = String.format("%.2f", facture);
                                            billet += nombreBillets + " BILLET(S) | JOUR      | 25 - 69 ans    :   " + factureFormat + " $\n";
                                            totalFacture += facture;
                                        }
                                    }
                                    //CHOIX AGE 70 ANS ET PLUS
                                    else if (choixAges == 'E')
                                    {
                                        System.out.print(MSG_NBR_BILLETS);
                                        nombreBillets = Clavier.lireIntLn();
                                        while(nombreBillets > BILLETS_MAX || nombreBillets < BILLETS_MIN )
                                        {
                                            System.out.print(MSG_ERR_NBR_BILLETS);
                                            System.out.print(MSG_NBR_BILLETS);
                                            nombreBillets = Clavier.lireIntLn();
                                        }
                                        if(nombreBillets != 0){
                                            System.out.println("\nAJOUT DE " + nombreBillets + " BILLET(S)  70 ans et plus | JOUR");
                                            facture = (VIEUX_J * nombreBillets);
                                            factureFormat = String.format("%.2f", facture);
                                            billet += nombreBillets + " BILLET(S) | JOUR      | 70 ans et plus :   " + factureFormat + " $\n";
                                            totalFacture += facture;
                                        }
                                    }
                                    else if (choixAges == 'F')
                                    {
                                    }
                                    else {
                                        System.out.print(MSG_ERR_AGES);
                                    }

                                } while(choixAges !='F');
                                break;

                            //CHOIX PERIODE JOUR/SOIR
                            case 'B':
                                //AFFICHER TRANCHES D'AGES
                                do
                                {
                                    System.out.print(TRANCHES_AGES);
                                    choixAges = Clavier.lireCharLn();
                                    choixAges = Character.toUpperCase(choixAges);

                                    //CHOIX AGE 0 - 6 ANS
                                    if(choixAges == 'A')
                                    {
                                        System.out.print(MSG_NBR_BILLETS);
                                        nombreBillets = Clavier.lireIntLn();
                                        while(nombreBillets > BILLETS_MAX || nombreBillets < BILLETS_MIN )
                                        {
                                            System.out.print(MSG_ERR_NBR_BILLETS);
                                            System.out.print(MSG_NBR_BILLETS);
                                            nombreBillets = Clavier.lireIntLn();
                                        }
                                        if(nombreBillets != 0){
                                            System.out.println("\nAJOUT DE " + nombreBillets + " BILLET(S) 0 - 6 ans | JOUR/SOIR");
                                            facture = (ENFANT * nombreBillets);
                                            factureFormat = String.format("%.2f", facture);
                                            billet += nombreBillets + " BILLET(S) | JOUR/SOIR | 0 - 6 ans      :   " + factureFormat + " $\n";
                                            totalFacture += facture;
                                        }
                                    }
                                    //CHOIX AGE 7 - 12 ANS
                                    else if (choixAges == 'B')
                                    {
                                        System.out.print(MSG_NBR_BILLETS);
                                        nombreBillets = Clavier.lireIntLn();
                                        while(nombreBillets > BILLETS_MAX || nombreBillets < BILLETS_MIN )
                                        {
                                            System.out.print(MSG_ERR_NBR_BILLETS);
                                            System.out.print(MSG_NBR_BILLETS);
                                            nombreBillets = Clavier.lireIntLn();
                                        }
                                        if(nombreBillets != 0){
                                            System.out.println("\nAJOUT DE " + nombreBillets + " BILLET(S) 7 - 12 ans | JOUR/SOIR");
                                            facture = (JEUNE_JS * nombreBillets);
                                            factureFormat = String.format("%.2f", facture);
                                            billet += nombreBillets + " BILLET(S) | JOUR/SOIR | 7 - 12 ans     :   " + factureFormat + " $\n";
                                            totalFacture += facture;
                                        }
                                    }
                                    //CHOIX AGE 13 - 24
                                    else if (choixAges == 'C')
                                    {
                                        System.out.print(MSG_NBR_BILLETS);
                                        nombreBillets = Clavier.lireIntLn();
                                        while(nombreBillets > BILLETS_MAX || nombreBillets < BILLETS_MIN )
                                        {
                                            System.out.print(MSG_ERR_NBR_BILLETS);
                                            System.out.print(MSG_NBR_BILLETS);
                                            nombreBillets = Clavier.lireIntLn();
                                        }
                                        if(nombreBillets != 0){
                                            System.out.println("\nAJOUT DE " + nombreBillets + " BILLET(S) 13 - 24 ans | JOUR/SOIR");
                                            facture = (ADO_JS * nombreBillets);
                                            factureFormat = String.format("%.2f", facture);
                                            billet += nombreBillets + " BILLET(S) | JOUR/SOIR | 13 - 24 ans    :   " + factureFormat + " $\n";
                                            totalFacture += facture;
                                        }
                                    }
                                    //CHOIX AGE 26 - 69 ANS
                                    else if (choixAges == 'D')
                                    {
                                        System.out.print(MSG_NBR_BILLETS);
                                        nombreBillets = Clavier.lireIntLn();
                                        while(nombreBillets > BILLETS_MAX || nombreBillets < BILLETS_MIN )
                                        {
                                            System.out.print(MSG_ERR_NBR_BILLETS);
                                            System.out.print(MSG_NBR_BILLETS);
                                            nombreBillets = Clavier.lireIntLn();
                                        }
                                        if(nombreBillets != 0){
                                            System.out.println("\nAJOUT DE " + nombreBillets + " BILLET(S) 25 - 69 ans | JOUR/SOIR");
                                            facture = (ADULTE_JS * nombreBillets);
                                            factureFormat = String.format("%.2f", facture);
                                            billet += nombreBillets + " BILLET(S) | JOUR/SOIR | 25 - 69 ans    :   " + factureFormat + " $\n";
                                            totalFacture += facture;
                                        }
                                    }
                                    //CHOIX AGE 70 ANS ET PLUS
                                    else if (choixAges == 'E')
                                    {
                                        System.out.print(MSG_NBR_BILLETS);
                                        nombreBillets = Clavier.lireIntLn();
                                        while(nombreBillets > BILLETS_MAX || nombreBillets < BILLETS_MIN )
                                        {
                                            System.out.print(MSG_ERR_NBR_BILLETS);
                                            System.out.print(MSG_NBR_BILLETS);
                                            nombreBillets = Clavier.lireIntLn();
                                        }
                                        if(nombreBillets != 0){
                                            System.out.println("\nAJOUT DE " + nombreBillets + " BILLET(S) 70 ans et plus | JOUR/SOIR");
                                            facture = (VIEUX_JS * nombreBillets);
                                            factureFormat = String.format("%.2f", facture);
                                            billet += nombreBillets + " BILLET(S) | JOUR/SOIR | 70 ans et plus :   " + factureFormat + " $\n";
                                            totalFacture += facture;
                                        }
                                    }
                                    //CHOIX TERMINER
                                    else if (choixAges == 'F')
                                    {
                                    }
                                    //MSG ERREUR TRANCHES D'AGES
                                    else {
                                        System.out.print(MSG_ERR_AGES);

                                    }
                                } while(choixAges !='F');
                                break;

                            //CHOIX PERIODE SOIRÉE
                            case 'C':
                                //AFFICHER MENU TRANCHES D'AGES
                                do
                                {
                                    System.out.print(TRANCHES_AGES);
                                    choixAges = Clavier.lireCharLn();
                                    choixAges = Character.toUpperCase(choixAges);

                                    //CHOIX AGE 0 - 6 ANS
                                    if(choixAges == 'A')
                                    {
                                        System.out.print(MSG_NBR_BILLETS);
                                        nombreBillets = Clavier.lireIntLn();
                                        while(nombreBillets > BILLETS_MAX || nombreBillets < BILLETS_MIN )
                                        {
                                            System.out.print(MSG_ERR_NBR_BILLETS);
                                            System.out.print(MSG_NBR_BILLETS);
                                            nombreBillets = Clavier.lireIntLn();
                                        }
                                        if(nombreBillets != 0){
                                            System.out.println("\nAJOUT DE " + nombreBillets + " BILLET(S) 0 - 6 ans | SOIRÉE");
                                            facture = (ENFANT * nombreBillets);
                                            factureFormat = String.format("%.2f", facture);
                                            billet += nombreBillets + " BILLET(S) | SOIRÉE    | 0 - 6 ans      :   " + factureFormat + " $\n";
                                            totalFacture += facture;
                                        }
                                    }
                                    //CHOIX AGE 7 - 12 ANS
                                    else if (choixAges == 'B')
                                    {
                                        System.out.print(MSG_NBR_BILLETS);
                                        nombreBillets = Clavier.lireIntLn();
                                        while(nombreBillets > BILLETS_MAX || nombreBillets < BILLETS_MIN )
                                        {
                                            System.out.print(MSG_ERR_NBR_BILLETS);
                                            System.out.print(MSG_NBR_BILLETS);
                                            nombreBillets = Clavier.lireIntLn();
                                        }
                                        if(nombreBillets != 0){
                                            System.out.println("\nAJOUT DE " + nombreBillets + " BILLET(S) 7 - 12 ans | SOIRÉE");
                                            facture = (JEUNE_S * nombreBillets);
                                            factureFormat = String.format("%.2f", facture);
                                            billet += nombreBillets + " BILLET(S) | SOIRÉE    | 7 - 12 ans   :   " + factureFormat + " $\n";
                                            totalFacture += facture;
                                        }
                                    }
                                    //CHOIX AGE 13 - 24 ANS
                                    else if (choixAges == 'C')
                                    {
                                        System.out.print(MSG_NBR_BILLETS);
                                        nombreBillets = Clavier.lireIntLn();
                                        while(nombreBillets > BILLETS_MAX || nombreBillets < BILLETS_MIN )
                                        {
                                            System.out.print(MSG_ERR_NBR_BILLETS);
                                            System.out.print(MSG_NBR_BILLETS);
                                            nombreBillets = Clavier.lireIntLn();
                                        }
                                        if(nombreBillets != 0){
                                            System.out.println("\nAJOUT DE " + nombreBillets + " BILLET(S) 13 - 24 ans | SOIRÉE");
                                            facture = (ADO_S * nombreBillets);
                                            factureFormat = String.format("%.2f", facture);
                                            billet += nombreBillets + " BILLET(S) | SOIRÉE    | 13 - 24 ans     :   " + factureFormat + " $\n";
                                            totalFacture += facture;
                                        }
                                    }
                                    //CHOIX AGE 25 - 69 ANS
                                    else if (choixAges == 'D')
                                    {
                                        System.out.print(MSG_NBR_BILLETS);
                                        nombreBillets = Clavier.lireIntLn();
                                        while(nombreBillets > BILLETS_MAX || nombreBillets < BILLETS_MIN )
                                        {
                                            System.out.print(MSG_ERR_NBR_BILLETS);
                                            System.out.print(MSG_NBR_BILLETS);
                                            nombreBillets = Clavier.lireIntLn();
                                        }
                                        if(nombreBillets != 0){
                                            System.out.println("\nAJOUT DE " + nombreBillets + " BILLET(S) 25 - 69 ans | SOIRÉE");
                                            facture = (ADULTE_S * nombreBillets);
                                            factureFormat = String.format("%.2f", facture);
                                            billet += nombreBillets + " BILLET(S) | SOIRÉE    | 25 - 69 ANS    :   " + factureFormat + " $\n";
                                            totalFacture += facture;
                                        }
                                    }
                                    //CHOIX AGE 70 ANS ET PLUS
                                    else if (choixAges == 'E')
                                    {
                                        System.out.print(MSG_NBR_BILLETS);
                                        nombreBillets = Clavier.lireIntLn();
                                        while(nombreBillets > BILLETS_MAX || nombreBillets < BILLETS_MIN )
                                        {
                                            System.out.print(MSG_ERR_NBR_BILLETS);
                                            System.out.print(MSG_NBR_BILLETS);
                                            nombreBillets = Clavier.lireIntLn();
                                        }
                                        if(nombreBillets != 0){
                                            System.out.println("\nAJOUT DE " + nombreBillets + " BILLET(S) 70 ans et plus | SOIRÉE");
                                            facture = (VIEUX_S * nombreBillets);
                                            factureFormat = String.format("%.2f", facture);
                                            billet += nombreBillets + " BILLET(S) | SOIRÉE    | 70 ans et plus :   " + factureFormat + " $\n";
                                            totalFacture += facture;
                                        }
                                    }
                                    //CHOIX TERMINER
                                    else if (choixAges == 'F')
                                    {
                                    }
                                    //MSG ERREUR TRANCHES D'AGES
                                    else
                                        System.out.print(MSG_ERR_AGES);


                                } while(choixAges !='F');
                                break;

                            //QUITTER LE MENU PERIODE
                            case 'D':
                                if(totalFacture == 0) {
                                    System.out.println("\n---> OPERATION ANNULEE <---");
                                    System.out.print(MSG_ENTREE);
                                    Clavier.lireFinLigne();
                                }
                                //AFFICHER LA FACTURE TOTAL
                                else {
                                    numeroFacture++;
                                    System.out.println("\nFacture # " + numeroFacture + "\n");
                                    System.out.print(billet);
                                    String totalFactureFormat = "";
                                    totalFactureFormat = String.format("%.2f", totalFacture);
                                    System.out.println("\nTOTAL : " + totalFactureFormat + " $");
                                    billet = "";
                                    recette += totalFacture;
                                    totalFacture = 0.00;
                                    System.out.print(MSG_ENTREE);
                                    Clavier.lireFinLigne();
                                }
                                break;

                            //MSG ERREUR MENU PERIODE
                            default:
                                System.out.print(MSG_ERR_PERIODES);

                        }

                    }while(choixPeriodes != 'D');

                    break;

                //TRAITEMENT CONSULTATION DES RECETTES
                case '2':
                    String recetteFormat = "";
                    recetteFormat = String.format("%.2f", recette);
                    System.out.println("\n-------------------------\nCONSULTATION DES RECETTES\n"
                            +"-------------------------\n\nRecettes : " + recetteFormat + " $");
                    System.out.print(MSG_ENTREE);
                    Clavier.lireFinLigne();
                    break;

                //TRAITEMENT REINITIALISATION
                case '3':
                    System.out.println(REINITIALISATION);
                    recette = 0.00;
                    facture = 0.00;
                    totalFacture = 0.00;
                    numeroFacture = 0;
                    nombreBillets = 0;
                    System.out.print(MSG_ENTREE);
                    Clavier.lireFinLigne();
                    break;

                //TRAITEMENT QUITTER
                case '4':
                    System.out.print(MSG_FIN);
                    break;

                //ERREUR CHOIX MENU...
                default:
                    System.out.print(MSG_ERR_MENU);
            }

        }while (choixMenu != '4');

    }
}
