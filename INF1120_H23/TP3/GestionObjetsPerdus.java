/**
 * Cette classe permet la gestion des objets perdus. Elle peut être utilisée dans un comptoir des objets perdus.
 * Elle permet de supprimer, ajouter et lister les objets perdus. Elle permet également d'afficher les objets par
 * mots clés, date et catégorie. Enfin, elle sauvegarde les résultats dans un fichier texte.
 *
 * @author Dyna Mehenni
 * Code Permanent: MEHD84580003
 * Cours : INF1120
 * @version 20/04/2023
 */


public class GestionObjetsPerdus {
    //declaration des constantes
    public static final String PRESENTATION = "\n=========================\nGESTION DES OBJETS PERDUS\n=========================\n";
    public static final String MENU = "----\nMENU\n----\n" +
            "1. Consigner un objet perdu\n" +
            "2. Rendre un objet reclame\n" +
            "3. Rechercher un objet par mots cles\n" +
            "4. Rechercher un objet par date(s)\n" +
            "5. Rechercher un objet par categorie\n" +
            "6. Afficher tous les objets consignes\n" +
            "7. Quitter\n";
    public static final String MSG_ERR_MENU = "\nERREUR, vous devez entrer un choix entre 1 et 7! RECOMMENCEZ...";
    public static final String MSG_CHOIX = "\nEntrez votre choix : ";
    public static final String MSG_FIN = "AUREVOIR !";
    public static final String MSG_OPTION_1 = "\n------------------------\nCONSIGNER UN OBJET PERDU\n------------------------\n";
    public static final String MSG_OPTION_2 = "\n-----------------------\nRENDRE UN OBJET RECLAME\n-----------------------\n";
    public static final String MSG_ID = "Entrez le numero d'identification (id) de l'objet a rendre : ";
    public static final String MSG_ERR_ID = "** L'OBJET PERDU AYANT CET ID N'EST PAS CONSIGNE **";
    public static final String QUESTION = "Voulez-vous vraiment rendre cet objet perdu (oui / non) : \n";
    public static final String MSG_ERR_QUESTION = "ERREUR, vous devez entrer OUI ou NON! RECOMMENCEZ...";
    public static final String MSG_ANNULEE = "** LA REMISE DE L'OBJET PERDU A ETE ANNULEE **";
    public static final String MSG_SUCCES = "** LA REMISE DE L'OBJET PERDU A ETE EFFECTUEE AVEC SUCCES **";
    public static final String MSG_OPTION_3 = "\n------------------------\nRECHERCHER PAR MOTS CLES\n------------------------\n";
    public static final String MSG_MOT_CLE = "Mot(s) cle(s) recherches : ";
    public static final String RESULTAT = "RESULTAT(S) DE LA RECHERCHE : ";
    public static final String MSG_AUCUN_OBJET = "** AUCUN OBJET TROUVE **";
    public static final String MSG_OPTION_4 = "\n----------------------\nRECHERCHER PAR DATE(S)\n----------------------\n";
    public static final String MSG_D_OU_P = "Specifier une (d)ate ou une (p)eriode : ";
    public static final String MSG_ERR_PERIODE = "ERREUR, entrez le caractere D ou P! RECOMMENCEZ...";
    public static final String MSG_DATE = "Date : ";
    public static final String MSG_DEBUT_PERIODE = "Date du debut de la periode : ";
    public static final String MSG_FIN_PERIODE = "Date de la fin de la periode : ";
    public static final String MSG_OPTION_5 = "\n------------------------\nRECHERCHER PAR CATEGORIE\n------------------------\n";
    public static final String MSG_OPTION_6 = "\n----------------------------------\nAFFICHER TOUS LES OBJETS CONSIGNES\n----------------------------------\n";
    public static final String MSG_AUCUN_CONSIGNE = "** AUCUN OBJET PERDU N'EST CONSIGNE **";
    public static final String MSG_CAT = "Entrez le numero de la categorie : ";
    public static final String MSG_ERR_CAT = "\nERREUR, entrez un numero entre 1 et 5! RECOMMENCEZ...\n";
    public static final String MENU_CAT = "CATEGORIES :\n" +
            "1. bijou\n" +
            "2. vetement\n" +
            "3. argent / portefeuille\n" +
            "4. cle(s)\n" +
            "5. autre\n";
    public static final String MSG_DATE_CONSIGNE = "Date de consignation :";
    public static final String MSG_JOUR = "\t\tEntrez le jour de la date : ";
    public static final String MSG_MOIS = "\t\tEntrez le mois de la date : ";
    public static final String MSG_ANNEE = "\t\tEntrez l'annee de la date : ";
    public static final String MSG_ERR_DATE = "\n\t\tERREUR, entrez un entier strictement positif! RECOMMENCEZ...";
    public static final String MSG_DATE_INVALIDE = "ERREUR, date invalide! RECOMMENCEZ...\n";
    public static final String MSG_DESCRIPTION = "Entrez les mots-cles decrivant l'objet a consigner : ";
    public static final String MSG_ERR_MOTS_CLES = "\nERREUR, la chaine doit contenir entre 2 et 50 caracteres! RECOMMENCEZ...";
    public final static String MSG_LOCALISATION = "Entrez la localisation de l'objet perdu consigne : ";
    public final static String MSG_ERR_LOCALISATION = "ERREUR, la chaine doit contenir entre 5 et 50 caracteres! RECOMMENCEZ...";
    public final static String ID = "ID : ";
    public final static String MOTS_CLES = "MOTS CLES : ";
    public final static String CAT = "CATEGORIE : ";
    public final static String DATE = "DATE : ";
    public final static String LOCALISATION = "LOCALISATION : ";
    public static final String MSG_ENTREE = "Appuyez sur <ENTREE> pour revenir au menu... ";
    public static final int MIN_MOTS_CLES = 2;
    public static final int MAX_MOTS_CLES = 50;
    public static final int MIN_LOCALISATION = 5;
    public static final int MAX_LOCALISATION = 50;
    public static final int MIN_CAT = 1;
    public static final int MAX_CAT = 5;
    public static final String OUI = "oui";
    public static final String NON = "non";
    public static final char D = 'd';
    public static final char P = 'p';


