# Solution GlossaLearn

## Table des matières

- [Introduction](#introduction)
- [Structure du projet](#structure-du-projet)
- [Prérequis](#prérequis)
- [Installation](#installation)
  - [Backend (API Principal)](#backend-api-principal)
  - [Frontend (Application Utilisateur)](#frontend-application-utilisateur)
  - [Analytics (Application IA/Analyse)](#analytics-application-ia-analyse)
- [Exécution](#exécution)
  - [Backend (API Principal)](#backend-api-principal)
  - [Frontend (Application Utilisateur)](#frontend-application-utilisateur)
  - [Analytics (Application IA/Analyse)](#analytics-application-ia-analyse)
- [Tests](#tests)
- [Dépannage](#dépannage)
- [Contributions](#contributions)
- [License](#license)

---

## Introduction

**GlossaLearn** est une plateforme d'apprentissage des langues innovante qui propose trois composantes :
1. **glossalearn-backend** : L'API principale développée en Java (Spring Boot).
2. **glossalearn-frontend** : L'application utilisateur en Angular pour l'apprentissage des langues.
3. **glossalearn-analytics** : Une solution d'analyse de données et d'intelligence artificielle développée en Python.

---

## Structure du projet

Le projet se compose des trois applications suivantes :

- glossalearn-backend : API principale développée en Java (Spring Boot)
- glossalearn-frontend : Application utilisateur développée en Angular
- glossalearn-analytics : Application d'analyse de données et d'intelligence artificielle développée en Python

---

## Prérequis

Avant de commencer, assurez-vous d'avoir installé les éléments suivants :

- **Node.js** (version ≥ 14.x) et **npm** (version ≥ 6.x) pour le frontend.
- **Angular CLI** pour gérer les applications Angular.
- **Python 3.x** et **pip** pour le traitement des données IA.
- **Java JDK 11+** pour le backend Spring Boot.
- **PostgreSQL** et **Redis** comme services tiers (assurés via `docker-compose` pour l'infrastructure).

---

## Installation

### 1. Backend (API Principal)

- Naviguez dans le dossier `glossalearn-backend` :
  cd glossalearn-backend

- Installez les dépendances :
  ./gradlew build

- Configurez la base de données dans le fichier `src/main/resources/application.yml`.

- Lancez l'API :
  ./gradlew bootRun

### 2. Frontend (Application Utilisateur)

- Naviguez dans le dossier `glossalearn-frontend` :
  cd glossalearn-frontend

- Installez les dépendances npm :
  npm install

- Démarrez l'application :
  ng serve

### 3. Analytics (Application IA/Analyse)

- Naviguez dans le dossier `glossalearn-analytics` :
  cd glossalearn-analytics

- Installez les dépendances Python :
  pip install -r requirements.txt

- Exécutez l'application d'analyse :
  python app.py

---

## Exécution

### Backend (API Principal)

L'API principale est construite avec Spring Boot. Elle fournit des endpoints REST pour gérer les utilisateurs, les cours, et les autres entités nécessaires à l'application d'apprentissage.

- Démarrez l'API localement :
    ```bash
    cd glossalearn-backend
    ./gradlew bootRun
    ```

Par défaut, l'API est disponible sur http://localhost:8080.

### Frontend (Application Utilisateur)

L'application frontend est une SPA (Single Page Application) développée avec Angular.

- Démarrez l'application :
    ```bash
    cd glossalearn-frontend
    ng serve
    ```

Par défaut, l'application est accessible sur http://localhost:4200.

### Analytics (Application IA/Analyse)

L'application **glossalearn-analytics** utilise Python pour effectuer des analyses de données et appliquer des modèles d'intelligence artificielle aux cours et aux utilisateurs.

- Exécutez le script :
    ```bash
    cd glossalearn-analytics
    .venv/Scripts/activate
    flask run
    ```
Par défaut, l'application d'analyse sera disponible sur http://localhost:5000.

---

## Tests

### Backend

Pour exécuter les tests unitaires et d'intégration du backend :

cd glossalearn-backend
./gradlew test

### Frontend

Pour exécuter les tests unitaires du frontend Angular :

cd glossalearn-frontend
ng test

### Analytics

Pour exécuter les tests sur l'application **glossalearn-analytics**, assurez-vous que tous les tests Python sont configurés, puis lancez-les :

cd glossalearn-analytics
python -m unittest discover

---

## Dépannage

- **Base de données** : Assurez-vous que la base de données est correctement configurée dans le fichier `application.yml` du backend.
- **Python** : Si l'application Python ne fonctionne pas, vérifiez que toutes les dépendances de `requirements.txt` sont bien installées.
- **Node.js** : Si l'application Angular ne démarre pas, vérifiez les versions de Node.js et des dépendances npm.

---

## Contributions

Les contributions sont les bienvenues. Veuillez suivre le flux de travail **Git Flow** et soumettre des pull requests avec une description détaillée des modifications.

---

## License

Ce projet est sous licence MIT. Veuillez consulter le fichier `LICENSE` pour plus de détails.
