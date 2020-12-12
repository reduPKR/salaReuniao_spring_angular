package com.sala_reuniao.salaDeReuniao.controller;

import com.sala_reuniao.salaDeReuniao.exception.ResourceNotFoundException;
import com.sala_reuniao.salaDeReuniao.model.Room;
import com.sala_reuniao.salaDeReuniao.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController @CrossOrigin("http://localhost:8080")
@RequestMapping("/api/v1")
public class RoomController {
    @Autowired
    private RoomRepository repository;

    @GetMapping("/rooms")
    public List<Room> findAll(){
        return repository.findAll();
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getById(@PathVariable long id) throws ResourceNotFoundException {
        Room room = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sala não encontrada: "+id));
        return ResponseEntity.ok().body(room);
    }

    @PostMapping("/rooms")
    public Room create(@Valid @RequestBody Room room){
        return repository.save(room);
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> update(@PathVariable long id, @Valid @RequestBody Room room_put) throws ResourceNotFoundException {
        Room room = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sala não encontrada: "+id));

        room.setName(room_put.getName());
        room.setDate(room_put.getDate());
        room.setStartHour(room_put.getStartHour());
        room.setEndHour(room_put.getEndHour());

        final Room updated_room = repository.save(room);
        return ResponseEntity.ok().body(updated_room);
    }

    @DeleteMapping("/rooms/{id}")
    public Map<String,Boolean> delete(@PathVariable long id) throws ResourceNotFoundException {
        Room room = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sala não encontrada: "+id));

        repository.delete(room);
        Map<String,Boolean>  map = new HashMap();
        map.put("deleted",true);
        return map;
    }

}
