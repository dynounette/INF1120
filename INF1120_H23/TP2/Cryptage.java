/**
 * Ce logiciel permet de crypter et de decrypter des messages secrets.
 * @author HIDE
 * Code Permanent: HIDE
 * Cours : INF1120
 * @version 26/03/2023
 */



public class Cryptage {

    //declaration des constantes
    public static final String MSG_ERR_MENU = "ERREUR, choix de menu invalide ! Recommencez...";
    public static final String MSG_FIN = "\n\nAUREVOIR !";
    public static final String PRESENTATION = "\nCe logiciel permet de crypter et de decrypter des messages secrets.\n";
    public static final String MENU_PRINCIPAL = "----\nMENU\n----\n"
            + "1. Crypter un message\n"
            + "2. Decrypter un message\n"
            + "3. Quitter"
            + "\n\nEntrez votre choix : ";
    public static final String CRYPTAGE = "\n++++++++++++\n+ CRYPTAGE +\n++++++++++++";
    public static final String DECRYPTAGE = "\n++++++++++++++\n+ DECRYPTAGE +\n++++++++++++++";
    public static final char MIN = '0', MAX = '9', ROTATION = 'R', PERMUTATION = 'P', INVERSION = 'I', INVERSION1 = 'V',
            DROITE = 'D', GAUCHE = 'G', INTERIEURE = 'I', EXTERIEURE = 'E';
    public static final String MSG_CLE = "CLE DE CRYPTAGE : ";
    public static final String MSG_ERR_CLE = "ERREUR, cle invalide ! Recommencez...";
    public static final String MSG_CRYPTAGE = "MESSAGE A CRYPTER (ENTREE pour annuler) : ";
    public static final String MSG_DECRYPTAGE = "\nMESSAGE A DECRYPTER (ENTREE pour annuler) : ";
    public static final String MSG_ERR_MESSAGE = "\nERREUR, message invalide : \nLe message ne peut contenir que des lettres"
            + ", des chiffres, des\n" + "\tespaces, et les caracteres .!?,;:'-\"";
    public static final String MSG_CRYPTE = "\nMESSAGE CRYPTE : ";
    public static final String MSG_DECRYPTE = "\nMESSAGE DECRYPTE : ";
    public static final String MSG_ANNULEE = "--> OPERATION ANNULEE <--";
    public static final String MSG_ENTREE = "Tappez <ENTREE> pour continuer...";

    /**
     * Échange deux caractères dans une chaîne de caractères.
     *
     * @param chaine la chaîne de caractères dans laquelle effectuer l'échange
     * @param i l'indice du premier caractère à échanger
     * @param j l'indice du deuxième caractère à échanger
     * @return une nouvelle chaîne de caractères avec les caractères aux indices spécifiés échangés
     */
    public static String echanger(String chaine, int i, int j) {
        if (j == chaine.length() - 1)
            return chaine.substring(0, i) + chaine.charAt(j) +
                    chaine.substring(i + 1, j) + chaine.charAt(i);


        return chaine.substring(0, i) + chaine.charAt(j) +
                chaine.substring(i + 1, j) + chaine.charAt(i) +
                chaine.substring(j + 1);
    }

    public static String rotationGauche(String message, String rotations) {
        // total est le nombre de rotations
        int total = Integer.parseInt(rotations);//permet de convertir une chaine de caractères en nombre entier (int)

        for (int i = 0; i < total; i++) {

            for (int j = 0; j < message.length() - 1; j++) {
                if (j == 0)
                    message = echanger(message, j, message.length() - 1);
                else
                    message = echanger(message, j - 1, j);
            }

        }

        return message;
    }


    /**
     * Effectue une rotation droite sur une chaîne de caractères.
     *
     * @param message   La chaîne à modifier.
     * @param rotations Nombre de rotations.
     * @return La chaîne modifiée.
     */

    public static String rotationDroite(String message, String rotations) {
        // total est le nombre de rotations
        int total = Integer.parseInt(rotations); //permet de convertir une chaine de caractères en nombre entier (int)

        for (int i = 0; i < total; i++) {
            for (int j = 0; j < message.length() - 1; j++)
                message = echanger(message, j, message.length() - 1);

        }
        return message;
    }

    /**
     * Permutation des caractères de la chaine, de l’intérieure vers l’exterieure.
     *
     * @param message   La chaîne à modifier.
     * @param rotations Nombre de permutation à réaliser.
     * @return La chaîne modifiée.
     */
    public static String permutationInterieure(String message, String rotations) {
        // total est le nombre de rotations
        int total = Integer.parseInt(rotations);//permet de convertir une chaine de caractères en nombre entier (int)
        int j;
        int i;

        if (message.length() < 2)
            return message;

        else {
            if (message.length() % 2 == 0) {
                i = ((message.length()) / 2) - 1;
                j = i + 1;
            } else {
                i = message.length() / 2;
                j = i;
                i--;
                j++;
            }

            for (int c = 0; c < total; c++, j++, i--) {
                if (j == message.length()) {
                    if (message.length() % 2 == 0) {
                        j = (message.length()) / 2;
                        i = j - 1;
                    } else {
                        i = message.length() / 2;
                        j = i;
                        i--;
                        j++;
                    }

                }

                message = echanger(message, i, j);

            }
        }

        return message;
    }

