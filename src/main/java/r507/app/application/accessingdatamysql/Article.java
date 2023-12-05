package r507.app.application.accessingdatamysql;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity // This tells Hibernate to make a table out of this class
public class Article {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)

  private Integer id;
  private String titre;
  private Date date_publication;
  private String contenu;

  public Article() {}

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitre() {
    return titre;
  }
  public void setTitre(String titre) {
    this.titre = titre;
  }

  public Date getDatePublication() {
    return date_publication;
  }
  public void setDatePublication() {
    this.date_publication= new Date();
  }

  public String getContenu() {
    return contenu;
  }
  public void setContenu(String contenu) {
    this.contenu = contenu;
  }

  @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "auteur", referencedColumnName = "id")
    private Auteur auteur;

  public Article(Auteur auteur) {
      this.auteur = auteur;
  }

  public Auteur getAuteur() {
      return auteur;
  }

  public void setAuteur(Auteur auteur) {
      this.auteur = auteur;
  }
}