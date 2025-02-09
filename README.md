# **Projet : Jeu du Pendu avec SQLite et Java**

## **📌 Introduction**

Ce projet implémente un **jeu du Pendu** en Java, où les mots sont stockés dans une base **SQLite**. Le programme récupère un mot aléatoire depuis la base et permet à l'utilisateur de le deviner en entrant des lettres.

---

## ** Pré-requis**

### **📌 Outils nécessaires :**

- **Java (JDK 8+)** installé
- **SQLite** installé ([🔗 Télécharger SQLite](https://www.sqlite.org/download.html))
- **Driver JDBC SQLite** → [🔗 sqlite-jdbc](https://github.com/xerial/sqlite-jdbc/releases)
- **Un fichier "words.txt" contenant une liste de mots, un par ligne**

---

## \*\* Étape 1 : Nettoyer et préparer \*\*\`\`


📌 **Le fichier `words.txt` ne doit contenir que des mots, un par ligne.**
📌 **Assurez-vous qu'il ne contient pas de chiffres ou de caractères spéciaux.**

---

## ** Étape 2 : Créer la base SQLite et insérer les mots**

Un script **Python** transforme `words.txt` en base **SQLite**.

📌 **Ce script :**

- Crée la base `words.db`.
- Crée une table `words.sql`.
- Insère tous les mots de `words.txt`.

---

## ** Étape 3 : Vérifier la base SQLite**

Après l'importation, vérifiez le contenu avec :

```sh
sqlite3 words.db "SELECT * FROM mots LIMIT 10;"
```

Pour compter les mots :

```sh
sqlite3 words.db "SELECT COUNT(*) FROM mots;"
```

---

## ** Étape 4 : Utiliser SQLite en Java avec JDBC**

### Télécharger JBDC

📌 **Lien :** [🔗 sqlite-jdbc](https://github.com/xerial/sqlite-jdbc/releases)

Il faut placer le fichier **`sqlite-jbdc-3.49.0.0`**.

### **📌 Fichier ****\`\`**** :**

## ** Étape 5 : Compiler et exécuter**

### **📌 Compilation/Exécution :**

```sh
javac -cp ".;sqlite-jdbc-3.49.0.0.jar" Pendu.java
java -cp ".;sqlite-jdbc-3.49.0.0.jar" Pendu
```

---

