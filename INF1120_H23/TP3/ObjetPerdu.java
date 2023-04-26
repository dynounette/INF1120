/**
 * Ce programme permet la consignation d’objets perdus dans le système, et la recherche de ces objets
 * perdus consignés (par mots clés, par dates, et par
 * catégorie) lorsqu’on vient les réclamer au comptoir.
 * @author HIDE
 * Code Permanent: HIDE
 * Cours : INF1120
 * @version 04/04/2023
 */

public class ObjetPerdu {
    //Variables de classe
    private static int sequenceld = 0;

    //Constantes de classe
    public static final int CAT_BIJOU = 0;
    public static final int CAT_VETEMENT = 1;
    public static final int CAT_ARGENT_PORTEFEUILLE = 2;
    public static final int CAT_CLE = 3;
    public static final int CAT_AUTRE = 4;
    public static final String [] CATEGORIES = {"bijou", "vetement", "argent / portefeuille", "cle(s)", "autre"};
    public static final String MENU_CAT = "CATEGORIES :\n" +
            "1. bijou\n" +
            "2. vetement\n" +
            "3. argent / portefeuille\n" +
            "4. cle(s)\n" +
            "5. autre\n";
    public static final String MSG_CAT = "Entrez le numero de la categorie : ";
    public static final String MSG_ERR_CAT = "ERREUR, entrez un numero entre 1 et 5! RECOMMENCEZ...";
    public static final String MSG_DATE_CONSIGNE = "Date de consignation :\n";
    public static final String MSG_JOUR = "Entrez le jour de la date : \n";
    public static final String MSG_MOIS = "Entrez le mois de la date : \n";
    public static final String MSG_ANNEE = "Entrez l'annee de la date : \n";
    public static final String MSG_ERR_DATE = "ERREUR, entrez un entier strictement positif! RECOMMENCEZ...";
    public static final String MSG_DATE_INVALIDE = "ERREUR, date invalide! RECOMMENCEZ...";
    public final static String MSG_LOCALISATION = "Entrez la localisation de l'objet perdu consigne : ";
    public final static String MSG_ERR_LOCALISATION = "ERREUR, la chaine doit contenir entre 5 et 50 caracteres! RECOMMENCEZ...";

    //Variables d'instance
    private int id; //Le numéro unique d’identification de cet objet perdu
    public String[] motsCles = new String[0]; //Un tableau non null contenant tous les mots clés associés à cet objet perdu
    private int categorie; //La catégorie associée à cet objet perdu
    private Date date; //La date de consignation de cet objet perdu
    private String localisation; //L’endroit où a été rangé cet objet perdu lors de sa consignation
    static int sequenceId = 0;
    public static int nbrElem = 0;

    String valeurNonSign = "-1";


    //-----------------------------
    //CONSTRUCTEURS
    //-----------------------------

    /**
     *  Constructeur qui initialise les attributs: categorie, date, localisation par les valeurs passés en paramère
     * @param categorie le nom de ce contact
     * ANTECEDANT: doit être une valeur entre 0 et CATEGORIES.length – 1 inclusivement
     * @param date le prenom de ce contact
     * @param localisation le telephone de ce contact
     */
    public ObjetPerdu(int categorie, Date date, String localisation) {
        if (categorie >= 0 && categorie <= CATEGORIES.length) {
            this.categorie = categorie;
        }
        this.date = date;
        this.localisation = localisation;
        sequenceId++;
        id = sequenceId;
        nbrElem++;

    }
    /**
     Cette méthode permet d'agrandir un tableau de chaînes de caractères en ajoutant un nombre
     spécifié de cases supplémentaires à la fin du tableau.
     @param tab le tableau de chaînes de caractères à agrandir
     @param nbrCasesDePlus le nombre de cases supplémentaires à ajouter au tableau
     @return le nouveau tableau de chaînes de caractères agrandi
     */
    public static String[] agrandirTableau(String[] tab, int nbrCasesDePlus) {
        //creer un nouveau tableau plus grand
        String [] tab2 = new String [tab.length + nbrCasesDePlus];

        //copier les éléments de tab dans tab2
        for (int i = 0 ; i < tab.length ; i++) {
            tab2[i] = tab[i];
        }
        return tab2;
    }

    /**
     Cette méthode permet de reduire la taille d'un tableau de chaînes de caractères en supprimant un nombre
     spécifié de cases supplémentaires à la fin du tableau.
     @param tab le tableau de chaînes de caractères à agrandir
     @param nbrCasesDeMoins le nombre de cases supplémentaires à ajouter au tableau
     @return le nouveau tableau de chaînes de caractères agrandi
     */
    public static String[] diminuerTableau(String[] tab, int nbrCasesDeMoins) {
        //creer un nouveau tableau plus petit
        String [] tab2 = new String [tab.length - nbrCasesDeMoins];
        int j = 0;
        //copier les éléments de tab dans tab2
        for (int i = 0; i < tab.length ; i++) {
            if(!(tab[i].equals(""))) {
                tab2[j] = tab[i];
                j++;
            }
        }
        return tab2;
    }

    //----------------
    //GETTERS
    //----------------

