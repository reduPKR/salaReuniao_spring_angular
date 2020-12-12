package com.sala_reuniao.salaDeReuniao.repository;

import com.sala_reuniao.salaDeReuniao.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
