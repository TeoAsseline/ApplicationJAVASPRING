package r507.app.application.accessingdatamysql;

public class DeleteLikeDislike {

    private Integer id_auteur;
    private Integer id_article;

    public DeleteLikeDislike() {
    }

    public DeleteLikeDislike(Integer id_auteur, Integer id_article) {
        this.id_article=id_article;
        this.id_auteur=id_auteur;
    }

    public int getId_auteur() {
        return this.id_auteur;
    }
    public int getId_article() {
        return this.id_article;
    }
}

