package no.usn.kino.kino;

import org.springframework.boot.SpringApplication;

public class TestKinoApplication {

	public static void main(String[] args) {
		SpringApplication.from(KinoApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
