# System Zarządzania Parafiami i Księżmi

Projekt realizowany w ramach laboratoriów z przedmiotu **Architektury usług internetowych**. Aplikacja demonstruje zaawansowaną architekturę mikroserwisów opartą o **Spring Boot**, frontend w **Angularze** oraz pełną konteneryzację przy użyciu **Docker & Docker Compose**.

---

## 📂 Struktura Projektu

System składa się z trzech usług backendowych, aplikacji frontendowej oraz dedykowanych baz danych:

```text
AUI/
├── gateway-service    # Brama API (Spring Cloud Gateway) - Port zew: 8080
├── discovery-service  # Usługa Wykrywania (Netflix Eureka)   - Port wew: 8761
├── config-service     # Centralna Konfiguracja           - Port wew: 8888
├── parish-service     # Mikroserwis Parafii              - Port wew: 8081
├── priest-service     # Mikroserwis Księży (2 instancje) - Port wew: 8082
├── frontend           # Aplikacja Angular serwowana przez NGINX
└── docker-compose.yml # Konteneryzacja całej infrastruktury
```

---

## 🛠️ Wykorzystane Technologie

* **Java 17** & **Spring Boot 3.x**
* **Spring Cloud (Gateway, Netflix Eureka, Config Server, LoadBalancer), Spring Data JPA**
* **PostgreSQL 15** (uruchomiana w kontenerach z wolumenami)
* **Flyway** (automatyczne wersjonowanie schematu baz danych)
* **Angular 17+, NGINX**
* **Docker** & **Docker Compose**

---

## 🚀 Instrukcja uruchomienia
### 1. Budowanie aplikacji

W głównym folderze wykonaj:

```powershell
.\mvnw clean package -DskipTests
```

### 2. Uruchomienie kontenerów
```bash
docker-compose up -d --build
```

### 3. Dostęp do aplikacji
Poczekaj ok. minuty aż wszystko się odpali:
* Aplikacja dostępna pod adresem: http://localhost:4200
* Eureka Dashboard: http://localhost:8761 (Podgląd statusu serwisów)

#### Aby wyłączyć:
```bash
docker-compose down # -v jeśli wykasuje wolumeny
```

