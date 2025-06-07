package crode.Builder;

import crode.Composite.Directory;
import crode.Leaf.File;

public class FileSystemBuilder {

    public static Directory createSampleFileSystem() {

        // Root directory
        Directory root = new Directory("root");

        // Documents folder
        Directory documents = new Directory("Documents");
        documents.add(new File("resume.pdf", 245760, "PDF"));
        documents.add(new File("presentation.pptx", 1024000, "PowerPoint"));
        documents.add(new File("notes.txt", 2048, "Text"));

        // Photos folder
        Directory photos = new Directory("Photos");
        photos.add(new File("vacation1.jpg", 2048000, "JPEG"));
        photos.add(new File("vacation2.jpg", 1536000, "JPEG"));

        Directory familyPhotos = new Directory("Family");
        familyPhotos.add(new File("wedding.jpg", 3072000, "JPEG"));
        familyPhotos.add(new File("birthday.jpg", 2560000, "JPEG"));
        photos.add(familyPhotos);

        // Music folder
        Directory music = new Directory("Music");
        music.add(new File("song1.mp3", 4096000, "MP3"));
        music.add(new File("song2.mp3", 3584000, "MP3"));

        Directory rock = new Directory("Rock");
        rock.add(new File("rock_song1.mp3", 4608000, "MP3"));
        rock.add(new File("rock_song2.mp3", 4096000, "MP3"));
        music.add(rock);

        // Add to root
        root.add(documents);
        root.add(photos);
        root.add(music);
        root.add(new File("system.log", 1024, "Log"));

        return root;
    }
}
