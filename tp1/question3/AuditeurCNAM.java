package question3;

/**
 * NFP121 TpIntroduction, usage de BlueJ et du "Submitter".
 * 
 * @version septembre 2009
 * @author � compl�ter
 * @see java.lang.String, java.lang.Math
 */
public class AuditeurCNAM {
    /** l'attribut nom de chaque auditeur. */
    private String nom;
    /** l'attribut prenom de chaque auditeur. */
    private String prenom;
    /** l'attribut matricule de chaque auditeur. */
    private String matricule;

    /**
     * "Cr�ation", le constructeur d'un auditeur avec son nom, son pr�nom et son
     * matricule.
     * 
     * @param nom
     *            le nom de l'auditeur
     * @param prenom
     *            son pr�nom
     * @param matricule
     *            sur la carte d'inscription, pr�s de la photo
     */
    public AuditeurCNAM(String nom, String prenom, String matricule) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
    }

    /**
     * le login au Cnam : 6 premi�res lettres du nom suivies de la premi�re
     * lettre du pr�nom s�par�es de '_' . le login retourn� est en minuscules,
     * le trait d'union, ou sp�ciaux <i>(pour unix)</i> sont remplac�s par des
     * '_' pas de caract�res accentu�s pour le login voir les classes
     * pr�d�fines, java.lang.String : les m�thodes replaceAll, toLowerCase et
     * substring java.lang.Math : la m�thode min<br>
     * <b>BlueJ : Menu Aide</b>
     * 
     * @return le login du Cnam simplifi�, sans les adaptations dues aux
     *         homonymes...
     */
    public String login() {
        boolean conditionPourNom = this.nom != null && !this.nom.equals("");
        boolean conditionPourPrenom = this.prenom != null && !this.prenom.equals("");
        if(conditionPourNom && conditionPourPrenom){
            //Declare and affect String nomPrime
            String nomPrime = this.nom;
            //Crop the first 6 characters of this.nom (if exists) from 0 to 5 (6 exculuded)
            if(nomPrime.length() > 6){
                nomPrime = this.nom.substring(0,6);
            }
            //Transform to lower case the result
            nomPrime = nomPrime.toLowerCase();
            //nomPime length
            int nomPimeLen = nomPrime.length();
            //Search for each '-' or special character and replace it with '_'
            for(int i=0;i<nomPimeLen;i++) {
                System.out.println("index: "+i+" of "+(nomPrime.length()-1));
                //Getting char at index i
                char checkChar = nomPrime.charAt(i);
                //Check for accents
                if((checkChar+"").equals("�")) {
                    //replace accent with the letter
                    nomPrime = nomPrime.substring(0,i) + "e" + nomPrime.substring(i + 1);
                } else {
                    //Converting character to integer
                    int charToInt = (int) checkChar;
                    //Between a et z (lowercase)
                    boolean conditionCorrecte = charToInt >= 97 && charToInt <= 122;
                    //If this condition is not correct
                    if(!conditionCorrecte) {
                        //Replace this character by '_'
                        String tmp = nomPrime.substring(0,i) + "_";
                        //Check if this is the last character of the string
                        if(i < 5){
                            //If not add the rest of the string
                            tmp += nomPrime.substring(i + 1);
                        }
                        nomPrime = tmp;
                    }
                }
            }
            //Get the first character (character at position 0) of the string this.prenom
            char prenomPrim = this.prenom.toLowerCase().charAt(0);
            //Conver this char to int
            int prenomPrimCharToInt = (int) prenomPrim;
            //Between a et z (lowercase)
            boolean conditionPrenomPrimCorrecte = prenomPrimCharToInt >= 97 && prenomPrimCharToInt <= 122;
            //Check for any special character
            if(!conditionPrenomPrimCorrecte) {
                prenomPrim = '_';
            }
            //Build the result
            String res = nomPrime + "_" + prenomPrim;
            return res;
        } else {
            return "";
        }
    }

    /**
     * Lecture du nom de l'auditeur.
     * 
     * @return son nom
     */
    public String nom() {
        return this.nom;
    }

    /**
     * Lecture du pr�nom de l'auditeur.
     * 
     * @return son pr�nom
     */
    public String prenom() {
        return this.prenom;
    }

    /**
     * Lecture du matricule de l'auditeur.
     * 
     * @return son matricule
     */
    public String matricule() {
        return this.matricule;
    }

    /**
     * m�thode toString ( m�thode red�finie de la classe Object).
     * 
     * @return la concat�nation du nom, du pr�nom et du login, selon cette
     *         syntaxe
     *         <code>nom() + " " + prenom() +  " login : " + login()</code>
     */
    @Override
    public String toString() {
        return nom() + " " + prenom() + " login : " + login();
    }

}
