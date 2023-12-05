package r507.app.application.accessingdatamysql;

public class ModifyAuteur {
    private String name;
    private String mdp;
    private String role;
    private Integer id;

    public ModifyAuteur() {
    }

    public ModifyAuteur(Integer id,String name, String mdp, String role) {
        this.id=id;
        this.name = name;
        this.mdp = mdp;
        this.role = role;
    }

    public String getName() {
        return this.name;
    }

    public String getMdp() {
        return this.mdp;
    }

    public String getRole() {
        return this.role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return this.id;
    }
    
}
