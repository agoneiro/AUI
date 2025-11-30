# System zarządzania parafią

Projekt realizowany w ramach laboratoriów z przedmiotu **Architektury usług internetowych**. Aplikacja składa się z trzech mikroserwisów backendowych (**Spring Boot**) oraz warstwy frontendowej (**Angular**).

## 📂 Struktura Projektu

```text
AUI/
├── gateway-service  # Brama API (Spring Cloud Gateway) - Port 8080
├── parish-service   # Mikroserwis Parafii (H2 DB)    - Port 8081
├── priest-service   # Mikroserwis Księży (H2 DB)    - Port 8082
└── frontend         # Aplikacja kliencka (Angular 17+) - Port 4200
```

---

## 🛠️ Wymagane Narzędzia
- Java JDK 17+
- Maven
- Node.js (LTS v20+)
- Angular CLI (npm install -g @angular/cli)

--- 

## 🚀 Jak uruchomić?
### 1. Backend (Spring Boot)
Należy uruchomić trzy aplikacje równolegle:
- ParishServiceApplication (Port: 8081)
- PriestServiceApplication (Port: 8082)
- GatewayServiceApplication (Port: 8080)

Bazy danych H2 są w pamięci i inicjalizują się automatycznie przy starcie.

### 2. Frontend (Angular)
Otwórz terminal w folderze frontend i wykonaj:

```bash
# Instalacja zależności (tylko pierwszy raz)
npm install
# Uruchomienie serwera
ng serve
```

Aplikacja dostępna pod adresem: http://localhost:4200/