# Spring Boot Application - Gestion des Patients

## 📝 Description du projet
Cette application **Spring Boot** est une **application de gestion des patients**. Elle permet d'effectuer les opérations suivantes :
- **Ajouter un patient** via un formulaire.
- **Afficher la liste des patients** sous forme de tableau.
- **Supprimer un patient** de la base de données.

L'application utilise une **base de données H2** en mémoire pour stocker les données des patients, et **Thymeleaf** est utilisé pour le rendu des pages HTML.

---

## 🚀 Fonctionnalités
- **Ajout d'un patient** : Un formulaire est disponible pour ajouter de nouveaux patients.
- **Affichage de la liste des patients** : Les patients sont affichés sous forme de tableau.
- **Suppression d'un patient** : Chaque patient dispose d'une action "Supprimer" à côté de son nom.
- **Accès à la console H2** : Accès direct à la base de données via [http://localhost:8080/h2-console](http://localhost:8080/h2-console).

---

## ⚙️ Technologies utilisées
- **Java** (langage de programmation)
- **Spring Boot** (framework backend)
- **Thymeleaf** (moteur de templates HTML)
- **H2 Database** (base de données en mémoire)
- **Spring Data JPA** (pour la gestion des données)
- **Spring Boot DevTools** (pour le rechargement automatique de l'application)
- **Maven** (outil de gestion des dépendances)

---

## 📂 Structure du projet

hopital/
├── src/
│   ├── main/
│   │   ├── java/com/example/hopital/
│   │   │   ├── controllers/        # Les contrôleurs
│   │   │   ├── models/             # Les classes de modèle (entités JPA)
│   │   │   ├── repositories/       # Les interfaces de repository
│   │   │   └── services/           # Les services métiers
│   │   └── resources/
│   │       ├── templates/          # Les pages HTML (patients.html, add-patient.html)
│   │       └── application.properties # Configuration de la base de données
└── README.md                        # Description du projet


---

## 📦 Installation et lancement
Pour exécuter le projet sur votre machine locale, suivez les étapes ci-dessous.

### 1️⃣ **Prérequis**
- **Java 17** ou version plus récente.
- **Maven** installé.
- **Eclipse, IntelliJ IDEA ou tout autre IDE supportant Spring Boot**.

### 2️⃣ **Cloner le dépôt**
Exécutez la commande suivante dans le terminal :
```bash
git clone https://github.com/AhmedMaaouia1/Spring-Boot-Application.git
cd Spring-Boot-Application

# 📄 Configuration de la base de données
Le fichier **application.properties** configure la base de données **H2** :

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update

# 🌐 Accès à la console H2

Vous pouvez accéder à la console **H2** à l'adresse suivante :

- **URL** : [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- **JDBC URL** : `jdbc:h2:mem:testdb`
- **Username** : `sa`
- **Password** : (vide)

La console H2 vous permet de :
- Visualiser les tables créées automatiquement par **JPA**.
- Exécuter des requêtes SQL pour vérifier les données (par exemple : `SELECT * FROM PATIENTS;`).
- Confirmer que les opérations d'ajout et de suppression de patients fonctionnent correctement.

---

## 🎯 Étapes pour accéder à la console H2 :
1. **Démarrez l'application Spring Boot** :
   - Exécutez la classe `HopitalApplication` en tant que **Spring Boot App**.
   - Vérifiez que l'application démarre correctement dans la console (message : `Tomcat started on port(s): 8080`).

2. **Accédez à la console H2** :
   - Ouvrez votre navigateur et allez à [http://localhost:8080/h2-console](http://localhost:8080/h2-console).

3. **Configurez la connexion** :
   - **JDBC URL** : `jdbc:h2:mem:testdb`
   - **Username** : `sa`
   - **Password** : (laissez vide)
   - Cliquez sur **Connect**.

4. **Vérifiez les données dans la table `PATIENTS`** :
   - Une fois connecté, exécutez la requête SQL suivante pour voir tous les patients :
     ```sql
     SELECT * FROM PATIENTS;
     ```
   - Le tableau affichera les colonnes `ID`, `NOM`, `AGE` et `MALADE`.

5. **Testez les fonctionnalités** :
   - Ajoutez des patients via [http://localhost:8080/add-patient](http://localhost:8080/add-patient).
   - Revenez à la console H2 et exécutez la requête pour vérifier que les nouveaux patients sont bien ajoutés.
   - Supprimez un patient depuis [http://localhost:8080/patients](http://localhost:8080/patients), puis relancez la requête pour confirmer la suppression.

---

### **Exemple de requête SQL dans la console H2 :**
```sql
SELECT * FROM PATIENTS;

# 🛠️ Fonctionnalités détaillées

## 1️⃣ **Ajout d'un patient**
- **URL** : [http://localhost:8080/add-patient](http://localhost:8080/add-patient)
- **Description** : Permet d'ajouter un nouveau patient dans la base de données.
- **Étapes** :
  1. Accédez à l'URL ci-dessus.
  2. Remplissez le formulaire avec les informations suivantes :
     - **Nom** : Nom du patient.
     - **Âge** : Âge du patient.
     - **Malade** : Cochez si le patient est malade.
  3. Cliquez sur **Enregistrer**.
  4. Vous serez redirigé vers la liste des patients.

---

## 2️⃣ **Affichage de la liste des patients**
- **URL** : [http://localhost:8080/patients](http://localhost:8080/patients)
- **Description** : Affiche tous les patients enregistrés dans la base de données sous forme de tableau.
- **Colonnes affichées** :
  - **ID** : Identifiant unique du patient.
  - **Nom** : Nom du patient.
  - **Âge** : Âge du patient.
  - **Malade** : Indique si le patient est malade (**Oui**/**Non**).
- **Étapes** :
  1. Accédez à l'URL ci-dessus.
  2. Visualisez les patients enregistrés dans un tableau.
  3. Ajoutez des patients via [http://localhost:8080/add-patient](http://localhost:8080/add-patient), puis actualisez la page.

---

## 3️⃣ **Suppression d'un patient**
- **URL** : [http://localhost:8080/patients](http://localhost:8080/patients)
- **Description** : Permet de supprimer un patient de la base de données.
- **Étapes** :
  1. Accédez à l'URL ci-dessus.
  2. Dans le tableau des patients, chaque ligne contient un lien **Supprimer**.
  3. Cliquez sur le lien **Supprimer** à côté du patient à supprimer.
  4. Le patient sera immédiatement supprimé, et la liste sera mise à jour.

---

### 🎯 **Vérifications conseillées**
1. **Ajout de patients** :
   - Accédez à [http://localhost:8080/add-patient](http://localhost:8080/add-patient).
   - Ajoutez quelques patients.
   - Vérifiez leur apparition dans [http://localhost:8080/patients](http://localhost:8080/patients).

2. **Suppression de patients** :
   - Supprimez un patient depuis [http://localhost:8080/patients](http://localhost:8080/patients).
   - Confirmez la suppression en accédant à la console H2 et en exécutant :
     ```sql
     SELECT * FROM PATIENTS;
     ```