    /**
     * Permet d'obtenir le numero unique d'identification de cet objet perdu.
     * @return le numero unique d'identification de cet objet perdu
     */
    public int getId() {
        return id;
    }
    /**
     * Permet d'obtenir la categorie à cet objet perdu.
     * @return la categorie à cet objet perdu.
     */
    public int getCategorie() {
        return categorie;
    }
    /**
     * Permet d'obtenir la date de consignation de cet objet perdu
     * @return la date de consignation de cet objet perdu
     */
    public Date getDate() {
        return date;
    }
    /**
     * Permet d'obtenir l’endroit où l’on range l’objet perdu consigné .
     * @return l’endroit où l’on range l’objet perdu consigné
     */
    public String getLocalisation() {
        return localisation;
    }

    //----------------
    //SETTERS
    //----------------
    /**
     * Permet de modifier la categorie de cet objet perdu.
     * ANTECEDANT: categorie doit être une valeur entre 0 et CATEGORIES.length – 1 inclusivement
     * @param categorie nouvelle categorie.
     */
    public void setCategorie(int categorie) {
        if (categorie >= 0 && categorie <= CATEGORIES.length) {
            this.categorie = categorie;
        }
    }
    /**
     * Permet de modifier la date de consignation de cet objet perdu .
     * @param date la nouvelle date de consignation de cet objet perdu .
     */
    public void setDate(Date date) {
        this.date = date;
    }
    /**
     * Permet de modifier le nom de cet employe.
     * @param localisation nouveau nom pour cet employe.
     */
    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    /**
     * Methode qui permet d'obtenir une chaine de caractères contenant tous les mots clés associés à cet objet perdu (stockés dans
     * l’attribut motsCles)
     * Si le tableau motsCles est vide, la chaine retournée par cette méthode sera la chaine vide.
     * @return une chaine qui contient les mots cles dans l'ordre ou ila apparaissent dans le tableau motsCles
     */
    public String obtenirMotsCles() {
        String motsCle = "";

        if(motsCles.length != 0) {
            for(int i = 0 ; i < motsCles.length ; i++) {
                motsCle += motsCles[i] + " " ;
            }
        }

        return motsCle;
    }

    /**
     * Ajoute un mot-clé à l'objet perdu, s'il n'existe pas déjà dans sa liste de mots-clés.
     * @param motCle le mot-clé à ajouter à l'objet perdu
     * @return true si le mot-clé a été ajouté avec succès, false sinon
     */
    public boolean ajouterMotCle(String motCle) {
        boolean status = true;

        if(motCle != null && motCle != "") {
            for(int i = 0 ; i < motsCles.length - 1 ; i++) {
                if(motCle.equalsIgnoreCase(motsCles[i])) {
                    status = false;
                }
            }

            if(status) {
                motsCles = agrandirTableau(motsCles,1);
                motsCles[motsCles.length - 1] = motCle;
            }
        }
        else {
            status = false;
        }
        return status;
    }

    /**
     * cette methode permet de savoir si le mot clé dont on veut est associé à cet objet perdu.
     * @param motCle le mot clé dont on veut savoir s’il est associé à cet objet perdu
     * @return retourne true si le motCle donné en paramètre est présent (sans tenir compte de la casse) dans le
     * tableau motsCles de cet objet perdu, retourne false sinon.
     */
    public boolean estAssocieACeMotCle(String motCle) {

        for(int i = 0; i < motsCles.length; i++){
            if (motCle.equalsIgnoreCase(motsCles[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * cette methode permet de supprimer le motCle donné en paramètre du tableau motsCles de cet objet perdu
     * @param motCle le mot clé dont on veut retirer l’association à cet objet perdu
     * Si motCle n’est pas dans le tableau motsCles, cette méthode ne supprime rien, et le tableau motsCles demeure inchangé.
     * @return true si le motCle donné en paramètre a été retiré du tableau motsCles de cet objet perdu,
     * retourne false sinon
     */
    public boolean supprimerMotCle(String motCle) {

        for(int i = 0; i < motsCles.length ; i++) {
            if(motCle.equalsIgnoreCase(motsCles[i])) {
                motsCles[i] = "";
                motsCles = diminuerTableau(motsCles,1);
                return true;
            }
        }

        return false;
    }

    /**
     * Cette methode retourne une representation sous forme d'une chaine de caracteres de cet
     * objet perdu.
     *
     * ANTECEDENTS :
     *   - la categorie de cet objet perdu est valide (entre 0 et CATEGORIES.length - 1)
     *   - le tableau motsCles n'est pas null.
     *
     * @return une representation sous forme d'une chaine de caracteres de cet objet perdu.
     */
    public String toString() {
        String listeMotsCles = "";
        String desc = "ID           : " + id + "\n" + "MOTS CLES    : ";

        for (String motCle : motsCles) {
            listeMotsCles = listeMotsCles + motCle + ", ";
        }

        desc = desc + (!listeMotsCles.isEmpty()
                ? listeMotsCles.substring(0, listeMotsCles.length() - 2) : listeMotsCles);
        desc = desc + "\n";
        desc = desc + "CATEGORIE    : " + CATEGORIES[categorie] + "\n"
                + "DATE         : " + date + "\n"
                + "LOCALISATION : " + localisation;
        return desc;
    }

    /**
     * Methode qui permet d'obtenir la valeur de l'attribut sequenceId.
     * @return la valeur de l’attribut de classe sequenceId .
     */
    public static int getSequenceId(){

        return sequenceId;
    }

    /**
     * Cette methode permet de modifier la valeur de l'attribut de classe sequenceId  par la valeur donnée en paramètre.
     * @param valeur la  nouvelle valeur de sequenceId.
     */
    public static void setSequenceId( int valeur){
        sequenceId = valeur;
    }

}
