# UTS Advanced Software Engineering - Aplikasi Spring Boot

## 👤 Informasi Pengembang
* **Nama** : Rizki Febrian
* **Mata Kuliah** : Advanced Software Engineering
* **Nama Proyek** : `UTS_AdvSWE_RizkiFebrian`
* **Teknologi Utama** : Java 17 / 26, Spring Boot 3.2.0 (Starter Web), Apache Maven

---

## 📝 Jawaban Soal 1: Analisis Kerangka Kerja Spring (Metode 5W)

* **What (Apa itu Spring Framework?):**  
  Spring merupakan kerangka kerja (*framework*) open-source berbasis Java yang dirancang untuk memfasilitasi pembuatan aplikasi backend kelas enterprise. Komponen utamanya mengandalkan *Inversion of Control* (IoC) serta *Dependency Injection* (DI) guna mengelola siklus hidup *object/bean* secara otomatis dan efisien.

* **Why (Mengapa Memilih Spring?):**  
  Penggunaan Spring memangkas kompleksitas arsitektur perangkat lunak Java secara signifikan. Berkat integrasi *embedded web server* (seperti Apache Tomcat bawaan Spring Boot), pengembang tidak perlu melakukan konfigurasi server eksternal secara manual dan dapat berfokus penuh pada logika bisnis utama.

* **Who (Siapa Penciptanya?):**  
  Arsitektur awal Spring Framework dirancang oleh **Rod Johnson** dan diperkenalkan secara resmi kepada publik pada Juni 2003.

* **When (Kapan Waktu yang Tepat Menggunakannya?):**  
  Spring/Spring Boot sangat tepat diimplementasikan pada proyek skala menengah hingga besar, pengembangan layanan berbasis *RESTful API*, arsitektur *microservices*, serta sistem enterprise yang membutuhkan performa tinggi, integrasi basis data, dan sistem keamanan yang terstruktur.

* **Where (Di Mana Posisi Implementasinya?):**  
  Spring beroperasi pada arsitektur *server-side* (back-end) dan dieksekusi di atas lingkungan *Java Virtual Machine* (JVM).

---

## 🚀 Fitur Utama & Logika Bisnis

Sistem ini dikembangkan sebagai layanan **Web RESTful API** menggunakan Spring Boot, lengkap dengan antarmuka web interaktif berarsitektur dashboard bertema **Burgundy Red**:

1. **Sistem Penggajian John Travolta (`/travolta`)**  
   * **Mekanisme Kerja:** Menghitung estimasi imbalan kerja mingguan dengan skema tarif dasar Rp 15.000/jam (kuota normal hingga 40 jam) dan insentif lembur sebesar 1,5 kali tarif dasar untuk kelebihan jam kerja.
   * **Kalkulasi Finansial:** Mengurangkan total imbalan dengan estimasi biaya hidup mingguan (Rp 600.000) untuk menganalisis kecukupan tabungan.

2. **Penghitung Akar Persamaan Kuadrat (`/kuadrat`)**  
   * **Mekanisme Kerja:** Menghitung nilai Diskriminan ($D = b^2 - 4ac$) dari formula umum $ax^2 + bx + c = 0$.
   * **Klasifikasi Akar:**
     * $D > 0$: Mengidentifikasi dua nilai akar real yang unik ($x_1 \neq x_2$).
     * $D = 0$: Mengidentifikasi satu nilai akar real kembar ($x_1 = x_2$).
     * $D < 0$: Mengidentifikasi nilai akar berupa bilangan imajiner (tidak ada akar real).

---

## 📸 Tampilan Antarmuka Web (Visual UI)

### 1. Halama Utama (Dashboard Form Input)
![Dashboard Utama](<img width="708" height="390" alt="image" src="https://github.com/user-attachments/assets/001726ea-89bc-4b6f-b6a2-4fc165d54c69" />
)

### 2. Halaman Rincian Gaji John Travolta
![Hasil Gaji](<img width="678" height="340" alt="image" src="https://github.com/user-attachments/assets/a414595e-4367-418f-adee-33fb6637d392" />
)

### 3. Halaman Hasil Analisis Persamaan Kuadrat
![Hasil Kuadrat](<img width="692" height="363" alt="image" src="https://github.com/user-attachments/assets/774d3f75-7e29-4cd1-b977-e7469e3c6f72" />
).

---

## 🛠️ Petunjuk Pengoperasian Aplikasi

### Metode 1: Menggunakan Apache NetBeans
1. Buka aplikasi Apache NetBeans, navigasi ke **File > Open Project**.
2. Arahkan ke direktori **`UTS_AdvSWE_RizkiFebrian`**.
3. Buka direktori `Source Packages` > `com.uts.advswe`.
4. Klik kanan pada berkas **`UtsApplication.java`**, lalu pilih **Run File** (atau tekan `Shift + F6`).

### Metode 2: Menggunakan Terminal / Command Prompt (Maven)
Jalankan perintah berikut pada direktori utama proyek:
```bash
mvn spring-boot:run
