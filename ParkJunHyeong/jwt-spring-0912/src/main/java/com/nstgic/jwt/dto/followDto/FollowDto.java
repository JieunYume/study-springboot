package com.nstgic.jwt.dto.followDto;


import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FollowDto {
    Long userId;
    String userName;
}
