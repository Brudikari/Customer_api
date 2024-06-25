# Étape 1 : Utiliser une image Maven pour la compilation
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Définir le répertoire de travail
WORKDIR /app

# Copier les fichiers nécessaires pour la compilation
COPY . .

# Compiler le projet et créer le fichier JAR
RUN mvn clean package -DskipTests

# Étape 2 : Utiliser une image Java pour exécuter l'application
FROM eclipse-temurin:17-jdk-alpine

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR depuis l'étape de compilation
COPY --from=build /app/target/customers-0.0.1-SNAPSHOT.jar app.jar

# Définir la commande de démarrage par défaut
ENTRYPOINT ["java", "-jar", "app.jar"]
