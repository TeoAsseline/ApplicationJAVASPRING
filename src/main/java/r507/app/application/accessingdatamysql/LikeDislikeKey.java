package r507.app.application.accessingdatamysql;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
class LikeDislikeKey implements Serializable {
    @Column(name = "article_id")
    Integer articleId;
    @Column(name = "auteur_id")
    Integer auteurId;
    // standard constructors, getters, and setters
    // hashcode and equals implementation
    public LikeDislikeKey() {
    }
    public LikeDislikeKey(Integer i, Integer j) {
        this.articleId=i;
        this.auteurId=j;
    }
    public Integer getArticleId() {
        return this.articleId;
    }
    public Integer getAuteurId() {
        return this.auteurId;
    }
}
