HEALTH CARE - Android Application
Aplikasi HEALTH CARE adalah aplikasi Android berbasis Kotlin yang dirancang untuk mendemonstrasikan implementasi form pendaftaran medis yang interaktif dengan validasi real-time dan fitur User Experience (UX) modern.
 Fitur Utama
•
Form Pendaftaran Lengkap: Input untuk Nama, Email, dan Password menggunakan TextInputLayout Material Design.
•
Validasi Real-time: Menggunakan TextWatcher untuk memberikan feedback error langsung saat pengguna mengetik (Email tidak valid, password kurang dari 6 karakter, dll).
•
Kontrol Pilihan (Selection Controls):
◦
Radio Button: Untuk pemilihan Jenis Kelamin.
◦
CheckBox: Untuk memilih hobi/aktivitas kesehatan (minimal 3 pilihan).
◦
Spinner: Untuk pemilihan Golongan Darah.
•
Interaksi Gesture (Long Press): Fitur khusus pada tombol Register di mana menekan lama (long click) akan menjalankan fungsi Clear Form (menghapus semua inputan) disertai dengan Haptic Feedback (getaran).
•
Dialog Konfirmasi: Menampilkan AlertDialog sebelum data benar-benar diproses untuk mencegah kesalahan input.
 Teknologi & Spesifikasi
•
Bahasa: Kotlin
•
UI Framework: XML (ConstraintLayout, ScrollView, Material Components)
•
View Binding: Untuk interaksi antara kode dan layout yang lebih aman.
•
AGP Version: 9.0.1 (Menggunakan Built-in Kotlin Support)
•
SDK Version:
◦
Compile SDK: 36
◦
Target SDK: 36
◦
Min SDK: 31
