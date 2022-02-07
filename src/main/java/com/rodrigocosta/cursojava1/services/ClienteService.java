package com.rodrigocosta.cursojava1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.rodrigocosta.cursojava1.domain.Cliente;
import com.rodrigocosta.cursojava1.dto.ClienteDTO;
import com.rodrigocosta.cursojava1.repositories.ClienteRepository;
import com.rodrigocosta.cursojava1.services.exceptions.DataIntegrityException;
import com.rodrigocosta.cursojava1.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente update(Cliente obj) {
		find(obj.getId());
		return clienteRepository.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			clienteRepository.deleteById(id);
		}
		catch (DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos!");
		}
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return clienteRepository.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
		throw new UnsupportedOperationException();
	}
}
