package com.tj.spring.learn.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author tangj
 * @since 2019/1/23 10:33
 */
@Data
@Entity
public class Owner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "wx_account")
    private String wxAccount;

    @Column(name = "wx_nickname")
    private String wxNickname;

    @Column(name = "province")
    private String province;

    @Column(name = "city")
    private String city;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "open_id")
    private String openId;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "phone")
    private String phone;

    @Column(name = "status")
    private Integer status;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "creator")
    private String creator;

    @Column(name = "updater")
    private String updater;
}
