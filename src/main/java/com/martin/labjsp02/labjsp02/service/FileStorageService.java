package com.martin.labjsp02.labjsp02.service;

import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class FileStorageService {

    private final Path fileStorageLocation = Paths.get("src/main/resources/static/uploads/").toAbsolutePath().normalize();

    public String storeFile(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new Exception("Failed to store empty file.");
            }

            // Créer le répertoire s'il n'existe pas
            Files.createDirectories(fileStorageLocation);

            // Copier le fichier dans le répertoire de stockage
            Path targetLocation = fileStorageLocation.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), targetLocation);

            return targetLocation.toString();
        } catch (Exception ex) {
            throw new RuntimeException("Could not store file. Please try again.", ex);
        }
    }

    // Méthode pour charger un fichier (non implémentée dans cet exemple)
    public Resource loadFileAsResource(String fileName) throws IOException {
        try {
            Path filePath = fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new IOException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new IOException("File not found " + fileName, ex);
        }
    }
}