    /**
     * Cette méthode vérifie si un tableau de chaînes de caractères contient un autre tableau de chaînes de caractères.
     * @param tableau le tableau de chaînes de caractères dans lequel chercher
     * @param sousTableau le tableau de chaînes de caractères à chercher
     * @return true si le sous-tableau est contenu dans le tableau, false sinon
     */
    public static boolean containsArray(String[] tableau, String[] sousTableau) {
        for (int i = 0; i <= tableau.length - sousTableau.length; i++) {
            boolean found = true;
            for (int j = 0; j < sousTableau.length; j++) {
                if (!tableau[i+j].equalsIgnoreCase(sousTableau[j])) {
                    found = false;

                }
            }
            if (found) {
                return true;
            }
        }
        return false;
    }

    /**
     *Cette méthode permet de consigner un objet perdu dans un tableau d'objets perdus.
     *
     *@param objetsPerdus Le tableau d'objets perdus dans lequel consigner l'objet.
     *@return Le tableau d'objets perdus mis à jour avec le nouvel objet consigné.
     */
    public static ObjetPerdu[] option1(ObjetPerdu[] objetsPerdus) {
        int choix;
        int categorie;
        int jour;
        int mois;
        int annee;
        String chaineMotsCles;
        String localisation;

        System.out.println(MSG_OPTION_1);
        System.out.println(MENU_CAT);
        categorie = (TP3Utils.validerEntier(MSG_CAT, MSG_ERR_CAT, MIN_CAT, MAX_CAT))-1;


        System.out.println(MSG_DATE_CONSIGNE);
        jour = TP3Utils.validerTypeEntierStrictPositif(MSG_JOUR, MSG_ERR_DATE);
        mois = TP3Utils.validerTypeEntierStrictPositif(MSG_MOIS, MSG_ERR_DATE);
        annee = TP3Utils.validerTypeEntierStrictPositif(MSG_ANNEE, MSG_ERR_DATE);
        Date date1 = new Date(jour, mois, annee);
        //valliderDate
        while (date1.estDateValide() == false || (date1.estPlusPetite(Date.dateDuJour()) == false && date1.estEgale(Date.dateDuJour()) == false)){
            System.out.println(MSG_DATE_INVALIDE);
            System.out.println(MSG_DATE_CONSIGNE);
            jour = TP3Utils.validerTypeEntierStrictPositif(MSG_JOUR, MSG_ERR_DATE);
            mois = TP3Utils.validerTypeEntierStrictPositif(MSG_MOIS, MSG_ERR_DATE);
            annee = TP3Utils.validerTypeEntierStrictPositif(MSG_ANNEE, MSG_ERR_DATE);
            date1.setJour(jour);
            date1.setMois(mois);
            date1.setAnnee(annee);
        }


        chaineMotsCles = TP3Utils.validerLngChaine(MSG_DESCRIPTION, MSG_ERR_MOTS_CLES, MIN_MOTS_CLES, MAX_MOTS_CLES);
        String[] motsCles = chaineMotsCles.split("\\s+");

        localisation = TP3Utils.validerLngChaine(MSG_LOCALISATION, MSG_ERR_LOCALISATION, MIN_LOCALISATION, MAX_LOCALISATION);
        ObjetPerdu objet1 = new ObjetPerdu(categorie, date1, localisation);
        objet1.motsCles = motsCles;

        if (ObjetPerdu.nbrElem - 1 == objetsPerdus.length) {
            ObjetPerdu[] tab = new ObjetPerdu[objetsPerdus.length + 4];
            for (int i = 0; i < objetsPerdus.length; i++) {
                tab[i] = objetsPerdus[i];
            }
            objetsPerdus = tab;
        }

        objetsPerdus[ObjetPerdu.nbrElem - 1] = objet1;
        System.out.println();

        return objetsPerdus;

    }

