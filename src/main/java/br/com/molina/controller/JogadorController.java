package br.com.molina.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.molina.entity.Jogador;
import br.com.molina.repository.JogadorRepository;

@RestController
//@RequestMapping("/api/v1")
public class JogadorController {
	
	@Autowired
	private JogadorRepository jogadorRepository;
	
    @GetMapping("/jogadors")
    @RequestMapping(value = "jogadores", method = RequestMethod.GET)
    public List < Jogador > getAllJogadores() {
        return jogadorRepository.findAll();
    }

    @GetMapping("/jogadors/{id}")
    public ResponseEntity<Jogador> getJogadorById(@PathVariable(value = "id") Long jogadorId)
       throws ResourceNotFoundException  {
        Jogador jogador = jogadorRepository.findById(jogadorId)
            .orElseThrow(() -> new ResourceNotFoundException("Jogador not found for this id :: " + jogadorId));
        return ResponseEntity.ok().body(jogador);
    }

    @PostMapping("/jogadors")
    public Jogador createJogador(@Valid @RequestBody Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    @PutMapping("/jogadosr/{id}")
    public ResponseEntity <Jogador> updateJogador(@PathVariable(value = "id") Long jogadorId,
        @Valid @RequestBody Jogador jogadorDetails) throws ResourceNotFoundException {
    	Jogador jogador = jogadorRepository.findById(jogadorId)
            .orElseThrow(() -> new ResourceNotFoundException("jogador not found for this id :: " + jogadorId));

        jogador.setNome(jogadorDetails.getNome());
        final Jogador updatedJogador = jogadorRepository.save(jogador);
        return ResponseEntity.ok(updatedJogador);
    }

    @DeleteMapping("/jogadors/{id}")
    public Map < String, Boolean > deleteJogador(@PathVariable(value = "id") Long jogadorId)
    throws ResourceNotFoundException {
    	Jogador jogador = jogadorRepository.findById(jogadorId)
            .orElseThrow(() -> new ResourceNotFoundException("jogador não encontrado :: " + jogadorId));

        jogadorRepository.delete(jogador);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
