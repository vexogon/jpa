package com.mattcoding.jpa;

import com.github.javafaker.Faker;
import com.mattcoding.jpa.models.Author;
import com.mattcoding.jpa.models.Video;
import com.mattcoding.jpa.repositories.AuthorRepository;
import com.mattcoding.jpa.repositories.videoRepository;
import com.mattcoding.jpa.specification.AuthSpecification;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import static com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer.Vanilla.std;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository repository,
			videoRepository videoRepository
	) {
		return args -> {
			for(int i =0; i < 50; i++) {
				Faker faker = new Faker();
				Author author = Author.builder().firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(19, 50))
						.email(faker.name().username() + "@gmail.com")
						.build();
				repository.save(author);

			}
				//Update author with ID = 1

				Author authorOne = Author.builder()
						.id(1)
						.firstName("matt")
						.lastName("butler")
						.age(19)
						.email("mattbutler0001@mail.com")
						.build();
			//repository.save(authorOne);

			//Changing the age using custom query SQL
			//repository.updateAuthor(24,1);

			//Update all authors using custom SQL query
			//repository.updateAllAUthors(99);
//
//			repository.findByNamedQuery(30).forEach(System.out::println);
//
//			repository.updateByNamedQuery(12);


			Specification<Author> spec = Specification
					.where(AuthSpecification.hasAge(34)
					.or(AuthSpecification.firstnameContains("Matt")
					));

			repository.findAll(spec).forEach(System.out::println);

			};


//			Video video = Video.builder()
//					.name("abc")
//					.length(6).build();
//			videoRepository.save(video);

		//update author a set a.get = 22 where a.id = 1

		};

	}
