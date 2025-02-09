import sqlite3

# Connexion à SQLite (crée la base si elle n'existe pas)
conn = sqlite3.connect("words.db")
cursor = conn.cursor()

# Créer la table si elle n'existe pas
cursor.execute("CREATE TABLE IF NOT EXISTS mots (id INTEGER PRIMARY KEY AUTOINCREMENT, mot TEXT NOT NULL);")

# Lire le fichier et insérer les mots
with open("words.txt", "r", encoding="utf-8") as file:
    words = [line.strip() for line in file if line.strip()]  # Nettoie les lignes vides
    cursor.executemany("INSERT INTO mots (mot) VALUES (?);", [(word,) for word in words])

# Sauvegarde et fermeture
conn.commit()
conn.close()

print(f"✅ {len(words)} mots ont été insérés dans words.db !")
