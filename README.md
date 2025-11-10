# 🧪 Testy automatyczne aplikacji webowych — [QA Playground](https://qaplayground.dev/)

---

## 📝 Opis projektu

Ten projekt zawiera zestaw **automatycznych testów interfejsu użytkownika (UI)** napisanych w języku **Java**, z 
użyciem bibliotek **Selenium WebDriver** oraz **TestNG**.  
Testy weryfikują poprawność działania wybranych elementów i funkcjonalności na stronie [QA Playground](https://qaplayground.dev/).

Projekt został przygotowany jako część nauki kwalifikacji oraz zaliczenia praktyki **INF.04 – Tworzenie i administrowanie
stronami internetowymi i aplikacjami webowymi**,  
oraz jako przykład wykorzystania frameworków testowych w praktyce.

---

## 🎯 Cele projektu

- Automatyzacja testów interfejsu użytkownika (UI)
- Weryfikacja poprawności działania elementów strony (formularze, przyciski, walidacje)
- Zastosowanie wzorca **Page Object Model (POM)** w organizacji testów
- Generowanie raportów z testów w formacie **Allure Report**
- Rejestrowanie logów przy użyciu **Log4j** i **SLF4J**
- Integracja projektu z systemem kontroli wersji **GitHub**

---

## 🧰 Użyte technologie

| Technologia | Zastosowanie |
|-----------|--------------|
| **Java 21** | język programowania |
| **Selenium WebDriver** | automatyzacja przeglądarki |
| **TestNG** | framework do testów jednostkowych |
| **Maven** | zarządzanie zależnościami i uruchamianie testów |
| **Allure Report** | generowanie raportów z wyników testów 
| **Log4j** | rejestrowanie logów w trakcie testów |
| **SLF4J** | prosty interfejs do logowania (bridge do Log4j) 
| **GitHub Actions** | automatyzacja i publikacja raportów (CI/CD) |

---

## 🚀 Jak uruchomić testy

1. **Sklonuj repozytorium:**
   ```bash
   git clone https://github.com/RomanBurlaka78/QA_PlaygroundWithOutDocker.git

2. Otwórz projekt w IDE (np. IntelliJ IDEA lub Eclipse).

3. Uruchom testy: 
  * w terminalu IDE wpisz:  mvn clean test 
  * lub uruchom ręcznie przez panel boczny Maven → Lifecycle → test

NB! Raport Allure jest również publikowany automatycznie w repozytorium na GitHubie.
Można go obejrzeć w zakładce:
👉 Actions → Pages → Build and Deployment

## 👨‍💻 O autorze

### Roman Burlaka
Uczeń kierunku informatycznego – kwalifikacja INF.04
Tworzenie i administrowanie aplikacjami internetowymi.
Piszę testy automatyczne w języku Java z użyciem Selenium i TestNG.

📫 GitHub: https://github.com/RomanBurlaka78