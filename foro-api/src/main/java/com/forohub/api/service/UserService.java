package com.forohub.api.service;

import com.forohub.api.domain.user.User;
import com.forohub.api.domain.user.UserRepository;
import com.forohub.api.domain.user.UserRequestDTO;
import com.forohub.api.domain.user.UserResponseDTO;
import com.forohub.api.domain.profile.Profile;
import com.forohub.api.domain.profile.ProfileRepository;
import com.forohub.api.domain.profile.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final ProfileRepository profileRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, ProfileRepository profileRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDTO registerUser(UserRequestDTO userRequest) {
        // Convierte los nombres de perfiles en entidades utilizando Role.valueOf
        List<Profile> profiles = userRequest.profiles().stream()
                .map(role -> {
                    // Intenta encontrar el perfil por el rol en la base de datos
                    Profile profile = profileRepository.findByRole(Role.valueOf(role.toUpperCase()));

                    // Si no existe, crea un nuevo perfil
                    if (profile == null) {
                        profile = new Profile(Role.valueOf(role.toUpperCase()));
                    }

                    return profile;
                })
                .collect(Collectors.toList());

        // Cifra la contraseña antes de guardarla
        String encryptedPassword = passwordEncoder.encode(userRequest.password());

        // Asigna los perfiles al usuario y guarda el usuario con la contraseña cifrada
        User user = new User(userRequest);
        user.setPassword(encryptedPassword);
        user.setProfiles(profiles);

        // Guarda el usuario (y los perfiles si no existen gracias a CascadeType.ALL)
        userRepository.save(user);

        // Retorna el DTO de respuesta
        return new UserResponseDTO(user);
    }
}
