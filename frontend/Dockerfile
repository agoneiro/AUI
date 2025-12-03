# Budowanie aplikacji Angular
FROM node:20-alpine as build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build --configuration=production

# Serwowanie przez NGINX
FROM nginx:alpine

# Kopiujemy zbudowane pliki Angulara do folderu NGINX
COPY --from=build /app/dist/frontend/browser /usr/share/nginx/html

# Kopiujemy szablon konfiguracji
COPY nginx.conf.template /etc/nginx/templates/default.conf.template

# Ustawiamy domyślną wartość zmiennej (można nadpisać w docker-compose)
ENV API_URL=http://gateway-service:8080

EXPOSE 80