    /**
     * Permutation des caractères de la chaine, de l’exterieure vers l’interieure.
     *
     * @param message   La chaîne à modifier.
     * @param rotations Nombre de permutation à réaliser.
     * @return La chaîne modifiée.
     */
    public static String permutationExterieure(String message, String rotations) {
        // total est le nombre de rotations
        int total = Integer.parseInt(rotations);//permet de convertir une chaine de caractères en nombre entier (int)

        if (message.length() < 2)
            return message;

        else {
            for (int i = 0, j = message.length() - 1, l = 0; i < total; i++) {
                message = echanger(message, l, j);
                l++;
                j--;

                // Si les indices se croisent, les compteurs se réinitialise pour recommencer la permutation externe
                if (l == message.length() / 2) {
                    l = 0;
                    j = message.length() - 1;
                }

            }
        }

        return message;
    }

    /**
     * Inversion d'un nombre donné 'n' de caractères en début de chaine, et en fin de chaine.
     *
     * @param message   La chaîne à modifier.
     * @param rotations Nombre d'inversion à réaliser.
     * @return La chaîne modifiée.
     */
    public static String inversion(String message, String rotations) {
        // total est le nombre de rotations
        int total = Integer.parseInt(rotations);//permet de convertir une chaine de caractères en nombre entier (int)
        String chaine1;
        String chaine2;
        String chaine3;
        String Output = "";

        if (total >= message.length() || total == 1) { // Si le nombre de caractères à inverser est supérieur à la longueur
            // de la chaîne ou égal à 1, on retourne la chaîne telle quelle
            return message;

        } else {
            chaine1 = message.substring(0, total);

            for (int i = chaine1.length() - 1; i >= 0; i--)
                Output += chaine1.charAt(i);


            if (total <= message.length() / 2) {
                chaine2 = message.substring(total, message.length() - total);
                Output += chaine2;

                chaine3 = message.substring(message.length() - total);

                for (int i = chaine3.length() - 1; i >= 0; i--)
                    Output += chaine3.charAt(i);

            } else {
                chaine2 = Output + message.substring(total);

                chaine3 = chaine2.substring(message.length() - total, message.length());

                Output = Output.substring(0, message.length() - total);

                for (int i = chaine3.length() - 1; i >= 0; i--)
                    Output += chaine3.charAt(i);


            }

        }

        return Output;
    }

