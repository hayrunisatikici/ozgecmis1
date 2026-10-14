# ozgecmis

Bu proje, Java programlama dili ve Apache PDFBox kütüphanesi kullanılarak tasarlanmış, Nesne Yönelimli Programlama (OOP) prensiplerine uygun bir PDF Özgeçmiş (CV) oluşturma uygulamasıdır.

## Özellikler
- **Modüler Mimari:** PDF üretimi, veri modelleri (`PersonalDetails`, `Experience`, `Resume`) ve ana uygulama akışı (`Main`) birbirinden tamamen ayrıştırılmıştır.
- **Profil Fotoğrafı Desteği:** PDF belgesine sol üst köşede hizalanmış vesikalık/profil fotoğrafı yerleştirme.
- **Dinamik Deneyim & Yetenek Listesi:** Birden fazla iş tecrübesi ve teknik yetenek ekleme yapısı.
- **Kartezyen Koordinat Hizalaması:** Sayfa bileşenleri ve ayırıcı çizgiler çakışmayacak şekilde koordinat tabanlı kurgulanmıştır.

## 🛠️ Kullanılan Bileşenler ve Mimari
1. `PersonalDetails`: Kişisel iletişim ve profil fotoğrafı dosya yolunu kapsüller (Encapsulation).
2. `Experience`: İş deneyimi detaylarını (Şirket, Unvan, Tarih, Açıklama) temsil eder.
3. `Resume`: Kişisel bilgileri, iş deneyimlerini ve yetenekleri bir arada tutan ana veri modelidir (Composition).
4. `PdfGeneratorService`: Veri nesnesini alarak Apache PDFBox kütüphanesi yardımıyla `Ozgecmis.pdf` dosyasına dönüştüren servis sınıfıdır.
