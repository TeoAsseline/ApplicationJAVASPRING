package r507.app.application.accessingdatamysql;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="like_dislike")
class LikeDislike {

    @EmbeddedId
    LikeDislikeKey id;

    @ManyToOne
    @MapsId("articleId")
    @JoinColumn(name = "article_id")
    Article article;

    @ManyToOne
    @MapsId("auteurId")
    @JoinColumn(name = "auteur_id")
    Auteur auteur;

    int likedislike;
    
    // standard constructors, getters, and setters
    // hashcode and equals implementation
    public LikeDislike() {
    }
    public 
    LikeDislike(Integer article, Integer auteur, int i) {
        this.id=new LikeDislikeKey(article,auteur);
        this.likedislike=i;
    }
    public LikeDislike(Integer article, Integer auteur) {
        this.id=new LikeDislikeKey(article,auteur);
    }
    public Integer getArticleId() {
        return this.article.getId();
    }
    public Integer getAuteurId() {
        return this.auteur.getId();
    }
    public Integer getLikeDislike() {
        return this.likedislike;
    }
    public void setLikeDislike(Integer likedislike) {
        this.likedislike=likedislike;
    }
    public void setArticle(Article article) {
        this.article=article;
    }
    public void setAuteur(Auteur auteur) {
        this.auteur=auteur;
    }
}