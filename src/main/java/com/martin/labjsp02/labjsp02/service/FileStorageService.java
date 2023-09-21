package com.martin.labjsp02.labjsp02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Service
public class FileStorageService {

    private final Path fileStorageLocation = Paths.get("src/main/resources/static/uploads/").toAbsolutePath().normalize();



    public FileStorageService() {

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public String storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Vérifiez si le nom du fichier contient des caractères invalides
            if (fileName.contains("..")) {
                throw new FileStorageException("Désolé! Le nom du fichier contient une séquence de chemin invalide " + fileName);
            }

            // Copiez le fichier à l'emplacement cible (en remplaçant le fichier existant avec le même nom)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            // Construisez le chemin correct ici
            // Notez que nous ajoutons simplement le nom du fichier au chemin d'accès du dossier de téléchargement
            String fileDownloadUri = "/uploads/" + fileName;

            return fileDownloadUri;
        } catch (IOException ex) {
            throw new FileStorageException("Impossible de stocker le fichier " + fileName + ". Veuillez réessayer!", ex);
        }

    }


    public class FileStorageException extends RuntimeException {
        public FileStorageException(String message) {
            super(message);
        }

        public FileStorageException(String message, Throwable cause) {
            super(message, cause);
        }
    }

}
