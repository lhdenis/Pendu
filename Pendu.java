import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class Pendu{

    public static void main(String[] args){
        System.out.println("***JEU DU PENDU***");
        System.out.println("");

        Random random = new Random();
        int n = random.nextInt(10) + 4;
        generateWord();
    }

    public static String generateWord(){
        String url = "jdbc:sqlite:words.db";
        String sql = "SELECT mot FROM mots ORDER BY RANDOM() LIMIT 1";
         
        try {
            Connection co = DriverManager.getConnection(url);
            Statement stmt = co.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            if (result.next()) {
                System.out.println("Mot à deviner : " + result.getString("mot"));
            } else {
                System.out.println("Aucun mot trouvé !");
            }
            co.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    // public static void pendu(int n){
    //     System.out.println("Il faut trouver le mot suivant en " + n + " lettres");

    //     /* génération d'un mot aléatoire de n lettre */
    //     String word = "...";

    //     System.out.println("Entrez une lettre");
    //     Scanner scanner = new Scanner(System.in);
    //     char input = scanner.nextLine().trim();
    // }


}

/*
 * # Créer la base SQLite et la table
sqlite3 words.db "CREATE TABLE IF NOT EXISTS mots (id INTEGER PRIMARY KEY AUTOINCREMENT, mot TEXT NOT NULL);"

# Insérer les mots depuis words.txt
Get-Content words.txt | ForEach-Object { sqlite3 words.db "INSERT INTO mots (mot) VALUES ('$_');" }

 */

