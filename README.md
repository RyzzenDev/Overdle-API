![Logo do OverDaily](Overdle.svg)
# 🎯 Overdle API
> The backend engine powering **Overdle** — the ultimate Overwatch guessing game.

**Overdle** is a daily challenge game inspired by the popular *Valdle*, but completely dedicated to the Overwatch universe. Every day, players are challenged to identify a hero based on specific clues such as **Affiliation**, **Role**, **Launch Year**, and **Many more**.

### ⚛️ Frontend Source Code

If you are looking for the source code for the Next.js application, you can find the repository here:
[👉 OverDaily Frontend Repository](https://github.com/RyzzenDev/OverdleWeb)
## 🎮 Play Now

The frontend is live! You can test your knowledge right now at:

### [👉 overdle.com}(https://overdle.com)

---

## 🛠️ About the Project

This API serves as the backbone of the application. It is designed to be robust and performant, managing the entire game state and data distribution.

**Key Responsibilities:**
* **Data Management:** Orchestrates the database of Heroes, Abilities, and Voice Lines.
* **Daily Challenges:** Generates and serves the daily puzzle data to the frontend.
* **Consistency:** Ensures game integrity and validates user answers.

---

## 🔮 Roadmap & Future Features

We are constantly working to expand Overdle. Here is what's coming next:

* **Ability Mode:** A new mode to guess the hero based solely on ability icons or descriptions.
* **Voice Line Mode:** Challenge your hearing by identifying heroes from obscure voice lines.
* **Map Guessing:** A visual mode to guess the Overwatch map from a screenshot.
* **Ultimate Mode:** A specialized mode focused entirely on Ultimate voice lines and sounds.

---

## 🚀 Tech Stack

This project leverages modern software architecture, utilizing **Java 21** and **Spring Boot 3** for high performance, alongside **Redis** for caching and **Next.js** for the client-side experience.

| Category | Technology | Description |
| :--- | :--- | :--- |
| **Core** | ![Java](https://img.shields.io/badge/Java-21-ED8B00?style=flat&logo=openjdk&logoColor=white) | The main programming language (LTS). |
| **Framework** | ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3-6DB33F?style=flat&logo=spring&logoColor=white) | For RESTful API creation and dependency injection. |
| **Database** | ![MySQL](https://img.shields.io/badge/MySQL-005C84?style=flat&logo=mysql&logoColor=white) | Primary relational database for persistence. |
| **Caching** | ![Redis](https://img.shields.io/badge/Redis-DC382D?style=flat&logo=redis&logoColor=white) | Used for caching and session management. |
| **Frontend** | ![Next.js](https://img.shields.io/badge/Next.js-black?style=flat&logo=next.js&logoColor=white) | The client-side application (hosted on Vercel). |

### Additional Libraries
* **Spring Data JPA / Hibernate:** For ORM and database interactions.
* **Lombok:** To reduce boilerplate code.
* **Spring Web:** For building the web layer.

---

## 📝 License

The code in this repository is licensed under the GNU General Public License, Version 3.

Disclaimer: OverDaily is a non-official, fan-made project created as a tribute to the Overwatch™ universe. Overwatch™ and all related intellectual properties (characters, names, art, sounds, etc.) are registered trademarks and property of Blizzard Entertainment, Inc.©. The project is entirely free and non-profit.
