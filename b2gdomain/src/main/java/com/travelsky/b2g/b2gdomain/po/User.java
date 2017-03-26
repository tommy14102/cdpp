package com.travelsky.b2g.b2gdomain.po;



import javax.persistence.*;

/**
 * Created by tommy14101 on 2017/3/23.
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    private StateEnum userState;//状态


    public User() {}
    public User(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StateEnum getUserState() {
        return userState;
    }

    public void setUserState(StateEnum userState) {
        this.userState = userState;
    }


public   enum StateEnum {
    NORMAL, DELETE;

    public String getLabel() {
        switch (this) {
            case NORMAL:
                return "正常";
            case DELETE:
                return "删除";
        }
        return null;
    }
}
}