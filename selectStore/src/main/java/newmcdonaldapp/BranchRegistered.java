package newmcdonaldapp;

public class BranchRegistered extends AbstractEvent {

    private Long id;

    public BranchRegistered(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
