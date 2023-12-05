package r507.app.application.accessingdatamysql;

public class ModifyArticle {
    
    private String titre;
    private String contenu;
    private Integer auteur;
    private Integer id;

    public ModifyArticle() {
    }
    public ModifyArticle(Integer id,String titre, String contenu, Integer auteur) {
        this.id=id;
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
    public int getId() {
        return this.id;
    }
}
