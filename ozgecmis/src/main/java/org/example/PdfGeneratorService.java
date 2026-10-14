package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;

public class PdfGeneratorService {

    public void generateResumePdf(Resume resume, String outputPath) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {

                PDType1Font titleFont = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);
                PDType1Font subTitleFont = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);
                PDType1Font textFont = new PDType1Font(Standard14Fonts.FontName.HELVETICA);

                float yPosition = 740;

                // 1. Profil Fotoğrafı (Sol Tarafta Hizalı)
                File photoFile = new File(resume.getPersonalDetails().getPhotoPath());
                if (photoFile.exists()) {
                    PDImageXObject image = PDImageXObject.createFromFileByExtension(photoFile, document);
                    // Fotoğraf solda: x = 50, y = 645, genişlik = 100, yükseklik = 100
                    contentStream.drawImage(image, 50, 645, 100, 100);
                }

                // 2. Kişisel Bilgiler (Fotoğrafın Sağında Hizalı)
                float textLeftMargin = 170; // Fotoğrafın bittiği yerin sağından başlatıyoruz

                contentStream.beginText();
                contentStream.setFont(titleFont, 18);
                contentStream.newLineAtOffset(textLeftMargin, yPosition);
                contentStream.showText(resume.getPersonalDetails().getFullName());
                contentStream.endText();

                yPosition -= 22;
                contentStream.beginText();
                contentStream.setFont(textFont, 10);
                contentStream.newLineAtOffset(textLeftMargin, yPosition);
                contentStream.showText("E-posta: " + resume.getPersonalDetails().getEmail());
                contentStream.endText();

                yPosition -= 15;
                contentStream.beginText();
                contentStream.setFont(textFont, 10);
                contentStream.newLineAtOffset(textLeftMargin, yPosition);
                contentStream.showText("Telefon: " + resume.getPersonalDetails().getPhoneNumber());
                contentStream.endText();

                yPosition -= 15;
                contentStream.beginText();
                contentStream.setFont(textFont, 10);
                contentStream.newLineAtOffset(textLeftMargin, yPosition);
                contentStream.showText("Adres: " + resume.getPersonalDetails().getAddress());
                contentStream.endText();

                // Ayırıcı Çizgi (Fotoğrafın alt sınırının hemen altına yerleştirildi)
                yPosition = 630;
                contentStream.moveTo(50, yPosition);
                contentStream.lineTo(550, yPosition);
                contentStream.stroke();

                // 3. İş Deneyimleri Başlığı
                yPosition -= 25;
                contentStream.beginText();
                contentStream.setFont(subTitleFont, 13);
                contentStream.newLineAtOffset(50, yPosition);
                contentStream.showText("IS DENEYIMLERI");
                contentStream.endText();

                // Deneyimleri Dinamik Yazdırma
                for (Experience exp : resume.getExperiences()) {
                    yPosition -= 22;
                    contentStream.beginText();
                    contentStream.setFont(subTitleFont, 10);
                    contentStream.newLineAtOffset(50, yPosition);
                    contentStream.showText(exp.getRole() + " - " + exp.getCompanyName() + " (" + exp.getDuration() + ")");
                    contentStream.endText();

                    yPosition -= 14;
                    contentStream.beginText();
                    contentStream.setFont(textFont, 9);
                    contentStream.newLineAtOffset(60, yPosition);
                    contentStream.showText("- " + exp.getDescription());
                    contentStream.endText();
                }

                // Ayırıcı Çizgi
                yPosition -= 25;
                contentStream.moveTo(50, yPosition);
                contentStream.lineTo(550, yPosition);
                contentStream.stroke();

                // 4. Yetenekler Başlığı
                yPosition -= 25;
                contentStream.beginText();
                contentStream.setFont(subTitleFont, 13);
                contentStream.newLineAtOffset(50, yPosition);
                contentStream.showText("YETENEKLER");
                contentStream.endText();

                yPosition -= 20;
                contentStream.beginText();
                contentStream.setFont(textFont, 10);
                contentStream.newLineAtOffset(50, yPosition);
                contentStream.showText(String.join(" | ", resume.getSkills()));
                contentStream.endText();
            }

            document.save(outputPath);
            System.out.println("PDF basariyla olusturuldu: " + outputPath);

        } catch (IOException e) {
            System.err.println("PDF olusturulurken bir hata meydana geldi: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
