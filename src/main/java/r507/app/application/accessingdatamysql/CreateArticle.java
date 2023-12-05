package r507.app.application.accessingdatamysql;

public class CreateArticle {
    
    private String titre;
    private String contenu;
    private Integer auteur;

    public CreateArticle() {
    }
    public CreateArticle(String titre, String contenu, Integer auteur) {
        this.titre = titre;
        this.contenu = contenu;
        this.auteur = auteur;
    }
    public String getTitre() {
        return this.titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getContenu() {
        return this.contenu;
    }
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    public Integer getAuteur() {
        return this.auteur;
    }
    public void setAuteur(Integer auteur) {
        this.auteur = auteur;
    }
}