    /**
     *  Cette méthode permet de gérer la réclamation d'un objet perdu.
     * @param objetsPerdus le tableau d'ObjetPerdu à modifier
     * @return le tableau d'ObjetPerdu modifié
     */
    public static ObjetPerdu[] option2(ObjetPerdu[] objetsPerdus) {
        int id;
        int i = 0;
        String rep;
        boolean status = false;

        System.out.println(MSG_OPTION_2);

        id = TP3Utils.validerTypeEntierStrictPositif(MSG_ID,MSG_ERR_ID);


        while(i < ObjetPerdu.nbrElem && !status) {
            if(objetsPerdus[i].getId() == id)
                status = true;
            i++;
        }
        if(!status) {
            System.out.println(MSG_AUCUN_OBJET);
        } else {
            i--;
            System.out.println(ID + objetsPerdus[i].getId());
            System.out.println(MOTS_CLES + objetsPerdus[i].obtenirMotsCles());
            System.out.println(CAT + ObjetPerdu.CATEGORIES[objetsPerdus[i].getCategorie()]);
            System.out.println(DATE + objetsPerdus[i].getDate());
            System.out.println(LOCALISATION + objetsPerdus[i].getLocalisation());
            System.out.println();

            rep = TP3Utils.validerRepDeuxChoix(QUESTION,MSG_ERR_QUESTION,OUI, NON);

            if(rep.equalsIgnoreCase(NON)) {
                System.out.println(MSG_ANNULEE);
            }
            else if (rep.equalsIgnoreCase(OUI)) {
                for(int j = i; j < objetsPerdus.length-1; j++) {
                    objetsPerdus[j] = objetsPerdus[j+1];
                }
                objetsPerdus[objetsPerdus.length-1] = null;
                System.out.println(MSG_SUCCES);
            }


        }
        System.out.println(MSG_ENTREE);
        Clavier.lireFinLigne();

        ObjetPerdu.nbrElem--;

        return objetsPerdus;
    }


    /**
     * Cette méthode permet de rechercher un objet perdu par mot(s) clé(s)
     * Elle affiche les informations de chaque objet trouvé et affiche un message d'erreur si aucun objet
     * correspondant à la catégorie spécifiée n'est trouvé.
     * @param objetsPerdus le tableau d'objets perdus à parcourir pour effectuer la recherche
     */
    public static void option3(ObjetPerdu[] objetsPerdus) {
        String motsCle;
        int i=0;
        String[] motsCles;
        boolean status = false;

        System.out.println(MSG_OPTION_3);

        motsCle = TP3Utils.validerLngChaine(MSG_MOT_CLE,MSG_ERR_MOTS_CLES,MIN_MOTS_CLES,MAX_MOTS_CLES);
        motsCle = motsCle.trim();

        motsCles = motsCle.split("\\s+");

        while(i < ObjetPerdu.nbrElem) {
            objetsPerdus[i].motsCles =  objetsPerdus[i].obtenirMotsCles().split(" ");
            if(containsArray(objetsPerdus[i].motsCles ,motsCles)) {
                status = true;
                System.out.println(RESULTAT);
                System.out.println(ID + objetsPerdus[i].getId());
                System.out.println(MOTS_CLES + objetsPerdus[i].obtenirMotsCles());
                System.out.println(CAT + ObjetPerdu.CATEGORIES[objetsPerdus[i].getCategorie()]);
                System.out.println(DATE + objetsPerdus[i].getDate());
                System.out.println(LOCALISATION + objetsPerdus[i].getLocalisation());
                System.out.println();
            }
            i++;
        }

        if(!status) {
            System.out.println(MSG_AUCUN_OBJET);
        }


        System.out.println(MSG_ENTREE);
        Clavier.lireFinLigne();
    }

