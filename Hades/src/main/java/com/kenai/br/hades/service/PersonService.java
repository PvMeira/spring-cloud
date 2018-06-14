package com.kenai.br.hades.service;

import com.kenai.br.hades.model.Person;
import com.kenai.br.hades.model.domain.StatusType;
import com.kenai.br.hades.model.dto.PersonDTO;
import com.kenai.br.hades.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService extends AbstractService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * Find a Person by theirs email
     * @param email
     * @return Optional
     */
    public Optional<Person> findByUsername(String email) {
        return this.personRepository.findByEmail(email);
    }

    /**
     * Basic Save Method for a Person
     * @param personDTO
     * @return PersonDTO that was save
     */
    public PersonDTO save(PersonDTO personDTO) {
        return this.map(this.personRepository
                            .save(this.map(personDTO,Person.class)),PersonDTO.class);
    }

    /**
     * Basic Update Method for a Person
     * @param personDTO
     * @return PersonDTO that was updated
     */
    public PersonDTO update(PersonDTO personDTO) {
        return this.map(this.personRepository
                            .save(this.map(personDTO,Person.class)),PersonDTO.class);
    }

    /**
     * Basic Logical Remove Method for a Person
     * @param id of the Person
     */
    public void remove(Long id) {
        Person person = this.personRepository.findOne(id);
        if (null != person) {
            this.personRepository.save(person.withStatus(StatusType.INACTIVE));
        }
    }

    /**
     * Basic FindById Method for a Person
     * @param id
     * @return PersonDTO
     */
    public PersonDTO findById(Long id) {
        return this.map(this.personRepository.findOne(id),PersonDTO.class);
    }

    /**
     * Basic ListAll Method for Person
     * @return
     */
    public List<PersonDTO> listAll() {
        List<Person> target = new ArrayList<>();
        this.personRepository.findAll().forEach(target::add);
        return this.map(target,PersonDTO.class);
    }

}
