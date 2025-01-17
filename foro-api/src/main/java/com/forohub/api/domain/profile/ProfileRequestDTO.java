package com.forohub.api.domain.profile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record ProfileRequestDTO(
        @NotBlank @Valid Role roleName
) { }