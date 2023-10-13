package dto;

import lombok.*;

import java.util.stream.DoubleStream;


@Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder

    public class ValidUserRequest {

        private String full_name;
        private String email;
        private String password;
        private boolean generate_magic_link;
    }

