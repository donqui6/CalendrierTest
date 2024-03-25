package modele;
import java.util.Scanner;
public class Date implements Comparable <Date>{
    protected int chJour;
    protected int chMois;
    protected int chAnnee;

    /**
     * Constructeur de la classe Date pour une date spécifiée.
     *
     * @param parJour  Le jour de la date.
     * @param parMois  Le mois de la date.
     * @param parAnnee L'année de la date.
     */
    public Date(int parJour, int parMois, int parAnnee) {
        chJour = parJour;
        chMois = parMois;
        chAnnee = parAnnee;
    }

    /**
     * Constructeur de la classe Date pour une date avec seulement l'année spécifiée.
     *
     * @param parAnnee L'année de la date.
     */
    public Date(int parAnnee) {
        chJour = 1;
        chMois = 1;
        chAnnee = parAnnee;
    }

    /**
     * Méthode statique pour lire une date à partir de la console.
     *
     * @return Une nouvelle instance de Date basée sur les entrées de l'utilisateur.
     */
    public static Date lireDate() {
        Scanner scanner = new Scanner(System.in);
        int parJour = scanner.nextInt();
        int parMois = scanner.nextInt();
        int parAnnee = scanner.nextInt();
        return new Date(parJour, parMois, parAnnee);
    }

    /**
     * Vérifie si la date est valide.
     *
     * @return true si la date est valide, sinon false.
     */
    public boolean estValide() {
        return chAnnee > 1582 &&
                chMois >= 1 && chMois <= 12 &&
                chJour >= 1 && chJour <= dernierJourDuMois(chMois, chAnnee);
    }

    /**
     * Retourne le dernier jour du mois pour une année et un mois donnés.
     *
     * @param parMois  Le mois.
     * @param parAnnee L'année.
     * @return Le dernier jour du mois.
     */
    protected static int dernierJourDuMois(int parMois, int parAnnee) {
        switch (parMois) {
            case 2:
                return estBissextile(parAnnee) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    /**
     * Vérifie si une année est bissextile.
     *
     * @param parAnnee L'année à vérifier.
     * @return true si l'année est bissextile, sinon false.
     */
    public static boolean estBissextile(int parAnnee) {
        return (parAnnee % 4 == 0 && parAnnee % 100 != 0) || parAnnee % 400 == 0 && parAnnee >= 1582;
    }

    /**
     * Convertit la date en une représentation sous forme de chaîne.
     *
     * @return Une chaîne représentant la date au format "jour/mois/année".
     */
    public String toString() {
        return chJour + "/" + chMois + "/" + chAnnee;
    }

    /**
     * Compare la date actuelle avec une autre date.
     *
     * @param parDate La date à comparer.
     * @return Un entier négatif si la date actuelle est antérieure, positif si elle est postérieure, et 0 si elles sont égales.
     */
    public int compareTo(Date parDate) {
        if (chAnnee < parDate.chAnnee)
            return -100;
        if (chAnnee > parDate.chAnnee)
            return 100;
        if (chMois < parDate.chMois)
            return -12;
        if (chMois > parDate.chMois)
            return 12;
        if (chJour < parDate.chJour)
            return -7;
        if (chJour > parDate.chJour)
            return 7;
        return 0;
    }

    /**
     * Retourne la date du lendemain.
     *
     * @return Une nouvelle instance de Date représentant la date du lendemain.
     */
    public Date dateDuLendemain() {
        if (chJour < Date.dernierJourDuMois(chMois, chAnnee))
            return new Date(chJour + 1, chMois, chAnnee);
        if (chMois < 12)
            return new Date(1, chMois + 1, chAnnee);
        return new Date(1, 1, chAnnee + 1);
    }

    /**
     * Retourne la date de la veille.
     *
     * @return Une nouvelle instance de Date représentant la date de la veille.
     */
    public Date dateDeLaVeille() {
        if (chJour > 1)
            return new Date(chJour - 1, chMois, chAnnee);
        if (chMois > 1)
            return new Date(Date.dernierJourDuMois(chMois - 1, chAnnee), chMois - 1, chAnnee);
        return new Date(31, 12, chAnnee - 1);
    }

    /**
     * Obtient le jour de la date.
     *
     * @return Le jour de la date.
     */
    public int getChJour() {
        return chJour;
    }

    /**
     * Obtient le mois de la date.
     *
     * @return Le mois de la date.
     */
    public int getChMois() {
        return chMois;
    }

    /**
     * Obtient l'année de la date.
     *
     * @return L'année de la date.
     */
    public int getChAnnee() {
        return chAnnee;
    }

}