    /**
     * Validation de la cle de cryptage.
     *
     * @param cle string à valider
     * @return true si la cle est valide sinon false
     */
    public static boolean validationCle(String cle) {
        int i = 0;


        if (cle.length() < 4 || cle.length() % 4 != 0) {
            return false;
        } else {
            while (i < cle.length()) {
                if ((cle.charAt(i) == ROTATION && cle.charAt(i + 1) == GAUCHE) ||
                        (cle.charAt(i) == ROTATION && cle.charAt(i + 1) == DROITE) ||
                        (cle.charAt(i) == PERMUTATION && cle.charAt(i + 1) == INTERIEURE) ||
                        (cle.charAt(i) == PERMUTATION && cle.charAt(i + 1) == EXTERIEURE) ||
                        (cle.charAt(i) == INVERSION && cle.charAt(i + 1) == INVERSION1)) {
                    i += 2;
                } else if (cle.charAt(i) >= MIN && cle.charAt(i) <= MAX &&
                        cle.charAt(i + 1) >= MIN && cle.charAt(i + 1) <= MAX) {
                    i += 2;
                } else {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * Validation du message.
     *
     * @param message est le string à valider
     * @return true si le message est valide sinon false
     */

    public static boolean validationMessage(String message) {
        boolean status = true;
        int i;

        for (i = 0; i < message.length(); i++) {
            if (!((message.charAt(i) >= 'a' && message.charAt(i) <= 'z') || (message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') ||
                    (message.charAt(i) >= MIN && message.charAt(i) <= MAX) || message.charAt(i) == '.' || message.charAt(i) == ';' ||
                    message.charAt(i) == '!' || message.charAt(i) == '?' || message.charAt(i) == ',' || message.charAt(i) == ':' ||
                    message.charAt(i) == '-' || message.charAt(i) == 39 || message.charAt(i) == '"' || message.charAt(i) == ' ' ) ||
                    message.charAt(i) == '\n') {
                status = false;
            }

        }

        return status;
    }


    /**
     * Crypte le msg donne avec la cle de cryptage donnee, et retourne
     * le message crypte.
     *
     * ANTECEDENT : la cle et le message doivent etre valides.
     *
     * @param cle la cle de cryptage
     * @param msg le message a crypter avec la cle donnee
     * @return le message crypte
     */
    public static String crypter(String cle, String msg) {
        int i = 0;
        boolean status = false;

        System.out.println(CRYPTAGE);

        while (!status) {
            System.out.print("\n" + MSG_CLE);
            cle = Clavier.lireString();
            cle = cle.toUpperCase();

            status = validationCle(cle);

            if (!status) {
                System.out.println("\n" + MSG_ERR_CLE);
            }

        }

        status = false;

        while (!status) {
            System.out.print(MSG_CRYPTAGE);
            msg = Clavier.lireString();

            status = validationMessage(msg);

            if (msg == "") {
                System.out.println("\n" + MSG_ANNULEE + "\n");

            }else if (!status) {
                System.out.println("\n" + MSG_ERR_MESSAGE);
            }

        }

        while (i < cle.length() - 1) {
            String nbr = cle.substring(i + 2, i + 4);
            if (cle.charAt(i) == ROTATION && cle.charAt(i + 1) == GAUCHE) {
                msg = rotationGauche(msg, nbr);
            } else if (cle.charAt(i) == ROTATION && cle.charAt(i + 1) == DROITE) {
                msg = rotationDroite(msg, nbr);
            } else if (cle.charAt(i) == PERMUTATION && cle.charAt(i + 1) == INTERIEURE) {
                msg = permutationInterieure(msg, nbr);
            } else if (cle.charAt(i) == PERMUTATION && cle.charAt(i + 1) == EXTERIEURE) {
                msg = permutationExterieure(msg, nbr);
            } else if (cle.charAt(i) == INVERSION && cle.charAt(i + 1) == INVERSION1) {
                msg = inversion(msg, nbr);
            }

            i = i + 4;
        }
        return msg;
    }

    /**
     * Decrypte le msg donne avec la cle de cryptage donnee, et retourne
     * le message decrypte.
     *
     * ANTECEDENT : la cle et le msg doivent etre valides.
     *
     * @param cle la cle de cryptage
     * @param msg le message a decripter avec la cle donnee
     * @return le message decrypte
     */
    public static String decrypter(String cle, String msg) {
        String Size;
        boolean status = false;
        int i ;

        System.out.println(DECRYPTAGE);

        while (!status) { // boucle de validation de la cle de cryptage
            System.out.print("\n" + MSG_CLE);
            cle = Clavier.lireString();
            cle = cle.toUpperCase();

            status = validationCle(cle);

            if (!status) {
                System.out.println(MSG_ERR_CLE);
            }

        }

        status = false;

        while (!status) {
            System.out.print(MSG_CRYPTAGE);
            msg = Clavier.lireString();

            status = validationMessage(msg);

            if (!status) {
                System.out.println("\n" + MSG_ERR_MESSAGE);
            }

        }

        if (msg == "") {
            System.out.println(MSG_ANNULEE);

        }else { // opérations de décryptage avec la cle donnee sur le message
            i = cle.length()-4;
            while (i >= 0) {
                String nbr = cle.substring(i + 2, i + 4);
                if (cle.charAt(i) == PERMUTATION && cle.charAt(i + 1) == INTERIEURE) {
                    msg = permutationInterieure(msg, nbr);
                } else if (cle.charAt(i) == INVERSION && cle.charAt(i + 1) == INVERSION1) {
                    Size = msg.length() / 2 + "";
                    msg = permutationExterieure(msg, Size);
                    msg = inversion(msg, nbr);
                    msg = permutationExterieure(msg, Size);
                } else if (cle.charAt(i) == PERMUTATION && cle.charAt(i + 1) == EXTERIEURE) {
                    msg = permutationExterieure(msg, nbr);
                } else if (cle.charAt(i) == ROTATION && cle.charAt(i + 1) == DROITE) {
                    msg = rotationGauche(msg, nbr);
                } else if (cle.charAt(i) == ROTATION && cle.charAt(i + 1) == GAUCHE) {
                    msg = rotationDroite(msg, nbr);
                }

                i = i - 4;
            }

        }

        return msg;

    }


    public static void main(String[] args) {

        //declaration variable
        char choixMenu;
        String message = "";
        String cle = "";

        //Presentation du logiciel
        System.out.println(PRESENTATION);
        System.out.println(MSG_ENTREE);
        Clavier.lireFinLigne();

        do {
            //afficher menu
            System.out.print(MENU_PRINCIPAL);
            choixMenu = Clavier.lireCharLn();

            //TRAITEMENT OPTION CRYPTAGE

            switch (choixMenu) {
                case '1':
                    message = crypter(cle, message);
                    if (message != "") {
                        System.out.println("\n" + MSG_CRYPTE + "[" + message + "]\n");
                        System.out.println(MSG_ENTREE+"\n");
                    }
                    break;
                //TRAITEMENT OPTION DECRYPTAGE
                case '2':
                    message = decrypter(cle, message);
                    if (message != "") {
                        System.out.println("\n" + MSG_DECRYPTE + "[" + message + "]\n");
                        System.out.println(MSG_ENTREE+"\n");
                        Clavier.lireFinLigne();
                    }
                    break;

                default:
                    System.out.println(MSG_ERR_MENU);

            }

        } while (choixMenu != '3');

    }
}

