package r507.app.application.accessingdatamysql;
import org.springframework.data.repository.CrudRepository;

import r507.app.application.accessingdatamysql.LikeDislike;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface LikeDislikeRepository extends CrudRepository<LikeDislike, Integer> {

}