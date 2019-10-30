package com.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Associado;
import com.entities.ResponseModel;
import com.repository.AssociadoRepository;

@CrossOrigin
@RestController
@RequestMapping("/associados")
public class AssociadoService {

	@Autowired
	private AssociadoRepository associadoRepository;
	
	@Transactional
	@PostMapping
	public @ResponseBody ResponseModel save (@RequestBody Associado associado){
	       try {
	            this.associadoRepository.save(associado);
	            return new ResponseModel(1, "Registro com sucesso");
	       } catch (Exception e) {
	            return new ResponseModel(0, e.getMessage());
	       }
	}
	
	@PutMapping
    public @ResponseBody
    ResponseModel update (@RequestBody Associado associado) {
        try {
            this.associadoRepository.save(associado);
            return new ResponseModel(1 , "Registro atualizado com sucesso");
        } catch (Exception e) {
            return new ResponseModel(0 ,e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseModel delete (@PathVariable("id") Long id) {
        try {
            this.associadoRepository.deleteById(id);
            return new ResponseModel(1 , "Registro excluido com sucesso");
        } catch (Exception e) {
            return new ResponseModel(0, e.getMessage());
        }
    }
    
    @GetMapping
    public @ResponseBody
    List<Associado> findAll(){
        return this.associadoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Associado> findById (@PathVariable("id") Long id){
        Optional<Associado> associado = this.associadoRepository.findById(id);

        if(associado == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(associado.get());
        }
    }

}
