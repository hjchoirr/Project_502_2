package org.choongang.member.controllers;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestLogin {
    private String userId;
    private String userPw;


}
