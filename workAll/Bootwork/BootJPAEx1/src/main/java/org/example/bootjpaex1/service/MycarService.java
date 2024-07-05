package org.example.bootjpaex1.service;

import lombok.RequiredArgsConstructor;
import org.example.bootjpaex1.data.MycarDto;
import org.example.bootjpaex1.repository.MyCarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MycarService {
    private final MyCarRepository myCarRepository;

    public void updateCar(MycarDto mycarDto){
        if (mycarDto.getPhoto().equals("no")){
//            myCarRepository.updateMycarNoPhoto(mycarDto.getId(), mycarDto.getName(), mycarDto.getPrice(), mycarDto.getColor());
            myCarRepository.updateMycarNoPhoto(mycarDto);
        } else {
            myCarRepository.save(mycarDto);
        }
    }

    public Page<MycarDto> findAllCars(Pageable pageable){
        return myCarRepository.findAll(pageable);
    }
}
