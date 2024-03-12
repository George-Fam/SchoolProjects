/**
 * La classe Budget représente un simple bilan financier mensuel.
 *
 * @author George Fam
 * Code permanent : FAMG76050000
 * Courriel : george.fam@courrier.uqam.ca
 * Cours : INF1120-20
 * @version 2024-02-20
 */
public class Budget {
    //Constantes : Presentation
    public static final String MSG_PRESENTATION = "Ce logiciel permet la " +
            "tenue d'un bilan financier mensuel.";
    public static final String MSG_PAUSE = "Appuyez sur <ENTREE> pour " +
            "continuer...";
    public static final String MSG_REINITIALISATION = "LE BUDGET A ETE" +
            " REINITIALISE.\n";
    public static final String MSG_FIN = "\nAUREVOIR !";

    //Constantes : messages solicitation
    public static final String MSG_SOL_MOIS = "Entrez le mois du budget: " ;
    public static final String MSG_SOL_ANNEE = "Entre l'annee du budget: ";
    public static final String MSG_SOL_MENU = "Entrez votre choix : ";
    public static final String MSG_SOL_REVENU = "Entrez le montant du revenu" +
            " (0 pour terminer) : ";
    public static final String MSG_SOL_DEPENSE = "Entrez le montant de la" +
            " depense (0 pour terminer) : ";

    //Constantes : messages erreur
    public static final String MSG_ERR_MOIS = "\nMois invalide. Saisir une " +
            "valeur entre 1 et 12... Recommencez !";
    public static final String MSG_ERR_ANNEE = "\nAnnee invalide. Saisir une " +
            "valeur entre 2024 et 9999... Recommencez !";
    public static final String MSG_ERR_CHOIX = "\nMenu invalide. Saisir une" +
            " valeur entre 1 et 5... Recommencez !";
    public static final String MSG_ERR_MONTANT = "\nMontant invalide. Saisir " +
            "une valeur superieure ou egale a 0... Recommencez !";

    //Constantes Menu et Tables
    public static final String MSG_MENU_BUDGET = "BUDGET - ";
    public static final String MSG_MENU_TIRET = "---------------------------" +
            "-----------------------";
    public static final String MSG_MENU_TIRET_COURT = "---------------------" +
            "--";
    public static final String MSG_MENU = "1. Entrer des revenus\n2. Entrer" +
            " des depenses\n3. Afficher le bilan\n" +
            "4. Reinitialiser le budget\n5. Quitter\n";
    public static final String MSG_DEP_POURC1 = "\nVous avez depense ";
    public static final String MSG_DEP_POURC2 = " de votre revenu total.";
    public static final String MSG_DEFICIT = "\n*** ATTENTION ***\nVous avez" +
            " un deficit de ";

    //Constantes MOIS (nom)
    public static final String MSG_MENU_MOIS_1 = "JANVIER";
    public static final String MSG_MENU_MOIS_2 = "FEVRIER";
    public static final String MSG_MENU_MOIS_3 = "MARS";
    public static final String MSG_MENU_MOIS_4 = "AVRIL";
    public static final String MSG_MENU_MOIS_5 = "MAI";
    public static final String MSG_MENU_MOIS_6 = "JUIN";
    public static final String MSG_MENU_MOIS_7 = "JUILLET";
    public static final String MSG_MENU_MOIS_8 = "AOUT";
    public static final String MSG_MENU_MOIS_9 = "SEPTEMBRE";
    public static final String MSG_MENU_MOIS_10 = "OCTOBRE";
    public static final String MSG_MENU_MOIS_11 = "NOVEMBRE";
    public static final String MSG_MENU_MOIS_12 = "DECEMBRE";

