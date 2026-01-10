# 📝 **Blog Management CRUD Application**

### *Full-Stack Spring Boot + PostgreSQL Web Application*

<p align="center">
  <img src="https://img.shields.io/badge/Spring%20Boot-2.7.15-brightgreen?style=for-the-badge">
  <img src="https://img.shields.io/badge/PostgreSQL-Database-blue?style=for-the-badge">
  <img src="https://img.shields.io/badge/Thymeleaf-Frontend-orange?style=for-the-badge">
  <img src="https://img.shields.io/badge/Status-Stable-brightgreen?style=for-the-badge">
</p>

A **role-based Blog Management CRUD Application** built with **Spring Boot**, **PostgreSQL**, and **Thymeleaf**, featuring **secure admin and user panels** with modern UI and clean UX.

---

# 🌐 **Live Demo / UI Preview**

🎬 Video Preview: [Watch Here](https://fs.blabigo.org/s/lb6Qam4t)

### **Admin Dashboard (Add / Edit / Delete Blogs)**

```
┌─────────────────────────────────────────────┐
│  🖋 Personal Blog                            │
│---------------------------------------------│
│  My first article        Edit  Delete       │
│  Second article          Edit  Delete       │
│  Third article           Edit  Delete       │
│  + Add Blog                                   │
└─────────────────────────────────────────────┘
```

### **User View**

```
┌─────────────────────────────────────────────┐
│  👤 Blogs                                   │
│---------------------------------------------│
│  My first article                            │
│  Second article                              │
│  Third article                               │
│  ...                                         │
└─────────────────────────────────────────────┘
```

---

# 🔑 **Roles & Features**

## 👨‍💼 Admin Panel

> Only Admin can access this panel (secure authentication object implemented)

### **Capabilities**

* 📝 Add new blogs
* ✏️ Edit existing blogs (original publish date preserved)
* 🗑 Delete blogs
* 🔒 Admin-only dashboard
* 🔐 Role-based route protection

---

## 👤 User Panel

### **Capabilities**

* View all blogs
* Read full blog details
* Cannot access admin routes

---

# 🛠️ **Tech Stack**

| Layer    | Technology                    |
| -------- | ----------------------------- |
| Backend  | Spring Boot (Java 17+)        |
| Frontend | Thymeleaf + CSS               |
| Security | Spring Security (Auth Object) |
| Database | PostgreSQL                    |
| IDE      | STS (Spring Tool Suite)       |

---

# 🗃️ **Database Setup (PostgreSQL)**

### **1. Create Database**

```sql
CREATE DATABASE blogapp;
```

### **2. Create Tables**

Use the **Schemas.sql** file in the repository.

### **3. Add Admin User**

```sql
INSERT INTO admin (username, password, name)
VALUES ('admin', 'admin123', 'Admin Name');
```

### **4. Configure DB Connection**

`application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/blogapp
spring.datasource.username=postgres
spring.datasource.password=your_pg_password
spring.jpa.hibernate.ddl-auto=update
```

---

# 🚀 **How to Run**

1. Open the project in **STS / IntelliJ IDEA**
2. Ensure PostgreSQL is running
3. Run the application as **Spring Boot App**
4. Access:

```
Admin: http://localhost:8080/admin/dashboard
User:  http://localhost:8080/
```

---

# 📁 **Project Structure**

```
BlogApp/
│
├── src/main/java/hello/security/main/      # Controllers & Services
├── src/main/resources/templates/          # Thymeleaf HTML pages
├── src/main/resources/static/             # CSS
├── Schemas.sql                             # DB setup
└── README.md
```

---

# ✅ **Feature Matrix**

| Role   | Features                                   |
| ------ | ------------------------------------------ |
| Admin  | Add/Edit/Delete Blogs, Admin Dashboard     |
| Admin  | Secure login, Role-based route protection  |
| User   | View blogs, Read full blog                 |
| Shared | Secure authentication with Spring Security |

---

# 🌱 **Future Enhancements**

* ✨ Rich text editor for blog content
* 🔍 Search & Filter blogs
* 🖼 Image upload for blogs
* 📊 Analytics for admin (views, top blogs)

---

# 👨‍💻 **Author**

### Haris Khatti

---

# 📄 **License**

This project is for **educational/demo purposes only**.

---

**Video / Live UI Preview:**
🎬 [https://fs.blabigo.org/s/lb6Qam4t](https://fs.blabigo.org/s/lb6Qam4t)

---

Agar chaho, mai ye **README.md file generate kar ke direct download link** bhi de doon, ready for GitHub push.

Kya mai woh kar doon?
