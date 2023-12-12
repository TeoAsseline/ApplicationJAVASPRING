package r507.app.application.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller // This means that this class is a Controller
@RequestMapping(path="/article") // This means URL's start with /demo (after Application path)
public class ArticleController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private ArticleRepository articleRepository;
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private AuteurRepository auteurRepository;
  @Autowired
  private LikeDislikeRepository likeDislikeRepository;

  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewArticle (@RequestBody CreateArticle createArticle) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
    Article n = new Article(auteurRepository.findById(createArticle.getAuteur()).get());
    n.setTitre(createArticle.getTitre());
    n.setContenu(createArticle.getContenu());
    n.setDatePublication();
    articleRepository.save(n);
    return "Saved";
  }

  @PostMapping(path="/like/{idarticle}/{idauteur}")
  public @ResponseBody String addLikeArticle(@PathVariable Integer idarticle,@PathVariable Integer idauteur){
    if(likeDislikeRepository.RechercherUnLikeDislike(idarticle,idauteur).isPresent()){
      return "Already liked/disliked";
    }
    LikeDislike like= new LikeDislike(idarticle,idauteur,1);
    like.setArticle(articleRepository.findById(idarticle).get());
    like.setAuteur(auteurRepository.findById(idauteur).get());
    likeDislikeRepository.save(like);
    return "Like added";
  }

  @PostMapping(path="/dislike/{idarticle}/{idauteur}")
  public @ResponseBody String addDislikeArticle(@PathVariable Integer idarticle,@PathVariable Integer idauteur){
    if(likeDislikeRepository.RechercherUnLikeDislike(idarticle,idauteur).isPresent()){
      return "Already liked/disliked";
    }
    LikeDislike like= new LikeDislike(idarticle,idauteur,0);
    like.setArticle(articleRepository.findById(idarticle).get());
    like.setAuteur(auteurRepository.findById(idauteur).get());
    likeDislikeRepository.save(like);
    return "Dislike added";
  }

  @PutMapping(path="/modifylike/{idarticle}/{idauteur}")
  public @ResponseBody String modifyLikeArticle(@PathVariable Integer idarticle,@PathVariable Integer idauteur){
    int i;
    if(!likeDislikeRepository.RechercherUnLikeDislike(idarticle,idauteur).isPresent()){
      return "Not liked/disliked existing";
    }
    LikeDislike modifylikedislike=likeDislikeRepository.RechercherUnLikeDislike(idarticle,idauteur).get();
    if(modifylikedislike.getLikeDislike()==1){
      i=0;
    }else{
      i=1;
    }
    modifylikedislike.setLikeDislike(i);
    likeDislikeRepository.save(modifylikedislike);
    return "Like/Dislike modified";
  }

  @DeleteMapping(path="/deletelike/{idarticle}/{idauteur}")
  public @ResponseBody String deleteLikeArticle(@PathVariable Integer idarticle,@PathVariable Integer idauteur){
    if(!likeDislikeRepository.RechercherUnLikeDislike(idarticle,idauteur).isPresent()){
      return "Not liked/disliked existing";
    }
    LikeDislike likedislike=likeDislikeRepository.RechercherUnLikeDislike(idarticle,idauteur).get();
    likeDislikeRepository.delete(likedislike);
    return "Like/Dislike deleted";
  }

  @PutMapping(path="/modify/{id}") // Map ONLY POST Requests
  public @ResponseBody String modifyArticle (@PathVariable Integer id,@RequestBody ModifyArticle modifyArticle) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
    if(articleRepository.findById(id).get()==null){
      return "No article";
    }
    Article n = articleRepository.findById(id).get();
    if(modifyArticle.getTitre()!=null){
      n.setTitre(modifyArticle.getTitre());
    }
    if(modifyArticle.getContenu()!=null){
      n.setContenu(modifyArticle.getContenu());
    }
    articleRepository.save(n);
    return "Modified";
  }

  @DeleteMapping(path="/delete/{id}") // Map ONLY POST Requests
  public @ResponseBody String deleteArticle (@PathVariable Integer id) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
    if(articleRepository.findById(id).get()==null){
      return "No article";
    }
    Article n = articleRepository.findById(id).get();
    n.setAuteur(null);
    articleRepository.delete(n);
    return "Deleted";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Article> getAllArticles() {
    // This returns a JSON or XML with the users
    //Si le role est moderator
    //return articleRepository.findAll();
    //Si le role est publisher
    //return articleRepository.findAll();
    //Si le role est inconnu
    return articleRepository.findAll();
  }

  @GetMapping(path="/all/{id}")
  public @ResponseBody Article getArticle(@PathVariable Integer id) {
    // This returns a JSON or XML with the users
    return articleRepository.findById(id).get();
  }

  @GetMapping(path="/all/{id}/like")
  public @ResponseBody String getArticleLike(@PathVariable Integer id) {
    // This returns a JSON or XML with the users
    return likeDislikeRepository.RechercherAuteurLike(id);
  }

  @GetMapping(path="/all/{id}/dislike")
  public @ResponseBody String getArticleDislike(@PathVariable Integer id) {
    // This returns a JSON or XML with the users
    return likeDislikeRepository.RechercherAuteurDislike(id);
  }

  @GetMapping(path="/all/{id}/nblike")
  public @ResponseBody Integer getArticleNbLike(@PathVariable Integer id) {
    // This returns a JSON or XML with the users
    return likeDislikeRepository.RechercherNombreLike(id);
  }

  @GetMapping(path="/all/{id}/nbdislike")
  public @ResponseBody Integer getArticleNbDislike(@PathVariable Integer id) {
    // This returns a JSON or XML with the users
    return likeDislikeRepository.RechercherNombreDislike(id);
  }
  
}