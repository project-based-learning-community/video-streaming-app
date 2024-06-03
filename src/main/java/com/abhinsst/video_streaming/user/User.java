
package com.abhinsst.video_streaming.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class User {

  private String username;
  private String email;
  private String password;
  private String status;
  private String age;
  private String gender;

}
