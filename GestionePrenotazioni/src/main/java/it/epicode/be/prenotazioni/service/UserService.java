package it.epicode.be.prenotazioni.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be.prenotazioni.common.exception.PrenotazioneException;
import it.epicode.be.prenotazioni.model.User;
import it.epicode.be.prenotazioni.payloads.UserRegistrationPayload;
import it.epicode.be.prenotazioni.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public Optional<User> findById(UUID id) {
		return userRepository.findById(id);
	}

	public Page<User> findByNome(String nome, Pageable pageable) {
		return userRepository.findByNome(nome, pageable);
	}

	public Optional<User> findByUsername(String nome) {
		return userRepository.findByUsername(nome);
	}

	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public User update(UUID id, User user) {
		Optional<User> userResult = userRepository.findById(id);

		if (userResult.isPresent()) {
			User userUpdate = userResult.get();
			userUpdate.setNome(user.getNome());
			userRepository.save(userUpdate);
			return userUpdate;
		} else {
			throw new PrenotazioneException("Elemento non aggiornato");
		}

	}

	public void delete(UUID id) {
		userRepository.deleteById(id);
	}

	public User findByIdAndUpdate(UUID userId, User body) {
		// TODO Auto-generated method stub
		return null;
	}

	public void findByIdAndDelete(UUID userId) {
		// TODO Auto-generated method stub

	}

	public Page<User> find(int page, int size, String sortBy) {
		// TODO Auto-generated method stub
		return null;
	}

	public User create(UserRegistrationPayload body) {
		// TODO Auto-generated method stub
		return null;
	}

}
