# 🏥 HEALTH CARE - Android Application

Aplikasi **HEALTH CARE** adalah solusi mobile untuk manajemen data pendaftaran kesehatan yang fokus pada pengalaman pengguna (*User Experience*) yang interaktif dan validasi data yang kuat.

---

## ✨ Fitur Unggulan

### 📝 Form Registrasi Cerdas
*   **Input Terintegrasi:** Menggunakan Material Design `TextInputLayout` untuk Nama, Email, dan Password.
*   **Validasi Real-time:** Sistem langsung mendeteksi kesalahan input (seperti format email salah atau password terlalu pendek) saat pengguna mengetik.
*   **Kontrol Presisi:** Pemilihan jenis kelamin via `RadioGroup` dan golongan darah via `Spinner`.

### 🛡️ Validasi Keamanan
*   Mencegah pengiriman data jika form belum lengkap.
*   Minimal 3 hobi harus dipilih untuk memastikan data profil yang kaya.
*   Dialog konfirmasi sebelum data diproses untuk menghindari kesalahan ketuk.

### ⚡ Fitur Eksklusif: Long Press Clear Form
Salah satu keunikan aplikasi ini adalah fitur **Quick Reset**:
*   **Aksi:** Tekan lama pada tombol **Register**.
*   **Efek:** Seluruh formulir akan dibersihkan seketika.
*   **Feedback:** Dilengkapi dengan *Haptic Feedback* (getaran) dan notifikasi Toast sebagai konfirmasi visual dan fisik.

---

## 🛠️ Stack Teknologi

| Komponen | Teknologi |
| :--- | :--- |
| **Bahasa** | Kotlin 2.2.10 |
| **Build System** | Gradle 9.0 (AGP 9.0.1) |
| **UI Engine** | Material Components & ConstraintLayout |
| **SDK Support** | Compile SDK 36 (Android 16) |
| **Min. Android** | Android 12 (API 31) |

---

## 🚀 Cara Menjalankan Project

### 1. Prasyarat
*   **Android Studio** Ladybug (2024.2.1) atau versi lebih baru.
*   **JDK 17** atau yang lebih tinggi.

### 2. Instalasi
1.  Clone repository ini:
    
