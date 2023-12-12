package r507.app.application.accessingdatamysql;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
import org.springframework.data.repository.query.Param;

public interface LikeDislikeRepository extends JpaRepository<LikeDislike, LikeDislikeKey> {
// JPA
@Query("FROM LikeDislike l WHERE l.article.id = :articleId AND l.auteur.id = :auteurId")
public Optional<LikeDislike> RechercherUnLikeDislike(@Param("articleId") Integer articleId,@Param("auteurId") Integer auteurId);

@Query("SELECT count(l) FROM LikeDislike l WHERE l.article.id = :articleId AND l.likedislike = '1'")
public Integer RechercherNombreLike(@Param("articleId") Integer articleId);

@Query("SELECT count(l) FROM LikeDislike l WHERE l.article.id = :articleId AND l.likedislike = '0'")
public Integer RechercherNombreDislike(@Param("articleId") Integer articleId);

@Query("SELECT l.auteur.name FROM LikeDislike l WHERE l.article.id = :articleId AND l.likedislike = '1'")
public String RechercherAuteurLike(@Param("articleId") Integer articleId);

@Query("SELECT l.auteur.name FROM LikeDislike l WHERE l.article.id = :articleId AND l.likedislike = '0'")
public String RechercherAuteurDislike(@Param("articleId") Integer articleId);
}