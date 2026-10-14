package org.example;

public class Main {
    public static void main(String[] args) {
        // 1. Kişisel Bilgiler Nesnesi Oluşturuluyor
        PersonalDetails personalDetails = new PersonalDetails(
                "Hayrunisa Tikici",
                "hayrunisa@example.com",
                "+90 555 123 4567",
                "Kirklareli, Turkiye",
                "profile.jpg" // Proje klasöründeki profil fotoğrafınızın adı
        );

        // 2. Özgeçmiş Nesnesi Oluşturuluyor
        Resume resume = new Resume(personalDetails);

        // 3. Ödev Şartı: 3 Adet İş Deneyimi
        resume.addExperience(new Experience(
                "Tech Solutions A.S.",
                "Yazilim Muhendisi Stajyeri",
                "Haziran 2025 - Agustos 2025",
                "Java ve Spring Boot altyapisiyla backend servislerinin gelistirilmesine katkida bulunuldu."
        ));

        resume.addExperience(new Experience(
                "Veri Sistemleri Ltd.",
                "Yazilim Gelistirme Asistani",
                "Ocak 2026 - Mayis 2026",
                "C++ ve Java dilleri kullanilarak algoritma optimizasyonu yapildi."
        ));

        resume.addExperience(new Experience(
                "Netronik Teknoloji",
                "Junior Java Gelistirici",
                "Haziran 2026 - Halen",
                "Nesne yonelimli mimari prensiplerine uygun moduler yazilim bilesenleri yazildi."
        ));

        // 4. Yetenekler Ekleniyor
        resume.addSkill("Java");
        resume.addSkill("C / C++");
        resume.addSkill("Git & GitHub");
        resume.addSkill("Object-Oriented Programming (OOP)");
        resume.addSkill("SQL");

        // 5. PDF Oluşturma İşlemi Servis Sınıfına Devrediliyor
        PdfGeneratorService pdfService = new PdfGeneratorService();
        pdfService.generateResumePdf(resume, "Ozgecmis.pdf");
    }
}