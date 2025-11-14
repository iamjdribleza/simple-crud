# Simple CRUD Application

A simple CRUD (Create, Read, Update, Delete) application that demonstrates basic database operations - adding, viewing, editing, and deleting records.
This project is designed to help beginners understand how CRUD operations work in a full-stack environment.

---

## Features
- **Create** - Add new records to the database
- **Read** - Retrieve and display data
- **Update** - Modify existing records
- **Delete** - Remove data from the database

---

## Tech Stack
- **Backend:** Java/Spring-Boot
- **Frontend:** Html, Tailwind, Angular
- **Database:** Postgresql
- **Tools:** Git, Postman, VS Code, IntelliJ

---

## Guitar API Endpoints
### Guitar
**GET /api/v1/guitars**
List all guitars.

**GET /api/v1/guitars/{refId}**
Get guitar by reference id.

**POST /api/v1/guitars**
Create new guitar.

**PATCH /api/v1/guitars/{refId}**
Update guitar.

**DELETE /api/v1/guitars/{refId}**
Delete guitar.

### Manufacturer
**GET /api/v1/manufacturers**
List all manufacturers.

**GET /api/v1/manufacturers/{refId}**
Get manufacturer by reference id.

**POST /api/v1/manufacturers**
Create new manufacturer.

**PATCH /api/v1/manufacturers/{refId}**
Update manufacturer.

**DELETE /api/v1/manufacturers/{refId}**
Delete manufacturer.

---

## Installation & Setup

### 1. Clone the repository
```bash
git clone https://github.com/iamjdribleza/simple-crud.git
cd simple-crud
