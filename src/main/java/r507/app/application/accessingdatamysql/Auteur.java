package r507.app.application.accessingdatamysql;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Auteur {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)

  private Integer id;
  private String name;
  private String mdp;
  private String role;

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getMdp() {
    return mdp;
  }
  public void setMdp(String mdp) {
    this.mdp = mdp;
  }

  public String getRole() {
    return role;
  }
  public void setRole(String role) {
    this.role = role;
  }
}