    /**
     * Cette méthode permet de rechercher un objet perdu par date ou par période
     * Elle affiche les informations de chaque objet trouvé et affiche un message d'erreur si aucun objet
     * correspondant à la catégorie spécifiée n'est trouvé.
     * @param objetsPerdus le tableau d'objets perdus à parcourir pour effectuer la recherche
     */
    public static void option4(ObjetPerdu[] objetsPerdus) {
        int jour;
        int mois;
        int annee;
        int i = 0;
        char choix;
        boolean status = false;

        System.out.println(MSG_OPTION_4);
        do{
            choix = TP3Utils.validerCaractere(MSG_D_OU_P,MSG_ERR_PERIODE,D,P);
            choix = Character.toUpperCase(choix);

            switch(choix){
                case 'D':
                    System.out.println(MSG_DATE);
                    jour = TP3Utils.validerTypeEntierStrictPositif(MSG_JOUR, MSG_ERR_DATE);
                    mois = TP3Utils.validerTypeEntierStrictPositif(MSG_MOIS, MSG_ERR_DATE);
                    annee = TP3Utils.validerTypeEntierStrictPositif(MSG_ANNEE, MSG_ERR_DATE);
                    Date date1 = new Date(jour, mois, annee);
                    //vallidation Date
                    while (date1.estDateValide() == false || (date1.estPlusPetite(Date.dateDuJour()) == false && date1.estEgale(Date.dateDuJour()) == false)){
                        System.out.println(MSG_DATE_INVALIDE);
                        System.out.println(MSG_DATE_CONSIGNE);
                        jour = TP3Utils.validerTypeEntierStrictPositif(MSG_JOUR, MSG_ERR_DATE);
                        mois = TP3Utils.validerTypeEntierStrictPositif(MSG_MOIS, MSG_ERR_DATE);
                        annee = TP3Utils.validerTypeEntierStrictPositif(MSG_ANNEE, MSG_ERR_DATE);
                        date1.setJour(jour);
                        date1.setMois(mois);
                        date1.setAnnee(annee);
                    }

                    while (i < ObjetPerdu.nbrElem){
                        if(objetsPerdus[i].getDate().estEgale(date1)){
                            status = true;
                            System.out.println(RESULTAT);
                            System.out.println(ID + objetsPerdus[i].getId());
                            System.out.println(MOTS_CLES + objetsPerdus[i].obtenirMotsCles());
                            System.out.println(CAT + ObjetPerdu.CATEGORIES[objetsPerdus[i].getCategorie()]);
                            System.out.println(DATE + objetsPerdus[i].getDate());
                            System.out.println(LOCALISATION + objetsPerdus[i].getLocalisation());
                            System.out.println();
                        }
                        i++;
                    }

                    if(!status) {
                        System.out.println(MSG_AUCUN_OBJET);
                    }

                    System.out.println(MSG_ENTREE);
                    Clavier.lireFinLigne();
                    break;

                case 'P':
                    System.out.println(MSG_DEBUT_PERIODE);
                    jour = TP3Utils.validerTypeEntierStrictPositif(MSG_JOUR, MSG_ERR_DATE);
                    mois = TP3Utils.validerTypeEntierStrictPositif(MSG_MOIS, MSG_ERR_DATE);
                    annee = TP3Utils.validerTypeEntierStrictPositif(MSG_ANNEE, MSG_ERR_DATE);
                    Date periode1 = new Date(jour, mois, annee);

                    while (periode1.estDateValide() == false || (periode1.estPlusPetite(Date.dateDuJour()) == false && periode1.estEgale(Date.dateDuJour()) == false)){
                        System.out.println(MSG_DATE_INVALIDE);
                        System.out.println(MSG_DATE_CONSIGNE);
                        jour = TP3Utils.validerTypeEntierStrictPositif(MSG_JOUR, MSG_ERR_DATE);
                        mois = TP3Utils.validerTypeEntierStrictPositif(MSG_MOIS, MSG_ERR_DATE);
                        annee = TP3Utils.validerTypeEntierStrictPositif(MSG_ANNEE, MSG_ERR_DATE);
                        periode1.setJour(jour);
                        periode1.setMois(mois);
                        periode1.setAnnee(annee);
                    }
                    System.out.println(MSG_FIN_PERIODE);
                    jour = TP3Utils.validerTypeEntierStrictPositif(MSG_JOUR, MSG_ERR_DATE);
                    mois = TP3Utils.validerTypeEntierStrictPositif(MSG_MOIS, MSG_ERR_DATE);
                    annee = TP3Utils.validerTypeEntierStrictPositif(MSG_ANNEE, MSG_ERR_DATE);
                    Date periode2 = new Date(jour, mois, annee);

                    while (periode2.estDateValide() == false || (periode2.estPlusPetite(Date.dateDuJour()) == false && periode2.estEgale(Date.dateDuJour()) == false)){
                        System.out.println(MSG_DATE_INVALIDE);
                        System.out.println(MSG_DATE_CONSIGNE);
                        jour = TP3Utils.validerTypeEntierStrictPositif(MSG_JOUR, MSG_ERR_DATE);
                        mois = TP3Utils.validerTypeEntierStrictPositif(MSG_MOIS, MSG_ERR_DATE);
                        annee = TP3Utils.validerTypeEntierStrictPositif(MSG_ANNEE, MSG_ERR_DATE);
                        periode2.setJour(jour);
                        periode2.setMois(mois);
                        periode2.setAnnee(annee);
                    }

                    if(periode2.estPlusPetite(periode1)){
                        System.out.println(MSG_AUCUN_OBJET);
                        System.out.println(MSG_ENTREE);
                        Clavier.lireFinLigne();

                    }else if(periode1.estEgale(periode2)){
                        i = 0;
                        while (i < ObjetPerdu.nbrElem){
                            if(objetsPerdus[i].getDate().estEgale(periode1)){
                                System.out.println(RESULTAT);
                                System.out.println(ID + objetsPerdus[i].getId());
                                System.out.println(MOTS_CLES + objetsPerdus[i].obtenirMotsCles());
                                System.out.println(CAT + ObjetPerdu.CATEGORIES[objetsPerdus[i].getCategorie()]);
                                System.out.println(DATE + objetsPerdus[i].getDate());
                                System.out.println(LOCALISATION + objetsPerdus[i].getLocalisation());
                                System.out.println();
                            }
                            i++;
                        }
                        System.out.println(MSG_ENTREE);
                        Clavier.lireFinLigne();
                    }else {
                        ObjetPerdu[] tab = TP3Utils.ordonnerObjetsPerdusParDate(objetsPerdus);
                        i = 0;
                        status = false;
                        while (i < ObjetPerdu.nbrElem) {
                            if (tab[i].getDate().estEgale(periode1) || tab[i].getDate().estEgale(periode2) || (tab[i].getDate().estPlusPetite(periode2) && !tab[i].getDate().estPlusPetite(periode1))) {
                                status = true;
                                System.out.println(RESULTAT);
                                System.out.println(ID + tab[i].getId());
                                System.out.println(MOTS_CLES + tab[i].obtenirMotsCles());
                                System.out.println(CAT + ObjetPerdu.CATEGORIES[tab[i].getCategorie()]);
                                System.out.println(DATE + tab[i].getDate());
                                System.out.println(LOCALISATION + tab[i].getLocalisation());
                                System.out.println();
                            }
                            i++;
                        }
                    }
                    if(!status) {
                        System.out.println(MSG_AUCUN_OBJET);
                    }

                    System.out.println(MSG_ENTREE);
                    Clavier.lireFinLigne();
                    break;

                default:
                    System.out.println(MSG_ERR_PERIODE);
            }

        } while(choix != 'D');

    }

