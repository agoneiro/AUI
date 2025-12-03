# System Zarządzania Parafiami i Księżmi

Projekt realizowany w ramach laboratoriów z przedmiotu **Architektury usług internetowych**. Aplikacja demonstruje architekturę mikroserwisów opartą o **Spring Boot**, frontend w **Angularze** oraz pełną konteneryzację przy użyciu **Docker & Docker Compose**.

---

## 📂 Struktura Projektu

System składa się z trzech usług backendowych, aplikacji frontendowej oraz dedykowanych baz danych:

```text
AUI/
├── gateway-service  # Brama API (Spring Cloud Gateway)
├── parish-service   # Mikroserwis Parafii
├── priest-service   # Mikroserwis Księży
├── frontend         # Aplikacja Angular serwowana przez NGINX
└── docker-compose.yml
```

---

## 🛠️ Wykorzystane Technologie

### Backend
* **Java 17** & **Spring Boot 3.x**
* **Maven**
* **PostgreSQL 15**
* **Angular 17+**
* **NGINX**
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

#### Aby wyłączyć:
```bash
docker-compose down
```

