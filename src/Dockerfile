# ESTÁGIO 1: BUILD
FROM gradle:8.5.0-jdk17 AS build
WORKDIR /app

# Copia e configura o ambiente de build
COPY build.gradle settings.gradle ./
COPY gradlew gradlew.bat ./
COPY gradle/ gradle/
COPY src src

# Roda o build e gera o JAR
RUN gradle build --no-daemon -x test

# ESTÁGIO 2: EXECUÇÃO (Runtime)
# Imagem menor e segura com apenas o JRE (Java Runtime Environment)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# COPIA o arquivo JAR correto
COPY --from=build /app/build/libs/overdaily-0.0.1-SNAPSHOT.jar app.jar

# Configuração de porta
ENV PORT 8080
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]