    //Constantes MOIS (nombre)
    public static final int MOIS_1 = 1;
    public static final int MOIS_2 = 2;
    public static final int MOIS_3 = 3;
    public static final int MOIS_4 = 4;
    public static final int MOIS_5 = 5;
    public static final int MOIS_6 = 6;
    public static final int MOIS_7 = 7;
    public static final int MOIS_8 = 8;
    public static final int MOIS_9 = 9;
    public static final int MOIS_10 = 10;
    public static final int MOIS_11 = 11;
    public static final int MOIS_12 = 12;

    //Constantes : Choix Menu
    public static final char CHOIX_MENU_1 = '1';
    public static final char CHOIX_MENU_2 = '2';
    public static final char CHOIX_MENU_3 = '3';
    public static final char CHOIX_MENU_4 = '4';

    //Constantes : limites (max, min)
    public static final int MOIS_MIN = 1;
    public static final int MOIS_MAX = 12;
    public static final int ANNEE_MIN = 2024;
    public static final int ANNEE_MAX = 9999;
    public static final char CHOIX_MENU_MIN = '1';
    public static final char CHOIX_MENU_MAX = '5';

    /**
     * Methode main qui permet à l'utilisateur de saisir les revenus
     * et dépenses mensuels, puis affiche un tableau comprenant les revenus
     * totaux, les dépenses totales, et le solde. L'utilisateur peut également
     * réinitialiser le budget pour un nouveau mois.
     *
     * @param args
     */
    public static void main(String[] args){
        //Declaration de variables
        int moisSaisi;
        int anneeSaisi;
        float revenuSaisi;
        float depenseSaisi;
        char choixMenu;
        float solde;

        //Initial. nulle pour eviter erreur de compilation (+=, etc) et/ou
        //avoir resultats de 0 sans entrée d'utilisateur
        String moisMenu="";
        float revenuTotal = 0f;
        float depenseTotal = 0f;
        float depensePourcentage = 0f;

        //Affichage message presentation et pause
        System.out.println(MSG_PRESENTATION);
        System.out.println("\n" + MSG_PAUSE);
        Clavier.lireFinLigne();

        //Entree au clavier du mois et boucle de validation (1-12)
        do {
            System.out.print(MSG_SOL_MOIS);
            moisSaisi = Clavier.lireInt();
            if(!(moisSaisi<=MOIS_MAX && moisSaisi>=MOIS_MIN)){
                System.out.println(MSG_ERR_MOIS);
            }
        }while(!(moisSaisi<=MOIS_MAX && moisSaisi>=MOIS_MIN));

        //Entree au clavier de l'annee et boucle de validation(2024-9999)
        do {
            System.out.print(MSG_SOL_ANNEE);
            anneeSaisi = Clavier.lireInt();
            if(!(anneeSaisi<=ANNEE_MAX && anneeSaisi>=ANNEE_MIN)){
                System.out.println(MSG_ERR_ANNEE);
            }
        }while(!(anneeSaisi<=ANNEE_MAX && anneeSaisi>=ANNEE_MIN));

        //Nom du mois Saisi à partir du mois saisi(chiffre)
        switch (moisSaisi){
            case MOIS_1:
                moisMenu = MSG_MENU_MOIS_1;
                break;
            case MOIS_2:
                moisMenu = MSG_MENU_MOIS_2;
                break;
            case MOIS_3:
                moisMenu = MSG_MENU_MOIS_3;
                break;
            case MOIS_4:
                moisMenu = MSG_MENU_MOIS_4;
                break;
            case MOIS_5:
                moisMenu = MSG_MENU_MOIS_5;
                break;
            case MOIS_6:
                moisMenu = MSG_MENU_MOIS_6;
                break;
            case MOIS_7:
                moisMenu = MSG_MENU_MOIS_7;
                break;
            case MOIS_8:
                moisMenu = MSG_MENU_MOIS_8;
                break;
            case MOIS_9:
                moisMenu = MSG_MENU_MOIS_9;
                break;
            case MOIS_10:
                moisMenu = MSG_MENU_MOIS_10;
                break;
            case MOIS_11:
                moisMenu = MSG_MENU_MOIS_11;
                break;
            case MOIS_12:
                moisMenu = MSG_MENU_MOIS_12;
                break;
        }
        // Boucle Repetition du menu tant qu'option choisie n'est pas 5
        do{
            //Affichage Menu
            System.out.println("\n" + MSG_MENU_TIRET_COURT);
            System.out.println(MSG_MENU_BUDGET + moisMenu + " " + anneeSaisi);
            System.out.println(MSG_MENU_TIRET_COURT);
            System.out.println(MSG_MENU);

            //Solic. choix menu+entree au clavier et boucle validation(1-5)
            do {
                System.out.print(MSG_SOL_MENU);
                choixMenu = Clavier.lireChar();
                Clavier.viderTampon();
                // vider tampon pour que valeur ne soit pas relu quand
                // boucle recommence.
                if(!(choixMenu<=CHOIX_MENU_MAX && choixMenu>=CHOIX_MENU_MIN)){
                    System.out.println(MSG_ERR_CHOIX);
                }
            }while(!(choixMenu<=CHOIX_MENU_MAX && choixMenu>=CHOIX_MENU_MIN));

            switch (choixMenu){
                case CHOIX_MENU_1: // Option 1 : Ajout de revenu
                    do{
                        System.out.print(MSG_SOL_REVENU);
                        revenuSaisi = Clavier.lireFloatLn();

                        if (revenuSaisi>=0){
                            revenuTotal+=revenuSaisi;
                        } else {
                            System.out.println(MSG_ERR_MONTANT);
                        }
                    } while(revenuSaisi!=0);
                    break;
                case CHOIX_MENU_2: // Option 2 : Ajout de depense
                    do{
                        System.out.print(MSG_SOL_DEPENSE);
                        depenseSaisi = Clavier.lireFloatLn();

                        if (depenseSaisi>=0){
                            depenseTotal+=depenseSaisi;
                        } else {
                            System.out.println(MSG_ERR_MONTANT);
                        }
                    } while(depenseSaisi!=0);
                    break;
                case CHOIX_MENU_3: // Option 3 : Affichage du bilan
                    solde = revenuTotal-depenseTotal;

                    //Resout erreur d'arrondissement float à -0 pour solde ≈ 0
                    if (-0.009 < solde && solde < 0.009){
                        solde = 0.0f;
                    }

                    System.out.println("\nBILLAN");
                    System.out.println(MSG_MENU_TIRET);
                    System.out.printf("%15s |%15s |%15s\n", "REVENUS",
                            "DEPENSES", "SOLDE");
                    System.out.println(MSG_MENU_TIRET);
                    System.out.printf("%13.2f $ |%13.2f $ |%13.2f $\n",
                            revenuTotal, depenseTotal, solde);
                    System.out.println(MSG_MENU_TIRET);

                    //Calcul de pourcentage de depense ou deficit
                    if(solde>=0){
                        //Evite division par 0 et depense pourcentage = NaN
                        if (revenuTotal != 0){
                            depensePourcentage=depenseTotal/revenuTotal*100;
                        }
                        System.out.printf("%s%.2f%%%s\n",MSG_DEP_POURC1,
                                depensePourcentage, MSG_DEP_POURC2);
                    } else{
                        System.out.printf("%s%.2f$\n", MSG_DEFICIT, -solde);
                    }

                    System.out.print(MSG_PAUSE);
                    Clavier.lireFinLigne();
                    break;
                //Option 4 : Reinitialisation du revenu et des depenses totales
                case CHOIX_MENU_4:
                    revenuTotal=0f;
                    depenseTotal=0f;
                    depensePourcentage=0f;
                    System.out.println(MSG_REINITIALISATION);
                    break;
            }
        }while(choixMenu!=CHOIX_MENU_MAX);

        System.out.println(MSG_FIN);    //Fin normale du programme
    }
}