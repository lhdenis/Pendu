import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Pendu{

    public static void main(String[] args){
        System.out.println("***JEU DU PENDU***");
        System.out.println("");

        int tries = 7;
        Random random = new Random();
        int n = random.nextInt(10) + 4;
        String word = generateWord(n);
        char[] letters = new char[n];
        java.util.Arrays.fill(letters, '_');
        Scanner scanner = new Scanner(System.in);
        HashMap<Character, Boolean> lettersHashMap = new HashMap<>();

        if(word == null){
            System.out.println("error");
        }
        
        for (char c = 'a'; c <= 'z'; c++) {
            lettersHashMap.put(c, false);
        }
        
        while(tries > 0)
        {
            System.out.println("Entrez une lettre :");
            char letter = scanner.next().charAt(0);
            lettersHashMap.put(letter, true);
            
            if (word.contains(String.valueOf(letter))) {
                System.out.println("Le mot contien bien la lettre " + letter + " !\n");
                for (int i = 0; i < n; i++) {
                    if(word.charAt(i) == letter){
                        letters[i] = letter;
                    }   
                }
            }
            else{
                System.out.println("Le mot ne contient pas la lettre " + letter + "\n");
                tries--;
            }
            if (String.valueOf(letters).equals(word)) {
                System.out.println("Bravo ! Vous avez trouvé le mot : " + word);
                break;
            }
            System.out.println("Il vous reste encore " + tries + " pour trouver le mot caché : " + String.valueOf(letters));
        }

        System.out.println("\n GAME OVER ! Le mot était : " + word);
        scanner.close();
    }

    public static String generateWord(int n){
        String url = "jdbc:sqlite:words.db";
        String sql = "SELECT mot FROM mots WHERE LENGTH(mot) = " + n + " ORDER BY RANDOM() LIMIT 1";
         
        try {
            Connection co = DriverManager.getConnection(url);
            Statement stmt = co.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            if (result.next()) {
                System.out.println("Vous avez 7 tentatives pour trouver un mot de taille " + n);
                return result.getString("mot");
            } else {
                System.out.println("Aucun mot trouvé !");
            }
            co.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}

/*
 * # Créer la base SQLite et la table
sqlite3 words.db "CREATE TABLE IF NOT EXISTS mots (id INTEGER PRIMARY KEY AUTOINCREMENT, mot TEXT NOT NULL);"

# Insérer les mots depuis words.txt
Get-Content words.txt | ForEach-Object { sqlite3 words.db "INSERT INTO mots (mot) VALUES ('$_');" }

 */

