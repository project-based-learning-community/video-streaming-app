package com.abhinsst.video_streaming;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.abhinsst.video_streaming.service.UserService;

@SpringBootApplication
public class VideoStreamingApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoStreamingApplication.class, args);

		@Bean
		public CommandLineRunner CommandLineRunner(UserService service){
			return args-> {
				Service.register(User.builder().username("abhishek").email("abhishek@gmail.com").password("prince@").build());

				Service.register(User.builder().username("anand").email("anand@gmail.com").password("prince@").build());

				Service.register(User.builder().username("prince").email("prince@gmail.com").password("prince@").build());
			}
		}
	}

}
