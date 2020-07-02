package com.example.demo.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author dengzhiwen <dengzhiwen@kuaishou.com>
 * Created on 2020-07-02
 */

@Getter
@Setter
@ToString
public class PicturesBo {

    private String type;
    private MultipartFile[] pictures;
    private String token;
}