    /**
     *  Cette méthode permet de rechercher un objet perdu par catégorie.
     * Elle affiche les informations de chaque objet trouvé et affiche un message d'erreur si aucun objet
     * correspondant à la catégorie spécifiée n'est trouvé.
     * @param objetsPerdus le tableau d'objets perdus à parcourir pour effectuer la recherche
     */
    public static void option5(ObjetPerdu[] objetsPerdus) {
        String choix;
        int categorie = 0;
        int i = 0;
        boolean status = false;

        System.out.println(MSG_OPTION_5);

        do {
            System.out.println(MENU_CAT);
            choix = Clavier.lireString();

            switch (choix) {
                case "1":
                    categorie = ObjetPerdu.CAT_BIJOU ;
                    break;

                case "2":
                    categorie = ObjetPerdu.CAT_VETEMENT;
                    break;

                case "3":
                    categorie = ObjetPerdu.CAT_ARGENT_PORTEFEUILLE;
                    break;

                case "4":
                    categorie = ObjetPerdu.CAT_CLE;
                    break;

                case "5":
                    categorie = ObjetPerdu.CAT_AUTRE;
                    break;

                default:
                    System.out.println(MSG_ERR_CAT);
            }

        }while(!choix.equals("1") && !choix.equals("2") && !choix.equals("3") && !choix.equals("4") && !choix.equals("5"));

        System.out.println(RESULTAT);

        while(i < ObjetPerdu.nbrElem) {
            if(objetsPerdus[i].getCategorie() == categorie) {
                status = true;
                System.out.println(ID + objetsPerdus[i].getId());
                System.out.println(MOTS_CLES + objetsPerdus[i].obtenirMotsCles());
                System.out.println(CAT + ObjetPerdu.CATEGORIES[objetsPerdus[i].getCategorie()]);
                System.out.println(DATE + objetsPerdus[i].getDate());
                System.out.println(LOCALISATION + objetsPerdus[i].getLocalisation());
                System.out.println();
            }
            i++;
        }

        if(!status) {
            System.out.println(MSG_AUCUN_OBJET);
        }
    }

