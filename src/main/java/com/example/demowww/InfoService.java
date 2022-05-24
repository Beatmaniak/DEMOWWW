package com.example.demowww;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InfoService {
    @Autowired
    private InfoRepository repo;

    public List<Info> listAll(){
        return repo.findAll();
    }
    public void save(Info info){
        repo.save(info);
    }
    public Info get(Long id){
        return repo.findById(id).get();
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
}
