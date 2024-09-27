package com.nstgic.jwt.dto.followDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FollowAddResponseDto {
    String followerName;
    String followingName;

}
