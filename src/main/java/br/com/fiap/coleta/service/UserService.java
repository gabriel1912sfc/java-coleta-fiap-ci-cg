package br.com.fiap.coleta.service;

import br.com.fiap.coleta.dto.UserCreateDTO;
import br.com.fiap.coleta.dto.UserExhibitionDTO;
import br.com.fiap.coleta.exceptions.UserNotFoundException;
import br.com.fiap.coleta.model.User;
import br.com.fiap.coleta.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserExhibitionDTO save(UserCreateDTO userCreateDTO) {

        User user = new User();
        BeanUtils.copyProperties(userCreateDTO, user);

        User createdUser = userRepository.save(user);
        return new UserExhibitionDTO(createdUser);

    }

    public UserExhibitionDTO findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            return new UserExhibitionDTO(userOptional.get());
        } else {
            throw new UserNotFoundException("Usuário não existe!");
        }
    }

    public List<UserExhibitionDTO> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(UserExhibitionDTO::new)
                .toList();
    }

    public void deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
        } else {
            throw new UserNotFoundException("Usuário não encontrado!");
        }
    }

    public UserExhibitionDTO updateUser(Long id, UserCreateDTO userCreateDTO) {
        Optional<User> userOptional = this.userRepository.findById(id);


        if (userOptional.isPresent()) {
            User user = userOptional.get();
            BeanUtils.copyProperties(userCreateDTO, user);
            User updatedUser = userRepository.save(user);
            return new UserExhibitionDTO(updatedUser);
        } else {
            throw new UserNotFoundException("Usuário não encontrado!");
        }

    }

}
