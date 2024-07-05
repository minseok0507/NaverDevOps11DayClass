package org.example.bootjpaex1.service;

import lombok.RequiredArgsConstructor;
import org.example.bootjpaex1.repository.MyCarCommentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyCarCommentService {
    private final MyCarCommentRepository myCarCommentRepository;

}
