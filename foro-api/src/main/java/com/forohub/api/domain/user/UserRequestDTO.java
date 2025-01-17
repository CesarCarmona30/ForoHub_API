package com.forohub.api.domain.user;

import com.forohub.api.domain.profile.Profile;
import com.forohub.api.domain.profile.ProfileRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record UserRequestDTO(
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank String password,
        @NotEmpty @Valid List<String> profiles
) { }