    /**
     * Affiche tous les objets perdus consignés (se trouvant dans le tableau
     *objetsPerdus), ordonnés (ordre croissant) par id.
     *  @param objetsPerdus le tableau d'objets perdus à afficher
     */
    public static void option6(ObjetPerdu[] objetsPerdus) {
        int i = 0;
        System.out.println(MSG_OPTION_6);

        ObjetPerdu[] tab = TP3Utils.ordonnerObjetsPerdusParId(objetsPerdus);
        while (i < ObjetPerdu.nbrElem) {
            System.out.println(ID + tab[i].getId());
            System.out.println(MOTS_CLES + tab[i].obtenirMotsCles());
            System.out.println(CAT + ObjetPerdu.CATEGORIES[tab[i].getCategorie()]);
            System.out.println(DATE + tab[i].getDate());
            System.out.println(LOCALISATION + tab[i].getLocalisation());
            System.out.println();
            i++;
        }
        if (objetsPerdus == null) {
            System.out.println(MSG_AUCUN_CONSIGNE);
        }
        System.out.println(MSG_ENTREE);
        Clavier.lireFinLigne();
    }

    public static void main(String[] args) {
        //declaration variable
        char choixMenu;
        char choixCat;
        ObjetPerdu objet;
        String motsCle, localisation;
        int categorie = 0;
        String motsCles[];
        boolean status;
        int jour = 0, mois, annee;
        ObjetPerdu[] objetsPerdus = TP3Utils.recupererDonnees();

        //Presentation du logiciel
        System.out.println(PRESENTATION);

        do {
            //afficher menu
            System.out.print(MENU);
            System.out.print(MSG_CHOIX);
            choixMenu = Clavier.lireCharLn();

            //TRAITEMENT OPTION CRYPTAGE

            switch (choixMenu) {
                case '1':
                    objetsPerdus = option1(objetsPerdus);
                    break;

                case '2':
                    if(ObjetPerdu.getSequenceId() > 0)
                        objetsPerdus = option2(objetsPerdus);
                    else
                        System.out.println(MSG_AUCUN_CONSIGNE);

                    break;

                case '3':
                    if(ObjetPerdu.sequenceId > 0)
                        option3(objetsPerdus);
                    else
                        System.out.println(MSG_AUCUN_OBJET);
                    break;

                case '4':
                    if(ObjetPerdu.getSequenceId() > 0)
                        option4(objetsPerdus);
                    else
                        System.out.println(MSG_AUCUN_OBJET);
                    break;

                case '5':
                    option5(objetsPerdus);
                    break;

                case '6':
                    option6(objetsPerdus);
                    break;

                case '7':
                    TP3Utils.sauvegarder(objetsPerdus);
                    System.out.println(MSG_FIN);
                    break;

                default:
                    System.out.println(MSG_ERR_MENU);

            }

        } while (choixMenu != '7');

    }

}