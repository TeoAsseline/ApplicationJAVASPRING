package r507.app.application.accessingdatamysql;

public class ModifyLikeDislike {
    private Integer id_auteur;
    private Integer id_article;
    private Integer like;

    public ModifyLikeDislike() {
    }

    public ModifyLikeDislike(Integer id_auteur, Integer id_article, Integer like) {
        this.id_article=id_article;
        this.id_auteur=id_auteur;
        this.like=like;
    }

    public int getId_auteur() {
        return this.id_auteur;
    }
    public int getId_article() {
        return this.id_article;
    }
    public int getLike() {
        return this.like;
    }
    public void setLike(Integer like) {
        this.like = like;
    }
}
