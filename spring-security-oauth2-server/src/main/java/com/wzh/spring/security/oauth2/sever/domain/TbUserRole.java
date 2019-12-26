package com.wzh.spring.security.oauth2.sever.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
@author wzh
@date 2019/12/26 - 15:38
*/
@Data
@Table(name = "tb_user_role")
public class TbUserRole implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 用户 ID
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 角色 ID
     */
    @Column(name = "role_id")
    private Long roleId;

    private static final long serialVersionUID = 1L;
}