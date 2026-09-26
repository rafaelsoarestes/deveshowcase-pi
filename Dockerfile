# Estágio de Build
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .

# Se os arquivos do projeto estiverem dentro de uma subpasta chamada deveshowcase-pi, 
# ajusta a compilação buscando o pom.xml onde estiver:
RUN if [ -f "pom.xml" ]; then ./mvnw clean package -DskipTests || mvn clean package -DskipTests; \
    elif [ -f "deveshowcase-pi/pom.xml" ]; then cd deveshowcase-pi && (./mvnw clean package -DskipTests || mvn clean package -DskipTests); \
    fi

# Estágio de Execução
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/**/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]