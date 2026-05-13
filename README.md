# 📱 SharedPreferences Demo App (Android)

A simple Android application demonstrating how to use **SharedPreferences** for saving user data such as **name, email, and password**, with basic **auto-login and logout functionality**.

---

## 🎯 Purpose

This project is designed for learning how Android **local storage (SharedPreferences)** works, including:

- Saving user credentials locally
- Auto-login on app launch
- Logging out and clearing stored data
- Passing data between activities

---

## ✨ Features

- 🔐 Login screen with name, email, and password
- 💾 Save user data using SharedPreferences
- 🚀 Auto-login if user is already saved
- 🔄 Logout functionality (clears saved data)
- 📱 Simple UI using XML layouts
- 🎨 Custom themes, drawables, and launcher icons

---

## 🏗️ Project Structure

- **MainActivity**
  - Login screen
  - Saves user input to SharedPreferences
  - Checks if user is already logged in (auto-login)

- **MainActivity2**
  - Displays saved user data
  - Contains logout button
  - Clears SharedPreferences on logout

---

## 🧠 How It Works

1. User enters **name, email, password**
2. Data is stored using `SharedPreferences`
3. On next app launch:
   - App checks saved data
   - If found → auto-login to MainActivity2
4. Logout clears stored preferences and returns to login screen

---

## 🛠️ Tech Stack

- Java / Kotlin (Android)
- XML Layouts
- Android SharedPreferences

---

### 🧪 Testing
- Basic unit tests
- Instrumentation tests
  
---

## 👨‍💻 Author
Developed by [jxesguerra](https://github.com/jxesguerra)
