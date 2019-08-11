package top.zoick.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zoick
 * @date 2019/8/7 21:31
 */
@Getter
@Setter
@ToString
public class Account implements Serializable {

    private Integer id;
    private String name;
    private Float money;

}
