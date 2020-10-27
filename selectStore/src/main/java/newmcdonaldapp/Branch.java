package newmcdonaldapp;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Branch_table")
public class Branch {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @PrePersist
    public void onPrePersist(){
        BranchRegistered branchRegistered = new BranchRegistered();
        BeanUtils.copyProperties(this, branchRegistered);
        branchRegistered.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        newmcdonaldapp.external.Order order = new newmcdonaldapp.external.Order();
        // mappings goes here
        SelectStoreApplication.applicationContext.getBean(newmcdonaldapp.external.OrderService.class)
            .orderBranchReg(order);


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




}
