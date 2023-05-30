package rikkei.academy.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(max = 800,  message = "không vượt quá 800 kí tự")
    @Pattern(regexp = "^[^@;,.=+-]*$",message = "không chứa các kí tự đặc biệt")
    private String songName;
    @NotEmpty
    @Size(max = 300,  message = "không vượt quá 300 kí tự")
    @Pattern(regexp = "^[^@;,.=+-]*$",message = "không chứa các kí tự đặc biệt")
    private String artist;
    @NotEmpty
    @Size(max = 1000,  message = "không vượt quá 1000 kí tự")
    @Pattern(regexp = "^[^@;.=+-]*$",message = "không chứa các kí tự đặc biệt ngoại trừ dấu ,")
    private String kindOfMusic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public Song() {
    }

    public Song(Long id, String songName, String artist, String kindOfMusic) {
        this.id = id;
        this.songName = songName;
        this.artist = artist;
        this.kindOfMusic = kindOfMusic;
    }
}
