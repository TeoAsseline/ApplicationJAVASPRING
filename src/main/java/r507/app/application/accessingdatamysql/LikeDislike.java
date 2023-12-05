package r507.app.application.accessingdatamysql;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
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
    public LikeDislike(Integer integer, Integer integer2, int i) {
        this.id=new LikeDislikeKey(integer,integer2);
        this.likedislike=i;
    }
    public LikeDislike(Integer integer, Integer integer2) {
        this.id=new LikeDislikeKey(integer,integer2);
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
}