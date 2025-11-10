# 🧩 Structure du JWT (coté Auth Service)

Quand ton service d’authentification crée le token, il y encode :

le nom d’utilisateur (sub)

les rôles / permissions dans les claims (roles ou authorities)

éventuellement d’autres infos (ID, expiration, etc.)

Exemple de payload du JWT :

-----

{
  "sub": "adama",
  "roles": ["ROLE_ADMIN", "ROLE_USER"],
  "permissions": ["CLIENT_READ", "CLIENT_WRITE"],
  "iat": 1731234567,
  "exp": 1731238167
}

-----


## 1. Exemple de génération côté Auth Service

Voir le fichier JwtTokenConfig.java

## 3. Côté microservices consommateurs : décoder et injecter les rôles

Quand un autre microservice reçoit une requête avec le JWT dans le header :

-----

Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6...

-----


➡️ Il doit extraire les rôles/permissions du token et les mettre dans le contexte Spring Security.
C’est exactement le rôle du filtre JwtTokenValidator.

Voir le ficher JwtTokenValidator.java

🧮 JwtUtils — extraction des rôles et permissions

Voir le fichier JwtUtils.java

## 🧱 4. SecurityConfig dans chaque microservice

Maintenant que le filtre remplit le SecurityContext avec les rôles du JWT,
tu peux sécuriser les routes avec les annotations Spring standard 🎯 :

Voir le fichier SecurityConfig.java 


## 5. Autorisation des routes (avec les rôles du JWT)

Une fois ton SecurityContext alimenté,
tu peux sécuriser les endpoints directement dans tes contrôleurs :

Exemple : voir fichier AdminController.java