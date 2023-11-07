package com.dto.springbootdto.service;


import com.dto.springbootdto.dto.UserLocationDTO;
import com.dto.springbootdto.model.User;
import com.dto.springbootdto.repo.UserRepository;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserLocationDTO> getAllUserLocation() {
        return userRepository.findAll()
                .stream()
                .map(this::convertEntityTODto)
                .collect(Collectors.toList());
    }


        private UserLocationDTO convertEntityTODto(User user){
        UserLocationDTO userLocationDTO = new UserLocationDTO();

        userLocationDTO.setUserId(user.getId());
        userLocationDTO.setEmail(user.getEmail());
        userLocationDTO.setPlace(user.getLocation().getPlace());
        userLocationDTO.setLongitude(user.getLocation().getLongitude());
        userLocationDTO.setLatitude(user.getLocation().getLatitude());
        return userLocationDTO;
    }



}

//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    public List<UserLocationDTO> getAllUsersLocation(){
//        return userRepository.findAll()
//                .stream()
//                .map(this::convertEntityToDto)
//                .collect(Collectors.toList());
//
//    }
//
////    private UserLocationDTO convertEntityToDto(User user){
////        UserLocationDTO userLocationDTO = new UserLocationDTO();
////        userLocationDTO.setUserId(user.getId());
////        userLocationDTO.setEmail(user.getEmail());
////        userLocationDTO.setPlace(user.getLocation().getPlace());
////        userLocationDTO.setLongitude(user.getLocation().getLongitude());
////        userLocationDTO.setLatitude(user.getLocation().getLatitude());
////        return userLocationDTO;
////    }
//
//    private UserLocationDTO convertEntityToDto(User user){
//        modelMapper.getConfiguration()
//                .setMatchingStrategy(MatchingStrategies.LOOSE);
//        UserLocationDTO userLocationDTO = new UserLocationDTO();
//        userLocationDTO = modelMapper.map(user, UserLocationDTO.class);
//        return userLocationDTO;
//    }
//
//    private User convertDtoToEntity(UserLocationDTO userLocationDTO){
//        modelMapper.getConfiguration()
//                .setMatchingStrategy(MatchingStrategies.LOOSE);
//        User user = new User();
//        user = modelMapper.map(userLocationDTO, User.class);
//        return user;
//    }
//}